package br.com.orange.cdc.form;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.orange.cdc.config.validation.Exist;
import br.com.orange.cdc.config.validation.ValorUnico;
import br.com.orange.cdc.domain.Autor;
import br.com.orange.cdc.domain.Categoria;
import br.com.orange.cdc.domain.Livro;
import br.com.orange.cdc.repository.AutorRepository;
import br.com.orange.cdc.repository.CategoriaRepository;

public class FormNovoLivro {
	@NotBlank
	@ValorUnico(campo = "titulo", entity = "Livro", message = "Titulo já existe")
	private String titulo;

	@NotBlank
	@Size(max = 500)
	private String resumo;

	@NotBlank
	private String sumario;

	@Min(value = 20)
	@NotNull
	private Double preco;

	@Min(value = 100)
	@NotNull
	private Integer numeroPaginas;

	@NotBlank
	@ValorUnico(campo = "isbn", entity = "Livro", message = "Isbn já existe")
	@Length(max = 13, min = 13, message = "O ISBN deve ter no minimo 13 dígitos e não mais do que isso")
	private String isbn;

	@Future
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate dataPublicacao;

	@NotNull
	@Positive
	@Exist(entity = Autor.class, message = "Autor não encontrado")
	private Long idAutor;

	@NotNull
	@Positive
	@Exist(entity = Categoria.class, message = "Categoria não encontrada")
	private Long idCategoria;

	public FormNovoLivro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@Min(20) @NotNull Double preco, @Min(100) @NotNull Integer numeroPaginas, @NotBlank String isbn,
			LocalDate dataPublicacao, @NotNull @Positive Long idAutor, @NotNull @Positive Long idCategoria) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idAutor = idAutor;
		this.idCategoria = idCategoria;
	}

	public Livro converterToEntidadeLivro(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao,
				retornaCategoria(categoriaRepository), retornaAutor(autorRepository));
	}

	public Autor retornaAutor(AutorRepository autorRepository) {
		return autorRepository.findById(idAutor).get();
	}

	public Categoria retornaCategoria(CategoriaRepository categoriaRepository) {
		return categoriaRepository.findById(idCategoria).get();
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

}
