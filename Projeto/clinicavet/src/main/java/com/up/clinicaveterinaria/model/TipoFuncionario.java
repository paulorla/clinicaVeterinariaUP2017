package com.up.clinicaveterinaria.model;

public class TipoFuncionario {
	private String codigoTipo;
	private String descricao;
	
	public String getCodigoTipo() {
		return codigoTipo;
	}
	
	public void setCodigoTipo(String codigoTipo) {
		this.codigoTipo = codigoTipo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoTipo == null) ? 0 : codigoTipo.hashCode());
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
		TipoFuncionario other = (TipoFuncionario) obj;
		if (codigoTipo == null) {
			if (other.codigoTipo != null)
				return false;
		} else if (!codigoTipo.equals(other.codigoTipo))
			return false;
		return true;
	}
}