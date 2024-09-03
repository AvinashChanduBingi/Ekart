package com.ekart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.model.Customer;
import com.ekart.repo.CustomerRepo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/customer")
public class Customercontroller {
	
	private CustomerRepo repo;
	
	@Autowired
	private Customercontroller(CustomerRepo repo)
	{
		this.repo = repo;
	}
	
	@GetMapping("/{id}")
	public Optional<Customer> getMethodName(@PathVariable Integer id) {
		return  repo.findById(id);
	}
	

}
