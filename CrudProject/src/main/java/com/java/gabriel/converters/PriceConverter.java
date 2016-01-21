package com.java.gabriel.converters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "priceConverter")
public class PriceConverter implements Converter {

	private final String priceValidator = "\\d{0,1}[\\.,]?\\d{0,3}[\\.,]?\\d{1,3}[\\.,]\\d{2}";

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		String price = value.toString();
		String priceFormated = price.replace("R$", "");

		Pattern pattern = Pattern.compile(priceValidator);
		Matcher matcher = pattern.matcher(priceFormated);

		if (!matcher.matches()) {
			((UIInput) component).setValid(false);

			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "invalid price",
					"invalid price");
			context.addMessage(component.getClientId(), message);
		}

		if (priceFormated.length() > 6) {
			priceFormated = priceFormated.replace(".", "").replace(",", ".");
		} else {
			priceFormated = priceFormated.replace(",", ".");
		}

		return priceFormated;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return value.toString();
	}

}
