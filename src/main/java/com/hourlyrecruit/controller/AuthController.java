package com.hourlyrecruit.controller;

import com.hourlyrecruit.dto.AuthResponseDTO;
import com.hourlyrecruit.dto.LoginRequestDTO;
import com.hourlyrecruit.dto.OtpRequestDTO;
import com.hourlyrecruit.dto.RefreshTokenRequest;
import com.hourlyrecruit.dto.RegisterRequestDTO;
import com.hourlyrecruit.dto.VerifyOtpDTO;
import com.hourlyrecruit.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired 
    private AuthService authService;


    @PostMapping("/register/hr")
    public ResponseEntity<AuthResponseDTO> registerHR(@RequestBody RegisterRequestDTO request) {
    	return ResponseEntity.ok(authService.registerHR(request));
    } 

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO request) {
    	return ResponseEntity.ok(authService.login(request)); 
    }
    @PostMapping("/refresh")
    public ResponseEntity<AuthResponseDTO>
    refreshToken(
            @RequestBody RefreshTokenRequest request) {

        return ResponseEntity.ok(
                authService.refreshToken(
                        request.getRefreshToken()
                )
        );
    }
    @PostMapping("/send-otp")
    public ResponseEntity<String> sendOtp(
            @RequestBody OtpRequestDTO request) {

        return ResponseEntity.ok(
                authService.sendOtp(request)
        );
    }
    @PostMapping("/verify-otp")
    public ResponseEntity<AuthResponseDTO>
    verifyOtp(
            @RequestBody VerifyOtpDTO request) {

        return ResponseEntity.ok(
                authService.verifyOtp(request)
        );
    }
} 