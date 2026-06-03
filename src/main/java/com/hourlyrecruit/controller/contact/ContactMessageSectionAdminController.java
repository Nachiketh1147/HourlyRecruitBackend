package com.hourlyrecruit.controller.contact;

import com.hourlyrecruit.model.ContactMessageSection;
import com.hourlyrecruit.service.ContactMessageSectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/contact-message-section")
public class ContactMessageSectionAdminController {

    @Autowired
    private ContactMessageSectionService service;

    @PostMapping
    public ResponseEntity<ContactMessageSection> create(@RequestBody ContactMessageSection section) {
        return ResponseEntity.ok(service.create(section));
    }

    @GetMapping
    public ResponseEntity<List<ContactMessageSection>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactMessageSection> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactMessageSection> update(@PathVariable Long id,@RequestBody ContactMessageSection section) {
        return ResponseEntity.ok(service.update(id, section));
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}