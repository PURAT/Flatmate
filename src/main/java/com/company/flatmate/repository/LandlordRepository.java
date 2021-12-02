package com.company.flatmate.repository;

import com.company.flatmate.entity.Landlord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LandlordRepository extends CrudRepository<Landlord, UUID> {
    List<Landlord> findAll();
}