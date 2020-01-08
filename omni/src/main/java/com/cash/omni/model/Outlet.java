package com.cash.omni.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "outlets")
public class Outlet {

    @Getter @Setter @NotBlank
    private String name;

    @Getter @Setter @NotBlank
    private String location;

    // private Location mapLocation;

    @Getter @Setter @NotNull
    private int availableCash;

    @Getter @Setter
    private boolean isAvailable;

    @Getter @Setter @NotNull
    private Person outletOwner;

    @Getter @Setter
    private List<Transaction> transactionList;

    @Getter @Setter
    private List<Feedback> feedbackList;
}
