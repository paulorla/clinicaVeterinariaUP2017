package com.up.clinicaveterinaria.mb;

import java.util.Date;

import com.up.clinicaveterinaria.facade.FuncionarioFacade;
import com.up.clinicaveterinaria.model.Funcionario;
import com.up.clinicaveterinaria.model.TipoFuncionario;
import com.up.clinicaveterinaria.util.JSFMessageUtil;

public class LoginMB {
	
	private FuncionarioFacade funcionarioFacade = new FuncionarioFacade();
	
	private Long cpf;
	private UserMB userMB;

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	public UserMB getUserMB() {
		return userMB;
	}

	public void setUserMB(UserMB userMB) {
		this.userMB = userMB;
	}

	public String login() {
		try{
			if(cpf != null) {
				Funcionario f = funcionarioFacade.findByCpf(cpf);
				if(f!=null) {
					userMB.setFuncionario(f);
					return "index";
				}else {
					JSFMessageUtil.sendWarningMessageToUser("Dados Incorretos!");
				}
			}else {
				JSFMessageUtil.sendWarningMessageToUser("Campos em branco!");
			}
		}catch(Exception e){
			e.printStackTrace();//LOGAR!
			JSFMessageUtil.sendWarningMessageToUser("Ocorreu um erro na aplicação!");
		}
		return null;
	}
}