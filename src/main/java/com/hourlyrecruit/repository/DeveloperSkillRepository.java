package com.hourlyrecruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hourlyrecruit.model.DeveloperSkill;

public interface DeveloperSkillRepository
        extends JpaRepository<DeveloperSkill, Long> {

    List<DeveloperSkill> findByDeveloperId(Long developerId);
}