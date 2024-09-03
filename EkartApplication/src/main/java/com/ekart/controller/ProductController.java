package com.ekart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.model.Products;
import com.ekart.service.ProductsDao;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductsDao service;
	
	@GetMapping
	public ResponseEntity<Object> getAllproducts() {
		List<Products> products = service.getAllProducts();
		if(products.isEmpty())
			return new ResponseEntity<Object>("No productss presesnt",HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Object>(products,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Object> getproductsById(@PathVariable Integer id) {
		Products products = service.getProductsById(id);
		if(products==null)
			return new ResponseEntity<Object>("No productss presesnt",HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Object>(products,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Object> saveproducts(@RequestBody Products products) {
		String status  = service.saveProduct(products);
		if(status.equalsIgnoreCase("success"))
			return new ResponseEntity<Object>("SuccesFully saved",HttpStatus.OK);
		else
			return new ResponseEntity<Object>(status,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@PutMapping
	public ResponseEntity<Object> updateproducts(@RequestBody Products products) {
		String status  = service.updateProduct(products);
		if(status=="success")
			return new ResponseEntity<Object>("SuccesFully Updated",HttpStatus.OK);
		else
			return new ResponseEntity<Object>(status,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteproducts(@PathVariable Integer id) {
		String status  = service.deleteProduct(id);
		if(status=="success")
			return new ResponseEntity<Object>("SuccesFully Deleted",HttpStatus.OK);
		else
			return new ResponseEntity<Object>(status,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
