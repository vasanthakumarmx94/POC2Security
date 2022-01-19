package com.neosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neosoft.dao.UserDao;
import com.neosoft.entity.JwtRequest;
import com.neosoft.entity.JwtResponse;
import com.neosoft.entity.User;
import com.neosoft.util.JwtUtil;

@Service
public class JwtService implements UserDetailsService{
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtutil;
	
	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
		String userName=jwtRequest.getUserName();
		String userPassword=jwtRequest.getUserPassword();
		authenticate(userName,userPassword);
		return null;
	}
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=userDao.findById(username).get();
		if (user!=null) {
			return
		}else {
			
		}
	}
	
	private void authenticate(String userName,String userPassword) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
			
		} catch (DisabledException e) {
			throw new Exception("user is dissabled");
		}catch (BadCredentialsException e) {
			throw new Exception("Bad credential from user");
		}
		
	}

	
}
