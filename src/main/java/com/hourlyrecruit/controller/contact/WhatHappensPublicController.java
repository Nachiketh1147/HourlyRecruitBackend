package com.hourlyrecruit.controller.contact;

import com.hourlyrecruit.model.WhatHappensSection;
import com.hourlyrecruit.model.WhatHappensStep;
import com.hourlyrecruit.service.WhatHappensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/what-happens")
public class WhatHappensPublicController {

    @Autowired
    private WhatHappensService service;

    @GetMapping("/section")
    public List<WhatHappensSection> getSections() {
        return service.getAllSections();
    }

    @GetMapping("/step/{sectionId}")
    public List<WhatHappensStep> getSteps(
            @PathVariable Long sectionId
    ) {
        return service.getStepsBySection(sectionId);
    }
}