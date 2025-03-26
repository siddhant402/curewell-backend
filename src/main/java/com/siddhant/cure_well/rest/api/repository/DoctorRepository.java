package com.siddhant.cure_well.rest.api.repository;

import com.siddhant.cure_well.rest.api.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}