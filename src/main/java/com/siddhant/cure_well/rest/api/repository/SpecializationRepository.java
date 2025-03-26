package com.siddhant.cure_well.rest.api.repository;
import com.siddhant.cure_well.rest.api.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, String> {
}