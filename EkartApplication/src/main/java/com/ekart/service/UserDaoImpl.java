package com.ekart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ekart.model.User;
import com.ekart.repo.UserRepo;

@Service
public class UserDaoImpl implements UserDao {
	
	private UserRepo repo;

	public UserDaoImpl(UserRepo repo)
	{
		this.repo = repo;
	}
	
	
	@Override
	public List<User> getAllUsers() {
		List<User> users = repo.findAll();
		return users;
	}


	@Override
	public User getUserById(Integer id) {
		return repo.findById(id).orElse(new User());
	}


	@Override
	public String saveUser(User user) {
		try
		{
			User users = repo.save(user);
			return "success";
		}
		catch(Exception e)
		{
			return e.getLocalizedMessage();
		}
		
	}


	@Override
	public String updateUser(User user) {
		
		try
		{
			User users = repo.save(user);
			return "success";
		}
		catch(Exception e)
		{
			return e.getLocalizedMessage();
		}
	}


	@Override
	public String deleteUser(Integer id) {
		try
		{
			Optional<User> user = repo.findById(id);
			repo.deleteById(id);
			if(!user.isPresent())
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

}
