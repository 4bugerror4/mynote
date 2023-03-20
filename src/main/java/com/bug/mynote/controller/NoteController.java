package com.bug.mynote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bug.mynote.service.NoteService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class NoteController {
	
	private final NoteService noteService;
	
	@GetMapping({"", "/", "/index"})
	public String main(Model model, @RequestParam(defaultValue = "", required = false) String searchText) {
		model.addAttribute("notes", noteService.getNotes(searchText));
		return "index";
	}
	
}
