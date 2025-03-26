package com.siddhant.cure_well.rest.api.service;

import com.siddhant.cure_well.rest.api.entity.Specialization;
import com.siddhant.cure_well.rest.api.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationService {

    private final SpecializationRepository specializationRepository;

    @Autowired
    public SpecializationService(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    public List<Specialization> getAllSpecializations() {
        return specializationRepository.findAll();
    }

    public Specialization addSpecialization(Specialization specialization) {
        return specializationRepository.save(specialization);
    }
}