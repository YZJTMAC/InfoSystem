$(function() {
	showTeacherMobilizeList();

	// 条件查询
	$("#select").click(function() {
		showTeacherMobilizeList();
	});
})

function showTeacherMobilizeList() {
	$('#proTeacher_list').html('');
	var pageIndex = $("#pageIndex").val();
	var sizePerPage = $("#sizePerPage").val();
	$
			.ajax( {
				url : pathHeader + '/teacher/teachermanage/queryTeacherMobilize.do',
				type : "POST",
				cache : "false",
				async : "true",
				dataType : "json",
				data : {
					startDate : $('#startDate').val(),
					endDate : $('#endDate').val(),
					sizePerPage : sizePerPage,
					pageIndex : pageIndex,
					auditStautsStr : $('#auditStauts').val()
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
							showTeacherMobilizeList();
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
		gridHtml += "未审核";
	}
	gridHtml += "</td>";
	gridHtml += "<td>";

	gridHtml += "<a href='" + pathHeader
			+ "/teacher/teachermanage/toTeacherMobilizeInfo.htm?click=1900&teacherId="
			+ obj.teacherId + "&oldVersion=" + obj.oldVersion + "&newVersion="
			+ obj.newVersion + "&id=" + obj.id
			+ "' style='cursor: pointer;'>详情</a>";

	gridHtml += "</td>";
	gridHtml += "</tr>";
	return gridHtml;
}