package com.company.flatmate.service;

import com.company.flatmate.entity.Renter;
import com.company.flatmate.repository.RenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenterService {

    private RenterRepository repository;

    RenterService(RenterRepository repository) {
        this.repository = repository;
    }

    public void save(Renter renter) {
        repository.save(renter);
    }

    public List<Renter> getRenters(){
        return repository.findAll();
    }


}
