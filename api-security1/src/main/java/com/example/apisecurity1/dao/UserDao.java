package com.example.apisecurity1.dao;

import com.example.apisecurity1.data.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Long> {
}
