package com.hourlyrecruit.service;

import com.hourlyrecruit.model.WhatHappensSection;
import com.hourlyrecruit.model.WhatHappensStep;
import com.hourlyrecruit.repository.WhatHappensSectionRepository;
import com.hourlyrecruit.repository.WhatHappensStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WhatHappensService {

    @Autowired
    private WhatHappensSectionRepository sectionRepository;

    @Autowired
    private WhatHappensStepRepository stepRepository;

    // SECTION CRUD

    public WhatHappensSection createSection(
            WhatHappensSection section
    ) {
        return sectionRepository.save(section);
    }

    public List<WhatHappensSection> getAllSections() {
        return sectionRepository.findAll();
    }

    public WhatHappensSection updateSection(
            Long id,
            WhatHappensSection updated
    ) {
        updated.setId(id);
        return sectionRepository.save(updated);
    }

    public void deleteSection(Long id) {
        sectionRepository.deleteById(id);
    }

    // STEP CRUD

    public WhatHappensStep createStep(
            WhatHappensStep step
    ) {
        return stepRepository.save(step);
    }

    public List<WhatHappensStep> getStepsBySection(
            Long sectionId
    ) {
        return stepRepository
                .findBySectionIdOrderByStepNumberAsc(sectionId);
    }

    public WhatHappensStep updateStep(
            Long id,
            WhatHappensStep updated
    ) {
        updated.setId(id);
        return stepRepository.save(updated);
    }

    public void deleteStep(Long id) {
        stepRepository.deleteById(id);
    }
}