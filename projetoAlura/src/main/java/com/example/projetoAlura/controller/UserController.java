package com.example.projetoAlura.controller;

import com.example.projetoAlura.model.User;
import com.example.projetoAlura.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    public UserRepository userRepository;

    @GetMapping
    public List<User> toAdd() {
        return userRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User toAdd(@RequestBody User user) {
        return userRepository.save(user);
    }
}
