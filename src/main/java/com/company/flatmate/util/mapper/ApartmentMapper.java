package com.company.flatmate.util.mapper;

import com.company.flatmate.dto.ApartmentDto;
import com.company.flatmate.entity.Apartment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApartmentMapper {
    ApartmentMapper INSTANCE = Mappers.getMapper(ApartmentMapper.class);

    ApartmentDto apartmentToDto(Apartment apartment);

    Apartment dtoToApartment(ApartmentDto apartmentDto);
}
