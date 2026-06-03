package com.hourlyrecruit.controller.hiredeveloper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hourlyrecruit.model.Developer;
import com.hourlyrecruit.model.DeveloperCategory;
import com.hourlyrecruit.service.DeveloperService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private DeveloperService developerService;
	@GetMapping("/developers/all")
    public ResponseEntity<List<Developer>> getAllDevelopers() {
		return ResponseEntity.ok(developerService.getAllDevelopers());
    }

    @GetMapping("/developer/{id}")
    public ResponseEntity<Developer> getDeveloperById(@PathVariable Long id) {
    	return ResponseEntity.ok(developerService.getDeveloperById(id));   
    }
    @PutMapping("/hire/{id}")
    public ResponseEntity<Developer> hireDeveloper(@PathVariable Long id) {
    	return ResponseEntity.ok(developerService.hireDeveloper(id)); 
    }
    @GetMapping("/developers/category/{category}")
    public ResponseEntity<List<Developer>> getByCategory(@PathVariable DeveloperCategory category) {
    	return ResponseEntity.ok(developerService.getDevelopersByCategory(category)); 
    }
    @DeleteMapping("/developers/{id}")
    public ResponseEntity<String> deleteDeveloper(@PathVariable Long id) {
    	developerService.deleteDeveloper(id);
    	return ResponseEntity.ok("Developer deleted successfully");
    }

}
