package br.com.orange.cdc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import br.com.orange.cdc.config.validation.ValorUnico;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(unique = true, nullable = false)
	@ValorUnico(message = "Categoria já cadastrada", campo = "nome", entity = "Categoria")
	private String nome;

	@Deprecated
	public Categoria() {

	}
	
	public Categoria(@NotBlank String nome) {
		this.nome = nome;
	}

}
