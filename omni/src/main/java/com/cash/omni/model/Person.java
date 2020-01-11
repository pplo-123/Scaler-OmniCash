package com.cash.omni.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public abstract class Person extends Auditable {

    @Getter
    @Setter
    @NotBlank
    private String name;

    @Getter
    @Setter
    @NotBlank
    private String phoneNumber;

    @Getter
    @Setter
    @NotBlank
    private String password;

    @Getter
    @Setter
    @NotBlank
    @Email
    private String email;

    @Getter
    @Setter
    private String imageURL;
}
