package com.author.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.author.model.Books;
import com.author.model.User;
import com.author.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService userService;
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") Integer id) {
		return userService.getUser(id);
	}
	
	@PostMapping
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		User savedUser=userService.saveUser(user);
		if(savedUser!=null)
			return new ResponseEntity<String>("Successfully added User!",HttpStatus.OK);
		else 
			return new ResponseEntity<String>("Failed to save User!",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/login")
	public ResponseEntity<String> checkUserLogin(@RequestParam(value="email",required=true) String email,@RequestParam(value="password",required = true) String password) {
		User loggedInUser=userService.checkUserExists(email,password);
		if(loggedInUser!=null) 
			return new ResponseEntity<String>("Successfully Logged In!",HttpStatus.OK);
		else 
			return new ResponseEntity<String>("Failed to Login! Inactive/Invalid User",HttpStatus.BAD_REQUEST);
	}
}
