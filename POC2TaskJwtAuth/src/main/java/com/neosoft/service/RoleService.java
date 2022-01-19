package com.neosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.dao.RoleDao;
import com.neosoft.entity.Role;

@Service
public class RoleService {
	
	@Autowired
	private RoleDao roleDao;
	
	public Role createNewRole(Role role) {
		
		return roleDao.save(role);
		
	}

}
