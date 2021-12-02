package com.company.flatmate.util.mapper;

import com.company.flatmate.dto.ApartmentPhotoDto;
import com.company.flatmate.entity.ApartmentPhoto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApartmentPhotoMapper {
    ApartmentPhotoDto photoToDto(ApartmentPhoto photo);

    ApartmentPhoto dtoToPhoto(ApartmentPhotoDto photoDto);
}
