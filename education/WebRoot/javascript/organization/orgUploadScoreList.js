$(function(){
	showOrgProScoreList();
	
	// 条件查询
	$("#select").click(function() {
		showOrgProScoreList();
	});
});

function showOrgProScoreList(){
	$('#orgProject_list').html('');
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + '/org/orgUploadScoreList.do',
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
			pagination(data, function(){showOrgProScoreList();});
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='7'>暂无查询结果！</td></tr>";
			$('#orgProject_list').append(gridHtml);
		}
	});
}


function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+nullFormatter(obj.projectNo)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.projectName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.year)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.trainTypeName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.projectPropertyName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.planNum)+"</td>";
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
		var returnStr = '<a href="###" class="tablelink" onclick="uploadScore(\'' + row.id + '\');">上传培训成绩</a><br/>' +
						'<a href="###" class="tablelink" onclick="downTemplate();">模板下载</a>'
		return returnStr;
	}
}

/**
 * 模版下载
 */
function downTemplate(){
	$("#downIframe",document.body).attr("src",pathHeader + "/template/upload_score.xls");
}


// 上传培训成绩
function uploadScore(projectId){
	var openUrl = pathHeader + '/org/orgUploadScorePage.htm?click=17&projectId=' + projectId;
	window.location.href = openUrl;
	//window.open(openUrl);
}