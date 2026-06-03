package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.HeroDashboardCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroDashboardCardRepository
        extends JpaRepository<HeroDashboardCard, Long> {
}