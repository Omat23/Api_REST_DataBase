package com.example.Api.ApiRest.Exception.HandlerException.Service;

import com.example.Api.ApiRest.Exception.ResponseException.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class ExceptionService {

    public ResponseEntity<ResponseException<Map<String, String>>> buildUnauthorizedResponse(){
        return new ResponseEntity<>(new ResponseException<>(
                "Invalid credentials",
                Map.of("error", "invalid email or password"),
                HttpStatus.UNAUTHORIZED.value(),
                LocalDateTime.now()
        ), HttpStatus.UNAUTHORIZED);
    }

}
