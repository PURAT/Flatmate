package com.company.flatmate.util.mapper;

import com.company.flatmate.dto.RenterFeedbackDto;
import com.company.flatmate.entity.RenterFeedback;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RenterFeedbackMapper {
    RenterFeedbackDto renterFeedbackToDto(RenterFeedback renterFeedback);

    RenterFeedback dtoToRenterFeedback(RenterFeedbackDto renterFeedbackDto);
}
