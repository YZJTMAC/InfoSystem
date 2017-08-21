$(function(){
	queryPxxsList();
	projectList();
	
});

function queryPxxsList(){
	var url = pathHeader+ "/org/queryPxxsList.do";
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
				$("#projectTrainType").append("<option  value=''>请选择</option>");
				$.each(data.rows, function(key, value) {
					$("#projectTrainType").append(
							"<option  value=\"" + value.dictionaryId + "\">"
							+ value.dictionaryName + "</option>");
				});
			}
		},
		error:function(){
			
		}
	});
	
}

function projectList(){
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	var url = pathHeader+ "/edupm/projectmanage/queryProjectByStatus.do";
	$('#proList1').html("");
	$.ajax({
		url:url,
		type:"post",
		data:{
			year:$("#year").val(),
			startIndex : pageIndex,
			pageSize:sizePerPage,
			status:status,
			projectTrainType:$('#projectTrainType').val(),
			projectName:$('#projectName').val(),
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
				$('#proList1').append(gridHtml);
				
				pagination(data, function(){projectList();});
			}else{
				$('#proList1').html("<tr><td colspan='8'>无查询记录</td></tr>");
			}
		},
		error:function(){
			$('#proList1').html("<tr><td colspan='8'>无查询记录</td></tr>");
		}
		
	});

}

function pInfo(id,createBy){
	var url = pathHeader+ "/edupm/projectmanage/projectInfo.htm?click=20&proId="+id+"&createBy="+createBy;
	//openWindow(url);
	window.open(url);
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
	//实施机构、创建项目者所属地区和登陆者地区相同，方可查看
//	if(obj.createByArea == areaId || obj.organizationId == orgId){
		gridHtml += "<td><a href='javascript:pInfo("+obj.id+",\"" + obj.createBy + "\")'>"+obj.projectName+"</a></td>";
//	}
//	else{
//		gridHtml += "<td>"+obj.projectName+"</td>";
//	}
	gridHtml += "<td>"+ps+"</td>";
	gridHtml += "<td>"+obj.planNum+"</td>";
	gridHtml += "<td>"+tn+"</td>";
	gridHtml += "<td>"+obj.applyer+"</td>";
	gridHtml += "<td>"+(obj.applyDate==null?'':obj.applyDate)+"</td>";
	gridHtml +="<td>"+(obj.status=="20"?"未审批":(obj.status=="22"?"审批不通过":(obj.status=="30"?"待启动":(obj.status=="50"?"已结束":"已关闭"))))+"</td>";
	gridHtml +="<td>"+obj.auditor+"</td></tr>";
	return gridHtml;
	
}