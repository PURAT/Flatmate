package com.company.flatmate.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "apartment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Apartment {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "apartment_id")
    private UUID id;

    @Column(name = "rooms_count")
    private Integer roomsCount;

    @Column(name = "lodger_count")
    private Integer lodgerCount;

    @Column(name = "location", columnDefinition = "point")
    private Point location;

    @Column(name = "address")
    private String address;

    @OneToMany(targetEntity = ApartmentPhoto.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "apartment_id", foreignKey = @ForeignKey(name = "apartment_id"))
    private List<ApartmentPhoto> photos;

    @OneToMany(targetEntity = ApartmentFeedback.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "apartment_id", foreignKey = @ForeignKey(name = "apartment_id"))
    private List<ApartmentFeedback> feedbacks;

    @Column(name = "price")
    private Double price;

    @Column(name = "publication_date", columnDefinition = "timestamp with time zone")
    private OffsetDateTime publicationDate;

    @Column(name = "is_active")
    private boolean active;

}
