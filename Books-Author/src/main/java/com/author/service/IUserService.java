package com.author.service;

import java.util.List;

import com.author.entity.AuthResponse;
import com.author.entity.User;

public interface IUserService {

	public User saveUser(User user);
	
	public User getUser(Integer id);

	public AuthResponse checkUserExists(String email, String password);

	public List<User> getAllUsers();
}
