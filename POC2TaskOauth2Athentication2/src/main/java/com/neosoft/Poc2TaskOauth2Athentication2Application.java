package com.neosoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.neosoft.repository.UserRepository;

@SpringBootApplication
public class Poc2TaskOauth2Athentication2Application extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(Poc2TaskOauth2Athentication2Application.class, args);
	}
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
	
//	@Bean
//	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repo) throws Exception {
//		builder.userDetailsService(s-> new customUserdetails(repo.findByUsername(s)));
//		
//		
//	}

}
