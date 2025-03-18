package com.example.demo.controller;

import com.example.demo.entity.Users;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Create new user", responses = {
            @ApiResponse(responseCode = "200", description = "Successfully created user")
    })
    public Users createUser(@RequestBody Users user) {
        userService.addUser(user);
        return user;
        // return "Successfully Created User!";
    }

    @GetMapping
    @Operation(summary = "Get all users", responses = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved all users")
    })
    public List<Users> getUsers() {
        return userService.getAllUser();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user", responses = {
            @ApiResponse(responseCode = "200", description = "Successfully updated user")
    })
    public Users updateUser(@PathVariable String id, @RequestBody Users user) {
        // TODO: process PUT request
        userService.updateUser(Long.valueOf(id), user);
        return user;

        // return "Successfully Updated User!";

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user", responses = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted user")
    })
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(Long.valueOf(id));
        return "Successfully Deleted User!";
    }
}