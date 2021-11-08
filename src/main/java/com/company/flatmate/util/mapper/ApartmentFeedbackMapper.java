package com.company.flatmate.util.mapper;

import com.company.flatmate.dto.ApartmentFeedbackDto;
import com.company.flatmate.entity.ApartmentFeedback;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApartmentFeedbackMapper {
    ApartmentFeedbackDto feedbackToDto(ApartmentFeedback feedback);

    ApartmentFeedback dtoToFeedback(ApartmentFeedbackDto feedbackDto);
}
