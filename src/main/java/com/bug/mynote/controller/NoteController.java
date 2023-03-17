package com.bug.mynote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoteController {
	
	@GetMapping({"", "/", "/index"})
	public String main() {
		return "index";
	}
	
}
