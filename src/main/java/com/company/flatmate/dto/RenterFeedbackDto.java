package com.company.flatmate.dto;

import com.company.flatmate.entity.Renter;
import com.company.flatmate.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class RenterFeedbackDto {
    @JsonIgnore
    private UUID renterFeedbackId;

    @JsonProperty("value")
    private int value;

    @JsonProperty("feedback")
    private String feedback;

    @JsonProperty("renter")
    private Renter renter;

    @JsonProperty("author")
    private User author;
}
