package com.author.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.author.entity.User;
import com.author.service.IUserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
	
	@PostMapping("/login")
	public ResponseEntity<String> checkUserLogin(@RequestBody User user) {
		User loggedInUser=userService.checkUserExists(user.getEmail(),user.getPassword());
		if(loggedInUser!=null) 
			return new ResponseEntity<String>("Successfully Logged In!",HttpStatus.OK);
		else 
			return new ResponseEntity<String>("Failed to Login! Inactive/Invalid User",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getUsers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
}
