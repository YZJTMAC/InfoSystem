function getTeacherScoreInfo(teacherId){
	window.location.href = pathHeader + "/teacher/teacherProject/toTeacherTrainScore.htm?teacherId="+teacherId+"&click=23";
}

function showPushComment(pushComment){
	if(pushComment != '' && pushComment != null && pushComment != "null"){
		$("#comment").html(pushComment);
	}else {
		$("#comment").html('');
	}
	$(".tip0").fadeIn(200);
}
function cancel(){
	$(".tip0").fadeOut(200);
}