$(function(){
	orgProjectInfo();
	// 返回/取消
	$("#back").click(function() {
		var openUrl = pathHeader + '/org/orgProjectListPage.htm?click=11';
		window.location.href = openUrl;
	});
});

function orgProjectInfo(){
	$.ajax({
		url : pathHeader + '/org/orgProjectInfo.do?projectId=' + projectId,
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		success:function(data){
			if(data.success) {
				var obj = data.obj;
				$('#modelName').html(obj.modelName);
				$('#projectName').html(obj.projectName);
				$('#year').html(obj.year);
				$('#projectNo').html(obj.projectNo);
				$('#startDate').html(new Date(obj.startDate).format("yyyy-MM-dd"));
				$('#endDate').html(new Date(obj.endDate).format("yyyy-MM-dd"));
				var isFree = obj.isFree;
//				if(isFree == 1){
//					$('#isFree').html('是');
//				} else {
//					$('#isFree').html('否');
//				}
				var signUpWay = obj.signUpWay;
				if(signUpWay == 1){
					signUpWay = '组织报名';
				} else if(signUpWay == 2){
					signUpWay = '自由报名';
				} else if(signUpWay == 3){
					signUpWay = '层级分配/报名';
				}
				$('#signUpWay').html(signUpWay);
				$('#planNum').html(obj.planNum);
				$('#projectScopeName').html(obj.projectScopeName);
				$('#trainScopeName').html(obj.trainScopeName);
				$('#projectPropertyName').html(obj.projectPropertyName);
				$('#trainTypeName').html(obj.trainTypeName);
				$('#subjectName').html(obj.subjectName);
				$('#educationBackgroundName').html(obj.educationBackgroundName);
				$('#positionName').html(obj.positionName);
				$('#professionalTitleName').html(obj.professionalTitleName);
				$('#memo').html(obj.memo);
				var projectAttchement = obj.projectAttchement;
				var fileNames = obj.fileNames;
				if(projectAttchement != null && projectAttchement.length!=0){
					var names = projectAttchement.split(',');
					var fileNames = fileNames.split(',');
					for(var i=0; i<names.length; i++){
						var name = names[i];
						var	fileName =  fileNames[i];
						$('#projectAttchement').append(fileName +" <a href='"+pathHeader+"/dowload/download.do?proId="+projectId+"&&index="+i+"' class='tablelink'>附件下载</a><br/>");
					}
				} 
				$('#classPeriod').html('学时：'+obj.classPeriod);
				$('#orgName').html(obj.orgName);
				$('#trainingHomeAddress').html(obj.trainingHomeAddress);
				$('#trainingAddress').html(obj.trainingAddress);
//				$('#gradeName').html(obj.gradeName);
//				var sex = obj.sex;
//				if(sex == 1){
//					$('#sex').html('男');
//				} else {
//					$('#sex').html('女');
//				}
//				var isClassCharger = obj.isClassCharger;
//				if(isClassCharger == 1){
//					$('#isClassCharger').html('是');
//				} else {
//					$('#isClassCharger').html('否');
//				}
//				$('#stdutySection').html(obj.stdutySection);
//				var mustAudit = obj.mustAudit;
//				if(mustAudit == 1){
//					$('#mustAudit').html('是');
//				} else {
//					$('#mustAudit').html('否');
//				}
//				$('#chargingStandard').html(obj.chargingStandard);
//				var orgList = obj.orgList;
//				if(orgList != null && orgList.length != 0){
//					for(var i=0; i<orgList.length; i++){
//						$('#organization').append("<td width='80'>"+orgList[i]+"</td>");
//					}
//				}
//				$('#classScore').html('学分：'+obj.classScore);
//				var status = obj.status;
//				if(status == 1){
//					$('#status').html('准备中');
//				} else if(status == 2){
//					$('#status').html('正在进行中');
//				} else if(status ==3) {
//					$('#status').html('已结束');
//				} 
//				$('#orgName').html(obj.orgName);
//				$('#updateDate').val(obj.updateDate);
			} else {
				
			}
		},
		error:function(){
			
		}
	});
}


