package com.hourlyrecruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hourlyrecruit.model.ReadySection;
import com.hourlyrecruit.repository.ReadySectionRepository;

@Service
public class ReadyService {

    @Autowired
    private ReadySectionRepository repository;

    public ReadySection create(ReadySection cta) {
        return repository.save(cta);
    }

    public List<ReadySection> getAll() {
        return repository.findAll();
    }

    public ReadySection getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("CTA not found"));
    }

    public ReadySection update(Long id,
                             ReadySection updated) {

        ReadySection cta = getById(id);
        cta.setCardTitle(updated.getCardTitle());
        cta.setHeading(updated.getHeading()); 
        cta.setSubHeading(updated.getSubHeading()); 
        cta.setPrimaryButton(updated.getPrimaryButton());
        cta.setPrimaryButtonUrl(updated.getPrimaryButtonUrl());
        cta.setSecondaryButton(updated.getSecondaryButton());
        
        cta.setSecondaryButtonUrl(updated.getSecondaryButtonUrl()); 

        return repository.save(cta);
    }

    public String delete(Long id) {

        ReadySection cta = getById(id);
 
        repository.delete(cta);

        return "CTA deleted successfully";
    }
}