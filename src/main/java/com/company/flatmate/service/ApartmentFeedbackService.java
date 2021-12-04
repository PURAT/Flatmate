package com.company.flatmate.service;

import com.company.flatmate.dto.ApartmentFeedbackDto;
import com.company.flatmate.entity.ApartmentFeedback;
import com.company.flatmate.repository.ApartmentFeedbackRepository;
import com.company.flatmate.util.mapper.ApartmentFeedbackMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApartmentFeedbackService {

    private final ApartmentFeedbackRepository repository;
    private final ApartmentFeedbackMapper mapper;


    public List<ApartmentFeedbackDto> findAllByApartmentId(@Nonnull UUID id) {
        return repository.findAllByApartmentId(id).stream()
                .map(mapper::feedbackToDto)
                .collect(Collectors.toList());
    }

    public List<ApartmentFeedbackDto> findAllByAuthorId(@Nonnull UUID id) {
        return repository.findAllByAuthorId(id).stream()
                .map(mapper::feedbackToDto)
                .collect(Collectors.toList());
    }

    public void save(ApartmentFeedbackDto feedback) {
        repository.save(mapper.dtoToFeedback(feedback));
    }


}
