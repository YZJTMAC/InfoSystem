$(function(){
	projectList1();	
});

function projectList1(){
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();	
	var	statusVal = "0";
	var url = pathHeader + "/edupm/projectmanage/queryCreditLendForAudit.do";
	$('#proList1').html("");
	$.ajax({
		url:url,
		type:"post",
		data:{
			teacherName : $('#teacherName1').val(),
			startIndex : pageIndex,
			pageSize:sizePerPage,
			status:statusVal
		},
		async:false,
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#proList1').append(gridHtml);
			}else{
				$('#proList1').html("<tr><td colspan='9'>无查询记录</td></tr>");
			}
//			pagination(data, function(){projectList1();});
		},
		error:function(){
			jQuery.generalAlert("查询错误，请联系相关人员!");
		}
		
	});
}
function projectList2(){
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();	
	var	statusVal = "1";
	var url = pathHeader + "/edupm/projectmanage/queryCreditLendForAudit.do";
	$('#proList2').html("");
	$.ajax({
		url:url,
		type:"post",
		data:{
			teacherName : $('#teacherName2').val(),
			startIndex : pageIndex,
			pageSize:sizePerPage,
			status:statusVal
		},
		async:false,
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#proList2').append(gridHtml);
			}else{
				$('#proList2').html("<tr><td colspan='9'>无查询记录</td></tr>");
			}
//			pagination(data, function(){projectList1();});
		},
		error:function(){
			jQuery.generalAlert("查询错误，请联系相关人员!");
		}
		
	});
}
function projectList3(){
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();	
	var	statusVal = "2";
	var url = pathHeader + "/edupm/projectmanage/queryCreditLendForAudit.do";
	$('#proList3').html("");
	$.ajax({
		url:url,
		type:"post",
		data:{
			teacherName : $('#teacherName3').val(),
			startIndex : pageIndex,
			pageSize:sizePerPage,
			status:statusVal
		},
		async:false,
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#proList3').append(gridHtml);
			}else{
				$('#proList3').html("<tr><td colspan='9'>无查询记录</td></tr>");
			}
//			pagination(data, function(){projectList1();});
		},
		error:function(){
			jQuery.generalAlert("查询错误，请联系相关人员!");
		}
		
	});
}
function projectList4(){
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();	
	var	statusVal = "3";
	var url = pathHeader + "/edupm/projectmanage/queryCreditLendForAudit.do";
	$('#proList4').html("");
	$.ajax({
		url:url,
		type:"post",
		data:{
			teacherName : $('#teacherName4').val(),
			startIndex : pageIndex,
			pageSize:sizePerPage,
			status:statusVal
		},
		async:false,
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#proList4').append(gridHtml);
			}else{
				$('#proList4').html("<tr><td colspan='9'>无查询记录</td></tr>");
			}
//			pagination(data, function(){projectList1();});
		},
		error:function(){
			jQuery.generalAlert("查询错误，请联系相关人员!");
		}
		
	});
}
function getTdHtml(obj){	
	
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.teacherName+"</td>";
	gridHtml +="<td>"+obj.schoolName+"</td>";
	gridHtml +="<td>"+obj.idNumber+"</td>";
	gridHtml +="<td>"+obj.lendYear+"</td>";
	gridHtml +="<td>"+obj.trainFormName+"</td>";
	gridHtml +="<td>"+obj.lendReason+"</td>";
	gridHtml +="<td>"+obj.lendDate+"</td>";
	gridHtml +="<td>"+obj.lendCredit+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td>";
	gridHtml += "</tr>";

	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		if(row.lendStatus == 0){
			returnStr += "<a href='###' class='tablelink' onclick='toAudit(\"" + row.id + "\");'>审 核</a>&nbsp;&nbsp;&nbsp;";
		}else if(row.lendStatus == 1){
			returnStr += "<a href='###' class='tablelink' onclick='queryAudit(\"" + row.id + "\");'>已通过</a>&nbsp;&nbsp;&nbsp;";
		}else if(row.lendStatus == 2){
			returnStr += "<a href='###' class='tablelink' onclick='queryAudit(\"" + row.id + "\");'>未通过</a>&nbsp;&nbsp;&nbsp;";
		}else if(row.lendStatus == 3){
			returnStr += "<a href='###' class='tablelink' onclick='queryAuditOver(\"" + row.id + "\");'>已偿还</a>&nbsp;&nbsp;&nbsp;";
		}
		return returnStr;
	}
}
var pid;
function toAudit(id){
	pid=id;//这句话要加上，pid是全局变量，审核的时候要用到该变量
	$("#memo").attr("value","");
	$("#auditModal").modal("show");
	$("#projectName10").html("学分借贷申请审核");
}

function audit(){
	var url = pathHeader + "/edupm/projectmanage/auditCreditLend.do";
	 $.ajax({
		 url:url,
		 data:{
		 	id:pid,
		 	audtiStatus:$("input[name='radio']:checked").val(),
		 	memo:$("#memo").val()
		 },
		 type:"post",
		 async:false,
		 success:function(data){
			 if(data.success){
				 jQuery.generalAlert("审核成功！");
			 $("#auditModal").modal("hide");
				 projectList1();
			 }
		 },
		 error:function(){
		 jQuery.generalAlert("审核出现错误，请联系相关人员 !");
		 }
	 });
}
function queryAudit(id){
	var url = pathHeader + "/teacher/teacherProject/queryTeacherLendCredit.do";
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