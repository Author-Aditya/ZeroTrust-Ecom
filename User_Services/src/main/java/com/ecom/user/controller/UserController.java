package com.ecom.user.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.user.services.UserService;
import com.ecommerce.models.UserDTO;

@RestController
@RequestMapping("/user")
public class UserController {
	
	UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
		
	}
	
	@PostMapping("/create")
	public UserDTO createUser(UserDTO user)
	{
		return userService.createUser(user);
		
	}
	
	@DeleteMapping("/delete")
	public UserDTO deleteUser(UserDTO user)
	{
		return userService.deleteUser(user);
		
	}
	

}
