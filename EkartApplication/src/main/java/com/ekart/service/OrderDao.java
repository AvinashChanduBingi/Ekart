package com.ekart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ekart.model.Orders;
import com.ekart.model.Products;

public interface OrderDao {
	
	List<Orders> getAllOrders();
	Orders getOrderById(Integer id);
	String saveOrder(Orders order);
	String updateOrder(Orders order);
	String deleteOrder(Integer id);
	List<Orders> getOrdersByUser(Integer id);

}
