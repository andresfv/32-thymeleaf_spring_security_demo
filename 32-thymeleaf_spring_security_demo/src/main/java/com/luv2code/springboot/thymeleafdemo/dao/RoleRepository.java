package com.luv2code.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	public Role findByName(String userName);
	
}
