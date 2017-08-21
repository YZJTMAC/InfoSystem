$(function(){
	queryTeacherScoereInfo();
	$("#select").click(function(){
		queryTeacherScoereInfo();
	});
	$("#chk_all").click(function(){
		if(this.checked){
			$("input[name='chk_list']").attr("checked",$(this).attr("checked"));
		}
		else{
			$("input[name='chk_list']").attr("checked",false);
		}
	});
});
function clearPCD() {
	$('#schoolProvinceId').val("");
	$('#schoolCityId').val("");
	$('#schoolDistrictId').val("");
	$('#tss').val("");
}
function queryTeacherScoereInfo(){
	$('#dataList').html("");
	var pageIndex = $("#pageIndex").val();
	var sizePerPage = $("#sizePerPage").val();
	var idNumber = $("#idNumber").val();
	var teacherName = $("#teacherName").val();
	var url = pathHeader+ "/sys/queryTeacherTraningScoreInfo.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
			id:id,
			flag:flag,
			idNumber:idNumber,
			startIndex : pageIndex,
			pageSize :sizePerPage,
			teacherName: teacherName,
			schoolName : $('#schoolName').val(),
			areaId:$('#areaId').val(),
			areaType:$('#areaType').val()
		},
		async:true,
		beforeSend: function(){
			$('#dataList').html("<tr><td align='center'colspan='14'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
		},
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += createTdHtml(element);
				});
				$('#dataList').html(gridHtml);
				pagination(data, function(){queryTeacherScoereInfo();});
			}else{
				$('#dataList').html("<tr><td colspan='14'>无查询记录</td></tr>");
			}
			getAndSetChecked();
		},
		error:function(){
		}
	});
}

function createTdHtml(obj){
	var createTime = new Date(obj.createTime).format("yyyy-MM-dd HH:mm:ss");
	var updateTime = new Date(obj.updateTime).format("yyyy-MM-dd HH:mm:ss");
	var rowStr = "<tr>";
	rowStr += "<td><input name='chk_list' type='checkbox' value='"+obj.id+"'></td>";
	rowStr += "<td>"+ obj.teacherName+"</td>" + 
			  "<td>"+ obj.schoolName+"</td>" +
			  "<td>"+ obj.idNumber+"</td>" +
			  "<td>"+ obj.teacherSection+"/"+obj.teacherSubject+"</td>" +
			  
			  "<td>"+ (obj.workShopNum == null ? '' : obj.workShopNum)+"</td>" +
			  "<td>"+ (obj.courseWorkNum == null ? '' : obj.courseWorkNum)+"</td>" +
			  "<td>"+ (obj.trainActivitNum == null ? '' : obj.trainActivitNum)+"</td>" +
			  "<td>"+ (obj.trainActivitJoinNum == null ? '' : obj.trainActivitJoinNum)+"</td>" +
			  "<td>"+ (obj.practiceActivitNum == null ? '' : obj.practiceActivitNum)+"</td>" +
			  "<td>"+ (obj.projectReportNum == null ? '' : obj.projectReportNum)+"</td>" +
			  "<td>"+ (obj.totalScore == null ? 0 : obj.totalScore)+"</td>" +
			  "<td><a href='javascript:void(0);' onclick='showTeacherTrainScoreMsg(\""+obj.idNumber+"\",\""+obj.pushComment+"\",\""+obj.totalScore+"\")'>"+ (obj.pushExcellent == 0 ? '未推优' : '已推优')+"</a></td>" +
			  "<td><a href='javascript:void(0);' onclick='toTeacherScoreInfo(\""+obj.teacherId+"\")'>"+"查看</a></td>";
			  rowStr += "</tr>";
	return rowStr;
}

function getAndSetChecked(){
	// 子选项全选中同时选中全选项, 子选项未选中全选项取消选中
	$('#chk_all').attr('checked', false);
	$("input[name='chk_list']").click(function () {
		if($(this).attr('checked')){
			var sum = 0;
			$("input[name='chk_list']").each(function(){				
				if($(this).attr('checked')){
					sum += 1;
				} else {
					sum += 0;
				}
			});
			if(sum == $("input[name='chk_list']").length){
				$('#chk_all').attr('checked', true);
			}
		} else {				
			$('#chk_all').attr('checked', false);
		} 		
	});
}
function exportTeacherScore(){
	var teacherIds = getCheckedTeacherIds();
	var teacherName = $("#teacherName").val();
	var schoolName = $("#schoolName").val();
	var idNumber = $("#idNumber").val();
	var areaId = $("#areaId").val();
	var areaType = $("#areaType").val();
	var url = "/sys/exportTeacherTraningScoreInfo.do";
	$("#downIframe",document.body).attr("src",pathHeader + "/sys/exportTeacherTraningScoreInfo.do?id="+id+"&queryIdNumber="+idNumber+"&teacherIds="+teacherIds+"&teacherName="+teacherName+"&schoolName="+schoolName+"&areaId="+areaId+"&areaType="+areaType);
}
//获取复选框选中的字段名称
function getCheckedTeacherIds(){
	var checkedIds = [];
    $("input[name='chk_list']:checkbox").each(function(){ 
        if($(this).attr("checked")){
        	if($(this).val() != null && $(this).val() != ''){
        		checkedIds.push($(this).val());
        	}
        }
    });
    return checkedIds;
}	
//推优详情显示
function showTeacherTrainScoreMsg(idNumber,pushComment,totalScore){
	$("#teacherIdNumber").val(idNumber);
	if(totalScore == 0 || totalScore == null || totalScore == "null"){
		alert("学分为0不能进行推优！！！");
		return;
	}else{
		if(pushComment != '' && pushComment != null && pushComment != "null"){
			$("#comment").html(pushComment);
		}else {
			$("#comment").html('');
		}
		$(".tip0").fadeIn(200);
	}
	
}
function cancel(){
	$(".tip0").fadeOut(200);
}


//学员推优
function pushTeacherScoreComment(){
	var idNumber = $("#teacherIdNumber").val();
	var comment = $("#comment").val();
	var url = pathHeader+ "/sys/addTeacherScoreComment.do";
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			idNumber:idNumber,
			comment : comment,
		},
		
		success:function(data){
			alert("操作成功！");
			window.location.reload();
		},
		error:function(){
			alert("操作失败 ！");
		}
		
	});
}

function toTeacherScoreInfo(teacherId){
	window.location.href = pathHeader + "/sys/toTeacherTrainScore.htm?teacherId="+teacherId+"&click=22";
}
/**
 * 最后确认, 个开发人 自己实现
 */
function lastForSure() {
	if(lastSelect != null && lastSelect.length > 0) {
		var conditionArray = lastSelect.split("_");
		var belone = conditionArray[0];
		var areaA = conditionArray[1];
		var text = conditionArray[2];
		$('#areaName').val(text);
		$('#areaType').val(areaA);
		$('#areaId').val(belone);
	}
	//清空
	clear();
	
	$(".tip11").fadeOut(200);
}