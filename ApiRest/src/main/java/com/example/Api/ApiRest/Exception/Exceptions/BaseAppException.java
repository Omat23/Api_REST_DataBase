package com.example.Api.ApiRest.Exception.Exceptions;

import lombok.Getter;

import java.util.Map;

@Getter
public class BaseAppException extends RuntimeException {

    protected final Map<String, String> resources;

    public BaseAppException(Map<String, String> resources) {
        this.resources = resources;
    }
}
