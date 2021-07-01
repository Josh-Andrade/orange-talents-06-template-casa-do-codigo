package br.com.orange.cdc.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.orange.cdc.config.validation.ValorUnico;

@Entity
public class Autor {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Email
	@Column(unique = true, nullable = false)
	@ValorUnico(message = "Email já cadastrado", campo = "email", entity = "Autor")
	private String email;
	@NotBlank
	@Column(nullable = false)
	private String nome;
	@NotBlank
	@Size(max = 400)
	@Column(length = 400, nullable = false)
	private String descricao;
	@Column(nullable = false)
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
