package com.example.task_menager.controller;

import com.example.task_menager.model.User;
import com.example.task_menager.service.UserService; // Zaimportuj usługę
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService; // Zmień typ na UserService

    @Autowired
    public UserController(UserService userService){ // Wstrzyknij usługę
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers(); // Wywołaj metodę z usługi
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user); // Wywołaj metodę z usługi
    }
}