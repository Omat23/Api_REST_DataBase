package com.example.Api.ApiRest.Exception.Exceptions;

import lombok.Getter;

import java.util.Map;

@Getter
public class ResourceNotFoundException extends BaseAppException{

    public ResourceNotFoundException(Map<String, String> resources) {
        super(resources);
    }

}
