package br.com.orange.cdc.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orange.cdc.config.validation.CategoriaUnicaValidator;
import br.com.orange.cdc.form.FormNovaCategoria;
import br.com.orange.cdc.repository.CategoriaRepository;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {
	
	private CategoriaRepository categoriaRepository;
	private CategoriaUnicaValidator categoriaUnicaValidator;
	
	public CategoriaController(CategoriaRepository categoriaRepository, CategoriaUnicaValidator categoriaUnicaValidator) {
		this.categoriaRepository = categoriaRepository;
		this.categoriaUnicaValidator = categoriaUnicaValidator;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(categoriaUnicaValidator);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrarNovaCategoria(@Valid @RequestBody FormNovaCategoria formNovaCategoria){
		categoriaRepository.save(formNovaCategoria.converterToEntidadeCategoria());		
		return ResponseEntity.ok().build();
	}
	
}
