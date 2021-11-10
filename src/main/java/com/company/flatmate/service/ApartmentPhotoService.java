package com.company.flatmate.service;

import com.company.flatmate.entity.Apartment;
import com.company.flatmate.entity.ApartmentPhoto;
import com.company.flatmate.repository.ApartmentPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApartmentPhotoService {

    private ApartmentPhotoRepository repository;

    public ApartmentPhotoService(ApartmentPhotoRepository repository) {
        this.repository = repository;
    }

    public void save(ApartmentPhoto photo) {
        repository.save(photo);
    }
}
