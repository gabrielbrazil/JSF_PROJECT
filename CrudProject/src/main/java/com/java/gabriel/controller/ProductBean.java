package com.java.gabriel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.java.gabriel.model.Product;
import com.java.gabriel.service.ProductService;

@Controller
@Scope("request")
public class ProductBean {
	
	@Autowired
	private ProductService productService;
	
	private Product product;
	private String message;
	
	public String productForm(){
		product = new Product();
		return "/pages/product/form";
	}

	public String salvar(){
		this.productService.save(product);
		message = "Success Save";
		return "/pages/product/home";
	}
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Product getProduct() {
		if(this.product == null){
			this.product = new Product();
		}
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	

}
