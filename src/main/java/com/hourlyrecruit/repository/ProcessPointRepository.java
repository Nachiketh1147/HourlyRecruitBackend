package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.ProcessPoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcessPointRepository
        extends JpaRepository<ProcessPoint, Long> {

    List<ProcessPoint> findByStepId(Long stepId);
}