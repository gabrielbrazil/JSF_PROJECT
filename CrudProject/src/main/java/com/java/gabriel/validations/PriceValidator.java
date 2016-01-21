package com.java.gabriel.validations;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class PriceValidator implements Validator {

	private final String priceValidator = "\\d{1,10}\\.\\d{2}";

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		String price = value.toString();
		BigDecimal priceToValidate = new BigDecimal(price);

		Pattern pattern = Pattern.compile(priceValidator);
		Matcher matcher = pattern.matcher(price);

		if ((priceToValidate.compareTo(new BigDecimal(0.01)) == -1)
				|| (!matcher.matches())) {
			((UIInput) component).setValid(false);
		}

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"invalid price", "invalid price");
		context.addMessage(component.getClientId(), message);

	}

}
