package com.bug.mynote.controller.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bug.mynote.config.api.PrincipalDetails;
import com.bug.mynote.domain.Note;
import com.bug.mynote.domain.User;
import com.bug.mynote.domain.dto.NoteSaveDto;
import com.bug.mynote.domain.dto.NoteUpdateDto;
import com.bug.mynote.service.NoteService;
import com.bug.mynote.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class NoteApiController {
	
	private final NoteService noteService;
	private final UserService userService;
	
	// 노트 하나 찾기
	@GetMapping("/note/{id}")
	public Note note(@PathVariable Long id) {
		return noteService.getNote(id);
	}
	
	// 노트 추가
	@PostMapping("/note/save")
	public Note save(@RequestBody NoteSaveDto dto, @AuthenticationPrincipal PrincipalDetails principal) {
		
		User user = userService.getUser(principal.getUser().getId());
		
		return noteService.save(dto.toEntity(user));
	}
	
	// 노트 수정
	@PutMapping("/note/update")
	public Note update(@RequestBody NoteUpdateDto dto) {
		return noteService.update(dto.toEntity());
	}
	
	// 노트 삭제
	@DeleteMapping("/note/{id}")
	public void delete(@PathVariable Long id) {
		noteService.delete(id);
	}
}
