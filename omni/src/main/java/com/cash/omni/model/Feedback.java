package com.cash.omni.model;

import com.cash.omni.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback extends Auditable{

    @Getter @Setter @Column(length = Constants.MAX_FEEDBACK_LENGTH)
    private String content;

    @Getter @Setter
    private int stars;

    @Getter @Setter
    private Outlet outlet;

    @Getter @Setter
    private Person feedBacker;
}
