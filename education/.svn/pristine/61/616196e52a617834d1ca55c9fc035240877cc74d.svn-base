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
		gridHtml += "<td><a href='###' onclick=printer(\""+obj.realName+"\",\""+obj.teacherClassPeriod+"\",\""+obj.teacherClassScore+"\",\""+obj.year+"\",\""+obj.teacherScore+"\");>打印年度证书</a></td>";
	}else{
		gridHtml += "<td><i>未达标</i></td>";
		gridHtml += "<td>未达标，不能打印</td>";
	}
	
	return gridHtml;
}


/**
 * 跳转到打印证书页面
 * @param {Object} realName
 * @param {Object} period 学时
 * @param {Object} score 学分
 */
function printer(realName, period, score, year, teacherScore){
	var openUrl = pathHeader + '/furtheredu/edumanage/toPrinterCertificatePage.htm?name='+realName+'&period='+period+'&score='+score+'&year='+year+'&grade='+teacherScore;
	window.open(openUrl);
}
