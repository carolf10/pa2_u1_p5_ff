package com.uce.edu.inventario.repository;

import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;

public interface IBodegaRepository {
	
	public Bodega seleccionar(String codigoBarras);

	public void insertar(Bodega bodega);

	public void actualizar(Bodega bodega);

	public void eliminar(String codigoBarras);

}
