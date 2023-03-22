package com.bug.mynote.controller.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bug.mynote.config.api.PrincipalDetails;
import com.bug.mynote.domain.Image;
import com.bug.mynote.domain.User;
import com.bug.mynote.domain.dto.ImageSaveDto;
import com.bug.mynote.service.ImageService;
import com.bug.mynote.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ImageApiController {
	
	private final ImageService imageService;
	private final UserService userService;
	
	@PostMapping("/image/save")
	public Image save(@RequestPart(value = "dto", required = false) ImageSaveDto dto,
			@RequestPart(value = "file", required = false) MultipartFile file,
			@AuthenticationPrincipal PrincipalDetails principal) {
		
		User user = userService.getUser(principal.getUser().getId());
		
		Image image = imageService.save(dto.toEntity(user), file);
		
		return image;
	}

}
