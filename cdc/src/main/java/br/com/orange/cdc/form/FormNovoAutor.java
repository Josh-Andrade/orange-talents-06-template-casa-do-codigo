package br.com.orange.cdc.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.orange.cdc.domain.Autor;

public class FormNovoAutor {

	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	@Size(max = 400)
	private String descricao;

	public FormNovoAutor(@NotBlank @Email String email, @NotBlank String nome,
			@NotBlank @Size(max = 400) String descricao) {
		this.email = email;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Autor converterToEntidadeAutor() {
		return new Autor(email, nome, descricao);
	}

}
