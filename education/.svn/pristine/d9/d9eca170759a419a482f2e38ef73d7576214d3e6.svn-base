$(function(){
	showOrgProjectList();
	$("#select").click(function() {
		showOrgProjectList();
	});
});

function showOrgProjectList(){
	$('#orgProject_list').html('');
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + '/org/orgProjectList.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectName : $('#projectName').val(),
			startTime : $('#beginDate').find("option:selected").val(),
			endTime : $('#endDate').find("option:selected").val(),
			pageIndex : pageIndex
		},
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#orgProject_list').append(gridHtml);
			} else {
				gridHtml = "<tr><td align='center'colspan='7'>暂无查询结果！</td></tr>";
				$('#orgProject_list').append(gridHtml);
			}
			pagination(data, function(){showOrgProjectList();});
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='7'>暂无查询结果！</td></tr>";
			$('#orgProject_list').append(gridHtml);
		}
	});
}


function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+nullFormatter(obj.projectName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.startDate)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.endDate)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.trainTypeName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.projectPropertyName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.planNum)+"</td>";
	gridHtml += "<td><a href='###' class='tablelink' onclick='setup(\"" + obj.id + "\",\"+"+obj.projectName+"\");'>参训教师管理</a></td></tr>";
	
	return gridHtml;
	
	function nullFormatter(obj){
		if(obj==null || obj=='null' || obj.length==0){
			return '';
		} else {
			return obj;
		}
	}
}


/**
 * 参训教师管理
 * @param {Object} projectId
 */
function setup(projectId, projectName){
	var openUrl = pathHeader + '/org/orgProjectTeachersPage.htm?click=14&projectId=' + projectId + '&projectName=' + projectName;
	//window.open(openUrl);
	window.location.href = openUrl;
}