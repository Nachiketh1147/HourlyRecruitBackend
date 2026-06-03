package com.hourlyrecruit.service;

import com.hourlyrecruit.dto.UserResponseDTO;
import com.hourlyrecruit.model.User;
import com.hourlyrecruit.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public UserResponseDTO getUserProfile(String email) {

        User user = userRepo.findByEmail(email) 
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());

        return dto;
    }
}