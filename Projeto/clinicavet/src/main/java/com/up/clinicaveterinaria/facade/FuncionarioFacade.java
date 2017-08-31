package com.up.clinicaveterinaria.facade;

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
}