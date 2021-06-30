package br.com.orange.cdc.dto;

import br.com.orange.cdc.projecao.DetalheLivroProjecao;

public class DetalheLivroDto {

	private String titulo;
	private String resumo;
	private String sumario;
	private Double preco;
	private Integer numeroPaginas;
	private String isbn;

	private DetalheAutorDto detalheAutorDto;

	private String nomeCategoria;

	public DetalheLivroDto(DetalheLivroProjecao livroProjecao) {
		this.titulo = livroProjecao.getTitulo();
		this.resumo = livroProjecao.getResumo();
		this.sumario = livroProjecao.getSumario();
		this.preco = livroProjecao.getPreco();
		this.numeroPaginas = livroProjecao.getNumeroPaginas();
		this.isbn = livroProjecao.getIsbn();
		this.detalheAutorDto = new DetalheAutorDto(livroProjecao.getNome(), livroProjecao.getDescricao());
		this.nomeCategoria = livroProjecao.getNomeCategoria();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public Double getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public DetalheAutorDto getDetalheAutorDto() {
		return detalheAutorDto;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

}
