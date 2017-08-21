$(function(){
	projectList();
});


function projectList(){
	
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	
	var url = pathHeader+ "/edupm/projectmanage/queryProjectByStatus.do";
	$("#page_1").html("");
	if(status == 10){
	$('#proList1').html("");
	$.ajax({
		url:url,
		type:"post",
		data:{
			projectName : $('#projectName').val(),
			start:$("#beginDate").val(),
			end:$("#endDate").val(),
			startIndex : pageIndex,
			pageSize:sizePerPage,
			status:status
		},
		async:false,
		success:function(data){
			var accLog=data.accLog;
			var areaId=data.areaId;
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtmlOne(element,accLog,areaId);
				});
				$('#proList1').append(gridHtml);
			}else{
				$('#proList1').html("<tr><td colspan='11'>无查询记录</td></tr>");
			}
			pagination(data, function(){projectList();});
		},
		error:function(){
			alert("URL ERROR!");
		}
		
	});
	}

	
}


function getTdHtmlOne(obj,accLog,areaId){
	var tn = "";
	var ps = "";
	if(obj.projectScopeName!="请选择"){
		ps = obj.projectScopeName;
	}
	if(obj.trainTypeName!='请选择'){
		tn = obj.trainTypeName;
	}
	var gridHtml = "<tr>";
	//创建项目者可查看
//	if(obj.createByArea == areaId){
		gridHtml += "<td><a href='javascript:projectInfo("+obj.id+",\"" + obj.createBy + "\",\"\")'>" + obj.projectName + "</a></td>";
//	}
//	else{
//		gridHtml += "<td>"+obj.projectName+"</td>";
//	}
	gridHtml += "<td>"+obj.startDate+"</td>";
	gridHtml += "<td>"+obj.endDate+"</td>";
	gridHtml += "<td>"+tn+"</td>";
	gridHtml += "<td>"+ps+"</td>";
	gridHtml += "<td>"+obj.planNum+"</td>";
	gridHtml += "<td>"+obj.createBy+"</td>";
	gridHtml += "<td>"+obj.organizationName+"</td>";
	gridHtml +="<td>"+obj.classPeriod+"学时"+"</td>";
	gridHtml +="<td>"+(obj.status==10?'待申报':'')+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td>";
	gridHtml += "</tr>";
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		//if(row.status == 10 && row.createBy==accLog){
		//状态为10，创建项目人的区域和登陆人的区域相同的才有操作权限
		//if(row.status == 10 && row.createByArea==areaId){
		
		if(row.status == 10){
			returnStr += "<a href='###' class='huibtn_a' onclick='setup(\"" + row.id + "\");'>编 辑</a>&nbsp;&nbsp;&nbsp;";
			returnStr += "<a href='###' class='huibtn_a' onclick='del(\"" + row.id + "\");'>删 除</a> &nbsp;&nbsp;&nbsp;";
			returnStr += "<a href='###' class='huibtn_a' onclick='projectInfo("+obj.id+",\"" + obj.createBy + "\",\"\");'>查看</a> &nbsp;&nbsp;&nbsp;";
			returnStr += "<a href='###' class='huibtn_a' onclick='uploadProjectFile(\"" + row.id + "\",\""+obj.projectName+"\");'>项目申报模板</a>";
		}
		return returnStr;
	}
}

function qryPro(){
	if(validateYear()){
		projectList();
	}else{
		jQuery.generalAlert("查询开始年度不能大于结束年度！");
	}
}

//项目申报模板
function uploadProjectFile(pid,pName) {
	$("#addFile").show();
	var url = pathHeader + "/fileupload/viewFiles.do?time=" + (new Date()).getTime();
	$(".addMore").html('');
	$("#projectName2").html(pName);
	$("#projectName3").val(pName);
	$('#projectId').val(pid);
	$.ajax({
			cache: false,
			dataType : 'json',
			url : url,
			async:"true",
			type : 'post',
			data : {
				projectId : pid,
				type : "declareTemplate"
			},
			success : function(data) {
				var table = "<tr><td width='5%'>序号</td><td width='43%'>文件名</td><td width='12%'>上传人</td><td width='25%'>上传时间</td><td colspan='2' width='15%'>操作</td><tr>";
				$.each(data.files,function(i, item) {
					table += "<tr><td>"+ (i + 1)
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

function nullFormatter(obj){
	if(obj==null || obj=='null' || obj.length==0){
		return '';
	} else {
		return obj;
	}
}

function removeFile(id, filePath, pid) {
	jQuery.confirmWindow(
				"提示",
				"是否删除该文件？",
				function() {
					var url = pathHeader
							+ "/fileupload/deleteFile.do?";
					$.ajax({
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
