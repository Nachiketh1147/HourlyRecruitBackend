package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.AboutTechnology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AboutTechnologyRepository
        extends JpaRepository<AboutTechnology, Long> {
 
    List<AboutTechnology> findByCategory(
            String category 
    );
}