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
	
	var url = pathHeader+ "/edupm/projectmanage/proListForAuditSH.do";
	
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
			}else{
				$('#proList').html("<tr><td colspan='11'>无查询记录</td></tr>");
			}
			pagination(data, function(){projectList();});
		},
		error:function(){
			
		}
		
	});
	
}


function getTdHtml(obj,areaId,orgId){
	/*var total = obj.pass-0+obj.unPass-0;*/
	/*var attendNum = obj.attendNum; //已审核
	var learningNum=obj.learningNum;//未审核
	var total=learningNum-attendNum;*/
	var gridHtml = "<tr>";
	/*if(attendNum!=0 || learningNum!=0 ){
	gridHtml += "<td><a href='javascript:projectInfo("+obj.projectId+",\"" + obj.createBy + "\")'>"+obj.projectName+"</a></td>";
	gridHtml += "<td>"+obj.startDate+"</td>";
	gridHtml += "<td>"+obj.endDate+"</td>";
	gridHtml += "<td>"+obj.planNum+"</td>";
	gridHtml += "<td>"+obj.attendNum+"</td>";
	gridHtml += "<td>"+total+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	}else{*/
	 /*var str = JSON.stringify(obj);  
	    alert(str);  
	    alert(obj.learningNum);*/
   //	alert(JSON.Stobj.learningNum);	
	//实施机构、 创建项目者所属地区和登陆者地区相同，方可查看项目信息。
//	if (obj.createByArea == areaId || obj.organizationId == orgId) {
		gridHtml += "<td><a href='javascript:projectInfo("+obj.projectId+",\"" + obj.createBy +"\",\"" + obj.applyer+ "\")'>" + obj.projectName + "</a></td>";
//	} else {
//		gridHtml += "<td>" + obj.projectName + "</td>";
//	}
		gridHtml += "<td>"+obj.startDate+"</td>";
		gridHtml += "<td>"+obj.endDate+"</td>";
		gridHtml += "<td>"+obj.createBy+"</td>";
		gridHtml += "<td>"+obj.organizationName+"</td>";
		gridHtml += "<td>"+obj.applyer+"</td>";
		gridHtml += "<td>"+obj.planNum+"</td>";//计划人数
		gridHtml += "<td>"+obj.shenheNum+"</td>"; //已审核
		gridHtml += "<td>"+obj.weishenheNum+"</td>";//未审核
		gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	   /*}*/
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		if(row.hasStopSign  == 0 ||row.hasStopSign==null){
			/*returnStr += 	 "<a href='###' class='tablelink' onclick='stopSign(\"" + row.projectId + "\");'>结束报名</a>&nbsp;&nbsp;&nbsp;";*/
			//实施机构、 创建项目者所属地区和登陆者地区相同，方可审核。
//			if (obj.createByArea == areaId || obj.organizationId == orgId) {
				returnStr += 	 "<a href='###' class='tablelink' onclick='audit(\"" + row.projectId + "\",\"" + row.projectName + "\");'>审 核</a>&nbsp;&nbsp;&nbsp;";
//			}
//			else{
//				returnStr += "";
//			}
		}else{
			returnStr += 	 "已审核";
		}
		return returnStr;
	}
}

function audit(projectId,projectName){
	var url = pathHeader + "/edupm/projectmanage/toTeacherListForAudites.htm?click=108&projectId="+projectId+"&projectName="+projectName;
	openWindow(url);
}
//结束报名
/*function stopSign(projectId){
	var url = pathHeader + "/edupm/projectmanage/stopSign.do";
	$.ajax({
		url:url,
		data:{projectId:projectId},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				projectList();
			}else{
				jQuery.generalAlert("名额没有全部上报，不能结束报名！");
			}
		},
		error:function(){
			jQuery.generalAlert("URL Error!");
		}
	});
}
*/