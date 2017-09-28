package com.up.clinicaveterinaria.mb;

import java.util.List;

import com.up.clinicaveterinaria.facade.FuncionarioFacade;
import com.up.clinicaveterinaria.model.Funcionario;

public class ConsultasMB {
	
	private List<Funcionario> veterinarios;
	private Funcionario veterinarioSelecionado;
	
	public ConsultasMB() {
		try {
			veterinarioSelecionado = null;
			veterinarios = (new FuncionarioFacade()).listarVeterinarios();
		}catch(Exception e) {
			e.printStackTrace();//logar
		}
	}

	public Funcionario getVeterinarioSelecionado() {
		return veterinarioSelecionado;
	}

	public void setVeterinarioSelecionado(Funcionario veterinarioSelecionado) {
		this.veterinarioSelecionado = veterinarioSelecionado;
	}

	public List<Funcionario> getVeterinarios() {
		return veterinarios;
	}
}