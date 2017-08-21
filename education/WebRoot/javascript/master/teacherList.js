var statusMap={};
$(function(){
	initDictionary("comparison_signup_status",statusMap);
	queryTeacher();
//	lastForSure();
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
 * 评选活动教师报名
 */
function queryTeacher(){
	$("#proList1").html("");
	var teacherName=$("#teacherName").val();
	var startIndex = $("#pageIndex").val();
	var pageSize = $("#sizePerPage").val();
	var url = pathHeader + "/master/quertTeacherComment.do";
	$.ajax({
		url:url,
		data:{
		comparisonId:comparisonId,
		teacherName:teacherName,
		startIndex:startIndex,
		pageSize:pageSize
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
	gridHtml += "<td>"+obj.phone+"</td>";
	gridHtml += "<td>"+obj.memo+"</td>";
	gridHtml += "<td>"+ chooseStatus(obj)+"</td>";
	gridHtml += "<td><a class='huibtn_a' onclick='uploadFile(\"" + obj.id + "\",\"" + obj.createBy + "\");'>附 件</a></td>";
	gridHtml += "<td>"+ optionFormatter(obj) +"</td>";
	gridHtml +="</tr>";
	return gridHtml;
}

	function chooseStatus(obj){
		var returnStr = "";
		if(obj.status == 1){
			returnStr = "未报名";
		}else if(obj.status == 11){
			returnStr = "区县通过审核";
		}else if(obj.status == 12 ){
			returnStr += "市通过审核";
		}else if(obj.status == 4){
			returnStr = "省通过审核";
		}else if(obj.status == 2){
			returnStr = "未通过审核";
		}else if(obj.status == 3){
			returnStr = "已报名未审核";
		}else if(obj.status == 4){
			returnStr = "专家评审中";
		}else if(obj.status == 5){
			returnStr = "专家评审完毕";
		}
		
		return returnStr;
	}
	
	function optionFormatter(obj){
		var roleId=$("#roleId").val();
		var returnStr = "";
		if(obj.status == 2){//审核未通过
			returnStr = "审核未通过";
		}else if(obj.status == 3 && roleId == 3){
			returnStr += "<a  class='huibtn_a' onclick='toJudge(\"" + obj.teacherName + "\",\"" + obj.id + "\")'>评审</a>&nbsp;&nbsp;";
		}else if(obj.status == 11 && roleId == 2){
			returnStr += "<a  class='huibtn_a' onclick='toJudge(\"" + obj.teacherName + "\",\"" + obj.id + "\")'>评审</a>&nbsp;&nbsp;";
		}
		else if(obj.status == 12 && roleId == 1){
			returnStr += "<a  class='huibtn_a' onclick='toJudge(\"" + obj.teacherName + "\",\"" + obj.id + "\")'>评审</a>&nbsp;&nbsp;";
		}else{
			returnStr += "<a class='huibtn_a' onclick='auditDetail(\"" + obj.id + "\");'>审核详情</a>&nbsp;&nbsp;";
		}
		return returnStr;
	}

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
				$("#provinceMemo").html("省级意见："+obj.provinceMemo);
				$("#cityMemo").html("市级意见："+obj.cityMemo);
				$("#districtMemo").html("区级意见："+obj.districtMemo);
				$("#auditReasonModal").modal("show");
			}
		},
		error:function(){
			
		}
	});
}


function getTdHtml2(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.masterName+"</td>";
	gridHtml += "<td>"+obj.expertScore+"</td>";
	gridHtml += "<td>"+obj.createDate+"</td>";
	gridHtml += "<td>"+obj.memo+"</td>";
	gridHtml +="</tr>";
	return gridHtml;
}
function detailScore(id, avgScore){

	$("#proList2").html("");
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
				
				$("#finalScore").html(avgScore);
				
				if(rows.length > 0){
					$.each(rows,function(index,element){
						gridHtml += getTdHtml2(element);
					});
					$("#proList2").html(gridHtml);
					$("#proList2").html(gridHtml);
				}else{
					$('#proList2').html("<tr><td colspan='14'>无查询记录</td></tr>");
				}
				
			}
			
		},
		error:function(){
			
		}
	});
	$("#judgeModal").modal("show");
//	$(".tip").show();
}
function hideMe(id){
	$(".tip").hide();
}
///////附件/////////////
/**
* 查询附件
*/
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
				type:'comparisonSignup',
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

var tId = "";
function toJudge(teacherName,id){
	$("#teacherName1").val(teacherName);
	$("#score").val("");
	$("#memo").val("");
	$(".tip").show();
	tId = id;
}

function judge(element){
	var memoVal = $("#memo").val();
	var memoName = "";//判断memo是哪一个等级的（省市区）
	var memoDateName = "";//判断memo日期是哪一个等级的（省市区）
	var status = "";
	var roleId=$("#roleId").val();
	if("3" == roleId){
		memoName = "d_memo";
		memoDateName = "d_memo_date";
		status = "11";
	}
	else if("2" == roleId){
		memoName = "c_memo";
		memoDateName = "c_memo_date";
		status = "12";
	}
	else if("1" == roleId){
		memoName = "p_memo";
		memoDateName = "p_memo_date";
		status = "4";
	}
	var radio = document.getElementsByName("review");
	var reviewResult = "";
    for(var i=0; i<radio.length; i ++){
        if(radio[i].checked){
        	if("pass" == radio[i].value){
        		reviewResult = "pass";
        	}
        	else if("unPass" == radio[i].value){
        		reviewResult = "unPass";
        		status = "2";
        	}
        }
    }
	var url = pathHeader + "/master/updateTeacherStatus.do";
	$.ajax({
		url:url,
		data:{
			teacherId:tId,
			status:status,
			memoName:memoName,
			memoVal:memoVal,
			memoDateName:memoDateName
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				jQuery.generalAlert(reviewResult);
				if(reviewResult=="pass"){
					var url2 = pathHeader + "/message/messageManagement/sendMessageToReview.do";
					jQuery.generalAlert("wojinlaile");
					$.ajax({
						url:url2,
						data:{
						},
						type:"post",
						async:true,
						success:function(data){
							if(data.success){
								queryTeacher();
							}
							jQuery.generalAlert(data.message);
						},
						error:function(){
							jQuery.generalAlert("消息发送失败！");
						}
					});
				}
				queryTeacher();
				hideMe();
				jQuery.generalAlert("评审成功！");
			}
			else{
				jQuery.generalAlert("评审失败！请检查网络或联系系统管理员！");
			}
			
		},
		error:function(){
			
		}
	});
}
function hideMe(){
	$(".tip").hide();
}
