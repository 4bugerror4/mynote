package com.bug.mynote.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bug.mynote.domain.User;
import com.bug.mynote.domain.dto.UserJoinDto;
import com.bug.mynote.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserApiController {
	
	private final UserService userService;
	
	@PostMapping("/auth/join")
	public User login(@RequestBody UserJoinDto dto) {
		
		return userService.joinUser(dto.toEntity());
	}
	

}
