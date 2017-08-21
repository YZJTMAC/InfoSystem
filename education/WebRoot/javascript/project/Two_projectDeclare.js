$(function(){
	queryProject(1);
	
	//待申报
	$('#select_1').click(function(){
		queryProject(1);
	});
	//审批通过
	$('#select_2').click(function(){
		queryProject(2);
	});
	//审批未通过
	$('#select_3').click(function(){
		queryProject(3);
	});
	//已申报的项目
	$('#select_4').click(function(){
		queryProject(4);
	});
});


/**
 * 待分配/已分配	tip切换
 * @param {Object} type
 */
function change(type){
	if(type == 1){
		$('#tab_1').attr('class','selected');
		$('#tab1').show();
		$('#tab_2').attr('class','');
		$('#tab2').hide();
		$('#tab_3').attr('class','');
		$('#tab3').hide();
		$('#tab_4').attr('class','');
		$('#tab4').hide();
		queryProject(1);
	}
	 if(type == 2){
		$('#tab_1').attr('class','');
		$('#tab1').hide();
		$('#tab_2').attr('class','selected');
		$('#tab2').show();
		$('#tab_3').attr('class','');
		$('#tab3').hide();
		$('#tab_4').attr('class','');
		$('#tab4').hide();
		queryProject(2);
	}else if(type == 3){
		$('#tab_1').attr('class','');
		$('#tab1').hide();
		$('#tab_2').attr('class','');
		$('#tab2').hide();
		$('#tab_3').attr('class','selected');
		$('#tab3').show();
		$('#tab_4').attr('class','');
		$('#tab4').hide();
		queryProject(3);
	}
	else if(type == 4){
		$('#tab_1').attr('class','');
		$('#tab1').hide();
		$('#tab_2').attr('class','');
		$('#tab2').hide();
		$('#tab_3').attr('class','');
		$('#tab3').hide();
		$('#tab_4').attr('class','selected');
		$('#tab4').show();
		queryProject(4);
	}
}


function queryProject(status){
	$('#table_list_1').html('');
	$('#table_list_2').html('');
	$('#table_list_3').html('');
	$('#table_list_4').html('');
	
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	
	var projectName;
	var startDate;
	var endDate;
	var statusVal;
	//条件查询
	if(status == 1){
		projectName = $('#projectName').val();
		startDate = $('#beginDate').find("option:selected").val();
		endDate = $('#endDate').find("option:selected").val();
		statusVal = "10";
	} else if(status == 2){
		projectName = $('#projectName2').val();
		startDate = $('#beginDate2').find("option:selected").val();
		endDate = $('#endDate2').find("option:selected").val();
//		statusVal = "21";
		statusVal = "30";
	} else if(status == 3){
		projectName = $('#projectName3').val();
		startDate = $('#beginDate3').find("option:selected").val();
		endDate = $('#endDate3').find("option:selected").val();
		statusVal = "22";
	}
	//已申报，待审核。
	else if(status == 4){
		projectName = $('#projectName4').val();
		startDate = $('#beginDate4').find("option:selected").val();
		endDate = $('#endDate4').find("option:selected").val();
		statusVal = "20";
	}
	
	$.ajax({
		url : pathHeader + '/edupm/projectmanage/queryProjectByStatus.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectName : projectName,
			start : startDate,
			end : endDate,
			status : statusVal,
			pageSize : sizePerPage,
			startIndex : pageIndex
		},
		success:function(data){
				var objList = data.rows;
				var orgId = data.orgId;
				var accLog = data.accLog;
				var areaId = data.areaId;
				
				if(objList.length>0){
					var gridHtml = "";
					$.each(objList, function(index,element) {
						gridHtml += getTdHtml(element, status,orgId,accLog,areaId);
					});
					
					if(status == 1){					
						$('#table_list_1').append(gridHtml);					
					} else if(status == 2){					
						$('#table_list_2').append(gridHtml);					
					} else if(status == 3){
						$('#table_list_3').append(gridHtml);					
					}else if(status == 4){
						$('#table_list_4').append(gridHtml);
					}
					
				}else{
					changeTip(status);
				}
				
			if(status==1){
				pagination(data, function(){queryProject(1);});
			}else if(status==2){
				pagination(data, function(){queryProject(2);});
			}else if(status==3){
				pagination(data, function(){queryProject(3);});
			}else if(status==4){
				pagination(data, function(){queryProject(4);});
			}
		},
		error:function(){
			alert("error");
		}
	});
}


/**
 * 	查不出数据时
 * @param {Object} status
 */
function changeTip(status){
	if(status == 1){
		gridHtml = "<tr><td align='center'colspan='9'>暂无查询结果！</td></tr>";
		$('#table_list_1').append(gridHtml);
	}else if(status == 2){
		gridHtml = "<tr><td align='center'colspan='10'>暂无查询结果！</td></tr>";
		$('#table_list_2').append(gridHtml);
	}else if(status == 3){
		gridHtml = "<tr><td align='center'colspan='10'>暂无查询结果！</td></tr>";
		$('#table_list_3').append(gridHtml);
	}else if(status == 4){
		gridHtml = "<tr><td align='center'colspan='9'>暂无查询结果！</td></tr>";
		$('#table_list_4').append(gridHtml);
	}
}

function getTdHtml(obj, status,orgId,accLog,areaId){
	var gridHtml = "<tr>";
	if(status == 1){
		gridHtml += "<td id='projectName'>"+nullFormatter(obj.projectName)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.startDate)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.endDate)+"</td>";
		gridHtml += "<td>"+obj.classPeriod+"学时"+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.planNum)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.trainTypeName)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.projectScopeName)+"</td>";
		gridHtml += "<td>"+obj.createBy+"</td>";
		gridHtml += "<td>"+optionFormatter(obj)+"</td>";
	} else if(status == 2){
		gridHtml += "<td id='projectName'>"+nullFormatter(obj.projectName)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.projectPropertyName)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.planNum)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.trainTypeName)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.applyer)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.applyDate.replace(".0",""))+"</td>";
		gridHtml += "<td>"+auditStatusFormatter(obj.auditStatus)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.createBy)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.auditDate.replace(".0",""))+"</td>";
		gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	} else if(status == 3){
		gridHtml += "<td>"+nullFormatter(obj.projectName)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.projectPropertyName)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.planNum)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.trainTypeName)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.applyer)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.applyDate.replace(".0",""))+"</td>";
		gridHtml += "<td><a href='###' class='huibtn_a' onclick='auditInfo(\"" + obj.id + "\");'>"+auditStatusFormatter(obj.auditStatus)+"</a></td>";
		gridHtml += "<td>"+nullFormatter(obj.createBy)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.auditDate.replace(".0",""))+"</td>";
		gridHtml += "<td>"+optionFormatterFalse(obj)+"</td></tr>";
	} 
	else if(status == 4){
		gridHtml += "<td>"+nullFormatter(obj.projectName)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.startDate)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.endDate)+"</td>";
		gridHtml +="<td>"+obj.classPeriod+"学时"+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.planNum)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.trainTypeName)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.projectPropertyName)+"</td>";
		gridHtml +="<td>"+obj.applyer+"</td>";
		gridHtml += "<td>"+optionFormatterFalse(obj)+"</td></tr>";
	} 
	
	return gridHtml;
	
	function nullFormatter(obj){
		if(obj==null || obj=='null' || obj.length==0){
			return '';
		} else {
			return obj;
		}
	}
	
	function optionFormatter(obj){
		var str = "";
		
		//实施机构、创建者所属地区和登陆者地区相同的才有操作权限
		if(obj.organizationId==orgId || obj.createByArea==areaId){
			//待申报
			if(obj.status == 10){
				str += "<a href='###' class='huibtn_a' onclick='showConfirm(\"" + obj.id + "\",\"" + obj.projectName + "\");'>申 报</a> &nbsp;&nbsp;&nbsp;";
				str += "<a href='###' class='huibtn_a' onclick='projectInfo(\"" + obj.id + "\");'>查看</a> &nbsp;&nbsp;&nbsp;";
				str += "<a href='###' class='huibtn_a' onclick='downloadProjectInfo(\"" + obj.id + "\");'>下载申报模板</a> &nbsp;&nbsp;&nbsp;";
			}
			
			//审批通过
//			if(obj.status == 21){
			//审核通过状态由21更改为30(待启动状态),同时废弃开始筹备项目操作
			if(obj.status == 30){
//				str +="<a href='###' class='huibtn_a' onclick='begin(\"" + obj.id + "\");'>开始筹备项目</a>&nbsp;&nbsp;&nbsp;";
				str += "<a class='huibtn_a' href='javascript:projectInfo("+obj.id+",\"" + obj.createBy + "\",\"" + obj.auditStatus  + "\",\"" + obj.applyer+ "\");'>查看</a>";
			}
			
		}else{
			str +="";
		}
		return str;	
	}
	
//	function optionFormatterFalse(obj){
//		return 	"<a href='###' class='huibtn_a' onclick='editProject(\""+obj.id+"\");'>编辑项目</a>";
//	}
	
	//重新申报
	function optionFormatterFalse(obj){
		var returnStr = "";
		//if(obj.status == 22  && obj.organizationId==orgId || obj.createBy==accLog){
		//状态为22、实施机构、创建者所属地区和登陆者地区相同的才有操作权限
		if(obj.status == 22  && obj.organizationId==orgId || obj.createByArea==areaId){
			/*returnStr += 	 "<a href='###' class='huibtn_a' onclick='setup(\"" + row.id + "\");'>编 辑</a>&nbsp;&nbsp;&nbsp;";
			returnStr += "<a href='###' class='huibtn_a' onclick='del(\"" + row.id + "\");'>删 除</a> &nbsp;&nbsp;&nbsp;";*/
			returnStr += "<a href='javascript:showConfirm("+obj.id+",\""+obj.projectName+"\")' class='huibtn_a'>重新申报</a>";
			returnStr += "<a class='huibtn_a' href='javascript:projectInfo("+obj.id+",\"" + obj.createBy +"\",\"" + obj.applyer+ "\")'>查看</a>";
		}
		return returnStr;
	}

	
	function auditStatusFormatter(auditStatus){
		if(auditStatus == 1){
			return '审核通过';
		} else {
			return '审核不通过';
		}
	}
	
}

/**
 * 开始筹备项目
 * @param {Object} id
 */
/*function begin(id){
	var url = pathHeader + "/edupm/projectmanage/prepareProject.do";
	$.ajax({
		url:url,
		data:{projectId:id},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				queryProject(2);
			}
			else{
				jQuery.generalAlert("筹备项目失败!");
			}
		},
		error:function(){
			alert("URL ERROR!");
		}
		
	});
}*/
function editProject(id){
	var url = pathHeader + "/edupm/projectmanage/toModifyDeclareProPage.htm?click=21&proId="+id;
	openWindow(url);
	}



var pid = null;
//查看上传文件
function showConfirm(id,pName){
	$("#projectName10").html(pName);
	$('#projectId').val(id);
	$("#projectName3").val(pName);
	pid = id;
	var url = pathHeader + "/fileupload/viewFiles.do?time="+(new Date()).getTime();
	$.ajax({
		cache: false,
  		dataType: 'json',  
  		url:url,
  		async:"true",
  		type:'post',
  		data : {
			projectId : pid,
			type : "declare"
			//roleId : "7"实施机构不分角色
		},
  		success:function(data){
			var table = "<tr><td width='5%'>序号</td><td width='43%'>文件名</td><td width='12%'>上传人</td><td width='25%'>上传时间</td><td colspan='2' width='15%'>操作</td><tr>";
			$
					.each(
							data.files,
							function(i, item) {
								table += "<tr><td>"
										+ (i + 1)
										+ "</td><td><a href='javascript:void(0)'; onclick='previewFile(\""+item.url+"\");'>"
										+ item.name
										+ "</a></td><td>"+item.userName+"</td>"
										+ "<td>"+nullFormatter(item.createDate.replace(".0",""))+"</td><td>"
										+ "<a href='#' onclick=downloadFile('"
										+ item.url
										+ "') >下载 </a></td>"
										+ "<td><a href='#' onclick= removeFile('"
										+ item.id + "','" + item.url
										+ "','"
										+ item.projectId
										+ "') >删除 </a>" + "</td></tr>";
							});
			$("#hasUpload").html(table);
			$('#myModal').modal('show');
  		},
  		
  		error:function(XMLHttpRequest, textStatus, errorThrown){
  			jQuery.generalAlert("查询数据出错！请联系管理员");
		}
  	});

}


//申报项目
function declare(){
	//$("#noUpload").remove();
jQuery.confirmWindow("提示","是否申报项目？",function(){
	var url = pathHeader +"/edupm/projectmanage/declareProject.do";
	$("#declareForm").ajaxSubmit({
		url:url,
		type:"post",
		async:true,
		success:function(data){
			var jsonData =jQuery.parseJSON(data);
			if(jsonData.success){
				jQuery.generalAlert("项目申报成功，等待跳转");
				setInterval(function() {
					location.reload();
				}, 2000);
			}else{
				jQuery.generalAlert(jsonData.info);
			}
		},
		error:function(){
			jQuery.generalAlert("URL ERROR !");
		}
	});
});
}

/**
 * 项目审核详情
 * @param {Object} id
 */
function auditInfo(id){
	var url = pathHeader +"/edupm/projectmanage/projectAuditInfo.do";
	$.ajax({
		url:url,
		data:{
			projectId:id
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				//$("#reason").show();
				$("#reason").html(data.obj.memo);
				$("#auditReasonModal").modal("show");
			}
		},
		error:function(){
			jQuery.generalAlert("URL ERROR!");
		}
		
	});
}



/**
 * id:总结报告id filePath：文件名 pid：项目id
 */
function removeFile(id, filePath, pid) {
	jQuery
			.confirmWindow(
					"提示",
					"是否删除该文件？",
					function() {
						var url = pathHeader
								+ "/fileupload/deleteFile.do?";
						$
								.ajax({
									dataType : 'json',
									type : 'post',
									url : url,
									data : {
										id : id,
										filePath : filePath,
										pid : pid
									},
									success : function(data) {
										jQuery.generalAlert("删除成功");
										$(".addMore").html('');
										$('#myModal').modal('hide');
									},
									error : function() {
										jQuery.generalAlert("删除失败");
									}
								});
					});

}

// 下载文件
function downloadFile(filePathName) {
	// 下载能使用jquery的ajax，因为ajax的返回值不支持流
	var url = pathHeader + '/fileupload/downloadFiles.do';
	var form = $("<form>");// 定义一个form表单
	form.attr("style", "display:none");
	form.attr("method", "post");
	form.attr("action", url);
	var input = $("<input>");
	input.attr("type", "hidden");
	input.attr("name", "filePathName");
	input.attr("value", filePathName);
	$("body").append(form);// 将表单放置在web中
	form.append(input);
	form.submit();// 表单提交
}

//实施管理员下载申报模板
function downloadProjectInfo(pid){
	var url = pathHeader + "/fileupload/otherViewFiles.do?time="+(new Date()).getTime();
	$.ajax({
		cache: false,
  		dataType: 'json',  
  		url:url,
  		async:"true",
  		type:'post',
  		data : {
			projectId : pid,
			type : "declareTemplate"
		},
  		success:function(data){
  			var table = "<tr align='center'><td width='10%'>序号</td><td width='40%'>文件名</td><td width='10%'>上传人</td><td width='20%'>上传时间</td><td width='20%'>操作</td><tr> ";
			$.each(
					data.files,
					function(i, item) {
						table += "<tr><td width='10%'>"
								+ (i + 1)
								+ "</td><td width='40%'><a href='javascript:void(0)'; onclick='previewFile(\""+item.url+"\");'>"
								+ item.name
								+ "</a></td><td width='10%'>"+item.userName+"</td>"
								+ "<td width='20%'>"+nullFormatter(item.createDate.replace(".0",""))+"</td><td width='20%'>"
								+ "<a href='#' onclick=downloadFile('"
								+ item.url
								+ "') >下载申报模板</a></td>"
								+ "<td></td></tr>";
							});
			$("#viewTable").html(table);
			$('#declareViewModal').modal('show');
  		},
  		
  		error:function(XMLHttpRequest, textStatus, errorThrown){
  			jQuery.generalAlert("查询数据出错！请联系管理员");
		}
  	});
}
