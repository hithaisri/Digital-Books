package com.author.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.author.entity.User;
import com.author.exception.ResourceNotFoundException;
import com.author.repository.IUserRepository;
import com.author.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	IUserRepository userRepository;

	@Override
	public User saveUser(User user) {
		User newUser=null;
		User exisitngUser=userRepository.findByEmail(user.getEmail());
		if(exisitngUser==null)
			 newUser=userRepository.save(user);
		else 
			throw new ResourceNotFoundException("User Duplicate Entry!");
		return newUser;
	}

	@Override
	public User getUser(Integer id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User checkUserExists(String email, String password) {
		User existingUser=userRepository.findByEmailAndPassword(email, password);
		return existingUser;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
}