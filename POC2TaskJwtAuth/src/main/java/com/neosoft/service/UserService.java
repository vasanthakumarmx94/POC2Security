package com.neosoft.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.neosoft.dao.RoleDao;
import com.neosoft.dao.UserDao;
import com.neosoft.entity.Role;
import com.neosoft.entity.User;

@Service
public class UserService {
	
	@Autowired
	private RoleDao roledao;
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public User registerNewuser(User user) {
		return userdao.save(user);
		
	}
	
	public void initRolesAndUser() {
		Role adminRole=new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin role");
		roledao.save(adminRole);
		
		Role userRole=new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default role for newly created records");
		roledao.save(userRole);
		
		User adminUser=new User();
		adminUser.setUserName("admin");
		adminUser.setUserFirstName("admin");
		adminUser.setUserLastName("admin");
		adminUser.setUserPassword(getEncodedPassword("admin@pass"));
		Set<Role> adminRoles=new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userdao.save(adminUser);
		
		User user=new User();
		user.setUserName("raj123");
		user.setUserFirstName("raj");
		user.setUserLastName("sharma");
		user.setUserPassword(getEncodedPassword("raj@pass"));
		Set<Role> userRoles=new HashSet<>();
		userRoles.add(userRole);
		user.setRole(userRoles);
		userdao.save(user);
		
		
	}
	
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
		
		
	}
	
	

}
