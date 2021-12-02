package com.company.flatmate.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ApartmentFeedbackDto {
//    @JsonProperty("apartment_feedback_id")
    @JsonIgnore
    private UUID id;

    @JsonProperty("value")
    private Integer value;

    @JsonProperty("feedback")
    private String feedback;

    @JsonProperty("apartment_id")
    private UUID apartmentId;

    @JsonProperty("author_id")
    private UUID authorId;
}
