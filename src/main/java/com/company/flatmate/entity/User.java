package com.company.flatmate.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name="user_t")
public class User {

    @Column(name = "user_id")
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID userId;

    @Column(name="username", nullable = false)
    private String username;

    @Column(name="firstname", nullable = false)
    private String firstname;

    @Column(name="city")
    private String city;

    @Column(name="email")
    private String email;

    @OneToMany(targetEntity = Renter.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_id"))
    private List<Renter> renters;

    @OneToMany(targetEntity = Landlord.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_id"))
    private List<Landlord> landlords;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    @Column(name="photo", columnDefinition = "bytea")
    private byte[]photo;
}