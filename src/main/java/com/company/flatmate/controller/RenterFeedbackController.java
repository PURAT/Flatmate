package com.company.flatmate.controller;

import com.company.flatmate.entity.RenterFeedback;
import com.company.flatmate.service.RenterFeedbackService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SecurityRequirement(name = "flatmateapi")
public class RenterFeedbackController {

    private final RenterFeedbackService renterFeedbackService;

    public RenterFeedbackController(RenterFeedbackService renterFeedbackService) {
        this.renterFeedbackService = renterFeedbackService;
    }

    @PostMapping(
            value = "/renter/feedback", consumes = "application/json", produces = "application/json")
    public RenterFeedback addRenterFeedback(@RequestBody RenterFeedback renterFeedback) throws Exception {
        renterFeedbackService.save(renterFeedback);
        return renterFeedback;
    }

    @GetMapping(
            value = "/renter/feedback")
    public List<RenterFeedback> getRenterFeedbacks() throws Exception {
        return renterFeedbackService.getRenterFeedbacks();
    }
}