$(function(){
	queryRecords();
});
function toTrainScorePage(){
	window.location.href = pathHeader + "/sys/queryTeacherTraningScoreInfo.htm?click=22";
}
function queryRecords(){
	var url = pathHeader + "/sys/queryTeacherTrainHistoryList.do";
	$("#records").html("");
	var importDate = $("#importDate").val();
	$.ajax({
		url:url,
		data:{
		startIndex:$("#pageIndex").val(),
		historyType :'teacherTrainScore',
		importDate:importDate
		},
		async:false,
		type:"post",
		success:function(data){
			var rows = data.rows;
			if(data.success && rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#records').append(gridHtml);
				pagination(data, function(){queryRecords();});
				
			}else{
				$('#records').html("<tr><td colspan='6'>无查询记录</td></tr>");
				pagination(data, function(){queryRecords();});
			}
		},
		error:function(){
			
		}
		
	});
	
}

function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.createDateStr+"</td>";
	gridHtml += "<td>"+obj.optionRealName+"</td>";
	gridHtml += "<td>"+obj.address+"</td>";
	gridHtml += "<td>"+obj.importSuccessCount+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		returnStr += 	 "<a href='###' class='tablelink' onclick='listRecords(\"" + obj.id + "\");'>查看导入记录</a>&nbsp;&nbsp;&nbsp;";
		return returnStr;
	}
}
function listRecords(id){
	var url = pathHeader + "/sys/queryTeacherTraningScoreInfo.htm?click=22&id="+id+"&flag=1";
	window.location.href=url;
}