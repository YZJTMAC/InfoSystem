$(function(){
	projectList();
});

function projectList(){
	$('#proList').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	
	var url = pathHeader+ "/edupm/projectmanage/projectList.do";
	
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
				$('#proList').html("<tr><td colspan='8'>无查询记录</td></tr>");
			}
		},
		error:function(){
			alert("url error!");
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
	gridHtml += "<td><a href='javascript:projectInfo("+obj.id+")'>"+obj.projectName+"</a></td>";
	gridHtml += "<td>"+obj.startDate+"</td>";
	gridHtml += "<td>"+obj.endDate+"</td>";
	gridHtml += "<td>"+tn+"</td>";
	gridHtml += "<td>"+ps+"</td>";
	gridHtml += "<td>"+obj.planNum+"</td>";
	gridHtml +="<td>"+obj.classPeriod+"学时/"+obj.classScore+"学分"+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		if(row.status == 4){
			returnStr += 	 "<a href='###' class='tablelink' onclick='setup(\"" + row.id + "\");'>编 辑</a>&nbsp;&nbsp;&nbsp;";
			returnStr += "<a href='###' class='tablelink' onclick='del(\"" + row.id + "\");'>删 除</a>";
		}
		return returnStr;
	}
}

function projectInfo(id){
	var url = pathHeader+ "/edupm/projectmanage/projectInfo.htm?click=0&proId="+id;
//	openWindow(url);
	window.open(url);
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

