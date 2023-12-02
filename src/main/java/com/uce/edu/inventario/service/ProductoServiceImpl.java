package com.uce.edu.inventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.inventario.repository.IProductoRepository;
import com.uce.edu.inventario.repository.modelo.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private IProductoRepository iProductoRepository;

	@Override
	public Producto buscar(String codigo) {
		// TODO Auto-generated method stub
		return iProductoRepository.seleccionar(codigo);
	}

	@Override
	public void guardar(Producto producto) {
		this.iProductoRepository.insertar(producto);
		
	}

	@Override
	public void actualizar(Producto producto) {
		this.iProductoRepository.actualizar(producto);
		
	}

	@Override
	public void eliminar(String codigo) {
		this.iProductoRepository.eliminar(codigo);
		
	}

}
