package com.neosoft.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	private String userName;
	private String userFirstName;
	private String userLastName;
	private String userPassword;
	
	@ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name="USER_ROLE",
				joinColumns = { 
						@JoinColumn(name="USER_ID") 
						},
				inverseJoinColumns = {@JoinColumn(name="ROLE_ID")	
						}
			 )
	private Set<Role> role;
	

}
