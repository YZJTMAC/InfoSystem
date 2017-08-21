var statusMap={};
$(function(){
	initDictionaryMap("comparison_status",statusMap);
	initDictionary("comparison_type","comparisonType");
	initDictionary("comparison_status","comparisonStatus");
	queryList();
	initSelectClass();
})

function initDictionary(dictionaryType, name){
	$("#"+name+"").html("");
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
				$("#"+name+"").append("<option  value='' >请选择</option>");
				$.each(data.rows, function(key, value) {
					$("#"+name+"").append(
							"<option  value=\"" + value.dictionaryId + "\">"
							+ value.dictionaryName + "</option>");
				});
			}
		},
		error:function(){
			
		}
	});
}

function initDictionaryMap(dictionaryType, map){
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
 * 跳转添加新的评比活动
 */
function toAdd(){
	var url =  pathHeader + "/master/toCreateComparison.htm?click=111";
	window.location.href=url;
}
/**
 * 跳转修改评比活动
 */
function updateObj(id){
	var url =  pathHeader + "/master/toCreateComparison.htm?click=111&id="+id+"";
	window.location.href=url;
}
/**
 * 专家账号管理
 */
function createMaster(id){
	var url =  pathHeader + "/master/toMasterManage.htm?click=111&id="+id+"";
	window.location.href=url;
}

/**
 * 专家库
 */
function toMasterDatabase(){
	var url =  pathHeader + "/master/toMasterDatabase.htm?click=111";
	window.location.href=url;

}
/**
 * 跳转删除评比活动
 */
function deleteObj(id){
	jQuery.confirmWindow(
	"提示",
	"确认删除？",
	function() {
		var url = pathHeader + "/master/deleteComparison.do";
		$.ajax({
			url:url,
			type:"post",
			async:true,
			data:{
				id:id
			},
			success:function(data){
				if(data.success){
					queryList();
				}
				jQuery.generalAlert(data.message);	
			},
			error:function(){
				jQuery.generalAlert("删除错误");	
			}
		});
	});
}
/**
 * 设置活动状态
 * @param id
 */
function setComparisonStatus(id,status){
	var tip = "";
	if(status == 1){
		tip = "确认启动？";
	}else{
		tip = "确认结束？";
	}
	jQuery.confirmWindow(
		"提示",
		tip,
		function() {
			var url = pathHeader + "/master/setComparisonStatus.do";
			$.ajax({
				url:url,
				type:"post",
				async:true,
				data:{
					id:id,
					status:status,
					roleId:40
				},
				success:function(data){
				if(data.success){
					queryList();
					}
				jQuery.generalAlert(data.message);	
				},
				error:function(){
				}
			});
		}
	)
}

/**
 * 查询列表
 */
function queryList(){
	var comparisonName = $("#comparisonNameQuery").val();
	var comparisonType = $("#comparisonType").val();
	var comparisonStatus = $("#comparisonStatus").val();
	var startDate = $("#startDate").val();
	var endDate = $("#endDate").val();
	var startIndex = $("#pageIndex").val();
	var pageSize = $("#sizePerPage").val();
	
	var url = pathHeader + "/master/queryComparison.do";
	$('#queryList').html("");
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			comparisonName:comparisonName,
			comparisonType:comparisonType,
			status:comparisonStatus,
			startDate:startDate,
			endDate:endDate,
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



function getObjHtml(obj){
	var gridHtml = "<tr>";
		gridHtml += "<td><a onclick='toDetail(\"" + obj.id + "\")'>"+obj.comparisonName+"</a></td>";
		gridHtml += "<td>"+obj.comparisonTypeName+"</td>";
		gridHtml += "<td>"+obj.comparisonYear+"</td>";
		gridHtml += "<td>"+obj.signupStartDate+"</td>";
		gridHtml += "<td>"+obj.signupEndDate+"</td>";
		gridHtml += "<td>"+ statusMap[obj.status] +"</td>";
		gridHtml += "<td>"+getOperate(obj.id,obj.status)+"</td>";
		gridHtml+= "</tr>";
	return gridHtml;
}
function getOperate(id,status){
	var op = "";
	if(status == 0){//创建完未开始
		op += "<a href='###' class='huibtn_a' onclick='updateObj(\"" + id + "\");'>编 辑</a>&nbsp;";
		op += "<a href='###' class='huibtn_a' onclick='deleteObj(\"" + id + "\");'>删 除</a>&nbsp;";
		op += "<a href='###' class='huibtn_a' onclick='setComparisonStatus(\"" + id + "\",1);'>启 动</a>&nbsp;";
	}else if(status == 1){//活动开始
		op += "<a href='###' class='huibtn_a' onclick='queryTeahcer(\"" + id + "\");'>报名教师</a>&nbsp;";
		op += "<a href='###' class='huibtn_a' onclick='setComparisonStatus(\"" + id + "\",2);'>结 束</a>&nbsp;";
	}else if(status == 2){//已结束
		op += "<a href='###' class='huibtn_a' onclick='queryTeahcer(\"" + id + "\");'>报名教师</a>&nbsp;";
	}else if(status == 3){//待评审
	}else if(status == 4){//公布结果中
	}
	op += "<a href='###' class='huibtn_a' onclick='createMaster(\"" + id + "\");'>专 家</a>&nbsp;";
	return op;
}

function toDetail(id){
	setPosition();
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
			var schools = "";
			var checkedSchools = obj.schools.split(",");
			for(var i = 0 ; i < checkedSchools.length ; i++){
				var s = checkedSchools[i].split("-");
				schools += s[1]+",";
			}
			
			$("#schools").val(schools.substring(0,schools.length-1));
			
		},
		error:function(){
		}
	});
	uploadFile(id);
	$(".tip").show();
}

function hideMe(){
	$(".tip").hide();
}

/**
 * 查询附件
 */
function uploadFile(isId) {
	var url = pathHeader + "/fileupload/viewFiles.do?time=" + (new Date()).getTime();
	$.ajax({
			cache: false,
			dataType : 'json',
			url : url,
			async:"true",
			type : 'post',
			data : {
				projectId : isId,
				type:'comparison'
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

///////////////////
function queryTeahcer(comparisonId){
	var url =  pathHeader + "/master/queryTeacherComment.htm?comparisonId="+comparisonId;
	window.location.href=url;
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
function setPosition(){
	var firstDiv=document.getElementById("comparisonTip");
	var top = document.documentElement.scrollTop + "px";
	firstDiv.style.marginTop = top;
}