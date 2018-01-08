package br.com.innovate.sortesua.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.innovate.sortesua.models.Aposta;
import br.com.innovate.sortesua.models.Sorteio;
import br.com.innovate.sortesua.models.enums.TipoSorteioEnum;

public class ApostaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return Aposta.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Aposta aposta = (Aposta) target;
		Sorteio sorteio = aposta.getTipo();

		switch (TipoSorteioEnum.valueOf(sorteio.getTipo().getId().intValue())) {
		case MEGASENA:
			if (aposta.getDezenasSelecionadas().size()<6  || aposta.getDezenasSelecionadas().size()> 15){
				 errors.rejectValue("dezenasSelecionadas", "field.required");
			}
			break;
		case LOTOFACIL:
			if (aposta.getDezenasSelecionadas().size()<15  || aposta.getDezenasSelecionadas().size()> 18){
				 errors.rejectValue("dezenasSelecionadas", "field.required");
			}
			break;
		}
	}

}
