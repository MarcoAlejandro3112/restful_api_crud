package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class ResourcesNotFoundException extends BaseRuntimeException{
    public ResourcesNotFoundException(Long id){
        super("Resource with "+id+" not found", HttpStatus.NOT_FOUND);
    }
}
