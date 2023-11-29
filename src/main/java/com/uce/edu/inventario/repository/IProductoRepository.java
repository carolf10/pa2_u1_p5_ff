package com.uce.edu.inventario.repository;

import com.uce.edu.inventario.repository.modelo.Producto;

public interface IProductoRepository {
	public Producto seleccionar(String codigo);

	public void insertar(Producto producto);

	public void actualizar(Producto producto);

	public void eliminar(String codigo);

}
