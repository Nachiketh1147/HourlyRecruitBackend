package com.hourlyrecruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hourlyrecruit.dto.DeveloperRequestDTO;
import com.hourlyrecruit.model.Developer;
import com.hourlyrecruit.model.DeveloperCategory;
import com.hourlyrecruit.model.DeveloperStatus;
import com.hourlyrecruit.model.Role;
import com.hourlyrecruit.model.User;
import com.hourlyrecruit.repository.DeveloperRepository;
import com.hourlyrecruit.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private UserRepository userRepository;

    // CREATE

    public Developer createProfile(
            DeveloperRequestDTO dto,
            String email
    ) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        if (developerRepository.existsByUser(user)) {
            throw new RuntimeException(
                    "Developer profile already exists. Use update profile instead."
            );
        }

        Developer developer = new Developer();

        developer.setUser(user);

        developer.setFullName(dto.getFullName());
        developer.setDesignation(dto.getDesignation());
        developer.setExperience(dto.getExperience());
        developer.setSkills(dto.getSkills());
        developer.setHourlyRate(dto.getHourlyRate());
        developer.setProfileImage(dto.getProfileImage());
        developer.setResumeUrl(dto.getResumeUrl());
        developer.setGithubUrl(dto.getGithubUrl());
        developer.setLinkedinUrl(dto.getLinkedinUrl());
        developer.setCategory(dto.getCategory());

        // Status enum
        developer.setStatus(DeveloperStatus.AVAILABLE); 

        user.setRole(Role.ROLE_DEVELOPER);

        userRepository.save(user);

        return developerRepository.save(developer);
    }

    // GET MY PROFILE

    public Developer getDeveloperByUserEmail(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        return developerRepository.findByUser(user)
                .orElseThrow(() ->
                        new RuntimeException("Developer profile not found"));
    }
    // UPDATE

    public Developer updateDeveloper(
            DeveloperRequestDTO dto,
            String email
    ) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Developer developer = developerRepository.findByUser(user)
                .orElseThrow(() ->
                        new RuntimeException("Developer profile not found"));

        developer.setFullName(dto.getFullName());
        developer.setDesignation(dto.getDesignation());
        developer.setExperience(dto.getExperience());
        developer.setSkills(dto.getSkills());
        developer.setHourlyRate(dto.getHourlyRate());
        developer.setProfileImage(dto.getProfileImage());
        developer.setResumeUrl(dto.getResumeUrl());
        developer.setGithubUrl(dto.getGithubUrl());
        developer.setLinkedinUrl(dto.getLinkedinUrl());
        developer.setCategory(dto.getCategory());

       
        return developerRepository.save(developer); 
    }
    // ADMIN

    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    public Developer getDeveloperById(Long id) {
        return developerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Developer not found"));
    }

    public List<Developer> getDevelopersByCategory(
            DeveloperCategory category
    ) {
        return developerRepository.findByCategory(category);
    }

    @Transactional
    public void deleteDeveloper(Long id) {

        Developer developer = developerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Developer not found"));

        User user = developer.getUser();

        // Break relationship
        user.setDeveloper(null);

        // Optional: revert role
        user.setRole(Role.ROLE_USER);

        userRepository.save(user);

        developerRepository.delete(developer);
    }

    // HIRE

    public Developer hireDeveloper(Long id) {

        Developer developer = developerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Developer not found"));

        developer.setStatus(DeveloperStatus.HIRED);
 
        return developerRepository.save(developer);
    }
    public long getTotalDevelopers() {
        return developerRepository.count();
    }
}