package com.bug.mynote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.mynote.domain.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
