$(function(){
	initAutoComplete(); 
});

/**
 * 初始化
 */
function initAutoComplete(){
	showHisInfo(); 
}


function showHisInfo() {
	$.ajax({
		url : pathHeader + "/teacher/teacherProject/teacherHisInfo.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			auditId:auditId
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
				var objListOld = data.oldEducationInfo;
				var objListNew = data.newEducationInfo;
				
				
				if(objListOld == null && objListNew == null) {
					// jQuery.generalAlert("a == null && b == null");
				} else if(objListOld != null && objListNew == null) {
					// jQuery.generalAlert("a != null && b == null");
					partB(objListOld, objListNew);
				} else if(objListOld == null && objListNew != null) {
					// jQuery.generalAlert("a == null && b != null");
					partA(objListOld, objListNew);
				} else if(objListOld.length > objListNew.length) {
					// jQuery.generalAlert("a > b");
					partD(objListOld, objListNew);
				} else if(objListOld.length < objListNew.length) {
					// jQuery.generalAlert("b > a");
					partE(objListOld, objListNew);
				} else if(objListOld.length = objListNew.length) {
					// jQuery.generalAlert("b = a");
					partC(objListOld, objListNew);
				}
				
				showDiferent() ;
				
			
			}
		},
		error:function(){
			jQuery.generalAlert("查询错误");
		}
		
		
	});
}

/**
 * 变动数组
 * @param {Object} a
 * @param {Object} b
 * @return {TypeName} 
 */
var changeArray = [];

/**
 * 比较方法
 * @param {Object} a
 * @param {Object} b
 */
function infoCompare(a, b , id) {
	if(a == null && b == null ) {
		return "";
	} else if(a != null && b == null ) {
		return "<em style='font-style:normal;'>"+a+"</em>";
	} else if(a == null && b != null ) {
		changeArray.push(id);
		return "<em style='font-style:normal;color:red'>"+b+"</em>";
	} else if(a != b){
		var htmlStr = "<i style='text-decoration:line-through; color:#999'>"+a+"</i>&nbsp;&nbsp;<em style=' font-style:normal;color:red'>"+b+"</em>";
		changeArray.push(id);
		return htmlStr;
	} else if( a == b) {
		return a;
	}
}

function showDiferent() {
	var flag = 1;
	var htmlStr = "";
	$.each(changeArray, function(index,element) {
		if(flag == 1) {
			htmlStr += "<tr>";
			htmlStr += $('#' +element + "_htm").prop("outerHTML");
			htmlStr += $('#' +element).prop("outerHTML");
			
		}
		
		if(flag == 2) {
			htmlStr += "<td width='27'>&nbsp;</td>";
			htmlStr += $('#' +element + "_htm").prop("outerHTML");
			htmlStr += $('#' +element).prop("outerHTML");
			htmlStr += "</tr>";
			flag = 1;
			return true;
		}
		
		if(index + 1 == changeArray.length) {
			htmlStr += "<td width='27'>&nbsp;</td>";
			htmlStr += "</tr>";
			flag = 1;
			return true;
		}
		flag ++;
	});
	$('#diferent').append(htmlStr);
	
}

function eduUser(data) {
	var obj = data.eduUserInfo;
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
}

//	教师基本信息
function teacherBaceInfo(data){
		var oldBasicInfo = data.oldBasicInfo;
		var newBasicInfo = data.newBasicInfo;
		if(oldBasicInfo !=null || newBasicInfo!=null){
			$('#teacherOldName').html(infoCompare(oldBasicInfo.teacherOldName, newBasicInfo.teacherOldName , "teacherOldName"));
			//拼写
			$('#teacherNameSpelling').html(infoCompare(oldBasicInfo.teacherNameSpelling, newBasicInfo.teacherNameSpelling , "teacherNameSpelling"));
			
			var teacherBornDateOld = oldBasicInfo.teacherBornDate;
			var teacherBornDateNew = newBasicInfo.teacherBornDate;
			$('#teacherBornDate').html(infoCompare(teacherBornDateOld, teacherBornDateNew , "teacherBornDate"));
			
			//政治面貌
			
			$('#teacherPoliticalStatus').html(infoCompare(getPoliticalStr(oldBasicInfo.teacherPoliticalStatus), getPoliticalStr(newBasicInfo.teacherPoliticalStatus), "teacherPoliticalStatus"));
			
			
			
			$('#teacherNativePlace').html(infoCompare(oldBasicInfo.teacherNativePlace, newBasicInfo.teacherNativePlace , "teacherNativePlace"));
			
			$('#teacherNation').html(infoCompare(oldBasicInfo.teacherNation, newBasicInfo.teacherNation , "teacherNation"));
			
			$('#teacherPhoneNum').html(infoCompare(oldBasicInfo.teacherPhoneNum, newBasicInfo.teacherPhoneNum, "teacherPhoneNum"));
			
			$('#teacherCallNum').html(infoCompare(oldBasicInfo.teacherCallNum, newBasicInfo.teacherCallNum, "teacherCallNum"));
			
			$('#teacherQq').html(infoCompare(oldBasicInfo.teacherQq, newBasicInfo.teacherQq, "teacherQq"));
			
			$('#teacherEmail').html(infoCompare(oldBasicInfo.teacherEmail, newBasicInfo.teacherEmail, "teacherEmail"));
			
			$('#teacherFamilyLocal').html(infoCompare(oldBasicInfo.teacherFamilyLocal, newBasicInfo.teacherFamilyLocal, "teacherFamilyLocal"));
			
			$('#teacherMaritalStatus').html(
				infoCompare(getMaritalStatus(oldBasicInfo.teacherMaritalStatus)
					, getMaritalStatus(newBasicInfo.teacherMaritalStatus), "teacherMaritalStatus"));
			
			$('#teacherHealthCondition').html(infoCompare(oldBasicInfo.teacherHealthCondition, newBasicInfo.teacherHealthCondition, "teacherHealthCondition"));
			// 入党时间
			var partyTimeOld = oldBasicInfo.partyTime;
			var partyTimeNew = newBasicInfo.partyTime;
			$('#partyTime').html(infoCompare(partyTimeOld, partyTimeNew, "partyTime"));
			}
}
//政治面貌
function getPoliticalStr(a) {
	//SysCode.createSelect("TEACHER_DIM_EDUCATION_POLITICAL_STATUS", "teacherPoliticalStatus", "<option value=''>请选择</option>");
	var teacherPolitical = SysCode.getJsonArray("TEACHER_DIM_EDUCATION_POLITICAL_STATUS","");	
	for(var i =0; i<teacherPolitical.length;i++ ){
		if(teacherPolitical[i].id == a){
			return teacherPolitical[i].text;
		}
	}
			}

function getMaritalStatus(a) {
			if( a == 1) {
				return "已婚";
			} else {
				return "未婚";
			}
		}
//教师工作信息
function jobInfo(data) {
	var oldJobInfo = data.oldJobInfo;
	var newJobInfo = data.newJobInfo;
	$('#adjustName').html(infoCompare(oldJobInfo.adjustName, newJobInfo.adjustName, "adjustName"));
	
	$('#jobQualification').html(infoCompare(oldJobInfo.jobQualification, newJobInfo.jobQualification, "jobQualification"));
	
	var jobCertificateDateOld = oldJobInfo.jobCertificateDate;
	var jobCertificateDateNew = newJobInfo.jobCertificateDate;
	$('#jobCertificateDate').html(infoCompare(jobCertificateDateOld, jobCertificateDateNew, "jobCertificateDate"));
	
	$('#jobCertificateNum').html(infoCompare(oldJobInfo.jobCertificateNum, newJobInfo.jobCertificateNum, "jobCertificateNum"));
	
	var jobWorkTimeOld = oldJobInfo.jobWorkTime;
	var jobWorkTimeNew = newJobInfo.jobWorkTime;
	$('#jobWorkTime').html(infoCompare(jobWorkTimeOld, jobWorkTimeNew, "jobWorkTime"));
	
	var jobWorkDateOld = oldJobInfo.jobWorkDate;
	var jobWorkDateNew = newJobInfo.jobWorkDate;
	$('#jobWorkDate').html(infoCompare(jobWorkDateOld, jobWorkDateNew, "jobWorkDate"));
	
	$('#jobCommentPosition').html(infoCompare(oldJobInfo.jobCommentPosition, newJobInfo.jobCommentPosition, "jobCommentPosition"));
	
	var jobCommentDateOld = oldJobInfo.jobCommentDate;
	var jobCommentDateNew = newJobInfo.jobCommentDate;
	$('#jobCommentDate').html(infoCompare(jobCommentDateOld, jobCommentDateNew, "jobCommentDate"));
	
	$('#jobRecruitmentPosition').html(infoCompare(oldJobInfo.jobRecruitmentPosition, newJobInfo.jobRecruitmentPosition, "jobRecruitmentPosition"));
	
	var jobRecruitmentDateOld = oldJobInfo.jobRecruitmentDate;
	var jobRecruitmentDateNew = newJobInfo.jobRecruitmentDate;
	$('#jobRecruitmentDate').html(infoCompare(jobRecruitmentDateOld, jobRecruitmentDateNew, "jobRecruitmentDate"));
	
	$('#jobSchoolAdministrationOffice').html(infoCompare(oldJobInfo.jobSchoolAdministrationOffice, newJobInfo.jobSchoolAdministrationOffice, "jobSchoolAdministrationOffice"));

	$('#jobFormerTeachingSubject').html(infoCompare(oldJobInfo.jobFormerTeachingSubject, newJobInfo.jobFormerTeachingSubject, "jobFormerTeachingSubject"));
	
	$('#jobFormerTeachingSection').html(infoCompare(oldJobInfo.jobFormerTeachingSection, newJobInfo.jobFormerTeachingSection, "jobFormerTeachingSection"));
	
	//学科带头人
	//$('#jobSubjectLeader').html(infoCompare(isTrue(oldJobInfo.jobSubjectLeader), isTrue(newJobInfo.jobSubjectLeader), "jobSubjectLeader"));
	$('#jobSubjectLeader').html(infoCompare(oldJobInfo.jobSubjectLeaderName, newJobInfo.jobSubjectLeaderName, "jobSubjectLeader"));
	
	//是否骨干教师
	//$('#jobCoreTeacher').html(infoCompare(isTrue(oldJobInfo.jobCoreTeacher), isTrue(newJobInfo.jobCoreTeacher), "jobCoreTeacher"));
	$('#jobCoreTeacher').html(infoCompare(oldJobInfo.jobCoreTeacher, newJobInfo.jobCoreTeacher, "jobCoreTeacher"));
	
	$('#jobWhetherGradeTeacher').html(infoCompare(isTrue(oldJobInfo.jobWhetherGradeTeacher), isTrue(newJobInfo.jobWhetherGradeTeacher), "jobWhetherGradeTeacher"));
	
	$('#jobCountyRuralTeacher').html(infoCompare(isTrue(oldJobInfo.jobCountyRuralTeacher), isTrue(newJobInfo.jobCountyRuralTeacher), "jobCountyRuralTeacher"));
	
	$('#jobWhetherTeacher').html(infoCompare(isTrue(oldJobInfo.jobWhetherTeacher), isTrue(newJobInfo.jobWhetherTeacher), "jobWhetherTeacher"));
	
	$('#jobPrivateSchoolTeacher').html(infoCompare(isTrue(oldJobInfo.jobPrivateSchoolTeacher), isTrue(newJobInfo.jobPrivateSchoolTeacher), "jobPrivateSchoolTeacher"));
	
	$('#jobSpecialTeacher').html(infoCompare(isTrue(oldJobInfo.jobSpecialTeacher), isTrue(newJobInfo.jobSpecialTeacher), "jobSpecialTeacher"));

	$('#jdfldw').html(infoCompare(oldJobInfo.jdfldw, newJobInfo.jdfldw, "jdfldw"));
	//是否名校长培养对象
	$('#eliteTraining').html(infoCompare(oldJobInfo.eliteTraining, newJobInfo.eliteTraining, "eliteTraining"));
	//是否教学名师
	$('#teachingMaster').html(infoCompare(oldJobInfo.teachingMaster, newJobInfo.teachingMaster, "teachingMaster"));
	//聘任岗位等级时间
	var postGradeOld = oldJobInfo.postGrade;
	var postGradeNew = newJobInfo.postGrade;
	$('#postGrade').html(infoCompare(postGradeOld, postGradeNew, "postGrade"));
	//本校任教起始时间
	var teachingTimeOld = new Date(oldJobInfo.teachingTime).format("yyyy-MM-dd");
	var teachingTimeNew = new Date(newJobInfo.teachingTime).format("yyyy-MM-dd");
	$('#teachingTime').html(infoCompare(teachingTimeOld, teachingTimeNew, "teachingTime"));
	
}

function isTrue(a) {
		if(a==1){
			return "是";
		}else{
			return "否";
		}
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
					infos += "<TD>"+list[i].teacherTrainStatusName+"</TD><TD>&nbsp;</TD>";
					infos += "<TD>学时/学分：</TD>";
					infos += "<TD>"+list[i].projectNo+"</TD><TD>&nbsp;</TD>";
					infos += "<TD>审核状态：</TD>";
					infos += "<TD>"+list[i].status+"</TD></TR>";
				}
				$('#commonHis').html(infos);
			}
		}
	});
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
					infos += "<td width='33'>"+list[i].createBy+"</td>";
					infos += "<td width='27'>&nbsp;</td>";
					infos += "<td width='85'>操作时间：</td>";
					var strs1 = new Date(list[i].createDate).format("yyyy-MM-dd");
					infos += "<td width='97'>"+strs1+"</td>";
					infos += "<td width='63'>&nbsp;</td>";
					infos += "<td width='85'>调动详情：</td>";
					infos += "<td width='125'><a href='#' class='tablelink'>【展开-查看层】</a></td>";
					infos += "</tr>";
					infos += "<tr class='"+(i%2==0 ? "" : "hui" )+"'>";
					infos += "<td width='85'>";
					infos += "<P align=left>原地区：</TD>";
					infos += "<TD colSpan=3>"+list[i].pastProvinceName +"-"+list[i].pastCityName+"-"+ list[i].pastDistrictName+"-"+ list[i].pastDistrictName+"-" +list[i].pastSchoolName+"</TD><TD>";
					infos += "<P align=left>目标地区：</TD>";
					infos += "<TD colSpan=3>"+list[i].newProivnceName +"-"+list[i].newCityName+"-"+ list[i].newDistrictName+ "-"+ list[i].newSchoolName+"</TD></TR>";
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
				if(values.auditStatus==1){
					auditStatus = "通过";
				}else if(values.auditStatus==0){
					auditStatus = "未通过";
				}else {
					auditStatus = "审核中"
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
			for(var i = 0 ;i<auditInfo.length;i++){
				var values = auditInfo[i];
				var auditTime = new Date(values.auditDate).format("yyyy-MM-dd");
				var auditStatus = "";
				if(values.auditStatus==1){
					auditStatus = "通过";
				}else if(values.auditStatus==0){
					auditStatus = "未通过";
				}else {
					auditStatus = "审核中"
				}
				var auditAuditor = "";
				if(values.auditAuditor!=null){
					auditAuditor = values.auditAuditor;
				}else{
					auditAuditor = "";
				}
				var auditOption = "";
				if(values.auditOption!=null){
					auditOption = values.auditOption;
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

function partE(objListOld, objListNew) {
	var tableValues ="" ;
	for(var i = 0 ;i<objListNew.length;i++){
		var oldValues = objListOld[i];
		var newValues = objListNew[i];
		var oldtime = null;
		var newtime = newValues.educationGraduationTime;
		if(oldValues != null ) {
			var oldtime = oldValues.educationGraduationTime;
		}
		
	   tableValues += "<tr>" +
		"<td width='85' id='educationExperience_"+newValues.sort+"_htm'>第"+newValues.sort+"学历："+"</td>"+"<td width='102' id='educationExperience_"+newValues.sort+"'>"+infoCompare((oldValues == null ? null : oldValues.educationExperience), 
			newValues.educationExperience, 'educationExperience_'+newValues.sort)+"</td>"+
		"<td width='85' id='educationDegree_"+newValues.sort +"_htm'>获得学位："+"</td>"+"<td width='102' id='educationDegree_"+newValues.sort +"'>"+infoCompare((oldValues == null ? null : oldValues.educationDegree), newValues.educationDegree, 'educationDegree_'+newValues.sort)+"</td>"+
		"<td width='85' id='educationGraduationTime_"+newValues.sort +"_htm'>毕业时间："+"</td>"+"<td width='102' id='educationGraduationTime_"+newValues.sort +"'>"+infoCompare(oldtime, newtime, 'educationGraduationTime_'+newValues.sort)+"</td>"+
		"<td>&nbsp;</td>"+
		"</tr>"+
		"<tr>"+
		"<td id='educationGraduationSchool_"+newValues.sort+"_htm'>毕业院校："+"</td>"+"<td width='102' id='educationGraduationSchool_"+newValues.sort+"'>"+infoCompare((oldValues == null ? null : oldValues.educationGraduationSchool), newValues.educationGraduationSchool, 'educationGraduationSchool_'+newValues.sort)+"</td>"+
		"<td id='educationGraduationProfession_"+newValues.sort+"_htm'>毕业专业："+"</td>"+"<td width='102' id='educationGraduationProfession_"+newValues.sort+"'>"+infoCompare((oldValues == null ? null : oldValues.educationGraduationProfession), newValues.educationGraduationProfession, 'educationGraduationProfession_'+newValues.sort)+"</td>"+
		"<td>&nbsp;</td>"+
		"</tr>";
	}
	$('#educationId').html(tableValues);
}

function partD(objListOld, objListNew) {
	var tableValues ="" ;
	for(var i = 0 ;i<objListOld.length;i++){
		var oldValues = objListOld[i];
		var newValues = objListNew[i];
		var oldtime = oldValues.educationGraduationTime;
		var newtime  = null;
		if(newValues != null ) {
			var newtime = newValues.educationGraduationTime;
		}
		
	   tableValues += "<tr>" +
		"<td width='85' id='educationExperience_"+oldValues.sort+"_htm'>第"+oldValues.sort+"学历："+"</td>"+"<td width='102' id='educationExperience_"+oldValues.sort+"'>"+infoCompare(oldValues.educationExperience, 
			(newValues == null ? null : newValues.educationExperience), 'educationExperience_'+oldValues.sort)+"</td>"+
		"<td width='85' id='educationDegree_"+oldValues.sort +"_htm'>获得学位："+"</td>"+"<td width='102' id='educationDegree_"+oldValues.sort +"'>"+infoCompare(oldValues.educationDegree, (newValues == null ? null :  newValues.educationDegree), 'educationDegree_'+oldValues.sort)+"</td>"+
		"<td width='85' id='educationGraduationTime_"+oldValues.sort+"_htm'>毕业时间："+"</td>"+"<td width='102' id='educationGraduationTime_"+oldValues.sort+"'>"+infoCompare(oldtime, newtime, 'educationGraduationTime_'+oldValues.sort)+"</td>"+
		"<td>&nbsp;</td>"+
		"</tr>"+
		"<tr>"+
		"<td id='educationGraduationSchool_"+oldValues.sort+"_htm'>毕业院校："+"</td>"+"<td width='102' id='educationGraduationSchool_"+oldValues.sort+"'>"+infoCompare(oldValues.educationGraduationSchool, (newValues == null ? null :  newValues.educationGraduationSchool), 'educationGraduationSchool_'+oldValues.sort)+"</td>"+
		"<td id='educationGraduationProfession_"+oldValues.sort+"_htm'>毕业专业："+"</td>"+"<td width='102' id='educationGraduationProfession_"+oldValues.sort+"'>"+infoCompare(oldValues.educationGraduationProfession, (newValues == null ? null :  newValues.educationGraduationProfession), 'educationGraduationProfession_'+oldValues.sort)+"</td>"+
		"<td>&nbsp;</td>"+
		"</tr>";
	}
	$('#educationId').html(tableValues);
}

function partA(objListOld, objListNew) {
	var tableValues ="" ;
	for(var i = 0 ;i<objListOld.length;i++){
		var newValues = objListNew[i];
		var oldtime = newValues.educationGraduationTime;
		
	   tableValues += "<tr>" +
		"<td width='85' id='educationExperience_"+newValues.sort+"_htm'>第"+newValues.sort+"学历："+"</td>"+"<td width='102' id='educationExperience_"+newValues.sort+"'><em style=' font-style:normal;color:red'>"+newValues.educationExperience+"</em></td>"+
		"<td width='85' id='educationDegree_"+newValues.sort +"_htm'>获得学位："+"</td>"+"<td width='102' id='educationDegree_"+newValues.sort +"'><em style=' font-style:normal;color:red'>"+newValues.educationDegree+"</em></td>"+
		"<td width='85' id='educationGraduationTime_"+newValues.sort +"_htm'>毕业时间："+"</td>"+"<td width='102' id='educationGraduationTime_"+newValues.sort +"'><em style=' font-style:normal;color:red'>"+oldtime+"</td>"+
		"<td>&nbsp;</td>"+
		"</tr>"+
		"<tr>"+
		"<td id='educationGraduationSchool_"+newValues.sort +"_htm'>毕业院校："+"</td>"+"<td width='102' id='educationGraduationSchool_"+newValues.sort +"'><em style=' font-style:normal;color:red'>"+newValues.educationGraduationSchool+"</em></td>"+
		"<td id='educationGraduationProfession_"+newValues.sort +"_htm'>毕业专业："+"</td>"+"<td width='102' id='educationGraduationProfession_"+newValues.sort +"'><em style=' font-style:normal;color:red'>"+newValues.educationGraduationProfession+"</em></td>"+
		"<td>&nbsp;</td>"+
		"</tr>";
	}
	$('#educationId').html(tableValues);
}

function partB(objListOld, objListNew) {
	var tableValues ="" ;
	for(var i = 0 ;i<objListOld.length;i++){
		var oldValues = objListOld[i];
		var oldtime = oldValues.educationGraduationTime;
		
	   tableValues += "<tr>" +
		"<td width='85' id='educationExperience_"+oldValues.sort+"_htm'>第"+oldValues.sort+"学历："+"</td>"+"<td width='102'>"+oldValues.educationExperience+"</td>"+
		"<td width='85' id='educationDegree_"+oldValues.sort +"_htm'>获得学位："+"</td>"+"<td width='102'>"+oldValues.educationDegree+"</td>"+
		"<td width='85'>毕业时间："+"</td>"+"<td width='102'>"+oldtime+"</td>"+
		"<td>&nbsp;</td>"+
		"</tr>"+
		"<tr>"+
		"<td>毕业院校："+"</td>"+"<td width='102'>"+oldValues.educationGraduationSchool+"</td>"+
		"<td>毕业专业："+"</td>"+"<td width='102'>"+oldValues.educationGraduationProfession+"</td>"+
		"<td>&nbsp;</td>"+
		"</tr>";
	}
	$('#educationId').html(tableValues);
}

function partC(objListOld, objListNew) {
	var tableValues ="" ;
	for(var i = 0 ;i<objListOld.length;i++){
		var oldValues = objListOld[i];
		var newValues = objListNew[i];
		var oldtime = oldValues.educationGraduationTime;
		var newtime = newValues.educationGraduationTime;
		
	   tableValues += "<tr>" +
		"<td width='85' id='educationExperience_"+oldValues.sort+"_htm'>第"+oldValues.sort+"学历："+"</td>"+"<td width='102' id='educationExperience_"+oldValues.sort+"' >"+infoCompare(oldValues.educationExperience, newValues.educationExperience, 'educationExperience_'+oldValues.sort)+"</td>"+
		"<td width='85' id='educationDegree_"+oldValues.sort +"_htm'>获得学位："+"</td>"+"<td width='102' id='educationDegree_"+oldValues.sort +"'>"+infoCompare(oldValues.educationDegree, newValues.educationDegree, 'educationDegree_'+oldValues.sort)+"</td>"+
		"<td width='85' id='educationGraduationTime_"+oldValues.sort+"_htm'>毕业时间："+"</td>"+"<td width='102' id='educationGraduationTime_"+oldValues.sort+"'>"+infoCompare(oldtime, newtime, 'educationGraduationTime_'+oldValues.sort)+"</td>"+
		"<td>&nbsp;</td>"+
		"</tr>"+
		"<tr>"+
		"<td id='educationGraduationSchool_"+oldValues.sort+"_htm'>毕业院校："+"</td>"+"<td width='102' id='educationGraduationSchool_"+oldValues.sort+"'>"+infoCompare(oldValues.educationGraduationSchool, newValues.educationGraduationSchool, 'educationGraduationSchool_'+oldValues.sort)+"</td>"+
		"<td id='educationGraduationProfession_"+oldValues.sort+"_htm'>毕业专业："+"</td>"+"<td width='102' id='educationGraduationProfession_"+oldValues.sort+"'>"+infoCompare(oldValues.educationGraduationProfession, newValues.educationGraduationProfession, 'educationGraduationProfession_'+oldValues.sort)+"</td>"+
		"<td>&nbsp;</td>"+
		"</tr>";
	}
	$('#educationId').html(tableValues);
}