package com.company.flatmate.controller;

import com.company.flatmate.entity.Landlord;
import com.company.flatmate.service.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LandlordController {

    private final LandlordService landlordService;

    @Autowired
    public LandlordController(LandlordService landlordService) {
        this.landlordService = landlordService;
    }

    @PostMapping(
            value = "/landlord", consumes = "application/json", produces = "application/json")
    public Landlord addUser(@RequestBody Landlord landlord) throws Exception {
        landlordService.save(landlord);
        return landlord;
    }

    @GetMapping(
            value = "/landlord")
    public List<Landlord> getLandlords() throws Exception {
        return landlordService.getLandlords();
    }
}