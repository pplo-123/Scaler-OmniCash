package com.cash.omni.model;




import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction extends Auditable {

    @Getter @Setter @NotNull
    private int amount;

    @Getter @Setter @NotNull
    private String transactionId;

    @Getter @Setter
    private boolean  isSuccessful;

    @Getter @Setter @ManyToOne
    @JsonBackReference
    private Outlet outlet;

    @Getter @Setter @ManyToOne
    @JsonBackReference
    private Customer customer;

    @Getter @Setter
    private Date transactionDate = new Date();



}
