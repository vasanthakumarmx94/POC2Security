package com.neosoft.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="role")
public class Role {
	
	@Id
	@GeneratedValue
	private long id;
	
	String name;
	

}
