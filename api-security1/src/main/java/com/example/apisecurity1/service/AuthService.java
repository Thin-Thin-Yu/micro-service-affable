package com.example.apisecurity1.service;

import com.example.apisecurity1.dao.UserDao;
import com.example.apisecurity1.data.User;
import com.example.apisecurity1.exception.PasswordNotMatchError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class AuthService {
    @Autowired
    private final UserDao userDao;
    public AuthService(UserDao userDao){
        this.userDao = userDao;
    }
    public User register(String firstName,String lastName,String email,String password,String confirmPassword){
        if(!password.equals(confirmPassword)){
            throw new PasswordNotMatchError();
        }
        return userDao.save(
                User.of(firstName,lastName,email,password)
        );
    }
}
