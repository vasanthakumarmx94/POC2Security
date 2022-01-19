package com.neosoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.entity.User;

public interface UserDao extends JpaRepository<User, String>{

}
