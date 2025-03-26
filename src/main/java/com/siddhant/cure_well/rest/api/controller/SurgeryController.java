package com.siddhant.cure_well.rest.api.controller;

import com.siddhant.cure_well.rest.api.entity.Surgery;
import com.siddhant.cure_well.rest.api.service.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SurgeryController {

    private final SurgeryService surgeryService;

    @Autowired
    public SurgeryController(SurgeryService surgeryService) {
        this.surgeryService = surgeryService;
    }

    @GetMapping("/surgeries")
    public ResponseEntity<List<Surgery>> getAllSurgeries() {
        List<Surgery> surgeries = surgeryService.getAllSurgeries();
        return new ResponseEntity<>(surgeries, HttpStatus.OK);
    }

    @PostMapping("/surgeries")
    public ResponseEntity<Surgery> addSurgery(@Valid @RequestBody Surgery surgery) {
        Surgery addedSurgery = surgeryService.addSurgery(surgery);
        return new ResponseEntity<>(addedSurgery, HttpStatus.CREATED);
    }

    @PutMapping("/surgeries/{id}")
    public ResponseEntity<Surgery> updateSurgery(@PathVariable Integer id, @Valid @RequestBody Surgery surgery) {
        surgery.setSurgeryId(id);
        Surgery updatedSurgery = surgeryService.updateSurgery(surgery);
        if (updatedSurgery != null) {
            return new ResponseEntity<>(updatedSurgery, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/surgeries/today")
    public ResponseEntity<List<Surgery>> getSurgeriesForToday() {
        LocalDate today = LocalDate.now();
        List<Surgery> todaysSurgeries = surgeryService.getSurgeriesByDate(today);
        return new ResponseEntity<>(todaysSurgeries, HttpStatus.OK);
    }

    @DeleteMapping("/surgeries/{id}")
    public ResponseEntity<Void> deleteSurgery(@PathVariable Integer id) {
        surgeryService.deleteSurgery(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/surgeries/{id}")
    public ResponseEntity<Surgery> getSurgeryById(@PathVariable Integer id) {
        Surgery surgery = surgeryService.getSurgeryById(id);
        if(surgery != null) {
            return ResponseEntity.ok(surgery);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}