package com.hourlyrecruit.controller.hiredeveloper;

import com.hourlyrecruit.model.StartTodaySection;
import com.hourlyrecruit.service.StartTodayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/start-today")
public class StartTodayPublicController {

    @Autowired
    private StartTodayService service;

    // GET ALL
    @GetMapping
    public ResponseEntity<List<StartTodaySection>> getAll() {

        return ResponseEntity.ok(
                service.getAll()
        );
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<StartTodaySection> getById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.getById(id)
        );
    }
}