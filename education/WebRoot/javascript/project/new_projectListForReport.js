$(function(){
	projectList();
	initSelect();
});


function projectList(){
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	
	var url = pathHeader+ "/edupm/projectmanage/otherProject.do";
	$('#proList1').html("");
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			projectName : $('#projectName').val(),
			start:$("#beginDate").val(),
			end:$("#endDate").val(),
			year:$("#year").val(),
			startIndex : pageIndex,
			pageSize:sizePerPage,
			status:"30,40",
			signUpWay:"1,3",
			queryFlag:1
		},
		beforeSend: function(){
			$('#proList1').html("<tr><td align='center' colspan='12'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
		},
		success:function(data){
			var rows = data.rows;
			var areaId=data.areaId;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element,areaId);
				});
				$('#proList1').html(gridHtml);
			}else{
				$('#proList1').html("<tr><td colspan='9'>无查询记录</td></tr>");
			}
			pagination(data, function(){projectList();});
		},
		error:function(){
			jQuery.generalAlert("URL ERROR!");
		}
		
	});
}


function getTdHtml(obj,areaId){
	var num =obj.allocatePlanNum;
	if(roleId == 1 || roleId == 2 || roleId == 3 || roleId == 7 || roleId == 8 || roleId == 9 ){
		num = obj.planNum;
	}
	var str = "";
	if(obj.status == 30){
		str = "待启动";
	}else if(obj.status == 40){
		str = "实施中";
	}
	var ss = "";
	var suw = obj.signUpWay;
	if(suw == 3){
		ss = "层级分配/报名";
	}else if(suw == 2 ){
		ss = "自由报名";
	}else{
		ss = "组织报名";
	}
	var gridHtml = "<tr>";
	gridHtml += "<td><a href='javascript:projectInfo("+obj.id+",\"" + obj.createBy +"\",\"" + obj.applyer+ "\")'>"+obj.projectName+"</a></td>";
	gridHtml += "<td>"+obj.planNum+"</td>";
	gridHtml += "<td>"+(num==null?"未分配":num)+"&nbsp;</td>";
	gridHtml +="<td>"+ss+"</td>";
	gridHtml +="<td>"+obj.createBy+"</td>";
	gridHtml +="<td>"+obj.organizationName+"</td>";
	gridHtml +="<td>"+obj.applyer+"</td>";
	gridHtml +="<td>"+obj.auditor+"</td>";
	gridHtml +="<td>"+str+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td>";
	gridHtml += "</tr>";
	return gridHtml;
	
	function optionFormatter(row){	
		var returnStr = "";
		//报名是否已结束
		if(row.hasStopSign == 0 ||row.hasStopSign==null){
		if(row.signUpWay == 3 && row.status != 40 && num!=null && num!=0){			
			returnStr += 	 "<a href='###' class='huibtn_a' onclick='toReport(\"" + row.id + "\",\""+row.createByArea+"\",\""+areaId+"\");'>上 报</a>&nbsp;&nbsp;&nbsp;";
			returnStr += 	 "<a href='###' class='huibtn_a' onclick='auditChaxunbaoming(\"" + row.id + "\",\""+row.createByArea+"\",\""+areaId+"\");'>查看报名情况</a>&nbsp;&nbsp;&nbsp;";
			//role == 4校管理员可以重新上报。以及当校管理员点击了确定上报后，才会显示重新上报。
			if(roleId == 4 && row.isReportStatus==1){
				returnStr += "<a href='###' class='huibtn_a' onclick='toSelectTeacher(\"" + row.id + "\",\""+row.createByArea+"\",\""+areaId+"\");'>重新上报</a>&nbsp;&nbsp;";
			}						
		}else if(row.status == 40 && num!=null ){
			returnStr += "<a href='###' class='huibtn_a' onclick='importA(\"" + row.id + "\");'>导入补报名学员名单</a>&nbsp;&nbsp;";
			returnStr += 	 "<a href='###' class='huibtn_a' onclick='auditChaxunbaoming(\"" + row.id + "\",\""+row.createByArea+"\",\""+areaId+"\");'>查看报名情况</a>&nbsp;&nbsp;&nbsp;";
/*			returnStr += "<a href='###' class='huibtn_a' onclick='begin(\"" + row.id + "\");'>补报名</a>";*/
		}else if(row.signUpWay == 1 ){
			returnStr += 	 "<a href='###' class='huibtn_a' onclick='importS(\"" + row.id + "\");'>导入学员名单</a>&nbsp;&nbsp;&nbsp;";	
						
			returnStr += 	 "<a href='###' class='huibtn_a' onclick='auditChaxunbaoming2(\"" + row.id + "\",\""+row.createByArea+"\",\""+areaId+"\");'>查看报名情况</a>&nbsp;&nbsp;&nbsp;";
		}
		}
		else {
			returnStr += "<a href='###' class='huibtn_a' >报名已结束</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
			if(row.signUpWay == 1){
				returnStr += 	 "<a href='###' class='huibtn_a' onclick='auditChaxunbaoming2(\"" + row.id + "\",\""+row.createByArea+"\",\""+areaId+"\");'>查看报名情况</a>&nbsp;&nbsp;&nbsp;";
			}
			else{
				returnStr += 	 "<a href='###' class='huibtn_a' onclick='auditChaxunbaoming(\"" + row.id + "\",\""+row.createByArea+"\",\""+areaId+"\");'>查看报名情况</a>&nbsp;&nbsp;&nbsp;";
			}
			
		}
		return returnStr;
	}
}
//组织报名方式的项目，查询报名情况

function auditChaxunbaoming2(projectId,createByArea,areaId){
	
		var url = pathHeader + "/edupm/projectmanage/toTeacherListForAuditchaxunbaoming.htm?click=24&projectId="+projectId+"&areaId="+areaId;
		openWindow(url);
	
}

function auditChaxunbaoming(projectId,createByArea,areaId){
	//登陆者地区和创建者地区相同的，直接打开上报界面，不用校验是否分配名额。
	if(createByArea == areaId){
		var url = pathHeader + "/edupm/projectmanage/toTeacherListForAuditchaxunbaoming.htm?click=24&projectId="+projectId+"&areaId="+areaId;
		openWindow(url);
	}
	
	else{
	$.ajax({
		url:pathHeader+"/edupm/projectmanage/hasAllocateGt.do",
		data:{projectId:projectId},
		async:true,
		type:"post",
		dataType:"json",
		success:function(data){
			if(data.success){
				var url = pathHeader + "/edupm/projectmanage/toTeacherListForAuditchaxunbaoming.htm?click=24&projectId="+projectId+"&areaId="+areaId;
				openWindow(url);
			}else{
				if(data.msg == -1){
				jQuery.generalAlert("此项目不属于您所在的机构！不能执行此操作！");
				}else{
					
				jQuery.generalAlert("未给本地区分配名额，不能执行此操作！");
				}
			}
		},
		error:function(){
			jQuery.generalAlert("系统内部错误，请联系管理员！");
		}
		
		
	});
	
	}
}
//重新上报
function toSelectTeacher(projectId,createByArea,areaId){
	//登陆者地区和创建者地区相同的，直接打开上报界面，不用校验是否分配名额。
	if(createByArea == areaId){
		var url = pathHeader + "/edupm/projectmanage/toSelectTeacherPageCXBM.htm?click=24&areaId="+areaId+"&projectId="+projectId;
		openWindow(url);
	}
	else{
	$.ajax({
		url:pathHeader+"/edupm/projectmanage/hasAllocateGt.do",
		data:{projectId:projectId},
		async:true,
		type:"post",
		dataType:"json",
		success:function(data){
			if(data.success){
				var url = pathHeader + "/edupm/projectmanage/toSelectTeacherPageCXBM.htm?click=24&areaId="+areaId+"&projectId="+projectId;
				openWindow(url);
			}else{
				if(data.msg == -1){
				jQuery.generalAlert("此项目不属于您所在的机构！不能重新上报！");
				}else{
					
				jQuery.generalAlert("未给本地区分配名额，不用执行重新上报操作！");
				}
			}
		},
		error:function(){
			jQuery.generalAlert("系统内部错误，请联系管理员！");
		}
		
		
	});
	}
}



function qryPro(){
	if(validateYear()){
		projectList();
	}else{
		jQuery.generalAlert("查询开始年度不能大于结束年度！");
	}
}

function initSelect(){
	$(".select3").uedSelect( {
		width : 100
	});
}

function toReport(id,createByArea,areaId){
	//登陆者地区和创建者地区相同的，直接打开上报界面，不用校验是否分配名额。
	if(createByArea == areaId){
		var url = pathHeader + "/edupm/projectmanage/toProjectReportByAreaPage.htm?projectId="+id + "&click=" + click;
		openWindow(url);
	}
	else{
	$.ajax({
		url:pathHeader+"/edupm/projectmanage/hasAllocateGt.do",
		data:{projectId:id},
		async:true,
		type:"post",
		dataType:"json",
		success:function(data){
			if(data.success){
				var url = pathHeader + "/edupm/projectmanage/toProjectReportByAreaPage.htm?projectId="+id + "&click=" + click;
				openWindow(url);
			}else{
				if(data.msg == -1){
				jQuery.generalAlert("此项目不属于您所在的机构！不能上报！");
				}else{
					
				jQuery.generalAlert("未给本地区分配名额，不用执行上报操作！");
				}
			}
		},
		error:function(){
			jQuery.generalAlert("系统内部错误，请联系管理员！");
		}
	});
	}
}



function importS(id){
	var url = pathHeader + "/edupm/projectmanage/toBatchSignUpPage.htm?projectId="+id+"&type=0&click=24";
	openWindow(url);
}

function importA(id){
	var url = pathHeader + "/edupm/projectmanage/toBatchSignUpPage.htm?projectId="+id+"&type=1&click=24";
	openWindow(url);
}