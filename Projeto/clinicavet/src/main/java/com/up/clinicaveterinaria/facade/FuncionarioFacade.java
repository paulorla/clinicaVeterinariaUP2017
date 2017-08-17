package com.up.clinicaveterinaria.facade;

import com.up.clinicaveterinaria.dao.FuncionarioDAO;
import com.up.clinicaveterinaria.model.Funcionario;

public class FuncionarioFacade extends GenericFacade<Long, Funcionario, FuncionarioDAO>{

	public FuncionarioFacade() {
		super(new FuncionarioDAO());
	}
}