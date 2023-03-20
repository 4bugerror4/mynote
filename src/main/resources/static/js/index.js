function noteSave() {

	let data = {
		title: $('#title').val(),
		content: $('#content').val()
	}

	$.ajax({

		type: 'POST',
		url: '/api/note/save',
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
		datatype: 'JSON',

		success: function(res) {
			console.log(res);
			alert("노트 작성 완료");
			location.href = "/"
		},

		error: function(e) {
			console.log(e);
			alert("노트 작성 실패");
		}

	});
}

function noteUpdate() {

	let data = {
		id: $('#update-id').val(),
		title: $('#update-title').val(),
		content: $('#update-content').val()
	}
	
	console.log(data);

	$.ajax({

		type: 'PUT',
		url: '/api/note/update',
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
		datatype: 'JSON',

		success: function(res) {
			console.log(res);
			alert("노트 수정 완료");
			location.href = "/"
		},

		error: function(e) {
			console.log(e);
			alert("노트 수정 실패");
		}

	});
}

function noteDelete(id) {

	$.ajax({

		type: 'DELETE',
		url: '/api/note/' + id,
		contentType: 'application/json; charset=utf-8',
		datatype: 'JSON',

		success: function(res) {
			console.log(res);
			alert("노트 삭제 완료");
			location.href = "/"
		},

		error: function(e) {
			console.log(e);
			alert("노트 수정 삭제");
		}

	});
}

// 모달창 값 전달 받기
$(document).ready(function() {
	$('#updateModal').on('show.bs.modal', function(event) {
		let button = $(event.relatedTarget);
		let id = button.data('id');
		let title = button.data('title'); // Button th:data-title
		let content = button.data('content'); // Button th:data-content
		let modal = $(this);
		modal.find('.modal-body #update-id').val(id);
		modal.find('.modal-body #update-title').val(title);
		modal.find('.modal-body #update-content').val(content);
	});
});