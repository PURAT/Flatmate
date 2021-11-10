package com.company.flatmate.controller;

import com.company.flatmate.entity.ApartmentFeedback;
import com.company.flatmate.service.ApartmentFeedbackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apartment")
@SecurityRequirement(name = "flatmateapi")
@Tag(name="apartment feedback", description="Отзывы о квартире")
public class ApartmentFeedbackController {

    private ApartmentFeedbackService service;

    public ApartmentFeedbackController(ApartmentFeedbackService service) {
        this.service = service;
    }

    @Operation(
            summary = "Отправка отзыва о квартире",
            description = "Позволяет отправить отзыв о квартире"
    )
    @PostMapping(value = "/feedback")
    public HttpStatus addApartmentFeedback(@RequestBody ApartmentFeedback feedback) {
        service.save(feedback);
        return HttpStatus.OK;
    }
}
