package com.bug.mynote.controller.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bug.mynote.config.api.PrincipalDetails;
import com.bug.mynote.domain.Board;
import com.bug.mynote.domain.Reply;
import com.bug.mynote.domain.User;
import com.bug.mynote.domain.dto.ReplySaveDto;
import com.bug.mynote.service.BoardService;
import com.bug.mynote.service.ReplyService;
import com.bug.mynote.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReplyApiController {
	
	private final ReplyService replyService;
	private final BoardService boardService;
	private final UserService userService;
	
	@PostMapping("/reply/save/{boardId}")
	public Reply save(@RequestBody ReplySaveDto dto,
			@PathVariable Long boardId,
			@AuthenticationPrincipal PrincipalDetails principal) {
		
		Board board = boardService.getBoard(boardId);
		User user = userService.getUser(principal.getUser().getId());
		
		Reply replyEntity = replyService.save(dto.toEntity(board, user));
		
		return replyEntity;
	}
	
	@DeleteMapping("/reply/delete/{replyId}")
	public void delete(@PathVariable Long replyId) {
		 replyService.delete(replyId);
	}

}
