package com.siddhant.cure_well.rest.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Specialization")
public class Specialization {

    @Id
    @Column(name = "SpecializationCode")
    private String specializationCode;

    @NotBlank(message = "Specialization name is required")
    @Column(name = "SpecializationName")
    private String specializationName;

    // Constructors

    public Specialization() {
    }

    public Specialization(String specializationCode, String specializationName) {
        this.specializationCode = specializationCode;
        this.specializationName = specializationName;
    }

    // Getters and Setters

    public String getSpecializationCode() {
        return specializationCode;
    }

    public void setSpecializationCode(String specializationCode) {
        this.specializationCode = specializationCode;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }
}