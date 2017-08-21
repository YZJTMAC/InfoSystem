var projectId;
$(function(){
	projectList();
});

//查询已经关闭的培训项目
function projectList(){
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	//var url = pathHeader+ "/edupm/projectmanage/projectListForStart.do";
	$('#proList1').html("");
	$.ajax({
		url:pathHeader + '/edupm/projectmanage/queryProjectByStatus.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectName : $('#projectName').val(),
			start:$("#beginDate").val(),
			end:$("#endDate").val(),
			startIndex : pageIndex,
			pageSize:sizePerPage,
			status:'50'
		},
		success:function(data){
			var rows = data.rows;
			var areaId = data.areaId;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element,areaId);
				});
				$('#proList1').append(gridHtml);
				pagination(data, function(){projectList();});
			}else{
				$('#proList1').html("<tr><td colspan='8'>无查询记录</td></tr>");
			}
		},
		error:function(){
			jQuery.generalAlert("URL ERROR!");
		}
		
	});
}


function getTdHtml(obj,areaId){
	var gridHtml = "<tr>";
	//创建项目者所属地区和登陆者地区相同，方可查看项目。
//	if(obj.createByArea == areaId){	
		gridHtml += "<td><a href='javascript:projectInfo("+obj.id+",\"" + obj.createBy +"\",\"" + obj.applyer+ "\")'>"+obj.projectName+"</a></td>";
//	}
//	else{
//		gridHtml += "<td>"+obj.projectName+"</td>";
//	}
	gridHtml += "<td>"+obj.startDate+"</td>";
	gridHtml += "<td>"+obj.endDate+"</td>";
	gridHtml += "<td>"+obj.planNum+"</td>";
	gridHtml += "<td>"+obj.attendNum+"</td>";
	gridHtml += "<td>"+obj.projectPropertyName+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	return gridHtml;
	
	function optionFormatter(row){
		
		var returnStr = "";
		if(row.status==60){
			returnStr += "已关闭";
		}else{
			returnStr += 	 "<a href='###' class='huibtn_a' onclick='toEnd(\"" + row.id + "\");'>关闭</a>&nbsp;&nbsp;&nbsp;";
		}
		//创建项目者所属地区和登陆者地区相同，方可关闭项目。
//		else if(obj.createByArea == areaId){
//			returnStr += 	 "<a href='###' class='huibtn_a' onclick='toEnd(\"" + row.id + "\");'>关闭</a>&nbsp;&nbsp;&nbsp;";
//		}
//		else{
//			returnStr += "";
//		}
		return returnStr;
	}
}



/**
 * 关闭项目
 */
function toEnd(id){
	
	jQuery.confirmWindow("提示","是否关闭项目？",function(){
		var url = pathHeader + "/edupm/projectmanage/changeProjectStatus.do";
		  $.ajax({
		   url:url,
		   data:{projectId:id,status:60},
		   type:"post",
		   async:true,
		   success:function(data){
		    if(data.success){
		     projectList();
		     jQuery.generalAlert("项目关闭成功！");
		     $("#tip").hide();
		    }
		   },
		   error:function(){
		    jQuery.generalAlert("URL ERROR!");
		   }
		  });
	});
	
}



function showMe(){
	$('#tip').show();
}

function hideMe(){
	$('#tip').hide();
}