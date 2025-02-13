package br.com.orange.cdc.config.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroValidacaoHandler {

	
	private MessageSource messageSource;
	
	public ErroValidacaoHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<FormErrorDto> handler(MethodArgumentNotValidException argumentNotValidException){
		List<FieldError> fields = argumentNotValidException.getFieldErrors();
		List<FormErrorDto> errorDto = new ArrayList<>();
		fields.stream().forEach(f -> {
			errorDto.add(new FormErrorDto(getMessage(f), f.getField()));
		});
		return errorDto;
	}
	
	public String getMessage(FieldError field) {
		return messageSource.getMessage(field, LocaleContextHolder.getLocale());
	}
}
