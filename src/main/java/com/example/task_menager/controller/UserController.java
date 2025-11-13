package com.example.task_menager.controller;

import com.example.task_menager.model.User;
import com.example.task_menager.service.UserService; // Zaimportuj usługę
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}