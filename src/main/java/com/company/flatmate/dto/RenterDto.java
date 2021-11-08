package com.company.flatmate.dto;

import com.company.flatmate.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class RenterDto {
    @JsonIgnore
    private UUID renterId;

    @JsonProperty("max_price")
    private int maxPrice;

    @JsonIgnore
    private OffsetDateTime publicationDate = OffsetDateTime.now();

    @JsonProperty("user")
    private User user;
}
