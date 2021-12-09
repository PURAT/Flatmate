package com.company.flatmate.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class RenterDto {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("max_price")
    private double maxPrice;

    @JsonIgnore
    private OffsetDateTime publicationDate = OffsetDateTime.now();

    @JsonProperty("user")
    private UUID userId; //todo ????

    @JsonProperty("active")
    private boolean active;
}
