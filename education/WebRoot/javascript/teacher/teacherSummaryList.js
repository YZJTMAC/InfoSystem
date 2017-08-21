$(function(){
	selectCloseProjectList();
	
	$("#select").click(function() {
		selectCloseProjectList();
	});
});

function selectCloseProjectList(){
	$('#summaryList').html('');
	
	var pageIndex = $("#pageIndex").val();
	var sizePerPage = $("#sizePerPage").val();
	$.ajax({
		//url : pathHeader + '/teacher/teacherProject/searchTeacherCloseProjectList.do',
		url : pathHeader + '/teacher/teacherProject/teacherOverProjectList.do',
		type: "post",
		cache: false,
		async: true,
		data:{
			projectName : $('#projectName').val(),
			start : $('#startTime').find("option:selected").val(),
			end : $('#endTime').find("option:selected").val(),
			startIndex : pageIndex,
			pageSize: sizePerPage
		},
		success:function(data){
			var objList = data.rows;
			
			if(objList.length > 0){
				var gridHtml = "";
				$.each(objList, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#summaryList').append(gridHtml);
				
			}else{
				gridHtml = "<tr><td align='center'colspan='4'>暂无查询结果！</td></tr>";
				$('#summaryList').append(gridHtml);
			}
			
			pagination(data, function(){selectCloseProjectList();});
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='4'>暂无查询结果！aaaa</td></tr>";
			$('#summaryList').append(gridHtml);
		}
	});
}


function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td id='projectName'>"+ obj.projectName +"</td>";
	gridHtml += "<td>"+ dateFormatter(obj.startDate) +"</td>";
	gridHtml += "<td>"+ dateFormatter(obj.endDate) +"</td>";
	gridHtml += "<td>"+ optionFormatter(obj) +"</td></tr>";
	return gridHtml;
	
	function dateFormatter(time){
		var date = new Date(time).format("yyyy-MM-dd");
		return date;
	}
	
	function optionFormatter(obj){
		var url = "<a href='#' class='tablelink' onclick='viewFiles("+obj.id+",\""+obj.projectName+"\")'>提交/查看我的总结</a>&nbsp;&nbsp;"; 
		return url;
	}
}
//保存文件
function saveFiles() {
	var url = pathHeader + "/fileupload/saveFiles.do";
	var files = $("input[name='file']");
	if (files == null || files.length == 0 || files[0].value == "") {
		jQuery.generalAlert("请上传培训总结！");
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
				jQuery.generalAlert("培训总结上传成功");
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
function viewFiles(pid, pName) {
	
	$(".addMore").html('');
	var url = pathHeader + "/fileupload/viewFiles.do?time="
			+ (new Date()).getTime();
	$("#hasUpload").html('');
	$("#projectName2").html(pName+"的培训总结");
	$("#projectName3").val(pName);
	$('#projectId').val(pid);
	$.ajax({
				dataType : 'json',
				url : url,
				type : 'post',
				data : {
					projectId : pid,
					type : "summarry"
				},
				success : function(data) {
					var table = "<tr><td width='5%'>序号</td><td width='43%'>文件名</td><td width='12%'>上传人</td><td width='25%'>上传时间</td><td colspan='2' width='15%'>操作</td><tr>";
					$.each(data.files,
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
				error : function() {
					jQuery.generalAlert("查询数据出错！请联系管理员");
				}
			});
}

/*function removeMe(o) {
	$(o).parent().parent().remove();
}

// 添加文件
function addMore() {
	var tr = '<tr class="addMore"><td>'
			+ '<input type="file"  name="file" /> '
			+ '</td><td><a href="##" onclick="removeMe(this)">删除</a></td></tr>';
	$("#noUpload").append(tr);
}*/
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