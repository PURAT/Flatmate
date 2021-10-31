package com.company.flatmate.service;

import com.company.flatmate.entity.RenterFeedback;
import com.company.flatmate.repository.RenterFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenterFeedbackService {

    private RenterFeedbackRepository repository;

    @Autowired
    RenterFeedbackService(RenterFeedbackRepository repository) {
        this.repository = repository;
    }

    public void save(RenterFeedback renterFeedback) {
        repository.save(renterFeedback);
    }

    public List<RenterFeedback> getRenterFeedbacks(){
        return repository.findAll();
    }


}
