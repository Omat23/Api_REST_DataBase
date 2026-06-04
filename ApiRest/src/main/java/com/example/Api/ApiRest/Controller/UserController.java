package com.example.Api.ApiRest.Controller;

import com.example.Api.ApiRest.DTOs.UserDTO;
import com.example.Api.ApiRest.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @PostMapping("/add")
    public String addUser(
            @RequestBody
            UserDTO userDTO
            ){

        userService.addUser(userDTO);
        return "User added successfully";
    }

}
