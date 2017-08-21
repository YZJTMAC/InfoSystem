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
			status : '30,40',
			flag: "Y"  //此标识表示查询申报人所管理的项目 
		},
		beforeSend: function(){
			$('#orgProject_list').html("<tr><td align='center'colspan='4'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
		},
		success:function(data){
			var objList = data.rows;
			var gridHtml = "";
			
			if(objList.length>0) {
				$.each(objList, function(index,element) {
					gridHtml += getTdHtml(element,data.roleType);
				});
				$('#orgProject_list').html(gridHtml);
			} else {
				gridHtml = "<tr><td align='center'colspan='4'>暂无查询结果！</td></tr>";
				$('#orgProject_list').html(gridHtml);
			}
			pagination(data, function(){showOrgProjectList();});
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='4'>暂无查询结果！</td></tr>";
			$('#orgProject_list').html(gridHtml);
		}
	});
}


function getTdHtml(obj,roleType){
	var gridHtml = "<tr>";
	gridHtml += "<td id='projectName'>"+nullFormatter(obj.projectName)+"</td>";
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
	
	function optionFormatter(row,roleType){
		var url1;
		var url2;
		if(roleType == 1 || roleType == 2 || roleType == 3  || roleType == 4){
			url1 =  "<a href='#' class='tablelink' onclick='viewSummaryRole("+obj.id+",\""+obj.projectName+"\",\""+roleType+"\")' >实施机构培训材料</a>&nbsp;&nbsp;"; 
			url2 =  "<a href='#' class='tablelink' onclick='viewFiles("+obj.id+",\""+obj.projectName+"\",\""+roleType+"\")' >提交/查看我的培训材料</a>&nbsp;&nbsp;";
			return url1 + url2;
		}else {
			return "<a href='#' class='tablelink' onclick='viewFiles("+obj.id+",\""+obj.projectName+"\",\""+obj.status+"\")' >提交/查看我的培训材料</a>&nbsp;&nbsp;" ;
		}
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
				$(".addMore").html('');
				$('#myModal').modal('hide');
				jQuery.generalAlert("培训材料上传成功");
			} else {
				jQuery.generalAlert(jsonData.info);
			}
		},
		error : function() {
			jQuery.generalAlert("URL ERROR !");
		}
	});
}


// 查看
function viewFiles(pid, pName,status) {
	$("#addFile").show();
	var url = pathHeader + "/fileupload/viewFiles.do?time=" + (new Date()).getTime();
	$(".addMore").html('');
	$("#projectName2").html(pName);
	$("#projectName3").val(pName);
	$('#projectId').val(pid);
	$
			.ajax({
				cache: false,
				dataType : 'json',
				url : url,
				async:"true",
				type : 'post',
				data : {
					projectId : pid,
					type : "trainingMaterials"
					//roleId : "7"
				},
				success : function(data) {
					var table = "<tr><td width='10%'>序号</td><td width='30%'>文件名</td><td width='15%'>上传人</td><td width='25%'>上传时间</td><td colspan='2' width='20%'>操作</td><tr>";
					$.each(data.files,function(i, item) {
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
					});
						
					$("#hasUpload").html(table);
					$('#myModal').modal('show');
					
				},
				error : function() {
					jQuery.generalAlert("查询数据出错！请联系管理员");
				}
			});
}
//行政管理员查看实施机构提交的培训材料
function viewSummaryRole(pid,pName,roleType){
	$("#addFile").hide();
	var url = pathHeader + "/fileupload/viewOthersFiles.do?time="
	+ (new Date()).getTime();
$(".addMore").html('');
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
			type : "trainingMaterials"
			//roleId : "7"
		},
		success : function(data) {
			var table = "<tr><td width='10%'>序号</td><td width='30%'>文件名</td><td width='15%'>上传人</td><td width='25%'>上传时间</td><td colspan='2' width='20%'>操作</td><tr>";
			$.each(data.files,function(i, item) {
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
								});
				
			$("#hasUpload").html(table);
			$('#myModal').modal('show');
			
		},
		error : function() {
			jQuery.generalAlert("查询数据出错！请联系管理员");
		}
	});
}
function nullFormatter(obj){
	if(obj==null || obj=='null' || obj.length==0){
		return '';
	} else {
		return obj;
	}
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
										$(".addMore").html('');
										$('#myModal').modal('hide');
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
