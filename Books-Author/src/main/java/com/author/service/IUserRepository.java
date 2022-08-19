package com.author.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.author.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

	public User findByEmailAndPassword(String email,String password);

	public User findByEmail(String email);
	
}
