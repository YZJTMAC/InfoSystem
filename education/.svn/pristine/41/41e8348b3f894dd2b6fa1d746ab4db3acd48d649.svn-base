
$(function(){
	queryQRBackground();
	showTeacherInfo();
});
// 查询二维码背景
function queryQRBackground(){
	var qrbackgroundImg =$('#qrbackground').val();
	if(qrbackgroundImg != -1){
		$.ajax({
			type : "POST",
			url : pathHeader + "/fileupload/viewQRCodeFiles.do",
			data:{
				id: qrbackgroundImg
			},
			success : function(data){
				var file = data.files[0];
				if(type == '2'){
					$("#QRbackgroundImgPro").attr("src",pathHeader+"/"+file.url);
				}else if(type == '3'){
					$("#QRbackgroundImg").attr("src",pathHeader+"/"+file.url);
				}
			}
		});
	}else{
	}
}

function showTeacherInfo() {
	$.ajax({
		url : pathHeader + "/teacher/teacherProject/teacherInfoList.do",
		type : "POST",
		cache : "false",
		dataType : "json",
		data : {
			teacherId : $("#teacherId").val()
		},
		async : true,
		success : function(data) {
			var obj = data.eduUserInfo;	
			if (data.success) {
				if(obj.userImageUrl == null || obj.userImageUrl==""){
					$("#photo").attr("src", pathHeader+"/images/u8_normal.jpg");
				}
				else{
					$("#photo").attr("src", imagerServer + obj.userImageUrl);
				}
			}
		},
		error : function() {
		}
	});
}



