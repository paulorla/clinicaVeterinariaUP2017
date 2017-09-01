package com.up.clinicaveterinaria.mb;

public class NavegacaoMB {

	public static final String VAI_PARA_INDEX = "index";
	public static final String VAI_PARA_CADASTRO_ANIMAIS = "cadastroAnimais";

	public String getVaiParaIndex() {// um get para ser acessível a partir das páginas xhtml. Não deve ser estático
		return VAI_PARA_INDEX;
	}

	public String getVaiParaCadastroAnimais() {
		return VAI_PARA_CADASTRO_ANIMAIS;
	}
}