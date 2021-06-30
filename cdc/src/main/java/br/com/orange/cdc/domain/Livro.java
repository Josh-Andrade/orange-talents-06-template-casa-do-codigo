package br.com.orange.cdc.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.orange.cdc.config.validation.DataFutura;
import br.com.orange.cdc.config.validation.ValorUnico;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@ValorUnico(campo = "titulo", entity = "Livro", message = "Titulo já existe")
	@Column(nullable = false)
	private String titulo;

	@NotBlank
	@Size(max = 500)
	@Column(length = 500, nullable = false)
	private String resumo;

	@NotBlank
	@Column(nullable = false, columnDefinition = "TEXT")
	private String sumario;

	@Min(value = 20)
	@NotNull
	@Column(nullable = false)
	private Double preco;

	@Min(value = 100)
	@NotNull
	@Column(nullable = false)
	private Integer numeroPaginas;

	@NotBlank
	@ValorUnico(campo = "isbn", entity = "Livro", message = "Isbn já existe")
	@Length(max = 13, min = 13, message = "O ISBN deve ter no minimo 13 dígitos e não mais do que isso")
	@Column(length = 13, nullable = false)
	private String isbn;

	@DataFutura
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	@Column(nullable = false)
	private LocalDate dataPublicacao;

	@NotNull
	@ManyToOne
	private Categoria categoria;

	@NotNull
	@ManyToOne
	private Autor autor;

	@Deprecated
	public Livro() {

	}

	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@Min(20) @NotNull Double preco, @Min(100) @NotNull Integer numeroPaginas, @NotBlank String isbn,
			LocalDate dataPublicacao, @NotNull Categoria categoria, @NotNull Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

}
