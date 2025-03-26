package com.siddhant.cure_well.rest.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.io.Serializable;

@Entity
@Table(name = "DoctorSpecialization")
@IdClass(DoctorSpecializationId.class)
public class DoctorSpecialization {

    @Id
    @Column(name = "DoctorID")
    private Integer doctorId;

    @Id
    @Column(name = "SpecializationCode")
    private String specializationCode;

    @NotNull(message = "Specialization date is required")
    @Column(name = "SpecializationDate")
    private LocalDate specializationDate;

    // Constructors

    public DoctorSpecialization() {
    }

    public DoctorSpecialization(Integer doctorId, String specializationCode, LocalDate specializationDate) {
        this.doctorId = doctorId;
        this.specializationCode = specializationCode;
        this.specializationDate = specializationDate;
    }

    // Getters and Setters

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecializationCode() {
        return specializationCode;
    }

    public void setSpecializationCode(String specializationCode) {
        this.specializationCode = specializationCode;
    }

    public LocalDate getSpecializationDate() {
        return specializationDate;
    }

    public void setSpecializationDate(LocalDate specializationDate) {
        this.specializationDate = specializationDate;
    }
}
