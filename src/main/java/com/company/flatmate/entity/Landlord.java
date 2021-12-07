package com.company.flatmate.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name="landlord")
public class Landlord {

    @Column(name = "landlord_id")
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

//    @OneToOne
//    @JoinColumn(name = "apartment_id", nullable = false)
//    private Apartment apartment;

    @Column(name = "apartment_id", nullable = false)
    private UUID apartmentId;

//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;

    @Column(name = "user_id", nullable = false)
    private UUID userId;
}
