package com.bug.mynote.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<Board> getBoardAll(Pageable pageable, String searchText) {
		Page<Board> boards = boardRepository.findByTitleContainingOrContentContaining(pageable, searchText, searchText);
		
		return boards;
	}
	
	@Transactional(readOnly = true)
	public Board getBoard(Long id) {
		return boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아이디의 게시글은 존재하지 않습니다."));
	}
	
	@Transactional
	public Board save(Board board) {
		return boardRepository.save(board);
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
