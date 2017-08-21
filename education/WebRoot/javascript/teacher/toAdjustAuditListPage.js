$(function() {
	
	//queryDic('adjust_type');
	SysCode.createSelect("TEACHER_STAFF", "adjustId", "<option value=''>请选择</option>");
	// 条件查询
	$("#select").click(function() {
		showAdjustList();
	});
	
	showAdjustList();
})

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
					$("#adjustId").append(
							"<option value='" + element.dictionaryId + "'>"
									+ element.dictionaryName + "</option>");
				});

			}
		}
	});
}


function showAdjustList() {
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
				url : pathHeader + '/teacher/teachermanage/queryAdjust.do',
				type : "POST",
				cache : "false",
				async : "true",
				dataType : "json",
				data : {
					realName : $('#realName').val(),
					idNumber : $('#idNumber').val(),
					sizePerPage : sizePerPage,
					pageIndex : pageIndex,
					adjustId : $('#adjustId').val(),
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
							showAdjustList();
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
	gridHtml += "<td>" + (obj.oldAdjustName=='请选择'?'':obj.oldAdjustName)+ "</td>";
	gridHtml += "<td>" + obj.newAdjustName + "</td>";
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
		if (obj.auditStatus.toString() == "11") {
			gridHtml += "<a href='#none' class='tablelink' onclick='openAdjust(\""+obj.teacherId+"\",\""+obj.id+"\",\""+obj.mobilizeMark+"\")'>审核</a>";
		}

		gridHtml += "</td>";
	}
	gridHtml += "</tr>";
	return gridHtml;
}

function openAdjust(teacherId,id,mark){
	$("#mark").html(mark);
	$(".tip0").fadeIn(200);//显示提示框
	$("#postPage").click(function() {
		setAdjust(teacherId,id);
	});
	$(".cancel").click(function() {
		$(".tip0").fadeOut(200);
	});
}

function setAdjust(teacherId,id) {
	
	var flag="0";
	$("input[name='audit']:checked").each(function() {
		flag = $(this).val();
	})
	if(teacherId==null || teacherId=='' || teacherId==undefined || id==null || id=='' || id==undefined){
		$(".tip01").fadeIn(200);//显示提示框
		$("#msgHtml").html("提交失败，教师信息错误！");
		$("#toPage").val("关闭");
		$(".sure1").click(function() {
			toPage(0);
		});
		return false;
	}
	$('#myModal').modal('show');
	var url = pathHeader + '/teacher/teachermanage/setAuditAdjust.do';
$.ajax( {
		url : url,
		data : {
			teacherId:teacherId,
			id:id,
			auditOption:$("#auditOption").val(),
			flag:flag
		},
		type : "POST",
		cache : false,
		async : true,
		dataType : "json",
		success : function(data) {
			if (data.success) {
				$(".tip01").fadeIn(200);
				$('#myModal').modal('hide');
				//调动成功页面跳转
		$("#msgHtml").html("提交成功！")
		$("#toPage").val("确定");
		$(".sure1").click(function() {
			toPage(1);
			$(".tip01").fadeOut(100);
		});
	} else {
		$(".tip01").fadeIn(200);//显示提示框
		$("#msgHtml").html("提交失败，请稍后再试！");
		$("#toPage").val("关闭");
		$(".sure1").click(function() {
			toPage(0);
		});
	}
},
error : function() {
	$(".tip01").fadeIn(200);
	$("#msgHtml").html("提交失败，请稍后再试！");
	$("#toPage").val("关闭");
	$(".sure1").click(function() {
		toPage(0);
	});
}

	});

}

function toPage(lx) {
	if (lx == 1) {
		window.location.href = pathHeader
				+ "/teacher/teachermanage/toAdjustAuditListPage.htm?click=1001&flag=Y";
	} else {
		$(".tip01").fadeOut(100);
	}
}