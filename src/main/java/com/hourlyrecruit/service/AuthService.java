package com.hourlyrecruit.service;

import com.hourlyrecruit.dto.AuthResponseDTO;
import com.hourlyrecruit.dto.LoginRequestDTO;
import com.hourlyrecruit.dto.OtpRequestDTO;
import com.hourlyrecruit.dto.RegisterRequestDTO;
import com.hourlyrecruit.dto.VerifyOtpDTO;
import com.hourlyrecruit.model.Otp;
import com.hourlyrecruit.model.RefreshToken;
import com.hourlyrecruit.model.Role;
import com.hourlyrecruit.model.User;
import com.hourlyrecruit.repository.OtpRepository;
import com.hourlyrecruit.repository.RefreshTokenRepository;
import com.hourlyrecruit.repository.UserRepository;
import com.hourlyrecruit.security.JWTService;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;
	@Autowired
	private RefreshTokenRepository refreshTokenRepo;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager; 
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private OtpRepository otpRepository;
    @Autowired 
    private EmailService emailService;

    public AuthResponseDTO registerHR(
            RegisterRequestDTO request) {

        if (userRepository.existsByEmail(
                request.getEmail())) {

            throw new RuntimeException(
                    "Email already exists"
            );
        }

        User hr = new User();

 
        hr.setEmail(request.getEmail());

        hr.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );

        hr.setRole(Role.ROLE_HR);

        userRepository.save(hr);

        UserDetails userDetails =
                userDetailsService.loadUserByUsername(
                        hr.getEmail()
                );

        String accessToken =
                jwtService.generateToken(
                        userDetails
                );

        String refreshToken =
                generateRefreshToken(hr);

        return new AuthResponseDTO(
                accessToken,
                refreshToken,
                "HR registered successfully"
        );
    }
    

    public AuthResponseDTO login(LoginRequestDTO request) {
    	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() ->new RuntimeException(
                                "User not found"));
        UserDetails userDetails =userDetailsService.loadUserByUsername(request.getEmail());

        String accessToken =jwtService.generateToken(userDetails);

        String refreshToken =
                generateRefreshToken(user);

        return new AuthResponseDTO(
                accessToken,
                refreshToken,
                "Login successful");
    }
    @Transactional
    public String sendOtp(
            OtpRequestDTO request) {

        String email = request.getEmail();

        otpRepository.deleteByEmail(email);

        String otp =
                String.valueOf(
                        100000 + new Random()
                                .nextInt(900000)
                );

        Otp otpEntity = new Otp();

        otpEntity.setEmail(email);

        otpEntity.setOtp(otp);

        otpEntity.setExpiryTime(
                LocalDateTime.now().plusMinutes(5)
        );

        otpRepository.save(otpEntity);

        emailService.sendOtp(email, otp);

        return "OTP sent successfully";
    }
    @Transactional
    public AuthResponseDTO verifyOtp(
            VerifyOtpDTO request) {

        Otp otpEntity =
                otpRepository.findByEmail(
                        request.getEmail()
                ).orElseThrow(() ->
                        new RuntimeException(
                                "OTP not found"
                        )
                );

        if (!otpEntity.getOtp()
                .equals(request.getOtp())) {

            throw new RuntimeException(
                    "Invalid OTP" 
            );
        }

        if (otpEntity.getExpiryTime()
                .isBefore(LocalDateTime.now())) {

            throw new RuntimeException(
                    "OTP expired"
            );
        }

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElse(null);

        // AUTO CREATE USER
        if (user == null) {

            user = new User();

            user.setEmail(request.getEmail());

           

            user.setRole(Role.ROLE_USER);

            userRepository.save(user);
        }

        UserDetails userDetails =
                userDetailsService
                        .loadUserByUsername(
                                user.getEmail()
                        );

        String accessToken =
                jwtService.generateToken(
                        userDetails
                );

        String refreshToken =
                generateRefreshToken(user);

        otpRepository.deleteByEmail(
                request.getEmail()
        );

        return new AuthResponseDTO(
                accessToken,
                refreshToken,
                "Login successful"
        );
    }
    public AuthResponseDTO refreshToken(
            String requestToken) {

        RefreshToken refreshToken =
                refreshTokenRepo.findByToken(requestToken)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Invalid refresh token"
                                )
                        );

        if (refreshToken.getExpiryDate()
                .isBefore(LocalDateTime.now())) {

            throw new RuntimeException(
                    "Refresh token expired"
            );
        }

        User user = refreshToken.getUser();

        UserDetails userDetails =
                userDetailsService.loadUserByUsername(
                        user.getEmail()
                );

        String newAccessToken =
                jwtService.generateToken(
                        userDetails
                );

        return new AuthResponseDTO(
                newAccessToken,
                requestToken,
                "Token refreshed successfully"
        );
    }
 // =========================
 // CREATE REFRESH TOKEN
 // =========================
    @Transactional
    public String generateRefreshToken(User user) {

        String token = UUID.randomUUID().toString();

        RefreshToken refreshToken =
                refreshTokenRepo.findByUser(user)
                        .orElse(new RefreshToken());

        refreshToken.setUser(user);
        refreshToken.setToken(token);
        refreshToken.setExpiryDate(
                LocalDateTime.now().plusDays(7)
        );

        refreshTokenRepo.save(refreshToken);

        return token;
    }
}