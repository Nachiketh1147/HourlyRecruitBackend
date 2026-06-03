package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.LetsBuildTogether;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetsBuildTogetherRepository
        extends JpaRepository<LetsBuildTogether, Long> {
}