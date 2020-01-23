package com.cash.omni.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Getter @Setter
    private int cashAvailable;

    @Getter
    @Setter
    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private List<Transaction> transactionList;


    @Getter
    @Setter
    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private List<Feedback> feedbackList;
}
