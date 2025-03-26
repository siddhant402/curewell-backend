package com.siddhant.cure_well.rest.api.service;

import com.siddhant.cure_well.rest.api.entity.Doctor;
import com.siddhant.cure_well.rest.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Integer doctorId) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);
        return optionalDoctor.orElse(null);
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Doctor doctor) {
        Optional<Doctor> existingDoctor = doctorRepository.findById(doctor.getDoctorId());
        if (existingDoctor.isPresent()) {
            return doctorRepository.save(doctor);
        }
        return null; // Consider throwing an exception if doctor not found
    }

    public void deleteDoctor(Integer id) {
        doctorRepository.deleteById(id);
    }
}