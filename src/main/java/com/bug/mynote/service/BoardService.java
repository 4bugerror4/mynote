package com.bug.mynote.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bug.mynote.domain.Board;
import com.bug.mynote.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	@Transactional(readOnly = true)
	public List<Board> getNoteAll() {
		return boardRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Board getNote(Long id) {
		return boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아이디의 게시글은 존재하지 않습니다."));
	}
	
	@Transactional
	public Board save(Board note) {
		return boardRepository.save(note);
	}
	
	@Transactional
	public Board update(Board board) {
		Board boardEntity = boardRepository.findById(board.getId()).orElseThrow(() -> new IllegalArgumentException("해당 아이디의 게시글은 존재하지 않습니다."));
		boardEntity.setTitle(board.getTitle());
		boardEntity.setContent(board.getContent());
		
		return boardEntity;
	}
	
	@Transactional
	public void delete(Long id) {
		boardRepository.deleteById(id);
	}
}
