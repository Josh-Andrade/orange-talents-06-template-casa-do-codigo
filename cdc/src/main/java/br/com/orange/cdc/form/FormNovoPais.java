package br.com.orange.cdc.form;

import javax.validation.constraints.NotBlank;

import br.com.orange.cdc.config.validation.ValorUnico;
import br.com.orange.cdc.domain.Pais;

public class FormNovoPais {

	@NotBlank
	@ValorUnico(campo = "nome", entity = "Pais", message = "País já foi cadastrado")
	private String nome;

	public FormNovoPais() {
	}
	
	public FormNovoPais(@NotBlank String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Pais converterToEntityPais() {
		return new Pais(nome);
	}
}
