package com.bug.mynote.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bug.mynote.domain.ChildReply;
import com.bug.mynote.repository.ChildReplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChildReplyService {
	
	private final ChildReplyRepository childReplyRepository;
	
	@Transactional
	public ChildReply save(ChildReply childReply) {
		ChildReply childReplyEntity = childReplyRepository.save(childReply);
		
		return childReplyEntity;
	}

}
