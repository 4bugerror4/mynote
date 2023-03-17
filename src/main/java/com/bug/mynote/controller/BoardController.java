package com.bug.mynote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {
	
	@GetMapping("/normal/board")
	public String normalBoard() {
		return "board/normal";
	}
	
	@GetMapping("/image/board")
	public String imageBoard() {
		return "board/image";
	}
	
	@GetMapping("/normal/board/write")
	public String normalBoardWrite() {
		return "board/write";
	}
	
	@GetMapping("/normal/board/{id}")
	public String normalBoardDetail(@PathVariable Long id) {
		return "board/detail";
	}

}
