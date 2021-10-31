package com.company.flatmate.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@Table(name="renter")
public class Renter {

    @Column(name = "renter_id")
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID renterId;

    @Column(name="max_price")
    private int maxPrice;

    @Column(name="publication_date", columnDefinition = "timestamp with time zone")
    private Timestamp publicationDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}