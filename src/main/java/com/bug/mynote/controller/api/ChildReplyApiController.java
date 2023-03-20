package com.bug.mynote.controller.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bug.mynote.config.api.PrincipalDetails;
import com.bug.mynote.domain.ChildReply;
import com.bug.mynote.domain.Reply;
import com.bug.mynote.domain.User;
import com.bug.mynote.domain.dto.ChildReplySaveDto;
import com.bug.mynote.service.ChildReplyService;
import com.bug.mynote.service.ReplyService;
import com.bug.mynote.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ChildReplyApiController {
	
	private final ChildReplyService childReplyService;
	private final ReplyService replyService;
	private final UserService userService;

	@PostMapping("/reply/save/child")
	public ChildReply save(@RequestBody ChildReplySaveDto dto,
			@AuthenticationPrincipal PrincipalDetails principal) {
		
		Reply reply = replyService.getReply(dto.getReplyId());
		User user = userService.getUser(principal.getUser().getId());
		
		return childReplyService.save(dto.toEntity(reply, user));
	}
}
