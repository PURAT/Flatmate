package com.company.flatmate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/admin")
    public String helloAdmin() {
        return "<h2> Hello, admin! </h2>";
    }

    @GetMapping("/user")
    public String helloUser() {
        return "<h2> Hello, user! </h2>";
    }

    @GetMapping("/home")
    public String home() {
        return "<h2> Home page </h2>";
    }
}
