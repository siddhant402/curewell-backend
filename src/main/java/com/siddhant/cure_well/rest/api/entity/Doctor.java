package com.siddhant.cure_well.rest.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DoctorID")
    private Integer doctorId;

    @NotBlank(message = "Doctor name is required")
    @Column(name = "DoctorName")
    private String doctorName;

    // Constructors (You can add constructors as needed)

    public Doctor() {
    }

    public Doctor(String doctorName) {
        this.doctorName = doctorName;
    }

    // Getters and Setters

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}