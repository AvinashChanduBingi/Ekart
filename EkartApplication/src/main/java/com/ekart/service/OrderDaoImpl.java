package com.ekart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.model.Orders;
import com.ekart.model.User;
import com.ekart.repo.OrderRepo;
import com.ekart.repo.UserRepo;

@Service
public class OrderDaoImpl implements OrderDao{
	
	private OrderRepo repo;
	
	@Autowired
	private UserRepo UserRepo;

	@Autowired
	public OrderDaoImpl(OrderRepo repo)
	{
		this.repo = repo;
	}
	
	
	@Override
	public List<Orders> getAllOrders() {
		List<Orders> orders = repo.findAll();
		return orders;
	}


	@Override
	public Orders getOrderById(Integer id) {
		return repo.findById(id).orElse(new Orders());
	}


	@Override
	public String saveOrder(Orders order) {
		try
		{
			if(order.getProductId().getQuantity()>order.getQuantity() )
			{
			repo.save(order);
			return "success";
			}
			else
			{
				return "No Enough stock";
			}
		}
		catch(Exception e)
		{
			return e.getLocalizedMessage();
		}
		
	}


	@Override
	public String updateOrder(Orders order) {
		
		try
		{
		  repo.save(order);
			return "success";
		}
		catch(Exception e)
		{
			return e.getLocalizedMessage();
		}
	}


	@Override
	public String deleteOrder(Integer id) {
		try
		{
			Optional<Orders> order = repo.findById(id);
			repo.deleteById(id);
			if(order.isEmpty())
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
	
	@Override
	public List<Orders> getOrdersByUser(Integer id)
	{
		User user = UserRepo.findById(id).orElse(new User());
		return user.getOrder();
	}

}
