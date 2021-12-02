package com.company.flatmate.repository;

import com.company.flatmate.entity.ApartmentPhoto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApartmentPhotoRepository extends CrudRepository<ApartmentPhoto, UUID> {

}
