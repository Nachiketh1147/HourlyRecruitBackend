package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.WhatHappensSection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhatHappensSectionRepository
        extends JpaRepository<WhatHappensSection, Long> {
}