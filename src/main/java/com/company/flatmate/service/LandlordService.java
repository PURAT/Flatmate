package com.company.flatmate.service;

import com.company.flatmate.dto.LandlordDto;
import com.company.flatmate.entity.Landlord;
import com.company.flatmate.repository.LandlordRepository;
import com.company.flatmate.util.mapper.ApartmentMapper;
import com.company.flatmate.util.mapper.LandlordMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LandlordService {

    private LandlordRepository repository;
    private final LandlordMapper mapper;


    public void save(LandlordDto landlord) {
        repository.save(mapper.dtoToLandlord(landlord));
    }

    public LandlordDto findById(@Nonnull UUID id){
        return repository.findById(id).stream()
                .map(mapper::landlordToDto).findFirst().get();//TODO
    }
}
