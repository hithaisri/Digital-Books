package com.author.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.author.entity.Role;
import com.author.repository.IRoleRespository;
import com.author.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	IRoleRespository roleRepo;
	
	@Override
	public Role saveRole(Role role) {
		Role newRole=roleRepo.save(role);
		return newRole;
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepo.findAll();
	}

}
