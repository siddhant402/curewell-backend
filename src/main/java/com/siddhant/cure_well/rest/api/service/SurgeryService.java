package com.siddhant.cure_well.rest.api.service;

import com.siddhant.cure_well.rest.api.entity.Surgery;
import com.siddhant.cure_well.rest.api.repository.SurgeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SurgeryService {

    private final SurgeryRepository surgeryRepository;

    @Autowired
    public SurgeryService(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }

    public List<Surgery> getAllSurgeries() {
        return surgeryRepository.findAll();
    }

    public Surgery addSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

    public Surgery updateSurgery(Surgery surgery) {
        if (surgeryRepository.existsById(surgery.getSurgeryId())) {
            return surgeryRepository.save(surgery);
        }
        return null;
    }

    public List<Surgery> getSurgeriesByDate(LocalDate date) {
        return surgeryRepository.findBySurgeryDate(date);
    }

    public void deleteSurgery(Integer id) {
        surgeryRepository.deleteById(id);
    }

    public Surgery getSurgeryById(Integer id) {
        Optional<Surgery> optionalSurgery = surgeryRepository.findById(id);
        return optionalSurgery.orElse(null);
    }
}