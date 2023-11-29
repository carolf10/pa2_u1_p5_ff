package com.uce.edu.transferencia.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaSeviceImpl implements ICuentaBancariaService {
	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository;

	@Override
	public CuentaBancaria buscar(String numero) {
		// TODO Auto-generated method stub
		return this.iCuentaBancariaRepository.seleccionar(numero);
	}

	@Override
	public void guardar(CuentaBancaria cuentaBancaria) {
		this.iCuentaBancariaRepository.insertar(cuentaBancaria);
		;

	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.iCuentaBancariaRepository.actualizar(cuentaBancaria);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.iCuentaBancariaRepository.eliminar(numero);
	}


	@Override
	public void depositar(String numeroOrigen, BigDecimal monto) {
		BigDecimal descuento = new BigDecimal(0.1);
		BigDecimal restar = monto.multiply(descuento);
		BigDecimal montoFinal = monto.subtract(restar);
		CuentaBancaria ctaTemp= this.buscar(numeroOrigen);
		BigDecimal saldo = ctaTemp.getSaldo();
		BigDecimal nuevoSal = saldo.add(montoFinal);
		ctaTemp.setSaldo(nuevoSal);
		actualizar(ctaTemp);
		
	}

}
