package com.company.flatmate.controller;

import com.company.flatmate.dto.ApartmentFeedbackDto;
import com.company.flatmate.entity.Apartment;
import com.company.flatmate.entity.ApartmentFeedback;
import com.company.flatmate.service.ApartmentService;
import com.company.flatmate.util.mapper.ApartmentFeedbackMapper;
import com.company.flatmate.util.mapper.ApartmentMapper;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/apartment")
@SecurityRequirement(name = "flatmateapi")
@AllArgsConstructor
public class ApartmentController {

    private final ApartmentFeedbackMapper apartmentFeedbackMapper;
    private final ApartmentMapper mapper;
    private final ApartmentService service;


    @PostMapping
    public HttpStatus addApartment(@RequestBody Apartment apartment) {
        service.save(apartment);
        return HttpStatus.OK;
    }

    @GetMapping("/feedback")
    public String getApartmentFeedback() {
        ApartmentFeedback feedback = new ApartmentFeedback();
        feedback.setApartmentId(UUID.randomUUID());
        feedback.setAuthorId(UUID.randomUUID());
        feedback.setValue(5);

        ApartmentFeedbackDto dto = apartmentFeedbackMapper.feedbackToDto(feedback);

        return dto.toString();
    }

    @GetMapping
    public String getApartment() {
        Apartment apartment = new Apartment();
        apartment.setId(UUID.fromString("400db01e-3999-11ec-8d3d-0242ac130003"));
        apartment.setLocation(new Point(10.565, 10.987));
        service.save(apartment);
        return null;
    }

}
