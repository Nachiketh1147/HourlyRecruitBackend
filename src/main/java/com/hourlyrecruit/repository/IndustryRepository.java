package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.Industry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndustryRepository
        extends JpaRepository<Industry, Long> {
}