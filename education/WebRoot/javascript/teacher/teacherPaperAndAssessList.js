$(function(){
	projectList();
});

function projectList(){
	$('#proList').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	
	var url = pathHeader+ "/teacher/teacherProject/searchTeacherCloseProjectList.do";
	
	$.ajax({
		url:url,
		type:"post",
		data:{
			projectName : $('#projectName').val(),
			start : $('#beginDate').val(),
			end : $('#endDate').val(),
			pageIndex : pageIndex,
			pageSize:sizePerPage,
			status:50
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
				$('#proList').html("<tr><td colspan='8'>无查询记录</td></tr>");
			}
		},
		error:function(){
			
		}
		
	});
	
}


function getTdHtml(obj){
	var tn = "";
	var ps = "";
	if(obj.projectScopeName!="请选择"){
		ps = obj.projectScopeName;
	}
	if(obj.trainTypeName!='请选择'){
		tn = obj.trainTypeName;
	}
	var gridHtml = "<tr>";
	gridHtml += "<td><a href='javascript:setup("+obj.projectId+")'>"+obj.projectName+"</a></td>";
	gridHtml += "<td>"+obj.startDate+"</td>";
	gridHtml += "<td>"+obj.endDate+"</td>";
	gridHtml += "<td>"+obj.trainTypeName+"</td>";
	gridHtml += "<td>"+obj.projectPropertyName+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		returnStr += 	 "<a href='###' class='tablelink' onclick='setup(\"" + row.projectId + "\");'>调查问卷</a>&nbsp;&nbsp;&nbsp;";
		return returnStr;
	}
}


function openWindow(url){
	window.location.href = url;
}

function qryPro(){
	if(validateYear()){
		projectList();
	}else{
		jQuery.generalAlert("查询开始年度不能大于结束年度！");
	}
}


function setup(id){
	var url = pathHeader + "/teacher/teacherProject/teacherPaperListPage.htm?click=11&proId="+id;
	openWindow(url);
}
