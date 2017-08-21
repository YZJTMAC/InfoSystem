$(function(){
	showTeacherAssessList();
});

function showTeacherAssessList(){
	$('#tableList').html('');
	$.ajax({
		url : pathHeader + '/stats/stats/queryFurtherStats.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#tableList').append(gridHtml);
			} else {
				gridHtml = "<tr><td align='center' colspan='4'>暂无查询结果！</td></tr>";
				$('#tableList').append(gridHtml);
			}
		},
		error:function(){
			gridHtml = "<tr><td align='center' colspan='4'>暂无查询结果！</td></tr>";
			$('#tableList').append(gridHtml);
		}
	});
}


function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.year+"年</td>";
	gridHtml += "<td>"+obj.teacherClassScore+"学分</td>";
	if(obj.isAssess=="1"){
		gridHtml += "<td>已达标</td>";
	}else{
		gridHtml += "<td><i>未达标</i></td>";
	}
	gridHtml += "<td><a href=\""+pathHeader+"/furtheredu/edumanage/teacherAssessWithYearInfo.htm?year="+obj.year+"\">查看年度详情</a></td>";
	return gridHtml;
}
