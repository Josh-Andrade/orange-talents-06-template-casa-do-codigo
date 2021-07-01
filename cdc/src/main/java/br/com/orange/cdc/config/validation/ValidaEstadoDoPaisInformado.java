package br.com.orange.cdc.config.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.orange.cdc.domain.Estado;
import br.com.orange.cdc.form.FormNovoCliente;
import br.com.orange.cdc.repository.EstadoRepository;

@Component
public class ValidaEstadoDoPaisInformado implements Validator {

	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return FormNovoCliente.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		FormNovoCliente formNovoCliente = (FormNovoCliente) target;
		if (errors.hasErrors() || formNovoCliente.getIdEstado() == null) {
			return;
		}

		Optional<Estado> estadoOptional = estadoRepository.verificaEstadoPertencePais(formNovoCliente.getIdEstado(), formNovoCliente.getIdPais());

		if (!estadoOptional.isPresent()) {
			errors.rejectValue("idEstado", "400", "O estado informado não pertence ao pais informado");
		}

	}

}
