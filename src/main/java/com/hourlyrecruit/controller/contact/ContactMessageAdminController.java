package com.hourlyrecruit.controller.contact;

import com.hourlyrecruit.model.ContactMessage;
import com.hourlyrecruit.service.ContactMessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/contact-message")
public class ContactMessageAdminController {

    @Autowired
    private ContactMessageService service;

    @GetMapping
    public ResponseEntity<List<ContactMessage>> getAll() {

        return ResponseEntity.ok(
                service.getAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactMessage> getById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.getById(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.delete(id)
        );
    }
}