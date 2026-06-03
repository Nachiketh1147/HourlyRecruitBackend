package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.AboutHowItWorksStep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AboutHowItWorksStepRepository
        extends JpaRepository<AboutHowItWorksStep, Long> {

    List<AboutHowItWorksStep> findBySectionId(Long sectionId);
}