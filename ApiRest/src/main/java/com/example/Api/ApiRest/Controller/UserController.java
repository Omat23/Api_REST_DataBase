package com.example.Api.ApiRest.Controller;

import com.example.Api.ApiRest.DTOs.UserRequestDTO;
import com.example.Api.ApiRest.DTOs.UserResponseDTO;
import com.example.Api.ApiRest.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserResponseDTO> addUser(
            @RequestBody
            @Valid
            UserRequestDTO userRequestDTO
            ){

        UserResponseDTO userResponseDTO = userService.addUser(userRequestDTO);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
    }
}
