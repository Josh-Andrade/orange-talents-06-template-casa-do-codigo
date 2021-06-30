package br.com.orange.cdc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import br.com.orange.cdc.config.validation.ValorUnico;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	@NotBlank
	@ValorUnico(campo = "nome", entity = "Pais", message = "País já foi cadastrado")
	private String nome;
	
	@Deprecated
	public Pais() {
		
	}

	public Pais(@NotBlank String nome) {
		this.nome = nome;
	}

}
