package com.bug.mynote.domain.dto;

import com.bug.mynote.domain.Note;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteUpdateDto {
	
	private Long id;
	private String title;
	private String content;
	
	public Note toEntity() {
		return Note.builder()
				.id(id)
				.title(title)
				.content(content)
				.build();
	}

}
