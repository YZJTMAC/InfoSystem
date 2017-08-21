$(function(){
	showOrgProTeacherScore();
	
	// 条件查询
	$("#select").click(function() {
		showOrgProTeacherScore();
	});
});

function showOrgProTeacherScore(){
	$('#teacherScore_list').html('');
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + '/org/orgProTeacherScore.do',
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
				$('#teacherScore_list').append(gridHtml);
				pagination(data, function(){showOrgProTeacherScore();});
			} else {
				gridHtml = "<tr><td align='center'colspan='8'>暂无查询结果！</td></tr>";
				$('#teacherScore_list').append(gridHtml);
			}
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='8'>暂无查询结果！</td></tr>";
			$('#teacherScore_list').append(gridHtml);
		}
	});
}


function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+nullFormatter(obj.projectName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.organizationName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.planNum)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.veryGood)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.good)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.general)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.bad)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.veryBad)+"</td>";
	
	return gridHtml;
	
	function nullFormatter(obj){
		if(obj==null || obj=='null' || obj.length==0){
			return '';
		} else {
			return obj;
		}
	}
	
}
