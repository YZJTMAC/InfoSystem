$(function(){
	getMessageCounts();
	//通知
	//getNoticeCounts();
});

function getMessageCounts(){
	var url = pathHeader+ "/message/messageManagement/getMessageCounts.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
		},
		async:true,
		success:function(data){
			if(data.success){
				$('#messageCounts').html(data.total);
				if($("#windowShow").val()=="1" && data.total>0){
					 $.messager.show(200, 130, "通知", "<a href='"+ pathHeader +"/message/messageManagement/messageList.htm?click=3' target='_blank'>您有<font style='padding:0 2px;color:red;text-decoration:underline;'>"+ data.total +"</font>条未读通知</a>",0);
				}
			}
		},
		error:function(){
		}
	});
}
/*
function getNoticeCounts(){
	var url = pathHeader+ "/notice/getNoticeCounts.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
		},
		async:true,
		success:function(data){
			if(data.success){
				$('#noticeCount').html(data.noticeCount);
			}
		},
		error:function(){
			//alert("查询错误");
		}
		
	});
}*/