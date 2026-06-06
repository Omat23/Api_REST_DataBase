package com.example.Api.ApiRest.Mapping;

import com.example.Api.ApiRest.DTOs.UserRequestDTO;
import com.example.Api.ApiRest.DTOs.UserResponseDTO;
import com.example.Api.ApiRest.Models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserRequestDTO userDTO);

    UserResponseDTO toResponseDTO(User user);

}
