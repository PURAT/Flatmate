package com.company.flatmate.dto;

import com.company.flatmate.entity.Landlord;
import com.company.flatmate.entity.Renter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class UserDto {
    @JsonIgnore
    private UUID userId;

    @JsonProperty("username")
    private String username;

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("city")
    private String city;

    @JsonProperty("email")
    private String email;

    @JsonProperty("renters")
    private List<Renter> renters;

    @JsonProperty("landlords")
    private List<Landlord> landlords;

    @JsonProperty("photo")
    private byte[]photo;
}
