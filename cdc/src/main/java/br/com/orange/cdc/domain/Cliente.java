package br.com.orange.cdc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.orange.cdc.config.validation.ValidCpfCnpj;
import br.com.orange.cdc.config.validation.ValorUnico;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ValidCpfCnpj(message = "Cpf ou Cnpj invalido")
	@NotBlank
	@ValorUnico(message = "Cpf ou Cpnj já cadastrado", campo = "documento", entity = "Cliente")
	private String documento;

	@NotBlank
	@Email
	@Column(unique = true, nullable = false)
	@ValorUnico(message = "Email já cadastrado", campo = "email", entity = "Cliente")
	private String email;

	@NotBlank
	@Column(nullable = false)
	private String nome;

	@NotBlank
	@Column(nullable = false)
	private String sobrenome;

	@NotBlank
	@Column(nullable = false)
	private String endereco;

	@NotBlank
	@Column(nullable = false)
	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull
	@ManyToOne
	private Pais pais;

	@ManyToOne
	private Estado estado;
	@NotBlank
	@Column(nullable = false)
	private String telefone;

	@NotBlank
	@Column(nullable = false)
	private String cep;

	@Deprecated
	public Cliente() {
	}

	public Cliente(@NotBlank String documento, @NotBlank @Email String email, @NotBlank String nome,
			@NotBlank String sobrenome, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Pais pais, @NotBlank String telefone, @NotBlank String cep) {
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.telefone = telefone;
		this.cep = cep;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}
	
	

}
