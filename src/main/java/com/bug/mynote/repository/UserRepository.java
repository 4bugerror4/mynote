package com.bug.mynote.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.mynote.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);

}
