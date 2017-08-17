package com.up.clinicaveterinaria.facade;

import com.up.clinicaveterinaria.dao.ConsultaDAO;
import com.up.clinicaveterinaria.model.Consulta;
import com.up.clinicaveterinaria.model.ConsultaId;

public class ConsultaFacade extends GenericFacade<ConsultaId, Consulta,ConsultaDAO>{

	public ConsultaFacade() {
		super(new ConsultaDAO());
	}
}