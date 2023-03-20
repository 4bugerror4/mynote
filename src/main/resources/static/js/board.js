function normalBoardSave() {
	
	let data = {
		title: $('#title').val(),
		content: $('#content').val()
	}
	
	console.log(data);
	
	$.ajax({

		type: 'POST',
		url: '/api/board/save',
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
		datatype: 'JSON',

		success: function(res) {
			console.log(res);
			alert("게시판 작성 완료");
			location.href = "/board/normal"
		},

		error: function(e) {
			console.log(e);
			alert("게세판 작성 실패");
		}

	});
}

function normalBoardUpdate() {
	
	let data = {
		id: $('#id').val(),
		title: $('#title').val(),
		content: $('#content').val()
	}
	
	console.log(data);
	
	$.ajax({

		type: 'PUT',
		url: '/api/board/update',
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
		datatype: 'JSON',

		success: function(res) {
			console.log(res);
			alert("게시판 수정 완료");
			location.href = "/board/normal"
		},

		error: function(e) {
			console.log(e);
			alert("게세판 수정 실패");
		}

	});
}

function normalBoardDelete() {
	
	let data = {
		id: $('#id').val()
	}
	
	console.log(data);
	
	$.ajax({

		type: 'DELETE',
		url: '/api/board/' + data.id,
		contentType: 'application/json; charset=utf-8',
		datatype: 'JSON',

		success: function(res) {
			console.log(res);
			alert("게시물 삭제 완료");
			location.href = "/board/normal"
		},

		error: function(e) {
			console.log(e);
			alert("게시물 수정 삭제");
		}

	});
}

function replySave() {
	
	let data = {
		content: $('#replyContent').val(),
		boardId: $('#id').val()
	}
	
	console.log(data);
	
	$.ajax({

		type: 'POST',
		url: '/api/reply/save/' + data.boardId,
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
		datatype: 'JSON',

		success: function(res) {
			console.log(res);
			alert("댓글 작성 완료");
			location.href = "/normal/board/" + data.boardId
		},

		error: function(e) {
			console.log(e);
			alert("댓글 작성 실패");
		}

	});
	
}

function replyDelete(replyId) {
	
	let data = {
		boardId: $('#id').val(),
		replyId: replyId,
	}
	
	console.log(data);
	
	$.ajax({

		type: 'DELETE',
		url: '/api/reply/delete/' + data.replyId,
		contentType: 'application/json; charset=utf-8',
		datatype: 'JSON',

		success: function(res) {
			console.log(res);
			alert("댓글 삭제 완료");
			location.href = "/normal/board/" + data.boardId
		},

		error: function(e) {
			console.log(e);
			alert("댓글 삭제 실패");
		}

	});
}

function childReplySave(replyId) {
	
	let data = {
		replyId: replyId,
		boardId: $('#id').val(),
		content: $(`#childContent${replyId}`).val()
	}
	
	console.log(data);
	
	$.ajax({

		type: 'POST',
		url: '/api/reply/save/child',
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
		datatype: 'JSON',

		success: function(res) {
			console.log(res);
			alert("대댓글 작성 완료");
			location.href = "/normal/board/" + data.boardId
		},

		error: function(e) {
			console.log(e);
			alert("대댓글 작성 실패");
		}

	});
	
}