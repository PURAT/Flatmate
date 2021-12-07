package com.company.flatmate.service;

import com.company.flatmate.dto.ApartmentDto;
import com.company.flatmate.repository.ApartmentRepository;
import com.company.flatmate.util.mapper.ApartmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class ApartmentService {

    private final ApartmentRepository repository;
    private final ApartmentMapper mapper;


    public ApartmentDto findById(@Nonnull UUID id) {
        return mapper.apartmentToDto(repository.findById(id).get());
    }

    public List<ApartmentDto> findAll() {
        return mapper.apartmentListToDtoList(repository.findAll());
    }

    public List<ApartmentDto> findAllByActive(boolean active) {
        return mapper.apartmentListToDtoList(repository.findAllByActive(active));
    }

    public List<ApartmentDto> findAllByPriceBetween(double min, double max) {
        return mapper.apartmentListToDtoList(repository.findAllByPriceBetweenAndActive(min, max, true));
    }

    public List<ApartmentDto> findAllByLodgerCount(int count) {
        return mapper.apartmentListToDtoList(repository.findAllByLodgerCountAndActive(count, true));
    }

    public List<ApartmentDto> findAllByRoomsCount(int count) {
        return mapper.apartmentListToDtoList(repository.findAllByRoomsCountAndActive(count, true));
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
