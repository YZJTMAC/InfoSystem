$(function(){
	selectCloseProjectList();
	// 条件查询
	$("#select").click(function() {
		selectCloseProjectList();
	});
	
	
	$("#tip a").click(function(){
		 //location.reload();
		  //$("#tip").fadeOut(200);
	  });
	  $("#cancleDiv").click(function(){
		  $("#tip a").click(); 
	  });
	  $("#tipRole a").click(function(){
		  location.reload();
		  $("#tipRole").fadeOut(200);
	  });
});

function selectCloseProjectList(){
	$('#orgProject_list').html('');
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + '/org/closeProjectList.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectName : $('#projectName').val(),
			startTime : $('#startTime').find("option:selected").val(),
			endTime : $('#endTime').find("option:selected").val(),
			pageIndex : pageIndex
		},
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				var roleType=data.roleType;
				var orgId = data.orgId;
				var areaId = data.areaId;
				var gridHtml = "";
				$.each(objList, function(index,element) {
					gridHtml += getTdHtml(element,roleType,orgId,areaId);
				});
				$('#orgProject_list').append(gridHtml);
			} else {
				gridHtml = "<tr><td align='center'colspan='4'>暂无查询结果！</td></tr>";
				$('#orgProject_list').append(gridHtml);
			}
			pagination(data, function(){selectCloseProjectList();});
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='4'>暂无查询结果！</td></tr>";
			$('#orgProject_list').append(gridHtml);
		}
	});
}
	

function getTdHtml(obj,roleType,orgId,areaId){
	var gridHtml = "<tr>";
	//gridHtml += "<td id='projectName'>"+nullFormatter(obj.projectName)+"</td>";
	//创建项目者所属地区和登陆者地区相同，方可查看项目。
	if(obj.createByArea == areaId || obj.organizationId == orgId){	
		gridHtml += "<td id='projectName'><a href='javascript:projectInfo("+obj.id+",\"" + obj.createBy +"\",\"" + obj.applyer+ "\")'>"+obj.projectName+"</a></td>";
	}
	else{
		gridHtml += "<td id='projectName'>"+obj.projectName+"</td>";
	}
	gridHtml += "<td>"+nullFormatter(obj.startDate)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.endDate)+"</td>";
	gridHtml += "<td>"+optionFormatter(obj,roleType)+"</td></tr>";
	
	return gridHtml;
	
	function nullFormatter(obj){
		if(obj==null || obj=='null' || obj.length==0){
			return '';
		} else {
			return obj;
		}
	}
	
	function optionFormatter(obj,roleType){
		/*if(roleType == 1){
			return "<a href='#' class='tablelink' onclick='otherViewFiles("+obj.id+","+roleType+")' >查看</a>&nbsp;&nbsp;" 
		}else{
			return "<a href='#' class='tablelink' onclick='viewFiles("+obj.id+",\""+obj.projectName+"\")' >提交</a>&nbsp;&nbsp;" 
		}*/
		//本项目的实施机构、创建项目者所属地区和登陆者同一地区，方可操作
		if(roleType == 1 || roleType == 2 || roleType == 3  || roleType == 4){
			if(obj.createByArea == areaId){
					return "<a href='#' class='tablelink' onclick='otherViewFiles("+obj.id+","+roleType+",\""+obj.projectName+"\")' >查看</a>&nbsp;&nbsp;" 
			}else{
				return "";
			}
		}else if(obj.organizationId == orgId){
			return "<a href='#' class='tablelink' onclick='viewFiles("+obj.id+",\""+obj.projectName+"\")' >提交</a>&nbsp;&nbsp;" 
			
		}
		else{
			return "";
		}
		/*
		 +
				"<a href='#' class='tablelink' onclick='viewSummary("+obj.projectId+", "+obj.orgId+")'>查看</a>"*/
	}
}

//添加文件
function addMore(){
	var tr = '<tr class="addMore" ><td  width="80%">' +
				'<input type="file"  name="file" /> ' +
			 '</td><td width="20%"><a href="###" onclick="removeMe(this)">删除</a></td></tr>';
	$("#noUpload").append(tr);
}
function removeMe(o){
	$(o).parent().parent().remove();
}


//保存文件
function saveFiles() {
	var url = pathHeader + "/fileupload/saveFiles.do";
	var files = $("input[name='file']");
	if (files == null || files.length == 0 || files[0].value == "") {
		jQuery.generalAlert("请上传资料！");
		return;
	}

	for ( var i = 0; i < files.length; i++) {
		var name = files[i].value.toString();
		var ext = name.substring(name.lastIndexOf('.') + 1, name.length);
		if (ext == "jsp" || ext == "html") {
			jQuery.generalAlert("上传文件格式非法！请重新上传！");
			return;
		}
	}
	$("#declareForm").ajaxSubmit({
		url : url,
		async : true,
		success : function(data) {
			var jsonData = jQuery.parseJSON(data)
			if (jsonData.success) {
				$(".addMore").html('');
				$('#reportModal').modal('hide');
				jQuery.generalAlert("项目总结报告上传成功");
			} else {
				jQuery.generalAlert(jsonData.info);
			}
		},
		error : function() {
			$('#reportModal').modal('hide');
			jQuery.generalAlert("URL ERROR !");
		}
	});
}

//查看
function viewFiles(pid, pName) {
	$(".addMore").html('');
	var url = pathHeader + "/fileupload/viewFiles.do?time="
			+ (new Date()).getTime();
	$("#projectName2").html(pName);
	$("#projectName3").val(pName);
	$('#projectId').val(pid);
	$
			.ajax({
				dataType : 'json',
				url : url,
				type : 'post',
				data : {
					projectId : pid,
					type : "report"
					//roleId : "7"
				},
				success : function(data) {
					var table = "<tr><td>序号</td><td>文件名</td><td colspan='2'>操作</td><tr> ";
					$
							.each(
									data.files,
									function(i, item) {
										table += "<tr><td>"
											+ (i + 1)
											+ "&nbsp;&nbsp;</td><td>"
											+ item.name
											+ "</td><td>"
											+ "<a href='#' onclick=downloadFile('"
											+ item.url
											+ "') >下载 </a></td>"
											+ "<td><a href='#' onclick= removeFile('"
											+ item.id + "','" + item.url
											+  "','"
											+ item.projectId
											+ "') >删除 </a>" + "</td></tr>";
								});
					$("#hasUpload").html(table);
					$('#reportModal').modal('show');
				},
				error : function() {
					jQuery.generalAlert("查询数据出错！请联系管理员");
				}
			});
}


//查看
function otherViewFiles(pid,roleType,pName) {
	var url = pathHeader + "/fileupload/otherViewFiles.do?time="
			+ (new Date()).getTime();
	$("#viewTable").html('');
	$("#projectName4").html(pName+"的项目总结报告");
	$('#projectId').val(pid);
	$
			.ajax({
				dataType : 'json',
				url : url,
				type : 'post',
				data : {
					projectId : pid,
					type : "report",
				},
				success : function(data) {
					var table = "<tr><td>序号</td><td>文件名</td><td>操作</td><tr> ";
					$
							.each(
									data.files,
									function(i, item) {
										table += "<tr><td>"
												+ (i + 1)
												+ "</td><td>"
												+ item.name
												+ "</td><td>"
												+ "<a href='#' onclick=downloadFile('"
												+ item.url
												+ "') >下载 </a></td>"
												+ "</td></tr>";
									});
					$("#viewTable").append(table);
					$("#reportViewModal").modal("show");
				},
				error : function() {
					jQuery.generalAlert("查询数据出错！请联系管理员");
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
										$('#reportModal').modal('hide');
									},
									error : function() {
										jQuery.generalAlert("删除失败");
									}
								});
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
