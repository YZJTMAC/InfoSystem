$(function() {

	// 条件查询
	$("#select").click(function() {
		showMobilizeAddList();
	});
	//queryDic('project_subject');
	queryDic('teacher_professional');
	queryDic('office_type');
	queryDic('ggjs_type');
	queryDicS('stduty_section', 'jobFormerTeachingSectionHTML');
})

var oldSchoolId = 0;

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
					retiress : $('#retiress').val(),
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
							$(".tip2").fadeOut(200);
						});

						//						$(".sure").click(function() {
						//							$(".tip2").fadeOut(100);
						//						});

						$(".cancel").click(function() {
							$(".tip2").fadeOut(100);
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
	
	if( obj.userImageUrl == null || obj.userImageUrl == "" || obj.userImageUrl.length == 0){
		gridHtml += "<img src='"+ pathHeader+ "/images/u8_normal.jpg' style='width:120px;height:120px' title='头像120×120'>";
	} else {
		gridHtml += "<img src='"+ imageServer+ obj.userImageUrl +"' style='width:120px;height:120px' title='头像120×120'>";
	}
//	gridHtml += "<img src=\"" + imageServer + obj.userImageUrl
//			+ "\" title=\"头像\" />";
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
			+ (obj.schoolName == null ? "" : obj.schoolName) + "</span>"
	gridHtml += "</dd><dd >";
	gridHtml += "<span class=\"titlewidth\" >教师资格证书号：</span><span>"
			+ obj.jobCertificateNum + "</span>";
	gridHtml += "</dd><dd>";
	gridHtml += "<span class=\"titlewidth\">(评)教师职称：</span><span>"
			+ obj.jobCommentPosition + "</span>";
	gridHtml += "</dd><dd>";
	gridHtml += "<span class=\"titlewidth\">(聘)教师职称：</span><span>"
			+ obj.jobRecruitmentPosition + "</span>";
	gridHtml += "</dd><dd >";
	gridHtml += "<span class=\"titlewidth\" >学校行政职务：</span><span>"
			+ obj.jobSchoolAdministrationOffice + "</span>";
	gridHtml += "</dd>";
	gridHtml += "<dd><span class=\"titlewidth\">任教学段/学科：</span><span>"
			+ obj.jobFormerTeachingSubject + "</span>";
	gridHtml += "</dd>";
	gridHtml += "<dd><span class=\"titlewidth\">是否为骨干教师：</span><span>"
			+ obj.jobCoreTeacher + "</span>";
	gridHtml += "</dd><dd >";
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
			+ obj.userDistrictName + (obj.schoolName == null ? "" : "—"
			+ obj.schoolName));

	gridHtml += "<input type=\"button\" onclick='addMobilize("
			+ obj.userProvinceId + "," + obj.userCityId + ","
			+ obj.userDistrictId + "," + obj.schoolId + ",\"" + str + "\",\""
			+ obj.jobCoreTeacherType + "\",\"" + obj.jobWhetherTeacher + "\",\""
			+ obj.jobCountyRuralTeacher + "\",\""
			+ obj.jobFormerTeachingSubjectType + "\",\""
			+ obj.jobCommentPositionType + "\",\""
			+ obj.jobRecruitmentPositionType + "\",\""
			+ obj.jobSchoolAdministrationOfficeType + "\"," + obj.id + ",\""
			+ obj.sectionDictionaryCode + "\",\""
			+ obj.jobFormerTeachingSectionType
			+ "\");' class=\"btn click\" value=\"发起\" />";
	gridHtml += "</div></td></tr></table></dd></dl>";
	return gridHtml;
}

function checkRole(teacherId){
	var status = -1;
	var url = pathHeader + '/person/getTeacherById.do';
	$.ajax({
		url : url,
		data:{teacherId:teacherId},
		type:'post',
		async: false,  
		success : function(data) {
			if(data.success){
				status = data.user.status;
			}
		}
	});
	
	
	if(status == 8){
		jQuery.generalAlert("该教师状态为在职，无法返聘");
		return false;
	} 
	
	if (status == 32) {
		jQuery.generalAlert("该教师已死亡，无法返聘");
		return false;
	}
//	if (status == 33) {
//		jQuery.generalAlert("该教师已离休，无法返聘");
//		return false;
//	}
//	if (status == 34) {
//		jQuery.generalAlert("该教师已离岗，无法返聘");
//		return false;
//	}
//	if (status == 35) {
//		jQuery.generalAlert("该教师已病休，无法返聘");
//		return false;
//	}
	return true;
}

//调动和返聘是同一个方法
function addMobilize(userProvinceId, userCityId, userDistrictId, schoolId, tss,
		jobCoreTeacherType, jobWhetherTeacher, jobCountyRuralTeacher,
		jobFormerTeachingSubjectType, jobCommentPositionType,
		jobRecruitmentPositionType, jobSchoolAdministrationOfficeType,
		teacherId, sectionDictionaryCode, jobFormerTeachingSectionType) {
	
	//检查该老师是否达到返聘要求，不需要检查，因为如果不达到要求，是无法进行返聘的
//	if(checkRole(teacherId)){
		oldSchoolId = schoolId;
		$(".tip2").fadeIn(200);
		$("#schoolProvinceId").val(userProvinceId);
		$("#schoolCityId").val(userCityId);
		$("#schoolDistrictId").val(userDistrictId);
		$("#schoolId2").val(schoolId);
		$("#tss").val(tss);

		$("#jobCommentPosition").val(jobCommentPositionType);
		$("#jobRecruitmentPosition").val(jobRecruitmentPositionType);
		$("#jobSchoolAdministrationOffice").val(jobSchoolAdministrationOfficeType);
		//骨干教师
		$("#jobCoreTeacher").val(jobCoreTeacherType);

		$(".select3").uedSelect( {
			width : 120
		});

		/*if (jobCoreTeacher == "是") {
			$("#jobCoreTeacherYES").attr("checked", true);
		} else {
			$("#jobCoreTeacherNO").attr("checked", true);
		}*/

		if (jobWhetherTeacher == "是") {
			$("#jobWhetherTeacherYES").attr("checked", true);
		} else {
			$("#jobWhetherTeacherNO").attr("checked", true);
		}

		if (jobCountyRuralTeacher == "是") {
			$("#jobCountyRuralTeacherYES").attr("checked", true);
		} else {
			$("#jobCountyRuralTeacherNO").attr("checked", true);
		}

		//学科学段
		if (jobFormerTeachingSectionType != undefined
				&& jobFormerTeachingSectionType != null
				&& jobFormerTeachingSectionType != '') {
			$("#jobFormerTeachingSectionType_" + jobFormerTeachingSectionType + "")
					.attr("checked", true);

			qrySubject(sectionDictionaryCode, jobFormerTeachingSectionType, jobFormerTeachingSubjectType);
		}

		// 创建调动
		$("#setMob").off().click(
				function() {
					setMobilize(userProvinceId, userCityId, userDistrictId,
							schoolId, tss, jobCoreTeacherType, jobWhetherTeacher,
							jobCountyRuralTeacher, jobFormerTeachingSubjectType,
							jobCommentPositionType, jobRecruitmentPositionType,
							jobSchoolAdministrationOfficeType, teacherId);
				});
//	}
	
}

function setMobilize(userProvinceId, userCityId, userDistrictId, schoolId, tss,
		jobCoreTeacherType, jobWhetherTeacher, jobCountyRuralTeacher,
		jobFormerTeachingSubjectType, jobCommentPositionType,
		jobRecruitmentPositionType, jobSchoolAdministrationOfficeType,
		teacherId) {
	// 创建调动
	var pastPovinceName = "";
	var pastCityName = "";
	var pastDistrictName = "";
	var pastSchoolName = "";
	var oldTss = tss.split('—');
	for ( var i = 0; i < oldTss.length; i++) {
		if (i == 0) {
			pastPovinceName = oldTss[0];
		} else if (i == 1) {
			pastCityName = oldTss[1];
		} else if (i == 2) {
			pastDistrictName = oldTss[2];
		} else if (i == 3) {
			pastSchoolName = oldTss[3];
		}
	}

	var newPovinceName = "";
	var newCityName = "";
	var newDistrictName = "";
	var newSchoolName = "";
	var newTss = $("#tss").val().split('—');
	for ( var i = 0; i < newTss.length; i++) {
		if (i == 0) {
			newPovinceName = newTss[0];
		} else if (i == 1) {
			newCityName = newTss[1];
		} else if (i == 2) {
			newDistrictName = newTss[2];
		} else if (i == 3) {
			newSchoolName = newTss[3];
		}
	}

	//	if($("#schoolId2").val() == oldSchoolId) {
	//		$("#msgs").html("请选择与原地区不同的目标学校！");
	//		return false;
	//	}

	if (newPovinceName == "" || newCityName == "" || newDistrictName == ""
			|| newSchoolName == "") {
		$("#msgs").html("请选择完整目标市县校信息！");
		return false;
	} else {
		$("#msgs").html("");
	}

	if ($("#mobilizeMark").val() == "") {
		$("#msgs").html("请填写操作说明！");
		return false;
	} else {
		$("#msgs").html("");
	}

	var strType = "";
	var strHtml = "";

	var strSection = "";
	var strSectionHtml = "";
	$("input[name='jobFormerTeachingSectionType']:checked").each(function() {
		strSection = $(this).val();
		strSectionHtml = $("#" + $(this).attr("id") + "_1").html();
	})

	if (strSection.length > 0) {
		$("input[name='jobFormerTeachingSubject']:checked").each(function() {
			strType += $(this).val() + ",";
			strHtml += $("#" + $(this).attr("id") + "_1").html() + ",";
		})
	}

	if (strType.length > 0) {
		strType = strType.substr(0, strType.length - 1);
		strHtml = strHtml.substr(0, strHtml.length - 1);
	}

	if (strType.split(',').length != strHtml.split(',').length) {
		$("#msgs").html("任教学段/学科信息错误，请重试！");
		return false;
	} else {
		$("#msgs").html("");
	}

	/*var ggjs = "0";
	$("input[name='jobCoreTeacher']:checked").each(function() {
		ggjs = $(this).val();
	})*/

	var bzr = "0";
	$("input[name='jobWhetherTeacher']:checked").each(function() {
		bzr = $(this).val();
	})

	var bpjh = "0";
	$("input[name='jobCountyRuralTeacher']:checked").each(function() {
		bpjh = $(this).val();
	})
	$('#myModal').modal('show');
	var url = pathHeader + '/teacher/teachermanage/setCreateMobilize.do';
	$
			.ajax( {
				url : url,
				data : {
					teacherId : teacherId,
					pastProvinceId : userProvinceId,
					pastPovinceName : pastPovinceName,
					pastCityId : userCityId,
					pastCityName : pastCityName,
					pastDistrictId : userDistrictId,
					pastDistrictName : pastDistrictName,
					pastSchoolId : schoolId,
					pastSchoolName : pastSchoolName,
					newProvinceId : $("#schoolProvinceId").val(),
					newProvinceName : newPovinceName,
					newCityId : $("#schoolCityId").val(),
					newCityName : newCityName,
					newDistrictId : $("#schoolDistrictId").val(),
					newDistrictName : newDistrictName,
					newSchoolId : $("#schoolId2").val(),
					newSchoolName : newSchoolName,
					jobCommentPosition : getSelected("jobCommentPosition").text
							.replace("请选择...", ""),
					jobCommentPositionType : getSelected("jobCommentPosition").value,
					jobRecruitmentPosition : getSelected("jobRecruitmentPosition").text
							.replace("请选择...", ""),
					jobRecruitmentPositionType : getSelected("jobRecruitmentPosition").value,
					jobSchoolAdministrationOffice : getSelected("jobSchoolAdministrationOffice").text
							.replace("请选择...", ""),
					jobSchoolAdministrationOfficeType : getSelected("jobSchoolAdministrationOffice").value,
					//骨干教师	
					jobCoreTeacherType : getSelected("jobCoreTeacher").value,
					jobCoreTeacher : getSelected("jobCoreTeacher").text.replace("请选择...", ""),
					
					jobFormerTeachingSubject : strHtml,
					jobFormerTeachingSubjectType : strType,
					//jobCoreTeacher : ggjs,
					jobWhetherTeacher : bzr,
					jobCountyRuralTeacher : bpjh,
					flag : $("#flag").val(),
					mobilizeMark : $("#mobilizeMark").val(),
					jobFormerTeachingSection : strSectionHtml,
					jobFormerTeachingSectionType : strSection
				},
				type : "POST",
				cache : false,
				async : true,
				dataType : "json",
				success : function(data) {
					if (data.success) {
						$('#myModal').modal('hide');						
						$(".tip2").fadeOut(200);
						//提示信息，发起成功之后是否立即去审核。
						reminderInfo();	
			} else {
				$(".tip1").fadeIn(200);
				if (data.flag == "-1") {
					$("#msgHtml").html("提交失败，该人员存在未审核的个人变更记录！");
				} else if (data.flag == "-2") {
					$("#msgHtml").html("提交失败，该人员存在未审核的个人调动记录！");
				} else if (data.flag == "-3") {
					$("#msgHtml").html("提交失败，该人员存在未审核的个人离退记录！");
				} else if (data.flag == "-03") {
					$("#msgHtml").html("提交失败，该人员存在未审核的个人编制调整记录！");
				} else if (data.flag == "-0") {
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
			$(".tip1").fadeIn(200);
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
				+ "/teacher/teachermanage/toMobilizePage.htm?click=3";
	} else {
		$(".tip1").fadeOut(100);
	}
}

function getSelected(sid) {
	var value, text;
	text = $("#" + sid + " option:selected").text();
	value = $("#" + sid).val();
	scontent = {
		value : value,
		text : text
	};
	return scontent;
}

/**
 * 查询字典表
 */
function queryDic(type) {
	var url = pathHeader + "/sys/queryDicByType.do";
	$
			.ajax( {
				url : url,
				data : {
					dicType : type
				},
				type : "post",
				async : false,
				success : function(data) {
					if (data.rows.length > 0) {
						var objList = data.rows;
						if (type == 'project_subject') {
							$
									.each(
											objList,
											function(index, element) {
												$(
														"#jobFormerTeachingSubjectHTML")
														.append(
																"<input id=\"jobFormerTeachingSubjectType"
																		+ element.dictionaryId
																		+ "\" name=\"jobFormerTeachingSubject\" type=\"checkbox\" value=\""
																		+ element.dictionaryId
																		+ "\"/>"
																		+ "<a id=\"jobFormerTeachingSubjectType"
																		+ element.dictionaryId
																		+ "_1\">"
																		+ element.dictionaryName
																		+ "</a>"
																		+ "");

											});
						} else if (type == 'teacher_professional') {
							$.each(objList, function(index, element) {
								$("#jobCommentPosition").append(
										"<option value='"
												+ element.dictionaryId + "'>"
												+ element.dictionaryName
												+ "</option>")
								$("#jobRecruitmentPosition").append(
										"<option value='"
												+ element.dictionaryId + "'>"
												+ element.dictionaryName
												+ "</option>")
							});
						} else if (type == 'office_type') {
							$.each(objList, function(index, element) {
								$("#jobSchoolAdministrationOffice").append(
										"<option value='"
												+ element.dictionaryId + "'>"
												+ element.dictionaryName
												+ "</option>")
							});
						}else if (type == 'ggjs_type') {
							$.each(objList, function(index, element) {
								$("#jobCoreTeacher").append(
										"<option value='"
												+ element.dictionaryId + "'>"
												+ element.dictionaryName
												+ "</option>")
							});
						}
					}
				}
			});
}

/**
 * 查询字典表
 */
function queryDicS(dicType, id) {
	var url = pathHeader + "/sys/queryDicByType.do";
	var vid = 0;
	$
			.ajax( {
				url : url,
				data : {
					dicType : dicType
				},
				type : "post",
				async : false,
				success : function(data) {
					if (data.success) {
						var objList = data.rows;
						var gridHtml = "";
						$
								.each(
										objList,
										function(index, element) {

											if (dicType == "project_subject") {
												gridHtml += "<INPUT name='jobFormerTeachingSubjectType'  value='"
														+ element.dictionaryId
														+ "' type='checkbox' >";
											} else {
												gridHtml += "<INPUT name='jobFormerTeachingSectionType' id='jobFormerTeachingSectionType_"
														+ element.dictionaryId
														+ "' onclick='qrySubject(\""+ element.dictionaryCode+ "\","+ element.dictionaryId+ ",\"\")' value='"
														+ element.dictionaryId
														+ "' type='radio' >";
											}
											gridHtml += "<a id=\"jobFormerTeachingSectionType_"
													+ element.dictionaryId
													+ "_1\">"
													+ element.dictionaryName
													+ "</a>";
										});
						$('#' + id).append(gridHtml);
					} else {
					}
				},
				error : function() {

				}
			});
}
/**
 * 查询学科
 */
function qrySubject(sectionName, id, jobFormerTeachingSubjectType) {
	$("#jobFormerTeachingSubjectHTML").html("");
	var url = pathHeader + "/sys/querySubject.do";
	$
			.ajax( {
				url : url,
				data : {
					sectionName : sectionName
				},
				type : "post",
				async : false,
				success : function(data) {
					if (data.success) {
						var rows = data.rows;
						if (rows.length > 0) {
							var gridHtml = "";
							var jss=1;
							for ( var i = 0; i < rows.length; i++) {
								var obj = rows[i];
								jss+=1;
								gridHtml += "<input id=\"jobFormerTeachingSubjectType"
										+ obj.dictionaryId
										+ "\" name=\"jobFormerTeachingSubject\" type=\"checkbox\" value=\""
										+ obj.dictionaryId
										+ "\"/>"
										+ "<a id=\"jobFormerTeachingSubjectType"
										+ obj.dictionaryId
										+ "_1\">"
										+ obj.dictionaryName + "</a>" + "";
								
								if(jss>6){
									jss=0;
									gridHtml += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
								}

							}
							$("#jobFormerTeachingSubjectHTML").html(gridHtml);

							var subject = jobFormerTeachingSubjectType
									.split(',');
							for ( var i = 0; i < subject.length; i++) {
								$("#jobFormerTeachingSubjectType" + subject[i])
										.attr("checked", true);
							}

						} else {
							$("#jobFormerTeachingSubjectHTML").html("未查询出相关学科");
						}
					}
				},
				error : function() {
					$("#jobFormerTeachingSubjectHTML").html("未查询出相关学科");
				}
			});
}

//提示信息，是否立即去审核。
function reminderInfo() {
	$('#reminderInfo').html("已发起成功，还需要审核，是否立即去审核？");	
	$("#toNewPage").click(function() {			
		var url = pathHeader+ "/teacher/teachermanage/toMobilizeAuditListPage.htm?click=1000&flag=N";
		window.open(url,"_self");
	});
	$("#toCancel").click(function() {
		window.location.href = $("#goto").attr("href");
		close();
	});
	$(".tip").fadeIn(200);
}

function close() {
	$(".tip").fadeOut(200);
	
}