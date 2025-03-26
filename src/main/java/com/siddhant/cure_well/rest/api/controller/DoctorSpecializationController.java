package com.siddhant.cure_well.rest.api.controller;

import com.siddhant.cure_well.rest.api.entity.DoctorSpecialization;
import com.siddhant.cure_well.rest.api.entity.DoctorSpecializationId;
import com.siddhant.cure_well.rest.api.service.DoctorSpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/doctor-specializations")
@CrossOrigin(origins = "*")
public class DoctorSpecializationController {

    private final DoctorSpecializationService doctorSpecializationService;

    @Autowired
    public DoctorSpecializationController(DoctorSpecializationService doctorSpecializationService) {
        this.doctorSpecializationService = doctorSpecializationService;
    }

    @GetMapping
    public ResponseEntity<List<DoctorSpecialization>> getAllDoctorSpecializations() {
        try {
            List<DoctorSpecialization> doctorSpecializations = doctorSpecializationService.getAllDoctorSpecializations();
            return new ResponseEntity<>(doctorSpecializations, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<DoctorSpecialization> addDoctorSpecialization(@Valid @RequestBody DoctorSpecialization doctorSpecialization) {
        try {
            DoctorSpecialization newDoctorSpecialization = doctorSpecializationService.addDoctorSpecialization(doctorSpecialization);
            return new ResponseEntity<>(newDoctorSpecialization, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<DoctorSpecialization> updateDoctorSpecialization(@Valid @RequestBody DoctorSpecialization doctorSpecialization) {
        try {
            DoctorSpecialization updatedDoctorSpecialization = doctorSpecializationService.updateDoctorSpecialization(doctorSpecialization);
            if (updatedDoctorSpecialization != null) {
                return new ResponseEntity<>(updatedDoctorSpecialization, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteDoctorSpecialization(@Valid @RequestBody DoctorSpecializationId id) {
        try {
            doctorSpecializationService.deleteDoctorSpecialization(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}