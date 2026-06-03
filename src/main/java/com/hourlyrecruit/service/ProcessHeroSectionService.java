package com.hourlyrecruit.service;

import com.hourlyrecruit.model.ProcessHeroSection;
import com.hourlyrecruit.repository.ProcessHeroSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessHeroSectionService {

    @Autowired
    private ProcessHeroSectionRepository repository;

    // CREATE
    public ProcessHeroSection create(
            ProcessHeroSection section
    ) {
        return repository.save(section);
    }

    // GET ALL
    public List<ProcessHeroSection> getAll() {
        return repository.findAll();
    }

    // GET BY ID
    public ProcessHeroSection getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hero section not found"));
    }

    // UPDATE
    public ProcessHeroSection update(
            Long id,
            ProcessHeroSection updated
    ) {

        ProcessHeroSection existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hero section not found"));

        existing.setCardTitle(updated.getCardTitle());
        existing.setHeading(updated.getHeading());
        existing.setSubHeading(updated.getSubHeading());

        return repository.save(existing);
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }
}