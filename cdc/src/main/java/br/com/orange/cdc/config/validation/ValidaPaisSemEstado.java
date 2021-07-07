package br.com.orange.cdc.config.validation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.orange.cdc.domain.Estado;
import br.com.orange.cdc.form.FormNovoCliente;
import br.com.orange.cdc.repository.EstadoRepository;

@Component
public class ValidaPaisSemEstado implements Validator{

	@Autowired
	private EstadoRepository estadoRepository;
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return FormNovoCliente.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		FormNovoCliente form = (FormNovoCliente) target;
		if(errors.hasErrors()) {
			return;
		}
		
		Optional<List<Estado>> estados = estadoRepository.findByPais_Id(form.getIdPais());
		
		if(!estados.get().isEmpty()) {
			errors.rejectValue("idPais", "O estado deve ser informado para o pais");
		}
	}

}
