package com.cash.omni.model;


import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "outlets")
public class Outlet extends Auditable {

    @Getter @Setter @NotBlank
    private String name;

    @Getter @Setter @NotBlank
    private String location;

    // private Location mapLocation;

    @Getter @Setter @NotBlank
    private String outletType;

    @Getter @Setter @NotNull
    private int availableCash;

    @Getter @Setter
    private boolean isAvailable = false;

    @Getter @Setter
    @ManyToOne
    @JsonIdentityReference
    private OutletOwner outletOwner;


    @Getter @Setter @OneToMany(mappedBy = "outlet")
    @JsonIdentityReference
    private List<Transaction> transactionList;

    @Getter @Setter @OneToMany(mappedBy = "outlet")
    @JsonIdentityReference
    private List<Feedback> feedbackList;

}
