var statusMap={};
$(function(){
	initDictionaryMap("comparison_status",statusMap);
	initDictionary("comparison_type","comparisonType");
	queryList();
	initSelectClass();
})

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
 * 跳转添加新的评比活动
 */
function toAdd(){
	var url =  pathHeader + "/master/toCreateComparison.htm";
	window.location.href=url;
}
/**
 * 根据项目查看教师列表
 * @param id
 */
function queryComparisonCommntTeacher(comparisonId){
	var f=document.createElement('form');
    f.style.display='none';
    f.action= pathHeader+'/master/queryTeacherList.htm?click=114';
    f.method='post';
    f.innerHTML='<input type="hidden" name="comparisonId" value="'+comparisonId+'"/>';
    document.body.appendChild(f);
    f.submit();
}

/**
 * 查询列表
 */
function queryList(){
	var url = pathHeader + "/master/queryComparisonByType.do";
	var comparisonName = $("#comparisonNameQuery").val();
	var comparisonType = $("#comparisonType").val();
	var statusType = $("#statusType").val();
	doPage();
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

function getObjHtml(obj){
	var gridHtml = "<tr>";
		gridHtml += "<td>"+obj.comparisonName+"</td>";
		gridHtml += "<td>"+obj.comparisonTypeName+"</td>";
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
		op += "<a href='###' class='huibtn_a'>活动未开始</a>&nbsp;";
	}else if(status == 1){//活动开始
		op += "<a href='###' class='huibtn_a' onclick='queryComparisonCommntTeacher(\"" + id + "\");'>查看报名教师</a>&nbsp;";
	}else if(status == 2){
		op += "<a href='###' class='huibtn_a'>活动已结束</a>&nbsp;";
	}else if(status == 3){
		op += "<a href='###' class='huibtn_a'>专家评审阶段</a>&nbsp;";
	}else if(status == 4){
		op += "<a href='###' class='huibtn_a'>结果公布中</a>&nbsp;";
	}
	return op;
}

/**
 * 查询附件
 */
function uploadFile(isId) {
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
				$("#hasUpload").html(table);
				$('#myModal').modal('show');
				
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