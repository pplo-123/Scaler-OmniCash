package com.cash.omni.model;

import com.cash.omni.Constants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "feedback")
public class Feedback extends Auditable{

    @Getter @Setter @Column(length = Constants.MAX_FEEDBACK_LENGTH)
    private String review;

    @Getter @Setter
    private int rating;

    @Getter @Setter @ManyToOne
    private Outlet outlet;

    @Getter @Setter @ManyToOne
    private Customer customer;

    @Getter @Setter
    private Date feedbackDate = new Date();
}
