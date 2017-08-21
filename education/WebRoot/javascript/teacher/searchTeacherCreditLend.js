$(function(){
	queryList();
	initSelectClass();
})


/**
 * 查询借贷列表
 */
function queryList(){
	var lendYear = $('#lendYear').val();
	var url = pathHeader + "/teacher/teacherProject/queryTeacherLendCreditByArea.do";
	$('#queryList').html("");
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			lendYear:lendYear
		},
		beforeSend: function(){
			$('#queryList').html("<tr><td align='center' colspan='14'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
		},
		success:function(data){
			var rows = data.rows;
			var totalNum = data.count;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getObjHtml(element);
				});
				$('#queryList').html(gridHtml);
				initSelectClass();
			}else{
				$('#queryList').html("<tr><td colspan='14'>无借贷记录</td></tr>");
			}
		},
		error:function(){
			$('#queryList').html("<tr><td colspan='14'>无借贷记录</td></tr>");
		}
	});
}



function getObjHtml(obj){
	var gridHtml = "<tr>";
		gridHtml += "<td>"+obj.teacherName+"</td>";
		gridHtml += "<td>"+obj.teacherIdNumber+"</td>";
		gridHtml += "<td>"+obj.trainFormName+"</td>";
		gridHtml += "<td>"+obj.lendDate+"</td>";
		gridHtml += "<td>"+obj.lendReason+"</td>";
		gridHtml += "<td>"+obj.lendCredit+"</td>";
		gridHtml += "<td>"+obj.lendPeriod+"</td>";
		if(obj.lendStatus == 0){
			gridHtml += "<td>未审批</td>";
		}
		if(obj.lendStatus == 1){
			gridHtml += "<td><a href='###' class='tablelink' onclick='queryAudit(\"" + obj.id + "\");'>已通过</a></td>";
		}
		if(obj.lendStatus == 2){
			gridHtml += "<td><a href='###' class='tablelink' onclick='queryAudit(\"" + obj.id + "\");'>未通过</a></td>";
		}
		if(obj.lendStatus == 3){
			gridHtml += "<td><a href='###' class='tablelink' onclick='queryAudit(\"" + obj.id + "\");'>已偿还</a></td>";
		}
		gridHtml+= "</tr>";
	return gridHtml;
}



/**
 * 查看审核意见
 * @param id
 */
function queryAudit(id){
	var url = pathHeader + "/teacher/teacherProject/queryTeacherLendCreditById.do";
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			id:id
		},
		success:function(data){
			var obj = data.rows;
			if(obj.lendCommand == null){
				$("#reason").html("无");
			}else{
				$("#reason").html(obj.lendCommand);
			}
			
			$("#auditReasonModal").modal("show");
		},
		error:function(){
		}
		
	});
}

 function initSelectClass(){
	 $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
	$(".select4").uedSelect({
		width : 100
	});
}