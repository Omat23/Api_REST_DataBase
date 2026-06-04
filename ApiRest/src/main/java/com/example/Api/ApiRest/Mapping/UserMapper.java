package com.example.Api.ApiRest.Mapping;

import com.example.Api.ApiRest.DTOs.UserDTO;
import com.example.Api.ApiRest.Models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserDTO userDTO);

}
