package com.siddhant.cure_well.rest.api.entity;

import java.io.Serializable;
import java.util.Objects;

public class DoctorSpecializationId implements Serializable {
    private Integer doctorId;
    private String specializationCode;

    // Constructors

    public DoctorSpecializationId() {
    }

    public DoctorSpecializationId(Integer doctorId, String specializationCode) {
        this.doctorId = doctorId;
        this.specializationCode = specializationCode;
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

    // equals and hashCode (Important for @IdClass)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorSpecializationId that = (DoctorSpecializationId) o;
        return Objects.equals(doctorId, that.doctorId) && Objects.equals(specializationCode, that.specializationCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId, specializationCode);
    }
}