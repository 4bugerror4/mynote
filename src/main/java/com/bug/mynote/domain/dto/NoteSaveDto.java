package com.bug.mynote.domain.dto;

import com.bug.mynote.domain.Note;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoteSaveDto {
	
	private String title;
	private String content;
	
	public Note toEntity() {
		return Note.builder()
				.title(title)
				.content(content)
				.build();
	}

}
