package com.company.flatmate.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "renter_feedback")
public class RenterFeedback {

    @Column(name = "renter_feedback_id")
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "rating", nullable = false)
    private int value;

    @Column(name = "feedback")
    private String feedback;

//    @ManyToOne
//    @JoinColumn(name = "renter_id", nullable = false)
//    private Renter renterId;

    @Column(name = "renter_id")
    private UUID renterId; //TODO ???????

//    @ManyToOne
//    @JoinColumn(name = "author_id", nullable = false)
//    private User author;
}
