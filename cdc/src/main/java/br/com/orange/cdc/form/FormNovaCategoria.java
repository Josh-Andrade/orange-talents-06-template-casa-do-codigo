package br.com.orange.cdc.form;

import javax.validation.constraints.NotBlank;

import br.com.orange.cdc.domain.Categoria;

public class FormNovaCategoria {

	@NotBlank
	private String nome;

	@Deprecated
	public FormNovaCategoria() {
	}
	
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
