$(function(){
	$(".select3").uedSelect({
		width : 100
	});
	
	queryProject(1);
});


function change(type){
	if(type == 1){
		$('#tab_1').attr('class','selected');
		$('#tab1').show();
		$('#tab_2').attr('class','');
		$('#tab2').hide();
		queryProject(1);
	}
	 if(type == 2){
		$('#tab_1').attr('class','');
		$('#tab1').hide();
		$('#tab_2').attr('class','selected');
		$('#tab2').show();
		queryProject(2);
	}
}

function changeTip(tab){
	var gridHtml = "";
	if(tab == 1){
		gridHtml = "<tr><td align='center' colspan='10'>无查询记录</td></tr>";
		$('#table_list_1').append(gridHtml);
	}else if(tab == 2){
		gridHtml = "<tr><td align='center' colspan='10'>无查询记录</td></tr>";
		$('#table_list_2').append(gridHtml);
	}
}

function queryProject(tab){
	$('#table_list_1').html('');
	$('#table_list_2').html('');
	
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	
	var projectName;
	var startDate;
	var endDate;
	var status;
	
	if(tab == 1){
		projectName = $('#projectName').val();
		startDate = $('#beginDate').find("option:selected").val();
		endDate = $('#endDate').find("option:selected").val();
		status = "1";
	} else if(tab == 2){
		projectName = $('#projectName2').val();
		startDate = $('#beginDate2').find("option:selected").val();
		endDate = $('#endDate2').find("option:selected").val();
		status = "2";
	} 
	
	$.ajax({
		url: pathHeader+ "/edupm/projectmanage/proListForAudit.do",
		type: "post",
		data:{
			projectName : projectName,
			start : startDate,
			end : endDate,
			status : status,
			startIndex : pageIndex
		},
		async:true,
		success:function(data){
			var total = data.total;
			if(total > 0){
				var rows = data.rows;
				var gridHtml = "";
				var areaId = data.areaId;
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element,areaId);
				});
				
				if(tab == 1){					
					$('#table_list_1').append(gridHtml);					
				} else if(tab == 2){					
					$('#table_list_2').append(gridHtml);					
				} 
				
			}else{
				changeTip(tab);
			}
			
			if(tab==1){
				pagination(data, function(){queryProject(1);});
			}else if(tab==2){
				pagination(data, function(){queryProject(2);});
			}
		},
		error:function(){
			
		}
		
	});
	
}


function getTdHtml(obj,areaId){
	var total = obj.pass-0+obj.unPass-0;
	var gridHtml = "<tr>";
	gridHtml += "<td><a href='javascript:projectInfo("+obj.projectId+",\"" + obj.createBy +"\",\"" + obj.applyer+ "\")'>"+obj.projectName+"</a></td>";
	gridHtml += "<td>"+obj.startDate+"</td>";
	gridHtml += "<td>"+obj.endDate+"</td>";
	gridHtml += "<td>"+obj.createBy+"</td>";
	gridHtml += "<td>"+obj.planNum+"</td>";
	gridHtml += "<td>"+obj.applyer+"</td>";
	gridHtml += "<td>"+obj.pass+"</td>";
	gridHtml += "<td>"+obj.unAudit+"</td>";
	gridHtml += "<td>"+obj.unPass+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		if(obj.hasStopSign == 0 ||obj.hasStopSign==null){
			//登陆者的areaId和创建项目者的createByArea相等，才可以操作。
//			if(areaId == row.createByArea){
				returnStr += 	 "<a href='###' class='tablelink' onclick='stopSign(\"" + row.projectId + "\");'>结束报名</a>&nbsp;&nbsp;&nbsp;";
				returnStr += 	 "<a href='###' class='tablelink' onclick='audit(\"" + row.projectId + "\");'>审 核</a>&nbsp;&nbsp;&nbsp;";
//			}
//			else{
//				returnStr += "不在操作范围内！";
//			}
		}
		else{
			returnStr += 	 "报名已结束";
		}
		return returnStr;
	}
}

function audit(projectId){
/*	var url = pathHeader + "/edupm/projectmanage/isReport.do";
	$.ajax({
		url:url,
		data:{projectId:projectId},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				var url = pathHeader + "/edupm/projectmanage/toTeacherListForAudit.htm?click=26&projectId="+projectId;
				openWindow(url);
			}else{
				jQuery.generalAlert("请进行名额上报，再进行审核！");
			}
		},
		error:function(){
			jQuery.generalAlert("URL Error!");
		}
	});*/
	var url = pathHeader + "/edupm/projectmanage/toTeacherListForAudit.htm?click=26&projectId="+projectId;
	openWindow(url);
}

function stopSign(projectId){
	jQuery.confirmWindow(	"提示","是否确定结束报名？",	function() {
	var url = pathHeader + "/edupm/projectmanage/stopSign.do";
	$.ajax({
		url:url,
		data:{projectId:projectId},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				if($("#tab_1").hasClass("selected")){
					queryProject(1);
				}else if($("#tab_2").hasClass("selected")){
					queryProject(2);
				}
				
			}else{
				jQuery.generalAlert("名额没有全部上报，不能结束报名！");
			}
		},
		error:function(){
			jQuery.generalAlert("URL Error!");
		}
	});
			});
}