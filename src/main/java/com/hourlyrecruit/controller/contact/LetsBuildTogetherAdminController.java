package com.hourlyrecruit.controller.contact; 

import com.hourlyrecruit.model.LetsBuildTogether;
import com.hourlyrecruit.service.LetsBuildTogetherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/lets-build-together")
public class LetsBuildTogetherAdminController {

    @Autowired
    private LetsBuildTogetherService service;

    // CREATE
    @PostMapping
    public LetsBuildTogether create(
            @RequestBody LetsBuildTogether data
    ) {
        return service.create(data);
    }

    // GET ALL
    @GetMapping
    public List<LetsBuildTogether> getAll() {
        return service.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public LetsBuildTogether getById(
            @PathVariable Long id
    ) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public LetsBuildTogether update(
            @PathVariable Long id,
            @RequestBody LetsBuildTogether data
    ) {
        return service.update(id, data);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id
    ) {
        service.delete(id);
        return "Deleted Successfully";
    }
}