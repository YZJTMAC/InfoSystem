$(function(){
	projectList();
});

function projectList(){
	$('#proList').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	
	var url = pathHeader+ "/org/orgProClassList.do";
	
	$.ajax({
		url:url,
		type:"post",
		data:{
			projectName : $('#projectName').val(),
			start : $('#beginDate').val(),
			end : $('#endDate').val(),
			startIndex : pageIndex
		},
		async:true,
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#proList').append(gridHtml);
			}else{
				$('#proList').html("<tr><td colspan='12'>无查询记录</td></tr>");
			}
			pagination(data, function(){projectList();});
		},
		error:function(){
			
		}
		
	});
	
}


function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+nullFormatter(obj.projectName)+"</a></td>";
	gridHtml += "<td>"+nullFormatter(obj.year)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.className)+"</td>";
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
		var returnStr = "";
		returnStr += 	 "<a href='###' class='tablelink' onclick='setClass(\""+row.projectId+"\",\""+row.projectName+"\",\""+(row.planNum==null?-1:row.planNum)+"\");'>设置课程</a>";
		return returnStr;
	}
}
function qryPro(){
	projectList();
}

function setClass(projectId, projectName, planNum){
	var openUrl = pathHeader + "/org/toProClassPage.htm?click=13&projectId="+projectId+"&projectName="+projectName+"&planNum="+planNum;
	window.location.href = openUrl;
	//openWindow(url);
}