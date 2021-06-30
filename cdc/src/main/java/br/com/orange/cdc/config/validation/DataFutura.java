package br.com.orange.cdc.config.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = DataFuturaImpl.class)
public @interface DataFutura {

	String message() default "A data precisa ser maior do que a atual";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
