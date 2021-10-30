package com.company.flatmate.dto;

import com.company.flatmate.entity.ApartmentFeedback;
import com.company.flatmate.entity.ApartmentPhoto;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private UUID id;

    @JsonProperty("rooms_count")
    private Integer roomsCount;

    @JsonProperty("lodger_count")
    private Integer lodgerCount;

    @JsonProperty("location")
    private Point location;

    @JsonProperty("address")
    private String address;

    @JsonProperty("photos")
    private List<ApartmentPhoto> photos;

    @JsonProperty("feedbacks")
    private List<ApartmentFeedback> feedbacks;

    @JsonProperty("price")
    private Double price;

    @JsonIgnore
    private OffsetDateTime publicationDate = OffsetDateTime.now();

    @JsonProperty("active")
    private boolean active;

}
