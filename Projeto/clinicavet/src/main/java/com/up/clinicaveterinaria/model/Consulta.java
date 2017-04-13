package com.up.clinicaveterinaria.model;

import java.util.Date;

import com.up.clinicaveterinaria.constants.Constants;
import com.up.clinicaveterinaria.exception.AssociacaoInvalidaException;

public class Consulta {
	private Animal animal;
	private Date dataHoraConsulta;
	private Funcionario veterinario;
	private Funcionario responsavelAgendamento;
	
	public Animal getAnimal() {
		return animal;
	}
	
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	public Date getDataHoraConsulta() {
		return dataHoraConsulta;
	}
	
	public void setDataHoraConsulta(Date dataHoraConsulta) {
		this.dataHoraConsulta = dataHoraConsulta;
	}
	
	public Funcionario getVeterinario() {
		return veterinario;
	}
	
	public void setVeterinario(Funcionario veterinario) throws AssociacaoInvalidaException {
		if(veterinario == null || veterinario.getTipoFuncionario().equals(Constants.CODIGO_TIPO_FUNCIONARIO_VETERINARIO))
			this.veterinario = veterinario;
		else
			throw new AssociacaoInvalidaException(this, veterinario);
	}
	
	public Funcionario getResponsavelAgendamento() {
		return responsavelAgendamento;
	}
	
	public void setResponsavelAgendamento(Funcionario responsavelAgendamento) {
		this.responsavelAgendamento = responsavelAgendamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animal == null) ? 0 : animal.hashCode());
		result = prime * result + ((dataHoraConsulta == null) ? 0 : dataHoraConsulta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (animal == null) {
			if (other.animal != null)
				return false;
		} else if (!animal.equals(other.animal))
			return false;
		if (dataHoraConsulta == null) {
			if (other.dataHoraConsulta != null)
				return false;
		} else if (!dataHoraConsulta.equals(other.dataHoraConsulta))
			return false;
		return true;
	}
}
