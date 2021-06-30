package br.com.orange.cdc.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orange.cdc.form.FormNovoLivro;
import br.com.orange.cdc.repository.AutorRepository;
import br.com.orange.cdc.repository.CategoriaRepository;
import br.com.orange.cdc.repository.LivroRepository;

@RestController
@RequestMapping(value = "/livro")
public class LivroController {

	private LivroRepository livroRepository;

	private AutorRepository autorRepository;

	private CategoriaRepository categoriaRepository;

	public LivroController(LivroRepository livroRepository, AutorRepository autorRepository,
			CategoriaRepository categoriaRepository) {
		this.livroRepository = livroRepository;
		this.autorRepository = autorRepository;
		this.categoriaRepository = categoriaRepository;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrarNovoLivro(@Valid @RequestBody FormNovoLivro formNovoLivro) {
		livroRepository.save(formNovoLivro.converterToEntidadeLivro(autorRepository, categoriaRepository));
		return ResponseEntity.ok().build();
	}

}
