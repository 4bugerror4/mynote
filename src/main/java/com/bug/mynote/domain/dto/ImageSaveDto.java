package com.bug.mynote.domain.dto;

import com.bug.mynote.domain.Image;
import com.bug.mynote.domain.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ImageSaveDto {
	
	private String content;
	
	public Image toEntity(User user) {
		return Image.builder()
				.content(content)
				.user(user)
				.build();
	}
	
}
