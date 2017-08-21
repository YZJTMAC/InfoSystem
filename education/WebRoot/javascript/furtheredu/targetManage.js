$(function() {
	initAutoComplete();

});

function clearPCD() {
	$('#schoolProvinceId').val("");
	$('#schoolCityId').val("");
	$('#schoolDistrictId').val("");
	$('#schoolId2').val("");
	$('#tss').val("");
	$('#tss1').val("");
}

/**
 * 初始化
 */
function initAutoComplete() {
	showInfoList();

	$("#pageSize").change(function() {
		showInfoList();
	});

	$(".click").click(function() {
		$('#year').val("");
		$('#classPeriod').val("");
		$('#classScore').val("");
		$('#targetId').val("0");
		openDiv();
	});
	$("#toCancel").click(function() {
		close();
	});
	$("#toPage").click(function() {
		close();
	});
}

function queryTargetInfo(id) {
	$(".tip").fadeIn(200);
	var f = "—";
	$
			.ajax( {
				type : "POST",
				url : pathHeader + "/furtheredu/edutarget/findTargetInfo.do",
				data : {
					id : id
				},
				async : true,
				success : function(msg) {
					if (msg.success) {
						var obj = msg.obj;
						$('#year').val(obj.year);

						$('#classPeriod').val(obj.classPeriod);
						$('#classScore').val(obj.classScore);
						$('#targetId').val(obj.id);

						$('#schoolProvinceId').val(obj.provinceId);
						$('#schoolCityId').val(obj.cityId);
						$('#schoolDistrictId').val(obj.districtId);
						$('#schoolId2').val(obj.schoolId);
						$('#tss1')
								.val(
										obj.provinceName
												+ (obj.cityName != null
														&& obj.cityName != '' ? f
														+ obj.cityName
														+ (obj.districtName != null
																&& obj.districtName != '' ? f
																+ obj.districtName
																+ (obj.schoolName != null
																		&& obj.schoolName != '' ? f
																		+ obj.schoolName
																		: "")
																: "")
														: ""));

						$("#yearStr").val($('#year').val());
						$("#cityStr").val($('#tss1').val());

						openDiv();
					} else {

					}
				},
				error : function() {
				}
			});
}

function updateA(data) {
	$.ajax( {
		type : "POST",
		url : pathHeader + "/furtheredu/edutarget/updateTarget.do",
		data : {
			data : $.toJSON(data)
		},
		async : true,
		success : function(msg) {
			if (msg.success) {
				$('#msgHtml').html("修改成功！");
				$("#toPage").html("<input name=\"\" onclick='toPage();'  type=\"button\" class=\"sure1\" value=\"确定\" />");
				$(".tip0").fadeIn(200);
			} else {
				if (msg.flag == "-1") {
					$('#msgHtml').html(
							"修改失败，已经存在" + $user.year + $user.provinceName
									+ $user.cityName + $user.districtName
									+ $user.schoolName + "的年度考核信息！");
				} else {
					$('#msgHtml').html("修改失败，请重试！");
				}
				$("#toPage").html("<input name=\"\" onclick='close();'  type=\"button\" class=\"sure1\" value=\"确定\" />");
				$(".tip0").fadeIn(200);

			}
		},
		error : function() {
			$('#msgHtml').html("修改失败，请重试！");
			$("#toPage").html("<input name=\"\" onclick='close();'  type=\"button\" class=\"sure1\" value=\"确定\" />");
			$(".tip0").fadeIn(200);
		}
	});
}

function checkData() {
	if ($('#year').val == '') {
		$('#errorMsg').html("请选择年份！");
		return false;
	} else {
		$('#errorMsg').html("");
	}
	if ($('#schoolProvinceId').val() == '' || $('#tss1').val() == '') {
		$('#errorMsg').html("请选择考核地区！");
		return false;
	} else {
		$('#errorMsg').html("");
	}
//	if ($('#classPeriod').val() == '') {
//		$('#errorMsg').html("学时不能为空！");
//		return false;
//	} else {
//		$('#errorMsg').html("");
//	}
//	if (!BasicValidate.isNumber($('#classPeriod').val())) {
//		$('#errorMsg').html("学时只能为数字！");
//		return false;
//	} else {
//		$('#errorMsg').html("");
//	}
	if ($('#classScore').val() == '') {
		$('#errorMsg').html("学分不能为空！");
		return false;
	} else {
		$('#errorMsg').html("");
	}
	if (!BasicValidate.isNumber($('#classScore').val())) {
		$('#errorMsg').html("学分只能为数字！");
		return false;
	} else {
		$('#errorMsg').html("");
	}

	return true;
}

function saveA() {
	if (checkData()) {
		var povinceName = "";
		var cityName = "";
		var districtName = "";
		var schoolName = "";
		var newTss = $("#tss1").val().split('—');
		for ( var i = 0; i < newTss.length; i++) {
			if (i == 0) {
				povinceName = newTss[0];
			} else if (i == 1) {
				cityName = newTss[1];
			} else if (i == 2) {
				districtName = newTss[2];
			} else if (i == 3) {
				schoolName = newTss[3];
			}
		}

		//地区名称和ID同步
		if (povinceName == "") {
			$('#schoolProvinceId').val("");
		}
		if (cityName == "") {
			$('#schoolCityId').val("");
		}
		if (districtName == "") {
			$('#schoolDistrictId').val("");
		}
		if (schoolName == "") {
			$('#schoolId2').val("");
		}

		var type = 0;

		//如果年度或者地区发生变化，则更新时要检查是否已经存在信息
		if ($('#yearStr').val() != $('#year').val()
				|| $('#cityStr').val() != $('#tss1').val()) {
			type = 1;
		}

		$user = {
			year : $('#year').val(),
			classPeriod : $('#classPeriod').val(),
			classScore : $('#classScore').val(),
			id : $('#targetId').val(),
			provinceName : povinceName,
			cityName : cityName,
			districtName : districtName,
			schoolName : schoolName,
			provinceId : $('#schoolProvinceId').val(),
			cityId : $('#schoolCityId').val(),
			districtId : $('#schoolDistrictId').val(),
			schoolId : $('#schoolId2').val(),
			status : 1,
			type : type
		}

		if ($user.id != 0 && $user.id != '') {
			updateA($user);
			return;
		}

		$.ajax( {
			type : "POST",
			url : pathHeader + "/furtheredu/edutarget/saveTarget.do",
			data : {
				data : $.toJSON($user)
			},
			async : true,
			success : function(msg) {
				if (msg.success) {
					$('#msgHtml').html("保存成功！");
					$("#toPage").html("<input name=\"\" onclick='toPage();'  type=\"button\" class=\"sure1\" value=\"确定\" />");
					$(".tip0").fadeIn(200);
				} else {
					if (msg.flag == "-1") {
						$('#msgHtml').html(
								"保存失败，已经存在" + $user.year + $user.provinceName
										+ $user.cityName + $user.districtName
										+ $user.schoolName + "的年度考核信息！");
					} else {
						$('#msgHtml').html("保存失败，请重试！");
					}
					$("#toPage").html("<input name=\"\" onclick='close();'  type=\"button\" class=\"sure1\" value=\"确定\" />");
					$(".tip0").fadeIn(200);

				}
			},
			error : function() {
				$('#msgHtml').html("保存失败，请重试！");
				$("#toPage").click(function() {
					close();
				});
				$(".tip0").fadeIn(200);
			}
		});
	}
}

function close() {
	$("#toCancel").css("display", "none");
	$(".tip0").fadeOut(200);
}
function toPage() {
	window.location.href = pathHeader
			+ "/furtheredu/edutarget/targetManagePage.htm?click=1";
}

/**
 * 删除教师
 */
function deleteTarget(data) {
	$('#msgHtml').html("确定删除吗？");
	$("#toCancel").css("display", "");
	$("#toPage").html("<input name=\"\" onclick='sureDel("+data+")'  type=\"button\" class=\"sure1\" value=\"确定\" />");
	$("#toCancel").click(function() {
		close();
	});
	$(".tip0").fadeIn(200);

}

function sureDel(data) {
	$.ajax( {
		url : pathHeader + "/furtheredu/edutarget/deleteTarget.do",
		type : "POST",
		cache : "false",
		async : "true",
		dataType : "json",
		data : {
			id : data
		},
		success : function(data) {
			if (data.success) {
				$("#toCancel").css("display", "none");
				$('#msgHtml').html("删除成功！");
				$("#toPage").html("<input name=\"\" onclick='toPage();'  type=\"button\" class=\"sure1\" value=\"确定\" />");
				$(".tip0").fadeIn(200);
			} else {
				$("#toCancel").css("display", "none");
				$('#msgHtml').html("删除失败，请重试！");
				$("#toPage").html("<input name=\"\" onclick='close();'  type=\"button\" class=\"sure1\" value=\"确定\" />");
				$(".tip0").fadeIn(200);
			}
		},
		error : function() {
			$("#toCancel").css("display", "none");
			$('#msgHtml').html("删除失败，请重试！");
			$("#toPage").html("<input name=\"\" onclick='toPage();'  type=\"button\" class=\"sure1\" value=\"确定\" />");
			$(".tip0").fadeIn(200);
		}
	});
}

function showInfoList() {
	$('#targetList').html("");
	var sizePerPage = $("#pageSize").val();
	var pageIndex = $("#pageIndex").val();

	$.ajax( {
		url : pathHeader + "/furtheredu/edutarget/queryTargetList.do",
		type : "POST",
		cache : "false",
		async : "true",
		dataType : "json",
		data : {
			year : $('#queryYear').val(),
			sizePerPage : sizePerPage,
			pageIndex : pageIndex,
			provinceId : $('#schoolProvinceId').val(),
			cityId : $('#schoolCityId').val(),
			districtId : $('#schoolDistrictId').val(),
			schoolId : $('#schoolId2').val()
		},
		success : function(data) {
			if (data.success) {
				var indexFlag = data.startIndex;
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList, function(index, element) {
					indexFlag++;
					gridHtml += getTdEHtml(element, indexFlag);
				});
				$('#targetList').append(gridHtml);
				$('#totleCount').text(data.total);
				pagination(data, function() {
					showInfoList();
				});
			} else {
				$('#totleCount').text(0);
				$('#targetList').html("<tr><td colspan='12'>无查询记录</td></tr>");
			}
		},
		error : function() {
		}
	});
}

function getTdEHtml(obj, index) {
	var f = "—";
	var dq = obj.provinceName
			+ (obj.cityName != null && obj.cityName != '' ? f
					+ obj.cityName
					+ (obj.districtName != null && obj.districtName != '' ? f
							+ obj.districtName
							+ (obj.schoolName != null && obj.schoolName != '' ? f
									+ obj.schoolName
									: "")
							: "")
					: "");
	var gridHtml = "<tr>";
	gridHtml += "<td>" + obj.year + "</td>";
	gridHtml += "<td>" + dq + "</td>";
	gridHtml += "<td>&nbsp;" + obj.classScore
			+ "学分</td>";
	gridHtml += "<td><a href='###' onclick='queryTargetInfo(" + obj.id
			+ ")' class='tablelink'>修改</a>&nbsp;";
	gridHtml += "&nbsp;<a href='###' onclick='deleteTarget(" + obj.id
			+ ")' class='tablelink'>删除</a>";
	gridHtml += "&nbsp;&nbsp;<a href='###' onclick='info(" + obj.year + ","
			+ obj.provinceId + "," + obj.cityId + "," + obj.districtId + ","
			+ obj.schoolId + ")' class='tablelink'>教师年度考核情况</a></td>";
	gridHtml += "</tr>";
	return gridHtml;

}

/**
 * 详情 furtheredu/edumanage/eduManageGroupPage.htm
 */
function info(year, provinceId, cityId, districtId, schoolId) {
	var openUrl
= pathHeader + "/furtheredu/edumanage/eduManageGroupPage.htm?provinceId="+provinceId+"&cityId="+cityId+"&districtId="+districtId+"&schoolId="+schoolId+"&click=2&year=" +　year;
	showWindow(openUrl);
}

function showWindow(url) {
	window.location.href = url;
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

function openDiv() {
	$('#msgHtml').html("");
	$('#flag').val("1");
	$(".tip").fadeIn(200);
	$(".tiptop a").click(function() {
		$('#flag').val("0");
		$(".tip").fadeOut(200);
	});
	$(".cancel").click(function() {
		$('#flag').val("0");
		$(".tip").fadeOut(200);
	});
	$(".sure").click(function() {
		 saveA();
	});
	$(".select2").uedSelect( {
		width : 100
	});
}