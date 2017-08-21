$(function() {
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

	showMobilizeList();
	
	clear();
}

function showMobilizeList() {
	$('#proTeacher_list').html('');
	var pageIndex = $("#pageIndex").val();
	var sizePerPage = $("#sizePerPage").val();
	var auditStatus = "0";
	if (audit == 'N') {
		auditStatus = "11";
	} else {
		auditStatus = "12,13,15"
	}
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
					pastSchoolId : $('#schoolId2').val(),
					changeType : $('#changeType').val(),
					auditStatus : auditStatus
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
							gridHtml = "<tr><td align='center' colspan='8'>暂无查询结果！</td></tr>";
							$('#proTeacher_list').append(gridHtml);
						}
						pagination(data, function() {
							showMobilizeList();
						});
					} else {
						gridHtml = "<tr><td align='center' colspan='8'>暂无查询结果！</td></tr>";
						$('#proTeacher_list').append(gridHtml);
					}
				},
				error : function() {
					gridHtml = "<tr><td align='center' colspan='8'>暂无查询结果！</td></tr>";
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
	if (audit == 'Y') {
		gridHtml += "<td>";
		if (obj.auditStatus == "15") {
			gridHtml += "自动审核通过";
		} else if (obj.auditStatus == "13") {
			gridHtml += "审核通过";
		} else if (obj.auditStatus == "12") {
			gridHtml += "审核不通过";
		}
		gridHtml += "</td>";
	} else if (audit == 'N') {
		gridHtml += "<td>";
		//判断是否有权限 并且为未审核状态 judgeAuthority("teacher_007_through")&&
		if (obj.auditStatus.toString() == "11") {
			var clickStr = "";
			if(flag == 1006) {
				clickStr = "&click=1006";
			} else {
				clickStr = "&click=1000";
			}
			gridHtml += "<a class='tablelink' href='" + pathHeader
					+ "/teacher/teachermanage/toMobilizeAudit.htm?id="
					+ obj.id + "&teacherId=" + obj.teacherId + "&oldVersion="
					+ obj.oldVersion + "&newVersion=" + obj.newVersion
					+ "&newProvinceId=" + obj.newProvinceId
					+ "&newProvinceName="
					+ encodeURIComponent(encodeURI(obj.newProvinceName))
					+ "&newCityId=" + obj.newCityId + "&newCityName="
					+ encodeURIComponent(encodeURI(obj.newCityName))
					+ "&newDistrictId=" + obj.newDistrictId
					+ "&newDistrictName="
					+ encodeURIComponent(encodeURI(obj.newDistrictName))
					+ "&newSchoolId=" + obj.newSchoolId + "&newSchoolName="
					+ encodeURIComponent(encodeURI(obj.newSchoolName)) + clickStr
					+ "' style='cursor: pointer;'>审核</a>";
		}

		gridHtml += "</td>";
	}
	gridHtml += "</tr>";
	return gridHtml;
}