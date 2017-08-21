$(function(){
	projectList();
});
//查询项目调查与评估管理列表
function projectList(){
	$('#proList').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	
	//var url = pathHeader+ "/edupm/projectmanage/projectListForStart.do";
	
	$.ajax({
		url:pathHeader + '/edupm/projectmanage/queryProjectByStatus.do',
		type:"post",
		data:{
			projectName : $('#projectName').val(),
			start : $('#beginDate').val(),
			end : $('#endDate').val(),
			startIndex : pageIndex,
			pageSize:sizePerPage,
			status:'50',
			flag: "Y"  //此标识表示查询申报人所管理的项目
		},
		async:true,
		success:function(data){
			var rows = data.rows;
			var areaId = data.areaId;
			var orgId = data.orgId;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element,areaId,orgId);
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


function getTdHtml(obj,areaId,orgId){
	var tn = "";
	var ps = "";
	if(obj.projectScopeName!="请选择"){
		ps = obj.projectScopeName;
	}
	if(obj.trainTypeName!='请选择'){
		tn = obj.trainTypeName;
	}
	var gridHtml = "<tr>";
	//实施机构、创建项目者所属区域和登陆者统一区域，方可操作
//	if(obj.createByArea == areaId || obj.organizationId == orgId){
		gridHtml += "<td><a href='javascript:setup("+obj.id+")'>"+obj.projectName+"</a></td>";
//	}
//	else{
//		gridHtml += "<td>"+obj.projectName+"</td>";
//	}
	gridHtml += "<td>"+obj.startDate+"</td>";
	gridHtml += "<td>"+obj.endDate+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		//实施机构、创建项目者所属区域和登陆者统一区域，方可操作
//		if(row.createByArea == areaId || obj.organizationId == orgId){
			returnStr += 	 "<a href='###' class='tablelink' onclick='setup(\"" + row.id + "\");'>调查问卷管理</a>&nbsp;&nbsp;&nbsp;";
//		}
//		else{
//			returnStr += "";
//		}
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
		alert("查询开始年度不能大于结束年度！");
	}
}

function setup(id){
	var url = pathHeader + "/edupm/projectmanage/toProjectPaperListPage.htm?click=32&proId="+id;
	openWindow(url);
}
