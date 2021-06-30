package br.com.orange.cdc.config.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistImpl implements ConstraintValidator<Exist, Long> {

	@PersistenceContext
	private EntityManager entityManager;

	private Class<?> entity;

	@Override
	public void initialize(Exist constraintAnnotation) {
		this.entity = constraintAnnotation.entity();
	}

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		Object objeto;
		if (value == null) {
			return false;
		} else {
			objeto = entityManager.find(this.entity, value);
		}
		if (objeto == null) {
			return false;
		}
		return true;
	}

}
