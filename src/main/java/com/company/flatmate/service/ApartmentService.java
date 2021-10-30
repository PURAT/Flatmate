package com.company.flatmate.service;

import com.company.flatmate.entity.Apartment;
import com.company.flatmate.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApartmentService {

    private ApartmentRepository repository;

    @Autowired
    public ApartmentService(ApartmentRepository repository) {
        this.repository = repository;
    }

    public void save(Apartment apartment) {
        repository.save(apartment);
    }
}
