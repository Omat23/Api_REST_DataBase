package com.example.Api.ApiRest.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter //Create the getters of the model
@NoArgsConstructor //Create an empty constructor
public class User {

    //User attributes
    private int id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String password;

    //It is required to avoid entering a manual ID
    public User(String name, String surname, int age, String email, String password){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.password = password;
    }

}
