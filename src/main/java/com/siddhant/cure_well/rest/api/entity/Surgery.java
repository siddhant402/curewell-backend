package com.siddhant.cure_well.rest.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Surgery")
public class Surgery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SurgeryID")
    private Integer surgeryId;

    @Column(name = "DoctorID")
    private Integer doctorId;

    @NotNull(message = "Surgery date is required")
    @Column(name = "SurgeryDate")
    private LocalDate surgeryDate;

    @NotNull(message = "Start time is required")
    @Column(name = "StartTime")
    private BigDecimal startTime;

    @NotNull(message = "End time is required")
    @Column(name = "EndTime")
    private BigDecimal endTime;

    @Column(name = "SurgeryCategory")
    private String surgeryCategory;

    // Constructors

    public Surgery() {
    }

    public Surgery(Integer doctorId, LocalDate surgeryDate, BigDecimal startTime, BigDecimal endTime, String surgeryCategory) {
        this.doctorId = doctorId;
        this.surgeryDate = surgeryDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.surgeryCategory = surgeryCategory;
    }

    // Getters and Setters

    public Integer getSurgeryId() {
        return surgeryId;
    }

    public void setSurgeryId(Integer surgeryId) {
        this.surgeryId = surgeryId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getSurgeryDate() {
        return surgeryDate;
    }

    public void setSurgeryDate(LocalDate surgeryDate) {
        this.surgeryDate = surgeryDate;
    }

    public BigDecimal getStartTime() {
        return startTime;
    }

    public void setStartTime(BigDecimal startTime) {
        this.startTime = startTime;
    }

    public BigDecimal getEndTime() {
        return endTime;
    }

    public void setEndTime(BigDecimal endTime) {
        this.endTime = endTime;
    }

    public String getSurgeryCategory() {
        return surgeryCategory;
    }

    public void setSurgeryCategory(String surgeryCategory) {
        this.surgeryCategory = surgeryCategory;
    }
}