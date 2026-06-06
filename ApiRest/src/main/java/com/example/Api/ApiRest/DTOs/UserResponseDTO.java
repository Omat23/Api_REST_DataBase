package com.example.Api.ApiRest.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseDTO {

    private int id;
    private String name;
    private String surname;
    private int age;
    private String email;

}
