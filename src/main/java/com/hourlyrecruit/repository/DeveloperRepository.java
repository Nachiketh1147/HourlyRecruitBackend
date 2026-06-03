package com.hourlyrecruit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hourlyrecruit.model.Developer;
import com.hourlyrecruit.model.DeveloperCategory;
import com.hourlyrecruit.model.DeveloperStatus;
import com.hourlyrecruit.model.User;

public interface DeveloperRepository
        extends JpaRepository<Developer, Long> {
    Optional<Developer> findByUser(User user);
    boolean existsByUser(User user);
    List<Developer> findByCategory(DeveloperCategory category);
    List<Developer> findByStatus(DeveloperStatus status);
    long countByStatus(DeveloperStatus status);

}