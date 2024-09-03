package com.ekart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ekart.model.Products;

@Service
public interface ProductsDao {

	List<Products> getAllProducts();
	Products getProductsById(Integer id);
	String saveProduct(Products Products);
	String updateProduct(Products Products);
	String deleteProduct(Integer id);
}
