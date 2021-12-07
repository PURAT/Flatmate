package com.company.flatmate.dto;

import com.company.flatmate.entity.Apartment;
import com.company.flatmate.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class LandlordDto {

    @JsonIgnore
    private UUID id;

    @JsonProperty("apartment_id")
    private UUID apartmentId;

    @JsonProperty("user_id")
    private UUID userId;
}
