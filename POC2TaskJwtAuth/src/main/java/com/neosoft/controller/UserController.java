package com.neosoft.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.entity.User;
import com.neosoft.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostConstruct
	public void initRolesAndUser() {
		userService.initRolesAndUser();
	}
	
	@PostMapping("/registerNewUser")
	public User registerNewUser(@RequestBody User user) {
		return userService.registerNewuser(user);
	}
	
	@GetMapping("/forAdmin")
	public String foradmin() {
		return "This URL is only accessible to admin";
		
	}
	
	@GetMapping("/forUser")
	public String forUser() {
		return " This url is only acceble to user";
	}

}
