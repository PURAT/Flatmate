package com.company.flatmate.dto;

import com.company.flatmate.entity.ApartmentFeedback;
import com.company.flatmate.entity.ApartmentPhoto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ApartmentDto {
    private UUID id;

    private Integer roomsCount;

    private Integer lodgerCount;

    private String address;

    private Point location;

    private List<ApartmentPhoto> photos;

    private List<ApartmentFeedback> feedbacks;

    private Double price;

    private OffsetDateTime publicationDate = OffsetDateTime.now();

    private boolean active;

}
