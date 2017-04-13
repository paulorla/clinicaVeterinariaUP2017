package com.up.clinicaveterinaria.model;

import java.util.Date;

public class VacinaAnimal {
	private Animal animal;
	private Vacina vacina;
	private Date dataVacinacao;
	private String descricaoVeterinario;
	
	public Animal getAnimal() {
		return animal;
	}
	
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	public Vacina getVacina() {
		return vacina;
	}
	
	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}
	
	public Date getDataVacinacao() {
		return dataVacinacao;
	}
	
	public void setDataVacinacao(Date dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}
	
	public String getDescricaoVeterinario() {
		return descricaoVeterinario;
	}
	
	public void setDescricaoVeterinario(String descricaoVeterinario) {
		this.descricaoVeterinario = descricaoVeterinario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animal == null) ? 0 : animal.hashCode());
		result = prime * result + ((dataVacinacao == null) ? 0 : dataVacinacao.hashCode());
		result = prime * result + ((vacina == null) ? 0 : vacina.hashCode());
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
		VacinaAnimal other = (VacinaAnimal) obj;
		if (animal == null) {
			if (other.animal != null)
				return false;
		} else if (!animal.equals(other.animal))
			return false;
		if (dataVacinacao == null) {
			if (other.dataVacinacao != null)
				return false;
		} else if (!dataVacinacao.equals(other.dataVacinacao))
			return false;
		if (vacina == null) {
			if (other.vacina != null)
				return false;
		} else if (!vacina.equals(other.vacina))
			return false;
		return true;
	}
}
