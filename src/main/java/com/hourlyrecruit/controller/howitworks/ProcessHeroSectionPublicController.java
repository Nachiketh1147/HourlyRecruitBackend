package com.hourlyrecruit.controller.howitworks;

import com.hourlyrecruit.model.ProcessHeroSection;
import com.hourlyrecruit.service.ProcessHeroSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/process-hero")
public class ProcessHeroSectionPublicController {

    @Autowired
    private ProcessHeroSectionService service;

    @GetMapping("/all")
    public List<ProcessHeroSection> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ProcessHeroSection getById(
            @PathVariable Long id
    ) {
        return service.getById(id);
    }
}