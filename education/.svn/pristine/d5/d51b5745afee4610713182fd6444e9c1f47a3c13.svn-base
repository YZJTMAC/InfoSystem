$(function() {
	showTeacherChangeList();
	
	// 条件查询
	$("#select").click(function() {
		showTeacherChangeList();
	});
});

function showTeacherChangeList() {
	$('#proTeacher_list').html('');
	$
			.ajax( {
				url : pathHeader + '/teacher/teachermanage/queryTeacherChangeList.do',
				type : "POST",
				cache : "false",
				async : "true",
				dataType : "json",
				data : {
					changeType : $("#changeType").val(),
					auditStatus : $("#auditStatus").val(),
					auditCreateDate : $("#auditCreateDate").val()
				},
				success : function(data) {
					if (data.success) {
						var objList = data.rows;
						var gridHtml = "";
						$.each(objList, function(index, element) {
							gridHtml += getTdHtml(element);
						});
						$('#proTeacher_list').append(gridHtml);
					} else {
						gridHtml = "<tr><td align='center' colspan='6'>暂无查询结果！</td></tr>";
						$('#proTeacher_list').append(gridHtml);
					}
				},
				error : function() {
					gridHtml = "<tr><td align='center' colspan='6'>暂无查询结果！</td></tr>";
					$('#proTeacher_list').append(gridHtml);
				}
			});
}

function getTdHtml(obj) {
	var gridHtml = "<tr>";
	gridHtml += "<td>" + (obj.auditCreateBy==null?"":obj.auditCreateBy) + "</td>";
	gridHtml += "<td>" + new Date(obj.auditCreateDate).format("yyyy-MM-dd") + "</td>";
	gridHtml += "<td>" + (obj.dictionaryName==null?"":obj.dictionaryName) + "</td>";
	if (obj.auditStatus == 11) {
		gridHtml += "<td><i>未审核</i></td>";
	} else if (obj.auditStatus == 12) {
		gridHtml += "<td>审核未通过</td>";
	} else if (obj.auditStatus == 13) {
		gridHtml += "<td>审核通过</td>";
	} else if (obj.auditStatus == "15") {
		gridHtml += "自动审核通过";
	} 
	gridHtml += "<td>" +  new Date(obj.auditUpdateDate).format("yyyy-MM-dd") + "</td>";
	gridHtml += "<td><a href=\"" + pathHeader
			+ "/teacher/teachermanage/changeInfoPage.htm?auditId=" + obj.id + "&click=100\">查看详情</a></td>";
	return gridHtml;
}
