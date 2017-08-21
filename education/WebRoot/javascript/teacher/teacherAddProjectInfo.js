$(function(){
	initAutoComplete();
	//培训机构查询
	getOrganizations();
});
function getOrganizations(){
	$.ajax({
		url : pathHeader + "/teacher/teacherProject/teacherProjectOrganization.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
		projectId:projectId
		},
		success:function(data){
			if(data.success) 
			{
				var info = data.infoList;
					var gridHtml = "<tr>";
				for(var i = 0;i<info.length;i++){
					gridHtml += "<td width='200'>"+info[i].organizationName+"</td>";
				}
       				gridHtml += "</tr>";
       				$('#orgsNames').html(gridHtml);
        
			}
		},
		error:function(){
			jQuery.generalAlert("查询错误!!!!");
		}
		
		
	});
}

/**
 * 初始化
 */
function initAutoComplete(){
	showInfoList();
}

function showInfoList() {
	
	$.ajax({
		url : pathHeader + "/teacher/teacherProject/teacherAddProjectStatus.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
		projectId:projectId
		},
		success:function(data){
			if(data.success) 
			{
				var obj = data.info;
				if(obj.updateBy==null||obj.updateBy.length==0||obj.updateBy=="")
					$('#updateBy').html("");
				else
					$('#updateBy').html(obj.updateBy);
			
				if(obj.updateDate!=null){
					var datas = new Date(obj.updateDate).format("yyyy-MM-dd hh:mm:ss");
					
					$('#updateDate').html(datas);
					}else{
						$('#updateDate').html("----");
					}
				
				
				if(obj.status==null||obj.status.length==0||obj.status==""){
					$('#status').html("");
				}
				else{
					if(obj.status==11){
						$('#status').html("审核中");
					}
					if(obj.status==12){
						$('#status').html("审核未通过");
					}
					if(obj.status==13){
						$('#status').html("审核通过");
					}
				}
				
				if(obj.auditMemo==null||obj.auditMemo.length==0||obj.auditMemo=="")
					$('#auditMemo').html("&nbsp;");
				else
					$('#auditMemo').html(obj.auditMemo);
			}
			
		},
		error:function(){
			jQuery.generalAlert("查询错误!!!!");
		}
		
		
	});
}

////报名之前查看该项目是否需要审核
//function selectProMustAudit(projectId,typeVal){
//	var url = pathHeader +"/teacher/teacherProject/selectProMustAudit.do";
//	$.ajax({
//		url:url,
//		data:{
//		projectId:projectId,
//		type : typeVal
//		},
//		type:"post",
//		async:true,
//		success:function(data){
//			if(data.success){
//				var info = data.info;
//				if(info!==null||info!==""){
//					if(info==1){
//					teacherAdd(projectId,typeVal);
//					}else {
//					teacherAdd2(projectId,typeVal);
//					}
//				}
//			}
//		},
//		error:function(){
//			jQuery.generalAlert("报名失败!");
//		}
//	});
//}


//教师报名加入培训项目--不需要审核
/*function teacherAdd2(projectId,typeVal){
	$("#disable").disabled="disabled";
	var url = pathHeader +"/teacher/teacherProject/createTeacherAddProject2.do";
	$.ajax({
		url:url,
		data:{
		projectId:projectId,
		type:typeVal
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				var url = pathHeader + "/teacher/teacherProject/teacherAddProjectPage.htm";
				jQuery.generalAlertAndJump("报名成功!", url);
//				window.location.href = pathHeader + "/teacher/teacherProject/teacherAddProjectPage.htm"
			}
		},
		error:function(){
			jQuery.generalAlert("报名失败!");
		}
	});
}*/



//教师报名加入培训项目--需要审核
function teacherAdd(projectId,type){
	$("#disable").disabled="disabled";
	var url = pathHeader +"/teacher/teacherProject/createTeacherAddProject.do";
	$.ajax({
		url:url,
		data:{
		projectId:projectId,
		type:type
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
			//var url = pathHeader + "/teacher/teacherProject/teacherAddProjectPage.htm";
			var url = pathHeader + "/teacher/teacherProject/teacherProjectCommon.htm?click=9&flag=7";
			jQuery.generalAlertAndJump("报名成功!", url);
//			window.location.href = pathHeader + "/teacher/teacherProject/teacherAddProjectPage.htm"
			}
		},
		error:function(){
			jQuery.generalAlert("报名失败!");
		}
	});
}
function showWindow(url) {
	window.location.href = url;
}