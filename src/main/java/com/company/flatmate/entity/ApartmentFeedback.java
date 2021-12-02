package com.company.flatmate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "apartment_feedback")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApartmentFeedback {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "apartment_feedback_id")
    private UUID id;

    @Column(name = "rating")
    private Integer value;

    @Column(name = "feedback", columnDefinition = "text")
    private String feedback;

    @Column(name = "apartment_id")
    private UUID apartmentId;

//    @ManyToOne
//    @JoinColumn(name = "apartment_id", nullable = false)
//    private Apartment apartment;

    @Column(name = "author_id")
    private UUID authorId;

}
