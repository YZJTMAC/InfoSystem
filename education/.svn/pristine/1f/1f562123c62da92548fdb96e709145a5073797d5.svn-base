$(function(){
	showTeacherAssessList();
});

function showTeacherAssessList(){
	$('#proTeacher_list').html('');
	$.ajax({
		url : pathHeader + '/furtheredu/edumanage/queryTeacherAssess.do',
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
				$('#proTeacher_list').append(gridHtml);
			} else {
				gridHtml = "<tr><td align='center' colspan='4'>暂无查询结果！</td></tr>";
				$('#proTeacher_list').append(gridHtml);
			}
		},
		error:function(){
			gridHtml = "<tr><td align='center' colspan='4'>暂无查询结果！</td></tr>";
			$('#proTeacher_list').append(gridHtml);
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
	gridHtml += "<td><a href=\""+pathHeader+"/furtheredu/edumanage/teacherAssessWithYearInfo.htm?click=4&year="+obj.year+"\">查看年度详情</a></td>";
	return gridHtml;
}
