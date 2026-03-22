package com.ecom.user.services.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ecom.user.entities.User;
import com.ecom.user.mapper.UserMapper;
import com.ecom.user.repository.UserRepo;
import com.ecom.user.services.UserService;
import com.ecommerce.models.UserDTO;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        logger.info("Service: Creating user with email: {}", userDTO.getEmailId());

        User user = userMapper.toEntity(userDTO);

        User savedUser = userRepo.save(user);

        logger.info("Service: User saved in DB with id: {}", savedUser.getId());

        return userMapper.toDTO(savedUser);
    }

    @Override
    public UserDTO deleteUser(UserDTO userDTO) {

        logger.warn("Service: Deleting user with username: {}", userDTO.getUsername());

        userRepo.deleteByUsername(userDTO.getUsername());

        logger.info("Service: User deleted successfully: {}", userDTO.getUsername());

        UserDTO deleteDto = new UserDTO();
        deleteDto.setMessage("Deleted Successfully");

        return deleteDto;
    }
}