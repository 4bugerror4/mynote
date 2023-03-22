package com.bug.mynote.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bug.mynote.domain.Image;
import com.bug.mynote.service.ImageService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ImageController {
	
	private final ImageService imageService;
	
	@GetMapping("/board/image")
	public String imageBoard(Model model) {
		
		List<Image> images = imageService.getImages();
		model.addAttribute("images", images);
		
		return "board/image";
	}

}
