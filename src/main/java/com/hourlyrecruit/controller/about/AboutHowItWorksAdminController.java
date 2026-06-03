package com.hourlyrecruit.controller.about;

import com.hourlyrecruit.model.*;
import com.hourlyrecruit.service.AboutHowItWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/about/how-it-works")
public class AboutHowItWorksAdminController {

    @Autowired
    private AboutHowItWorksService service;

    // SECTION

    @PostMapping("/section")
    public AboutHowItWorksSection createSection(
            @RequestBody AboutHowItWorksSection section
    ) {
        return service.createSection(section);
    }

    @PutMapping("/section/{id}")
    public AboutHowItWorksSection updateSection(
            @PathVariable Long id,
            @RequestBody AboutHowItWorksSection section
    ) {
        return service.updateSection(id, section);
    }

    @DeleteMapping("/section/{id}")
    public void deleteSection(
            @PathVariable Long id
    ) {
        service.deleteSection(id);
    }

    // STEP

    @PostMapping("/step")
    public AboutHowItWorksStep createStep(
            @RequestBody AboutHowItWorksStep step
    ) {
        return service.createStep(step);
    }

    @PutMapping("/step/{id}")
    public AboutHowItWorksStep updateStep(
            @PathVariable Long id,
            @RequestBody AboutHowItWorksStep step
    ) {
        return service.updateStep(id, step);
    }

    @DeleteMapping("/step/{id}")
    public void deleteStep(
            @PathVariable Long id
    ) {
        service.deleteStep(id);
    }
}