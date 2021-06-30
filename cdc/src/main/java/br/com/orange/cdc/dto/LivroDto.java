package br.com.orange.cdc.dto;

import br.com.orange.cdc.projecao.LivroProjecao;

public class LivroDto {

	private Long id;
	private String titulo;

	public LivroDto(LivroProjecao livroProjecao) {
		this.id = livroProjecao.getId();
		this.titulo = livroProjecao.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

}
