package com.company.flatmate.controller;

import com.company.flatmate.entity.User;
import com.company.flatmate.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "flatmateapi")
@Tag(name="user", description="Операции с пользователями")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "Регистрация пользователя",
            description = "Позволяет зарегистрировать пользователя"
    )
    @PostMapping(
            value = "/user", consumes = "application/json", produces = "application/json")
    public User addUser(@RequestBody User user) throws Exception {
        userService.save(user);
        return user;
    }

    @Operation(
            summary = "Получение пользователей",
            description = "Позволяет получить пользователей"
    )
    @GetMapping(
            value = "/user")
    public List<User> getUsers() throws Exception {
        return userService.getUsers();
    }
}