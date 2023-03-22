package com.bug.mynote.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.bug.mynote.domain.Image;
import com.bug.mynote.repository.ImageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageService {
	
	private final ImageRepository imageRepository;
	
	@Value("${file.path}")
	private String uploadFolder;
	
	@Transactional(readOnly = true)
	public List<Image> getImages() {
		return imageRepository.findAll();
	}
	
	@Transactional
	public Image save(Image image, MultipartFile file) {
		
		UUID uuid = UUID.randomUUID();
		String imageFileName = uuid + "_" + file.getOriginalFilename();
		
		Path imageFilePath = Paths.get(uploadFolder + imageFileName);
		
		try {
			Files.write(imageFilePath, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		image.setPostImageUrl(imageFileName);
		image.setUser(image.getUser());
		
		Image imageEntity = imageRepository.save(image);
		
		return imageEntity;
	}

}
