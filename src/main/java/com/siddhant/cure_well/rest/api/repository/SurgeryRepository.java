package com.siddhant.cure_well.rest.api.repository;

import com.siddhant.cure_well.rest.api.entity.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface SurgeryRepository extends JpaRepository<Surgery, Integer> {
    List<Surgery> findBySurgeryDate(LocalDate surgeryDate);
}