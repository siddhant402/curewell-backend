package com.siddhant.cure_well.rest.api.repository;
import com.siddhant.cure_well.rest.api.entity.DoctorSpecialization;
import com.siddhant.cure_well.rest.api.entity.DoctorSpecializationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorSpecializationRepository extends JpaRepository<DoctorSpecialization, DoctorSpecializationId> {
}