$(function() {
	SysCode.createSelect("SCHOOL_TYPE", "schoolTypeId", "<option value=''>请选择</option>");
	SysCode.createSelect("SCHOOL_NATURE", "schoolNatureId", "<option value=''>请选择</option>");
	showSchoolList();
	// 条件查询
	$("#select").click(function() {
		showSchoolList();
	});
});

function clearPCD() {
	$('#schoolProvinceId').val("");
	$('#schoolCityId').val("");
	$('#schoolDistrictId').val("");
	$('#tss').val("");
}

function showSchoolList() {
	$('#proTeacher_list').html('');
	var pageIndex = $("#pageIndex").val();
	var sizePerPage = $("#sizePerPage").val();
	$
			.ajax( {
				url : pathHeader + '/sys/querySysSchool.do',
				type : "POST",
				cache : "false",
				async : "true",
				dataType : "json",
				data : {
					schoolName : $('#schoolName').val(),
					schoolTypeId : $('#schoolTypeId').val(),
					schoolCode:$('#schoolCode').val(),
					sizePerPage : sizePerPage,
					pageIndex : pageIndex,
					schoolProvinceId : $('#schoolProvinceId').val(),
					schoolCityId : $('#schoolCityId').val(),
					schoolDistrictId : $('#schoolDistrictId').val()
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
						
						if(gridHtml==""){
							gridHtml = "<tr><td align='center' colspan='5'>暂无查询结果！</td></tr>";
							$('#proTeacher_list').append(gridHtml);
						}
						pagination(data, function() {
							showSchoolList();
						});
					} else {
						gridHtml = "<tr><td align='center' colspan='5'>暂无查询结果！</td></tr>";
						$('#proTeacher_list').append(gridHtml);
					}
				},
				error : function() {
					gridHtml = "<tr><td align='center' colspan='5'>暂无查询结果！</td></tr>";
					$('#proTeacher_list').append(gridHtml);
				}
			});
}

function getTdHtml(obj) {
	var gridHtml = "<tr>";
	gridHtml += "<td>" + obj.schoolName + "</td>";
	gridHtml += "<td>" + obj.schoolTypeName + "</td>";
	gridHtml += "<td>" + obj.schoolCode + "</td>";
	gridHtml += "<td>" + obj.schoolProvinceName + "&nbsp;&nbsp;"
			+ obj.schoolCityName + "&nbsp;&nbsp;" + obj.schoolDistrictName
			+ "</td>";
	gridHtml += "<td>";
	//if (judgeAuthority("system_005_select")) {
		gridHtml += "<a href='" + pathHeader
				+ "/sys/querySchoolInfo.htm?click=2&id=" + obj.schoolId
				+ "' style='cursor: pointer;'>查看</a>&nbsp;&nbsp";
	//}
	//if (judgeAuthority("system_005_update")) {
		gridHtml += "<a href='" + pathHeader
				+ "/sys/modifySchoolInfo.htm?click=2&id=" + obj.schoolId
				+ "' style='cursor: pointer;'>编辑</a>&nbsp;&nbsp";
	//}
	//if (judgeAuthority("system_005_delete")) {
		gridHtml += "<a onclick='del("+ obj.schoolId+")' style='cursor: pointer;'>删除</a>&nbsp;&nbsp";
	//}
	gridHtml += "</td>";
	gridHtml += "</tr>";
	return gridHtml;
}

function del(id) {
	$("#toPage").css("display","");
	$("#cancel").val("取消");
	$('#msgHtml').html("确定要删除此条记录吗？");

	$("#toPage").click(function() {
		deleteSchool(id);
	});
	$("#cancel").click(function() {
		close();
	});

	$(".tip").fadeIn(200);
}

function close() {
	$(".tip").fadeOut(200);
}

function toPage() {
	window.location.href = pathHeader + "/sys/toSetSchoolPage.htm?click=2";
}

function deleteSchool(id) {
	$.ajax( {
		url : pathHeader + '/sys/deleteSchool.do',
		type : "POST",
		cache : "false",
		async : "true",
		dataType : "json",
		data : {
			schoolId : id
		},
		success : function(data) {
			if (data.success) {
				toPage();
			} else {
				
				if(data.flag=="-1"){
					$('#msgHtml').html("删除失败，该学校已经被引用！");
					
				}else{
					$('#msgHtml').html("删除失败！");
				}
				$("#toPage").css("display","none");
				$("#cancel").val("关闭");
				$(".tip").fadeIn(200);
			}
		},
		error : function() {
			toPage();
		}
	});

}

//导出学校
function exportSysSchoolToExcel() {
	console.log($('#schoolDistrictId').val());
	var pageIndex = $("#pageIndex").val();
	var sizePerPage = $("#sizePerPage").val();
	$("#downIframe", document.body).attr(
			"src",
			pathHeader + "/sys/exportSysSchoolToExcel.do?"
				+ "schoolName=" + $('#schoolName').val()
				+ "&schoolTypeId="+$('#schoolTypeId').val()
				+ "&schoolCode="+$('#schoolCode').val()
				+"&sizePerPage="+sizePerPage
				+"&pageIndex="+pageIndex
				+"&schoolProvinceId="+$('#schoolProvinceId').val()
				+"&schoolCityId="+$('#schoolCityId').val()
				+"&schoolDistrictId="+$('#schoolDistrictId').val());
}

