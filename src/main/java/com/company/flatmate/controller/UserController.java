package com.company.flatmate.controller;

import com.company.flatmate.entity.User;
import com.company.flatmate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(
            value = "/user", consumes = "application/json", produces = "application/json")
    public User addUser(@RequestBody User user) throws Exception {
        userService.save(user);
        return user;
    }

    @GetMapping(
            value = "/user")
    public List<User> getUsers() throws Exception {
        return userService.getUsers();
    }
}