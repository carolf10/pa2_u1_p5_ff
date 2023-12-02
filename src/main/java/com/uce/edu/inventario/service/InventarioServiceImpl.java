package com.uce.edu.inventario.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.inventario.repository.IBodegaRepository;
import com.uce.edu.inventario.repository.IInventarioRepository;
import com.uce.edu.inventario.repository.IProductoRepository;
import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Inventario;
import com.uce.edu.inventario.repository.modelo.Producto;

@Service
public class InventarioServiceImpl implements IInventarioService{
	
	@Autowired
	private IBodegaRepository iBodegaRepository;
	
	@Autowired
	private IInventarioRepository iInventarioRepository;
	
	@Autowired
	private IProductoRepository iProductoRepository;

	@Override
	public Inventario buscar(String codigo) {
		// TODO Auto-generated method stub
		return iInventarioRepository.seleccionar(codigo);
	}

	@Override
	public void guardar(Inventario inventario) {
		this.iInventarioRepository.insertar(inventario);
		
	}

	@Override
	public void actualizar(Inventario inventario) {
		this.iInventarioRepository.actualizar(inventario);
		
	}

	@Override
	public void eliminar(String codigo) {
		this.iInventarioRepository.eliminar(codigo);
		
	}

	@Override
	public void registrar(String codigoBodega, String codigpBarras, Integer stock) {
		Bodega bodega= this.iBodegaRepository.seleccionar(codigoBodega);
		
		Producto producto= this.iProductoRepository.seleccionar(codigpBarras);
		Integer stockActual = producto.getStock();
		Integer stockFinal = stockActual + stock;
		producto.setStock(stockFinal);
		this.iProductoRepository.actualizar(producto);
		
		Inventario inv = new Inventario();
		inv.setCodigo("23423423");
		inv.setFechaIngreso(LocalDateTime.now());
		inv.setBodega(bodega);
		inv.setProducto(producto);
		
		this.iInventarioRepository.insertar(inv);
		
	}

}
