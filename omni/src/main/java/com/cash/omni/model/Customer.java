package com.cash.omni.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer extends Person {

    @Getter
    @Setter
    @NotNull
    boolean isVerified = false;

    //@Getter
    //@Setter
    //GoogleMap curr_locn;

    @Getter
    @Setter
    @OneToMany(mappedBy = "customer")
    private List<Transaction> transactionList;


    @Getter
    @Setter
    @OneToMany(mappedBy = "customer")
    private List<Feedback> feedbackList;
}
