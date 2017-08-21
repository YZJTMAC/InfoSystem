$(function() {
	showTeacherAssessList();
	roleTypeList();
});
function roleTypeList() {
	
	$.ajax( {
			url : pathHeader + '/sys/queryRoleTypeList.do',
			type : "POST",
			cache : "false",
			async : "true",
			dataType : "json",
			success : function(data) {
				if(data.success) {
					var objList = data.rows;
					var gridHtml = "";
					$.each(objList, function(index, element) {
						gridHtml += getRoleTypeHtml(element);
					});
					$('#roleType').append(gridHtml);
					
				}
			},
			error : function() {
				
			}
		}	
	);
}
function showTeacherAssessList() {
	$('#proTeacher_list').html('');
	$
			.ajax( {
				url : pathHeader + '/sys/queryRoleList.do',
				type : "POST",
				cache : "false",
				async : "true",
				dataType : "json",
				data:{onlyManager :false},
				success : function(data) {
					if (data.success) {
						var objList = data.rows;
						var gridHtml = "";
						$.each(objList, function(index, element) {
							gridHtml += getTdHtml(element);
						});
						$('#proTeacher_list').append(gridHtml);
					} else {
						gridHtml = "<tr><td align='center' colspan='3'>暂无查询结果！</td></tr>";
						$('#proTeacher_list').append(gridHtml);
					}
				},
				error : function() {
					gridHtml = "<tr><td align='center' colspan='3'>暂无查询结果！</td></tr>";
					$('#proTeacher_list').append(gridHtml);
				}
			});
}
function getRoleTypeHtml(obj) {
	var optionHtml = "<option value=" + obj.roleType + ">" + obj.roleTypeName
	 + "</option>";
	return optionHtml;
}
function getTdHtml(obj) {
	var gridHtml = "<tr>";
	gridHtml += "<td>" + obj.roleName + "</td>";
	gridHtml += "<td>" + obj.roleTypeName + "</td>";
	gridHtml += "<td>" + (obj.createByName==null?'':obj.createByName) + "</td>";
	gridHtml += "<td>" + (obj.createUserProvince==null?'':obj.createUserProvince)
	+(obj.createUserCity==null?'':'-'+obj.createUserCity)
	+(obj.createUserDistrict==null?'':'-'+obj.createUserDistrict)
	+(obj.createUserSchool==null?'':'-'+obj.createUserSchool)+ "</td>";
	gridHtml += "<td>" + (obj.status.toString() == "1" ? "启用" : "禁用") + "</td>";
	if (obj.status == "1") {
		if(obj.id == obj.roleType && roleTypeId != '1'){
			gridHtml += "<td>&nbsp;&nbsp;<a style='color:#056DAE' href='"+pathHeader+"/sys/toViewRoleInfoPage.htm?click=1&id="+obj.id+"&roleType="+obj.roleType+"'>查看角色权限</a></td>";
		}else{
			gridHtml += "<td><a onclick='setRoleStatus("+obj.id+",0)' style='cursor: pointer;color:#056DAE'>禁用</a>&nbsp;&nbsp;<a style='color:#056DAE' href='"+pathHeader+"/sys/toRoleInfoPage.htm?click=1&id="+obj.id+"&roleType="+obj.roleType+"'>编辑角色权限</a></td>";
		}
	} else {
		if(roleTypeId != '1' && obj.id == obj.roleType){
			gridHtml += "<td><a onclick='setRoleStatus("+obj.id+",1)' style='cursor: pointer;color:#056DAE'>启用</a>&nbsp;&nbsp;</td>";
		}else{
			gridHtml += "<td><a onclick='setRoleStatus("+obj.id+",1)' style='cursor: pointer;color:#056DAE'>启用</a>&nbsp;&nbsp;</td>";
		}
	}
	return gridHtml;
}

function setRoleStatus(id_, status_) {
	$.ajax( {
		url : pathHeader + '/sys/setRoleStauts.do',
		type : "POST",
		cache : "false",
		async : "true",
		dataType : "json",
		data : {
			id : id_,
			status : status_
		},
		success : function(data) {
			if (data.success) {
				window.location.href = pathHeader + "/sys/toRolePage.htm?click='toRolePage'";
			} else {
				jQuery.generalAlert("操作失败！");
			}
		},
		error : function() {
			jQuery.generalAlert("操作失败！");
		}
	});
}

function chk() {
	var roleType = $("#roleType").val(); //角色类型名称
	var roleName = $("#roleName").val(); //角色名称
	if (roleType == "") {
		$('#selectedError').html("请选择角色类型！");
		return false;
	}else if(roleName == ""){
		$('#CodeError').html("请填写角色名称！");
		return false;
	}else {
		$('#msg').html("")
	}
	
	return true;
}

function addRole() {
	var roleType = $("#roleType").val(); //角色类型名称
	var roleName = $("#roleName").val(); //角色名称
	if(chk()){
		
		$.ajax(
				{
					url : pathHeader + '/sys/addRole.do',
					type : "POST",
					cache : "false",
					async : "true",
					dataType : "json",
					data : {
						roleType : roleType,
						roleName : roleName
					},
					success : function(data) {
						if (data.success) {
							window.location.href = pathHeader + "/sys/toRolePage.htm?click=1";
						} else {
							jQuery.generalAlert("操作失败！");
						}
					},
					error : function() {
						jQuery.generalAlert("操作失败！");
					}
				}	
		);
	}
}