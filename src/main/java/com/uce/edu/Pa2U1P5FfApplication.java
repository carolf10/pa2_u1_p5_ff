package com.uce.edu;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;
import com.uce.edu.transferencia.service.ICuentaBancariaService;
import com.uce.edu.transferencia.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U1P5FfApplication implements CommandLineRunner {
	
	@Autowired
	private ITransferenciaService iTransferenciaService;
	@Autowired
	private ICuentaBancariaService iCuentaBancariaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5FfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//1. Crear las cuentas
		CuentaBancaria ctaOrigen = new CuentaBancaria();
		ctaOrigen.setCedulaPropietario("1753341344");
		ctaOrigen.setNumero("1234");
		ctaOrigen.setSaldo(new BigDecimal(100));
		this.iCuentaBancariaService.guardar(ctaOrigen);
		
		CuentaBancaria ctaDestino = new CuentaBancaria();
		ctaDestino.setCedulaPropietario("1753341333");
		ctaDestino.setNumero("5678");
		ctaDestino.setSaldo(new BigDecimal(200));
		this.iCuentaBancariaService.guardar(ctaDestino);
		
		this.iTransferenciaService.realizar("1234", "5678", new BigDecimal(20));
		this.iTransferenciaService.realizar("5678","1234", new BigDecimal(50));
		this.iTransferenciaService.realizar("1234","5678", new BigDecimal(10));
		
		System.out.println("Contador");

		List<Transferencia> lista = this.iTransferenciaService.visulizarTodoList();
		for(Transferencia trans: lista) {
			System.out.println("Transferencia "+trans.toString());
		}

	}

}
