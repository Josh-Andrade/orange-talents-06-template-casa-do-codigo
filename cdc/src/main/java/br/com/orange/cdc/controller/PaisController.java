package br.com.orange.cdc.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orange.cdc.form.FormNovoPais;
import br.com.orange.cdc.repository.PaisRepository;

@RestController
@RequestMapping(value = "/pais")
public class PaisController {

	private PaisRepository paisRepository;

	public PaisController(PaisRepository paisRepository) {
		this.paisRepository = paisRepository;
	}

	@PostMapping
	public ResponseEntity<?> cadastrarPais(@RequestBody @Valid FormNovoPais formNovoPais) {
		paisRepository.save(formNovoPais.converterToEntityPais());
		return ResponseEntity.ok().build();
	}
}
