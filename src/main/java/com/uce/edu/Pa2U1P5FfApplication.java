package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.inventario.repository.IInventarioRepository;
import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Inventario;
import com.uce.edu.inventario.repository.modelo.Producto;
import com.uce.edu.inventario.service.IBodegaService;
import com.uce.edu.inventario.service.IInventarioService;
import com.uce.edu.inventario.service.IProductoService;

@SpringBootApplication
public class Pa2U1P5FfApplication implements CommandLineRunner {
	
	@Autowired //por atributo
	private IProductoService iProductoService;
	
	@Autowired
	private IBodegaService iBodegaService;
	
	@Autowired
	private IInventarioService iInventarioService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5FfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Producto p1 = new Producto();
		p1.setCodigoBarras("123456");
		p1.setNombre("HP 15 laptop");
		p1.setStock(0);
		
		this.iProductoService.guardar(p1);
		
		Producto p2 = new Producto();
		p2.setCodigoBarras("546515646");
		p2.setNombre("Teclado HP ");
		p2.setStock(0);
		
		this.iProductoService.guardar(p2);
		
		Bodega b1 = new Bodega();
		b1.setCapacidad(12);
		b1.setCodigo("232366");
		b1.setDireccion("Sector Alma Lojana");
		b1.setNombre("Bodega 1");
		
		this.iBodegaService.guardar(b1);
		
		this.iInventarioService.registrar("232366", "123456", 50);
		this.iInventarioService.registrar("232366", "546515646", 100);
		this.iInventarioService.registrar("232366", "123456", 20);
		
		System.out.println(this.iProductoService.buscar("123456"));
		System.out.println(this.iProductoService.buscar("546515646"));
		
	}

}
