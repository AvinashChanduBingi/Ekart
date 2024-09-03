package com.ekart.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.model.User;
import com.ekart.service.UserDao;


@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserDao service;
	
	@GetMapping
	public ResponseEntity<Object> getAllUsers() {
		List<User> users = service.getAllUsers();
		if(users.isEmpty())
			return new ResponseEntity<Object>("No users presesnt",HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Object>(users,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable Integer id) {
		User user = service.getUserById(id);
		if(user==null)
			return new ResponseEntity<Object>("No users presesnt",HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Object>(user,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		String status  = service.saveUser(user);
		if(status.equalsIgnoreCase("success"))
			return new ResponseEntity<Object>("SuccesFully saved",HttpStatus.OK);
		else
			return new ResponseEntity<Object>(status,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@PutMapping
	public ResponseEntity<Object> updateUser(@RequestBody User user) {
		String status  = service.updateUser(user);
		if(status=="success")
			return new ResponseEntity<Object>("SuccesFully Updated",HttpStatus.OK);
		else
			return new ResponseEntity<Object>(status,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {
		String status  = service.deleteUser(id);
		if(status=="success")
			return new ResponseEntity<Object>("SuccesFully Deleted",HttpStatus.OK);
		else
			return new ResponseEntity<Object>(status,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
