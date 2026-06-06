package com.example.Api.ApiRest.Service;

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

    public UserResponseDTO addUser(UserRequestDTO userRequestDTO){
        User user = userMapper.toUser(userRequestDTO);
        return userMapper.toResponseDTO(userRepository.save(user));
    }
}
