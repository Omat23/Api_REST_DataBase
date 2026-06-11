package com.example.Api.ApiRest.Service;

import com.example.Api.ApiRest.Config.SecurityConfig;
import com.example.Api.ApiRest.DTOs.UserRequestDTO;
import com.example.Api.ApiRest.DTOs.UserResponseDTO;
import com.example.Api.ApiRest.Mapping.UserMapper;
import com.example.Api.ApiRest.Models.User;
import com.example.Api.ApiRest.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    private SecurityConfig securityConfig;

    public UserResponseDTO addUser(UserRequestDTO userRequestDTO){
        userRequestDTO.setPassword(encryptPassword(userRequestDTO.getPassword()));
        User user = userMapper.toUser(userRequestDTO);
        return userMapper.toResponseDTO(userRepository.save(user));
    }

    //add method to update user and encrypt password
    private String encryptPassword(String password){
        return securityConfig.bCrypt().encode(password);
    }
}
