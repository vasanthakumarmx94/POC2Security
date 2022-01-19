package com.neosoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.entity.Role;

public interface RoleDao extends JpaRepository<Role, String>{
	

}
