$(function() {
	getRoleList();
	showManagesList();
	queryDic('project_subject');
	$('#action')
			.html(
					"<a href=\"#none\" onclick='openCreateManages();' class=\"huibtn_a\" style=\"margin-left: 6px\">生成</a>&nbsp;");

	// 条件查询
	$("#select").click(function() {
		showManagesList();
	});
})

function openCreateManages() {
	$('#flag').val("1");
	$(".tip1").fadeIn(200);
	$(".tiptop a").click(function() {
		$('#flag').val("0");
		$('#createRoleId').val("");
		$(".tip1").fadeOut(200);
	});
	$(".cancel1").click(function() {
		$('#flag').val("0");
		$('#createRoleId').val("");
		$(".tip1").fadeOut(200);
	});
	$(".sure1").click(function() {
		createManges();
	});

}

/**
 * 选择角色
 */
function changeRoleId() {
	var role = $("#createRoleId").val();
	$('#msgHtmlC').html("");
	//专家
	if (role == "20") {
		$('#adminrole').css("display", "none");
		$('#sysrole').css("display", "");
		$('#expertrole').css("display", "");
		$('#sl').css("display", "");
	} else if (role == "1") {
		$('#adminrole').css("display", "");
		$('#sysrole').css("display", "");
		$('#expertrole').css("display", "none");
		$('#sl').css("display", "none");
	} else if (role == "0" || role == "6" || role == "7"|| role == "8"|| role == "9"|| role == "10") {
		$('#adminrole').css("display", "none");
		$('#sysrole').css("display", "");
		$('#expertrole').css("display", "none");
		$('#sl').css("display", "");
	}
}

function lastForSure() {
	var str = "";
	$("#schoolProvinceId").val("");
	$("#schoolCityId").val("");
	$("#schoolDistrictId").val("");
	$("#schoolId2").val("");
	var tempArray = chilkQueryConditionArray;
	$(tempArray).each(function(index, element) {
		if (element != null && element.length > 0) {
			var temp = element.split("_");
			if (temp[1] == "provinceId") {
				$("#schoolProvinceId").val(temp[0]);
				str = temp[2];
			} else if (temp[1] == "cityId") {
				$("#schoolCityId").val(temp[0]);
				str += "—" + temp[2];
			} else if (temp[1] == "districtId") {
				$("#schoolDistrictId").val(temp[0]);
				str += "—" + temp[2];
			} else if (temp[1] == "schoolId") {
				if (temp[0] != undefined) {
					$("#schoolId2").val(temp[0]);
				}
				str += "—" + temp[2];
			}

		}
	})

	if ($('#flag').val() == "0") {
		$('#tss').val(str);
	} else {
		$('#tss1').val(str);
	}

	clear();
}

/**
 * 查询字典表
 */
function queryDic(type) {
	var url = pathHeader + "/sys/queryDicByType.do";
	$.ajax( {
		url : url,
		data : {
			dicType : type
		},
		type : "post",
		async : false,
		success : function(data) {
			if (data.rows.length > 0) {
				var objList = data.rows;

				$.each(objList, function(index, element) {
					$("#subjectId").append(
							"<option value='" + element.dictionaryId + "'>"
									+ element.dictionaryName + "</option>");
					$("#createSubjectId").append(
							"<option value='" + element.dictionaryId + "'>"
									+ element.dictionaryName + "</option>");
				});

			}
		}
	});
}

function clearPCD() {
	$('#schoolProvinceId').val("");
	$('#schoolCityId').val("");
	$('#schoolDistrictId').val("");
	$('#tss').val("");
	$('#tss1').val("");
}

function showManagesList() {
	$('#proTeacher_list').html('');
	var pageIndex = $("#pageIndex").val();
	var sizePerPage = $("#sizePerPage").val();
	$
			.ajax( {
				url : pathHeader + '/person/queryManages.do',
				type : "POST",
				cache : "false",
				async : "true",
				dataType : "json",
				data : {
					loginAccount : $('#loginAccount').val(),
					roleId : $('#roleId').val(),
					sizePerPage : sizePerPage,
					pageIndex : pageIndex,
					userProvinceId : $('#schoolProvinceId').val(),
					userCityId : $('#schoolCityId').val(),
					userDistrictId : $('#schoolDistrictId').val(),
					subjectId : $('#subjectId').val(),
					schoolId : $('#schoolId2').val()
				},
				success : function(data) {
					if (data.success) {
						var objList = data.rows;
						var gridHtml = "";
						$("#counts").html(data.total);
						$.each(objList, function(index, element) {
							gridHtml += getTdHtml(element);
						});

						$('#proTeacher_list').append(gridHtml);
						pagination(data, function() {
							showManagesList();
						});
					} else {
						gridHtml = "<tr><td align='center' colspan='10'>暂无查询结果！</td></tr>";
						$('#proTeacher_list').append(gridHtml);
					}
				},
				error : function() {
					gridHtml = "<tr><td align='center' colspan='10'>暂无查询结果！</td></tr>";
					$('#proTeacher_list').append(gridHtml);
				}
			});
}

function getTdHtml(obj) {
	var createDate =obj.createDate!=null? new Date(obj.createDate).format("yyyy-MM-dd HH:mm:ss"):"";
	var gridHtml = "<tr>";
	gridHtml += "<td>" + obj.realName + "</td>";
	gridHtml += "<td>" + obj.loginAccount + "</td>";
	gridHtml += "<td>" + obj.password + "</td>";
	gridHtml += "<td>" + obj.roleName + "</td>";
	gridHtml += "<td>" + obj.idNumber + "</td>";
	gridHtml += "<td>" + obj.userProvinceName + "</td>";
	gridHtml += "<td>" + obj.userCityName.replace("—", "");
	gridHtml += "</td>";
	gridHtml += "<td>" + obj.userDistrictName.replace("—", "");
	gridHtml += "</td>";
	gridHtml += "<td>" + obj.schoolName.replace("—", "");;
	gridHtml += "</td>";
	gridHtml += "<td>" + createDate;
	gridHtml += "</td>";
	gridHtml += "</tr>";
	return gridHtml;
}

function close() {
	$(".tip0").fadeOut(200);
}

function toPage() {
	window.location.href = pathHeader
			+ "/person/toCreateManagesPage.htm?click=555";
}

function createManges() {
	var flag = "";
	var createType="";
	var createRoleId = $('#createRoleId').val();
	if (createRoleId == "") {
		$('#msgHtmlC').html("请选择角色！");
		return false;
	} else {
		$('#msgHtmlC').html("");
	}

	if (createRoleId == "20") {//专家
		if ($('#createSubjectId').val() == "") {
			$('#msgHtmlC').html("请选择学科！");
			return false;
		} else {
			flag = "20";
			$('#msgHtmlC').html("");
		}
	} else if (createRoleId == "1") {//管理员
		if ($("#schoolProvinceId").val() == "") {
			$('#msgHtmlC').html("所属地区信息错误，请重新选择！");
			return false;
		} else {
			$('#msgHtmlC').html("");
		}

		if (!$('#fw0').attr("checked") && !$('#fw1').attr("checked")) {
			$('#msgHtmlC').html("请选择生成范围！");
			return false;
		} else {
			if($('#fw0').attr("checked") && $('#fw1').attr("checked")){
				createType="ALL";//全部生成
			}else if($('#fw0').attr("checked")){//生成当前所属地区的管理员
				createType="TOP";
			}else{//生成所有下级地区的管理员
				createType="DOWN";
			}
			
			$('#msgHtmlC').html("");
		}

		flag = "1";

	} else if (createRoleId == "0") {//系统管理员
		flag = "0";
	} else if (createRoleId == "6") {//承培机构管理员
		flag = "6";
	} else if (createRoleId == "7") {//实施机构管理员 省
		flag = "7";
	}
	else if (createRoleId == "8") {//实施机构管理员 市
		flag = "8";
	}
	else if (createRoleId == "9") {//实施机构管理员 区
		flag = "9";
	}
	else if (createRoleId == "10") {//实施机构管理员 校
		flag = "10";
	}
	if ($('#topStr').val() == "") {
		$('#msgHtmlC').html("用户名前辍不能为空！");
		return false;
	} else {
		$('#msgHtmlC').html("");
	}
	
	if (createRoleId!="1" && $('#createNum').val() == "") {
		$('#msgHtmlC').html("生成数量不能为空！");
		return false;
	} else {
		$('#msgHtmlC').html("");
	}
	if (createRoleId!="1" && !BasicValidate.isFullNumber($('#createNum').val())) {
		$('#msgHtmlC').html("生成数量只能为整数！");
		return false;
	} else {
		$('#msgHtmlC').html("");
	}
	
	var povinceName="";
	var cityName="";
	var districtName="";
	var schoolName="";
	var newTss=$("#tss1").val().split('—');
	for(var i=0;i<newTss.length;i++){
		if(i==0){
			povinceName=newTss[0];
		}else if(i==1){
			cityName=newTss[1];
		}else if(i==2){
			districtName=newTss[2];
		}else if(i==3){
			schoolName=newTss[3];
		}
	}
	$("#btn").attr('disabled', true);
	$.ajax( {
		url : pathHeader + '/person/createManages.do',
		type : "POST",
		cache : "false",
		async : "true",
		dataType : "json",
		data : {
			flag : flag,
			topStr : $('#topStr').val(),
			subjectId:$('#createSubjectId').val(),
			subjectName:getSelected("createSubjectId").text.replace("请选择...",""),
			createType:createType,
			schoolProvinceId:$('#schoolProvinceId').val(),
			schoolCityId:$('#schoolCityId').val(),
			schoolDistrictId:$('#schoolDistrictId').val(),
			schoolId:$('#schoolId2').val(),
			schoolProvinceName:povinceName,
			schoolCityName:cityName,
			schoolDistrictName:districtName,
			schoolName:schoolName,
			createNum:$('#createNum').val()
		},
		success : function(data) {
			if (data.success) {
				$('#msgHtml').html("生成成功,共生成"+data.counts+"条信息！");
				$("#toPage").click(function() {
					toPage();
				});
				$(".tip0").fadeIn(200);
			} else {
				if (data.flag == "-1") {//前台参数roleId为空
			$('#msgHtml').html("信息错误，请重试！");
		} else if (data.flag == "-2") {//生成失败
			$('#msgHtml').html("生成失败，请重试！");
		} else if (data.flag == "-3") {//生成帐号的信息不存在
			$('#msgHtml').html("生成帐号信息为空，请重试！");
		}else if (data.flag == "-4") {//学科信息错误
			$('#msgHtml').html("学科信息错误！");
		}else if (data.flag == "-5") {//不存在省份信息
			$('#msgHtml').html("生成失败，系统中不存在地区信息！");
		}else if (data.flag == "-6") {//地区信息为空
			$('#msgHtml').html("生成失败，当前登录人地区信息不符合生成该角色！");
		}else if (data.flag == "-7") {//地区信息为空
			$('#msgHtml').html("生成失败，当前登录人权限不能生成系统管理员帐号！");
		}else{
			$('#msgHtml').html("生成失败，请重试！");
		}

		$("#btn").attr('disabled', false);
		$("#toPage").click(function() {
			close();
		});
		$(".tip0").fadeIn(200);
	}
},
error : function() {
	$('#msgHtml').html("生成失败！");
	$("#btn").attr('disabled', false);
	$("#toPage").click(function() {
		close();
	});
	$(".tip0").fadeIn(200);
}
	});

}


function getRoleList() {
	$('#roleId').html('');
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
