var teacherId = 0;
var eduBaseId = 0;
var eduJobId = 0;

var openFlagB = false;
var openFlagC = false;
var openFlagD = false;

var saveFlagB = false;
var saveFlagC = false;
var saveFlagD = false;

function showUploadPhoto() {
	$(".tip14").fadeIn(200);
}

$(function(){
	
	
	$(".true2").click(function() {
		$("#imageSrc").val($("#imageSrcTemp").val());
		$("#photo").attr("src", $("#photoTemp").attr("src"));
		$(".tip14").fadeOut(200);
	});
	
	$(".cancl").click(function() {
		$(".tip14").fadeOut(200);
	});
	
	$(".tiptop17 a").click(function() {
		 $(".tip14").fadeOut(200);
	});
	
	$('.click').click(function(){
//		if(validateTeacherId()) {
			$("#div" + $(this).attr("id")).toggle();
			if($(this).attr("id") == 'B') {
				openFlagB = openFlagB ? false:true;
				if(openFlagB) {
					$(this).children().attr("src", pathHeader + "/images/btn_shrink.gif");
				} else {
					$(this).children().attr("src", pathHeader + "/images/btn_spread.gif");
				}
			}
			if($(this).attr("id") == 'C') {
				openFlagC = openFlagC ? false:true;
				if(openFlagC) {
					$(this).children().attr("src", pathHeader + "/images/btn_shrink.gif");
				} else {
					$(this).children().attr("src", pathHeader + "/images/btn_spread.gif");
				}
			}
			if($(this).attr("id") == 'D') {
				openFlagD = openFlagD ? false:true;
				if(openFlagD) {
					$(this).children().attr("src", pathHeader + "/images/btn_shrink.gif");
				} else {
					$(this).children().attr("src", pathHeader + "/images/btn_spread.gif");
				}
			}
//		}
	});
	
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
	
	// 国籍
	SysCode.createSelect("TEACHER_DIM_COUNTRY", "country", "<option value=''>请选择</option>");
	
	//是否名校长培养对象
	SysCode.createSelect("TEACHER_DIM_MSPYDX", "eliteTraining", "<option value=''>请选择</option>");
	//是否教学名师
	SysCode.createSelect("TEACHER_DIM_JXMS", "teachingMaster", "<option value=''>请选择</option>");
	//是否学科带头人
	SysCode.createSelect("TEACHER_DIM_XKDTR", "jobSubjectLeader", "<option value=''>请选择</option>");
	//是否骨干教师
	SysCode.createSelect("TEACHER_DIM_GGJS", "jobCoreTeacher", "<option value=''>请选择</option>");
	queryDic('stduty_section', 'sectionList');
});


function queryXueLiList(){
	var url = pathHeader+ "/org/queryXueLiList.do";
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
				//alert($(".select6.eduHis").attr("style"))
			$(".select6.eduHis").append("<option  value=''>请选择</option>");
			$.each(data.rows, function(key, value) {
				$(".select6.eduHis").append(
					"<option  value=\"" + value.dictionaryId + "\">"
					+ value.dictionaryName + "</option>");
			});
			}
		},
		error:function(){
			
		}
	});
	
}

/**
 * 查询字典表
 */
function queryDic(dicType, id){
	var url = pathHeader+ "/sys/queryDicByType.do";
	var vid = 0;
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
						gridHtml += "<INPUT name='jobFormerTeachingSubjectType'  value='"+element.dictionaryId+"' type='checkbox' >";
					} else {
						gridHtml += "<INPUT name='jobFormerTeachingSectionType' onclick='qrySubject(\""+element.dictionaryCode+"\","+element.dictionaryId+")' value='"+element.dictionaryId+"' type='radio' >";
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
/**
 * 查询学科
 */
function qrySubject(sectionName,id){
	$("#subjectList").html("");
	var url = pathHeader + "/sys/querySubject.do";
	$.ajax({
		url:url,
		data:{ sectionName:sectionName},
		type:"post",
		async:false,
		success:function(data){
			if(data.success){
				var rows = data.rows;
				if(rows.length > 0){
					var gridHtml = "";
					for(var i = 0;i<rows.length;i++){
						var obj = rows[i];
						gridHtml += "<span style=\"float: left;\">";
						gridHtml += "<INPUT name='jobFormerTeachingSubjectType'  value='"+obj.dictionaryId+"' type='checkbox' >";
						gridHtml += obj.dictionaryName;
						gridHtml += "</span>";
					}
					$("#subjectList").html(gridHtml);
				} else {
					$("#subjectList").html("未查询出相关学科");
				}
			}
		},
		error:function(){
			
		}
	});
	return flag;
}
function createCommonOpt(rows,sid){
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
		
/**
 * 最后确认, 个开发人 自己实现
 */
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
	
	/*flag = validateAndShowTip.validateAccount(data.loginAccount, 0, 10)? true : false;*/
	var userName = /^[a-zA-Z][\w]{3,19}$/;	
	flag = userName.test(data.loginAccount);
	if(!flag){
	jQuery.generalAlert("4-20位英文、数字或下划线组合，第1位必须为字母！");
	return flag;
	}
	
	flag = validateAndShowTip.validatePaswd(data.password, 0, 10)? true : false;
	if(!flag) {return flag;}
	
	flag = validateAndShowTip.validateRealName(data.realName, 0, 10)? true : false;
	if(!flag) {return flag;}
	
	flag = data.gender != '' ? true : false;
	if(!flag) {jQuery.generalAlert("请选择性别！");return flag;}
	
	flag = data.status != 0 ? true : false;
	if(!flag) {jQuery.generalAlert("请选择用户状态！");return flag;}
	
	flag = BasicValidate.isIdNumber(data.idNumber) ? true : false;
	if(!flag) {jQuery.generalAlert("身份证不符合规则");return flag;}
	
	flag = validateAndShowTip.validateTeacherNo(data.teacherNo, 0, 20)? true : false;
	if(!flag) {return flag;}
	
	flag = data.schoolId != 0? true : false;
	if(!flag) {jQuery.generalAlert("请选择学校！");return flag;}
	
	return flag;
}

function validateBaseInfo(data) {
	var flag = true;
	if(data.teacherPhoneNum.length>0){
		flag = BasicValidate.checkReceiverMobile(data.teacherPhoneNum)? true : false;
		if(!flag) {jQuery.generalAlert("请输入正确的手机号码");return flag;}
	}
	if(data.teacherQq.length>0){
		flag = BasicValidate.isFullNumber(data.teacherQq)? true : false;	
		if(!flag) {jQuery.generalAlert("QQ只允许输入正整数数字");return flag;}
	}
	return flag;
}

function saveA(){
	//if(confirm("是否保存数据 ?")){
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
		schoolName:$('#schoolName').val(),
		userImageUrl:$('#imageSrc').val(),
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
	 $('#myModal').modal('show');
	$.ajax( {
			type : "POST",
			url : pathHeader + "/teacher/teachermanage/saveTeacher.do",
			data:{data: $.toJSON($user)},
			async : true,
			success : function(msg) {
				$('#myModal').modal('hide');
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
					} else if(msg.msg == -2){
						jQuery.generalAlert("该用户身份证号码已经注册！");
					} else if(msg.msg == -3){
						jQuery.generalAlert("该教师编号已经存在！");
					} else{
						jQuery.generalAlert("教师信息保存失败 ！");
					}
				}
 			},
			error : function() {
			}
		});
	//}
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
			//入党时间
			partyTime : $("#partyTime").val(),
			teacherNativePlace : $('#teacherNativePlace').val(),
			teacherNation : $('#teacherNation').val(),
			teacherPhoneNum : $('#teacherPhoneNum').val(),
			teacherCallNum : $('#teacherCallNum').val(),
			teacherQq : $('#teacherQq').val(),
			teacherEmail : $('#teacherEmail').val(),
			teacherFamilyLocal : $('#teacherFamilyLocal').val(),
			teacherHealthCondition : $('#teacherHealthCondition').val(),
			teacherCountry:$('#country').val(),
			 teacherId:teacherId
	};
	//数据校验
	if(!validateBaseInfo($edu)) {
		return false;
	}
	saveFlagB = true;
	$('#myModal').modal('show');
	$.ajax( {
			type : "POST",
			url : pathHeader + "/teacher/teachermanage/saveTeacherBaseInfo.do",
			data:{data: $.toJSON($edu)},
			async : true,
			success : function(msg) {
				$('#myModal').modal('hide');
				if (msg.success) {
					 if(msg.eduBaseId == 0) {
						 jQuery.generalAlert("基本信息修改成功！");
					 } else if(msg.eduBaseId > 0){
						 eduBaseId = msg.eduBaseId;
						 jQuery.generalAlert("基本信息保存成功！");
					 }
				} else {
					jQuery.generalAlert("基本信息修改失败！");
				}
				saveFlagB = false;
 			},
			error : function() {
 				saveFlagB = false;
			}
		});
	//}
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
	 $('#myModal').modal('show');
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
				$('#myModal').modal('hide');
				if (msg.success) {
					 jQuery.generalAlert("教育经历保存成功！");
				} else {
					 jQuery.generalAlert("教育经历保存失败！");
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
	 $('#myModal').modal('show');
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
	
	//var jobSubjectLeader = $('input:radio[name="jobSubjectLeader"]:checked').val();
	//var jobCoreTeacher = $('input:radio[name="jobCoreTeacher"]:checked').val();
	var jobWhetherTeacher = $('input:radio[name="jobWhetherTeacher"]:checked').val();
	var jobWhetherGradeTeacher = $('input:radio[name="jobWhetherGradeTeacher"]:checked').val();
	var jobCountyRuralTeacher = $('input:radio[name="jobCountyRuralTeacher"]:checked').val();
	var jobPrivateSchoolTeacher = $('input:radio[name="jobPrivateSchoolTeacher"]:checked').val();
	var jobSpecialTeacher = $('input:radio[name="jobSpecialTeacher"]:checked').val();
	var sfzb = $('input:radio[name="sfzb"]:checked').val();
	var qrzsfzy = $('input:radio[name="qrzsfzy"]:checked').val();
	
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
	    	jobSchoolAdministrationOfficeType: $('#jobSchoolAdministrationOfficeType').val(),
	    	jobSchoolAdministrationOffice: getSelected('jobSchoolAdministrationOfficeType').text,
	    	adjustId:$('#adjustId').val(),
	    	adjustName:getSelected('adjustId').text,
	    	teacherId:teacherId,
	    	jobFormerTeachingSection:jobFormerTeachingSection,
	    	jobFormerTeachingSubjectType:jobFormerTeachingSubjectType,
	    	jobFormerTeachingSubject:jobFormerTeachingSubject,
	    	jobFormerTeachingSectionType: jobFormerTeachingSectionType,
	    	//jobSubjectLeader: jobSubjectLeader,
	    	//jobCoreTeacher: jobCoreTeacher,
	    	jobWhetherTeacher: jobWhetherTeacher,
	    	jobWhetherGradeTeacher: jobWhetherGradeTeacher,
	    	jobCountyRuralTeacher: jobCountyRuralTeacher,
	    	jobPrivateSchoolTeacher: jobPrivateSchoolTeacher,
	    	jobSpecialTeacher: jobSpecialTeacher,
	    	//五险一金
			wxyj:$("#wxyj").val(),
			//岗位类别
			gwlb:$("#gwlb").val(), 
			//岗位等级
			gwdj:$("#gwdj").val(),
			//是否在编
			sfzb:sfzb,
			//签订合同情况
			contract:$("#contract").val(),
			//月平均工资
			salary:$("#salary").val(),
			//教师资格证种类
			jszgz:$("#jszgz").val(),
			//普通话等级
			pthdj:$("#pthdj").val(),
			//从教起始年月
			cjqsny:$("#cjqsny").val(),
			//是否是全日制师范类专业毕业
			qrzsfzy:qrzsfzy,
			//近三年培训情况
			jsnpxqk:$("#jsnpxqk").val(),
			//是否是免费师范生
			mfsfs:$("#mfsfs").val(),
			//是否是特岗教师
			tgjs:$("#tgjs").val(),
			//继续教育编号
			jxjybh:$("#jxjybh").val(),
			//荣誉称号
			rych:$("#rych").val(),
			//是否名校长培养对象
			eliteTrainingType : $("#eliteTraining").val(),
			eliteTraining:getSelected('eliteTraining').text,
	    	//是否教学名师
			teachingMasterType : $("#teachingMaster").val(),
			teachingMaster:getSelected('teachingMaster').text,
			//是否学科带头人
			jobSubjectLeader : $("#jobSubjectLeader").val(),
			jobSubjectLeaderName:getSelected('jobSubjectLeader').text,
			//借调分流单位
			jdfldw : $("#jdfldw").val(),
			//聘任岗位等级时间
			postGrade : $("#postGrade").val(),
			//借调分流单位
			jdfldw : $("#jdfldw").val(),
			//借调分流时间
			jdflTime : $("#jdflTime").val(),
			//离岗待退时间
			postBack : $("#postBack").val(),
			//是否骨干教师
			jobCoreTeacherType : $("#jobCoreTeacher").val(),
			jobCoreTeacher:getSelected('jobCoreTeacher').text,
			//备注
			remark : $("#remark").val()
			
	};
	
	saveFlagD = true;
	$.ajax( {
			type : "POST",
			url : pathHeader + "/teacher/teachermanage/saveTeacherJob.do",
			data:{data: $.toJSON($job)},
			async : true,
			success : function(msg) {
				if (msg.success) {
					$('#myModal').modal('hide');
					 if(msg.eduJobId == 0) {
						 jQuery.generalAlert("工作经历修改成功！");
					 } else if(msg.eduJobId > 0){
						 eduJobId = msg.eduJobId;
						 jQuery.generalAlert("工作经历保存成功！");
					 }
				} else {
					$('#myModal').modal('hide');
					if (msg.flag == "-1") {
						jQuery.generalAlert("保存失败，在信息变更审核中未进行审核,管理员审核过后方可保存！");
					} else if (msg.flag == "-2") {
						jQuery.generalAlert("保存失败，在教师调动审核中未进行审核,管理员审核过后方可保存！");
					} else if (msg.flag == "-3") {
						jQuery.generalAlert("保存失败，在编制调整中未进行审核,管理员审核过后方可保存！");
					} else if (msg.flag == "-4") {
						jQuery.generalAlert("保存失败，在教师离退休中未进行审核,管理员审核过后方可保存！");
					} else if (msg.flag == "-5") {
						jQuery.generalAlert("保存失败，在教师死亡中未进行审核,管理员审核过后方可保存！");
					} else if (msg.flag == "-6") {
						jQuery.generalAlert("保存失败，在教师离退休中未进行审核,管理员审核过后方可保存！");
					} else if (msg.flag == "-7") {
						jQuery.generalAlert("保存失败，在教师离岗中未进行审核,管理员审核过后方可保存！");
					} else if (msg.flag == "-8") {
						jQuery.generalAlert("保存失败，在教师病休中未进行审核,管理员审核过后方可保存！");
					}else {
						jQuery.generalAlert("工作经历保存失败！");
					}
				}
				saveFlagD = false;
 			},
			error : function() {
				saveFlagD = false; 
			}
		});
}

var eduIdNum = 1;
$(function() {
	$('#addBranchArea').click(	function() {
		addEduInfo();
		queryXueLiList();
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
				flag:flag,
				time : ""  //新增教育经历  文本框置空
			};
 			$("#addEduPartA").tmpl(json).insertBefore("#flag"); 
 			$("#addEduPartB").tmpl(json).insertBefore("#flag");
 			//学历
 			//学位
 			SysCode.createSelect("TEACHER_DIM_DEGREE_DEAN", eduIdNum +"_educationDegree", "<option value=''>请选择</option>");
 			eduIdNum ++;
			$(".select6").uedSelect({
			width : 102  
		});
}
function onMouOver(){
	alert((".select6 eduHis").text());
	
}