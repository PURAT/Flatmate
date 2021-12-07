package com.company.flatmate.service;

import com.company.flatmate.dto.ApartmentDto;
import com.company.flatmate.entity.Apartment;
import com.company.flatmate.repository.ApartmentRepository;
import com.company.flatmate.util.mapper.ApartmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class ApartmentService {

    private final ApartmentRepository repository;
    private final ApartmentMapper mapper;


    public ApartmentDto findById(@Nonnull UUID id) {
        return repository.findById(id).stream()
                .map(mapper::apartmentToDto).findFirst().get();
    }

    public List<ApartmentDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::apartmentToDto)
                .collect(Collectors.toList());
    }

    public List<ApartmentDto> findAllByActive(boolean active) {
        return repository.findAllByActive(active).stream()
                .map(mapper::apartmentToDto)
                .collect(Collectors.toList());
    }

    public List<ApartmentDto> findAllByPriceBetween(double min, double max) {
        return repository.findAllByPriceBetweenAndActive(min, max, true).stream()
                .map(mapper::apartmentToDto)
                .collect(Collectors.toList());
    }

    public List<ApartmentDto> findAllByLodgerCount(int count) {
        return repository.findAllByLodgerCountAndActive(count, true).stream()
                .map(mapper::apartmentToDto)
                .collect(Collectors.toList());
    }

    public List<ApartmentDto> findAllByRoomsCount(int count) {
        return repository.findAllByRoomsCountAndActive(count, true).stream()
                .map(mapper::apartmentToDto)
                .collect(Collectors.toList());
    }

    public UUID save(ApartmentDto apartment) {
        return repository.save(mapper.dtoToApartment(apartment)).getId();
    }

    public void deleteAllByActive(boolean active) {
        repository.deleteAllByActive(active);
    }

    public void deleteAllByDateBefore(@Nonnull OffsetDateTime date) {
        repository.deleteAllByPublicationDateBefore(date);
    }

    public void deleteById(@Nonnull UUID id) {
        repository.deleteById(id);
    }
}
