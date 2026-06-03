package com.hourlyrecruit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hourlyrecruit.model.Role;
import com.hourlyrecruit.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	Optional<User> findByEmail(String email);
	Boolean existsByEmail(String Email);
	 Boolean existsByRole(Role role);
	 List<User> findByRole(Role role);
	 Optional<User> findByIdAndRole(Long id, Role role);
}
