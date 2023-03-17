package com.bug.mynote.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bug.mynote.domain.Note;
import com.bug.mynote.repository.NoteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoteService {
	
	private final NoteRepository noteRepository;
	
	@Transactional(readOnly = true)
	public List<Note> getNoteAll() {
		return noteRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Note getNote(Long id) {
		return noteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아이디의 노트는 존재하지 않습니다."));
	}
	
	@Transactional
	public Note save(Note note) {
		return noteRepository.save(note);
	}
	
	@Transactional
	public Note update(Note note) {
		Note noteEntity = noteRepository.findById(note.getId()).orElseThrow(() -> new IllegalArgumentException("해당 아이디의 노트는 존재하지 않습니다."));
		noteEntity.setTitle(note.getTitle());
		noteEntity.setContent(note.getContent());
		
		return noteEntity;
	}
	
	@Transactional
	public void delete(Long id) {
		noteRepository.deleteById(id);
	}

}
