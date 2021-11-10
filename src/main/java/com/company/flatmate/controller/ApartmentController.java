package com.company.flatmate.controller;

import com.company.flatmate.dto.ApartmentFeedbackDto;
import com.company.flatmate.entity.Apartment;
import com.company.flatmate.entity.ApartmentFeedback;
import com.company.flatmate.service.ApartmentService;
import com.company.flatmate.util.mapper.ApartmentFeedbackMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@SecurityRequirement(name = "flatmateapi")
@Tag(name="apartment", description="Операции с квартирой")
public class ApartmentController {

    private ApartmentFeedbackMapper apartmentFeedbackMapper;

    private ApartmentService service;

    @Autowired
    public ApartmentController(ApartmentService service, ApartmentFeedbackMapper mapper) {
        this.service = service;
        this.apartmentFeedbackMapper = mapper;
    }

    @Operation(
            summary = "Создание квартиры",
            description = "Позволяет создать квартиру"
    )
    @PostMapping(value = "/apartment")
    public HttpStatus addApartment(@RequestBody Apartment apartment) {
        service.save(apartment);
        return HttpStatus.OK;
    }

    @Operation(
            summary = "Получение отзывов о квартире",
            description = "Позволяет получить отзывы о квартире"
    )
    @GetMapping("/apartment/feedback")
    public String getApartmentFeedback() {
        ApartmentFeedback feedback = new ApartmentFeedback();
        feedback.setApartmentId(UUID.randomUUID());
        feedback.setAuthorId(UUID.randomUUID());
        feedback.setValue(5);

        ApartmentFeedbackDto dto = apartmentFeedbackMapper.feedbackToDto(feedback);

        return dto.toString();
    }

    @Operation(
            summary = "Получение квартир",
            description = "Позволяет получить квартиры"
    )
    @GetMapping("/apartment")
    public String getApartment() {
        Apartment apartment = new Apartment();
        apartment.setId(UUID.fromString("400db01e-3999-11ec-8d3d-0242ac130003"));
        apartment.setLocation(new Point(10.565, 10.987));
        service.save(apartment);
        return null;
    }

}
