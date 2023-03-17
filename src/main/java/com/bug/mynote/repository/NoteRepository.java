package com.bug.mynote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.mynote.domain.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
