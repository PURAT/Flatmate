package com.company.flatmate.service;

import com.company.flatmate.dto.RenterDto;
import com.company.flatmate.repository.RenterRepository;
import com.company.flatmate.util.mapper.RenterMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RenterService {

    private RenterRepository repository;
    private final RenterMapper mapper;


    public List<RenterDto> getRenters(){
        return repository.findAll().stream()
                .map(mapper::renterToDto)
                .collect(Collectors.toList());
    }

    public List<RenterDto> findAllByActive(boolean active){
        return repository.findAllByActive(active).stream()
                .map(mapper::renterToDto)
                .collect(Collectors.toList());
    }

    public RenterDto findById(@Nonnull UUID id){
        return repository.findById(id).stream()
                .map(mapper::renterToDto).findFirst().get();
    }

    public List<RenterDto> findAllByMaxPriceBetween(double min, double max){
        return repository.findAllByMaxPriceBetweenAndActive(min, max, true).stream()
                .map(mapper::renterToDto)
                .collect(Collectors.toList());
    }

    public void save(RenterDto renter) {
        repository.save(mapper.dtoToRenter(renter));
    }

    public void deleteById(@Nonnull UUID id){
        repository.deleteById(id);
    }
}
