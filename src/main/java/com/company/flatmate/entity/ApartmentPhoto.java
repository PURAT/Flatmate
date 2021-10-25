package com.company.flatmate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "apartment_photo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApartmentPhoto {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "apartment_photo_id")
    private UUID id;

    @Column(name = "apartment_id")
    private UUID apartmentId;

    @Lob
    @Column(name = "photo", columnDefinition = "bytea")
    private byte[] photo;
}
