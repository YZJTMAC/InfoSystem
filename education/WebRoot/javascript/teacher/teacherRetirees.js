$(function(){
	lastForSure();
	
	$("#pageSize").change(function(){
		showInfoList(); 
	});
	
	$(".tiptop2 a").click(function() {
		$(".tip2").fadeOut(200);
	});

	$(".cancel").click(function() {
		$(".tip2").fadeOut(100);
	});
	
	$("#toPage").click(function() {
		$(".tip1").fadeOut(100);
	});
	
	$('.deleteEdu').live('click', function() {
		clear();
  		$(".tip11").fadeIn(200);
	});
	
	$(".sure").click(function() {
		setMobilize();
	});
	
});

var areaFlag = 0;

/**
 * 最后确认, 个开发人 自己实现
 */
function lastForSure() {
	
	if(areaFlag == 1) {
		var str = "";
		var tempArray = chilkQueryConditionArray;
		$(tempArray).each(function(index, element) {
			if (element != null && element.length > 0) {
				var temp = element.split("_");
				if (temp[1] == "provinceId") {
					str = temp[2];
					$("#newProvinceId").val(temp[0]);
					$("#newPovinceName").val(temp[2]);
				} else if (temp[1] == "cityId") {
					str += "—" + temp[2];
					$("#newCityId").val(temp[0]);
					$("#newCityName").val(temp[2]);
				} else if (temp[1] == "districtId") {
					str += "—" + temp[2];
					$("#newDistrictId").val(temp[0]);
					$("#newDistrictName").val(temp[2]);
				} else if (temp[1] == "schoolId") {
					str += "—" + temp[2];
					$("#newSchoolId").val(temp[0]);
					$("#newSchoolName").val(temp[2]);
				}
	
			}
		})
		
		$('#tss').val(str);
		areaFlag = 0;
	} else {
		if(lastSelect != null && lastSelect.length > 0) {
			var conditionArray = lastSelect.split("_");
			var belone = conditionArray[0];
			var areaA = conditionArray[1]
			var text = conditionArray[2]
			$('#areaName').val(text);
			$('#areaType').val(areaA);
			$('#areaId').val(belone);
		}
		//重新生成查询条件
		showInfoList();
	}
	
	
	//清空
	clear();
	
	$(".tip11").fadeOut(200);
}

function showInfoList() {
	var sizePerPage = $("#pageSize").val();
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + "/teacher/teachermanage/queryTeacherRetireesActivetyList.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
		queryYear : $('#auditCreateDate').val(),
		realName:$('#realName').val(),
		idNumber:$('#idNumber').val(),
		changeTypeRetirees:$('#changeTypeRetirees').val(),
		changeType : $('#changeType').val(),
		areaId : $('#areaId').val(),
		areaType : $('#areaType').val(),
		sizePerPage:sizePerPage, 
		pageIndex:pageIndex},
		success:function(data){
			if(data.success) {
				var indexFlag = data.startIndex ;
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList, function(index,element) {
					indexFlag ++;
					gridHtml += getTdEHtml(element, indexFlag);
				});
				$('#teacherList').html("");
				$('#teacherList').html(gridHtml);
				$('#totleCount').text(data.total);
				pagination(data, function(){showInfoList(); });
			} else {
				$('#teacherList').html("<tr><td colspan='12'>无查询记录</td></tr>");
				$('#totleCount').text(0);
			}
		},
		error:function(){
		}
	});
}
 
function getTdEHtml(obj ,index) {
	var gridHtml = "<tr>";
		gridHtml += "<td>"+obj.realName+"</td>";
		gridHtml += "<td>"+obj.idNumber+"</td>";
		gridHtml += "<td>"+(obj.gender == 1 ? "男" : "女") +"</td>";
		gridHtml += "<td>"+(obj.newProvinceName == null ? "" : obj.newProvinceName)
                           +"-"+ (obj.newCityName == null ? "" : obj.newCityName)
                           +"-"+ (obj.newDistrictName == null ? "" : obj.newDistrictName)
                           +"-"+ (obj.newSchoolName == null ? "" : obj.newSchoolName) +"</td>";
		//gridHtml += "<td>"+(obj.jobFormerTeachingSection == null ? "" :obj.jobFormerTeachingSection)+"</td>";
		//gridHtml += "<td>"+(obj.jobFormerTeachingSubject == null ? "" :obj.jobFormerTeachingSubject)+"</td>";
		gridHtml += "<td>"+obj.auditCreateBy+"</td>";
		var strs = new Date(obj.auditCreateDate).format("yyyy-MM-dd");
		gridHtml += "<td>"+strs+"</td>";
		gridHtml += "<td>"+statusFormatterB(obj)+"</td>";
		gridHtml += "<td>"+optionFormatter(obj)+"</td>";
		gridHtml += "</tr>";
	return gridHtml;
	}
	
	function statusFormatterB(rows) {
		var returnStr = "";
		if (rows.auditStatus == 15) {
			returnStr = "自动审核通过";
		} else if (rows.auditStatus == 13) {
			returnStr = "通过";
		} else if (rows.auditStatus ==12) {
			returnStr = "未通过";
		} else if (rows.auditStatus ==11) {
			returnStr = "<font style='color: red;'>未审核</font>";
		} else if (rows.auditStatus ==14) {
			returnStr = "审核中";
		} 
		return returnStr;
	}
	
	function statusFormatter(rows) {
		var returnStr = "";
		if (rows.changeType == 31) {
			returnStr = "退休";
		} else if (rows.changeType == 32) {
			returnStr = "死亡";
		} else if (rows.changeType ==33) {
			returnStr = "离休";
		} else if (rows.changeType ==34) {
			returnStr = "离岗";
		} else if (rows.changeType ==35) {
			returnStr = "病休";
		} else if (rows.changeType ==36) {
			returnStr = "其他";
		}
		return returnStr;
	}
	
	function optionFormatter(rows){
//		var audit = "<a href='###' class='huibtn_a click2'>审核</a> ";
//		var handle = "<a href='###' onclick='reEmploy("+rows.teacherId+");' class='huibtn_a click2'>返聘</a>";
//		var returnStr = "";
//		if (rows.auditStatus ==12) {
//			returnStr += audit;
//		} else { // 订单状态“待签收”
//			//已提货待签收状态应该不用异常， 
//			//如果需要异常签收，那么不应该判断48小时
//			returnStr += handle;
//		} 
		var showInfo = "<a class='tablelink' href='###' onclick='reEmploy("+rows.auditId+");'  >详情</a>";
		
		return showInfo;
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

// 返聘调动
function setMobilize() {
	
	// 学科 学段
	var strType = "";
	var strHtml = "";
	$("input[name='jobFormerTeachingSubjectType']:checked").each(function() {
		strType += $(this).val() + ",";
		strHtml+=$(this).attr("id")+",";
	})
	
	if(strType.length>0){
		strType=strType.substr(0,strType.length-1);
		strHtml=strHtml.substr(0,strHtml.length-1);
	}
	
	if(strType.split(',').length!=strHtml.split(',').length){
		$("#msgs").html("任教学段/学科信息错误，请重试！");
		return false;
	}else{
		$("#msgs").html("");
	}
	
	var jobCoreTeacher = $('input:radio[name="jobCoreTeacher"]:checked').val();
	var jobWhetherTeacher = $('input:radio[name="jobWhetherTeacher"]:checked').val();
	var jobCountyRuralTeacher = $('input:radio[name="jobCountyRuralTeacher"]:checked').val();
	
	var url = pathHeader + '/teacher/teachermanage/setCreateMobilize.do';
	$.ajax( {
			url : url,
			data : {
				teacherId:$("#teacherId").val(),
				pastProvinceId:$("#pastProvinceId").val(),
				pastPovinceName:$("#pastPovinceName").val(),
				pastCityId:$("#pastCityId").val(),
				pastCityName:$("#pastCityName").val(),
				pastDistrictId:$("#pastDistrictId").val(),
				pastDistrictName:$("#pastDistrictName").val(),
				pastSchoolId:$("#pastSchoolId").val(),
				pastSchoolName:$("#pastSchoolName").val(),
				newProvinceId:$("#newProvinceId").val(),
				newProvinceName:$("#newProvinceName").val(),
				newCityId:$("#newCityId").val(),
				newCityName:$("#newCityName").val(),
				newDistrictId:$("#newDistrictId").val(),
				newDistrictName:$("#newDistrictName").val(),
				newSchoolId:$("#newSchoolId").val(),
				newSchoolName:$("#newSchoolName").val(),
				jobCommentPosition:getSelected("jobCommentPosition").text.replace("请选择...",""),
				jobCommentPositionType:getSelected("jobCommentPosition").value,
				jobRecruitmentPosition:getSelected("jobRecruitmentPosition").text.replace("请选择...",""),
				jobRecruitmentPositionType:getSelected("jobRecruitmentPosition").value,
				jobSchoolAdministrationOffice:getSelected("jobSchoolAdministrationOffice").text.replace("请选择...",""),
				jobSchoolAdministrationOfficeType:getSelected("jobSchoolAdministrationOffice").value,
				jobFormerTeachingSubject:strHtml,
				jobFormerTeachingSubjectType:strType,
				jobCoreTeacher:jobCoreTeacher,
				jobWhetherTeacher:jobWhetherTeacher,
				jobCountyRuralTeacher:jobCountyRuralTeacher,
				mobilizeMark:$("#mobilizeMark").val()
			},
			type : "POST",
			cache : false,
			async : true,
			dataType : "json",
			success : function(data) {
				if (data.success) {
					$("#msgHtml").html("提交成功，请到调动管理功能中，查看返聘调动记录！")
					$(".tip1").fadeIn(200);
					$(".tip2").fadeOut(200);
					//调动成功页面跳转
		} else {
			$(".tip1").fadeIn(200);
			if (data.flag == "-1") {
				$("#msgHtml").html("提交失败，该人员存在未审核的个人变更记录！");
			} else if (data.flag == "-2") {
				$("#msgHtml").html("提交失败，该人员存在未审核的个人调动记录！");
			} else if (data.flag == "-3") {
				$("#msgHtml").html("提交失败，该人员存在未审核的个人离退记录！");
			} else if (data.flag == "-0") {
				$("#msgHtml").html("提交失败，请稍后再试！");
			} else {
				$("#msgHtml").html("提交失败，请稍后再试！");
			}
		}
	},
	error : function() {
		$(".tip1").fadeIn(200);
		$("#msgHtml").html("提交失败，请稍后再试！");
	}

	});
}	
	
function reEmploy(auditId) {
	$(".tipinfo").empty();
	var json = {
		eduIdNum : 1
	};
	$("#addEduPartB").tmpl(json).appendTo(".tipinfo");
	
	//SysCode.createSelect("PROJECT_DIM_PROFESSIONAL_TITLE", "jobRecruitmentPosition", "<option value=''>请选择</option>");
	//SysCode.createSelect("PROJECT_DIM_PROFESSIONAL_TITLE", "jobCommentPosition", "<option value=''>请选择</option>");
	
	//queryDic('project_subject');
	//queryDic('office_type');
	/**
	$.ajax( {
			url : pathHeader + "/teacher/teacherProject/teacherJobInfo.do",
			type : "POST",
			cache : "false",
			async : "true",
			dataType : "json",
			data : {
				teacherId : teacherId
			},
			success : function(data) {
				if(data.success) {
					var jobInfo = data.jobInfo;
					var userInfo = data.eduUserInfo;
					var str = userInfo.userProvinceName + "-" + userInfo.userCityName + "-" + userInfo.userDistrictName + "-" + userInfo.schoolName
					$('#tss').val(str);
					
					//存入旧 地区 信息
					$("#teacherId").val(teacherId);
					$("#pastProvinceId").val(userInfo.userProvinceId);
					$("#pastPovinceName").val(userInfo.userProvinceName);
					$("#pastCityId").val(userInfo.userCityId);
					$("#pastCityName").val(userInfo.userCityName);
					$("#pastDistrictId").val(userInfo.userDistrictId);
					$("#pastDistrictName").val(userInfo.userDistrictName);
					$("#pastSchoolId").val(userInfo.schoolId);
					$("#pastSchoolName").val(userInfo.schoolName);
				
					
					if(jobInfo != null) {
						var subjectStr = jobInfo.jobFormerTeachingSubjectType;
						var subjectArray = subjectStr.split(",");
						for(var i = 0; i< subjectArray.length; i++) {
							$('input:checkbox[name="jobFormerTeachingSubjectType"][value=' + subjectArray[i] + ']')
							.attr("checked", 'checked');
						}
		
						$('#jobCommentPosition').val(jobInfo.jobCommentPositionType);
						$('#jobRecruitmentPosition').val(jobInfo.jobRecruitmentPositionType);
						$('#jobSchoolAdministrationOffice').val(jobInfo.jobSchoolAdministrationOffice);
						
						$('input:radio[name="jobCoreTeacher"][value=' + jobInfo.jobCoreTeacher + ']')
								.attr("checked", 'checked');
	
						$('input:radio[name="jobWhetherTeacher"][value=' + jobInfo.jobWhetherTeacher + ']')
								.attr("checked", 'checked');
	
						//国培计划农村骨干
						$('input:radio[name="jobCountyRuralTeacher"][value=' + jobInfo.jobCountyRuralTeacher + ']')
								.attr("checked", 'checked');
					}
					$(".select3").uedSelect({
						width : 100
					});
	
				}
			}
	});
	**/
	
	$.ajax( {
			url : pathHeader + "/teacher/teachermanage/queryAuditInfo.do",
			type : "POST",
			cache : "false",
			async : "true",
			dataType : "json",
			data : {
				id : auditId
			},
			success : function(data) {
				if(data.success) { 
					$("#mobilizeMark").val(data.auditInfo.mobilizeMark == null ? "" : data.auditInfo.mobilizeMark);
					$(".tip2").fadeIn(200);
				}
			}
	});
	
	
	areaFlag = 1;
}

/**
 * 详情
 */
function info(orderId) {
	var openUrl = pathHeader + "/order/orderInfoPage.htm?orderId=" +　LogisticToString(orderId);
	showWindow(openUrl);
}

function showWindow(url) {
	window.location.href = url;
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
														.append("<INPUT name='jobFormerTeachingSubjectType' value='"+element.dictionaryId+"' id='"+element.dictionaryName+"' type='checkbox' >" + element.dictionaryName);

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
						}
					}
				}
			});
}