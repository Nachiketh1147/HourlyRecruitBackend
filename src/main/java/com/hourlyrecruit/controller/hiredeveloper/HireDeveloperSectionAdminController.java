package com.hourlyrecruit.controller.hiredeveloper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hourlyrecruit.dto.HireDeveloperSectionDTO;
import com.hourlyrecruit.model.HireDeveloperSection;
import com.hourlyrecruit.service.HireDeveloperSectionService;

@RestController
@RequestMapping("/admin/hire-developer-section")
public class HireDeveloperSectionAdminController {

    @Autowired
    private HireDeveloperSectionService service;

    @PostMapping
    public HireDeveloperSection create(
            @RequestBody HireDeveloperSection section
    ) {
        return service.save(section);
    }

    @GetMapping("/all")
    public List<HireDeveloperSection> getAll() { 
        return service.getAll();
    }
    @GetMapping
    public HireDeveloperSectionDTO getSection() {

        return service.getPublicSection();
    } 

    @PutMapping("/{id}")
    public HireDeveloperSection update(
            @PathVariable Long id,
            @RequestBody HireDeveloperSection section
    ) {
        return service.update(id, section);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        service.delete(id);

        return "Deleted Successfully";
    }
}