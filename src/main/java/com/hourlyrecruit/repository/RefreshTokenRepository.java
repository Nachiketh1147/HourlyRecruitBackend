package com.hourlyrecruit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.hourlyrecruit.model.RefreshToken;
import com.hourlyrecruit.model.User;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
	Optional<RefreshToken> findByToken(String token);
	@Modifying
	@Transactional
	void deleteByUser(User user);
	Optional<RefreshToken> findByUser(User user);   
} 