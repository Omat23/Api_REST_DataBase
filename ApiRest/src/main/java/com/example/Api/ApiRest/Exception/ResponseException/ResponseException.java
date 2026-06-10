package com.example.Api.ApiRest.Exception.ResponseException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseException<T>{

    private String title;
    private T content;
    private int codeError;
    private LocalDateTime timestamp;

}
