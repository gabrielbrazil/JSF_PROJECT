package com.java.gabriel.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.java.gabriel.model.Product;

@Repository("productDAO")
public class ProductImpl implements ProductDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void save(Product product) {
		this.entityManager.persist(product);
	}
	

}
