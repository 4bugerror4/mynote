package com.bug.mynote.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bug.mynote.domain.User;
import com.bug.mynote.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder encoder;
	
	@Transactional(readOnly = true)
	public User getUser(String username) {
		return userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("해당 번호의 아이디는 존재하지 않습니다."));
	}
	
	@Transactional(readOnly = true)
	public User getUser(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 번호의 아이디는 존재하지 않습니다."));
	}
	
	@Transactional(readOnly = true)
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@Transactional
	public User joinUser(User user) {
		
		User userEntity = new User();
		userEntity.setUsername(user.getUsername());
		
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		userEntity.setPassword(encPassword);
		userEntity.setEmail(user.getEmail());
		userEntity.setNickname(user.getNickname());
		userEntity.setRole("ROLE_USER");
		
		return userRepository.save(userEntity);
	}

}
