package com.company.flatmate.controller;

import com.company.flatmate.entity.Renter;
import com.company.flatmate.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.List;

@RestController
public class RenterController {

    private final RenterService renterService;

    @Autowired
    public RenterController(RenterService renterService) {
        this.renterService = renterService;
    }

    @PostMapping(
            value = "/renter", consumes = "application/json", produces = "application/json")
    public Renter addRenter(@RequestBody Renter renter) throws Exception {
        renter.setPublicationDate(OffsetDateTime.now());
        renterService.save(renter);
        return renter;
    }

    @GetMapping(
            value = "/renter")
    public List<Renter> getRenters() throws Exception {
        return renterService.getRenters();
    }
}