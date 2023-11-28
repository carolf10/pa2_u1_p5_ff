package com.uce.edu.transferencia.service;

import java.util.List;

import com.uce.edu.transferencia.repository.modelo.NumeracionTransferencia;

public interface INumeracionTransferenciaService {
	public NumeracionTransferencia buscarContador(long numero);
	public void ingresarContador(NumeracionTransferencia contadorTransferencia);
	public  void actualizarContador(NumeracionTransferencia contadorTransferencia);
	public void borrarContador(long numero);
	public String establecerContador();
	public List<NumeracionTransferencia> visulizarTodoList ();

}
