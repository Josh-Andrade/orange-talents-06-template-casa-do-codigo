package br.com.orange.cdc.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orange.cdc.form.FormNovaCategoria;
import br.com.orange.cdc.repository.CategoriaRepository;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

	private CategoriaRepository categoriaRepository;

	public CategoriaController(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrarNovaCategoria(@Valid @RequestBody FormNovaCategoria formNovaCategoria) {
		categoriaRepository.save(formNovaCategoria.converterToEntidadeCategoria());
		return ResponseEntity.ok().build();
	}

}
