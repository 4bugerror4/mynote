package com.bug.mynote.domain.dto;

import com.bug.mynote.domain.Board;
import com.bug.mynote.domain.Reply;
import com.bug.mynote.domain.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplySaveDto {

	private String content;
	
	public Reply toEntity(Board board, User user) {
		return Reply.builder()
				.content(content)
				.board(board)
				.user(user)
				.build();
	}
}
