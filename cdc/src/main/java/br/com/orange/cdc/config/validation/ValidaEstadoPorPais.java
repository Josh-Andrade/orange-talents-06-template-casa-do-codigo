package br.com.orange.cdc.config.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.orange.cdc.domain.Estado;
import br.com.orange.cdc.form.FormNovoEstado;
import br.com.orange.cdc.repository.EstadoRepository;

@Component
public class ValidaEstadoPorPais implements Validator{

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return FormNovoEstado.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		FormNovoEstado value = (FormNovoEstado) target;
		Optional<Estado> estadoOptional = estadoRepository.verificaEstadoDisponivelPais(value.getIdPais(), "%"+value.getNome()+"%");
		
		if(estadoOptional.isPresent()) {
			errors.rejectValue("nome", "400", "Já existe um estado com esse nome cadastrado para esse país");
		}
		
	}

}
