package com.company.flatmate.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ApartmentFeedbackDto {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("value")
    private Integer value;

    @JsonProperty("feedback")
    private String feedback;

    @JsonProperty("apartmentId")
    private UUID apartmentId;

//    @JsonProperty("authorId")
@JsonIgnore
private UUID authorId;
}
