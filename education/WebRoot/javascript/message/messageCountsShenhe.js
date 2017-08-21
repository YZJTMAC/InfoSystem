$(function(){
	//通知
	getMessageCounts();
});

function getMessageCounts(){
	var url = pathHeader+ "/message/messageManagement/getMessageShenheCounts.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
		},
		async:true,
		success:function(data){
			if(data.success){
				$('#messageCounts').html(data.total);
				}
		},
		error:function(){
			//alert("查询错误");
		}
		
	});
}
