package com.neosoft.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.myexception.ResourceNotFoundException;
import com.neosoft.customUserdetails;
import com.neosoft.entities.User;
import com.neosoft.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> optuser = userRepository.findByUsername(username);
		optuser.orElseThrow(() -> new ResourceNotFoundException("User", "UserName",username));
		return optuser.map(User->new customUserdetails(User)).get();
	}
	
	
	
	
	
	
	
	
	
}
