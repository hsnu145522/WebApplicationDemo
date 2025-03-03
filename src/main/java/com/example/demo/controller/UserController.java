package com.example.demo.controller;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public String createUser(@RequestBody Users user) {
        userService.addUser(user);
        return "Successfully Created User!";
    }

    @GetMapping
    public List<Users> getUsers() {
        return userService.getAllUser();
    }
}