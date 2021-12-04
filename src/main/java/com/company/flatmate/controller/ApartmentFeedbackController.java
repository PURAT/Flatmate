package com.company.flatmate.controller;

import com.company.flatmate.entity.ApartmentFeedback;
import com.company.flatmate.service.ApartmentFeedbackService;
import com.company.flatmate.util.mapper.ApartmentFeedbackMapper;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apartment/feedback")
@SecurityRequirement(name = "flatmateapi")
@AllArgsConstructor
public class ApartmentFeedbackController {

    private final ApartmentFeedbackService service;
    private final ApartmentFeedbackMapper mapper;


    @PostMapping
    public HttpStatus addApartmentFeedback(@RequestBody ApartmentFeedback feedback) {
        service.save(feedback);
        return HttpStatus.OK;
    }
}
