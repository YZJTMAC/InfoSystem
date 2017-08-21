$(function(){
	projectList1();	
});

function projectList1(){
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();	
	var	statusVal = "1";
	var url = pathHeader + "/teacher/teacherProject/queryTeacherIndeptStudy.do";
	$('#proList1').html("");
	$.ajax({
		url:url,
		type:"post",
		data:{
			teacherName : $('#teacherName1').val(),
			startIndex : pageIndex,
			pageSize:sizePerPage,
			status:statusVal
		},
		async:false,
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#proList1').append(gridHtml);
			}else{
				$('#proList1').html("<tr><td colspan='9'>无查询记录</td></tr>");
			}
		},
		error:function(){
			jQuery.generalAlert("查询错误，请联系相关人员!");
		}
		
	});
}
function projectList2(){
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();	
	var	statusVal = "2";
	var url = pathHeader + "/teacher/teacherProject/queryTeacherIndeptStudy.do";
	$('#proList2').html("");
	$.ajax({
		url:url,
		type:"post",
		data:{
			teacherName : $('#teacherName2').val(),
			startIndex : pageIndex,
			pageSize:sizePerPage,
			status:statusVal
		},
		async:false,
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#proList2').append(gridHtml);
			}else{
				$('#proList2').html("<tr><td colspan='9'>无查询记录</td></tr>");
			}
		},
		error:function(){
			jQuery.generalAlert("查询错误，请联系相关人员!");
		}
		
	});
}
function projectList3(){
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();	
	var	statusVal = "3";
	var url = pathHeader + "/teacher/teacherProject/queryTeacherIndeptStudy.do";
	$('#proList3').html("");
	$.ajax({
		url:url,
		type:"post",
		data:{
			teacherName : $('#teacherName3').val(),
			startIndex : pageIndex,
			pageSize:sizePerPage,
			status:statusVal
		},
		async:false,
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#proList3').append(gridHtml);
			}else{
				$('#proList3').html("<tr><td colspan='9'>无查询记录</td></tr>");
			}
		},
		error:function(){
			jQuery.generalAlert("查询错误，请联系相关人员!");
		}
		
	});
}
function getTdHtml(obj){	
	
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.teacherName+"</td>";
	gridHtml += "<td>"+obj.schoolName+"</td>";
	gridHtml += "<td>"+obj.idNumber+"</td>";
	gridHtml +="<td>"+obj.isYear+"</td>";
	gridHtml +="<td>"+obj.isStudyTypeName+"</td>";
	gridHtml +="<td>"+obj.isAnnotation+"</td>";
	gridHtml +="<td>"+obj.createDate+"</td>";
	gridHtml +="<td>"+obj.isCredit+"</td>";
	gridHtml += "<td><a href='javascript:uploadFile("+obj.id+","+obj.teacherId+")'>附件</a></td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td>";
	gridHtml += "</tr>";

	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		if(row.status == 1){
			returnStr += "<a href='###' class='tablelink' onclick='toAudit(\"" + row.id + "\");'>审核</a>&nbsp;&nbsp;&nbsp;";
		}else if(row.status == 2){
			returnStr += "<a href='###' class='tablelink' onclick='queryAudit(\"" + row.id + "\");'>已通过</a>&nbsp;&nbsp;&nbsp;";
		}else if(row.status == 3){
			returnStr += "<a href='###' class='tablelink' onclick='queryAudit(\"" + row.id + "\");'>未通过</a>&nbsp;&nbsp;&nbsp;";
		}
		return returnStr;
	}
}
var pid;
function toAudit(id){
	pid=id;//这句话要加上，pid是全局变量，审核的时候要用到该变量
	$("#memo").attr("value","");
	$("#auditModal").modal("show");
	$("#projectName10").html("学分借贷申请审核");
}

function audit(){
	var url = pathHeader + "/teacher/teacherProject/auditIndeptStudy.do";
	 $.ajax({
		 url:url,
		 data:{
		 	id:pid,
		 	audtiStatus:$("input[name='radio']:checked").val(),
		 	memo:$("#memo").val()
		 },
		 type:"post",
		 async:false,
		 success:function(data){
			 if(data.success){
				 jQuery.generalAlert("审核成功！");
			 $("#auditModal").modal("hide");
				 projectList1();
			 }
		 },
		 error:function(){
		 jQuery.generalAlert("审核出现错误，请联系相关人员 !");
		 }
	 });
}
function queryAudit(id){
	var url = pathHeader + "/teacher/teacherProject/queryTeacherIndeptStudy.do";
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			id:id
		},
		success:function(data){
			var obj = data.rows[0];
			if(obj.comment == null){
				$("#reason").html("无");
			}else{
				$("#reason").html(obj.comment);
			}
			
			$("#auditReasonModal").modal("show");
		},
		error:function(){
		}
		
	});
}
///项目申报模板
function uploadFile(isId,teacherId) {
	$("#addFile").show();
	var url = pathHeader + "/fileupload/viewFiles.do?time=" + (new Date()).getTime();
	$(".addMore").html('');
	$('#projectId').val(isId);
	$.ajax({
			cache: false,
			dataType : 'json',
			url : url,
			async:"true",
			type : 'post',
			data : {
				projectId : isId,
				teacherId:teacherId,
				type: 'indeptStudy'
			},
			success : function(data) {
				var table = "<tr><td width='8%'>序号</td><td width='40%'>文件名</td><td width='12%'>上传人</td><td width='25%'>上传时间</td><td colspan='2' width='15%'>操作</td><tr>";
				$.each(data.files,function(i, item) {
					table += "<tr>" +
							"<td>"+ (i + 1)+ "</td>" +
							"<td><a href='javascript:void(0)'; onclick='previewFile(\""+item.url+"\");'>"+ item.name+ "</a></td>" +
							"<td>"+item.userName+"</td>"+ 
							"<td>"+nullFormatter(item.createDate.replace(".0",""))+"</td>" +
							"<td>"+ "<a href='#' onclick=downloadFile('"+ item.url+ "') >下载 </a></td>"+ 
							"</tr>";
						});
				$("#hasUpload").html(table);
				$('#myModal').modal('show');
				
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