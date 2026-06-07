package com.example.Api.ApiRest.Exception.ResponseException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class ResponseException<T>{

    private String title;
    private String message;
    private T content;
    private int codeError;
    private LocalDateTime timestamp;

}
