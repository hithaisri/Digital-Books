package com.author.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.author.model.User;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	IUserRepository userRepository;

	@Override
	public User saveUser(User user) {
		User newUser=userRepository.save(user);
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
	
	
	
	
}
