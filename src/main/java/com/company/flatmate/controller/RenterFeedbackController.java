package com.company.flatmate.controller;

import com.company.flatmate.entity.RenterFeedback;
import com.company.flatmate.service.RenterFeedbackService;
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
@Tag(name="renter feedback", description="Отзывы о жильце")
public class RenterFeedbackController {

    private final RenterFeedbackService renterFeedbackService;

    public RenterFeedbackController(RenterFeedbackService renterFeedbackService) {
        this.renterFeedbackService = renterFeedbackService;
    }

    @Operation(
            summary = "Отправка отзыва о жильце",
            description = "Позволяет отправить отзыв о жильце"
    )
    @PostMapping(
            value = "/renter/feedback", consumes = "application/json", produces = "application/json")
    public RenterFeedback addRenterFeedback(@RequestBody RenterFeedback renterFeedback) throws Exception {
        renterFeedbackService.save(renterFeedback);
        return renterFeedback;
    }

    @Operation(
            summary = "Получение отзывов о жильце",
            description = "Позволяет получить отзывы о жильце"
    )
    @GetMapping(
            value = "/renter/feedback")
    public List<RenterFeedback> getRenterFeedbacks() throws Exception {
        return renterFeedbackService.getRenterFeedbacks();
    }
}