package com.neosoft.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String username;
	private String password;
	
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Role> roles;
	
	
	
	
}
