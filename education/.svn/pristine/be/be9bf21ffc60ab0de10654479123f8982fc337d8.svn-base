$(function(){
	queryRecords();
})

function queryRecords(){
	var url = pathHeader + "/edupm/teachermanage/importTeacherRecords.do";
	$.ajax({
		url:url,
		data:{
		historyType:"retirees",
		startIndex:$("#pageIndex").val()
		},
		async:false,
		type:"post",
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#records').append(gridHtml);
				pagination(data, function(){queryRecords();});
			}else{
				$('#records').html("<tr><td colspan='6'>无查询记录</td></tr>");
			}
		},
		error:function(){
			
		}
		
	});
	
}

function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.year+"</td>";
	gridHtml += "<td>"+obj.optDate+"</td>";
	gridHtml += "<td>"+obj.name+"</td>";
	gridHtml += "<td>"+obj.address+"</td>";
	gridHtml += "<td>"+obj.total+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		returnStr += 	 "<a href='###' class='tablelink' onclick='listRecords(\"" + row.id + "\");'>查看导入记录</a>&nbsp;&nbsp;&nbsp;";
		return returnStr;
	}
}


function listRecords(id){
	var url = pathHeader + "/edupm/teachermanage/toImportRecordsListPage.htm?historyType=retirees&click=4&id="+id;
	window.location.href=url;
}