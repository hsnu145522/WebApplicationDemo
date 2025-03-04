package com.example.demo.controller;

import com.example.demo.entity.Users;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public String createUser(@RequestBody Users user) {
        userService.addUser(user);
        return "Successfully Created User!";
    }

    @GetMapping
    public List<Users> getUsers() {
        return userService.getAllUser();
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable String id, @RequestBody Users user) {
        // TODO: process PUT request
        userService.updateUser(Long.valueOf(id), user);

        return "Successfully Updated User!";

    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(Long.valueOf(id));
        return "Successfully Deleted User!";
    }
}