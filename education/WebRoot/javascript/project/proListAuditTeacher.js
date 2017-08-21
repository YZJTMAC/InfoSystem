$(function(){
	$(".select3").uedSelect({
		width : 100
	});
	projectList();
});

function qryPro(){
	if(validateYear()){
		projectList();
	}else{
		jQuery.generalAlert("查询开始年度不能大于结束年度！");
	}
}


function projectList(){
	$('#proList').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	
	var url = pathHeader+ "/edupm/projectmanage/proListForAuditTeacher.do";
	
	$.ajax({
		url:url,
		type:"post",
		data:{
			projectName : $('#projectName').val(),
			start : $('#beginDate').val(),
			end : $('#endDate').val(),
			startIndex : pageIndex
		},
		async:true,
		success:function(data){
			var rows = data.rows;
			var areaId = data.areaId;
			var orgId = data.orgId;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element,areaId,orgId);
				});
				$('#proList').append(gridHtml);
				pagination(data, function(){projectList();});
			}else{
				$('#proList').html("<tr><td colspan='11'>无查询记录</td></tr>");
			}
		},
		error:function(){
			
		}
		
	});
	
}


function getTdHtml(obj,areaId,orgId){
	var gridHtml = "<tr>";
	gridHtml += "<td><a href='javascript:projectInfo("+obj.projectId+",\"" + obj.createBy +"\",\"" + obj.applyer+ "\")'>" + obj.projectName + "</a></td>";
	gridHtml += "<td>"+obj.startDate+"</td>";
	gridHtml += "<td>"+obj.endDate+"</td>";
	gridHtml += "<td>"+obj.createBy+"</td>";
	gridHtml += "<td>"+obj.organizationName+"</td>";
	gridHtml += "<td>"+obj.applyer+"</td>";
	gridHtml += "<td>"+obj.planNum+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		returnStr += 	 "<a href='###' class='tablelink' onclick='audit(\"" + row.projectId + "\",\"" + row.projectName + "\");'>审 核</a>&nbsp;&nbsp;&nbsp;";
		return returnStr;
	}
}

function audit(projectId,projectName){
	var url = pathHeader + "/edupm/projectmanage/toTeacherTrainModify.htm?click=110&projectId="+projectId+"&projectName="+projectName;
	openWindow(url);
}