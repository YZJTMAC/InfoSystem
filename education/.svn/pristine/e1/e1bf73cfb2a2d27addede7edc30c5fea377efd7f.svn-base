$(function(){
	queryTeacher();
})

/**
 * 评选活动教师
 */
function queryTeacher(){
	$("#proList1").html("");
	var startIndex = $("#pageIndex").val();
	var pageSize = $("#sizePerPage").val();
	var url = pathHeader + "/master/quertJudgeDetail.do";
	$.ajax({
		url:url,
		data:{
		comparisonId:comparisonId,
		masterId:masterId,
		startIndex:startIndex,
		pageSize:pageSize
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				var rows = data.rows;
				var gridHtml = "";
				if(rows.length > 0){
					$.each(rows,function(index,element){
						gridHtml += getTdHtml(element);
					});
					$("#proList1").html(gridHtml);
					pagination(data, function(){queryTeacher();});
					$("#proList1").html(gridHtml);
				}else{
					$('#proList1').html("<tr><td colspan='14'>无查询记录</td></tr>");
					pagination(data, function(){queryTeacher();});
				}
				
			}
			
		},
		error:function(){
			
		}
	});
}

function getTdHtml(obj){
	var gridHtml = "<tr>";
	if(obj.teacherImg != null && obj.teacherImg != ""){
		gridHtml += "<td><img id='masterPhoto'  style='height: 99px; width:71px;margin-top:2px' src='"+pathHeader+"/uploadFile/"+obj.teacherImg+"' title='头像' /></td>";
	}else{
		gridHtml += "<td><img id='masterPhoto'  style='height: 99px; width:71px;margin-top:2px' src='"+pathHeader+"/static/photo/teacher_default.png' title='头像' /></td>";
	}
	gridHtml += "<td>"+obj.teacherName+"</td>";
	gridHtml += "<td>"+obj.idNumber+"</td>";
	gridHtml += "<td>"+obj.sectionName+"</td>";
	gridHtml += "<td>"+obj.subjectName+"</td>";
	gridHtml += "<td>"+obj.schoolName+"</td>";
	gridHtml += "<td>"+obj.expertScore+"</td>";
	gridHtml += "<td>"+obj.memo+"</td>";
	gridHtml +="</tr>";
	return gridHtml;
}

