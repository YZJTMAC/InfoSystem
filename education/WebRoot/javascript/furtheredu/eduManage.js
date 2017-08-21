$(function() {
	$(".select3").uedSelect( {
		width : 100
	});
	$(".select4").uedSelect( {
		width : 100
	});
	
	initAutoComplete();
	
	$("#pageSize").change(function(){
		showInfoList();
	});
	// 查询地区
	/*areaList(0, 'provinceId');

	// 省变更
	$('#provinceId').change(function() {
		$('#cityId').empty();
		$('#cityId').append("<option value=''>请选择市</option>");
		$('#districtId').empty();
		$('#districtId').append('<option value="">请选择区/县</option>');
		if ($(this).val() == '') {
			return false;
		}
		areaList($(this).val(), 'cityId');
	});

	// 市变更
	$('#cityId').change(function() {
		$('#districtId').empty();
		$('#districtId').append('<option value="">请选择区/县</option>');
		if ($(this).val() == '') {
			return false;
		}
		areaList($(this).val(), 'districtId');
	});*/
});

/**
 * 初始化
 */
function initAutoComplete() {
	lastForSure();
	$("#chk_all").click(function() {
		if($(this).attr("checked")){
			$("input[name='chk_list']").attr("checked", $(this).attr("checked"));			
		}
		else{
		$("input[name='chk_list']").attr("checked", false);
		}
	});

	$(".batchAudit").click(function() {
		//		var arrChk=$("input[name='chk_list']:checked");
			getAuditIds('h');
			$(".tip").fadeIn(200);
		});

	$(".click").click(function() {
		$(".tip").fadeIn(200);
	});

	$(".tiptop a").click(function() {
		$(".tip").fadeOut(200);
	});

	//批量审核
	$(".sure").click(function() {
		teacherAudit();
	});

	$(".cancel").click(function() {
		$(".tip").fadeOut(100);
	});

	$(".click2").click(function() {
		$(".tip2").fadeIn(200);
	});

	$(".tip2top a").click(function() {
		$(".tip2").fadeOut(200);
	});

	$(".sure2").click(function() {
		teacherDelete();
		$(".tip2").fadeOut(100);
	});

	$(".cancel2").click(function() {
		$(".tip2").fadeOut(100);
	});

}
//子选项全选中同时选中全选项, 子选项未选中全选项取消选中
function getAndSetChecked(){	
	$("input[name='chk_list']").click(function(){		
		if($(this).attr("checked")){			
			var sum = 0;
			$("input[name='chk_list']").each(function(){
				if($(this).attr("checked")){
					sum += 1;
				}
				else{
					sum += 0;
				}
			});
			if(sum == $("input[name='chk_list']").length){
				$("#chk_all").attr("checked",true)
			}
		}
		else{
			$("#chk_all").attr("checked",false)
		}
	});
}

/*function addAreaQueryCondition(belone, area, text) {
	var gridHtml = "<li class='area'><span><a href='###' id='" + belone + "_"
			+ area + "_" + text + "' >" + text + "</a></span></li>";
	gridHtml += "<li class='flag'>&gt;</li>";
	chilkQueryConditionArray[indexFlag] = belone + "_" + area + "_" + text;
	chilkQueryConditionHtml.push(gridHtml);
	$('#childCondition').append(gridHtml);
	indexFlag++;
}

function areaList(belong, area){
	var url = pathHeader + "/sys/areaList.do";
	$.ajax({
		url:url,
		data:{
			belong:belong
		},
		dataType:"json",
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				var obj = eval(data.obj);
				if(obj.length > 0){
					for(var i=0; i<obj.length; i++){
						$opt2 = $("<option value='" + obj[i].code + "'>" + obj[i].name + "</option>");
						$('#'+area).append($opt2);
					}
				}
			}
		},
		error:function(){
		}
	});
}

*//**
 * 地区
 * @param {Object} obj
 * @return {TypeName} 
 *//*
function dHtml(obj) {
	var htmlStr = "";
	for ( var i = 0; i < obj.length; i++) {
		htmlStr += "<dd><input type='checkbox'>";
		if (obj[i].schoolCount > 0) {
			districtId = obj[i].code;
			districtName = obj[i].name;
			htmlStr += "<a href='###' onclick='querySchool();addAreaQueryCondition("
					+ obj[i].code
					+ ", \"districtId\", \""
					+ obj[i].name
					+ "\");' class='tablelink'>" + obj[i].name ;
			htmlStr += "<img src='" + pathHeader
					+ "/images/more.jpg' width='13' height='13'></a>";
		} else {
			htmlStr += "<a href='###' class='tablelink'>" + obj[i].name
					+ "</a>";
		}
		htmlStr += "</dd>";
	}
	return htmlStr;
}

*//**
 * 市
 * @param {Object} obj
 * @return {TypeName} 
 *//*
function cHtml(obj) {
	var htmlStr = "";
	for ( var i = 0; i < obj.length; i++) {
		htmlStr += "<dd><input type='checkbox'>";
		if (obj[i].childrenCount > 0) {
			htmlStr += "<a href='###' onclick='areaList(" + obj[i].code
					+ ", \"districtId\", \"" + obj[i].name
					+ "\")' class='tablelink'>" + obj[i].name ;
			htmlStr += "<img src='" + pathHeader
					+ "/images/more.jpg' width='13' height='13'></a>";
		} else {
			htmlStr += "<a href='###' class='tablelink'>" + obj[i].name
					+ "</a>";
		}
		htmlStr += "</dd>";
	}
	return htmlStr;
}

*//**
 * 大区-省
 * @param {Object} obj
 * @return {TypeName} 
 *//*
function pHtml(obj) {
	var htmlStr = "<dl>";
	htmlStr += "<dt>东北地区</dt>";
	for ( var i = 0; i < obj.length; i++) {
		if (obj[i].childrenCount > 0) {
			htmlStr += "<dd><a href='###' onclick='areaList(" + obj[i].code
					+ ", \"cityId\", \"" + obj[i].name + "\")' >" + obj[i].name
					+ "</a></dd>";
		} else {
			htmlStr += "<dd><a href='###' >" + obj[i].name + "</a></dd>";
		}
	}
	htmlStr += "</dl>";
	return htmlStr;
}*/

function showDeleteDiv(data) {
	$('#auditIds').val(data);
	$(".tip2").fadeIn(200);
}
function showAuditDiv(data) {
	$('#auditIds').val(data);
	$(".tip").fadeIn(200);
}

function getAuditIds(str) {
	var arrChk = $("input[name='chk_list']:checked");
	var idStr = "";
	$(arrChk).each(function() {
		var option = $('#' + this.value + '_batchOption').val();
		//判断是否有审核权限
		if (option.indexOf(str) >= 0) {
			idStr += this.value + ",";
		}
	});
	idStr = idStr.substring(0, idStr.length - 1);
	$('#auditIds').val(idStr);
}

/**
 * 删除继教信息
 */
function teacherDelete() {
	data = $('#auditIds').val();
	memo = $('#deleteMemo').val();
	$.ajax( {
		url : pathHeader + "/furtheredu/edumanage/deleteManage.do",
		type : "POST",
		cache : "false",
		async : "true",
		dataType : "json",
		data : {
			data : data,
			memo : memo
		},
		success : function(data) {
			if (data.success) {
				$('#auditIds').val("");
				$(".tip2").fadeOut(200);
				showInfoList();
			} else {
			}
		},
		error : function() {
		}
	});
}

/**
 * 审核教师继教信息
 */
function teacherAudit() {
	data = $('#auditIds').val();
	memo = $('#auditMemo').val();
	var auditTeacher = $('input:radio[name="auditTeacher"]:checked').val();
	$.ajax( {
		url : pathHeader + "/furtheredu/edumanage/auditEduInfo.do",
		type : "POST",
		cache : "false",
		async : "true",
		dataType : "json",
		data : {
			data : data,
			isPass : auditTeacher,
			memo : memo
		},
		success : function(data) {
			if (data.success) {
				$('#auditIds').val("");
				$(".tip").fadeOut(200);
				showInfoList();
			} else {

			}
		},
		error : function() {
		}
	});
}

function showInfoList() {
	$('#targetList').html("");
	var sizePerPage = $("#pageSize").val();
	var pageIndex = $("#pageIndex").val();

	$.ajax( {
		url : pathHeader + "/furtheredu/edumanage/queryManageList.do",
		type : "POST",
		cache : "false",
		async : "true",
		dataType : "json",
		data : {
			projectName : $('#projectName').val(),
			queryYearStart : $('#queryYearStart').val(),
			queryYearEnd : $('#queryYearEnd').val(),
			queryStatus : $('#queryStatus').val(),
			queryIdNumber : $('#queryIdNumber').val(),
			queryRealName : $('#queryRealName').val(),
			queryPId : $('#provinceId').val(),
			areaId : $('#areaId').val(),
			areaType : $('#areaType').val(),
			sizePerPage : sizePerPage,
			pageIndex : pageIndex
		},
		success : function(data) {			
				var indexFlag = data.startIndex;
				var objList = data.rows;
				var orgId = data.orgId;
				var areaId = data.areaId;
				if(objList.length > 0){
					var gridHtml = "";
					
					$.each(objList, function(index, element) {
						indexFlag++;
						gridHtml += getTdEHtml(element, indexFlag,orgId,areaId);
					});
					$('#targetList').append(gridHtml);
					$('#totleCount').text(data.total);
				}
				else{
					$('#totleCount').text(0);
					$('#targetList').html("<tr><td colspan='12'>无查询记录</td></tr>");
				}
				pagination(data, function() {
					showInfoList();
				});
			
			getAndSetChecked();
		},
		error : function() {
		}
	});
}

function getTdEHtml(obj, index,orgId,areaId) {
	var gridHtml = "<tr>";
	gridHtml += "<td><input name='chk_list' type='checkbox' value='" + obj.id
			+ "'></td>";
	gridHtml += "<td>" + obj.year + "</td>";
	gridHtml += "<td>" + obj.projectName + "</td>";
	gridHtml += "<td>" + obj.idNumber + "</td>";
	gridHtml += "<td>" + obj.realName + "</td>";
	gridHtml += "<td>" + obj.schoolName + "</td>";
	gridHtml += "<td>" + (obj.teacherTrainStatusId == 1 ? "合格" : "不合格")
			+ "</td>";
	gridHtml += "<td>"+obj.teacherClassPeriod+"/" + obj.teacherClassScore + "学分</td>";
	gridHtml += "<td>" + statusFormatter(obj) + "</td>";
	gridHtml += "<td>" + optionFormatter(obj) + "</td>";
	gridHtml += "</tr>";
	return gridHtml;
	function statusFormatter(rows) {
		var returnStr = "";
		if (rows.teacherScoreAuditStatusId == 11) {
			returnStr = "未审核";
		} else if (rows.teacherScoreAuditStatusId == 12) {
			returnStr = "<i>审核未通过</i>";
		} else if (rows.teacherScoreAuditStatusId == 13) {
			returnStr = "审核通过";
		}
		return returnStr;
	}

	function optionFormatter(rows) {
		var remove = "";
		var handle = "";
		
		//项目创建者所属区域和登陆者区域相同，方可操作
		if(rows.createByArea == areaId || rows.organizationId == orgId){
			remove = "<a href='###' onClick='showDeleteDiv(" + rows.id
			+ ")' class='tablelink click2'>删除</a>&nbsp;&nbsp;";
	        handle = "<a href='###' onClick='showAuditDiv(" + rows.id
			+ ")' class='tablelink click'>审核</a>";
		}
		
		var returnStr = "";
		if (rows.teacherScoreAuditStatusId == 11) {//未审核
			returnStr += remove;
			returnStr += handle;
			returnStr += "<input id='" + rows.id
					+ "_batchOption' type='hidden' value='r_h' />";
		} else if (rows.teacherScoreAuditStatusId == 12) {//审核未通过
			returnStr += remove;
			returnStr += "<input id='" + rows.id
					+ "_batchOption' type='hidden' value='r' />";
		} else if (rows.teacherScoreAuditStatusId == 13) { // 审核通过
			returnStr += remove;
			returnStr += "<input id='" + rows.id
					+ "_batchOption' type='hidden' value='r' />";
		}
		return returnStr;
	}
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
	//重新生成查询条件
	showInfoList();
	
	//清空
	clear();
	
	$(".tip11").fadeOut(200);
}

/**
 * 详情
 */
function info(orderId) {
	var openUrl= pathHeader + "/order/orderInfoPage.htm?orderId=" + LogisticToString(orderId);
	showWindow(openUrl);
}

function showWindow(url) {
	window.location.href = url;
}