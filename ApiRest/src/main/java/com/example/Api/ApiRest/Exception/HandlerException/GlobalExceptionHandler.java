package com.example.Api.ApiRest.Exception.HandlerException;

import com.example.Api.ApiRest.Exception.ResponseException.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseException<Map<String, String>>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException validException){
        Map<String, String> errors = new HashMap<>();
        validException.getBindingResult().getFieldErrors().forEach(error ->{
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(new ResponseException<>(
                "Invalid input parameters",
                validException.getMessage(),
                errors,
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        ), HttpStatus.BAD_REQUEST);
    }

}
