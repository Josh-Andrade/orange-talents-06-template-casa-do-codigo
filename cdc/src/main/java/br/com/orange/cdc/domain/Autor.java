package br.com.orange.cdc.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Autor {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	@Size(max = 400)
	private String descricao;
	private LocalDateTime horaCadastro = LocalDateTime.now();
	
	@Deprecated
	public Autor() {
		
	}

	public Autor(@NotBlank @Email String email, @NotBlank String nome, @NotBlank @Size(max = 400) String descricao) {
		this.email = email;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	
}
