package com.uce.edu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ioc.di.Estudiante;
import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.service.IMateriaService;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;
import com.uce.edu.transferencia.service.ICuentaBancariaService;
import com.uce.edu.transferencia.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U1P5FfApplication implements CommandLineRunner {
	
	@Autowired //por atributo
	private ITransferenciaService iTransferenciaService;
	
	/* DI por constructor
	private ITransferenciaService iTransferenciaService;
	@Autowired 
	public Pa2U1P5FfApplication(ITransferenciaService iTransferenciaService) {
		this.iTransferenciaService= iTransferenciaService;
	}*/
	
	/*DI por metodo (set)
	@Autowired
	public void setiTransferenciaService(ITransferenciaService iTransferenciaService) {
		this.iTransferenciaService = iTransferenciaService;
	}*/

	@Autowired
	private ICuentaBancariaService iCuentaBancariaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5FfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Transferencia> lista = new ArrayList<>();
		
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
		
		this.iTransferenciaService.realizar("1234", "5678", new BigDecimal(30));
		//System.out.println(ctaOrigen.hashCode());
		//System.out.println(ctaDestino.hashCode());
		
		CuentaBancaria ctaOrigen1 = this.iCuentaBancariaService.buscar("1234");
		System.out.println(ctaOrigen1);
		
		CuentaBancaria ctaDestino1 = this.iCuentaBancariaService.buscar("5678");
		System.out.println(ctaDestino1);
		
		this.iTransferenciaService.realizar("1234", "5678", new BigDecimal(50));
		this.iTransferenciaService.realizar("5678", "1234", new BigDecimal(10));
		
		//Constrir un reporte del estado de cuenta de todas las transferencias
		int indice=0;
		for(Transferencia trans: lista) {
			
			indice++;
			System.out.println(indice + " : " + trans.toString());
		}

		
	}

}
