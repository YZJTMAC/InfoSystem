$(function(){
	$(".tiptop2 a").click(function() {
		$(".tip1").fadeOut(200);
	});

	$(".cancel").click(function() {
		$(".tip1").fadeOut(100);
	});
});
	
function showJobChange(auditId) {
	$(".tipinfo").empty();
	$(".tip1").fadeIn(200);
	var json = {
		eduIdNum : 1
	};
	$("#addEduPartC").tmpl(json).appendTo(".tipinfo");
	showHisInfo(auditId);
}

function showHisInfo(auditId) {
	$.ajax({
		url : pathHeader + "/teacher/teacherProject/teacherJobChangeHisInfo.do",
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
				//教师工作信息
				jobInfoB(data);

//				showDiferent() ;
				
			
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
	} else if(a != null && b == null ) {
		$("#" + id + "_old").html("<em style='color: #999; text-decoration: line-through;'>"+a+"</em>");
	} else if(a == null && b != null ) {
		$("#" + id + "_new").html("<em style='font-style:normal;color:red'>"+b+"</em>");
	} else if(a != b){
		$("#" + id + "_old").html("<em style='color: #999; text-decoration: line-through;'>"+a+"</em>");
		$("#" + id + "_new").html("<em style='font-style:normal;color:red'>"+b+"</em>");
	} else if( a == b) {
		$("#" + id + "_old").html(a);
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

 //教师工作信息
function jobInfoB(data) {
	var oldJobInfo = data.oldJobInfo;
	var newJobInfo = data.newJobInfo;
	
	$('#jobQualification').html(infoCompare(oldJobInfo.jobQualification, newJobInfo.jobQualification, "jobQualification"));
	
	var jobCertificateDateOld = oldJobInfo.jobCertificateDate;
	var jobCertificateDateNew = newJobInfo.jobCertificateDate;
	infoCompare(jobCertificateDateOld, jobCertificateDateNew, "jobCertificateDate");
	
	infoCompare(oldJobInfo.jobCertificateNum, newJobInfo.jobCertificateNum, "jobCertificateNum");
	
	var jobWorkTimeOld = oldJobInfo.jobWorkTime;
	var jobWorkTimeNew = newJobInfo.jobWorkTime;
	infoCompare(jobWorkTimeOld, jobWorkTimeNew, "jobWorkTime");
	
	var jobWorkDateOld = oldJobInfo.jobWorkDate;
	var jobWorkDateNew = newJobInfo.jobWorkDate;
	infoCompare(jobWorkDateOld, jobWorkDateNew, "jobWorkDate");
	
	infoCompare(oldJobInfo.jobCommentPosition, newJobInfo.jobCommentPosition, "jobCommentPosition");
	
	var jobCommentDateOld = oldJobInfo.jobCommentDate;
	var jobCommentDateNew = newJobInfo.jobCommentDate;
	infoCompare(jobCommentDateOld, jobCommentDateNew, "jobCommentDate");
	
	infoCompare(oldJobInfo.jobRecruitmentPosition, newJobInfo.jobRecruitmentPosition, "jobRecruitmentPosition");
	
	var jobRecruitmentDateOld = oldJobInfo.jobRecruitmentDate;
	var jobRecruitmentDateNew = newJobInfo.jobRecruitmentDate;
	infoCompare(jobRecruitmentDateOld, jobRecruitmentDateNew, "jobRecruitmentDate");
	
	infoCompare(oldJobInfo.jobSchoolAdministrationOffice, newJobInfo.jobSchoolAdministrationOffice, "jobSchoolAdministrationOffice");

	infoCompare(oldJobInfo.jobFormerTeachingSubject, newJobInfo.jobFormerTeachingSubject, "jobFormerTeachingSubject");
																						 
	infoCompare(oldJobInfo.jobFormerTeachingSection, newJobInfo.jobFormerTeachingSection, "jobFormerTeachingSection");
	
	infoCompare(isTrue(oldJobInfo.jobSubjectLeader), isTrue(newJobInfo.jobSubjectLeader), "jobSubjectLeader");
	
	infoCompare(isTrue(oldJobInfo.jobCoreTeacher), isTrue(newJobInfo.jobCoreTeacher), "jobCoreTeacher");
	
	infoCompare(isTrue(oldJobInfo.jobWhetherGradeTeacher), isTrue(newJobInfo.jobWhetherGradeTeacher), "jobWhetherGradeTeacher");
	
	infoCompare(isTrue(oldJobInfo.jobCountyRuralTeacher), isTrue(newJobInfo.jobCountyRuralTeacher), "jobCountyRuralTeacher");
	
	infoCompare(isTrue(oldJobInfo.jobWhetherTeacher), isTrue(newJobInfo.jobWhetherTeacher), "jobWhetherTeacher");
	
	infoCompare(isTrue(oldJobInfo.jobPrivateSchoolTeacher), isTrue(newJobInfo.jobPrivateSchoolTeacher), "jobPrivateSchoolTeacher");
	
	infoCompare(isTrue(oldJobInfo.jobSpecialTeacher), isTrue(newJobInfo.jobSpecialTeacher), "jobSpecialTeacher");
	
	$("#mobilizeMark").html(data.mobilizeMark);
	$("#auditOption").html(data.auditOption);
	
}

function isTrue(a) {
		if(a==1){
			return "是";
		}else{
			return "否";
		}
	}

 

 
 
