package com.ecom.user.services.serviceImpl;

import org.springframework.stereotype.Service;

import com.ecom.user.entities.User;
import com.ecom.user.mapper.UserMapper;
import com.ecom.user.repository.UserRepo;
import com.ecom.user.services.UserService;
import com.ecommerce.models.UserDTO;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepo.save(user);

        return userMapper.toDTO(savedUser);
    }

	@Override
	public UserDTO deleteUser(UserDTO userDTO) {
		 userRepo.deleteByUsername(userDTO.getUsername());
		 UserDTO deleteDto = new UserDTO();
		 deleteDto.setMessage("deleted Successfully");
	     return deleteDto;
	}
}
