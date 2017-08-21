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

/**
 * 启用/禁用证书
 */
function changeCertificateStatus(id, status){
	
	$certificate = {
		id:id,
		status:status
	}
	
	$.ajax( {
			type : "POST",
			url : pathHeader + "/furtheredu/certificate/addCertificate.do",
			data:{data: $.toJSON($certificate)},
			async : true,
			success : function(msg) {
				 showInfoList();
 			},
			error : function() {
			}
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


function showInfoList() {
	$('#targetList').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + "/furtheredu/certificate/queryCertificateList.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
		queryYear:$('#queryYear').val(),
		sizePerPage:sizePerPage, 
		pageIndex:pageIndex},
		success:function(data){
			if(data.success) {
				var indexFlag = data.startIndex ;
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList, function(index,element) {
					indexFlag ++;
					gridHtml += getTdEHtml(element, indexFlag);
				});
				$('#targetList').append(gridHtml);
				
				$('#totleCount').text(data.total);
				pagination(data, function(){showInfoList(); });
			} else {
				$('#targetList').html("<tr><td colspan='12'>无查询记录</td></tr>");
			}
		},
		error:function(){
		}
	});
}

function getTdEHtml(obj ,index) {
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.year+"</td>";
	gridHtml += "<td>"+obj.title+"</td>";
	gridHtml += "<td>"+(obj.status == 1 ? "启用" : "禁用") +"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td>";
	gridHtml += "</tr>";
	return gridHtml;
	
	function optionFormatter(rows){
		var view = "<A class='tablelink  ' href='"+pathHeader +"/furtheredu/certificate/certificateShowPage.htm?id="+rows.id+"'  target=_blank>查看 </A>";
		var edit = "<A class='tablelink click' href='###' onclick='edit("+rows.id+")' >编辑 </A>";
		var remove = "<A class='tablelink  ' href='###' onclick='deleteCertificateInfo("+rows.id+")' >删除 </A>";
		var disable = "<A class='tablelink' href='###' onclick='changeCertificateStatus("+rows.id+", 0);'>禁用 </A>";
		var enable = "<A class='tablelink' href='###' onclick='changeCertificateStatus("+rows.id+", 1);'>启用 </A>";
		var returnStr = "";
		returnStr += view;
		returnStr += edit;
		returnStr += remove;
		if(rows.status == 1) {
			returnStr += disable;
		} else if (rows.status == 0) {
			returnStr += enable;
		}   
		return returnStr;
	}
}

function deleteCertificateInfo(id){
	if(confirm("确定要删除该证书模板吗？")){
		$.ajax( {
			type : "POST",
			url : pathHeader + "/furtheredu/certificate/deleteCertificate.do",
			data:{id: id},
			async : true,
			success : function(msg) {
				if (msg.success) {
					var obj = msg.obj;
					showInfoList()
					jQuery.generalAlert("删除成功！");
				} else {
					
				}
 			},
			error : function() {
			}
		});
	}
}

/**
 * 详情
 */
function info(orderId) {
	var openUrl = pathHeader + "/order/orderInfoPage.htm?orderId=" +　LogisticToString(orderId);
	showWindow(openUrl);
}

function edit(id) {
	var openUrl = pathHeader + "/furtheredu/certificate/certificateAddPage.htm?type=1&click=3&id=" +　id;
	showWindow(openUrl);
}

function showWindow(url) {
	window.location.href = url;
}