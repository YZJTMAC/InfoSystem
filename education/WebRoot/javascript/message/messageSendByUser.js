$(function(){
	$(".select3").uedSelect({
		width : 300
	});
});

function sendMessage(){
	if(!$.trim($("#receiveUser").val()).length > 0){
		jQuery.generalAlert("收信人不为空!");
		return;
	}
	
	if(!$.trim($("#title").val()).length > 0){
		jQuery.generalAlert("通知标题不为空!");
		return;
	}
	
	if(!$.trim($("#content").val()).length > 0){
		jQuery.generalAlert("通知内容不为空!");
		return;
	}
	
	$("#messageForm").ajaxSubmit({
		url : pathHeader + "/message/messageManagement/sendMessageByUser.do?time="+new Date(),
		type:"post",
		async:true,
		success : function(data) {
			var url = pathHeader + "/message/messageManagement/sendMessageByUser.htm?click=3"
			var jsonData = jQuery.parseJSON(data)
			if(jsonData.success){
				jQuery.generalAlertAndJump("发送成功！",url);
			}else{
				jQuery.generalAlert(jsonData.info);
			}
		},
		error : function() {
			jQuery.generalAlert("ERROR");
		}
	});
}