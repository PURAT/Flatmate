package com.company.flatmate.controller;

import com.company.flatmate.dto.ApartmentFeedbackDto;
import com.company.flatmate.security.payload.MessageResponse;
import com.company.flatmate.service.ApartmentFeedbackService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/apartment/feedback")
@SecurityRequirement(name = "flatmateapi")
@AllArgsConstructor
public class ApartmentFeedbackController {

    private final ApartmentFeedbackService service;

    @GetMapping
    public ResponseEntity<?> getApartmentFeedbacks(@PathVariable("apart_id") String id) {
        try {
            List<ApartmentFeedbackDto> list = service.findAllByAuthorId(UUID.fromString(id));
            return ResponseEntity.ok(list);
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Apartment ID is entered incorrectly!"));
        }
    }

    @GetMapping
    public ResponseEntity<?> getApartmentFeedbacksByAuthor(@PathVariable("author_id") String id) {
        try {
            List<ApartmentFeedbackDto> list = service.findAllByApartmentId(UUID.fromString(id));
            return ResponseEntity.ok(list);
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Apartment ID is entered incorrectly!"));
        }
    }

    @PostMapping
    public ResponseEntity<?> addApartmentFeedback(@RequestBody ApartmentFeedbackDto feedback) {
        service.save(feedback);
        return ResponseEntity.ok().build();
    }
}
