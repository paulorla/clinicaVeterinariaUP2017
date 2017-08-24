package com.up.clinicaveterinaria.mb;

import java.util.Date;

import com.up.clinicaveterinaria.model.Funcionario;
import com.up.clinicaveterinaria.model.TipoFuncionario;
import com.up.clinicaveterinaria.util.JSFMessageUtil;

public class LoginMB {
	
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

	public void login() {
		try{
			if(cpf == 1) {//loga somente se digitarmos 1
				Funcionario f = new Funcionario();
				f.setCpf(cpf); // esse funcionário não existe no banco! Esse é somente um teste
				f.setDataAdmissao(new Date());
				f.setId(1L);
				f.setNascimento(new Date());
				f.setNome("Funcionário teste");
				f.setTipoFuncionario(new TipoFuncionario());
	
				userMB.setFuncionario(f);
			}else {
				JSFMessageUtil.sendWarningMessageToUser("Dados incorretos!");
			}
		}catch(Exception e){
			e.printStackTrace();//LOGAR!
			JSFMessageUtil.sendWarningMessageToUser("Ocorreu um erro na aplicação!");
		}
	}
}