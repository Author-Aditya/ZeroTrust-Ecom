package com.ecom.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.model.entities.User;


@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);

}