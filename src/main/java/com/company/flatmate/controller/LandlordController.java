package com.company.flatmate.controller;

import com.company.flatmate.dto.LandlordDto;
import com.company.flatmate.exception.NoSuchDataException;
import com.company.flatmate.security.payload.MessageResponse;
import com.company.flatmate.service.LandlordService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@SecurityRequirement(name = "flatmateapi")
@RequestMapping("/landlord")
@AllArgsConstructor
public class LandlordController {

    private final LandlordService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> getLandlord(@PathVariable String id) {
        try {
            return ResponseEntity.ok(service.findById(UUID.fromString(id)));
        } catch (Exception e) {
            throw new NoSuchDataException();
        }
    }

    @PostMapping
    public ResponseEntity<?> addLandlord(@RequestBody LandlordDto landlord) {
        service.save(landlord);
        return ResponseEntity.ok().build();
    }

}