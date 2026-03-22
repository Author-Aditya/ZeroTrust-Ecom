package com.ecom.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.user.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	boolean deleteByUsername(String username);

	User findByUsername(String username);

}
