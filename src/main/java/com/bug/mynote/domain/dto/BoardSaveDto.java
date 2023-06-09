package com.bug.mynote.domain.dto;

import com.bug.mynote.domain.Board;
import com.bug.mynote.domain.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardSaveDto {
	
	private String title;
	private String content;
	
	public Board toEntity(User user) {
		return Board.builder()
				.title(title)
				.content(content)
				.user(user)
				.build();
	}

}
