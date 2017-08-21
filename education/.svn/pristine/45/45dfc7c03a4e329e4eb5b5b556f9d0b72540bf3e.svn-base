$(function(){
	initAutoComplete();
//	showTeacherInfo(teacherId);
	
	$("#JobtransferHis").click(function(){
		showJobtransferHistory();
	});
	
	$("#commentHis").click(function(){
		showCommentHistory();
	});
	
	
});

/**
 * 初始化
 */
function initAutoComplete(){
	showInfoList();
}

function eduUser(data) {
	var obj = data.eduUserInfo;
				var url = pathHeader + "/teacher/teacherProject/updateTeacherPage.htm?teacherId="+obj.id;
				$("#info1").attr("href",url);
				$("#info2").attr("href",url);
				$("#info3").attr("href",url);
				$("#info4").attr("href",url);
				$("#info5").attr("href",url);
				$("#info6").attr("href",url);
				if(obj.loginAccount==null||obj.loginAccount.length==0||obj.loginAccount==""){
					$('#loginAccount').html("&nbsp;");
					
				}
				else{
					$('#loginAccount').html(obj.loginAccount);
				}
				
				if(obj.password==null||obj.password.length==0||obj.password=="")
					$('#password').html("&nbsp;");
				else
					$('#password').html(obj.password);
				
				if(obj.realName==null||obj.realName.length==0||obj.loginAccount=="")
					$('#realName').html("&nbsp;");
				else
					$('#realName').html(obj.realName);
					$('#teacherName').html(obj.realName);
				if(obj.gender==null||obj.gender.length==0){
					$('#gender').html("&nbsp;");
					}
				else{
					var sex = "";
					if(obj.gender==1){
					sex = "男";
					}else{
					sex="女";
					}
					$('#gender').html(sex);
					}
				
				if(obj.idNumber==null||obj.idNumber.length==0||obj.idNumber=="")
					$('#idNumber').html("&nbsp;");
				else
					$('#idNumber').html(obj.idNumber);
				if(obj.teacherNo==null||obj.teacherNo.length==0||obj.teacherNo=="")
					$('#teacherNo').html("&nbsp;");
				else
					$('#teacherNo').html(obj.teacherNo);
				if(obj.schoolName==null||obj.schoolName.length==0||obj.schoolName=="")
					$('#schoolName').html("&nbsp;");
				else
					$('#schoolName').html(obj.schoolName);
				
				if(obj.status==null||obj.status.length==0||obj.status=="")
					$('#status').html("&nbsp;");
				else {
					var auditStatus = "";
					if (obj.status == 6) {
						auditStatus = "未审核";
					} else if (obj.status == 7) {
						auditStatus = "审核不通过";
					} else if (obj.status == 8){
						auditStatus = "在职"
					}else if(obj.status == 31) 
						auditStatus = "已退休";
					else if(obj.status == 32) 
						auditStatus = "已死亡";
					else if(obj.status == 33) 
						auditStatus = "已离休";
					else if(obj.status == 34) 
						auditStatus = "已离岗";
					else if(obj.status == 35) 
						auditStatus = "已病休";
					$('#status').html(auditStatus);
				}
			$('#auditId').html(showAudit(obj));
			
	if(obj.userImageUrl != null || obj.userImageUrl == "") {
		$("#photo").attr("src", imageServer + obj.userImageUrl);
	}
}

function teacherBaceInfo(data){
	//				教师基本信息
				var basicInfo = data.basicInfo;
		if(basicInfo!==null){
			
			if (basicInfo.teacherCountry == null
				|| basicInfo.teacherCountry.length == 0
				|| basicInfo.teacherCountry == "")
				$('#country').html("");
			else
				$('#country').html(SysCode.getValue(basicInfo.teacherCountry,"TEACHER_DIM_COUNTRY"));
				
				if(basicInfo.teacherOldName==null||basicInfo.teacherOldName.length==0||basicInfo.teacherOldName=="")
					$('#teacherOldName').html("&nbsp;");
				else
					$('#teacherOldName').html(basicInfo.teacherOldName);
			if(basicInfo.teacherNameSpelling==null||basicInfo.teacherNameSpelling.length==0||basicInfo.teacherNameSpelling=="")
					$('#teacherNameSpelling').html("&nbsp;");
				else
					$('#teacherNameSpelling').html(basicInfo.teacherNameSpelling);
			if(basicInfo.teacherBornDate==null||basicInfo.teacherBornDate.length==0||basicInfo.teacherBornDate==""){
				$('#teacherBornDate').html("&nbsp;");
			}
			else{
				$('#teacherBornDate').html(basicInfo.teacherBornDate);
			}
			if(basicInfo.teacherPoliticalStatus==null||basicInfo.teacherPoliticalStatus.length==0||basicInfo.teacherPoliticalStatus==""){
				
					$('#teacherPoliticalStatus').html("&nbsp;");
			}
				else{
					var mianMao = SysCode.getValue(basicInfo.teacherPoliticalStatus,"TEACHER_DIM_EDUCATION_POLITICAL_STATUS");
					$('#teacherPoliticalStatus').html(mianMao);
				}
			if(basicInfo.teacherNativePlace==null||basicInfo.teacherNativePlace.length==0||basicInfo.teacherNativePlace=="")
					$('#teacherNativePlace').html("&nbsp;");
				else
					$('#teacherNativePlace').html(basicInfo.teacherNativePlace);
			if(basicInfo.teacherNation==null||basicInfo.teacherNation.length==0||basicInfo.teacherNation=="")
					$('#teacherNation').html("&nbsp;");
				else
					$('#teacherNation').html(basicInfo.teacherNation);
			if(basicInfo.teacherPhoneNum==null||basicInfo.teacherPhoneNum.length==0||basicInfo.teacherPhoneNum=="")
					$('#teacherPhoneNum').html("&nbsp;");
				else
					$('#teacherPhoneNum').html(basicInfo.teacherPhoneNum);
			if(basicInfo.teacherCallNum==null||basicInfo.teacherCallNum.length==0||basicInfo.teacherCallNum=="")
					$('#teacherCallNum').html("&nbsp;");
				else
					$('#teacherCallNum').html(basicInfo.teacherCallNum);
			if(basicInfo.teacherQq==null||basicInfo.teacherQq.length==0||basicInfo.teacherQq=="")
					$('#teacherQq').html("&nbsp;");
				else
					$('#teacherQq').html(basicInfo.teacherQq);
			if(basicInfo.teacherEmail==null||basicInfo.teacherEmail.length==0||basicInfo.teacherEmail=="")
					$('#teacherEmail').html("&nbsp;");
				else
					$('#teacherEmail').html(basicInfo.teacherEmail);
			
			if(basicInfo.teacherFamilyLocal==null||basicInfo.teacherFamilyLocal.length==0||basicInfo.teacherFamilyLocal=="")
					$('#teacherFamilyLocal').html("&nbsp;");
				else
					$('#teacherFamilyLocal').html(basicInfo.teacherFamilyLocal);
			
			if(basicInfo.teacherMaritalStatus==null||basicInfo.teacherMaritalStatus.length==0){
					$('#teacherMaritalStatus').html("&nbsp;");
			}
				else{
					var teacherMaritalStatus = "";
					if(basicInfo.teacherMaritalStatus==1){
						teacherMaritalStatus = "已婚";
					}else{
						teacherMaritalStatus = "未婚";
					}
					$('#teacherMaritalStatus').html(teacherMaritalStatus);
				}
			if(basicInfo.teacherHealthCondition==null||basicInfo.teacherHealthCondition.length==0||basicInfo.teacherHealthCondition=="")
					$('#teacherHealthCondition').html("&nbsp;");
				else
					$('#teacherHealthCondition').html(basicInfo.teacherHealthCondition);
			}
}

function jobInfo(data) {
	//教师工作信息
			var jobInfo = data.jobInfo;
			if(jobInfo!=null){
				
			//五险一金
			if (jobInfo.wxyj == null
				|| jobInfo.wxyj.length == 0
				|| jobInfo.wxyj == "")
				$('#wxyj').text("");
			else
				$('#wxyj').text(jobInfo.wxyj);
			//岗位类别
			$('#gwlb').html(SysCode.getValue(jobInfo.gwlb, "TEACHER_DIM_GWLB"));
			//岗位等级
			$('#gwdj').text(jobInfo.gwdj);
			$('#gwdj').html(SysCode.getValue(jobInfo.gwdj, "TEACHER_DIM_GWDJ"));
			//是否在编
			$('#sfzb').text( logicStr(jobInfo.sfzb));
			//签订合同情况
			$('#contract').html(SysCode.getValue(jobInfo.contract, "TEACHER_DIM_CONTRACT"));
			//月平均工资
			if (jobInfo.salary == null
				|| jobInfo.salary.length == 0
				|| jobInfo.salary == "")
				$('#salary').text("");
			else
				$('#salary').text(jobInfo.salary);  
			//教师资格证种类
			$('#jszgz').html(SysCode.getValue(jobInfo.jszgz, "TEACHER_DIM_JSZGZ"));
			//普通话等级
			$('#pthdj').html(SysCode.getValue(jobInfo.pthdj, "TEACHER_DIM_PTHDJ"));
			//从教起始年月
			if (jobInfo.cjqsny == null
				|| jobInfo.cjqsny.length == 0
				|| jobInfo.cjqsny == "")
				$('#cjqsny').text("");
			else
				$('#cjqsny').text(jobInfo.cjqsny);
			//是否是全日制师范类专业毕业
			$('#qrzsfzy').text( logicStr(jobInfo.qrzsfzy));
			//近三年培训情况
			if (jobInfo.jsnpxqk == null
				|| jobInfo.jsnpxqk.length == 0
				|| jobInfo.jsnpxqk == "")
				$('#jsnpxqk').text("");
			else
				$('#jsnpxqk').text(jobInfo.jsnpxqk);
			//是否是免费师范生
			$('#mfsfs').html(SysCode.getValue(jobInfo.mfsfs, "TEACHER_DIM_MFSFS"));
			//是否是特岗教师
			$('#tgjs').html(SysCode.getValue(jobInfo.tgjs, "TEACHER_DIM_TGJS"));
			
			//继续教育编号
			if (jobInfo.jxjybh == null
				|| jobInfo.jxjybh.length == 0
				|| jobInfo.jxjybh == "")
				$('#jxjybh').text("");
			else
				$('#jxjybh').text(jobInfo.jxjybh);
			//荣誉称号
			if (jobInfo.rych == null
				|| jobInfo.rych.length == 0
				|| jobInfo.rych == "")
			$('#rych').text("");
			else
			$('#rych').text(jobInfo.rych);
				
			if (jobInfo.adjustId == null || jobInfo.adjustId.length == 0 || jobInfo.adjustId == "")
				$('#adjustId').html("");
			else {
				$('#adjustId').html(SysCode.getValue(jobInfo.adjustId, "TEACHER_STAFF"));
			}
			
			if(jobInfo.jobQualificationType==null||jobInfo.jobQualificationType.length==0||jobInfo.jobQualificationType=="")
					$('#jobQualificationType').html("&nbsp;");
				else{
					$('#jobQualificationType').html(SysCode.getValue(jobInfo.jobQualificationType, "TEACHER_QUALIFICATION_TYPE") );
				}
			
			if(jobInfo.jobCertificateDate==null||jobInfo.jobCertificateDate.length==0||jobInfo.jobCertificateDate=="")
				$('#jobCertificateDate').html("&nbsp;");
			else
				$('#jobCertificateDate').html(jobInfo.jobCertificateDate);
			
			if(jobInfo.jobCertificateNum==null||jobInfo.jobCertificateNum.length==0||jobInfo.jobCertificateNum=="")
				$('#jobCertificateNum').html("&nbsp;");
			else
				$('#jobCertificateNum').html(jobInfo.jobCertificateNum);
			
			if(jobInfo.jobWorkTime==null||jobInfo.jobWorkTime.length==0||jobInfo.jobWorkTime=="")
				$('#jobWorkTime').html("&nbsp;");
			else
				$('#jobWorkTime').html(jobInfo.jobWorkTime);
			
			if(jobInfo.jobWorkDate==null||jobInfo.jobWorkDate.length==0||jobInfo.jobWorkDate=="")
				$('#jobWorkDate').html("&nbsp;");
			else
				$('#jobWorkDate').html(jobInfo.jobWorkDate);
			
			if(jobInfo.jobCommentPosition==null||jobInfo.jobCommentPosition.length==0||jobInfo.jobCommentPosition=="")
				$('#jobCommentPosition').html("&nbsp;");
			else
				$('#jobCommentPosition').html(jobInfo.jobCommentPosition);
			
			if(jobInfo.jobCommentDate==null||jobInfo.jobCommentDate.length==0||jobInfo.jobCommentDate=="")
				$('#jobCommentDate').html("&nbsp;");
			else
				$('#jobCommentDate').html(jobInfo.jobCommentDate);
			
			if(jobInfo.jobRecruitmentPosition==null||jobInfo.jobRecruitmentPosition.length==0||jobInfo.jobRecruitmentPosition=="")
				$('#jobRecruitmentPosition').html("&nbsp;");
			else
				$('#jobRecruitmentPosition').html(jobInfo.jobRecruitmentPosition);
			
			if(jobInfo.jobRecruitmentDate==null||jobInfo.jobRecruitmentDate.length==0||jobInfo.jobRecruitmentDate=="")
				$('#jobRecruitmentDate').html("&nbsp;");
			else
				$('#jobRecruitmentDate').html(jobInfo.jobRecruitmentDate);
			
			if(jobInfo.jobSchoolAdministrationOffice==null||jobInfo.jobSchoolAdministrationOffice.length==0||jobInfo.jobSchoolAdministrationOffice=="")
				$('#jobSchoolAdministrationOffice').html("&nbsp;");
			else
				$('#jobSchoolAdministrationOffice').html(jobInfo.jobSchoolAdministrationOffice);
			//是否名校长培养对象
			$('#eliteTraining').html(SysCode.getValue(jobInfo.eliteTrainingType, "TEACHER_DIM_MSPYDX"));
			//是否教学名师
			$('#teachingMaster').html(SysCode.getValue(jobInfo.teachingMasterType, "TEACHER_DIM_JXMS"));
			//是否学科带头人
			$('#jobSubjectLeader').html(SysCode.getValue(jobInfo.jobSubjectLeader, "TEACHER_DIM_XKDTR"));
			//是否骨干教师
			$('#jobCoreTeacher').html(SysCode.getValue(jobInfo.jobCoreTeacherType, "TEACHER_DIM_GGJS"));
			//聘任岗位等级时间
			if (jobInfo.postGrade == null
					|| jobInfo.postGrade.length == 0
					|| jobInfo.postGrade == "")
				$('#postGrade').html("&nbsp;");
			else
				$("#postGrade").html(jobInfo.postGrade);
			//借调分流单位
			if (jobInfo.jdfldw == null
					|| jobInfo.jdfldw.length == 0
					|| jobInfo.jdfldw == "")
				$('#jdfldw').html("&nbsp;");
			else
			$("#jdfldw").html(jobInfo.jdfldw);
			//借调分流时间
			if (jobInfo.jdflTime == null
					|| jobInfo.jdflTime.length == 0
					|| jobInfo.jdflTime == "")
				$('#jdflTime').html("&nbsp;");
			else
				$("#jdflTime").html(jobInfo.jdflTime);
			//离岗待退时间
			if (jobInfo.postBack == null
					|| jobInfo.postBack.length == 0
					|| jobInfo.postBack == "")
				$('#postBack').html("&nbsp;");
			else
				$("#postBack").html(jobInfo.postBack);
			//备注
			$("#remark").html(jobInfo.remark);
			if(jobInfo.jobFormerTeachingSection==null||jobInfo.jobFormerTeachingSection.length==0||jobInfo.jobFormerTeachingSection=="")
					$('#jobFormerTeachingSection').html("&nbsp;");
				else
					$('#jobFormerTeachingSection').html(jobInfo.jobFormerTeachingSection);
			
			if(jobInfo.jobFormerTeachingSubject==null||jobInfo.jobFormerTeachingSubject.length==0||jobInfo.jobFormerTeachingSubject=="")
					$('#jobFormerTeachingSubject').html("&nbsp;");
				else
					$('#jobFormerTeachingSubject').html(jobInfo.jobFormerTeachingSubject);
			
			/*if(jobInfo.jobSubjectLeader==null||jobInfo.jobSubjectLeader.length==0){
					$('#jobSubjectLeader').html("&nbsp;");
					}
				else{
					var value = "";
					if(jobInfo.jobSubjectLeader==1){
						value = "是";
					}else{
						value = "否";
					}
					$('#jobSubjectLeader').html(value);
				}*/
			
			/*if(jobInfo.jobCoreTeacher==null||jobInfo.jobCoreTeacher.length==0)
					$('#jobCoreTeacher').html("&nbsp;");
				else{
					var value = "";
					if(jobInfo.jobCoreTeacher==1){
						value = "是";
					}else{
						value = "否";
					}
					$('#jobCoreTeacher').html(value);
				}*/
			
			if(jobInfo.jobWhetherGradeTeacher==null||jobInfo.jobWhetherGradeTeacher.length==0){
					$('#jobWhetherGradeTeacher').html("&nbsp;");
			}
				else{
					var value = "";
					if(jobInfo.jobWhetherGradeTeacher==1){
						value = "是";
					}else{
						value = "否";
					}
					
					$('#jobWhetherGradeTeacher').html(value);
				}
			
			if(jobInfo.jobCountyRuralTeacher==null||jobInfo.jobCountyRuralTeacher.length==0){
					$('#jobCountyRuralTeacher').html("&nbsp;");
			}
				else{
					var value = "";
					if(jobInfo.jobCountyRuralTeacher==1){
						value = "是";
					}else{
						value = "否";
					}
					
					$('#jobCountyRuralTeacher').html(value);
				}
			
			if(jobInfo.jobWhetherTeacher==null||jobInfo.jobWhetherTeacher.length==0){
					$('#jobWhetherTeacher').html("&nbsp;");
			}
				else{
					var value = "";
					if(jobInfo.jobWhetherTeacher==1){
						value = "是";
					}else{
						value = "否";
					}
					
					$('#jobWhetherTeacher').html(value);
				}
			
			if(jobInfo.jobPrivateSchoolTeacher==null||jobInfo.jobPrivateSchoolTeacher.length==0){
					$('#jobPrivateSchoolTeacher').html("&nbsp;");
			}
				else{
					var value = "";
					if(jobInfo.jobPrivateSchoolTeacher==1){
						value = "是";
					}else{
						value = "否";
					}
					
					$('#jobPrivateSchoolTeacher').html(value);
				}
			
			if(jobInfo.jobSpecialTeacher==null||jobInfo.jobSpecialTeacher.length==0){
					$('#jobSpecialTeacher').html("&nbsp;");
			}
				else{
					var value = "";
					if(jobInfo.jobSpecialTeacher==1){
						value = "是";
					}else{
						value = "否";
					}
					
					$('#jobSpecialTeacher').html(value);
				}
			}
}

function logicStr(a) {
	if(a==1){
		return "是";
	}else{
		return "否";
	}
}


function showInfoList() {
	$.ajax({
		url : pathHeader + "/teacher/teacherProject/teacherInfoList.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
		teacherId:teacherId
		},
		success:function(data){
			if(data.success) 
			{
				//教师登录信息
				eduUser(data);
				//教师基本信息
				teacherBaceInfo(data);
				
				//教师工作信息
				jobInfo(data);
				
				

			//教育经历
			var objList = data.educationInfo;
		if(objList!=null||objList.length!=0){
			 var tableValues ="" ;
			for(var i = 0 ;i<objList.length;i++){
				var values = objList[i];
				var time = values.educationGraduationTime;
			   tableValues += "<tr>" +
				"<td width='85'>第"+values.sort+"学历："+"</td>"+"<td width='102'>"+(values.educationExperience==null?'':values.educationExperience)+"</td>"+
				"<td width='85'>获得学位："+"</td>"+"<td width='102'>"+(values.educationDegree==null?'':values.educationDegree)+"</td>"+
				"<td width='85'>毕业时间："+"</td>"+"<td width='102'>"+ (time==null ? '' : time) +"</td>"+
				"<td>&nbsp;</td>"+
				"</tr>"+
				"<tr>"+
				"<td>毕业院校："+"</td>"+"<td width='102'>"+(values.educationGraduationSchool==null?'':values.educationGraduationSchool)+"</td>"+
				"<td>毕业专业："+"</td>"+"<td width='102'>"+(values.educationGraduationProfession==null?'':values.educationGraduationProfession)+"</td>"+
				"<td>&nbsp;</td>"+
				"</tr>";
			}
			$('#educationId').html(tableValues);
		}
			
			//历次学校记录
			var schoolList = data.oldSchool;
		if(schoolList!=null||schoolList.length>0){
			 var tableValues ="" ;
			for(var i = 0 ;i<schoolList.length;i++){
				var values = schoolList[i];
				var strs = new Date(values.oldEntryTime).format("yyyy-MM-dd");
				var strs2 = new Date(values.updateDate).format("yyyy-MM-dd");
				var strs3 = new Date(values.oldTurnoverTime).format("yyyy-MM-dd");
			   tableValues += "<tr>" +
			   "<td>"+values.oldSchool+"</td>"+
			   "<td>"+strs+"</td>"+
			   "<td>" +strs3+"</td>"+
			   "<td>"+values.updateBy+"</td>"+
			   "<td>"+strs2+"</td>"+
				"</tr>";
			}
			$('#schoolId').html(tableValues);
				
		}
			//教师审核情况
			var auditHistroy = data.auditHistroy;
			if(auditHistroy!=null||auditHistroy.length>0){
				$('#auditHistry').html(showAuditHistory(auditHistroy));
			}
			}
		},
		error:function(){
			jQuery.generalAlert("查询错误");
		}
		
		
	});
}

function showTeacherComment(auditInfo) {
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
			
		}
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

//收起
function packUp(){
	$('#basicDiv').hide();
	$('#basicTitl').hide();
	$('#basicTitl1').css("display","block");
}
//展开
function backUp(){
	$('#basicDiv').show();
	$('#basicTitl').show();
	$('#basicTitl1').css("display","none");
}


//教育经历收起
function packUpTwo(){
	$('#basicTitlTwo').hide();
	$('#eduId').hide();
	$('#basicTitl2').css("display","block");
}
//教育经历展开
function backUpTwo(){
	$('#basicTitlTwo').show();
	$('#eduId').show();
	$('#basicTitl2').css("display","none");
}


//工作信息收起
function packUpThree(){
	$('#basicTitlThree').hide();
	$('#jodMessage').hide();
	$('#basicTitl3').css("display","block");
}
//工作信息展开
function backUpThree(){
	$('#basicTitlThree').show();
	$('#jodMessage').show();
	$('#basicTitl3').css("display","none");
}
function update(){
$("#userId").val();
jQuery.generalAlert("userId=="+$("#userId").val());
	}
function showWindow(url) {
	window.location.href = url;
}