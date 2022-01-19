package com.neosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.entity.Role;
import com.neosoft.service.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	
	@PostMapping("/createnewRole")
	public Role createnewRole(@RequestBody Role role) {
		return roleService.createNewRole(role);
		
	}
}
