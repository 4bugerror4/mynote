package com.bug.mynote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.mynote.domain.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

}
