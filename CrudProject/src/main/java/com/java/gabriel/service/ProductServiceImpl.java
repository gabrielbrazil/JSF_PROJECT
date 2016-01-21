package com.java.gabriel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.gabriel.dao.ProductDAO;
import com.java.gabriel.model.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	
	@Transactional
	@Override
	public void save(Product product) {
		this.productDAO.save(product);
	}


	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	

}
