package com.java.gabriel.validations;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.java.gabriel.service.ProductService;


@Component
@Scope("request")
public class EmailValidation implements Validator {

	@Autowired
	private ProductService productService;
	
	
	@Override
	public void validate(FacesContext context, UIComponent toValidate, Object value) 
			throws ValidatorException {
		
		String email = value.toString();
		
		if(email.indexOf('@') == -1){
			((UIInput)toValidate).setValid(false);
		}
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Invalid Email.", "Invalid Email.");
		context.addMessage(toValidate.getClientId(context),message);
	}


	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	
	
	
	
}
