package com.example.Api.ApiRest.Controller;

import com.example.Api.ApiRest.DTOs.UserRequestDTO;
import com.example.Api.ApiRest.DTOs.UserResponseDTO;
import com.example.Api.ApiRest.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<UserResponseDTO> getUser(
            @RequestParam
            String email,
            @RequestParam
            String password
    ){
        return new ResponseEntity<>(userService.getUser(email, password), HttpStatus.OK);
    }
}
