package com.hourlyrecruit.controller.hiredeveloper;

import com.hourlyrecruit.model.StartTodaySection;
import com.hourlyrecruit.service.StartTodayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/start-today")
public class StartTodayAdminController {

    @Autowired
    private StartTodayService service;

    // CREATE
    @PostMapping
    public ResponseEntity<StartTodaySection> create(
            @RequestBody StartTodaySection section
    ) {
        return ResponseEntity.ok(service.create(section));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<StartTodaySection> update(
            @PathVariable Long id,
            @RequestBody StartTodaySection section
    ) {
        return ResponseEntity.ok(
                service.update(id, section)
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.delete(id)
        );
    }
}