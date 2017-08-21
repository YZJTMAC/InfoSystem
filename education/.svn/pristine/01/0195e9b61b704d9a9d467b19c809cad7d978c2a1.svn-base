/*var teacherId = 0;
var eduBaseId = 0;
var eduJobId = 0;

var openFlagB = false;
var openFlagC = false;
var openFlagD = false;

var saveFlagB = false;
var saveFlagC = false;
var saveFlagD = false;*/

$(function(){
		
	/*$('.click').click(function(){
		if(validateTeacherId()) {
			$("#div" + $(this).attr("id")).toggle();
			if($(this).attr("id") == 'B') {
				openFlagB = openFlagB ? false:true;
			}
			if($(this).attr("id") == 'C') {
				openFlagC = openFlagC ? false:true;
			}
			if($(this).attr("id") == 'D') {
				openFlagD = openFlagD ? false:true;
			}
		}
	});*/
	
//教师资格种类
	SysCode.createSelect("TEACHER_QUALIFICATION_TYPE", "jobQualificationType", "<option value=''>请选择</option>");
	
	//教师状态
	SysCode.createSelect("TEACHER_STATUS", "status", "<option value=''>请选择</option>");
	
	//(聘)教师职称
	SysCode.createSelect("PROJECT_DIM_PROFESSIONAL_TITLE", "jobRecruitmentPosition", "<option value=''>请选择</option>");
	
	//(评)教师职称
	SysCode.createSelect("PROJECT_DIM_PROFESSIONAL_TITLE", "jobCommentPosition", "<option value=''>请选择</option>");
	
	// 教师编制
	SysCode.createSelect("TEACHER_STAFF", "adjustId", "<option value=''>请选择</option>");
	
	// 教师行政职位
	SysCode.createSelect("TEACHER_OFFICE_TYPE", "jobSchoolAdministrationOfficeType", "<option value=''>请选择</option>");
	
	// 政治面貌
	SysCode.createSelect("TEACHER_DIM_EDUCATION_POLITICAL_STATUS", "teacherPoliticalStatus", "<option value=''>请选择</option>");
	
//	queryDic('project_subject', 'subjectList');
	
	// 特岗教师类别
	SysCode.createSelect("TEACHER_DIM_TGJS", "tgjs", "<option value=''>请选择</option>");
	
	// 免费师范生
	SysCode.createSelect("TEACHER_DIM_MFSFS", "mfsfs", "<option value=''>请选择</option>");
	
	// 普通话等级
	SysCode.createSelect("TEACHER_DIM_PTHDJ", "pthdj", "<option value=''>请选择</option>");
	
	// 教师资格证种类
	SysCode.createSelect("TEACHER_DIM_JSZGZ", "jszgz", "<option value=''>请选择</option>");
	
	// 合同签订情况
	SysCode.createSelect("TEACHER_DIM_CONTRACT", "contract", "<option value=''>请选择</option>");
	
	// 岗位类别
	SysCode.createSelect("TEACHER_DIM_GWLB", "gwlb", "<option value=''>请选择</option>");
	
	// 岗位等级
	SysCode.createSelect("TEACHER_DIM_GWDJ", "gwdj", "<option value=''>请选择</option>");
	
	// 岗位等级
	SysCode.createSelect("TEACHER_DIM_COUNTRY", "country", "<option value=''>请选择</option>");
	
	queryDic('project_subject', 'subjectList');
	
	queryDic('stduty_section', 'sectionList');
	
	showTeacherInfo(teacherId);
});

/**
 * 查询字典表
 */
function queryDic(dicType, id){
	var url = pathHeader+ "/sys/queryDicByType.do";
	$.ajax({
		url:url,
		data:{dicType:dicType},
		type:"post",
		async:false,
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList, function(index,element) {
												
					gridHtml += "<span style=\"float: left;\">";
					if(dicType == "project_subject") {
						gridHtml += "<INPUT disabled='disabled' name='jobFormerTeachingSubjectType' value='"+element.dictionaryId+"' type='checkbox' >";
					} else {
						gridHtml += "<INPUT disabled='disabled' name='jobFormerTeachingSectionType' value='"+element.dictionaryId+"' type='radio' >";
					}
					gridHtml += element.dictionaryName;
					gridHtml += "</span>";
				});
				$('#' + id).append(gridHtml);
			} else {
			}
		},
		error:function(){
			
		}
	});
}

/*function createCommonOpt(rows,sid){
	for(var i = 0;i<rows.length;i++){
		var opt = "<option value='"+rows[i].id+"' ";
		opt += ">"+rows[i].text+"</option>";
		$("#"+sid).append(opt);
	}
}

function validateTeacherId(obj) {
	if(teacherId == 0) {
			jQuery.generalAlert("请先填写并保存登录信息！");
			return false;
	} else {
			return true;
	}
}

var provinceId = null;
var provinceName= null;
var cityId= null;
var cityName= null;
var districtId= null;
var districtName = null;
		
*//**
 * 最后确认, 个开发人 自己实现
 *//*
function lastForSure() {
	if(lastSelect != null && lastSelect.length > 0) {
		var tempArray = chilkQueryConditionArray;
		$(tempArray).each(function(index,element) {
			if(element != null && element.length >0) {
				var temp = element.split("_");
				if(temp[1] == "provinceId") {
					provinceId = temp[0];
					provinceName = temp[2];
				} else if(temp[1] == "cityId") {
					cityId = temp[0];
					cityName = temp[2];
				} else if(temp[1] == "districtId") {
					districtId = temp[0];
					districtName = temp[2];
				} 
				
			}
		})
		var conditionArray = lastSelect.split("_");
		var belone = conditionArray[0];
		var areaA = conditionArray[1]
		var text = conditionArray[2]
		$('#selectSchoolId').val(belone);
		$('#schoolName').val(text);
	}
	clear();
}

function validateInfo(data) {
	var flag = false;
	flag = validateAndShowTip.validateAccount(data.loginAccount, 0, 10)? true : false;
	if(!flag) {return flag;}
	
	flag = validateAndShowTip.validatePaswd(data.password, 0, 10)? true : false;
	if(!flag) {return flag;}
	
	flag = validateAndShowTip.validateRealName(data.realName, 0, 10)? true : false;
	if(!flag) {return flag;}
	
	flag = data.gender != '' ? true : false;
	if(!flag) {jQuery.generalAlert("请选择性别！");return flag;}
	
	flag = data.status != 0 ? true : false;
	if(!flag) {jQuery.generalAlert("请选择用户状态！");return flag;}
	
	flag = validateAndShowTip.validateIdNumb(data.idNumber, 0, 18)? true : false;
	if(!flag) {return flag;}
	
	flag = validateAndShowTip.validateTeacherNo(data.teacherNo, 0, 10)? true : false;
	if(!flag) {return flag;}
	
	flag = data.schoolId != 0? true : false;
	if(!flag) {jQuery.generalAlert("请选择学校！");return flag;}
	
	return flag;
}
function saveA(){
	
	var obj = $("#from1").serialize();
	$user = {
		id:teacherId,
		loginAccount:$('#loginAccount').val(),
		password:$('#password').val(),
		realName:$('#realName').val(),
		gender:$('#gender').val(),
		status:$('#status').val(),
		idNumber:$('#idNumber').val(),
		teacherNo:$('#teacherNo').val(),
		schoolId:$('#selectSchoolId').val(),
		userProvinceId:provinceId,
		userProvinceName:provinceName,
		userCityId:cityId,
		userCityName:cityName,
		userDistrictId:districtId,
		userDistrictName:districtName
	}
	if(!validateInfo($user)) {
		return false;
	}
	
	$.ajax( {
			type : "POST",
			url : pathHeader + "/teacher/teachermanage/saveTeacher.do",
			data:{data: $.toJSON($user)},
			async : true,
			success : function(msg) {
				if (msg.success) {
					 if(msg.userId == 0) {
						 jQuery.generalAlert("用户修改成功！");
					 } else if(msg.userId > 0){
						 teacherId = msg.userId;
						 jQuery.generalAlert("用户保存成功！");
					 }
				} else {
					if(msg.msg == -1) {
						jQuery.generalAlert("该用户名已经存在！");
					}
				}
 			},
			error : function() {
			}
		});
}

function saveB(){
	
	if(!openFlagB) {
		return;
	}
	
	if(saveFlagB) {
		jQuery.generalAlert("数据保存中,请勿重复提交数据");
		return;
	}
		
	if(!validateTeacherId()) {
		return false;
	}
	var teacherMaritalStatus = $('input:radio[name="teacherMaritalStatus"]:checked').val();
	$edu = {
//			id:eduBaseId,
			teacherOldName : $('#teacherOldName').val(),
			teacherMaritalStatus:teacherMaritalStatus,
			teacherNameSpelling : $('#teacherNameSpelling').val(),
			teacherBornDate : $('#teacherBornDate').val(),
			teacherPoliticalStatus : $('#teacherPoliticalStatus').val(),
			teacherNativePlace : $('#teacherNativePlace').val(),
			teacherNation : $('#teacherNation').val(),
			teacherPhoneNum : $('#teacherPhoneNum').val(),
			teacherCallNum : $('#teacherCallNum').val(),
			teacherQq : $('#teacherQq').val(),
			teacherEmail : $('#teacherEmail').val(),
			teacherFamilyLocal : $('#teacherFamilyLocal').val(),
			teacherHealthCondition : $('#teacherHealthCondition').val(),
			 teacherId:teacherId
	};
	saveFlagB = true;
	$.ajax( {
			type : "POST",
			url : pathHeader + "/teacher/teachermanage/saveTeacherBaseInfo.do",
			data:{data: $.toJSON($edu)},
			async : true,
			success : function(msg) {
				if (msg.success) {
					 if(msg.eduBaseId == 0) {
						 jQuery.generalAlert("基本信息修改成功！");
					 } else if(msg.eduBaseId > 0){
						 eduBaseId = msg.eduBaseId;
						 jQuery.generalAlert("基本信息保存成功！");
					 }
				} else {
					
				}
				saveFlagB = false;
 			},
			error : function() {
 				saveFlagB = false;
			}
		});
}

function saveC(){
	if(!openFlagC) {
		return;
	}
	
	if(saveFlagC) {
		jQuery.generalAlert("数据保存中,请勿重复提交数据");
		return;
	}
	
	if(!validateTeacherId()) {
		return false;
	}
	var eduInfoList = [];
	$(".eduInfo").each(function(){
    	var idStr = $(this).attr("id");
    	$eduInfo = {
			 teacherId:teacherId,
			 educationExperienceType:$('#'+idStr+'_educationExperience').val(),
			 educationExperience:getSelected(idStr+'_educationExperience').text,
			 educationDegree:getSelected(idStr+'_educationDegree').text,
			 educationDegreeType:$('#'+idStr+'_educationDegree').val(),
			 educationGraduationTime:$('#'+idStr+'_educationGraduationTime').val(),
			 educationGraduationSchool:$('#'+idStr+'_educationGraduationSchool').val(),
			 educationGraduationProfession:$('#'+idStr+'_educationGraduationProfession').val(),
			 sort:idStr
		};
		eduInfoList.push($eduInfo);
  	});


	$edu = {
	 	teacherId:teacherId,
		eduInfoList : eduInfoList
	};
	
	saveFlagC = true;
	$.ajax( {
			type : "POST",
			url : pathHeader + "/teacher/teachermanage/saveTeacherEdu.do",
			data:{data: $.toJSON($edu)},
			async : true,
			success : function(msg) {
				if (msg.success) {
					 jQuery.generalAlert("教育经历保存成功！");
				} else {
					
				}
				saveFlagC = false;
 			},
			error : function() {
				saveFlagC = false;
			}
		});
}

function saveD(){
	if(!openFlagD) {
		return;
	}
	
	if(saveFlagD) {
		jQuery.generalAlert("数据保存中,请勿重复提交数据");
		return;
	}
		
	if(!validateTeacherId()) {
		return false;
	}
	var jobFormerTeachingSectionType = $('input:radio[name="jobFormerTeachingSectionType"]:checked').val(); 
	var jobFormerTeachingSection = $('input:radio[name="jobFormerTeachingSectionType"]:checked').parent().text();
	
	var jobFormerTeachingSubjectType = "";
	var jobFormerTeachingSubject = "";
	$("input[name='jobFormerTeachingSubjectType']:checkbox:checked").each(function(){ 
		jobFormerTeachingSubjectType += $(this).val() + ",";
		jobFormerTeachingSubject += $(this).parent().text() +",";
	});
	jobFormerTeachingSubjectType = jobFormerTeachingSubjectType.substring(0,jobFormerTeachingSubjectType.length -1);
	jobFormerTeachingSubject = jobFormerTeachingSubject.substring(0,jobFormerTeachingSubject.length -1); 
	
	var jobSubjectLeader = $('input:radio[name="jobSubjectLeader"]:checked').val();
	var jobCoreTeacher = $('input:radio[name="jobCoreTeacher"]:checked').val();
	var jobWhetherTeacher = $('input:radio[name="jobWhetherTeacher"]:checked').val();
	var jobWhetherGradeTeacher = $('input:radio[name="jobWhetherGradeTeacher"]:checked').val();
	var jobCountyRuralTeacher = $('input:radio[name="jobCountyRuralTeacher"]:checked').val();
	var jobPrivateSchoolTeacher = $('input:radio[name="jobPrivateSchoolTeacher"]:checked').val();
	var jobSpecialTeacher = $('input:radio[name="jobSpecialTeacher"]:checked').val();
	$job = {
//			id:eduJobId,
			jobQualificationType : $('#jobQualificationType').val(),
			jobQualification:getSelected('jobQualificationType').text,
			jobCertificateDate: $('#jobCertificateDate').val(),
			jobCertificateNum : $('#jobCertificateNum').val(),
			jobWorkTime : $('#jobWorkTime').val(),
			jobWorkDate : $('#jobWorkDate').val(),
	    	jobCommentPositionType: $('#jobCommentPosition').val(),
			jobCommentPosition:getSelected('jobCommentPosition').text,
	    	jobCommentDate : $('#jobCommentDate').val(),
	    	jobRecruitmentPositionType: $('#jobRecruitmentPosition').val(),
	    	jobRecruitmentPosition:getSelected('jobRecruitmentPosition').text,
	    	jobRecruitmentDate: $('#jobRecruitmentDate').val(),
	    	jobSchoolAdministrationOffice: $('#jobSchoolAdministrationOffice').val(),
	    	
	    	teacherId:teacherId,
	    	jobFormerTeachingSection:jobFormerTeachingSection,
	    	jobFormerTeachingSubjectType:jobFormerTeachingSubjectType,
	    	jobFormerTeachingSubject:jobFormerTeachingSubject,
	    	jobFormerTeachingSectionType: jobFormerTeachingSectionType,
	    	jobSubjectLeader: jobSubjectLeader,
	    	jobCoreTeacher: jobCoreTeacher,
	    	jobWhetherTeacher: jobWhetherTeacher,
	    	jobWhetherGradeTeacher: jobWhetherGradeTeacher,
	    	jobCountyRuralTeacher: jobCountyRuralTeacher,
	    	jobPrivateSchoolTeacher: jobPrivateSchoolTeacher,
	    	jobSpecialTeacher: jobSpecialTeacher
	};
	
	saveFlagD = true;
	$.ajax( {
			type : "POST",
			url : pathHeader + "/teacher/teachermanage/saveTeacherJob.do",
			data:{data: $.toJSON($job)},
			async : true,
			success : function(msg) {
				if (msg.success) {
					 if(msg.eduJobId == 0) {
						 jQuery.generalAlert("工作经历修改成功！");
					 } else if(msg.eduJobId > 0){
						 eduJobId = msg.eduJobId;
						 jQuery.generalAlert("工作经历保存成功！");
					 }
				} else {
					
				}
				saveFlagD = false;
 			},
			error : function() {
				saveFlagD = false; 
			}
		});
}
*/ 
var eduIdNum = 1;
/*$(function() {
	$('#addBranchArea').click(	function() {
		addEduInfo();
	});

	$('.deleteEdu').live('click', function() {
		$(this).parent().parent().next().remove();
		$(this).parent().parent().remove();
		eduIdNum--;
		if (eduIdNum <= 0) {
			eduIdNum = 1;
		}
	});
})

function addEduInfo() {
	var flag = "";
			switch(eduIdNum)
			{
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
			var json = {
				eduIdNum:eduIdNum, 
				flag:flag
				};
 			$("#addEduPartA").tmpl(json).insertBefore("#flag"); 
 			$("#addEduPartB").tmpl(json).insertBefore("#flag");
 			//学历
 			SysCode.createSelect("TEACHER_DIM_EDUCATION_BACKGROUND_DEAN", eduIdNum +"_educationExperience", "<option value=''>请选择</option>");
 			//学位
 			SysCode.createSelect("TEACHER_DIM_DEGREE_DEAN", eduIdNum +"_educationDegree", "<option value=''>请选择</option>");
 			eduIdNum ++;
			$(".select6").uedSelect({
			width : 102  
		});
}
*/