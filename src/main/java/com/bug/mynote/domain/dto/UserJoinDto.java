package com.bug.mynote.domain.dto;

import com.bug.mynote.domain.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserJoinDto {
	
	private String username;
	private String password;
	private String email;
	private String nickname;

	public User toEntity() {
		return User.builder()
				.username(username)
				.password(password)
				.email(email)
				.nickname(nickname)
				.build();
	}
}
