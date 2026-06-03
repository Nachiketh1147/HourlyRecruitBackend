package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.ProcessStep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcessStepRepository
        extends JpaRepository<ProcessStep, Long> {

    List<ProcessStep> findBySectionIdOrderByStepNumberAsc(Long sectionId);
}