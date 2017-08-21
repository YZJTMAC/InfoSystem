$(function(){
	//通知
	//getMessageCounts();
	personSession();
});

function outLogin() {
	var url = pathHeader + "/person/nLogin.do";
	$.ajax( {
		url : url,
		type : "post",
		async : true,
		success : function(data) {
			window.location.href = pathHeader + "/person/login.htm";

		},
		error : function() {
			window.location.href = pathHeader + "/person/login.htm";
		}
	});
}

function personSession() {
	var url = pathHeader + "/person/login/personSession.do";
	$.ajax( {
		url : url,
		type : "post",
		async : true,
		success : function(data) {
			if (data.success) {
				//(data.userCityName==null?"":data.userCityName) + 
				$("#userInfo").html(data.realName);
				$("#userInfo").attr("title", data.roleName);
			}
		}
	});
	
	/*function getMessageCounts(){
		jQuery.generalAlert("message");
		var url = pathHeader+ "/message/messageManagement/getMessageCounts.do";
		$.ajax({
			url:url,
			type:"post",
			data:{
			},
			async:true,
			success:function(data){
				jQuery.generalAlert(data.total);
				if(data.success){
					$('#messageCounts').html(data.total);
					}
			},
			error:function(){
				jQuery.generalAlert("查询错误");
			}
			
		});
	}*/
	
}