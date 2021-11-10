package com.company.flatmate.controller;

import com.company.flatmate.entity.ApartmentFeedback;
import com.company.flatmate.service.ApartmentFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apartment")
public class ApartmentFeedbackController {

    private ApartmentFeedbackService service;

    public ApartmentFeedbackController(ApartmentFeedbackService service) {
        this.service = service;
    }

    @PostMapping(value = "/feedback")
    public HttpStatus addApartmentFeedback(@RequestBody ApartmentFeedback feedback) {
        service.save(feedback);
        return HttpStatus.OK;
    }
}
