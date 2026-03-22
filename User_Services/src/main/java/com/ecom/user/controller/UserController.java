package com.ecom.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;

import com.ecom.user.services.UserService;
import com.ecommerce.models.UserDTO;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserDTO createUser(@RequestBody UserDTO user) {

        logger.info("Received request to create user with email: {}", user.getEmailId());

        UserDTO response = userService.createUser(user);

        logger.info("User created successfully with email: {}", response.getEmailId());

        return response;
    }

    @DeleteMapping("/delete")
    public UserDTO deleteUser(@RequestBody UserDTO user) {

        logger.warn("Received request to delete user with email: {}", user.getEmailId());

        UserDTO response = userService.deleteUser(user);

        logger.info("User deleted successfully with email: {}", user.getEmailId());

        return response;
    }
}