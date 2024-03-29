package com.example.projetoAlura.model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/apis/users")

public class UserTest {
    @GetMapping("/test")
    public User getUser() throws IllegalAccessException {
        User user = new User();
        user.setName("César");
        user.setUsername("cesaroli");
        user.setEmail("cesaroli@icloud.com");
        user.setPassword("123321");
        user.setRoles(Roles.STUDENDT);
        user.setDate(new Date());

        return user;
    }
}
