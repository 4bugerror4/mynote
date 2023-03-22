package com.bug.mynote.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.bug.mynote.domain.Board;
import com.bug.mynote.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("/board/normal")
	public String normalBoard(Model model, @PageableDefault(sort = "id", size = 5, direction = Direction.DESC) Pageable pageable, 
			@RequestParam(required = false, defaultValue = "") String searchText) {
		
		Page<Board> boards = boardService.getBoardAll(pageable, searchText);
		int startPage = Math.max(1, boards.getPageable().getPageNumber() - 4);
		int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 4);
		
		model.addAttribute("boards", boards);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return "board/normal";
	}
	
	@GetMapping("/normal/board/write")
	public String normalBoardWrite() {
		return "board/write";
	}
	
	@GetMapping("/normal/board/{id}")
	public String normalBoardDetail(@PathVariable Long id, Model model) {
		
		Board board = boardService.getBoard(id);
		model.addAttribute("board", board);
		
		return "board/detail";
	}
	
	@GetMapping("/normal/board/update/{id}")
	public String normalBoardUpdate(@PathVariable Long id, Model model) {
		
		Board board = boardService.getBoard(id);
		model.addAttribute("board", board);
		model.addAttribute("test", "Hello <b>Spring</b>");
		
		return "board/update";
	}

}
