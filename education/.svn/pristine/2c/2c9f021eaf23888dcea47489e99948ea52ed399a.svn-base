$(function(){
	showOrgProjectList();
	
	// 条件查询
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
				pagination(data, function(){showOrgProjectList();});
			} else {
				gridHtml = "<tr><td align='center'colspan='4'>暂无查询结果！</td></tr>";
				$('#orgProject_list').append(gridHtml);
			}
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='4'>暂无查询结果！</td></tr>";
			$('#orgProject_list').append(gridHtml);
		}
	});
}


function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+nullFormatter(obj.projectName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.startDate)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.endDate)+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function nullFormatter(obj){
		if(obj==null || obj=='null' || obj.length==0){
			return '';
		} else {
			return obj;
		}
	}
	
	function optionFormatter(row){
		return "<a href='#' class='tablelink'  onclick='info(\"" + row.id + "\");'>教师总结</a>&nbsp;&nbsp;" +
				"<a href='#' class='tablelink'  onclick='info(\"" + row.id + "\");'>承配机构总结</a>&nbsp;&nbsp;" +
						"<a href='#' class='tablelink'  onclick='info(\"" + row.id + "\");'>我的总结</a>";
	}
}

/**
 * 查看详情
 * @param {Object} projectId
 */
function info(projectId){
	var openUrl = pathHeader + '/org/?projectId=' + projectId+'&click=18';
	window.open(openUrl);
}
