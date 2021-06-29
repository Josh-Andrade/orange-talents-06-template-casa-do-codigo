package br.com.orange.cdc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orange.cdc.config.validation.EmailUnicoValidator;
import br.com.orange.cdc.form.FormNovoAutor;
import br.com.orange.cdc.repository.AutorRepository;

@RestController
@RequestMapping(value = "/autor")
public class AutorController {
	
	private AutorRepository autorRepository;
	
	private EmailUnicoValidator emailUnicoValidator;
	
	public AutorController(AutorRepository autorRepository, EmailUnicoValidator emailUnicoValidator) {
		this.autorRepository = autorRepository;
		this.emailUnicoValidator = emailUnicoValidator;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(emailUnicoValidator);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastroNovoAutor(@RequestBody @Valid FormNovoAutor formNovoAutor){
		autorRepository.save(formNovoAutor.converterToEntidadeAutor());
		return ResponseEntity.ok().build();
	}
}
