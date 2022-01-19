package com.neosoft.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
		final UserDetails userDetails= loadUserByUsername(userName);
		String newGeneratedToken= jwtutil.generateToken(userDetails);
		
		User user= userDao.findById(userName).get();
		
		return new JwtResponse(user, newGeneratedToken);
		
	}
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=userDao.findById(username).get();
		if (user!=null) {
			return new org.springframework.security.core.userdetails.User(
					user.getUserName(),
					user.getUserPassword(),
					getAuthorities(user)
					);
		}else {
			throw new UsernameNotFoundException("Username not valid");
		}
	}
	
	private Set getAuthorities(User user) {
		Set authorities=new HashSet();
		user.getRole().forEach(role->{
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
		});
		
		return authorities;
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
