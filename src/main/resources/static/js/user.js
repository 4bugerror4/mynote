function userJoin() {
	
	let data = {
		username: $('#username').val(),
		password: $('#password').val(),
		email: $('#email').val(),
		nickname: $('#nickname').val()
	};
	
	$.ajax({
		
		type: 'POST',
		url: '/api/auth/join',
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
		datatype: 'JSON',
		
		success: function(res) {
			console.log(res);
			alert("회원가입 성공");
			location.href="/"
		},
		
		error: function(e) {
			console.log(e);
			alert("회원가입 실패");
		}
		
	});
}