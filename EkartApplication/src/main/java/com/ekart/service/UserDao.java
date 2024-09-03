package com.ekart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ekart.model.User;

@Service
public interface UserDao {
	
	List<User> getAllUsers();
	User getUserById(Integer id);
	String saveUser(User user);
	String updateUser(User user);
	String deleteUser(Integer id);

}
