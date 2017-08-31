package com.up.clinicaveterinaria.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.up.clinicaveterinaria.model.Funcionario;

public class FuncionarioDAO extends GenericDAO<Long, Funcionario>{

	public FuncionarioDAO() {
		super(Funcionario.class);
	}
	
	public Funcionario findByCPF(Long cpf) {
		Query query = super.getEntityManager().createNamedQuery("Funcionario.findBycpf");
		query.setParameter("cpf", cpf);
		try {
			Funcionario retorno = (Funcionario) query.getSingleResult();
			return retorno;
		}catch (NoResultException ex) {
			return null;
		}
	}
}