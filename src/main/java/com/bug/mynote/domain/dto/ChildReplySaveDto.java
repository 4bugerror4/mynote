package com.bug.mynote.domain.dto;

import com.bug.mynote.domain.ChildReply;
import com.bug.mynote.domain.Reply;
import com.bug.mynote.domain.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChildReplySaveDto {
	
	private String content;
	private Long replyId;
	
	public ChildReply toEntity(Reply reply, User user) {
		return ChildReply.builder()
				.content(content)
				.reply(reply)
				.user(user)
				.build();
	}

}
