$(function(){
	getProjectList();
});

function getProjectList(){	
	$('#target').html("");
	var pageSize = $("#pageSize").val();
	var pageIndex = $("#pageIndex").val();
	var projectName = $('#projectName').val();
	var projectYear = $('#projectYear').find("option:selected").val();
	$.ajax({
		url : pathHeader + '/org/findTeacherScoreProjectList.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectName : projectName,
			projectYear : projectYear,			
			pageIndex : pageIndex,
			pageSize : pageSize
		},
		success:function(data){
			if(data.success) {				
				var rows = data.rows;
				var areaId = data.areaId;
				var orgId = data.orgId;
				var roleId = data.roleId;
				if(rows.length > 0){
					var gridHtml = "";				
					$.each(rows, function(index,element) {
						gridHtml += getTdHtml(element,areaId,orgId,roleId);
					});
					$('#target').append(gridHtml);
				}
				else{
					gridHtml = "<tr><td align='center'colspan='7'>暂无查询结果！</td></tr>";				
					$('#target').html("");
					$('#target').append(gridHtml);		
				}
				pagination(data, function() {					
					getProjectList();
				});
				 
			} else {
				gridHtml = "<tr><td align='center'colspan='7'>暂无查询结果！</td></tr>";				
					$('#target').html("");
					$('#target').append(gridHtml);				
			}
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='7'>错误,暂无查询结果！</td></tr>";
			$('#target').append(gridHtml);
		}
	}); 
}

function getTdHtml(obj,areaId,orgId,roleId){
	var gridHtml = "<tr>";		
	//实施机构、 创建项目者所属地区和登陆者地区相同，方可查看项目信息。	
//	if (obj.createByArea == areaId || obj.organizationId == orgId) {
		gridHtml += "<td><a href='javascript:projectInfo("+obj.projectId+",\"" + obj.createBy +"\",\"\")'>" + obj.projectName + "</a></td>";
//	} else {
//		gridHtml += "<td>" + obj.projectName + "</td>";
//	}
	gridHtml += "<td>"+obj.trainTypeName+"</td>";
	gridHtml += "<td>"+obj.planNum+"</td>";
	gridHtml += "<td>"+obj.attendNum+"</td>";
	gridHtml += "<td>"+obj.shenheNum+"</td>";
	gridHtml += "<td>"+obj.weishenheNum+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		
		//校管理员查看无区域限制
//		if(roleId == 4){
//			returnStr += "<a href='toTeacherScoreViewPage.htm?click=4&projectId="+row.projectId+"&pubRule="+row.scorePublishRule+"&lvRule="+row.scoreLevelRule+"&projectName="+row.projectName+"' class='tablelink'>查看</a>";
		
//		}else{
			//实施机构、 创建项目者所属地区和登陆者地区相同，方可查看。
//			if(row.createByArea == areaId || row.organizationId == orgId) {
				returnStr += "<a href='toTeacherScoreViewPage.htm?click=4&projectId="+row.projectId+"&pubRule="+row.scorePublishRule+"&lvRule="+row.scoreLevelRule+"&projectName="+row.projectName+"' class='tablelink'>查看</a>";
//			}else{
//				returnStr += "";
//			}
//		}
		return returnStr;
	}
}