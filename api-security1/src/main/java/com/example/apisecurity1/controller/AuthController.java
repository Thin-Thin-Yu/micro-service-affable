package com.example.apisecurity1.controller;

import com.example.apisecurity1.dao.UserDao;
import com.example.apisecurity1.data.User;
import com.example.apisecurity1.exception.PasswordNotMatchError;
import com.example.apisecurity1.service.AuthService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private final AuthService authService;
    public AuthController(AuthService authService){
        this.authService = authService;
    }
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
    record RequestUser(@JsonProperty("first_name") String firstName,
                       @JsonProperty("last_name") String lastName, String email, String password,
                       @JsonProperty("confirm_password") String confirmPassword){}
    record RegisterResponse(@JsonProperty("first_name") String firstName,
                            @JsonProperty("last_name") String lastName,String email){}
    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RequestUser requestUser){
        User user= authService.register(
                requestUser.firstName(), requestUser.lastName(), requestUser.email(), requestUser.password(),requestUser.confirmPassword()
        );
        return new RegisterResponse(user.getFirstName(),user.getLastName(),user.getEmail());
    }


}
