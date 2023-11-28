package com.uce.edu.transferencia.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.transferencia.repository.modelo.NumeracionTransferencia;

@Repository
public class NumeracionTransferenciaRepositoryImpl implements INumeracionTransferenciaRepository{

	private static List<NumeracionTransferencia> base= new ArrayList<NumeracionTransferencia>();
	
	@Override
	public NumeracionTransferencia selecionar(long numero) {
		for(NumeracionTransferencia contador : base) {
			if (contador.getContador()==numero) {
				return contador;
			}
		}
		return null;
	}

	@Override
	public void insertar(NumeracionTransferencia contadorTransferencia) {
		base.add(contadorTransferencia);
		
	}

	@Override
	public void actualizar(NumeracionTransferencia contadorTransferencia) {
		this.eliminar(contadorTransferencia.getContador());
		this.insertar(contadorTransferencia);
		
	}

	@Override
	public void eliminar(long numero) {
		NumeracionTransferencia contadorTransferencia = this.selecionar(numero);
		base.remove(contadorTransferencia);
		
	}

	@Override
	public List<NumeracionTransferencia> selecionarTodo() {
		return base;
	}
	

}
