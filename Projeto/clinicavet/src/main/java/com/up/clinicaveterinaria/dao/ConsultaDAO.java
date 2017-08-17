package com.up.clinicaveterinaria.dao;

import com.up.clinicaveterinaria.model.Consulta;
import com.up.clinicaveterinaria.model.ConsultaId;

public class ConsultaDAO extends GenericDAO<ConsultaId, Consulta>{
	public ConsultaDAO() {
		super(Consulta.class);
	}
}