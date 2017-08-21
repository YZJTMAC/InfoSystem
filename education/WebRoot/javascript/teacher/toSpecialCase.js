var statusMap = {};
$(function(){
	queryDictionByType("examine_status",statusMap);
	queryList();
	initSelectClass();
})

function depStudyAdd(){
	var url =  pathHeader + "/teacher/teacherProject/toSpecialCaseAdd.htm?click=33";
	window.location.href=url;
}

/**
 * 
 */
function queryList(){
	var queryYear = $('#queryYear').val();
	var url = pathHeader + "/teacher/teacherProject/queryTeacherSpecialCase.do";
	$('#qrList').html("");
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			queryYear:queryYear
		},
		beforeSend: function(){
			$('#qrList').html("<tr><td align='center' colspan='14'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
		},
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getObjHtml(element);
				});
				$('#qrList').html(gridHtml);
				initSelectClass();
			}else{
				$('#qrList').html("<tr><td colspan='14'>无查询记录</td></tr>");
			}
		},
		error:function(){
			$('#qrList').html("<tr><td colspan='14'>无查询记录</td></tr>");
		}
	});
}

function getObjHtml(obj){
	var gridHtml = "<tr>";
		gridHtml += "<td>"+obj.year+"</td>";
		gridHtml += "<td>"+obj.projectName+"</td>";
		gridHtml += "<td>"+obj.trainFormName+"</td>";
		gridHtml += "<td>"+obj.teacherClassScore+"</td>";
		gridHtml += "<td>"+
		"<a href='###' class='tablelink' onclick='queryAudit(\"" + obj.id + "\");'>"+statusMap[obj.examine]
		+"</a></td>";
		gridHtml += "<td><a href='javascript:uploadFile("+obj.id+","+obj.examine+")'>附件</a></td>";
		if(obj.examine == 0){//未审核
			gridHtml += "<td><a href='javascript:deleteObj("+obj.id+")'>删除</a></td>";
		}else{//已通过 未通过
			//查看
//			gridHtml += "<td><a href='javascript:queryObj("+obj.id+")'>查看</a></td>";
			gridHtml += "<td></td>";
		}
		gridHtml+= "</tr>";
	return gridHtml;
}
function queryAudit(id){
	var url = pathHeader + "/teacher/teacherProject/queryTeacherSpecialCase.do";
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			id:id
		},
		success:function(data){
			var obj = data.rows[0];
			if(obj.auditMemo == null){
				$("#reason").html("无");
			}else{
				$("#reason").html(obj.auditMemo);
			}
			
			$("#auditReasonModal").modal("show");
		},
		error:function(){
		}
	});
}
/**
 * 删除一条记录
 * @param id
 */
function deleteObj(id){
	var url = pathHeader + "/teacher/teacherProject/specialCaseDelete.do";
	$('#qrList').html("");
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			id:id
		},
		success:function(data){
			if(data.success){
				jQuery.generalAlert("删除成功");
			}else{
				jQuery.generalAlert("删除失败");
			}
			queryList();
		},
		error:function(){
			jQuery.generalAlert("删除失败");
		}
	});
}
function queryDictionByType(dictionaryType,map){
	$("#reasonInsert").html("");
	var url = pathHeader + "/org/queryDictionaryByType.do";
	$.ajax({
		url:url,
		data:{
			dictionaryType:dictionaryType
		},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
				$.each(data.rows, function(key, value) {
					map[value.dictionaryId] = value.dictionaryName;
				});
			}
		},
		error:function(){
			
		}
	});
}
//项目申报模板
function uploadFile(id,isStatus) {
	$("#addFile").show();
	var url = pathHeader + "/fileupload/viewFiles.do?time=" + (new Date()).getTime();
	$(".addMore").html('');
	$('#projectId').val(id);
	$.ajax({
			cache: false,
			dataType : 'json',
			url : url,
			async:"true",
			type : 'post',
			data : {
				projectId : id,
				type: 'specialCaseTemplate'
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
 function initSelectClass(){
	 $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
	$(".select4").uedSelect({
		width : 100
	});
}