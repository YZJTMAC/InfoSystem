$(function() {

	// 条件查询
	$("#select").click(function() {
		showMobilizeAddList();
	});
//	queryDic('adjust_type');
	// 教师编制
	SysCode.createSelect("TEACHER_STAFF", "adjustId", "<option value=''>请选择</option>");
})

function showMobilizeAddList() {
	if ($('#realName').val() == "" && $('#idNumber').val() == "") {
		$("#msg").html("请输入教师姓名或身份证号！");
		return false;
	} else {
		$("#msg").html("");
	}
	$('#proTeacher_list').html('');
	var pageIndex = $("#pageIndex").val();
	var sizePerPage = $("#sizePerPage").val();
	$
			.ajax( {
				url : pathHeader + '/teacher/teachermanage/queryCreateMobilize.do',
				type : "POST",
				cache : "false",
				async : "true",
				dataType : "json",
				data : {
					realName : $('#realName').val(),
					idNumber : $('#idNumber').val()
				},
				success : function(data) {
					if (data.success) {
						var objList = data.rows;
						var gridHtml = "";
						$.each(objList, function(index, element) {
							gridHtml += getTdHtml(element);
						});
						if (gridHtml.length == 0) {
							gridHtml = "<dl class=\"teacherdlxinxi\" style='text-align:center'>暂无查询结果！</dl>";
						}
						$('#proTeacher_list').append(gridHtml);

						$(".tiptop2 a").click(function() {
							$(".tip0").fadeOut(200);
						});

						$(".cancel").click(function() {
							$(".tip0").fadeOut(100);
						});

					} else {
						gridHtml = "<dl class=\"teacherdlxinxi\" style='text-align:center'>暂无查询结果！</dl>";
						$('#proTeacher_list').append(gridHtml);
					}
				},
				error : function() {
					gridHtml = "<dl class=\"teacherdlxinxi\" style='text-align:center'>暂无查询结果！</dl>";
					$('#proTeacher_list').append(gridHtml);
				}
			});
}

function getTdHtml(obj) {
	var gridHtml = "<dl class=\"teacherdlxinxi\"><dt style=\"height: 210px;\">";
//	gridHtml += "<img src=\"" + imageServer  
//			+ obj.userImageUrl + "\" title=\"头像11\" />";
	if( obj.userImageUrl == null || obj.userImageUrl == "" || obj.userImageUrl.length == 0){
		gridHtml += "<img src='"+ pathHeader+ "/images/u8_normal.jpg' style='width:120px;height:120px' title='头像120×120'>";
	} else {
		gridHtml += "<img src='"+ imageServer+ obj.userImageUrl +"' style='width:120px;height:120px' title='头像120×120'>";
	}
	gridHtml += "</dt><dd><span class=\"titlewidth\">姓名：</span><span>"
			+ obj.realName + "</span>";
	gridHtml += "</dd><dd>";
	gridHtml += "<span class=\"titlewidth\">身份证号：</span><span>" + obj.idNumber
			+ "</span>";
	gridHtml += "</dd><dd  style='width:410px'>";
	gridHtml += "<span class=\"titlewidth\">原地区：</span><span style='overflow: hidden;'>"
			+ obj.userProvinceName
			+ obj.userCityName
			+ obj.userDistrictName
			+ obj.schoolName + "</span>"
	gridHtml += "</dd><dd>";
	gridHtml += "<span class=\"titlewidth\" >教师资格证书号：</span><span>"
			+ obj.jobCertificateNum + "</span>";
	gridHtml += "</dd><dd>";
	gridHtml += "<span class=\"titlewidth\">(评)教师职称：</span><span>"
			+ obj.jobCommentPosition + "</span>";
	gridHtml += "</dd><dd>";
	gridHtml += "<span class=\"titlewidth\">(聘)教师职称：</span><span>"
			+ obj.jobRecruitmentPosition + "</span>";
	gridHtml += "</dd><dd>";
	gridHtml += "<span class=\"titlewidth\" >学校行政职务：</span><span>"
			+ obj.jobSchoolAdministrationOffice + "</span>";
	gridHtml += "</dd>";
	gridHtml += "<dd><span class=\"titlewidth\">任教学段/学科：</span><span>"
			+ obj.jobFormerTeachingSubject + "</span>";
	gridHtml += "</dd>";
	gridHtml += "<dd><span class=\"titlewidth\">是否为骨干教师：</span><span>"
			+ obj.jobCoreTeacher + "</span>";
	gridHtml += "</dd><dd>";
	gridHtml += "<span class=\"titlewidth\">是否为班主任：</span><span>"
			+ obj.jobWhetherTeacher + "</span>";
	gridHtml += "</dd><dd>";
	gridHtml += "<span class=\"titlewidth\">国培计划农村骨干教师：</span><span>"
			+ obj.jobCountyRuralTeacher + "</span>";
	gridHtml += "</dd><dd class=\"tohaid1\"><span></span></dd>";
	gridHtml += "<dd></dd>";
	gridHtml += "<dd class=\"tohaid1\">";
	gridHtml += "<table width=\"100%\"><tr><td align=\"left\">";
	gridHtml += "<div>";
	var str = (obj.userProvinceName + "—" + obj.userCityName + "—"
			+ obj.userDistrictName + "—" + obj.schoolName);

	gridHtml += "<input type=\"button\" onclick='addMobilize("
			+ obj.adjustId + ",\"" + obj.adjustName + "\"," + obj.id
			+ ");' class=\"btn click\" value=\"发起\" />";
	gridHtml += "</div></td></tr></table></dd></dl>";
	return gridHtml;
}

function addMobilize(adjustId, adjustName,teacherId) {
	$(".tip0").fadeIn(200);
	$("#oldAdjustName").html((adjustName=='请选择'?'':adjustName));

	// 创建编制调整
	
	$("#setMob").off().click(function() {
		setMobilize(adjustId, teacherId);
	});

}

function setMobilize(adjustId,teacherId) {
	if($('#adjustId').val()==''){
		$("#msgs").html("请选择目标编制！");
		return false;
	}else{
		$("#msgs").html("");
	}
	
	if($('#adjustId').val()==adjustId){
		$("#msgs").html("目标编制不能与当前编制相同！");
		return false;
	}else{
		$("#msgs").html("");
	}
	
	if($("#mobilizeMark").val()==""){
		$("#msgs").html("请填写编制调整说明！");
		return false;
	}else{
		$("#msgs").html("");
	}
	if(teacherId==null || teacherId=='' || teacherId==undefined){
		$("#msgs").html("教师信息错误，请刷新页面后重试！");
		return false;
	}else{
		$("#msgs").html("");
	}
	$('#myModal').modal('show');
	var url = pathHeader + '/teacher/teachermanage/setCreateAdjust.do';
$.ajax( {
		url : url,
		data : {
			teacherId:teacherId,
			adjustName:getSelected("adjustId").text.replace("请选择...",""),
			adjustId:$('#adjustId').val(),
			mobilizeMark:$("#mobilizeMark").val()
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
		$(".tip01").fadeIn(200);
		if (data.flag == "-1") {
			$("#msgHtml").html("提交失败，该人员存在未审核的个人变更记录！");
		} else if (data.flag == "-2") {
			$("#msgHtml").html("提交失败，该人员存在未审核的个人调动记录！");
		} else if (data.flag == "-3") {
			$("#msgHtml").html("提交失败，该人员存在未审核的个人离退记录！");
		}else if (data.flag == "-03") {
			$("#msgHtml").html("提交失败，该人员存在未审核的个人编制调整记录！");
		}else if (data.flag == "-0") {
			$("#msgHtml").html("提交失败，请稍后再试！");
		} else {
			$("#msgHtml").html("提交失败，请稍后再试！");
		}
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
				+ "/teacher/teachermanage/toAdjustPage.htm?click=333";
	} else {
		$(".tip01").fadeOut(100);
	}
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