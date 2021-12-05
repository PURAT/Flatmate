package com.company.flatmate.service;

import com.company.flatmate.dto.ApartmentPhotoDto;
import com.company.flatmate.entity.ApartmentPhoto;
import com.company.flatmate.repository.ApartmentPhotoRepository;
import com.company.flatmate.util.mapper.ApartmentPhotoMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class ApartmentPhotoService {

    private final ApartmentPhotoRepository repository;
    private final ApartmentPhotoMapper mapper;

    public List<ApartmentPhotoDto> findAllByApartmentId(@Nonnull UUID id) {
        return repository.findAllByApartmentId(id).stream()
                .map(mapper::photoToDto)
                .collect(Collectors.toList());
    }

    public void save(ApartmentPhotoDto photo) {
        repository.save(mapper.dtoToPhoto(photo));
    }
}
