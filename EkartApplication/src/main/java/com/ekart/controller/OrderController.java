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

import com.ekart.model.Orders;
import com.ekart.service.OrderDao;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/order")
public class OrderController {
	

	@Autowired
	private OrderDao service;
	
	@GetMapping
	public ResponseEntity<Object> getAllOrders() {
		List<Orders> Orders = service.getAllOrders();
		if(Orders.isEmpty())
			return new ResponseEntity<Object>("No Orderss presesnt",HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Object>(Orders,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOrdersById(@PathVariable Integer id) {
		Orders Orders = service.getOrderById(id);
		if(Orders==null)
			return new ResponseEntity<Object>("No Orders presesnt",HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Object>(Orders,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Object> saveOrders(@RequestBody Orders Orders) {
		String status  = service.saveOrder(Orders);
		if(status.equalsIgnoreCase("success"))
			return new ResponseEntity<Object>("SuccesFully saved",HttpStatus.OK);
		else
			return new ResponseEntity<Object>(status,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@PutMapping
	public ResponseEntity<Object> updateOrders(@RequestBody Orders Orders) {
		String status  = service.updateOrder(Orders);
		if(status=="success")
			return new ResponseEntity<Object>("SuccesFully Updated",HttpStatus.OK);
		else
			return new ResponseEntity<Object>(status,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteOrders(@PathVariable Integer id) {
		String status  = service.deleteOrder(id);
		if(status=="success")
			return new ResponseEntity<Object>("SuccesFully Deleted",HttpStatus.OK);
		else
			return new ResponseEntity<Object>(status,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<Orders>> getOrdersByUser(@PathVariable Integer id) {
		List<Orders> order = service.getOrdersByUser(id);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	

}
