var pid;
$(function(){
	projectList1();	
	/**
	 * 项目审核
	 */
	 $(".sure").click(function(){
		 var url = pathHeader + "/edupm/projectmanage/auditProject.do";
		 $.ajax({
			 url:url,
			 data:{
			 	projectId:pid,
			 	audtiStatus:$("input[name='radio']:checked").val(),
			 	memo:$("#memo").val()
			 },
			 type:"post",
			 async:false,
			 success:function(data){
				 if(data.success){
					 jQuery.generalAlert("审核成功！");
					 projectList1();
				 }
			 },
			 error:function(){
				 jQuery.generalAlert("审核出现错误，请联系相关人员 !");
			 }
		 });
//	  	$(".tip").fadeOut(100);
		 $("#auditModal").modal("hide");
	});
});

function projectList1(){
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();	
	var	statusVal = "20";
	var url = pathHeader + "/edupm/projectmanage/queryProjectForAudit.do";
	$('#proList1').html("");
	$.ajax({
		url:url,
		type:"post",
		data:{
			projectName : $('#projectName1').val(),
			start:$("#beginDate1").val(),
			end:$("#endDate1").val(),
			year:$("#year").val(),
			startIndex : pageIndex,
			pageSize:sizePerPage,
			status:statusVal
		},
		async:false,
		success:function(data){
			var rows = data.rows;
			var accLog=data.accLog;
			var orgId=data.orgId;
			var areaId=data.areaId;
			
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element,accLog,areaId);
				});
				$('#proList1').append(gridHtml);
			}else{
				$('#proList1').html("<tr><td colspan='9'>无查询记录</td></tr>");
			}
			pagination(data, function(){projectList1();});
		},
		error:function(){
			jQuery.generalAlert("查询错误，请联系相关人员!");
		}
		
	});
}
function projectList2(){
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();	
	
	var	statusVal = "30";
	var url = pathHeader + "/edupm/projectmanage/queryProjectForAudit.do";
	$('#proList2').html("");
	$.ajax({
		url:url,
		type:"post",
		data:{
			projectName : $('#projectName2').val(),
			start:$("#beginDate2").val(),
			end:$("#endDate2").val(),
			year:$("#year").val(),
			startIndex : pageIndex,
			pageSize:sizePerPage,
			status:statusVal
		},
		async:false,
		success:function(data){
			var rows = data.rows;
			var accLog=data.accLog;
			var areaId=data.areaId;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element,accLog,areaId);
				});
				$('#proList2').append(gridHtml);
			}else{
				$('#proList2').html("<tr><td colspan='9'>无查询记录</td></tr>");
			}
			pagination(data, function(){projectList2();});
		},
		error:function(){
			jQuery.generalAlert("查询错误，请联系相关人员!");
		}
		
	});
}
function projectList3(){
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();	
	var	statusVal = "22";
	var url = pathHeader + "/edupm/projectmanage/queryProjectForAudit.do";
	$('#proList3').html("");
	$.ajax({
		url:url,
		type:"post",
		data:{
			projectName : $('#projectName3').val(),
			start:$("#beginDate3").val(),
			end:$("#endDate3").val(),
			year:$("#year").val(),
			startIndex : pageIndex,
			pageSize:sizePerPage,
			status:statusVal
		},
		async:false,
		success:function(data){
			var rows = data.rows;
			var accLog=data.accLog;
			var areaId=data.areaId;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element,accLog,areaId);
				});
				$('#proList3').append(gridHtml);
			}else{
				$('#proList3').html("<tr><td colspan='9'>无查询记录</td></tr>");
			}
			pagination(data, function(){projectList3();});
		},
		error:function(){
			jQuery.generalAlert("查询错误，请联系相关人员!");
		}
		
	});
}
function getTdHtml(obj,accLog,areaId){	
	var str = "";
	if(obj.status == 20){
		str = "未审核";
	}else if(obj.status == 30){
		str = "<a href='javascript:auditInfo("+obj.id+")'>审核通过</a>";
	}else if(obj.status == 22) {
		str = "<a href='javascript:auditInfo("+obj.id+")'>审核不通过</a>";
	}
	
	var gridHtml = "<tr>";
	gridHtml += "<td id='projectName'><a href='javascript:projectInfo("+obj.id+",\"" + obj.createBy + "\",\"\")'>"+obj.projectName+"</a></td>";
	//创建者的区域和登陆者区域相同才可以有查看详细
//	if(obj.createByArea == areaId){
//		gridHtml += "<td id='projectName'><a href='javascript:projectInfo("+obj.id+",\"" + obj.createBy + "\")'>"+obj.projectName+"</a></td>";
//	}
//	else{
//		gridHtml += "<td id='projectName'>"+obj.projectName+"</td>";		
//	}	
	gridHtml += "<td>"+obj.planNum+"</td>";
	gridHtml +="<td>"+obj.orgName+"</td>";
	gridHtml +="<td>"+obj.applyer+"</td>";
	gridHtml +="<td>"+nullFormatter(obj.applyTime.replace(".0",""))+"</td>";
	gridHtml +="<td>"+str+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td>";
	gridHtml += "</tr>";

	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		if(row.status == 20){
			//审核权限控制，状态20、创建者的区域和登陆者区域相同才可以有审核权限
//			if(row.createByArea == areaId){
				returnStr += "<a href='###' class='tablelink' onclick='toAudit(\"" + row.id + "\",\"" + row.projectName + "\");'>审 核</a>&nbsp;&nbsp;&nbsp;";
				returnStr += "<a href='###' class='tablelink' onclick='otherViewFiles(\"" + row.id + "\",\"" + row.projectName + "\");'>查看申报书</a>&nbsp;&nbsp;&nbsp;";
//			}
//			else{
//				returnStr += "";
//			}
			
		}else if(row.status == 30){
			returnStr += "已审核";
		}else{
			returnStr += "已审核";
		}
		return returnStr;
	}
}

function toAudit(id,pName){
	pid=id;//这句话要加上，pid是全局变量，审核的时候要用到该变量
	//清理：
	//$("#auditModal input:radio").attr('checked',false); 因为这个没有加验证
	$("#memo").attr("value","");
	$("#auditModal").modal("show");
	$("#projectName10").html("项目--"+pName+"--审核");
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
				projectList();
			}
		},
		error:function(){
			jQuery.generalAlert("URL ERROR!");
		}
		
	});
}
*/

function otherViewFiles(pid,pName, userId) {
	var url = pathHeader + "/fileupload/otherViewFiles.do?time="
			+ (new Date()).getTime();
	$("#projectName11").html(pName+"的项目申报书");
	$("#download").html('');
	$('#projectId').val(pid);
	$.ajax({
				dataType : 'json',
				url : url,
				type : 'post',
				data : {
					projectId : pid,
					type : "declare",
					//roleId : "7",
					userId:userId
				},
				success : function(data) {
					var table = "<thead><tr><td width='5%'>序号</td><td width='45%'>文件名</td><td width='13%'>上传人</td><td width='25%'>上传时间</td><td width='12%'>操作</td><tr></thead> ";
					$.each(data.files,
									function(i, item) {
										table += "<tr><td>"
												+ (i + 1)
												+ "</td><td>"
												+ item.name
												+ "</td><td>"
												+ item.userName
												+ "</td><td>"
												+ nullFormatter(item.createDate.replace(".0",""))
												+ "</td><td>"
												+ "<a href='#' onclick=downloadFile('"
												+ item.url
												+ "') >下载 </a></td>"
												+ "</td></tr>";
									});
					$("#viewTable").html(table);
					$('#viewFiles').modal('show');
				},
				error : function() {
					jQuery.generalAlert("查询数据出错！请联系管理员");
				}
			});
}


//下载文件
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



