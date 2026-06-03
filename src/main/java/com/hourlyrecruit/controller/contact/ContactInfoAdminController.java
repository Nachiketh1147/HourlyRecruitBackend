package com.hourlyrecruit.controller.contact;

import com.hourlyrecruit.model.ContactInfo;
import com.hourlyrecruit.service.ContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/contact-info")
public class ContactInfoAdminController {

    @Autowired
    private ContactInfoService service;

    @PostMapping
    public ResponseEntity<ContactInfo> create(
            @RequestBody ContactInfo info
    ) {
        return ResponseEntity.ok(service.create(info));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactInfo> update(
            @PathVariable Long id,
            @RequestBody ContactInfo info
    ) {
        return ResponseEntity.ok(service.update(id, info));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(service.delete(id));
    }

}