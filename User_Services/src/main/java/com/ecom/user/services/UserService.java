package com.ecom.user.services;

import com.ecommerce.models.UserDTO;

public interface UserService {
	
	UserDTO createUser(UserDTO user);

	UserDTO deleteUser(UserDTO user);

}
