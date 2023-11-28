package com.uce.edu.transferencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.INumeracionTransferenciaRepository;
import com.uce.edu.transferencia.repository.modelo.NumeracionTransferencia;

@Service
public class NumeracionTransferenciaServiceImpl implements INumeracionTransferenciaService {
	@Autowired
	private INumeracionTransferenciaRepository iNumeracionTransferenciaRepository;
	
	@Override
	public NumeracionTransferencia buscarContador(long numero) {
		// TODO Auto-generated method stub
		return this.iNumeracionTransferenciaRepository.selecionar(numero);
	}

	@Override
	public void ingresarContador(NumeracionTransferencia contadorTransferencia) {
		this.iNumeracionTransferenciaRepository.insertar(contadorTransferencia);
	}

	@Override
	public void actualizarContador(NumeracionTransferencia contadorTransferencia) {
		this.iNumeracionTransferenciaRepository.actualizar(contadorTransferencia);
	}

	@Override
	public void borrarContador(long numero) {
		this.iNumeracionTransferenciaRepository.eliminar(numero);
		
	}

	@Override
	public String establecerContador() {
		long tmp=0;
		List<NumeracionTransferencia> listTmpList = this.visulizarTodoList();
		if (listTmpList.isEmpty()) {
			NumeracionTransferencia contadorTmp = new NumeracionTransferencia();
			contadorTmp.setContador(0);
			this.iNumeracionTransferenciaRepository.insertar(contadorTmp);
			return String.valueOf(0);
		}
		else {
			NumeracionTransferencia a = listTmpList.get(listTmpList.size()-1);
			tmp = a.getContador();
			NumeracionTransferencia b = new NumeracionTransferencia();
			b.setContador(tmp+1);
			this.iNumeracionTransferenciaRepository.insertar(b);
			return String.valueOf(tmp+1);
		}
	}

	@Override
	public List<NumeracionTransferencia> visulizarTodoList() {
		// TODO Auto-generated method stub
		return this.iNumeracionTransferenciaRepository.selecionarTodo();
	}

}
