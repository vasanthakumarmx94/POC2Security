package com.neosoft.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{



	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/Project/{projId}/students").hasAnyRole("ADMIN","USER")
		.antMatchers(HttpMethod.POST,"/project").hasAnyRole("ADMIN","USER")
		.antMatchers(HttpMethod.POST,"/**").hasAnyRole("ADMIN") //for all end points with post 
		.antMatchers(HttpMethod.GET,"/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.PUT,"/project/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/students/**").hasAnyRole("ADMIN").and()
		.csrf().disable();
		
//		http.authorizeRequests()
//        .antMatchers("/Project/{projId}/students","/project").permitAll()
//        .anyRequest().authenticated().and()
//        .antMatcher("/**").authorizeRequests()
//        .antMatchers("/**").hasRole("ADMIN")
//        .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
		
	}

	
	
}
