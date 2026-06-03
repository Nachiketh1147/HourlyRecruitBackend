package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.StartTodaySection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StartTodayRepository extends JpaRepository<StartTodaySection, Long> {
}