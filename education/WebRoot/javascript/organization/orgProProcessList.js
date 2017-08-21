$(function(){
	showOrgProjectList();
	// 条件查询
	$("#select").click(function() {
		showOrgProjectList();
	});
});

function showOrgProjectList(){
	$('#orgProject_list').html('');
	var pageIndex = $("#pageIndex").val();
	var sizePerPage = $("#sizePerPage").val();
	$.ajax({
		//url :pathHeader + '/org/proAndProcessList.do',
		url : pathHeader + '/edupm/projectmanage/queryProjectByStatus.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectName : $('#projectName').val(),
			start : $('#beginDate').find("option:selected").val(),
			end : $('#endDate').find("option:selected").val(),
			startIndex : pageIndex,
			pageSize :sizePerPage,
			status : '30,40,50',
			flag: "Y"  //此标识表示查询申报人所管理的项目 
		},
		beforeSend: function(){
			$('#orgProject_list').html("<tr><td align='center'colspan='8'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
		},
		success:function(data){
			var objList = data.rows;
			var gridHtml = "";
			
			if(objList.length>0) {
				var areaId = data.areaId;
				var orgId = data.orgId;
				
				$.each(objList, function(index,element) {
					gridHtml += getTdHtml(element,data.roleType,areaId,orgId);
				});
				$('#orgProject_list').html(gridHtml);
			} else {
				gridHtml = "<tr><td align='center'colspan='8'>暂无查询结果！</td></tr>";
				$('#orgProject_list').html(gridHtml);
			}
			pagination(data, function(){showOrgProjectList();});
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='8'>暂无查询结果！</td></tr>";
			$('#orgProject_list').html(gridHtml);
		}
	});
}


function getTdHtml(obj,roleType,areaId,orgId){
	
	var gridHtml = "<tr>";
	//gridHtml += "<td id='projectName'>"+nullFormatter(obj.projectName)+"</td>";
	//创建项目者所属地区和登陆者地区相同，方可查看项目。
//	if(obj.createByArea == areaId || obj.organizationId == orgId){	
		gridHtml += "<td><a href='javascript:projectInfo("+obj.id+",\"" + obj.createBy +"\",\"" + obj.applyer+ "\")'>"+obj.projectName+"</a></td>";
//	}
//	else{
//		gridHtml += "<td>"+nullFormatter(obj.projectName)+"</td>";
//	}
	gridHtml += "<td>"+nullFormatter(obj.startDate)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.endDate)+"</td>";
	gridHtml += "<td>"+obj.applyer+"</td>";
	gridHtml += "<td>"+obj.organizationName+"</td>";
	//gridHtml += "<td>"+obj.createBy+"</td>";
	gridHtml += "<td>"+obj.auditor+"</td>";
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
		var url1;
		var url2;
		if(roleType == 1 || roleType == 2 || roleType == 3  || roleType == 4){
			if(obj.createByArea == areaId){
				url1 =  "<a href='#' class='tablelink' onclick='otherViewFiles("+obj.id+","+roleType+",\""+obj.projectName+"\")' >实施机构项目过程管理</a>&nbsp;&nbsp;";
				url2 =  "<a href='#' class='tablelink' onclick='viewFiles("+obj.id+",\""+obj.projectName+"\","+roleType+")' >提交/查看项目过程管理</a>&nbsp;&nbsp;";
				return url1 + url2;
			}else{
				return "";
			}
		}else{
			return "<a href='#' class='tablelink' onclick='viewFiles("+obj.id+",\""+obj.projectName+"\",\""+obj.status+"\")' >提交/查看项目过程管理</a>&nbsp;&nbsp;" ;
		}
//		if(obj.createByArea == areaId){
//			return "<a href='#' class='tablelink' onclick='otherViewFiles("+obj.id+","+roleType+",\""+obj.projectName+"\")' >查看</a>&nbsp;&nbsp;";
//		}
//		else if(obj.organizationId == orgId){
//			return "<a href='#' class='tablelink' onclick='viewFiles("+obj.id+",\""+obj.projectName+"\")' >提交</a>&nbsp;&nbsp;" ;
//		}else{
//			return "";
//		}
	}
	
	
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
				jQuery.generalAlert("项目过程管理材料上传成功");
				$(".addMore").html('');
				$('#processModal').modal('hide');
			} else {
				jQuery.generalAlert(jsonData.info);
			}
		},
		error : function() {
			jQuery.generalAlert("URL ERROR !");
			$(".tipt").fadeOut(200);
		}
	});
}

//查看
function viewFiles(pid, pName,status) {
	$(".addMore").html('');
	$("#addFile").show();
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
					type : "process"
					//roleId : "7"
				},
				success : function(data) {
					var table = "<tr><td width='5%'>序号</td><td width='43%'>文件名</td><td width='12%'>上传人</td><td width='25%'>上传时间</td><td colspan='2' width='15%'>操作</td><tr>";
					$.each(data.files,function(i, item) {
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
					$('#processModal').modal('show');
				},
				error : function() {
					jQuery.generalAlert("查询数据出错！请联系管理员");
				}
			});
}


//查看实施机构过程管理附件
function otherViewFiles(pid,roleType,pName) {
	$("#addFile").hide();
	var url = pathHeader + "/fileupload/viewOthersFiles.do?time="
			+ (new Date()).getTime();
	$("#projectName2").html(pName+"的培训项目过程管理");
	//$("#viewTable").html('');
	$(".addMore").html('');
	//$("#projectName2").html(pName);
	$("#projectName3").val(pName);
	
	$('#projectId').val(pid);
	$
			.ajax({
				dataType : 'json',
				url : url,
				type : 'post',
				data : {
					projectId : pid,
					type : "process"
				},
				success : function(data) {
					var table = "<tr><td width='5%'>序号</td><td width='43%'>文件名</td><td width='12%'>上传人</td><td width='25%'>上传时间</td><td colspan='2' width='15%'>操作</td><tr>";
					$.each(data.files,function(i, item) {
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
					//$("#viewTable").append(table);
					$("#hasUpload").html(table);
					$('#processModal').modal('show');
				},
				error : function() {
					jQuery.generalAlert("查询数据出错！请联系管理员");
				}
			});
}

/*function removeMe(o) {
	$(o).parent().parent().remove();
}
*/

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
										$(".addMore").html('');
										$('#processModal').modal('hide');
										jQuery.generalAlert("删除成功");
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

