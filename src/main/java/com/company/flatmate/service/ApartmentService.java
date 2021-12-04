package com.company.flatmate.service;

import com.company.flatmate.dto.ApartmentDto;
import com.company.flatmate.repository.ApartmentRepository;
import com.company.flatmate.util.mapper.ApartmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApartmentService {

    private final ApartmentRepository repository;
    private final ApartmentMapper mapper;


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

    public void save(ApartmentDto apartment) {
        repository.save(mapper.dtoToApartment(apartment));
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
