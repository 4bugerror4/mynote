package com.bug.mynote.domain.dto;

import com.bug.mynote.domain.Board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardUpdateDto {
	
	private Long id;
	private String title;
	private String content;
	
	public Board toEntity() {
		return Board.builder()
				.id(id)
				.title(title)
				.content(content)
				.build();
	}

}
