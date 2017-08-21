$(function() {
	getRoleList();
	getRoleTypeList();
	showManagesList();

	//if (judgeAuthority("system_011_add")) {
	$('#action').html("<a href='###' onclick='batchModifyMgr();' class=\"huibtn_a\" style=\"margin-left: 6px\">批量修改</a>&nbsp;");
	$('#action').append("<a href='###' onclick='batchDelMgr();' class=\"huibtn_a\" style=\"margin-left: 6px\">批量删除</a>&nbsp;");
	$('#action').append("<a href=\""+ pathHeader + "/person/toAddManagesPage.htm?click=444\" class=\"huibtn_a\" style=\"margin-left: 6px\">添加</a>&nbsp;");
	//}
	//if(judgeAuthority("system_011_export")){
	$('#action').append("<a href=\"#\" onclick=\"downTeacherExcl();\" class=\"huibtn_a \" style=\"margin-left: 6px\">导出</a>");
	//}
	
	// 条件查询
	$("#select").click(function() {
		showManagesList();
	});
})

function downTeacherExcl() {
	$("#downIframe", document.body).attr(
			"src",
			pathHeader + "/person/exportManagesList.do?loginAccount="
					+ $('#loginAccount').val() + "&roleId="
					+ $('#roleId').val() + "&userProvinceId="
					+ $('#schoolProvinceId').val() + "&userCityId="
					+ $('#schoolCityId').val() + "&userDistrictId="
					+ $('#schoolDistrictId').val()+ "&schoolId="
					+ $('#schoolId').val());
}

function clearPCD() {
	$('#schoolProvinceId').val("");
	$('#schoolCityId').val("");
	$('#schoolDistrictId').val("");
	$('#tss').val("");
}

function showManagesList() {
	$('#proTeacher_list').html('');
	var pageIndex = $("#pageIndex").val();
	var sizePerPage = $("#sizePerPage").val();
	$.ajax( {
				url : pathHeader + '/person/queryManages.do',
				type : "POST",
				cache : "false",
				async : "true",
				dataType : "json",
				data : {
					loginAccount : $('#loginAccount').val(),
					roleId : $('#roleId').val(),
					roleTypeId : $('#roleTypeId').val(),
					schoolName:$("#schoolName").val(),
					sizePerPage : sizePerPage,
					pageIndex : pageIndex,
					userProvinceId : $('#schoolProvinceId').val(),
					userCityId : $('#schoolCityId').val(),
					userDistrictId : $('#schoolDistrictId').val()
				},
				success : function(data) {
					if (data.success) {
						var objList = data.rows;
						var gridHtml = "";
						$("#counts").html(data.total);
						$.each(objList, function(index, element) {
							gridHtml += getTdHtml(element, data.roleId);
						});

						$('#proTeacher_list').append(gridHtml);
						pagination(data, function() {
							showManagesList();
						});
					} else {
						gridHtml = "<tr><td align='center' colspan='7'>暂无查询结果！</td></tr>";
						$('#proTeacher_list').append(gridHtml);
					}
					
					getAndSetChecked();
				},
				error : function() {
					gridHtml = "<tr><td align='center' colspan='7'>暂无查询结果！</td></tr>";
					$('#proTeacher_list').append(gridHtml);
				}
			});
}

function getTdHtml(obj, logRoleId) {
	var gridHtml = "<tr>";
	gridHtml += "<td><input id='"+obj.id+"' class='xiao_checkbox' type='checkbox'/></td>";
	gridHtml += "<td>" + obj.realName + "</td>";
	gridHtml += "<td>" + obj.loginAccount + "</td>";
	gridHtml += "<td>" + obj.password + "</td>";
	gridHtml += "<td>" + obj.roleName + "</td>";
	gridHtml += "<td>" + obj.roleTypeName + "</td>";
	gridHtml += "<td>"
			+ (obj.userProvinceName != null ? obj.userProvinceName : "")
			+ obj.userCityName + obj.userDistrictName +   "</td>";
	gridHtml += "<td>" +obj.schoolName.replace("—","") + "</td>";
	gridHtml += "<td>" + obj.userStatus + "</td>";
	gridHtml += "<td>";
	if (parseFloat(logRoleId) <= 1) {

		//if (judgeAuthority("ststem_011_select")) {
		gridHtml += "<a href='" + pathHeader
				+ "/person/toInfoManagesPage.htm?click=444&id=" + obj.id
				+ "' style='cursor: pointer;'>查看</a>&nbsp;&nbsp";
		//}
		//if (judgeAuthority("system_011_update")) {
		gridHtml += "<a href='" + pathHeader
				+ "/person/toModifyManagesPage.htm?click=444&id=" + obj.id
				+ "' style='cursor: pointer;'>编辑</a>&nbsp;&nbsp";
		//}
		//if (judgeAuthority("ststem_011_delete")) {
		gridHtml += "<a onclick='del(" + obj.id
				+ ")' style='cursor: pointer;'>删除</a>&nbsp;&nbsp";
		//}

	} else if (parseFloat(logRoleId) > 1 && obj.roleId.toString() != "0") {

		//if (judgeAuthority("ststem_011_select")) {
		gridHtml += "<a href='" + pathHeader
				+ "/person/toInfoManagesPage.htm?click=444&id=" + obj.id
				+ "' style='cursor: pointer;'>查看</a>&nbsp;&nbsp";
		//}
		//if (judgeAuthority("system_011_update")) {
		gridHtml += "<a href='" + pathHeader
				+ "/person/toModifyManagesPage.htm?click=444&id=" + obj.id
				+ "' style='cursor: pointer;'>编辑</a>&nbsp;&nbsp";
		//}
		//if (judgeAuthority("ststem_011_delete")) {
		gridHtml += "<a onclick='del(" + obj.id
				+ ")' style='cursor: pointer;'>删除</a>&nbsp;&nbsp";
		//}
	}
	gridHtml += "</td>";
	gridHtml += "</tr>";
	return gridHtml;
}

function getSelected(sid){
	var value,text;
	text = $("#"+sid+" option:selected").text();
	value = $("#"+sid).val();
	scontent={
		value:value,
		text:text
	};
	return scontent;
}
function batchModifyMgr(){
	var ids = getChecked();
	if(ids.length<1){
		$('#msgHtml').html("请选择需要批量修改的记录？");
		$(".tip").fadeIn(200);
		$("#toPage").click(function() {
			close();
		});
		$("#cancel").click(function() {
			close();
		});
		return;
	}
	
	$(".tip0").fadeIn(200);
	$("#modifyRole").click(function() {
		var roleId = getSelected("batRoleId").value;
		if(roleId == ""){
			$('#selectedError').html("请选择角色类型！");
			return false;
		}
		batchModifyManages(ids)
		close();
	});
	$("#modifyCancel").click(function() {
		close();
	});
}

//批量修改用户角色
function batchModifyManages(ids){
	
	$.ajax( {
		url : pathHeader + '/person/batchModifyMgrs.do',
		type : "POST",
		cache : "false",
		async : "true",
		dataType : "json",
		data : {
			ids : ids,
			roleId : getSelected("batRoleId").value
		},
		success : function(data) {
			close();
			showManagesList();
		},
		error : function() {
			//toPage();
		}
	});
}


function batchDelMgr(){
	var ids = getChecked();
	if(ids.length<1){
		$('#msgHtml').html("请选择需要批量删除的记录？");
		$(".tip").fadeIn(200);
		$("#toPage").click(function() {
			close();
		});
		$("#cancel").click(function() {
			close();
		});
		return;
	}
	
	$('#msgHtml').html("确定要批量删除这些记录吗？");
	$("#toPage").click(function() {
		batchDelManages(ids);
	});
	$("#cancel").click(function() {
		close();
	});

	$(".tip").fadeIn(200);
	
}


function batchDelManages(ids){
	$.ajax( {
		url : pathHeader + '/person/batchDelMgrs.do',
		type : "POST",
		cache : "false",
		async : "true",
		dataType : "json",
		data : {
			ids : ids
		},
		success : function(data) {
			if (data.success) {
				$('#allCheck').attr('checked', false);
				close();
				showManagesList();
			} else {
				showManagesList();
			}
		},
		error : function() {
			toPage();
		}
	});
}


function del(id) {
	$('#msgHtml').html("确定要删除此条记录吗？");

	$("#toPage").click(function() {
		deleteManges(id);
	});
	$("#cancel").click(function() {
		close();
	});

	$(".tip").fadeIn(200);
}

function close() {
	$(".tip").fadeOut(200);
	$(".tip0").fadeOut(200);
}

function toPage() {
	window.location.href = pathHeader + "/person/toManagesPage.htm?click=444";
}

function deleteManges(id) {
	$.ajax( {
		url : pathHeader + '/person/deleteManages.do',
		type : "POST",
		cache : "false",
		async : "true",
		dataType : "json",
		data : {
			id : id
		},
		success : function(data) {
			if (data.success) {
				toPage();
			} else {
				toPage();
			}
		},
		error : function() {
			toPage();
		}
	});

}



//多选
function getAndSetChecked(){
	$('#allCheck').attr('checked', false);
	// 批量选中/取消
	$('#allCheck').click(function(){
		if($(this).attr('checked')){
			$('.xiao_checkbox').attr('checked', 'checked');
		} else {
			$('.xiao_checkbox').attr('checked', false);
		}
	});
	// 子选项选中同时选中父选项, 子选项都未选中父选项取消选中
	$('.xiao_checkbox').click(function(){
		if($(this).attr('checked')){
			var sum = 0;
			$('.xiao_checkbox').each(function(){
				if($(this).attr('checked')){
					sum += 1;
				} else {
					sum += 0;
				}
			});
			if(sum == $('.xiao_checkbox').length){
				$('#allCheck').attr('checked', true);
			}
			
		} else {
			$('#allCheck').attr('checked', false);
		} 
	});
}


function getChecked(){
	var ids = '';
	$('.xiao_checkbox').each(function(){
		if($(this).attr('checked')){
			ids += this.id + ',';
		}
	});
	if(ids.length >0){
		ids = ids.toString().substring(0,ids.length-1);
	}
	return ids;
}
//验证是否具有显示权限
function xianshi(roleId) {
		if(roleId == 1) {
				$('#glyuan').hide();
		}
		if(roleId == 2) {
				$('#glyuan').hide();
				$('#sgly').hide();
				$('#shengssjggly').hide();
		}
		if(roleId == 3) {
				$('#glyuan').hide();
				$('#sgly').hide();
				$('#gly').hide();
				$('#shengssjggly').hide();
				$('#shissjggly').hide();
		}
			
			
		if(roleId == 4) {
			$('#glyuan').hide();
			$('#sgly').hide();
			$('#gly').hide();
			$('#qgly').hide();
			$('#cpjggly').hide();
			$('#shengssjggly').hide();
			$('#shissjggly').hide();
			$('#qussjggly').hide();
		
		}

		if(roleId == 6) {
				$('#glyuan').hide();
				$('#sgly').hide();
				$('#gly').hide();
				$('#qgly').hide();
				$('#xgly').hide();

  		}
		
		if(roleId == 7) {
			$(document).ready(function(){
				$('#glyuan').hide();
				$('#sgly').hide();
				$('#gly').hide();
				$('#qgly').hide();
				$('#xgly').hide();
		});

  		}
		
		
		if(roleId == 8) {
				$('#glyuan').hide();
				$('#sgly').hide();
				$('#gly').hide();
				$('#qgly').hide();
				$('#xgly').hide();
				$('#shengssjggly').hide();

  		}
		if(roleId == 9) {
				$('#glyuan').hide();
				$('#sgly').hide();
				$('#gly').hide();
				$('#qgly').hide();
				$('#xgly').hide();
				$('#shengssjggly').hide();
				$('#shissjggly').hide();

  		}
		if(roleId == 10) {
				$('#glyuan').hide();
				$('#sgly').hide();
				$('#gly').hide();
				$('#qgly').hide();
				$('#xgly').hide();
				$('#shengssjggly').hide();
				$('#shissjggly').hide();
				$('#qussjggly').hide();

  		}
	
	return true;
}

function getRoleList() {
	$('#roleId').html('');
	$('#batRoleId').html('');
	
	$.ajax( {
				url : pathHeader + '/sys/queryRoleList.do',
				type : "POST",
				cache : "false",
				async : "true",
				dataType : "json",
				data:{onlyManager :true,status : 1},
				success : function(data) {
					if (data.success) {
						var objList = data.rows;
						var gridHtml = "<option value=''>请选择...</option>";
						$.each(objList, function(index, element) {
							gridHtml += getSelHtml(element);
						});
						
					}
					$('#roleId').append(gridHtml);
					$('#batRoleId').append(gridHtml);
				},
				error : function() {
					
				}
			});
}


function getSelHtml(obj) {
	var gridHtml = "";
	gridHtml += "<option id="+obj.roleType+" value="+obj.id+">" + obj.roleName +" ["+ obj.roleTypeName +"]"+ "</option>";
	return gridHtml;
}

function getRoleTypeList(){
	$('#roleTypeId').html('');
	
	$.ajax( {
				url : pathHeader + '/sys/queryRoleTypeList.do',
				type : "POST",
				cache : "false",
				async : "true",
				dataType : "json",
				data:{onlyManager :true,status : 1,isDisTeacher : 1},
				success : function(data) {
					if (data.success) {
						var objList = data.rows;
						var gridHtml = "<option value=''>请选择...</option>";
						$.each(objList, function(index, element) {
							gridHtml += getRoleTypeHtml(element);
						});
					}
					$('#roleTypeId').append(gridHtml);
				},
				error : function() {
					
				}
			});
}

function getRoleTypeHtml(obj) {
	var optionHtml = "<option value=" + obj.roleType + ">" + obj.roleTypeName
	 + "</option>";
	return optionHtml;
}