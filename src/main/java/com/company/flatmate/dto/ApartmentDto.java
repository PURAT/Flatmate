package com.company.flatmate.dto;

import com.company.flatmate.entity.ApartmentFeedback;
import com.company.flatmate.entity.ApartmentPhoto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ApartmentDto {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("roomsCount")
    private Integer roomsCount;

    @JsonProperty("lodgerCount")
    private Integer lodgerCount;

    @JsonProperty("address")
    private String address;

    @JsonProperty("location")
    private Point location;

    @JsonProperty("photos")
    private List<ApartmentPhoto> photos;

    @JsonProperty("feedbacks")
    private List<ApartmentFeedback> feedbacks;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("date")
    private OffsetDateTime publicationDate = OffsetDateTime.now();

    @JsonProperty("active")
    private boolean active;

}
