package com.bug.mynote.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bug.mynote.domain.Reply;
import com.bug.mynote.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyService {
	
	private final ReplyRepository replyRepository;
	
	@Transactional(readOnly = true)
	public Reply getReply(Long id) {
		
		Reply reply = replyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 번호의 아이디는 존재하지 않습니다."));
		
		return reply;
	}
	
	@Transactional
	public Reply save(Reply reply) {
		
		Reply replyEntity = replyRepository.save(reply);
		
		return replyEntity;
	}
	
	@Transactional
	public void delete(Long replyId) {
		
		replyRepository.deleteById(replyId);
	}

}
