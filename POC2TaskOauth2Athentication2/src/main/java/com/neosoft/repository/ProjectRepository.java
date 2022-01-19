package com.neosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.entities.Project;



public interface ProjectRepository extends JpaRepository<Project, Long>{

}
