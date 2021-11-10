package com.company.flatmate.service;

import com.company.flatmate.entity.Apartment;
import com.company.flatmate.entity.ApartmentFeedback;
import com.company.flatmate.repository.ApartmentFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApartmentFeedbackService {

    private ApartmentFeedbackRepository repository;

    public ApartmentFeedbackService(ApartmentFeedbackRepository repository) {
        this.repository = repository;
    }

    public void save(ApartmentFeedback feedback) {
        repository.save(feedback);
    }
}
