package com.up.clinicaveterinaria.facade;

import java.util.List;

import com.up.clinicaveterinaria.constants.Constants;
import com.up.clinicaveterinaria.dao.FuncionarioDAO;
import com.up.clinicaveterinaria.model.Funcionario;

public class FuncionarioFacade extends GenericFacade<Long, Funcionario, FuncionarioDAO>{

	public FuncionarioFacade() {
		super(new FuncionarioDAO());
	}
	
	public Funcionario findByCpf(Long cpf) throws Exception {
		try {
			dao.beginTransaction();
			Funcionario obj = dao.findByCPF(cpf);
			dao.commitAndCloseTransaction();
			return obj;
		} catch (Exception e) {
			if (dao.isTransactionActive())
				dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
	
	public List<Funcionario> listarVeterinarios() throws Exception {
		return listarByTipo(Constants.CODIGO_TIPO_FUNCIONARIO_VETERINARIO);
	}
	
	public List<Funcionario> listarByTipo(String strCodigoTipoFunc) throws Exception {
		try {
			dao.beginTransaction();
			List<Funcionario> lista = dao.listarByTipo(strCodigoTipoFunc);
			dao.commitAndCloseTransaction();
			return lista;
		} catch (Exception e) {
			if (dao.isTransactionActive())
				dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
}