package com.hourlyrecruit.controller.hiredeveloper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hourlyrecruit.dto.DeveloperRequestDTO;
import com.hourlyrecruit.model.Developer;
import com.hourlyrecruit.service.DeveloperService;
@RestController
@RequestMapping("/developer") 
public class DeveloperController {
	@Autowired
	private DeveloperService developerService;
    @PostMapping("/create")
    public ResponseEntity<Developer> createProfile(@RequestBody DeveloperRequestDTO dto,Authentication authentication) {
    	return ResponseEntity.ok(developerService.createProfile(dto,authentication.getName()));
    }
    @GetMapping("/me")
    public ResponseEntity<Developer> getMyProfile(Authentication auth) {
    	String email = auth.getName(); 
    	return ResponseEntity.ok(developerService.getDeveloperByUserEmail(email));  
    }

    @PutMapping("/update") 
    public ResponseEntity<Developer> updateDeveloper(@RequestBody DeveloperRequestDTO dto,Authentication auth) {
    	return ResponseEntity.ok(developerService.updateDeveloper(dto,auth.getName())); 
    }

}
 