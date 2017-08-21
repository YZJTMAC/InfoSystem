$(function(){
	trainScoreInfo();
});

function trainScoreInfo(){
	$('#tablelist').html("");
	
	var pageIndex = $("#pageIndex").val();
	var sizePerPage = $("#sizePerPage").val();
	var idNumber = $("#idNumber").val();
	var url = pathHeader+ "/sys/queryTeacherTraningScoreByTeacherId.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
			teacherId:teacherId,
			startIndex : pageIndex,
			pageSize :sizePerPage
		},
		async:true,
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += createTdHtml(element);
				});
				$('#proList').html(gridHtml);
				pagination(data, function(){queryTeacherScoereInfo();});
			}else{
				$('#proList').html("<tr><td colspan='8'>无查询记录</td></tr>");
			}
		},
		error:function(){
		}
	});
}

function createTdHtml(obj){
	var startDate = new Date(obj.startDate).format("yyyy-MM-dd");
	var endDate = new Date(obj.endDate).format("yyyy-MM-dd");
	var gridHtml = "<tr>";
	gridHtml += "<td><a href='javascript:projectInfo("+obj.id+")'>"+obj.projectName+"</a></td>";
	gridHtml += "<td>"+startDate+"</td>";
	gridHtml += "<td>"+endDate+"</td>";
	gridHtml += "<td>"+obj.trainTypeName+"</td>";
	gridHtml += "<td>"+obj.projectPropertyName+"</td>";
	/*gridHtml += "<td>"+teacherScoreFormatter(obj.teacherScore)+"</td>";*/
	gridHtml += "<td>"+teacherClassScoreFormatter(obj.classScore)+"</td>";
	gridHtml += "<td>"+teacherStatusFormatter(obj.teacherTrainStatusName)+"</td>";
	
	return gridHtml;
	
	function teacherScoreFormatter(score){
		var a = (score==null || score=='null' || score=='')?'暂无成绩': score;
		return a;
	}
	function teacherClassScoreFormatter(score){
		var a = (score==null || score=='null' || score=='')?'无学分信息': score;
		return a;
	}
	
	function teacherStatusFormatter(status){
		var a = (status==null || status=='null' || status=='')?'暂无状态': status;
		return a;
	}
	
}