package com.ekart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekart.model.Products;

@Repository
public interface ProductRepo extends JpaRepository<Products, Integer> {

}
