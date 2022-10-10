package com.example.POD.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="FEEDBACK")
public class Feedback {
    @Column(name="feedback_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long feedbackId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employment_id")
    private ChainEmploymentProfile chainEmploymentProfile;

    @Column
    private int rating;

    @Column
    private boolean altitude;

    @Column
    private String comment;

    @Column(name="created_date", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "schedule_id")
    private SpaOrderSchedule spaOrderSchedule;
}
