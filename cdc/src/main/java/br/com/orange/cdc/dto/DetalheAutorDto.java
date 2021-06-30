package br.com.orange.cdc.dto;

public class DetalheAutorDto {

	private String nome;
	private String descricao;

	public DetalheAutorDto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
