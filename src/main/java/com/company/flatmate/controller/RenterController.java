package com.company.flatmate.controller;

import com.company.flatmate.dto.RenterDto;
import com.company.flatmate.security.payload.MessageResponse;
import com.company.flatmate.service.RenterService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@SecurityRequirement(name = "flatmateapi")
@RequestMapping("/renter")
@AllArgsConstructor
public class RenterController {

    private final RenterService service;

    @GetMapping()
    public ResponseEntity<?> getActiveRenters() throws Exception {
        return ResponseEntity.ok(service.findAllByActive(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getActiveApartments(@PathVariable String id) {
        try {
            return ResponseEntity.ok(service.findById(UUID.fromString(id)));
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Renter ID is entered incorrectly!"));
        } catch (NoSuchElementException e) {
            return ResponseEntity
                    .notFound().build();
        }
    }

    @GetMapping(params = {"min", "max"})
    public ResponseEntity<?> getRenterByMaxPrice(@RequestParam(value = "min") double min,
                                                  @RequestParam(value = "max") double max) {
        return ResponseEntity.ok(service.findAllByMaxPriceBetween(min, max));
    }

    @PostMapping
    public ResponseEntity<?> addRenter(@RequestBody RenterDto renter) throws Exception {
        service.save(renter);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteApartment(@PathVariable String id) {
        try {
            service.deleteById(UUID.fromString(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Renter ID is entered incorrectly!"));
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity
                    .notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}