package com.example.Api.ApiRest.Exception.HandlerException;

import com.example.Api.ApiRest.Exception.Exceptions.BadCredentialsException;
import com.example.Api.ApiRest.Exception.Exceptions.BaseAppException;
import com.example.Api.ApiRest.Exception.Exceptions.EmailNotFoundException;
import com.example.Api.ApiRest.Exception.Exceptions.ResourceNotFoundException;
import com.example.Api.ApiRest.Exception.HandlerException.Service.ExceptionService;
import com.example.Api.ApiRest.Exception.ResponseException.ResponseException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {

    private ExceptionService exceptionService;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseException<Map<String, String>>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException validException){
        Map<String, String> errors = new HashMap<>();
        validException.getBindingResult().getFieldErrors().forEach(error ->{
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(new ResponseException<>(
                "Invalid input parameters",
                errors,
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        ), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseException<Map<String, String>>> handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        return new ResponseEntity<>(new ResponseException<>(
                resourceNotFoundException.getMessage(),
                resourceNotFoundException.getResources(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        ), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({EmailNotFoundException.class, BadCredentialsException.class})
    public ResponseEntity<ResponseException<Map<String, String>>> handlerAuthenticationException(){
        return exceptionService.buildUnauthorizedResponse();
    }
}
