package com.example.demo.controller;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<Users> getUsers() {
        return userRepository.findAll();
    }
}