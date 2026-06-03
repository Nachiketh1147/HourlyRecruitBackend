package com.hourlyrecruit.service;

import com.hourlyrecruit.model.StartTodaySection;
import com.hourlyrecruit.repository.StartTodayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StartTodayService {

    @Autowired
    private StartTodayRepository repository;

    // CREATE
    public StartTodaySection create(StartTodaySection section) {
        return repository.save(section);
    }

    // GET ALL
    public List<StartTodaySection> getAll() {
        return repository.findAll();
    }

    // GET BY ID
    public StartTodaySection getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Section Not Found"));
    }

    // UPDATE
    public StartTodaySection update(
            Long id,
            StartTodaySection updated
    ) {

        StartTodaySection existing = getById(id);
        existing.setCardTitle(updated.getCardTitle()); 

        existing.setHeading(updated.getHeading());
        existing.setSubHeading(updated.getSubHeading());

        existing.setPrimaryButtonText(updated.getPrimaryButtonText());
        existing.setPrimaryButtonTextUrl(updated.getPrimaryButtonTextUrl()); 

        existing.setSecondaryButtonText(updated.getSecondaryButtonText());
        existing.setSecondaryButtonTextUrl(updated.getSecondaryButtonTextUrl()); 

        return repository.save(existing);
    }

    // DELETE
    public String delete(Long id) {

        repository.deleteById(id);

        return "Start Today Section Deleted Successfully";
    }
}