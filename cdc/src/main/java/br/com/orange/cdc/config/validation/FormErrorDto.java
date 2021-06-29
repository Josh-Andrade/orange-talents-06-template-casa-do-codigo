package br.com.orange.cdc.config.validation;

public class FormErrorDto {

	private String mensagem;
	private String campo;

	public FormErrorDto(String mensagem, String campo) {
		this.mensagem = mensagem;
		this.campo = campo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getCampo() {
		return campo;
	}

}
