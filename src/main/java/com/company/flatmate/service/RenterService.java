package com.company.flatmate.service;

import com.company.flatmate.dto.RenterDto;
import com.company.flatmate.repository.RenterRepository;
import com.company.flatmate.util.mapper.RenterMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RenterService {

    private RenterRepository repository;
    private final RenterMapper mapper;


    public List<RenterDto> getRenters(){
        return mapper.renterListToDtoList(repository.findAll());
    }

    public List<RenterDto> findAllByActive(boolean active){
        return mapper.renterListToDtoList(repository.findAllByActive(active));
    }

    public RenterDto findById(@Nonnull UUID id){
        return mapper.renterToDto(repository.findById(id).get());
    }

    public List<RenterDto> findAllByMaxPriceBetween(double min, double max){
        return mapper.renterListToDtoList(repository.findAllByMaxPriceBetweenAndActive(min, max, true));
    }

    public void save(RenterDto renter) {
        repository.save(mapper.dtoToRenter(renter));
    }

    public void deleteById(@Nonnull UUID id){
        repository.deleteById(id);
    }
}
