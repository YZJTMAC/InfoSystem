$(function(){
	initAutoComplete();
	$("#pageSize").change(function(){
		showInfoList();
	});
});

/**
 * 初始化
 */
function initAutoComplete(){
	showInfoList();
	 $(".click").click(function(){
		$('#year').val("");
		$('#classPeriod').val("");
		$('#classScore').val("");
		$('#provinceId').val("");
		$('#cityId').val("");
		$('#targetId').val("0");
	  	$(".tip").fadeIn(200);
	 });
	  
	  $(".tiptop a").click(function(){
	  $(".tip").fadeOut(200);
		});
	
	  $(".sure").click(function(){
		  saveA();
	  	$(".tip").fadeOut(100);
	 });
	
	  $(".cancel").click(function(){
	 	 $(".tip").fadeOut(100);
		});
}


function queryTargetInfo(id) {
	$(".tip").fadeIn(200);
	$.ajax({
		type : "POST",
		url : pathHeader + "/furtheredu/edutarget/findTargetInfo.do",
		data:{id:id},
		async : true,
		success : function(msg) {
				if (msg.success) {
					var obj = msg.obj;
					$('#year').val(obj.year);
					$('#classPeriod').val(obj.classPeriod);
					$('#classScore').val(obj.classScore);
					$('#provinceId').val(obj.provinceId);
					$('#cityId').val(obj.cityId);
					$('#targetId').val(obj.id);
				} else {
						
				}
 			},
			error : function() {
			}
	});
}

function updateA(data){
	$.ajax({
			type : "POST",
			url : pathHeader + "/furtheredu/edutarget/updateTarget.do",
			data:{data: $.toJSON(data)},
			async : true,
			success : function(msg) {
				if (msg.success) {
					 if(msg.userId >= 0) {
						 jQuery.generalAlert("年度设置修改成功！");
					 }  
					 showInfoList();
				} else {
					
				}
 			},
			error : function() {
			}
		});
}

function saveA(){
	
	$user = {
		year:$('#year').val(),
		classPeriod:$('#classPeriod').val(),
		classScore:$('#classScore').val(),
		provinceId:$('#provinceId').val(),
		provinceName:$('#provinceId').text(),
		cityId:$('#cityId').val(),
		id:$('#targetId').val(),
		cityName:$('#cityId').text()
	}
	
	if($user.id != 0) {
		updateA($user);
		return;
	}
	
	$.ajax({
			type : "POST",
			url : pathHeader + "/furtheredu/edutarget/saveTarget.do",
			data:{data: $.toJSON($user)},
			async : true,
			success : function(msg) {
				if (msg.success) {
					 if(msg.userId == 0) {
					 } else if(msg.userId > 0){
						 teacherId = msg.userId;
					 }
					 showInfoList();
				} else {
					
				}
 			},
			error : function() {
			}
		});
}

/**
 * 删除教师
 */
function deleteTarget(data) {
	if(!confirm('确定要删除选中的设置吗？'))
			return false;
	$.ajax({
		url : pathHeader + "/furtheredu/edutarget/deleteTarget.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{id:data},
		success:function(data){
			if(data.success) { 
				showInfoList();
			} else {
			}
		},
		error:function(){
		}
	});
}

function clearYearTagrtB() {
	qperiod = 0;
	qscore = 0;
	
	cperiod = 0;
	cscore = 0;
	
	dperiod = 0;
	dscore = 0;
	
	speriod = 0;
	sscore = 0;
}

function clearYearTagrt() {
	qid= '';
	qname= '';
	qperiod = 0;
	qscore = 0;
	
	cid= '';
	cname= '';
	cperiod = 0;
	cscore = 0;
	
	did= '';
	dname= '';
	dperiod = 0;
	dscore = 0;
	
	sid= '';
	sname= '';
	speriod = 0;
	sscore = 0;
}
/**
 * 最后确认, 个开发人 自己实现
 */
function lastForSure() {
	clearYearTagrt();
	var tempArray = chilkQueryConditionArray;
	$(tempArray).each(function(index, element) {
		if (element != null && element.length > 0) {
			var temp = element.split("_");
			if (temp[1] == "provinceId") {
				qid = temp[0];
				qname = temp[2];
			} else if (temp[1] == "cityId") {
				cid = temp[0];
				cname = temp[2];
			} else if (temp[1] == "districtId") {
				did = temp[0];
				dname = temp[2];
			} else if (temp[1] == "schoolId") {
				if (temp[0] != undefined) {
					sid = temp[0];
				}
				sname =  temp[2];
			}

		}
	})
	
	
	if(lastSelect != null && lastSelect.length > 0) {
		var conditionArray = lastSelect.split("_");
		var belone = conditionArray[0];
		var areaA = conditionArray[1]
		var text = conditionArray[2]
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
 * 根据地区获得，年度目标设置
 */
function showYearTagert() {
	$("#yearTagrt").html("");
	if(qid != null && qid != "") {
		$("#yearTagrt").append(	$('#queryYear').val() +"年度&nbsp;&nbsp;"+ qname + "考核要求：<b>[学分要求]</b>"+qscore+"学分；<br>");
	}
	if(cid != null && cid != "") {
		$("#yearTagrt").append(	$('#queryYear').val() +"年度&nbsp;&nbsp;"+ cname + "考核要求：<b>[学分要求]</b>"+cscore+"学分；<br>");
	}
	if(did != null && did != "") {
		$("#yearTagrt").append(	$('#queryYear').val() +"年度&nbsp;&nbsp;"+ dname + "考核要求：<b>[学分要求]</b>"+dscore+"学分；<br>");
	}
	if(sid != null && sid != "") {
		$("#yearTagrt").append(	$('#queryYear').val() +"年度&nbsp;&nbsp;"+ sname + "考核要求：<b>[学分要求]</b>"+sscore+"学分；<br>");
	}
}

function showInfoList() {
	$('#targetList').html("");
	var sizePerPage = $("#pageSize").val();
	var pageIndex = $("#pageIndex").val();
	/*var year = $('#queryYear').val();
	if(queryYear != null && queryYear != "" ) {
		year = queryYear;
		$('#queryYear').val(queryYear);
		queryYear = "";
	} */
	$.ajax({
		url : pathHeader + "/furtheredu/edumanage/queryManageGroupByList.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
		queryYear:$('#queryYear').val(),
		qid:qid,
		cid:cid,
		did:did,
		sid:sid,
		areaId : $('#areaId').val(),
		areaType : $('#areaType').val(),
		realName : $('#queryRealName').val(),
		sizePerPage:sizePerPage, 
		pageIndex:pageIndex},
		success:function(data){
				initYearTargert(data.yearTagrt);
				var indexFlag = data.startIndex ;
				var objList = data.rows;
				if(objList.length > 0){
					var gridHtml = "";
					$.each(objList, function(index,element) {
						indexFlag ++;
						gridHtml += getTdEHtml(element, indexFlag);
					});
					$('#targetList').append(gridHtml);
					$('#totleCount').text(data.total);
				}
				 else {
						initYearTargert(data.yearTagrt);
						$('#totleCount').text(0);
						$('#targetList').html("<tr><td colspan='12'>无查询记录</td></tr>");
					}
				pagination(data, function(){showInfoList(); });				
			showYearTagert();
		},
		error:function(){
		}
	});
}

function initYearTargert(data) {
	if(data == null || data.length == 0) {
		clearYearTagrtB();	
		return;
	}
	var qflag = false;
	var cflag = false;
	var dflag = false;
	var sflag = false;
	$.each(data, function(index,element) {
		
		if(element.provinceId !=null && element.cityId != null && element.districtId != null && element.schoolId != null ) {
			sid = element.schoolId;
			sname= element.schoolName;
			speriod = element.classPeriod;
			sscore = element.classScore;
			sflag = true;
		}  else if(element.provinceId !=null && element.cityId != null && element.districtId != null && element.schoolId == null ) {
			did = element.districtId;
			dname = element.districtName;
			dperiod = element.classPeriod;
			dscore = element.classScore;
			dflag = true;
		} else if(element.provinceId !=null && element.cityId != null && element.districtId == null && element.schoolId == null ) {
			cid = element.cityId;
			cName = element.cityName;
			cperiod = element.classPeriod;
			cscore = element.classScore;
			cflag = true;
		} else if(element.provinceId !=null && element.cityId == null && element.districtId == null && element.schoolId == null ) {
			qid = element.provinceId;
			qname = element.provinceName;
			qperiod = element.classPeriod;
			qscore = element.classScore;
			qflag = true;
		} 
	});
	if(!qflag) {
		qid = "";
		qname = "";
		qperiod = 0;
		qscore = 0;
	}
	if(!cflag) {
		cid = "";
		cname = "";
		cperiod = 0;
		cscore = 0;
	}
	if(!dflag) {
		did = "";
		dname = "";
		dperiod = 0;
		dscore = 0;
	}
	if(!sflag) {
		sid = "";
		sname = "";
		speriod = 0;
		sscore = 0;
	}
}

function closeTip() {
	$(".tip0").fadeOut(200);
}

function sendInfo(receverId, receverName,isHege){
	var content = '年度继教考核未达到要求';
	if(isHege=='合格'){
		content = '年度继教考核达到要求';
	}
	var url = pathHeader+ "/message/messageManagement/sendMessageToUser.do";
	$.ajax({
				url:url,
				type:"post",
				data:{
				content:content,
				title:"继教考核提醒",
				receiveUserId:receverId,
				receiveUserName:receverName
				},
				async:true,
				success:function(data){
					if(data.success){
						$(".tip0").fadeIn(200);
					}
				},
			error:function(){
			jQuery.generalAlert("错误");
		}
	});
}


function getTdEHtml(obj ,index) {
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.realName+"</td>";
	gridHtml += "<td>"+(obj.idNumber==null?"":obj.idNumber)+"</td>";
	gridHtml += "<td>&nbsp;"+(obj.teacherScore==null?"0":obj.teacherScore)+"学分</td>" ;
	gridHtml += "<td><i>"+compare(0,(obj.teacherScore==null?"0":obj.teacherScore))+"</i>&nbsp;<a href='###' onclick='sendInfo(\""+obj.teacherId+"\", \""+obj.realName+"\",\""+compare(0,(obj.teacherScore==null?"0":obj.teacherScore))+"\")'>发送提醒</a></td>";
	gridHtml += "</tr>";
	return gridHtml;
	
	/**
	 * 比较合格 与 不合格
	 * @param {Object} a 学时
	 * @param {Object} b 学分
	 */
	function compare(a, b) {
//		if( a< qperiod || a< cperiod|| a< dperiod|| a< dscore) {
//			return "不合格";
//		}
		if( b< dscore || b< cscore|| b< qscore|| b< sscore) {
			return "不合格";
		}
		return "合格";
	}
}

/**
 * 详情
 */
function info(orderId) {
	var openUrl = pathHeader + "/order/orderInfoPage.htm?orderId=" +　LogisticToString(orderId);
	showWindow(openUrl);
}

function showWindow(url) {
	window.location.href = url;
}