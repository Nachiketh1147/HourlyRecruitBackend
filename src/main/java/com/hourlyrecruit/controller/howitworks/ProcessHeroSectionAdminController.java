package com.hourlyrecruit.controller.howitworks;

import com.hourlyrecruit.model.ProcessHeroSection;
import com.hourlyrecruit.service.ProcessHeroSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/process-hero")
public class ProcessHeroSectionAdminController {

    @Autowired
    private ProcessHeroSectionService service;

    // CREATE
    @PostMapping("/create")
    public ProcessHeroSection create(
            @RequestBody ProcessHeroSection section
    ) {
        return service.create(section);
    }

    // GET ALL
    @GetMapping("/all")
    public List<ProcessHeroSection> getAll() {
        return service.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ProcessHeroSection getById(
            @PathVariable Long id
    ) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ProcessHeroSection update(
            @PathVariable Long id,
            @RequestBody ProcessHeroSection section
    ) {
        return service.update(id, section);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String delete(
            @PathVariable Long id
    ) {
        service.delete(id);
        return "Process hero deleted successfully";
    }
}