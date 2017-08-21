jQuery(document).ready(function(){
	var pname=GetURLParameter("projectName");
	$('#pname').html(decodeURIComponent(pname));
	
	showInfoList(); //未审核用户列表
	
	//学时升序排列
	$('#periodUpSort').click(function(){
		$("#periodSortType").val("asc");
		showInfoList();
	});
	
	//学时降序排列
	$('#periodDownSort').click(function(){
		$("#periodSortType").val("desc");
		showInfoList();
	});
	
	//学分升序排列
	$('#scoreUpSort').click(function(){
		$("#scoreSortType").val("asc");
		showInfoList2();
	});
	
	//学分降序排列
	$('#scoreDownSort').click(function(){
		$("#scoreSortType").val("desc");
		showInfoList2();
	});
	
	$('.cancel').click(function(){
		$('.tip').fadeOut(100);
	});
	
	$(".tiptop a").click(function() {
		$(".tip").fadeOut(200);
	});
	
	
	$('#tabPage0').click(function(){
		$('#isScorePublished').val(1); //未审核
		$("#queryAudit").hide(); 
		
		showInfoList(); 
	});
	
	$('#tabPage1').click(function(){
		$('#isScorePublished').val(2); //已审核
		$("#queryAudit").show();
		
		showInfoList2(); 
	});
	
	//批量审核
	$('#btnBatch').click(function(){
		enterBatchCredit();
	});
	
	 $("#search").click( function () {
		 listBySelectedTab();
	 });
	 
	 $("#chkAll").click( function () {
		   if($(this).attr("checked")){
			   $("input[name='chkEnterCredit']").attr("checked",true);
		   }else{
			   $("input[name='chkEnterCredit']").attr("checked",false);
		   }
		 }
	 );
	 
	 $("#chkAll").attr("checked",false);
});


function GetURLParameter(sParam)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) 
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) 
        {
            return sParameterName[1];
        }
    }
}

//多选
function getAndSetChecked(){	
	// 子选项全选中同时选中全选项, 子选项未选中全选项取消选中
	$('#chkAll').attr('checked', false);
	$("input[name='chkEnterCredit']").click(function () {
		if($(this).attr('checked')){
			var sum = 0;
			$("input[name='chkEnterCredit']").each(function(){				
				if($(this).attr('checked')){
					sum += 1;
				} else {
					sum += 0;
				}
			});
			if(sum == $("input[name='chkEnterCredit']").length){
				$('#chkAll').attr('checked', true);
			}
		} else {				
			$('#chkAll').attr('checked', false);
		} 		
		});
}

function showInfoList(){
	$('#target').html('');
	var pageSize = $("#pageSize").val();
	var pageIndex = $("#pageIndex").val();
	var periodSortType = $("#periodSortType").val();   //学时排序
	 
	$.ajax({
		url : pathHeader + '/org/orgRegionUserListTrain.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			notAudit:"notAudit", 
			projectId:GetURLParameter("projectId"),
			pageIndex : pageIndex,
			pageSize:pageSize,
			periodSortType: periodSortType,
			queryIdNumber : $('#queryIdNumber').val(),
			queryRealName : $('#queryRealName').val(),
			areaId : $('#areaId').val(),
			areaType : $('#areaType').val()
		},
		success:function(data){
			if(data.success) {
				$("#counts").html(data.total);
				
				if(data.total>0){
					var objList = data.rows;
					var gridHtml = "";
					$.each(objList, function(index, element) {
						gridHtml += getTdHtml(element);
					});
					$('#target').append(gridHtml);
					$('.tablelist tbody tr:odd').addClass('odd');
					
				}else{
					gridHtml = "<tr><td align='center'colspan='7'>暂无查询结果！</td></tr>";
					$('#target').append(gridHtml);
				}
				
				pagination(data, function(){showInfoList();});
				
			} else {
				gridHtml = "<tr><td align='center'colspan='7'>暂无查询结果！</td></tr>";
				$('#target').append(gridHtml);
			}
			getAndSetChecked();
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='7'>错误,暂无查询结果！</td></tr>";
			$('#target').append(gridHtml);
		}
	}); 

}

function showInfoList2(){
	$('#target2').html('');
	var pageSize = 10;
	var pageIndex = $("#pageIndex").val();	
	var scoreSortType = $("#scoreSortType").val();   //学分排序 
	
	$.ajax({
		url : pathHeader + '/org/orgRegionUserListTrain.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			alreadyAudit:"alreadyAudit", 
			projectId:GetURLParameter("projectId"),
			pageIndex : pageIndex,
			pageSize: pageSize,
			scoreSortType:scoreSortType,
			queryStatus : $('#queryStatus').val(),
			queryIdNumber : $('#queryIdNumber').val(),
			queryRealName : $('#queryRealName').val(),
			areaId : $('#areaId').val(),
			areaType : $('#areaType').val()
		},
		success:function(data){
			if(data.success) {
				
				if(data.total>0){
					var objList = data.rows;
					var gridHtml = "";
					$.each(objList, function(index, element) {
						gridHtml += getTdHtml2(element);
					});
					$('#target2').append(gridHtml);
					$('.tablelist tbody tr:odd').addClass('odd');
					
				}else{
					gridHtml = "<tr><td align='center'colspan='6'>暂无查询结果！</td></tr>";
					$('#target2').append(gridHtml);
				}
				
				pagination(data, function(){showInfoList2();});
				
			} else {
				gridHtml = "<tr><td align='center'colspan='6'>暂无查询结果！</td></tr>";
				$('#target2').append(gridHtml);
			}
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='6'>错误,暂无查询结果！</td></tr>";
			$('#target2').append(gridHtml);
		}
	}); 

}

//单个审核学分 click
function auditOneCredit(){
	var ids = $("#userId").val();
	var score = $('#txt_fp').val();
	var status=$('input[name=isPass]:checked').val();
	if(score===""){
		alert("请输入审核学分!");
		return;
	}
	if(ids===""){
		alert("请选择教师!");
		return;
	}
	var isPass=$('input[name=isPass]:checked').length;
	if(isPass===0){
		alert("请选择审核状态!");
		return;
	}
	enterCredit(ids,score,status);
}

//批量审核学分 click
function enterBatchCredit(){
	 var result = $('#batchResult').val();
	 if(result ==="0"){
		 alert("请选择审核结果");
		 return;
	 } 
	 
	var score = $("#batchScore").val();
	/* if(score ===""){
		 alert("请输入批量审核学分");
		 return;
	 }*/
	
	 var count=$('input[name=chkEnterCredit]:checked').length;
	 if(count ===0){
		 alert("请选择审核人员");
		 return;
	 }
	 
	 var ids = "";
	 $('input[name=chkEnterCredit]:checked').each(function(e){
		 ids += $(this).val()+",";
	 });
	 
	 enterCredit(ids.substring(0,ids.length-1),score,result);//审核学分
}

//单个及批量审核学分
function enterCredit(ids,score,status){
	var exchangeRule = GetURLParameter("exchangeRule");
	if(exchangeRule.length==0 || typeof(exchangeRule)=="undefined"){
		if(confirm("继教版块全员兑换规则尚未设置，确定审核？")){
			postRequest(ids,score,status);
		}
	}else{
		postRequest(ids,score,status);
	}
}
 
function postRequest(ids,score,status){
	var statusName = "合格";
	if(status==12){
		statusName = "不合格"
	}
	
	var projectId = GetURLParameter("projectId");
	$.ajax({
		url:pathHeader + '/furtheredu/certificate/auditCreditTrain.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			ids:ids,
			projectId:projectId,
			status:status,
			statusName:statusName,
			score:score
		},
		success:function(data){
			if(data.success) {
				alert("审核学分成功");
				showInfoList();
				$('.tip').fadeOut(100);
			}else{
				alert("审核学分失败");
			}
		},
		error:function(){
		}
	});
}

//update credit one by one
function enterCreditOneByOne(teacherId,score){
	if(score===""){
		alert("请输入审核学分!");
		return;
	}
	if(teacherId===""){
		alert("请选择教师!");
		return;
	}
	var projectId = GetURLParameter("projectId");
	
	$.ajax({
		url:pathHeader + '/furtheredu/certificate/auditCreditTrain.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			id:teacherId,
			projectId:projectId,
			status:13,
			statusName:'合格',
			score:score
		},
		sucess:function(data){
			if(data) {
				alert("学分审核成功!");
				 
			} else {
				alert("学分审核失败!");
			}
		},
		error:function(){
			alert("错误.");
		}
	});
}

//打开弹出窗口 
function popup(userId,name,period,score){
	$("#userId").val(userId);
	$('#pTeacherName').html("教师姓名:"+name);
	$('#pscore').html(" 参加学习:"+period+"学时");
//	var unit = GetURLParameter("unit");
	$('#txt_fp').val(score);
	$(".tip").fadeIn(200);
}

function getTdHtml(obj) {
	var gridHtml = "<tr>";
	gridHtml += "<td><input name='chkEnterCredit' type='checkbox' value='" + obj.id + "' /></td>";
	gridHtml += "<td>" + obj.realName + "</td>";
	gridHtml += "<td>" + obj.idNumber + "</td>";
	gridHtml += "<td>" + obj.schoolName + "</td>";
	gridHtml += "<td>" + obj.teacherClassPeriod + "</td>";
	gridHtml += "<td>" + obj.auditScore + "</td>";
	
	gridHtml += "<td><a name=btn_bc onclick=popup(" + obj.id + "," +
					"'"+ obj.realName  +"'," +
					"'"+ obj.teacherClassPeriod + "'," +
					"'"+ obj.auditScore + "'); class='huibtn_a click'>审核</a>&nbsp;&nbsp;</td>";
	gridHtml += "</tr>";
	
	return gridHtml;
}

function getTdHtml2(obj) {
	var gridHtml = "<tr>";
	gridHtml += "<td>" + obj.realName + "</td>";
	gridHtml += "<td>" + (obj.gender == 1 ? '男':'女') + "</td>";
	gridHtml += "<td>" + obj.idNumber + "</td>";
	gridHtml += "<td>" + obj.schoolName + "</td>";
	gridHtml += "<td>" + obj.auditScore + "</td>";
	gridHtml += "<td>" + (obj.auditStatus == 12 ? '不合格' : (obj.auditStatus == 13 ? '合格' : '待审核')) +"</td>";
	gridHtml += "</tr>";
	
	return gridHtml;
}

/**
 * 最后确认, 个人开发 自己实现
 */
function lastForSure() {
	if(lastSelect != null && lastSelect.length > 0) {
		var conditionArray = lastSelect.split("_");
		var belone = conditionArray[0];
		var areaA = conditionArray[1];
		var text = conditionArray[2];
		$('#areaId').val(belone);
		$('#areaType').val(areaA);
		$('#areaName').val(text);
	}
	
	listBySelectedTab();
	
	//清空
	clear();
	
	$(".tip11").fadeOut(200);
}

//根据选中项查询对应列表
function listBySelectedTab(){
	 var isScorePublished = $("#isScorePublished").val();
	 
	 if(isScorePublished=="1"){
		 showInfoList(); //未审核用户列表
	 }else if(isScorePublished=="2"){
		 showInfoList2(); //已审核用户列表
	 }
}