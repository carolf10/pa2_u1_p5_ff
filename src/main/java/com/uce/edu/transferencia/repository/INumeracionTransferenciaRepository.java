package com.uce.edu.transferencia.repository;

import java.util.List;

import com.uce.edu.transferencia.repository.modelo.NumeracionTransferencia;

public interface INumeracionTransferenciaRepository {
	public NumeracionTransferencia selecionar(long numero);
	public void insertar(NumeracionTransferencia contadorTransferencia);
	public  void actualizar(NumeracionTransferencia contadorTransferencia);
	public void eliminar(long numero);
	public List<NumeracionTransferencia> selecionarTodo();

}
