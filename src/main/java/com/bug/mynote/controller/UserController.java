package com.bug.mynote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/auth/login")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("/auth/join")
	public String join() {
		return "user/join";
	}

}
