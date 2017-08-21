$(function(){
	
	selectCloseProjectList();
	// 条件查询
	$("#select").click(function() {
		selectCloseProjectList();
	});
});

$(document).ready(function(){
  $(".tiptop a").click(function(){
	  $(".tip").fadeOut(200);
  });

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
	});

});
function selectCloseProjectList(){
	$('#summaryList').html('');
	var pageIndex = $("#pageIndex").val();
	var sizePerPage = $("#sizePerPage").val();
	$.ajax({
		//url : pathHeader + '/edupm/searchXingZhengCloseProjectList.do',
		url:pathHeader + '/edupm/projectmanage/queryProjectByStatus.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectName : $('#projectName').val(),
			start : $('#startTime').find("option:selected").val(),
			end : $('#endTime').find("option:selected").val(),
			startIndex : pageIndex,
			pageSize:sizePerPage,
			status : '50'
		},
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				
				if(objList.length>0){
					var areaId = data.areaId;
					var gridHtml = "";
					$.each(objList, function(index,element) {
						gridHtml += getTdHtml(element,data.isHide,areaId);
					});
				}else{
					gridHtml = "<tr><td align='center'colspan='4'>暂无查询结果！</td></tr>";
				}
				
				$('#summaryList').append(gridHtml);
			} else {
				gridHtml = "<tr><td align='center'colspan='4'>暂无查询结果！</td></tr>";
				$('#summaryList').append(gridHtml);
			}
			pagination(data, function(){selectCloseProjectList();});
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='4'>暂无查询结果！</td></tr>";
			$('#summaryList').append(gridHtml);
		}
	});
}
	


function getTdHtml(obj,isHide,areaId){
	var gridHtml = "<tr>";
	//gridHtml += "<td>"+nullFormatter(obj.projectName)+"</td>";
	//创建项目者所属地区和登陆者地区相同，方可查看项目。
//	if(obj.createByArea == areaId){	
		gridHtml += "<td><a href='javascript:projectInfo("+obj.id+",\"" + obj.createBy +"\",\"" + obj.applyer+ "\")'>"+obj.projectName+"</a></td>";
//	}
//	else{
//		gridHtml += "<td>"+obj.projectName+"</td>";
//	}
	gridHtml += "<td>"+nullFormatter(obj.startDate)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.endDate)+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function nullFormatter(obj){
		if(obj==null || obj=='null' || obj.length==0){
			return '';
		} else {
			return obj;
		}
	}
	function optionFormatter(obj,userId){
		//var url1 = "<a id='chengPeiUrl' href='../org/toChengPeiSummaryListPage.htm?pid="+obj.id+"&click=102' class='tablelink'>承培机构总结</a>&nbsp;&nbsp;";
		var url2;
		var url3;
		var url4;
		//创建项目者所属区域和登陆者同一区域的，方可操作
//		if(obj.createByArea == areaId){
			url2 = "<a href='../teacher/teacherProject/teacherProSummaryList.htm?projectId="+obj.id+"&click=102' class='tablelink'>老师的总结</a>&nbsp;&nbsp;";
//		}
//		else{
//			url2 = "";
//		}
//		if(obj.createByArea == areaId){
		    url3 = "<a href='#' class='tablelink' onclick='orgViewFiles("+obj.id+",\""+obj.projectName+"\")' >实施机构总结</a>&nbsp;&nbsp;";
//		}
//		else{
//			url3 = "";
//		}
//		if(obj.createByArea == areaId){
		    url4 = "<a href='#' class='tablelink' onclick='viewFiles("+obj.id+",\""+obj.projectName+"\")' >提交/查看我的总结</a>&nbsp;&nbsp;";
//		}
//		else{
//			url4 = "";
//		}
		if(isHide==0){
			url1="";
		}
		return url2+url3+url4;
	}
}
//查看实施机构项目总结
function orgViewFiles(pid,pName) {
	$("#addFile").hide();
	var url = pathHeader + "/fileupload/viewOthersFiles.do?time="
			+ (new Date()).getTime();
	//$("#viewTable").html('');
	$(".addMore").html('');
	$("#projectName2").html(pName);
	$("#projectName3").val(pName);
	$("#projectName4").html(pName+"的培训总结")
	$('#projectId').val(pid);
	$
			.ajax({
				dataType : 'json',
				url : url,
				type : 'post',
				data : {
					projectId : pid,
					type : "summarry"
					//roleId : "7",
				},
				success : function(data) {
					var table = "<tr><td width='10%'>序号</td><td width='30%'>文件名</td><td width='15%'>上传人</td><td width='25%'>上传时间</td><td colspan='2' width='20%'>操作</td><tr>";
					$
							.each(
									data.files,
									function(i, item) {
										//临时修改
										if(item.roleId != '5'){
											table += "<tr><td width='10%'>"
												+ (i + 1)
												+ "</td><td width='30%'><a href='javascript:void(0)'; onclick='previewFile(\""+item.url+"\");'>" 
												+ item.name
												+ "</a></td><td width='15%'>"+item.userName+"</td>"
												+ "<td width='25%'>"+nullFormatter(item.createDate.replace(".0",""))+"</td><td width='10%'>"
												+ "<a href='#' onclick=downloadFile('"
												+ item.url
												+ "') >下载 </a></td>"
												+ "<td width='10%'><a href='#' onclick= removeFile('"
												+ item.id + "','" + item.url
												+ "','"
												+ item.projectId
												+ "') >删除 </a>" + "</td></tr>";
										}
										
									});
					//$("#viewTable").html(table);
					$("#hasUpload").html(table);
					$('#summaryViewModal').modal('show');
				},
				error : function() {
					jQuery.generalAlert("查询数据出错！请联系管理员");
				}
			});
}

//行政管理员查看项目总结
function viewFiles(pid,pName) {
	$("#addFile").show();
	var url = pathHeader + "/fileupload/viewFiles.do?time="
			+ (new Date()).getTime();
	//$("#viewTable").html('');
	$(".addMore").html('');
	$("#projectName2").html(pName);
	$("#projectName3").val(pName);
	$("#projectName4").html(pName+"的培训总结")
	$('#projectId').val(pid);
	$
			.ajax({
				dataType : 'json',
				url : url,
				type : 'post',
				data : {
					projectId : pid,
					type : "summarry"
					//roleId : "7",
				},
				success : function(data) {
					var table = "<tr><td width='10%'>序号</td><td width='30%'>文件名</td><td width='15%'>上传人</td><td width='25%'>上传时间</td><td colspan='2' width='20%'>操作</td><tr>";
					$
							.each(
									data.files,
									function(i, item) {
										//临时修改
										if(item.roleId != '5'){
											table += "<tr><td width='10%'>"
												+ (i + 1)
												+ "</td><td width='30%'><a href='javascript:void(0)'; onclick='previewFile(\""+item.url+"\");'>" 
												+ item.name
												+ "</a></td><td width='15%'>"+item.userName+"</td>"
												+ "<td width='25%'>"+nullFormatter(item.createDate.replace(".0",""))+"</td><td width='10%'>"
												+ "<a href='#' onclick=downloadFile('"
												+ item.url
												+ "') >下载 </a></td>"
												+ "<td width='10%'><a href='#' onclick= removeFile('"
												+ item.id + "','" + item.url
												+ "','"
												+ item.projectId
												+ "') >删除 </a>" + "</td></tr>";
										}
										
									});
					//$("#viewTable").html(table);
					$("#hasUpload").html(table);
					$('#summaryViewModal').modal('show');
				},
				error : function() {
					jQuery.generalAlert("查询数据出错！请联系管理员");
				}
			});
}

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
										$(".addMore").html('');
										$('#summaryViewModal').modal('hide');
										jQuery.generalAlert("删除成功");
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
function initSysSetupInfo(){
	$.ajax({
		url : pathHeader + '/sys/sysSetupInfo.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		success:function(data){
			if(data.success){
				var obj = data.obj;
				if(obj.enableOrg==1){
					$("#chengPeiUrl").hide();
				}
			} else {
				jQuery.generalAlert("查询失败!");
			}
		},
		error:function(){
			jQuery.generalAlert("查询失败!");
		}
	});
}


//function viewSummary(pid){
//	$("#download").html('');
//	var url = pathHeader + "/edupm/summary/shengViewSummary.do?time="+(new Date()).getTime();
//	$.ajax({
//  		dataType: 'json',  
//  		url:url,
//  		data:{projectId:pid,type:0},
//  		success:function(data){
//  			if(data.eps!=null){
//  	  			$("#summaryTitle").val(data.eps.title);
//  	  			$("#summaryId").val(data.eps.id);
//  	  			$("#pid").val(data.eps.projectId);
//  	  			$("#summaryContent").val(data.eps.content);
//  	  		if(nullFormatter(data.eps.attchementTitle)){
//	  	  		var titles = data.eps.attchementTitle.split("^");
//	  	  		var fileUrl;
////				for(var i=0;i<titles.length;i++){
////					fileUrl =  data.eps.attchementUrl;
////					$("#download").append("<div id="+data.eps.id+titles[i]+">"+titles[i]+"<a href='#' onclick=downloadFile('" +fileUrl+titles[i]+"') >&nbsp;&nbsp;下载 </a></div>");
////				}
//				var table = "<tr><td width='30%'>序号&nbsp;&nbsp;</td><td width='40%'>文件名</td><td width='30%'>操作</td><tr> ";
//				for(var i=0;i<titles.length;i++){
//					fileUrl =  data.eps.attchementUrl;
//					table += "<tr><td width='30%'>"+(i+1)+"&nbsp;&nbsp;</td><td width='40%'>"+titles[i]+"</td><td width='30%'>"+"<a href='#' onclick=downloadFile('" +fileUrl+titles[i]+"') >下载 </a></td>"+"</tr>";
//				}
//				$("#download").append(table);
//				
//	  		}else{
//	  			$("#download").html("还未开始上传附件");
//	  		}
//  			}else{
//  				$("#delete").html("");
//  				$("#summaryId").val(null);
//  				$("#pid").val(pid);
//  	  			$("#summaryTitle").val("");
//  	  			$("#summaryContent").val(""); 
//  	  			$("#download").html("");
//				$("#download").attr("href","#");
//  			}
//  			$(".tip").fadeIn(200);
//  		},
//  		error:function(XMLHttpRequest, textStatus, errorThrown){
//			alert("查询数据出错！请联系管理员");
//		}
//  	});
//}
//
//function nullFormatter(obj){
//	if(obj==null || obj=='null' || obj.length==0){
//		return false;
//	} else {
//		return true;
//	}
//}
