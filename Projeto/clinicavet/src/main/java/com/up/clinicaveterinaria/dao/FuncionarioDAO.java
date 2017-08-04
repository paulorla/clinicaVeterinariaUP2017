package com.up.clinicaveterinaria.dao;

import com.up.clinicaveterinaria.model.Funcionario;

public class FuncionarioDAO extends GenericDAO<Long, Funcionario>{

	public FuncionarioDAO() {
		super(Funcionario.class);
	}
}