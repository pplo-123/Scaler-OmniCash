package com.cash.omni.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class Location{

    @Getter @Setter @NotBlank
    private String city;

    @Getter @Setter @NotBlank
    private String state;

    @Getter @Setter @NotBlank
    private String country;

    @Getter @Setter @NotNull
    private float latitude;

    @Getter @Setter @NotNull
    private float longitude;

    @Getter @Setter @NotNull
    private int pincode;

}
