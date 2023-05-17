package com.example.apisecurity1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@EnableJdbcRepositories
@SpringBootApplication
public class ApiSecurity1Application {

    public static void main(String[] args) {
        SpringApplication.run(ApiSecurity1Application.class, args);
    }

}
