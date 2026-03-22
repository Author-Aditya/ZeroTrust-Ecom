package com.ecom.user.mapper;

import org.mapstruct.Mapper;

import com.ecom.user.entities.User;
import com.ecommerce.models.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDTO dto);

    UserDTO toDTO(User user);
}