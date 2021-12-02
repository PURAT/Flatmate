package com.company.flatmate.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ApartmentPhotoDto {
//    @JsonProperty("apartment_photo_id")
    @JsonIgnore
    private UUID id;

    @JsonProperty("apartment_id")
    private UUID apartmentId;

    @JsonProperty("photo")
    private byte[] photo;
}
