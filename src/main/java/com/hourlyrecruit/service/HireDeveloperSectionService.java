package com.hourlyrecruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hourlyrecruit.dto.HireDeveloperSectionDTO;
import com.hourlyrecruit.model.DeveloperStatus;
import com.hourlyrecruit.model.HireDeveloperSection;
import com.hourlyrecruit.repository.DeveloperRepository;
import com.hourlyrecruit.repository.HireDeveloperSectionRepository;

@Service
public class HireDeveloperSectionService {
 
    @Autowired
    private HireDeveloperSectionRepository sectionRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    public HireDeveloperSection save(
            HireDeveloperSection section
    ) {
        return sectionRepository.save(section);
    }

    public List<HireDeveloperSection> getAll() {
        return sectionRepository.findAll();
    }

    public HireDeveloperSection update(
            Long id,
            HireDeveloperSection section
    ) {

        section.setId(id);

        return sectionRepository.save(section);
    }

    public void delete(Long id) {
        sectionRepository.deleteById(id);
    }

    public HireDeveloperSectionDTO getPublicSection() {

        HireDeveloperSection section =
                sectionRepository.findAll()
                        .stream()
                        .findFirst()
                        .orElseThrow(() ->
                                new RuntimeException("Hire Developer Section not found"));

        HireDeveloperSectionDTO dto =
                new HireDeveloperSectionDTO();

        dto.setId(section.getId());
        dto.setCardTitle(section.getCardTitle());
        dto.setHeading(section.getHeading());

        dto.setAvailableDevelopers(
                developerRepository.countByStatus(
                        DeveloperStatus.AVAILABLE
                )
        );

        dto.setAvailabilityText(
                section.getAvailabilityText()
        );

        return dto;
    }
}