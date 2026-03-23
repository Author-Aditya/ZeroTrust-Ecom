package com.ecom.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.user.entities.User;

import jakarta.transaction.Transactional;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Transactional
	void deleteByUsername(String username);

	User findByUsername(String username);

}
