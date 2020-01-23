package com.cash.omni.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "outlet_owners")
public class OutletOwner extends Person {
    @Getter
    @Setter
    @NotNull
    private boolean isVerified = false;

    @Getter
    @Setter
    @OneToMany(mappedBy = "outletOwner")
    @JsonManagedReference
    private List<Outlet> outletList;
}
