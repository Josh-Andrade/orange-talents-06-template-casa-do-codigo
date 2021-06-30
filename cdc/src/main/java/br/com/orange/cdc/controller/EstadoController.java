package br.com.orange.cdc.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orange.cdc.config.validation.ValidaEstadoPorPais;
import br.com.orange.cdc.form.FormNovoEstado;
import br.com.orange.cdc.repository.EstadoRepository;
import br.com.orange.cdc.repository.PaisRepository;

@RestController
@RequestMapping(value = "/estado")
public class EstadoController {

	private EstadoRepository estadoRepository;

	private PaisRepository paisRepository;
	
	private ValidaEstadoPorPais validaEstadoPorPais;

	public EstadoController(EstadoRepository estadoRepository, PaisRepository paisRepository, ValidaEstadoPorPais validaEstadoPorPais) {
		this.estadoRepository = estadoRepository;
		this.paisRepository = paisRepository;
		this.validaEstadoPorPais = validaEstadoPorPais;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(validaEstadoPorPais);
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrarNovoEstado(@RequestBody @Valid FormNovoEstado formNovoEstado) {
		estadoRepository.save(formNovoEstado.converterToEntityEstado(paisRepository));
		return ResponseEntity.ok().build();
	}
}
