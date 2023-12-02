package com.uce.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.inventario.repository.modelo.Bodega;

@Repository
public class BodegaRepositoryImpl implements IBodegaRepository {
	
	private static List<Bodega> base =new ArrayList<Bodega>();


	@Override
	public Bodega seleccionar(String codigoBarras) {
		for(Bodega bodega:base) {
			if(bodega.getCodigo().equals(codigoBarras)) {
				Bodega bodegaNueva = new Bodega();
				bodegaNueva.setCapacidad(bodega.getCapacidad());
				bodegaNueva.setCodigo(bodega.getCodigo());
				bodegaNueva.setDireccion(bodega.getDireccion());
				bodegaNueva.setNombre(bodega.getNombre());
				return bodegaNueva;
			}
		}
		return null;
	}
	
	public Bodega seleccionarEliminar(String codigo) {
		for(Bodega cuenta:base) {
			if(cuenta.getCodigo().equals(codigo)) {
				return cuenta;
			}
		}
		return null;
	}

	@Override
	public void insertar(Bodega bodega) {
		base.add(bodega);
	}

	@Override
	public void actualizar(Bodega bodega) {
		this.eliminar(bodega.getCodigo());
		this.insertar(bodega);
		
	}

	@Override
	public void eliminar(String codigoBarras) {
		Bodega bodega = this.seleccionarEliminar(codigoBarras);
		base.remove(bodega);		
	}

}
