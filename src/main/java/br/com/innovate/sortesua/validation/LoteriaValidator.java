package br.com.innovate.sortesua.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.innovate.sortesua.models.Loteria;

public class LoteriaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return   Loteria.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required" );
        ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required" );


        Loteria  loteria = (Loteria) target;

        if(loteria.getDigitos() <= 0) {
            errors.rejectValue("digitos", "field.required");
        }

		
	}

}
