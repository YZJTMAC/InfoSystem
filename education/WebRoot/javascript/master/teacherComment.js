var statusMap={};
$(function(){
	initDictionary("comparison_signup_status",statusMap);
	alert("aaa");
	queryTeacher();
	initSelectClass();
})

/**
 * 初始化字典数据
 * @param dictionaryType
 * @param map
 */
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
 * 评选活动教师报名
 */
function queryTeacher(){
	$("#proList1").html("");
	var teacherName=$("#teacherName").val();
	doPage();
	var startIndex = $("#pageIndex").val();
	var pageSize = $("#sizePerPage").val();
	var url = pathHeader + "/master/quertTeacherComment.do";
	$.ajax({
		url:url,
		data:{
		comparisonId:comparisonId,
		teacherName:teacherName,
		startIndex:startIndex,
		pageSize:pageSize,
		status: "2,3,4,5,11,12,13"
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				var rows = data.rows;
				var gridHtml = "";
				if(rows.length > 0){
					$.each(rows,function(index,element){
						gridHtml += getTdHtml(element);
					});
					$("#proList1").html(gridHtml);
					pagination(data, function(){queryTeacher();});
					$("#proList1").html(gridHtml);
				}else{
					$('#proList1').html("<tr><td colspan='14'>无查询记录</td></tr>");
					pagination(data, function(){queryTeacher();});
				}
				
			}
			
		},
		error:function(){
			
		}
	});
}

/**
 * 填写数据
 * @param obj
 * @returns {String}
 */
function getTdHtml(obj){
	var gridHtml = "<tr>";
	if(obj.teacherImg != null && obj.teacherImg != ""){
		gridHtml += "<td><img id='masterPhoto'  style='height: 99px; width:71px;margin-top:2px' src='"+pathHeader+"/uploadFile/"+obj.teacherImg+"' title='头像' /></td>";
	}else{
		gridHtml += "<td><img id='masterPhoto'  style='height: 99px; width:71px;margin-top:2px' src='"+pathHeader+"/static/photo/teacher_default.png' title='头像' /></td>";
	}
	gridHtml += "<td>"+obj.teacherName+"</td>";
	gridHtml += "<td>"+obj.idNumber+"</td>";
	gridHtml += "<td>"+obj.sectionName+"</td>";
	gridHtml += "<td>"+obj.subjectName+"</td>";
	gridHtml += "<td>"+obj.schoolName+"</td>";
	gridHtml += "<td>"+statusMap[obj.status]+"</td>";
	gridHtml += "<td>"+ (obj.status == 5 ? obj.expertScore : 0)+"</td>";
	gridHtml += "<td><a class='huibtn_a' href='javascript:detail(\"" + obj.id + "\");'>详情</a>&nbsp;&nbsp;</td>";
	gridHtml +="</tr>";
	return gridHtml;
	
}

/**
 * 查看教师详情
 * @param teacherId
 */
function detail(teacherId){
	var firstDiv=document.getElementById("detailContent");
	firstDiv.scrollTop=0;
	setPosition("detailTip");
	$("#files").html("");
	getTeacher(teacherId);
	auditDetail(teacherId);
	detailScore(teacherId);
	$(".tip2").show();
}

/**
 * 查询教师信息
 * @param teacherId
 */
function getTeacher(teacherId){
	var url = pathHeader + "/master/quertTeacherComment.do";
	$.ajax({
		url:url,
		data:{
		startIndex:0,
		pageSize:10,
		teacherId:teacherId
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				var obj = data.rows[0];
				$("#teacherNameDetail").html(obj.teacherName);
				$("#createDate").html(obj.createDate);
				$("#idNumber").html(obj.idNumber);
				$("#createBy").html(obj.createByName);
				$("#sectionName").html(obj.sectionName);
				$("#subjectName").html(obj.subjectName);
				$("#schoolName").html(obj.schoolName);
				$("#memo").html(obj.memo);
				uploadFile(obj.id,obj.createBy);
				$("#detailModal").modal("show");
			}
			
		},
		error:function(){
		}
	});
}

/**
 * 查询审核信息
 * @param teacherId
 */
function auditDetail(teacherId){
	var url = pathHeader + "/master/queryMemo.do";
	$.ajax({
		url:url,
		data:{
		id:teacherId
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				var obj = data.rows[0];
				$("#provinceAuditDate").html(obj.provinceMemoDate);
				$("#provinceAuditMemo").html(obj.provinceMemo);
				$("#cityAuditDate").html(obj.cityMemoDate);
				$("#cityAuditMemo").html(obj.cityMemo);
				$("#districtAuditDate").html(obj.districtMemoDate);
				$("#districtAuditMemo").html(obj.districtMemo);
			}
		},
		error:function(){
			
		}
	});
}

/**
 * 查询评审信息
 * @param id
 */
function detailScore(id){
var url = pathHeader + "/master/queryMasterScore.do";
$.ajax({
	url:url,
	data:{
	comparisonId:comparisonId,
	teacherId:id
	},
	type:"post",
	async:true,
	success:function(data){
		if(data.success){
			var rows = data.rows;
			var gridHtml = "";
			
			if(rows.length > 0){
				$.each(rows,function(index,element){
					gridHtml+=	"<tr><td width='80'>&nbsp;</td ><td width='80'>专家姓名：</td ><td width='180'><div class='vocation'><label>"+element.masterName+"</label ></div ></td ><td width='80'>用户名：</td ><td width='180'><div class='vocation'><label>"+element.loginAccount+"</label ></div ></td ></tr><tr><td width='80'>&nbsp;</td ><td width='80'>分数：</td ><td width='180'><div class='vocation'><label>"+element.expertScore+"</label ></div ></td ><td width='80'>评审时间：</td ><td width='180'><div class='vocation'><label>"+element.createDate+"</label ></div ></td ></tr><tr><td width='80'>&nbsp;</td ><td width='80'>评审备注：</td ><td width='180'colspan='3'><div class='vocation'><label>"+element.memo+"</label ></div ></td ></tr><tr><td width='80'><td  style='border-top:1px dashed #a7b5bc;' colspan='4'></td></tr>";
				});
				$("#judgeList").html(gridHtml);
				
			}else{
				$("#judgeList").html("暂无评审记录");
			}
		}
		
	},
	error:function(){
	}
});
}



//function getTdHtml2(obj){
//	var gridHtml = "<tr>";
//	gridHtml += "<td>"+obj.masterName+"</td>";
//	gridHtml += "<td>"+obj.expertScore+"</td>";
//	gridHtml += "<td>"+obj.createDate+"</td>";
//	gridHtml += "<td>"+obj.memo+"</td>";
//	gridHtml +="</tr>";
//	return gridHtml;
//}

/////////附件/////////////
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
				type:'comparisonSignup',
				teacherId:teacherId
				
			},
			success : function(data) {
				var table = "<tr style='border:1px solid #000000;  text-align: center;'><td width='8%'>序号</td><td width='40%'>文件名</td><td width='12%'>上传人</td><td width='25%'>上传时间</td><td colspan='2' width='15%'>操作</td><tr>";
				var hasFile = false;
				$.each(data.files,function(i, item) {
					table += "<tr style='border:1px solid #000000;  text-align: center;'>" +
							"<td>"+ (i + 1)+ "</td>" +
							"<td><a href='javascript:void(0)'; onclick='previewFile(\""+item.url+"\");'>"+ item.name+ "</a></td>" +
							"<td>"+item.userName+"</td>"+ 
							"<td>"+nullFormatter(item.createDate.replace(".0",""))+"</td>" +
							"<td>"+ "<a href='#' onclick=downloadFile('"+ item.url+ "') >下载 </a></td>"+ 
							"</tr>";
					hasFile = true;
				});
				if(hasFile){
					$("#files").append(table);
				}else{
					$("#files").html("无附件");
				}
				
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
//其他///////////////
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
function hideMe(){
	var firstDiv=document.getElementById("detailContent");
	firstDiv.scrollTop=0;
	$(".tip2").hide();
}
function setPosition(tipName){
	var tip=document.getElementById(tipName);
	var top = document.documentElement.scrollTop + "px";
	tip.style.marginTop = top;
}
var vals = ""
function doPage(){
	var  str =  $("#teacherName").val() ;
	if(vals != str){
		$("#pageIndex").val(1);
		vals = str;
	}
}