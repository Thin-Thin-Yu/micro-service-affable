package com.example.apisecurity1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PasswordNotMatchError extends ResponseStatusException {
    public PasswordNotMatchError(){
        super(HttpStatus.BAD_REQUEST,"password do not match!");
    }
}
