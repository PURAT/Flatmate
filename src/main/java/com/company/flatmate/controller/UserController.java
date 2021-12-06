package com.company.flatmate.controller;

import com.company.flatmate.dto.UserDto;
import com.company.flatmate.security.payload.MessageResponse;
import com.company.flatmate.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@SecurityRequirement(name = "flatmateapi")
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(service.findById(UUID.fromString(id)));
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("User ID is entered incorrectly!"));
        } catch (NoSuchElementException e) {
            return ResponseEntity
                    .notFound().build();
        }
    }

    @GetMapping(params="login")
    public ResponseEntity<?> getUserByLogin(@RequestParam(value = "login") String login) {
        try {
            return ResponseEntity.ok(service.findByLogin(login));
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("User login is entered incorrectly!"));
        } catch (NoSuchElementException e) {
            return ResponseEntity
                    .notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserDto user) throws Exception {
        service.save(user);
        return ResponseEntity.ok().build();
    }

}