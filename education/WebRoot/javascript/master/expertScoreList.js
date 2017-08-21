var statusMap={};
$(function(){
	initDictionary("comparison_status",statusMap);
	queryList();
	initSelectClass();
})

function initDictionary(dictionaryType, map){
	var url = pathHeader + "/org/queryDictionaryByType.do";
	$.ajax({
		url:url,
		data:{
			dictionaryType:dictionaryType,
			status:1
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

/**
 * 跳转添加项目评分
 */
function toJudge(id){
	if(checkDate(id)){
		var url =  pathHeader + "/master/toJudgeList.htm?click=113&comparisonId="+id ;
		window.location.href=url;
	}
}

/**
 * 检测是否在报名时间范围内
 */
function checkDate(id){
	var res = false;
	var url = pathHeader + "/master/checkDate.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
			comparisonId : id,
			type:"audit"
		},
		async : false,
		success:function(data){
			if(data.success){
				res = true;	
			}else{
				jQuery.generalAlert(data.message);
			}
		},
		error:function(){}
	});
	return res;
}
/**
 * 查询列表
 */
function queryList(){
	var url = pathHeader + "/master/queryComparisonByMaster.do";
	var startIndex = $("#pageIndex").val();
	var pageSize = $("#sizePerPage").val();
	
	$('#queryList').html("");
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			startIndex:startIndex,
			pageSize:pageSize
		},
		beforeSend: function(){
			$('#queryList').html("<tr><td align='center' colspan='14'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
		},
		success:function(data){
			var rows = data.rows;
			var totalNum = data.count;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getObjHtml(element);
				});
				$('#queryList').html(gridHtml);
				pagination(data, function(){queryList()});
				initSelectClass();
			}else{
				$('#queryList').html("<tr><td colspan='14'>无查询记录</td></tr>");
				pagination(data, function(){queryList()});
			}
		},
		error:function(){
			$('#queryList').html("<tr><td colspan='14'>无查询记录</td></tr>");
		}
	});
}
//
//
//
function getObjHtml(obj){
	var gridHtml = "<tr>";
		gridHtml += "<td><a onclick='toDetail(\"" + obj.id + "\",\"" + obj.createBy + "\")'>"+obj.comparisonName+"</a></td>";
		gridHtml += "<td>"+obj.comparisonTypeName+"</td>";
		gridHtml += "<td>"+obj.comparisonYear+"</td>";
		gridHtml += "<td>"+obj.auditStartDate+"</td>";
		gridHtml += "<td>"+obj.auditEndDate+"</td>";
		gridHtml += "<td>"+ statusMap[obj.status] +"</td>";
		gridHtml += "<td>"+getOperate(obj.id,obj.status)+"</td>";
		gridHtml+= "</tr>";
	return gridHtml;
}
function toDetail(id,teacherId){
	$("#files").html("");
	var url = pathHeader + "/master/queryComparison.do";
	$.ajax({
		url:url,
		data:{
			id:id
		},
		type:"post",
		async:false,
		success:function(data){
			var obj = data.rows[0];
			$("#comparisonName").val(obj.comparisonName);
			$("#comparisonTypeName").val(obj.comparisonTypeName);
			$("#comparisonYear").val(obj.comparisonYear);
			$("#comparisonPlanNum").val(obj.comparisonPlanNum);
			$("#signupStartDate").val(obj.signupStartDate);
			$("#signupEndDate").val(obj.signupEndDate);
			$("#auditStartDate").val(obj.auditStartDate);
			$("#auditEndDate").val(obj.auditEndDate);
			$("#publishDate").val(obj.publishDate);
			$("#memo").val(obj.memo);
			
		},
		error:function(){
		}
	});
	uploadFile(id,teacherId);
	$(".tip").show();
}
function getOperate(id,status){
	var op = "";
	if(status == 0){//创建完未开始
	}else if(status == 1){//活动开始
		op += "<a href='###' class='huibtn_a' onclick='toJudge(\"" + id + "\");'>评 审</a>&nbsp;";
	}else{
	}
	return op;
}
function hideMe(){
	$(".tip").hide();
}

/**
 * 查询附件
 */
function uploadFile(isId,teacherId) {
	var url = pathHeader + "/fileupload/viewFiles.do?time=" + (new Date()).getTime();
	$.ajax({
			cache: false,
			dataType : 'json',
			url : url,
			async:"true",
			type : 'post',
			data : {
				projectId : isId,
				type :'comparison',
				teacherId : teacherId
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
				$("#files").append(table);
			},
			error : function() {
				jQuery.generalAlert("查询数据出错！请联系管理员");
			}
		});
}
/**
 * 下载文件
 * @param filePathName
 */
function downloadFile(filePathName) {
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
}