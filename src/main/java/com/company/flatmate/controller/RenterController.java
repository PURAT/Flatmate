package com.company.flatmate.controller;

import com.company.flatmate.entity.Renter;
import com.company.flatmate.service.RenterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.List;

@RestController
@SecurityRequirement(name = "flatmateapi")
@Tag(name="renter", description="Операции с жильцом")
public class RenterController {

    private final RenterService renterService;

    public RenterController(RenterService renterService) {
        this.renterService = renterService;
    }

    @Operation(
            summary = "Создание нанимателя",
            description = "Позволяет создать нанимателя"
    )
    @PostMapping(
            value = "/renter", consumes = "application/json", produces = "application/json")
    public Renter addRenter(@RequestBody Renter renter) throws Exception {
        renter.setPublicationDate(OffsetDateTime.now());
        renterService.save(renter);
        return renter;
    }

    @Operation(
            summary = "Получение нанимателей",
            description = "Позволяет получить нанимателей"
    )
    @GetMapping(
            value = "/renter")
    public List<Renter> getRenters() throws Exception {
        return renterService.getRenters();
    }
}