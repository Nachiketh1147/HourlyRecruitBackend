package com.hourlyrecruit.controller.contact;

import com.hourlyrecruit.model.ContactInfo;
import com.hourlyrecruit.service.ContactInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/contact-info")
public class ContactInfoPublicController {

    @Autowired
    private ContactInfoService service;

    @GetMapping
    public ResponseEntity<List<ContactInfo>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactInfo> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id)); 
    }
}