$(function(){
	$(".select3").uedSelect({
		width : 300
	});
	
	initProject();
});

function initProject(){
	var url = pathHeader+ "/edupm/projectmanage/queryProjectByStatusAll.do";
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
				$.each(data.rows, function(key, value) {
					$("#projectList").append(
						"<option  value=\"" + value.id + "\">"
						+ value.projectName + "</option>");
				});
			}
		},
		error:function(){ }
	});
}

function sendMessage(){
	if(!$.trim($("#projectList").val()).length > 0){
		jQuery.generalAlert("项目不能为空!");
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
	
	if($("input[type='checkbox']:checked").length == 0){
		jQuery.generalAlert("请选择至少一个接收者!");
		return;
	}
	
	$("#messageForm").ajaxSubmit({
		url : pathHeader + "/message/messageManagement/sendMessageByProject.do?time="+new Date(),
		type:"post",
		async:true,
		success : function(data) {
			var url = pathHeader + "/message/messageManagement/sendMessageByProject.htm?click=3"
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