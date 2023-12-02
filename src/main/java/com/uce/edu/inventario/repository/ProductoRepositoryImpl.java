package com.uce.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.inventario.repository.modelo.Producto;

@Repository
public class ProductoRepositoryImpl implements IProductoRepository{
	
	private static List<Producto> base =new ArrayList<Producto>();


	@Override
	public Producto seleccionar(String codigo) {
		for(Producto producto:base) {
			if(producto.getCodigoBarras().equals(codigo)) {
				Producto prodNuevo = new Producto();
				prodNuevo.setCodigoBarras(producto.getCodigoBarras());
				prodNuevo.setNombre(producto.getNombre());
				prodNuevo.setStock(producto.getStock());
				return prodNuevo;
			}
		}
		return null;
	}
	
	public Producto seleccionarEliminar(String codigo) {
		for(Producto producto:base) {
			if(producto.getCodigoBarras().equals(codigo)) {
				return producto;
			}
		}
		return null;
	}

	@Override
	public void insertar(Producto producto) {
		base.add(producto);
	}

	@Override
	public void actualizar(Producto producto) {
		this.eliminar(producto.getCodigoBarras());
		this.insertar(producto);
		
	}

	@Override
	public void eliminar(String codigo) {
		Producto producto = this.seleccionarEliminar(codigo);
		base.remove(producto);
		
	}

}
