package com.example.Api.ApiRest.Service;

import com.example.Api.ApiRest.Config.SecurityConfig;
import com.example.Api.ApiRest.DTOs.UserRequestDTO;
import com.example.Api.ApiRest.DTOs.UserResponseDTO;
import com.example.Api.ApiRest.Exception.Exceptions.BadCredentialsException;
import com.example.Api.ApiRest.Exception.Exceptions.EmailNotFoundException;
import com.example.Api.ApiRest.Exception.Exceptions.ResourceNotFoundException;
import com.example.Api.ApiRest.Mapping.UserMapper;
import com.example.Api.ApiRest.Models.User;
import com.example.Api.ApiRest.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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

    public UserResponseDTO getUser(String email, String password){

        User userResponse = userRepository.findByEmail(email).orElseThrow(EmailNotFoundException::new);

        if(!securityConfig.bCrypt().matches(password, userResponse.getPassword())){
            throw new BadCredentialsException();
        }
        return userMapper.toResponseDTO(userResponse);
    }
}
