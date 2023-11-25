package com.uce.edu.transferencia.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.ITransferenciaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {
	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository;

	@Override
	public Transferencia buscar(String numero) {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.seleccionar(numero);
	}

	@Override
	public void guardar(Transferencia transferencia) {
		this.iTransferenciaRepository.insertar(transferencia);

	}

	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.actualizar(transferencia);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.eliminar(numero);
	}

	@Override
	public void realizar(String numeroOrigen, String numeroDestinp, BigDecimal monto) {
		// TODO Auto-generated method stub
		//1. Buscar Cta Origen 
		CuentaBancaria cuentaOrigen=this.iCuentaBancariaRepository.seleccionar(numeroOrigen);
		//2. Consultar el saldo
		BigDecimal salBigDecimal = cuentaOrigen.getSaldo();
		//3. Validar Saldo
		if(salBigDecimal.compareTo(monto) >= 0) {
			//4. Restar el monto
			BigDecimal nuevoSaldoOrigen = salBigDecimal.subtract(monto);
			//5. Actualizar Cta Origen
			cuentaOrigen.setSaldo(nuevoSaldoOrigen);
			this.iCuentaBancariaRepository.actualizar(cuentaOrigen);
			//6. Buscar Cta Destino
			CuentaBancaria ctaDestino = this.iCuentaBancariaRepository.seleccionar(numeroDestinp);
			//7. Consultar Saldo
			BigDecimal saldoDestino = ctaDestino.getSaldo();
			//8. Sumar el monto
			BigDecimal nuevoSaldoDestino = saldoDestino.add(monto);
			//9. Actualizar Cta Destino
			ctaDestino.setSaldo(nuevoSaldoDestino);
			this.iCuentaBancariaRepository.actualizar(ctaDestino);
		
			//10. Crear Transferencia
			Transferencia transferencia = new Transferencia();
			transferencia.setCuentaOrigen(cuentaOrigen);
			transferencia.setCuentaDestino(ctaDestino);
			transferencia.setFecha(LocalDateTime.now());
			transferencia.setMonto(monto);
			transferencia.setNumero("12312313");
			
			this.iTransferenciaRepository.insertar(transferencia);
			System.out.println("Transferencia realizada con Exito!");
			
		} else {
			System.out.println("Saldo no disponible");
		}
		
		
	}

}
