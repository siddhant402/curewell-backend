package com.siddhant.cure_well.rest.api.service;
import com.siddhant.cure_well.rest.api.entity.DoctorSpecialization;
import com.siddhant.cure_well.rest.api.entity.DoctorSpecializationId;
import com.siddhant.cure_well.rest.api.repository.DoctorSpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorSpecializationService {

    private final DoctorSpecializationRepository doctorSpecializationRepository;

    @Autowired
    public DoctorSpecializationService(DoctorSpecializationRepository doctorSpecializationRepository) {
        this.doctorSpecializationRepository = doctorSpecializationRepository;
    }

    public List<DoctorSpecialization> getAllDoctorSpecializations() {
        return doctorSpecializationRepository.findAll();
    }

    public DoctorSpecialization addDoctorSpecialization(DoctorSpecialization doctorSpecialization) {
        return doctorSpecializationRepository.save(doctorSpecialization);
    }

    public DoctorSpecialization updateDoctorSpecialization(DoctorSpecialization doctorSpecialization) {
        Optional<DoctorSpecialization> existingDoctorSpecialization = doctorSpecializationRepository.findById(
                new DoctorSpecializationId(doctorSpecialization.getDoctorId(), doctorSpecialization.getSpecializationCode())
        );
        if (existingDoctorSpecialization.isPresent()) {
            return doctorSpecializationRepository.save(doctorSpecialization);
        }
        return null; // Consider throwing an exception if DoctorSpecialization not found
    }

    public void deleteDoctorSpecialization(DoctorSpecializationId id) {
        doctorSpecializationRepository.deleteById(id);
    }
}