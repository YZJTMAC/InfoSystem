$(function() {
	if (judgeAuthority("teacher_007_add")) {
		$('#action').html(
						"<li><a href=\""
								+ pathHeader
								+ "/teacher/teachermanage/toMobilizeAddPage.htm?click=3\">发起调动</a></li>"+$('#action').html());
	}

	showMobilizeList();

	// 条件查询
	$("#select").click(function() {
		showMobilizeList();
	});
})

function clearPCD() {
	$('#schoolProvinceId').val("");
	$('#schoolCityId').val("");
	$('#schoolDistrictId').val("");
	$('#schoolId2').val("");
	$('#tss').val("");
}

function lastForSure() {
	var str = "";
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

	$('#tss').val(str);

	clear();
}

function showMobilizeList() {
	$('#proTeacher_list').html('');
	var pageIndex = $("#pageIndex").val();
	var sizePerPage = $("#sizePerPage").val();
	$
			.ajax( {
				url : pathHeader + '/teacher/teachermanage/queryMobilize.do',
				type : "POST",
				cache : "false",
				async : "true",
				dataType : "json",
				data : {
					realName : $('#realName').val(),
					idNumber : $('#idNumber').val(),
					sizePerPage : sizePerPage,
					pageIndex : pageIndex,
					pastProvinceId : $('#schoolProvinceId').val(),
					pastCityId : $('#schoolCityId').val(),
					pastDistrictId : $('#schoolDistrictId').val(),
					changeType : $('#changeType').val(),
					pastSchoolId : $('#schoolId2').val()
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
						if (gridHtml == "") {
							gridHtml = "<tr><td align='center' colspan='9'>暂无查询结果！</td></tr>";
							$('#proTeacher_list').append(gridHtml);
						}
						pagination(data, function() {
							showMobilizeList();
						});
					} else {
						gridHtml = "<tr><td align='center' colspan='9'>暂无查询结果！</td></tr>";
						$('#proTeacher_list').append(gridHtml);
					}
				},
				error : function() {
					gridHtml = "<tr><td align='center' colspan='9'>暂无查询结果！</td></tr>";
					$('#proTeacher_list').append(gridHtml);
				}
			});
}

function getTdHtml(obj) {
	var gridHtml = "<tr>";
	gridHtml += "<td>" + obj.realName + "</td>";
	gridHtml += "<td>" + obj.idNumber + "</td>";
	gridHtml += "<td>" + obj.sex + "</td>";
	gridHtml += "<td>" + obj.pastProvinceName + obj.pastCityName
			+ obj.pastDistrictName + obj.pastSchoolName + "</td>";
	gridHtml += "<td>" + obj.newProvinceName + obj.newCityName
			+ obj.newDistrictName + obj.newSchoolName + "</td>";
	gridHtml += "<td>" + obj.auditCreateBy + "</td>";
	gridHtml += "<td>" + new Date(obj.auditCreateDate).format("yyyy-MM-dd");
	+"</td>";
	gridHtml += "<td>";
	if (obj.auditStatus == "15") {
		gridHtml += "自动审核通过";
	} else if (obj.auditStatus == "13") {
		gridHtml += "通过";
	} else if (obj.auditStatus == "12") {
		gridHtml += "未通过";
	} else if (obj.auditStatus == "11") {
		gridHtml += "<font style='color: red;'>未审核</font>";
	}
	gridHtml += "</td>";
	gridHtml += "<td>";
	if (judgeAuthority("teacher_007_select")) {
		var clickStr = "";
		if(flag == 15) {
			clickStr = "&click=15";
		} else {
			clickStr = "&click=3";
		}
		gridHtml += "<a href='"
				+ pathHeader
				+ "/teacher/teachermanage/toMobilizeInfo.htm?"+clickStr+"&teacherId="
				+ obj.teacherId + "&oldVersion=" + obj.oldVersion
				+ "&newVersion=" + obj.newVersion + "&id=" + obj.id
				+ "' style='cursor: pointer;'>详情</a>";
	}

	//判断如果当前登录人是否为审核角色
//	if (audit == 1) {
//		//判断是否有权限 并且为未审核状态
//		if (judgeAuthority("teacher_007_through")
//				&& obj.auditStatus.toString() == "11") {
//			gridHtml += "<a href='" + pathHeader
//					+ "/teacher/teachermanage/toMobilizeAudit.htm?click=3&id="
//					+ obj.id + "&teacherId=" + obj.teacherId + "&oldVersion="
//					+ obj.oldVersion + "&newVersion=" + obj.newVersion
//					+ "&newProvinceId=" + obj.newProvinceId
//					+ "&newProvinceName="
//					+ encodeURIComponent(encodeURI(obj.newProvinceName))
//					+ "&newCityId=" + obj.newCityId + "&newCityName="
//					+ encodeURIComponent(encodeURI(obj.newCityName))
//					+ "&newDistrictId=" + obj.newDistrictId
//					+ "&newDistrictName="
//					+ encodeURIComponent(encodeURI(obj.newDistrictName))
//					+ "&newSchoolId=" + obj.newSchoolId + "&newSchoolName="
//					+ encodeURIComponent(encodeURI(obj.newSchoolName))
//					+ "' style='cursor: pointer;'>审核</a>";
//		}
//	}

	gridHtml += "</td>";
	gridHtml += "</tr>";
	return gridHtml;
}