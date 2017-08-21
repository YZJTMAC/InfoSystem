function projectList(flag){
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	var projectScopeName=null;
	if(flag == 1){
		projectScopeName="国培项目";
	}if(flag == 2){
		projectScopeName="省级培训项目";
	}if(flag == 3){
		projectScopeName="地市级培训项目";
	}if(flag == 4){
		projectScopeName="区县级培训项目";
	}if(flag == 5){
		projectScopeName="校本培训项目";
	}
	
	var url = pathHeader+ "/edupm/projectmanage/otherProject.do";
	$('#proList1').html("");
	$.ajax({
		url:url,
		type:"post",
		data:{
			projectName : $('#projectName').val(),
			startIndex : pageIndex,
			pageSize:sizePerPage,
			status:"30",
			signUpWay:3,
			queryFlag:1,
			projectScopeName:projectScopeName,
			start:$('#beginDate').val(),
			end:$('#endDate').val()
			
		},
		async:false,
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#proList1').append(gridHtml);
			}else{
				$('#proList1').html("<tr><td colspan='9'>无查询记录</td></tr>");
			}
			pagination(data, function(){projectList(flag);});
		},
		error:function(){
			alert("URL ERROR!");
		}
		
	});
}


function getTdHtml(obj){
	var roleId = $("input[name='roleId']").val();
	
	var areaId=$("input[name='areaId']").val();
	var num =obj.allocatePlanNum;
	if(roleId == 1 || roleId == 7 || obj.cid == areaId || obj.did == areaId){
		num = obj.planNum;
	}
	var ss = "";
	var suw = obj.signUpWay;
	if(suw == 3){
		ss = "层级分配/报名";
	}else if(suw == 2 ){
		ss = "自由报名";
	}else{
		ss = "组织报名";
	}
	var str = "";
	
	var gridHtml = "<tr>";
	// 修改BUG反馈 #2540培训项目》培训名额分配，现在显示为每分页4条，并且总数显示错误
	//zhaobichao 2014-12-23 原需求是上级分配给下级名额后方可显示结果，但只有项目创建区域和登陆者区域相同和上级分配给下级名额后方可有培训名额操作权限
	//修改成培训范围覆盖该下级也可显示结果，但只有项目创建区域和登陆者区域相同和上级分配给下级名额后方可有培训名额操作权限
	//if(num!=null){
	//gridHtml += "<td><a href='javascript:projectInfo("+obj.id+",\"" + obj.createBy + "\")'>"+obj.projectName+"</a></td>";
	//创建者所属地区和登陆者地区相同、分配给这个地区名额后的才有操作权限
//	if(obj.createByArea==areaId || obj.allocatePlanNum != null){
	if(obj.allocatePlanNum != null){
		gridHtml += "<td><a href='javascript:projectInfo("+obj.id+",\"" + obj.createBy +"\",\"" + obj.applyer+ "\")'>"+obj.projectName+"</a></td>";
	}
	else{
		gridHtml += "<td>"+obj.projectName+"</td>";
	}
	gridHtml +="<td>"+ss+"</td>";
	gridHtml +="<td>"+obj.trainScopeName+"</td>";
	gridHtml +="<td>"+obj.applyer+"</td>";
	gridHtml += "<td>"+obj.planNum+"</td>";
	gridHtml +="<td>"+(num==null?"未分配":num)+"&nbsp;</td>";
	gridHtml +="<td>"+obj.createBy+"</td>";
	gridHtml +="<td>"+obj.organizationName+"</td>";
	gridHtml +="<td>"+obj.auditor+"</td>";
	gridHtml +="<td>待启动</td>";
	//gridHtml += "<td><a href='javascript:toAllocate("+obj.id+")' class='huibtn_a'>分配名额</a></td>";
	//层级分配/报名
	if(suw == 3){
	gridHtml += "<td>"+optionFormatter(obj)+"</td>";
	}
	else{
			gridHtml += "<td>"+"不用分配名额"+"</td>";
	}
	/*}
	gridHtml += "</tr>";*/
	
	return gridHtml;
	
	function optionFormatter(obj){
		var str = "";
		//是否已经结束报名
		if(obj.hasStopSign == 0 ||obj.hasStopSign==null){
			//创建者所属地区和登陆者地区相同、分配给这个地区名额后的才有操作权限
			//if(obj.createByArea==areaId || obj.allocatePlanNum > 0 || obj.trainScopeId == areaId){
				str +="<a href='javascript:toAllocate("+obj.id+")' class='huibtn_a'>分配名额</a>";
			//}
			//else{
			//	str +="";
			//}
		}
		else{
			str +="报名已结束";
		}
		
		return str;	
	}
	
	
}
/**
 * 查询项目
 */
function qryPro(){
	var flag= $("input[name='flage']").val();
	projectList(flag);
}

function toAllocate(id){
	window.location.href = pathHeader + "/edupm/projectmanage/toAllocatePage.htm?flag="+flag+"&click=23&projectId="+id;
}