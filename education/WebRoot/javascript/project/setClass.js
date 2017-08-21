$(function(){
	projectList();
});

function projectList(){
	$('#proList').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	
	var url = pathHeader+ "/edupm/projectmanage/proClassList.do";
	
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
				pagination(data, function(){projectList();});
			}else{
				$('#proList').html("<tr><td colspan='4'>无查询记录</td></tr>");
			}
		},
		error:function(){
			
		}
		
	});
	
}


function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.projectName+"</a></td>";
	gridHtml += "<td>"+obj.year+"</td>";
	gridHtml += "<td>"+(obj.classes==null?"":obj.classes)+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		returnStr += 	 "<a href='###' class='tablelink' onclick='setClass(\"" + row.projectId + "\");'>设置课程</a>&nbsp;&nbsp;";
		returnStr += 	 "<a href='###' class='tablelink' onclick='viewClass(\"" + row.projectId + "\");'>查看机构课程</a>";
		return returnStr;
	}
}
function qryPro(){
	if(validateYear()){
		projectList();
		
	}else{
		jQuery.generalAlert("查询开始年度不能大于结束年度！");
	}
}

function setClass(id){
	var url = pathHeader + "/edupm/projectclass/toClassListPage.htm?click=5&proId="+id;
	openWindow(url);
}

function viewClass(id){
	var url = pathHeader + "/edupm/projectclass/toOrgClassPage.htm?click=5&proId="+id;
	openWindow(url);
}