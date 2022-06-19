package com.example.navvistaskbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class NavvisTaskBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NavvisTaskBackendApplication.class, args);
    }
}
