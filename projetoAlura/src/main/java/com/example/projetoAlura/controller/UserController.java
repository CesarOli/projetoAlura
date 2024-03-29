package com.example.projetoAlura.controller;

import com.example.projetoAlura.model.User;
import com.example.projetoAlura.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    private ResponseEntity<UserInfo> getUserInfo(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        UserInfo userInfo = new UserInfo(user.getName(), user.getEmail(), user.getRoles());
        return ResponseEntity.ok(userInfo);
    }

    private record UserInfo(String name, String email, com.example.projetoAlura.model.Roles role) {
    }
}
