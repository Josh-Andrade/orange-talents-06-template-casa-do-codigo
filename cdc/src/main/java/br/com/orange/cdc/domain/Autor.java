package br.com.orange.cdc.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String nome;
	private String descricao;
	private LocalDateTime horaCadastro = LocalDateTime.now();
	
	@Deprecated
	public Autor() {
		
	}

	public Autor(String email, String nome, String descricao) {
		this.email = email;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	
}
