$(function(){
	
	$(".cancel").click(function() {
		qryChangeInfoList();
	});
	
});


function audit(){
	$('#myModal').modal('show');
	var url = pathHeader + "/edupm/teachermanage/auditRecord.do";
	$.ajax({
		url:url,
		data:{
			auditId:auditId,
			status:$("input[name='status']:checked").val(),
			memo:$("#memo").val(),
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				jQuery.generalAlert("审核成功!");
				$('#myModal').modal('hide');
				var url = pathHeader + "/edupm/teachermanage/toTeacherInfoChangeAuditPage.htm?click=2";
				openWindow(url);
			}
		},
		error:function(){
			
		}
		
	});
}





function qryChangeInfoList(){
	
	var url = pathHeader + "/edupm/teachermanage/toTeacherInfoChangeAuditPage.htm?click=2";
	openWindow(url);
}


