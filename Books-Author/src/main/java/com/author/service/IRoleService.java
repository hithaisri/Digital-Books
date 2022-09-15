package com.author.service;

import java.util.List;

import com.author.entity.Role;

public interface IRoleService {

    public Role saveRole(Role role);

	public List<Role> getAllRoles();
}
