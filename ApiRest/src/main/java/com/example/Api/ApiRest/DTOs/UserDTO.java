package com.example.Api.ApiRest.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Surname is required")
    private String surname;

    @Min(value = 18, message = "Age must be at least 18")
    @Positive(message = "Age must be a positive number")
    private String age;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

}
