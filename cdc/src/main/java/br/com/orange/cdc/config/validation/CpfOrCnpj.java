package br.com.orange.cdc.config.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { })
@ConstraintComposition(CompositionType.OR)
@ReportAsSingleViolation
@CPF
@CNPJ
public @interface CpfOrCnpj {

	String message() default "CPF/CNPJ inválido";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
