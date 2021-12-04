package com.company.flatmate.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ApartmentPhotoDto {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("apartmentId")
    private UUID apartmentId;

    @JsonProperty("photo")
    private byte[] photo;
}
