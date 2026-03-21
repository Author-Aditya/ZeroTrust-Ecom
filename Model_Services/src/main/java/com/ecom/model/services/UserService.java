package com.ecom.model.services;

import com.ecom.model.entities.User;
import com.ecommerce.models.UserDTO;

public interface UserService {
	
	UserDTO getUser(String Username);

}
