package com.siddhant.cure_well.rest.api.controller;
import com.siddhant.cure_well.rest.api.entity.Specialization;
import com.siddhant.cure_well.rest.api.service.SpecializationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SpecializationController {

    private final SpecializationService specializationService;

    @Autowired
    public SpecializationController(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @GetMapping("/specialization")
    public ResponseEntity<List<Specialization>> getAllSpecializations() {
        try {
            List<Specialization> specializations = specializationService.getAllSpecializations();
            return new ResponseEntity<>(specializations, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/specialization")
    public ResponseEntity<Specialization> addSpecialization(@Valid @RequestBody Specialization specialization) {
        try {
            Specialization newSpecialization = specializationService.addSpecialization(specialization);
            return new ResponseEntity<>(newSpecialization, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
