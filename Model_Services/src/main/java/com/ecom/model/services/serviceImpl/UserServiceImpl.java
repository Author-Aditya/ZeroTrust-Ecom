package com.ecom.model.services.serviceImpl;

import org.springframework.stereotype.Service;

import com.ecom.model.entities.User;
import com.ecom.model.repository.UserRepo;
import com.ecom.model.services.UserService;
import com.ecommerce.models.UserDTO;


@Service
public class UserServiceImpl implements UserService {

	UserRepo userRepo;

	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDTO getUser(String Username) {
		try {
			User user = userRepo.findByUsername(Username);
			if(user != null)
			{
				UserDTO userDTO = convert(user,"User Exist");
				return userDTO;
				
			}
			else {
				UserDTO userDTO = new UserDTO();
				userDTO.setMessage("Invalid Username");
				return userDTO;
			}
			
			
		} catch (Exception e) {
			UserDTO userDTO = new UserDTO();
			userDTO.setMessage("Getting issue while fetching user");
			return userDTO;
		}

	}

	private UserDTO convert(User user, String message) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setEmailId(user.getEmailId());
		userDTO.setMessage(message);
		return userDTO;
	}

}
