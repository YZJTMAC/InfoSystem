var projectId;
$(function(){
	$('#tabPage0').click(function(){
		changeTab(1);
	});
	$('#tabPage1').click(function(){
		changeTab(2);
	});
	projectList();
});

/**
 * tab切换
 */
function changeTab(tab){
	if(tab == 1){
		$('#tabPage0').attr('class','selected');
		$('#tab1').show();
		$('#tabPage1').attr('class','');
		$('#tab2').hide();
		projectList();
	}
	 if(tab == 2){
		$('#tabPage0').attr('class','');
		$('#tab1').hide();
		$('#tabPage1').attr('class','selected');
		$('#tab2').show();
		getStartedProjectList();
	}
}

function projectList(){
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	
	var url = pathHeader+ "/edupm/projectmanage/projectListForStart.do";
	$('#proList1').html("");
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			projectName : $('#projectName').val(),
			start:$("#beginDate").val(),
			end:$("#endDate").val(),
			startIndex : pageIndex,
			pageSize:sizePerPage,
			status:30
		},
		beforeSend: function(){
			$('#proList1').html("<tr><td align='center' colspan='12'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
		},
		success:function(data){
			var rows = data.rows;
			var areaId = data.areaId;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element,areaId);
				});
				$('#proList1').html(gridHtml);
				pagination(data, function(){projectList();});
			}else{
				$('#proList1').html("<tr><td colspan='12'>无查询记录</td></tr>");
			}
		},
		error:function(){
			jQuery.generalAlert("URL ERROR!");
		}
		
	});
}

function getStartedProjectList(){
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	
	var url = pathHeader+ "/edupm/projectmanage/projectListForStart.do";
	$('#proList1').html("");
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			projectName : $('#projectName').val(),
			start:$("#beginDate").val(),
			end:$("#endDate").val(),
			startIndex : pageIndex,
			pageSize:sizePerPage,
			status:40
		},
		beforeSend: function(){
			$('#proList1').html("<tr><td align='center' colspan='12'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
		},
		success:function(data){
			var rows = data.rows;
			var areaId = data.areaId;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element,areaId);
				});
				$('#proList1').html(gridHtml);
				pagination(data, function(){getStartedProjectList();});
			}else{
				$('#proList1').html("<tr><td colspan='12'>无查询记录</td></tr>");
			}
		},
		error:function(){
			jQuery.generalAlert("URL ERROR!");
		}
		
	});
}

function getTdHtml(obj,areaId){
	/*var pass=0;
	
	var roleId= $("input[name='roleId']").val();
	alert(roleId);*/
	/*if(roleId==3){
		pass=obj.quPass;
		
	}else if(roleId==2){
		pass=obj.cityPass;
		
	}else if(roleId==1){
		pass=obj.provincePass;
		
	}*/
	
	var gridHtml = "<tr>";
	//创建项目者所属地区和登陆者地区相同，方可查看项目信息。
//	if(obj.createByArea == areaId){
		gridHtml += "<td><a href='javascript:projectInfo("+obj.id+",\"" + obj.createBy +"\",\"" + obj.applyer+ "\")'>"+obj.projectName+"</a></td>";
//	}
//	else{
//		gridHtml += "<td>"+obj.projectName+"</td>";
//	}
	gridHtml += "<td>"+obj.startDate+"</td>";
	gridHtml += "<td>"+obj.endDate+"</td>";
	gridHtml += "<td>"+obj.projectPropertyName+"</td>";
	gridHtml += "<td>"+obj.createBy+"</td>";
	gridHtml += "<td>"+obj.organizationName+"</td>";
	gridHtml += "<td>"+obj.applyer+"</td>";
	gridHtml += "<td>"+obj.planNum+"</td>";
	gridHtml += "<td>"+obj.signNum+"</td>";
	gridHtml += "<td>"+obj.auditor+"</td>";
	gridHtml += "<td>"+obj.pass+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		//创建项目者所属地区和登陆者地区相同，方可启动项目。
//		if(row.createByArea == areaId){
			if(row.status == 30){
				returnStr += 	 "<a href='###' class='huibtn_a' onclick='toStart(\"" + row.id + "\",\"" + row.projectName + "\","+ obj.signNum +","+ obj.pass +");'>启动</a>&nbsp;&nbsp;&nbsp;";
			}else if(row.status == 40){
				returnStr += "已启动";
			}else if(row.status == 50){
				returnStr += "已结束";
			}
//		}
//		else{
//			returnStr += "";
//		}
		return returnStr;
	}
}


var warnTip = '';	//未设置对接地址提示信息
var warnTipNum = 0;		//启动与否条件
function clear(){
	 warnTip = '';
	 warnTipNum = 0;
	 $("#orgStatus").html("");
}

/**
 * 查询指定的机构项目状态
 */
function toStart(id, projectName,signNum,passNum){
	clear();
	projectId = id;
	var url = pathHeader + "/edupm/projectmanage/queryOrgStatus.do";
	$.ajax({
		url:url,
		data:{projectId:id},
		type:"post",
		async:false,
		success:function(data){
			if(data.success){
				$("#proName").html("项目名称："+ projectName);
				
				var obj = data.obj;
				if(obj!=null){
					//培训形式为远程培训或混合培训时，启动时给出提示信息
					if(obj.trainTypeId==1 || obj.trainTypeId==3){
						if(obj.trainHomeAddr==null || obj.trainHomeAddr.length==0 || obj.trainHomeAddr=='http://' || obj.trainAddr==null || obj.trainAddr.length==0 || obj.trainAddr=='http://'){
							warnTip = '该项目未设置培训对接地址,';
						}
					}
					
					//报名人数或审核通过人数为0不能启动项目
					if(signNum==0 || passNum==0){
						warnTipNum = 2;
					}
					
					$("#orgStatus").html(getHtml(obj));
					
				}else{
					warnTipNum = 1;
					$("#orgStatus").html("<tr><td colspan='2'>未分配机构！</td></tr>");
				}
				
				$("#tip").show();
			}
		},
		error:function(){
			jQuery.generalAlert("URL ERROR!");
		}
	});
}

function getHtml(obj){
	var ss = "";
	ss += "<tr>";
	ss += "<td>"+obj.orgName+"</td>";
	ss += "<td>"+(obj.status==30?'待启动':'')+"</td>";
	ss +="</tr>";
	return ss;
}

/**
 * 启动项目
 */
function start(){
	if(warnTipNum==1){
		jQuery.generalAlert("项目尚未分配给机构！不能启动项目！");
	}else if(warnTipNum==2){
		jQuery.generalAlert("教师报名人数或审核通过人数为0！不能启动项目！");
	}else{
		jQuery.confirmWindow("提示", warnTip+"确定启动项目？",function(){
			var url = pathHeader + "/edupm/projectmanage/changeProjectStatus.do";
			$.ajax({
				dataType : 'json',
				type: "post",
				url: url,
				data:{projectId:projectId,status:40},
				async:false,
				success:function(data){
					if(data.success){
						jQuery.generalAlert("项目已启动！");
						projectList();
						$('#tip').hide();
					}
				},
				error:function(){
					jQuery.generalAlert("URL ERROR!");
				}
			});
		});
	}
}

function showMe(){
	$('#tip').show();
}

function hideMe(){
	$('#tip').hide();
}