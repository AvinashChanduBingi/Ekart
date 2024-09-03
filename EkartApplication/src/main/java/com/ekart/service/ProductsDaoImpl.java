package com.ekart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ekart.model.Products;
import com.ekart.repo.ProductRepo;

@Service
public class ProductsDaoImpl implements ProductsDao {
	private ProductRepo repo;

	public ProductsDaoImpl(ProductRepo repo)
	{
		this.repo = repo;
	}
	
	
	@Override
	public List<Products> getAllProducts() {
		List<Products> products = repo.findAll();
		return products;
	}


	@Override
	public Products getProductsById(Integer id) {
		return repo.findById(id).orElse(new Products());
	}


	@Override
	public String saveProduct(Products Products) {
		try
		{
			Products product = repo.save(Products);
			return "success";
		}
		catch(Exception e)
		{
			return e.getLocalizedMessage();
		}
		
	}


	@Override
	public String updateProduct(Products Products) {
		
		try
		{
			Products product = repo.save(Products);
			return "success";
		}
		catch(Exception e)
		{
			return e.getLocalizedMessage();
		}
	}


	@Override
	public String deleteProduct(Integer id) {
		try
		{
			Optional<Products> product = repo.findById(id);
			repo.deleteById(id);
			if(product.isEmpty())
			{
				throw new Exception("no id found");
			}
			return "success";
		}
		catch(Exception e)
		{
			return e.getLocalizedMessage();
		}
		
	}
}
