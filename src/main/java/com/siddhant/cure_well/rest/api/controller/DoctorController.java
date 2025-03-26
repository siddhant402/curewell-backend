package com.siddhant.cure_well.rest.api.controller;

import com.siddhant.cure_well.rest.api.entity.Doctor;
import com.siddhant.cure_well.rest.api.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin(origins = "*")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody Doctor doctor) {
        try {
            Doctor newDoctor = doctorService.addDoctor(doctor);
            return new ResponseEntity<>(newDoctor, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        try {
            List<Doctor> doctors = doctorService.getAllDoctors();
            return new ResponseEntity<>(doctors, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}") // Corrected path and parameter name
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Integer id) { // Corrected parameter name
        try {
            Doctor doctor = doctorService.getDoctorById(id);

            if (doctor != null) {
                return ResponseEntity.ok(doctor);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Integer id, @Valid @RequestBody Doctor doctor) {
        try {
            doctor.setDoctorId(id);
            Doctor updatedDoctor = doctorService.updateDoctor(doctor);
            if (updatedDoctor != null) {
                return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Integer id) {
        try {
            doctorService.deleteDoctor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}