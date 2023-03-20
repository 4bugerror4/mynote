package com.bug.mynote.controller.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.bug.mynote.domain.Board;
import com.bug.mynote.domain.User;
import com.bug.mynote.domain.dto.BoardSaveDto;
import com.bug.mynote.domain.dto.BoardUpdateDto;
import com.bug.mynote.service.BoardService;
import com.bug.mynote.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardApiController {
	
	private final BoardService boardService;
	private final UserService userService;
	
	// 전체 게시글 찾기
	@GetMapping("/boards")
	public Page<Board> notes(Pageable pageable, String searchText) {
		return boardService.getBoardAll(pageable, searchText);
	}
	
	// 게시글 하나 찾기
	@GetMapping("/board/{id}")
	public Board note(@PathVariable Long id) {
		return boardService.getBoard(id);
	}
	
	// 게시글 추가
	@PostMapping("/board/save")
	public Board save(@RequestBody BoardSaveDto dto, @AuthenticationPrincipal PrincipalDetails principal) {
		
		User user = userService.getUser(principal.getUser().getId());
		
		return boardService.save(dto.toEntity(user));
	}
	
	// 게시글 수정
	@PutMapping("/board/update")
	public Board update(@RequestBody BoardUpdateDto dto) {
		return boardService.update(dto.toEntity());
	}
	
	// 게시글 삭제
	@DeleteMapping("/board/{id}")
	public void delete(@PathVariable Long id) {
		boardService.delete(id);
	}

}
