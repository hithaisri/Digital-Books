package com.author.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.author.entity.Role;
import com.author.service.IRoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	IRoleService roleService;
	
	
	@GetMapping
	public List<Role> getAllRoles(){
		return roleService.getAllRoles();
	}
	
	@PostMapping
	public ResponseEntity<String> saveRole(@RequestBody Role role) {
		Role savedRole=roleService.saveRole(role);   //save role
		if(savedRole!=null)
			return new ResponseEntity<String>("Successfully added Role!",HttpStatus.OK);
		else 
			return new ResponseEntity<String>("Failed to save Role!",HttpStatus.BAD_REQUEST);
	}
}
