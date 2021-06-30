package br.com.orange.cdc.form;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import br.com.orange.cdc.config.validation.ValorUnico;
import br.com.orange.cdc.domain.Categoria;

public class FormNovaCategoria {

	@NotBlank
	@ValorUnico(message = "Categoria já cadastrada", campo = "nome", entity = "Categoria")
	private String nome;

	@Deprecated
	public FormNovaCategoria() {
	}

	@JsonCreator(mode = Mode.PROPERTIES)
	public FormNovaCategoria(@NotBlank String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Categoria converterToEntidadeCategoria() {
		return new Categoria(this.nome);
	}
}
