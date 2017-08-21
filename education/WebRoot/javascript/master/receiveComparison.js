var statusMap={};
$(function(){
	initDictionaryMap("comparison_status",statusMap);
	initDictionary("comparison_type","comparisonType");
	queryList();
	initSelectClass();
})

/**
 * 初始字典
 */
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
/**
 * 查询列表
 */
function queryList(){
	var comparisonName = $("#comparisonNameQuery").val();
	var comparisonType = $("#comparisonType").val();
	var statusType = $("#statusType").val();
	doPage();
	var url = pathHeader + "/master/queryComparison.do";
	var startIndex = $("#pageIndex").val();
	var pageSize = $("#sizePerPage").val();
	
	$('#queryList').html("");
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			comparisonName:comparisonName,
			comparisonType:comparisonType,
			startIndex:startIndex,
			pageSize:pageSize,
			status:statusType
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

/**
 * 添加数据
 */
function getObjHtml(obj){
	var gridHtml = "<tr>";
		gridHtml += "<td><a onclick='toDetail(\"" + obj.id + "\",\"" + obj.createBy + "\")'>"+obj.comparisonName+"</a></td>";
		gridHtml += "<td>"+obj.comparisonTypeName+"</td>";
		gridHtml += "<td>"+obj.comparisonYear+"</td>";
		gridHtml += "<td>"+obj.signupStartDate+"</td>";
		gridHtml += "<td>"+obj.signupEndDate+"</td>";
		gridHtml += "<td>"+obj.createByName+"</td>";
		gridHtml += "<td>"+obj.signupNum+"/"+obj.comparisonPlanNum+"</td>";
		gridHtml += "<td>"+ statusMap[obj.status] +"</td>";
		gridHtml += "<td>"+getOperate(obj.id,obj.status,obj.comparisonName)+"</td>";
		gridHtml+= "</tr>";
	return gridHtml;
}

/**
 * 添加操作
 */
function getOperate(id,status,name){
	var op = "";
	if(status == 1){
		op += "<a class='huibtn_a' onclick='signUp(\"" + id + "\",\"" + name + "\");'>报 名</a>&nbsp;";
	}
		op += "<a class='huibtn_a' onclick='view(\"" + id + "\",2);'>查 看</a>&nbsp;";
	return op;
}

/**
 * 查询项目详情
 * @param id
 */
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

/**
 * 隐藏窗口
 */
function hideMe(){
	$(".tip").hide();
}


/**
 * 对我校教师进行报名
 * @param id
 */
function signUp(id,name){
//	检测是否可以报名
	if(checkDate(id)){
		var url =  pathHeader + "/master/toSignUpComparison.htm?click=112&comparisonId="+id+"&comparisonName="+name;
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
			type:"signup"
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
 * 查看我校报名教师，和教师被审核状态
 * @param id
 */
function view(id){
	var url =  pathHeader + "/master/viewSignUpComparison.htm?click=112&comparisonId="+id;
	window.location.href=url;
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
				type:'comparison',
				teacherId:teacherId
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
var vals = ""
function doPage(){
	var  str =  $("#comparisonNameQuery").val() + $("#comparisonType").val() + $("#statusType").val();
	if(vals != str){
		$("#pageIndex").val(1);
		vals = str;
	}
}