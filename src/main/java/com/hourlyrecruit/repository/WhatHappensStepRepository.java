package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.WhatHappensStep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhatHappensStepRepository
        extends JpaRepository<WhatHappensStep, Long> {

    List<WhatHappensStep> findBySectionIdOrderByStepNumberAsc(Long sectionId);
}