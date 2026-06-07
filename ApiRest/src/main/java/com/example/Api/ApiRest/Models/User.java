package com.example.Api.ApiRest.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity //Indicates that this class is an entity and will be mapped to a database table
@Table(name = "users") //Specifies the name of the database table to be used for mapping
@Data //Create the getters and setters of the model
@NoArgsConstructor //Create an empty constructor
public class User {

    //User attributes
    @Id //Indicates that this field is the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Specifies that the primary key will be generated automatically by the database
    @Column(name = "id") //Specifies the name of the column in the database and that it cannot be null
    private int id;
    @Column(name = "name", nullable = false) //Specifies the name of the column in the database and that it cannot be null
    private String name;
    @Column(name = "surname", nullable = false) //Specifies the name of the column in the database and that it cannot be null
    private String surname;
    @Column(name = "age", nullable = false) //Specifies the name of the column in the database and that it cannot be null
    private int age;
    @Column(name = "email", nullable = false) //Specifies the name of the column in the database and that it cannot be null
    private String email;
    @Column(name = "password", nullable = false) //Specifies the name of the column in the database and that it cannot be null
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
