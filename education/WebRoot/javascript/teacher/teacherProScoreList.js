$(function(){
	showTeacherProScoreList();
	
	// 条件查询
	$("#select").click(function() {
		showTeacherProScoreList();
	});
});

function showTeacherProScoreList(){
	$('#proTeacher_list').html('');
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	
	$.ajax({
		url : pathHeader + '/edupm/teachermanage/teacherProScoreList.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			startIndex : pageIndex,
			pageSize:sizePerPage,
			status:40,
			projectName : $('#projectName').val(),
			start : $('#beginDate').find("option:selected").val(),
			end : $('#endDate').find("option:selected").val()	
		},
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				var areaId = data.areaId;
				var orgId = data.orgId;
				var gridHtml = "";
				$.each(objList, function(index,element) {
					gridHtml += getTdHtml(element,areaId,orgId);
				});
				$('#proTeacher_list').append(gridHtml);
				pagination(data, function(){showTeacherProScoreList();});
			} else {
				gridHtml = "<tr><td align='center'colspan='11'>暂无查询结果！</td></tr>";
				$('#proTeacher_list').append(gridHtml);
			}
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='11'>暂无查询结果！</td></tr>";
			$('#proTeacher_list').append(gridHtml);
		}
	});
}


function getTdHtml(obj,areaId,orgId){
	var gridHtml = "<tr>";
	//实施机构、创建项目者所属地区和登陆者地区相同，方可查看项目信息。
//	if(obj.createByArea == areaId || obj.organizationId == orgId){
		gridHtml += "<td><a href='javascript:projectInfo("+obj.id+",\"" + obj.createBy +"\",\"" + obj.applyer+ "\")'>"+obj.projectName+"</a></td>";
//	}
//	else{
//		gridHtml += "<td>"+obj.projectName+"</td>";
//	}
	
	var projectStatus = "";
	if(obj.status == 30){
		projectStatus = "待启动";
	}else if(obj.status == 40){
		projectStatus = "实施中";
	}
	
	gridHtml += "<td>"+projectStatus+"</td>";
	gridHtml += "<td>"+obj.trainTypeName+"</td>";
	gridHtml += "<td>"+obj.createBy+"</td>";
	gridHtml += "<td>"+obj.organizationName+"</td>";
	gridHtml += "<td>"+(obj.hasStopSign==1?'是':'否')+"</td>";  
	gridHtml += "<td>"+obj.applyer+"</td>";
	gridHtml += "<td>"+obj.planNum+"</td>";
	gridHtml += "<td>"+obj.auditor+"</td>";
	gridHtml += "<td>"+numFormatter(obj.pass)+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function numFormatter(num) {
		if(num == null || num == 'null'){
			return '';
		} else {
			return num;
		}
	}
	
	function optionFormatter(row){
		//实施机构、创建项目者所属地区和登陆者地区相同，方可导入成绩。
//		if(row.createByArea == areaId || row.organizationId == orgId){
			return "<a href='###' class='tablelink' onclick='downTemplate(\"" + row.id+ "\");'>模板</a>&nbsp;&nbsp;" +
			   "<a href='###' class='tablelink' onclick='upload(\"" + row.id+ "\",\""+row.hasStopSign+"\");'>导入</a>&nbsp;&nbsp;" +
			   "<a href='###' class='tablelink' onclick='info(\"" + row.id+ "\");'>查看</a>";
//		}
//		else{
//			return "";
//		}
	}
}


/**
 * 模版下载
 */
function downTemplate(projectId){
	//$("#downIframe",document.body).attr("src",pathHeader + "/template/upload_score.xls");	
	
	$("#downIframe", document.body).attr(
			"src",
			pathHeader + "/edupm/teachermanage/downTeachersScoreTemplate.do?projectId="
					+ projectId);
}


/**
 * 查看培训成绩	以前版本的现在不用了 
 * @param {Object} projectId

function info(projectId){
	var openUrl = pathHeader + '/edupm/teachermanage/toTeacherProScoreInfoPage.htm?click=4&projectId=' + projectId;
	window.location.href = openUrl;
}
 */


/**
 * 导入成绩
 * @param {Object} projectId
 */
function upload(projectId,hasStopSign){
	if(hasStopSign != 1){
		jQuery.generalAlert("此项目还未结束报名,请在教师报名审核列表中点击结束报名，方可导入成绩 !");
		return ;
	}
	var openUrl = pathHeader + '/edupm/teachermanage/toImportTeacherScorePage.htm?click=28&projectId=' + projectId+"&hasStopSign="+hasStopSign;
	window.location.href = openUrl;
}


/**
 * 查看导入的培训成绩饼状图
 * @param {Object} projectId
 */
function info(projectId){
	var openUrl = pathHeader + '/edupm/teachermanage/toImportScoreInfoPage.htm?click=28&projectId=' + projectId;
	window.location.href = openUrl;
}