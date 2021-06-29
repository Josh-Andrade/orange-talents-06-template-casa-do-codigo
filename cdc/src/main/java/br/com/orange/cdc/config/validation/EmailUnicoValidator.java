package br.com.orange.cdc.config.validation;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.orange.cdc.domain.Autor;
import br.com.orange.cdc.form.FormNovoAutor;
import br.com.orange.cdc.repository.AutorRepository;

@Component
public class EmailUnicoValidator implements Validator{

	
	private AutorRepository autorRepository;
	
	public EmailUnicoValidator(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return FormNovoAutor.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}

		FormNovoAutor formAutor = (FormNovoAutor) target;
		Optional<Autor> optionalAutor = autorRepository.findByEmail(formAutor.getEmail());
		
		if(optionalAutor.isPresent()) {
			errors.rejectValue("Email", "400", "esse email já foi cadastrado: " + formAutor.getEmail());
		}
	}
}
