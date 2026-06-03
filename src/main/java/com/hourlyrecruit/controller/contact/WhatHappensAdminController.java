package com.hourlyrecruit.controller.contact;

import com.hourlyrecruit.model.WhatHappensSection;
import com.hourlyrecruit.model.WhatHappensStep;
import com.hourlyrecruit.service.WhatHappensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/what-happens")
public class WhatHappensAdminController {

    @Autowired
    private WhatHappensService service;

    // SECTION CRUD

    @PostMapping("/section")
    public WhatHappensSection createSection(
            @RequestBody WhatHappensSection section
    ) {
        return service.createSection(section);
    }

    @GetMapping("/section")
    public List<WhatHappensSection> getAllSections() {
        return service.getAllSections();
    }

    @PutMapping("/section/{id}")
    public WhatHappensSection updateSection(
            @PathVariable Long id,
            @RequestBody WhatHappensSection section
    ) {
        return service.updateSection(id, section);
    }

    @DeleteMapping("/section/{id}")
    public void deleteSection(@PathVariable Long id) {
        service.deleteSection(id);
    }

    // STEP CRUD

    @PostMapping("/step")
    public WhatHappensStep createStep(
            @RequestBody WhatHappensStep step
    ) {
        return service.createStep(step);
    }

    @GetMapping("/step/{sectionId}")
    public List<WhatHappensStep> getSteps(
            @PathVariable Long sectionId
    ) {
        return service.getStepsBySection(sectionId);
    }

    @PutMapping("/step/{id}")
    public WhatHappensStep updateStep(
            @PathVariable Long id,
            @RequestBody WhatHappensStep step
    ) {
        return service.updateStep(id, step);
    }

    @DeleteMapping("/step/{id}")
    public void deleteStep(@PathVariable Long id) {
        service.deleteStep(id);
    }
}