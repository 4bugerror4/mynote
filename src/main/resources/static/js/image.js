function imageSave() {
	
	let data = {
		content: $('#content').val()
	};
	
	let form = $('#imageForm')[0];
	let formData = new FormData(form);
	
	formData.append('file', $('#file'));
	formData.append('dto', new Blob([JSON.stringify(data)], {type: 'application/json'}));
	
	$.ajax({
		type: 'POST',
		url: '/api/image/save',
		data: formData,
		contentType: false, // 필수 : x-www-form-urlencoded로 파싱되는 것을 방지
		processData: false, // 필수 : contentType을 false로 줬을 때 QueryString 자동 설정됨. 해제
		enctype: 'multipart/form-data',
		dataType: 'json',
		
		success: function(res) {
			console.log(res);
			alert("이미지 등록 완료");
			location.href = "/board/image"
		},
		error: function(e) {
			console.log(e);
			alert("이미지 등록 실패");
		}
	});
	
}