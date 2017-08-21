$(function(){
	showTeacherInfo(teacherId);
	
	$("#JobtransferHis").click(function(){
		showJobtransferHistory();
	});
	
	$("#commentHis").click(function(){
		showCommentHistory();
	});
});

function goback() {
	var openUrl = toUrlById(click);
	showWindow(openUrl);
}

function showWindow(url) {
	window.location.href = url;
}

function savePhoto() {
	
	var url = pathHeader + "/person/savePhoto.do";
	var imgUrl=$("#photoTemp")[0].src;
	$.ajax({
		url:url,
		data:{
			imgUrl:imgUrl,
			teacherId : teacherId
		},
		async:false,
		type:"post",
		success:function(data){
			if(data.success) {
				alert("修改成功");
				
			}else {
				alert("修改失败");
			}
			
		},
		error:function(){
			
		}
		
	});
	window.location.reload();
}
