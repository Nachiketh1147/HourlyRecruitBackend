package com.hourlyrecruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hourlyrecruit.model.StartupHighlightCard;

@Repository
public interface StartupHighlightCardRepository
        extends JpaRepository<StartupHighlightCard, Long> {
} 