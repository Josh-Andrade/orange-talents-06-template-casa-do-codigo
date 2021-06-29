package br.com.orange.cdc.config.validation;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.orange.cdc.domain.Categoria;
import br.com.orange.cdc.form.FormNovaCategoria;
import br.com.orange.cdc.repository.CategoriaRepository;

@Component
public class CategoriaUnicaValidator implements Validator{

	private CategoriaRepository categoriaRepository;
	
	public CategoriaUnicaValidator(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return FormNovaCategoria.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		FormNovaCategoria formNovaCategoria = (FormNovaCategoria) target;
		Optional<Categoria> optionalCategoria = categoriaRepository.findByNome(formNovaCategoria.getNome());
		
		if(optionalCategoria.isPresent()) {
			errors.rejectValue("Nome", null, "Categoria já foi cadastrada:" + formNovaCategoria.getNome());
		}
	}

}
