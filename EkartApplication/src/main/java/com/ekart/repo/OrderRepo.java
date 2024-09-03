package com.ekart.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekart.model.Orders;
import com.ekart.model.User;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer> {
	

}
