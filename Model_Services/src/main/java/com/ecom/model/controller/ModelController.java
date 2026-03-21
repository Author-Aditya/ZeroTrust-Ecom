package com.ecom.model.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.model.services.UserService;
import com.ecommerce.models.UserDTO;

@RestController
@RequestMapping("/model")
public class ModelController {

    UserService userService;

    public ModelController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser/{username}")
    public UserDTO getUser(@PathVariable String username) {
        return userService.getUser(username);
    }
}