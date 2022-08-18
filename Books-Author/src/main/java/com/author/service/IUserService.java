package com.author.service;

import com.author.model.User;

public interface IUserService {

	public User saveUser(User user);
	
	public User getUser(Integer id);

	public User checkUserExists(String email, String password);
}
