package com.hourlyrecruit.controller.contact;

import com.hourlyrecruit.model.LetsBuildTogether;
import com.hourlyrecruit.service.LetsBuildTogetherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/lets-build-together")
public class LetsBuildTogetherPublicController {

    @Autowired
    private LetsBuildTogetherService service;

    @GetMapping
    public List<LetsBuildTogether> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public LetsBuildTogether getById(
            @PathVariable Long id
    ) {
        return service.getById(id);
    }
}