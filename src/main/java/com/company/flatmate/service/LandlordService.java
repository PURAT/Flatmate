package com.company.flatmate.service;

import com.company.flatmate.entity.Landlord;
import com.company.flatmate.repository.LandlordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandlordService {

    private LandlordRepository repository;

    LandlordService(LandlordRepository repository) {
        this.repository = repository;
    }

    public void save(Landlord landlord) {
        repository.save(landlord);
    }

    public List<Landlord> getLandlords(){
        return repository.findAll();
    }

}
