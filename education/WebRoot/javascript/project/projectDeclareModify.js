$(function(){
	qryProInfo();

})
function initSelectClass(){
//
//	$(".select2").uedSelect({
//		width : 167  
//	});
	$(".select1").uedSelect({
			width : 345			  
		});
		$(".select2").uedSelect({
			width : 167  
		});
		$(".select3").uedSelect({
			width : 100
		});
}


function qryProInfo(){
	var url = pathHeader +"/edupm/projectmanage/qryFullInfo.do";
	$.ajax({
		url:url,
		type:"post",
		async:false,
		data:{proId:proId},
		success:function(data){
			if(data.success){
				var obj = data.dto;
				setInputValue("id",obj.id);
				setInputValue("projectName",obj.projectName);
//				setInputValue("year",obj.year);
				$("select[name='year']").val(obj.year);
				setInputValue("projectNo",obj.projectNo);
				setInputValue("startDate",obj.startDate);
				setInputValue("endDate",obj.endDate);
				setInputValue("planNum",obj.planNum);
				setInputValue("trainScopeName",obj.trainScopeName);
				setInputValue("trainScopeId",obj.trainScopeId);
				$("#projectScope").val(obj.projectScopeId);
//				$("#projectScope").find("option[text='"+obj.projectScopeName+"']").attr("selected",true);
				$("#projectProperty").val(obj.projectPropertyId);
				$("#projectTrainType").val(obj.trainTypeId);
				$("#projectGrade").val(obj.projectGradeId);
				$("select[name='sex']").val(obj.sex);
				$("#projectEduBg").val(obj.educationBackgroundId);
				$("#projectPos").val(obj.positionId);
				$("#projectProTit").val(obj.professionalTitleId);
				$("select[name='isClassCharger']").val(obj.isClassCharger);
				$("input[name='subject']").val(obj.subjectName);
				$("input[name='subjectId']").val(obj.subjectId);
				$("input[name='subjectName']").val(obj.subjectName);
				//	$("#section").val(obj.sectionId);
//				$("select[name='isFree']").val(obj.isFree);
				
				//是否收费\
//				$("input[type=radio]").attr("checked",obj.isFree);
				$('input[name=if]').get(obj.isFree).checked = true;
				//报名方式设置
//				$("input[type=radio]").attr("checked","1");
				$('input[name=t1]').get(obj.signUpWay-1).checked = true;
				
				
				$("select[name='mustAudit']").val(obj.mustAudit);
				setInputValue("chargingStandard",obj.chargingStandard);
				setInputValue("classPeriod",obj.classPeriod);
				setInputValue("classScore",obj.classScore);
				$("textarea[name='memo']").text(obj.memo);
				if(obj.fileName != null && obj.fileName.length>0){
					var names = obj.fileName.split(",");
					var attch = obj.projectAttchement.split(",");
					var tHtml = "";
				
					for(var i = 0;i<names.length;i++){
					tHtml +="<tr>";
					tHtml +="<td colspan='2' align='center'><a href='"+pathHeader+"/static/projectAttchement/"+attch[i]+"' class='tablelink'>"+names[i]+"</a>&nbsp;&nbsp;<a href='###' onclick='removeFile(this,\""+attch[i]+"\")'>删除</a></td>";
					tHtml +="</tr>";
					}
				}
				$("#files").append(tHtml);
				initSelectClass();

			}
		},
		error:function(){
			
		}
		
	});
}

function updatePro(){
	setValue();
	var url = pathHeader +"/edupm/projectmanage/modifyProjrct.do";
	$("#proForm").ajaxSubmit({
		url:url,
		async:false,
		success:function(data){
			if(data== 'true'){
				jQuery.generalAlert("保存成功！");
//				url = pathHeader + "/edupm/projectmanage/toProjectListPage.htm";
				url = pathHeader +"/edupm/projectmanage/toNewProjectDeclarePage.htm?click=91&status=10";
				openWindow(url);
			}else{
				jQuery.generalAlert("保存失败！");
			}
		},
		error:function(){
			
		}
	});
}

function removeFile(o,fileName){
	var name = $("#deleted").val();
	if(name.length > 0){
		$("#deleted").val(name+","+fileName);
	}else{
		$("#deleted").val(fileName);
	}
	$(o).parent().remove();
}

function cancel(){
	var url = pathHeader +"/edupm/projectmanage/toProjectDeclarePage.htm?click=21&status=10#tab2";
	openWindow(url);
}