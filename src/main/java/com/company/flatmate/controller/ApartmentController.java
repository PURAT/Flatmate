package com.company.flatmate.controller;

import com.company.flatmate.dto.ApartmentFeedbackDto;
import com.company.flatmate.dto.ApartmentPhotoDto;
import com.company.flatmate.entity.Apartment;
import com.company.flatmate.entity.ApartmentFeedback;
import com.company.flatmate.entity.ApartmentPhoto;
import com.company.flatmate.service.ApartmentService;
import com.company.flatmate.util.mapper.ApartmentFeedbackMapper;
import com.company.flatmate.util.mapper.ApartmentPhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ApartmentController {

    private ApartmentService service;

    @Autowired
    public ApartmentController(ApartmentService service) {
        this.service = service;
    }

    @PostMapping(value = "/apartment")
    public HttpStatus addApartment(@RequestBody Apartment apartment) {
        service.save(apartment);
        return HttpStatus.OK;
    }

    @GetMapping("/apartment_feedback")
    public String getApartmentFeedback() {
        ApartmentFeedback feedback = new ApartmentFeedback();
        feedback.setApartmentId(UUID.randomUUID());
        feedback.setAuthorId(UUID.randomUUID());
        feedback.setValue(5);

        ApartmentFeedbackDto dto = ApartmentFeedbackMapper.INSTANCE.feedbackToDto(feedback);

        return dto.toString();
    }

    @GetMapping("/apartment")
    public String getApartment() {
        Apartment apartment = new Apartment();
        apartment.setId(UUID.fromString("400db01e-3999-11ec-8d3d-0242ac130003"));
        apartment.setLocation(new Point(10, 10));
        service.save(apartment);
        return null;
    }

}
