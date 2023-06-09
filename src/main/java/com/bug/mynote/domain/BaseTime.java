package com.bug.mynote.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public class BaseTime {
	
	@JoinColumn(name = "created_date")
	@CreatedDate
	private LocalDateTime createdDate;
	
	@JoinColumn(name = "modifed_date")
	@LastModifiedDate
	private LocalDateTime modifiedDate;

}
