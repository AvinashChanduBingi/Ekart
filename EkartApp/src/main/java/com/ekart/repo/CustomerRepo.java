package com.ekart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ekart.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
