package br.com.orange.cdc.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orange.cdc.form.FormNovoAutor;
import br.com.orange.cdc.repository.AutorRepository;

@RestController
@RequestMapping(value = "/autor")
public class AutorController {
	
	private AutorRepository autorRepository;
	
	public AutorController(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	@PostMapping
	public ResponseEntity<?> cadastroNovoAutor(@Valid @RequestBody FormNovoAutor formNovoAutor){
		autorRepository.save(formNovoAutor.converterToEntidadeAutor());		
		return ResponseEntity.ok().build();
	}
}
