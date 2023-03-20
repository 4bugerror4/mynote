package com.bug.mynote.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.mynote.domain.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
	
	List<Note> findByTitleContainingOrContentContaining(String title, String content);

}
