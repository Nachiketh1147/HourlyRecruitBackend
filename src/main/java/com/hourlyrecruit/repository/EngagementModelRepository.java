package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.EngagementModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EngagementModelRepository
        extends JpaRepository<EngagementModel, Long> {

    List<EngagementModel> findBySectionId(Long sectionId);
}