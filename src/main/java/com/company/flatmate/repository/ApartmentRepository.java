package com.company.flatmate.repository;

import com.company.flatmate.entity.Apartment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApartmentRepository extends CrudRepository<Apartment, UUID> {

}
