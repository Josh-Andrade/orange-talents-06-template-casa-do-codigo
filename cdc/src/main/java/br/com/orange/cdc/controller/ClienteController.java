package br.com.orange.cdc.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orange.cdc.config.validation.ValidaEstadoDoPaisInformado;
import br.com.orange.cdc.config.validation.ValidaPaisSemEstado;
import br.com.orange.cdc.domain.Cliente;
import br.com.orange.cdc.form.FormNovoCliente;
import br.com.orange.cdc.repository.ClienteRepository;
import br.com.orange.cdc.repository.EstadoRepository;
import br.com.orange.cdc.repository.PaisRepository;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	private ClienteRepository clienteRepository;

	private PaisRepository paisRepository;

	private EstadoRepository estadoRepository;

	private ValidaEstadoDoPaisInformado validaEstadoDoPaisInformado;

	private ValidaPaisSemEstado validaPaisSemEstado;

	public ClienteController(ClienteRepository clienteRepository, PaisRepository paisRepository,
			EstadoRepository estadoRepository, ValidaEstadoDoPaisInformado validaEstadoDoPaisInformado,
			ValidaPaisSemEstado validaPaisSemEstado) {
		this.clienteRepository = clienteRepository;
		this.paisRepository = paisRepository;
		this.estadoRepository = estadoRepository;
		this.validaEstadoDoPaisInformado = validaEstadoDoPaisInformado;
		this.validaPaisSemEstado = validaPaisSemEstado;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(validaEstadoDoPaisInformado, validaPaisSemEstado);
	}

	@PostMapping
	public ResponseEntity<Long> cadastrarNovoCliente(@Valid @RequestBody FormNovoCliente formNovoCliente) {
		Cliente cliente = clienteRepository.save(
				formNovoCliente.converterFormToEntityCliente(clienteRepository, paisRepository, estadoRepository));
		return ResponseEntity.ok(cliente.getId());
	}

}
