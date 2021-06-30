package br.com.orange.cdc.config.validation;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DataFuturaImpl implements ConstraintValidator<DataFutura, LocalDate> {

	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataRecebida = value;

		if (dataRecebida.isAfter(dataAtual)) {
			return true;
		}
		return false;
	}

}
