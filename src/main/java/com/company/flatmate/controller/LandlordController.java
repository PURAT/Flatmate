package com.company.flatmate.controller;

import com.company.flatmate.entity.Landlord;
import com.company.flatmate.service.LandlordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SecurityRequirement(name = "flatmateapi")
@Tag(name="landlord", description="Операции с арендодателем")
public class LandlordController {

    private final LandlordService landlordService;

    public LandlordController(LandlordService landlordService) {
        this.landlordService = landlordService;
    }

    @Operation(
            summary = "Создание арендодателя",
            description = "Позволяет создать арендодателя"
    )
    @PostMapping(
            value = "/landlord", consumes = "application/json", produces = "application/json")
    public Landlord addUser(@RequestBody Landlord landlord) throws Exception {
        landlordService.save(landlord);
        return landlord;
    }

    @Operation(
            summary = "Получение арендодателя",
            description = "Позволяет получить арендодателя"
    )
    @GetMapping(
            value = "/landlord")
    public List<Landlord> getLandlords() throws Exception {
        return landlordService.getLandlords();
    }
}