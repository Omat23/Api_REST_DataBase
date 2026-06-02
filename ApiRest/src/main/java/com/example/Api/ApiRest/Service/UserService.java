package com.example.Api.ApiRest.Service;

import com.example.Api.ApiRest.DTOs.UserDTO;
import com.example.Api.ApiRest.Mapping.UserMapper;
import com.example.Api.ApiRest.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    public void addUser(UserDTO userDTO){

        userRepository.save(userMapper.toUser(userDTO));

    }
}
