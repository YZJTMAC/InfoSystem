$(function() {
	//查询教师信息
	showTeacherInfo(teacherId);
	
	/*$("#JobtransferHis").click(function(){
		showJobtransferHistory();
	});
	
	$("#commentHis").click(function(){
		showCommentHistory();
	});*/
});

function showTeacherInfo() {
	$.ajax( {
				url : pathHeader + "/teacher/teacherProject/teacherInfoList.do",
				type : "POST",
				cache : "false",
				async : "false",
				dataType : "json",
				data : {
					teacherId : teacherId
				},
				success : function(data) {
				
				eduUser(data);

				//教师基本信息
				teacherBaceInfo(data);

				//教育经历
				var objList = data.educationInfo;
				var tableValues = "";
				for ( var i = 0; i < objList.length; i++) {
					var values = objList[i];
					addCommonEduInfo(values);
				}

				//教师工作信息
				jobInfo(data);

				//历次学校记录
				var schoolList = data.oldSchool;
				var tableValues = "";
				for ( var i = 0; i < schoolList.length; i++) {
					var values = schoolList[i];
					var strs = new Date(values.oldEntryTime)
							.format("yyyy-MM-dd");
					var strs2 = new Date(values.updateDate)
							.format("yyyy-MM-dd");
					var strs3 = new Date(values.oldTurnoverTime)
							.format("yyyy-MM-dd");
					tableValues += "<tr>" + "<td>" + values.oldSchool + "</td>"
							+ "<td>" + strs + "</td>" + "<td>" + strs3
							+ "</td>" + "<td>" + values.updateBy + "</td>"
							+ "<td>" + strs2 + "</td>" + "</tr>";
				}
				$('#schoolId').val(tableValues);

				//教师审核情况
			var auditHistroy = data.auditHistroy;
			if(auditHistroy!=null||auditHistroy.length>0){
				$('#auditHistry').html(showAuditHistory(auditHistroy));
			}
			
				//教师审核情况
				var auditInfo = data.auditInfo;
				if(auditInfo != null) {
					var infos = "";
					for ( var i = 0; i < auditInfo.length; i++) {
						var values = auditInfo[i];
						var auditTime = new Date(values.auditDate)
								.format("yyyy-MM-dd");
						var auditStatus = "";
						if (values.auditStatus == 1) {
							auditStatus = "通过";
						} else if (values.auditStatus == 0) {
							auditStatus = "未通过";
						} else {
							auditStatus = "审核中"
						}
						infos += "<tr>" + " <td width='96'>审核状态：</td>"
								+ "<td width='212'>"
								+ auditStatus
								+ "</td>"
								+ "<td width='10'>&nbsp;</td><td width='113'></td><td width='169'></td></tr>"
								+ "<tr>"
								+ "<td>学校审核人：</td>"
								+ "<td>"
								+ values.auditAuditor
								+ "</td>"
								+ "<td>&nbsp;</td>"
								+ "<td>审核时间：</td>"
								+ "<td>"
								+ auditTime
								+ "</td>"
								+ "</tr>"
								+ "<tr>"
								+ "<td>审核意见：</td>"
								+ "<td>"
								+ values.auditOption
								+ "</td>"
								+ "<td>&nbsp;</td><td></td>"
								+ "<td></td>"
								+ "</tr>";
						$('#auditId').val(infos);
					}
				}
				$(".select2").uedSelect( {
					width : 167
				});
			},
			error : function() {
				jQuery.generalAlert("查询错误");
			}

			});
}

function teacherBaceInfo(data) {
	var basicInfo = data.basicInfo;
	if (basicInfo == null ) {
		return 
		}
	
		if (basicInfo.teacherCountry == null
				|| basicInfo.teacherCountry.length == 0
				|| basicInfo.teacherCountry == "")
			$('#country').val("");
		else
			$('#country').val(basicInfo.teacherCountry);
		if (basicInfo.teacherOldName == null
				|| basicInfo.teacherOldName.length == 0
				|| basicInfo.teacherOldName == "")
			$('#teacherOldName').val("");
		else
			$('#teacherOldName').val(basicInfo.teacherOldName);
		if (basicInfo.teacherNameSpelling == null
				|| basicInfo.teacherNameSpelling.length == 0
				|| basicInfo.teacherNameSpelling == "")
			$('#teacherNameSpelling').val("");
		else
			$('#teacherNameSpelling').val(basicInfo.teacherNameSpelling);
		if (basicInfo.teacherBornDate == null
				|| basicInfo.teacherBornDate.length == 0
				|| basicInfo.teacherBornDate == "") {
			$('#teacherBornDate').val("");
		} else {
			$('#teacherBornDate').val(basicInfo.teacherBornDate);
		}
		$('#teacherPoliticalStatus').val(basicInfo.teacherPoliticalStatus);
		
		//入党时间
		if (basicInfo.partyTime == null
				|| basicInfo.partyTime.length == 0
				|| basicInfo.partyTime == "") {
			$('#partyTime').val("");
		} else {
			$('#partyTime').val(basicInfo.partyTime);
		}
		
		if (basicInfo.teacherNativePlace == null
				|| basicInfo.teacherNativePlace.length == 0
				|| basicInfo.teacherNativePlace == "")
			$('#teacherNativePlace').val("");
		else
			$('#teacherNativePlace').val(basicInfo.teacherNativePlace);
		if (basicInfo.teacherNation == null
				|| basicInfo.teacherNation.length == 0
				|| basicInfo.teacherNation == "")
			$('#teacherNation').val("");
		else
			$('#teacherNation').val(basicInfo.teacherNation);
		if (basicInfo.teacherPhoneNum == null
				|| basicInfo.teacherPhoneNum.length == 0
				|| basicInfo.teacherPhoneNum == "")
			$('#teacherPhoneNum').val("");
		else
			$('#teacherPhoneNum').val(basicInfo.teacherPhoneNum);
		if (basicInfo.teacherCallNum == null
				|| basicInfo.teacherCallNum.length == 0
				|| basicInfo.teacherCallNum == "")
			$('#teacherCallNum').val("");
		else
			$('#teacherCallNum').val(basicInfo.teacherCallNum);
		if (basicInfo.teacherQq == null || basicInfo.teacherQq.length == 0
				|| basicInfo.teacherQq == "")
			$('#teacherQq').val("");
		else
			$('#teacherQq').val(basicInfo.teacherQq);
		if (basicInfo.teacherEmail == null
				|| basicInfo.teacherEmail.length == 0
				|| basicInfo.teacherEmail == "")
			$('#teacherEmail').val("");
		else
			$('#teacherEmail').val(basicInfo.teacherEmail);

		if (basicInfo.teacherFamilyLocal == null
				|| basicInfo.teacherFamilyLocal.length == 0
				|| basicInfo.teacherFamilyLocal == "")
			$('#teacherFamilyLocal').val("");
		else
			$('#teacherFamilyLocal').val(basicInfo.teacherFamilyLocal);

		if (basicInfo.teacherMaritalStatus == null
				|| basicInfo.teacherMaritalStatus.length == 0) {
			$('#teacherMaritalStatus').val("");
		} else {
			var teacherMaritalStatus = "";
			if (basicInfo.teacherMaritalStatus == 1) {
				teacherMaritalStatus = "已婚";
			} else {
				teacherMaritalStatus = "未婚";
			}
			$('input:radio[name="teacherMaritalStatus"][value=' + basicInfo.teacherMaritalStatus + ']').attr("checked", 'checked');
//			$('#teacherMaritalStatus').val(teacherMaritalStatus);
		}
		if (basicInfo.teacherHealthCondition == null
				|| basicInfo.teacherHealthCondition.length == 0
				|| basicInfo.teacherHealthCondition == "")
			$('#teacherHealthCondition').val("");
		else
			$('#teacherHealthCondition').val(basicInfo.teacherHealthCondition);
}

function eduUser(data) {
	var obj = data.eduUserInfo;
	eduBaseId = obj.id;
	if (obj.loginAccount == null || obj.loginAccount.length == 0
			|| obj.loginAccount == "") {
		$('#loginAccount').html("");
	} else {
		$('#loginAccount').html(obj.loginAccount);

	}
	if (obj.password == null || obj.password.length == 0 || obj.password == "")
		$('#password').html("");
	else
		$('#password').html(obj.password);

	if (obj.realName == null || obj.realName.length == 0
			|| obj.loginAccount == "") {
		$('#realName').html("");
		$('#teacherName').text("");
	} else {
		$('#realName').html(obj.realName);
		$('#teacherName').html(obj.realName + "老师的资料信息");
	}
	if (obj.gender == null || obj.gender.length == 0) {
		$('#gender').html("");
	} else {
		var sex = "";
		if (obj.gender == 1) {
			sex = "男";
		} else {
			sex = "女";
		}
		$('#gender').html(sex);
	}

	if (obj.idNumber == null || obj.idNumber.length == 0 || obj.idNumber == "")
		$('#idNumber').html("");
	else
		$('#idNumber').html(obj.idNumber);
	if (obj.teacherNo == null || obj.teacherNo.length == 0
			|| obj.teacherNo == "")
		$('#teacherNo').html("");
	else
		$('#teacherNo').html(obj.teacherNo);
	if (obj.schoolName == null || obj.schoolName.length == 0
			|| obj.schoolName == "")
		$('#schoolName').html("");
	else
		$('#schoolName').html(obj.schoolName);

	if (obj.status == null || obj.status.length == 0 || obj.status == "")
		$('#status').html("");
	else {
		var statueName = "";
		switch (obj.status) {
		case 6:
			statueName = "未审核";
			break;
		case 7:
			statueName = "审核不通过";
			break;
		case 8:
			statueName = "在职";
			break;
		case 31:
			statueName = "已退休";
			break;
		case 32:
			statueName = "已死亡";
			break;
		case 33:
			statueName = "已离休";
			break;
		case 34:
			statueName = "已离岗";
			break;
		case 35:
			statueName = "已病休";
			break;
		}
		$('#status').html(statueName);
	}
	if(obj.userImageUrl != null || obj.userImageUrl == "") {
		$("#photo").attr("src", imageServer + obj.userImageUrl);
		$("#photoTemp").attr("src", imageServer + obj.userImageUrl);
	}
	// 基本审核记录
	$('#auditId').html(showAudit(obj));
}

function jobInfo(data) {
	var jobInfo = data.jobInfo;
	if (jobInfo == null) {
		return;
	}
	
	//五险一金
	if (jobInfo.wxyj == null
		|| jobInfo.wxyj.length == 0
		|| jobInfo.wxyj == "")
		$('#wxyj').val("");
	else
		$('#wxyj').val(jobInfo.wxyj);
	//岗位类别
	$('#gwlb').val(jobInfo.gwlb); 
	//岗位等级
	$('#gwdj').val(jobInfo.gwdj);
	//是否在编
	$('input:radio[name="sfzb"][value=' + jobInfo.sfzb + ']')
			.attr("checked", 'checked');
	//签订合同情况
	$('#contract').val(jobInfo.contract);
	//月平均工资
	if (jobInfo.salary == null
		|| jobInfo.salary.length == 0
		|| jobInfo.salary == "")
		$('#salary').val("");
	else
		$('#salary').val(jobInfo.salary);  
	//教师资格证种类
	$('#jszgz').val(jobInfo.jszgz);
	//普通话等级
	$('#pthdj').val(jobInfo.pthdj);
	//从教起始年月
	if (jobInfo.cjqsny == null
		|| jobInfo.cjqsny.length == 0
		|| jobInfo.cjqsny == "")
		$('#cjqsny').val("");
	else{
		$('#cjqsny').val(jobInfo.cjqsny);
	}		
	//是否是全日制师范类专业毕业
	$('input:radio[name="qrzsfzy"][value=' + jobInfo.qrzsfzy + ']')
			.attr("checked", 'checked');
	//近三年培训情况
	if (jobInfo.jsnpxqk == null
		|| jobInfo.jsnpxqk.length == 0
		|| jobInfo.jsnpxqk == "")
		$('#jsnpxqk').val("");
	else
		$('#jsnpxqk').val(jobInfo.jsnpxqk);
	//是否是免费师范生
	$('#mfsfs').val(jobInfo.mfsfs);
	
	//是否名校长培养对象
	$('#eliteTraining').val(jobInfo.eliteTrainingType);
	//是否教学名师
	$('#teachingMaster').val(jobInfo.teachingMasterType);
	//是否学科带头人
	$('#jobSubjectLeader').val(jobInfo.jobSubjectLeader);
	//聘任岗位等级时间
	if (jobInfo.postGrade == null
			|| jobInfo.postGrade.length == 0
			|| jobInfo.postGrade == "")
		$('#postGrade').val("");
	else
		$("#postGrade").val(jobInfo.postGrade);
	//借调分流单位
	if (jobInfo.jdfldw == null
			|| jobInfo.jdfldw.length == 0
			|| jobInfo.jdfldw == "")
		$('#jdfldw').val("");
	else
	$("#jdfldw").val(jobInfo.jdfldw);
	//借调分流时间
	if (jobInfo.jdflTime == null
			|| jobInfo.jdflTime.length == 0
			|| jobInfo.jdflTime == "")
		$('#jdflTime').val("");
	else
		$("#jdflTime").val(jobInfo.jdflTime);
	//离岗待退时间
	if (jobInfo.postBack == null
			|| jobInfo.postBack.length == 0
			|| jobInfo.postBack == "")
		$('#postBack').val("");
	else
		$("#postBack").val(jobInfo.postBack);
	
	//备注
	$('#remark').val(jobInfo.remark);
	
	//是否是特岗教师
	$('#tgjs').val(jobInfo.tgjs);
	//继续教育编号
	if (jobInfo.jxjybh == null
		|| jobInfo.jxjybh.length == 0
		|| jobInfo.jxjybh == "")
		$('#jxjybh').val("");
	else
		$('#jxjybh').val(jobInfo.jxjybh);
	//荣誉称号
	if (jobInfo.rych == null
		|| jobInfo.rych.length == 0
		|| jobInfo.rych == "")
	$('#rych').val("");
	else
	$('#rych').val(jobInfo.rych);
	
	eduJobId = jobInfo.id;
	
	if (jobInfo.adjustId == null
			|| jobInfo.adjustId.length == 0
			|| jobInfo.adjustId == "")
		$('#adjustId').val("");
	else {
		$('#adjustId').val(jobInfo.adjustId);
	}
	
	if (jobInfo.jobQualificationType == null
			|| jobInfo.jobQualificationType.length == 0
			|| jobInfo.jobQualificationType == "")
		$('#jobQualificationType').val("");
	else
		$('#jobQualificationType').val(jobInfo.jobQualificationType);

	if (jobInfo.jobCertificateDate == null
			|| jobInfo.jobCertificateDate.length == 0
			|| jobInfo.jobCertificateDate == "")
		$('#jobCertificateDate').val("");
	else
		$('#jobCertificateDate').val(jobInfo.jobCertificateDate);

	if (jobInfo.jobCertificateNum == null
			|| jobInfo.jobCertificateNum.length == 0
			|| jobInfo.jobCertificateNum == "")
		$('#jobCertificateNum').val("");
	else
		$('#jobCertificateNum').val(jobInfo.jobCertificateNum);

	if (jobInfo.jobWorkTime == null || jobInfo.jobWorkTime.length == 0
			|| jobInfo.jobWorkTime == "")
		$('#jobWorkTime').val("");
	else
		$('#jobWorkTime').val(jobInfo.jobWorkTime);

	if (jobInfo.jobWorkDate == null || jobInfo.jobWorkDate.length == 0
			|| jobInfo.jobWorkDate == "")
		$('#jobWorkDate').val("");
	else
		$('#jobWorkDate').val(jobInfo.jobWorkDate);

	if (jobInfo.jobCommentPositionType == null
			|| jobInfo.jobCommentPositionType.length == 0
			|| jobInfo.jobCommentPositionType == "")
		$('#jobCommentPosition').val("");
	else
		$('#jobCommentPosition').val(jobInfo.jobCommentPositionType);

	if (jobInfo.jobCommentDate == null || jobInfo.jobCommentDate.length == 0
			|| jobInfo.jobCommentDate == "")
		$('#jobCommentDate').val("");
	else
		$('#jobCommentDate').val(jobInfo.jobCommentDate);

	if (jobInfo.jobRecruitmentPositionType == null
			|| jobInfo.jobRecruitmentPositionType.length == 0
			|| jobInfo.jobRecruitmentPositionType == "")
		$('#jobRecruitmentPosition').val("");
	else
		$('#jobRecruitmentPosition').val(jobInfo.jobRecruitmentPositionType);

	if (jobInfo.jobRecruitmentDate == null
			|| jobInfo.jobRecruitmentDate.length == 0
			|| jobInfo.jobRecruitmentDate == "")
		$('#jobRecruitmentDate').val("");
	else
		$('#jobRecruitmentDate').val(jobInfo.jobRecruitmentDate);

    if (jobInfo.jobSchoolAdministrationOfficeType == null
			|| jobInfo.jobSchoolAdministrationOfficeType.length == 0
			|| jobInfo.jobSchoolAdministrationOfficeType == "")
		$('#jobSchoolAdministrationOfficeType').val("");
	else
		$('#jobSchoolAdministrationOfficeType').val(
				jobInfo.jobSchoolAdministrationOfficeType);

    //查询指定学段学科
	qrySubject(jobInfo.sectionDictionaryCode, "");
	$('input:radio[name="jobFormerTeachingSectionType"][value=' + jobInfo.jobFormerTeachingSectionType + ']')
			.attr("checked", 'checked');

	//教师学科设置
	if (jobInfo.jobFormerTeachingSubjectType == null
			|| jobInfo.jobFormerTeachingSubjectType.length == 0
			|| jobInfo.jobFormerTeachingSubjectType == "")
		$('#jobFormerTeachingSubject').val("");
	else {
		var subjectStr = jobInfo.jobFormerTeachingSubjectType;
		var subjectArray = subjectStr.split(",");
		for(var i = 0; i< subjectArray.length; i++) {
			$('input:checkbox[name="jobFormerTeachingSubjectType"][value=' + subjectArray[i] + ']')
			.attr("checked", 'checked');
		}
	}

	//学科带头人
	/*$(
			'input:radio[name="jobSubjectLeader"][value=' + jobInfo.jobSubjectLeader + ']')
			.attr("checked", 'checked');*/

	//是否骨干教师：
	$('#jobCoreTeacher').val(jobInfo.jobCoreTeacherType);
	/*$(
			'input:radio[name="jobCoreTeacher"][value=' + jobInfo.jobCoreTeacher + ']')
			.attr("checked", 'checked');*/

	//是否为特级教师
	$(
			'input:radio[name="jobWhetherGradeTeacher"][value=' + jobInfo.jobWhetherGradeTeacher + ']')
			.attr("checked", 'checked');

	//国培计划农村骨干
	$(
			'input:radio[name="jobCountyRuralTeacher"][value=' + jobInfo.jobCountyRuralTeacher + ']')
			.attr("checked", 'checked');

	$(
			'input:radio[name="jobWhetherTeacher"][value=' + jobInfo.jobWhetherTeacher + ']')
			.attr("checked", 'checked');

	$(
			'input:radio[name="jobPrivateSchoolTeacher"][value=' + jobInfo.jobPrivateSchoolTeacher + ']')
			.attr("checked", 'checked');

	$(
			'input:radio[name="jobSpecialTeacher"][value=' + jobInfo.jobSpecialTeacher + ']')
			.attr("checked", 'checked');

}
function showWindow(url) {
	window.location.href = url;
}

function addCommonEduInfo(data) {
	var flag = "";
	switch (data.sort) {
	case 1:
		flag = "第一";
		break;
	case 2:
		flag = "第二";
		break;
	case 3:
		flag = "第三";
		break;
	default:
		flag = "其他";
	}
	var time = data.educationGraduationTime;
	var json = {
		eduIdNum : eduIdNum,
		flag : flag,
		time : time,
		educationGraduationSchool : data.educationGraduationSchool,
		educationGraduationProfession : data.educationGraduationProfession
	};
	$("#addEduPartA").tmpl(json).insertBefore("#flag");
	$("#addEduPartB").tmpl(json).insertBefore("#flag");

	//学历
	SysCode.createSelect("TEACHER_DIM_EDUCATION_BACKGROUND_DEAN", eduIdNum
			+ "_educationExperience", "<option value=''>请选择</option>");
	//学位
	SysCode.createSelect("TEACHER_DIM_DEGREE_DEAN", eduIdNum
			+ "_educationDegree", "<option value=''>请选择</option>");

	$("#" + eduIdNum + "_educationExperience")
			.val(data.educationExperienceType);
	$("#" + eduIdNum + "_educationDegree").val(data.educationDegreeType);
	//设置select educationDegree
	eduIdNum++;
	$(".select6").uedSelect( {
		width : 102
	});
}

function showCommentHistory() {
	
	$.ajax({
		url : pathHeader + "/furtheredu/edumanage/teacherComment.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
		teacherId:teacherId
		},
		success:function(data){
			if(data.success) {
				var list = data.rows;
				var infos ="" ;
				for(var i = 0 ;i<list.length;i++){
					infos += "<tr class='"+(i%2==0 ? "" : "hui" )+"'>";
					infos += "<TD width=76>项目编号：</TD>";
					infos += "<TD width=120>"+list[i].projectNo+"</TD>";
					infos += "<td width='27'>&nbsp;</td>";
					infos += "<TD width=76>项目名称：</TD>";
					infos += "<TD width=120>"+list[i].projectName+"</TD>";
					infos += "<TD width=27>&nbsp;</TD>";
					infos += "<TD width=76>起止时间：</TD>";
					var strs1 = new Date(list[i].startDate).format("yyyy-MM-dd");
					var strs2 = new Date(list[i].endDate).format("yyyy-MM-dd");
					infos += "<TD width=120>"+strs1+"<br/>"+strs2+"</TD>";
					infos += "</tr>";
					infos += "<tr class='"+(i%2==0 ? "" : "hui" )+"'>";
					infos += "<TD>是否合格：</TD>";
					infos += "<TD>"+(list[i].teacherTrainStatusName == null ? "" : list[i].teacherTrainStatusName )+"</TD><TD>&nbsp;</TD>";
					infos += "<TD>学时/学分：</TD>";
					var teacherClassPeriod = list[i].teacherClassPeriod == null ? "0" : list[i].teacherClassPeriod;
					var teacherClassScore = list[i].teacherClassScore == null ? "0" : list[i].teacherClassScore;
					infos += "<TD>"+teacherClassPeriod+"/" + teacherClassScore+"</TD><TD>&nbsp;</TD>";
					infos += "<TD>审核状态：</TD>";
					infos += "<TD>"+statusSelect(list[i].status)+"</TD></TR>";
				}
				$('#commonHis').html(infos);
			}
		}
	});
	
	function statusSelect (obj) {
		var auditStatus = "";
		if (obj == 11) {
			auditStatus = "待审核";
		} else if (obj == 12) {
			auditStatus = "审核不通过";
		} else  if (obj == 13){
			auditStatus = "通过"
		}
		return auditStatus;
	}
 }

function showJobtransferHistory() {
	$.ajax({
		url : pathHeader + "/teacher/teacherProject/jobtransferHistoryList.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
		teacherId:teacherId
		},
		success:function(data){
			if(data.success) {
				var list = data.rows;
				var infos ="" ;
				for(var i = 0 ;i<list.length;i++){
					infos += "<tr class='"+(i%2==0 ? "" : "hui" )+"'>";
					infos += "<td>操作人：</td>";
					infos += "<td width='33'>"+list[i].auditCreateBy+"</td>";
					infos += "<td width='27'>&nbsp;</td>";
					infos += "<td width='85'>操作时间：</td>";
					var strs1 = new Date(list[i].auditCreateDate).format("yyyy-MM-dd");
					infos += "<td width='97'>"+strs1+"</td>";
					infos += "<td width='63'>&nbsp;</td>";
					infos += "<td width='85'>调动详情：</td>";
					infos += "<td width='125'><a href='###' onclick='showJobChange("+list[i].id+")' class='tablelink'>【展开-查看层】</a></td>";
					infos += "</tr>";
					infos += "<tr class='"+(i%2==0 ? "" : "hui" )+"'>";
					infos += "<td width='85'>";
					infos += "<P align=left>原地区：</TD>";
					infos += "<TD colSpan=3>"+list[i].pastProvinceName +"-"+list[i].pastCityName+"-"+ list[i].pastDistrictName+"-"+ list[i].pastDistrictName+"-" +list[i].pastSchoolName+"</TD><TD>";
					infos += "<P align=left>目标地区：</TD>";
					infos += "<TD colSpan=3>"+list[i].newProvinceName +"-"+list[i].newCityName+"-"+ list[i].newDistrictName+ "-"+ list[i].newSchoolName+"</TD></TR>";
					infos += "</tr>";
				}  
				$('#Jobtransfer').html(infos);
			}
		}
	});
 }


function showAuditHistory(auditInfo) {
	 var infos ="" ;
			for(var i = 0 ;i<auditInfo.length;i++){
				var values = auditInfo[i];
				var auditTime = new Date(values.auditDate).format("yyyy-MM-dd");
				var auditStatus = "";
				if(values.auditStatus==11){
					auditStatus = "待审";
				}else if(values.auditStatus==12){
					auditStatus = "未通过";
				}else if(values.auditStatus==13){
					auditStatus = "审核通过"
				}else if(values.auditStatus==15){
					auditStatus = "自动审核通过"
				}
			   infos += "<table width='645' border='0' cellpadding='0' cellspacing='0' class='"+(i%2==0?"tab1" : "tab1 hui")+"' style='display:block;' ><tr>" +
			   " <td width='96'>审核状态：</td>"+"<td width='212'>"+auditStatus+"</td>"+
			   "<td width='10'>&nbsp;</td><td width='113'></td><td width='169'></td></tr>"+
			   "<tr>"+"<td>学校审核人：</td>"+"<td>"+values.auditAuditor+"</td>"+"<td>&nbsp;</td>"+
			   "<td>审核时间：</td>"+
			   "<td>"+auditTime+"</td>"+
			   "</tr>"+
			   "<tr>"+
			   "<td>审核意见：</td>" +"<td>"+values.auditOption+"</td>"+
			   "<td>&nbsp;</td><td></td>"+"<td></td>"+
				"</tr></table>";
			}
			return infos;
}

function showAudit(auditInfo) {
	 var infos ="" ;
			if(auditInfo != null){
				var auditTime = new Date(auditInfo.auditDate).format("yyyy-MM-dd");
				var auditStatus = "";
				if(auditInfo.status==6){
					auditStatus = "待审";
				}else if(auditInfo.status==7){
					auditStatus = "审核未通过";
				}else if(auditInfo.status >= 8) {
					auditStatus = "审核通过"
				}
				var auditAuditor = "";
				if(auditInfo.auditName!=null){
					auditAuditor = auditInfo.auditName;
				}else{
					auditAuditor = "";
				}
				var auditOption = "";
				if(auditInfo.memo!=null){
					auditOption = auditInfo.memo;
				}else{
					auditOption="";
				}
			   infos += "<tr>" +
			   " <td width='96'>审核状态：</td>"+"<td width='212'>"+auditStatus+"</td>"+
			   "<td width='10'>&nbsp;</td><td width='113'></td><td width='169'></td></tr>"+
			   "<tr>"+"<td>学校审核人：</td>"+"<td>"+auditAuditor+"</td>"+"<td>&nbsp;</td>"+
			   "<td>审核时间：</td>"+
			   "<td>"+auditTime+"</td>"+
			   "</tr>"+
			   "<tr>"+
			   "<td>审核意见：</td>" +"<td>"+auditOption+"</td>"+
			   "<td>&nbsp;</td><td></td>"+"<td></td>"+
				"</tr>";
			}
			return infos;
}

function goback() {
	var openUrl = toUrlById(click);
	showWindow(openUrl);
}

function showWindow(url) {
	window.location.href = url;
}

function savePhoto() {
	
	var url = pathHeader + "/person/savePhoto.do";
	var imgUrl=$("#imageSrcTemp").val();
	if(imgUrl == null || imgUrl == ''){
		imgUrl = "/photo/u8_normal.jpg";
	}
	$.ajax({
		url:url,
		data:{
			imgUrl:imgUrl,
			teacherId : teacherId
		},
		async:false,
		type:"post",
		success:function(data){
			if(data.success) {
				alert("修改成功");
				
			}else {
				alert("修改失败");
			}
			
		},
		error:function(){
			
		}
		
	});
	window.location.reload();
}