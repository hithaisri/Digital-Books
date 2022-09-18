package com.author.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.author.entity.AuthResponse;
import com.author.entity.LoggedInUser;
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
	public AuthResponse checkUserExists(String email, String password) {
		AuthResponse response=null;
		User existingUser=null;
		existingUser=userRepository.findByEmailAndPassword(email, password);
		if(existingUser!=null) {
			response=new AuthResponse();
			response.setMessage("Successfully Logged In");
			response.setRole(existingUser.getRole());
			response.setStatusCode(200);
			LoggedInUser loggedInUser=new LoggedInUser();
			loggedInUser.setEmail(existingUser.getEmail());
			loggedInUser.setUserId(existingUser.getId());
			loggedInUser.setUserName(existingUser.getFirstName()+" "+existingUser.getLastName());
			response.setUser(loggedInUser);
		}else {
			response=new AuthResponse();
			response.setMessage("Failed To Login! Check your credentials");
			response.setRole(0);
			response.setStatusCode(400);
			LoggedInUser loggedInUser=new LoggedInUser();
			response.setUser(loggedInUser);	
		}

			return response;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
}