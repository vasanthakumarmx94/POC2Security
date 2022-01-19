package com.neosoft.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {

	
	private User user;
	private String jwtToken;
}
