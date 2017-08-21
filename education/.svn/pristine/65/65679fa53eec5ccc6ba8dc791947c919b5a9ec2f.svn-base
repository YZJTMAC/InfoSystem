$(function(){
	qryProInfo();	
	showP();
	$("input[name='checkProName']").attr("value",$("input[name='projectName']").attr("value"));
	$("input[name='checkProNo']").attr("value",$("input[name='projectNo']").attr("value"));
	
	
	
})


function showP(){
	/*$('#if').html('');*/
	var a=$("input[name='if']:checked").val();
	if(a!=0){
		 $("#feeLable").show();
		 $("#feeInput").show();
	}else{
		$("#feeLable").hide();
		$("#feeInput").hide();
	}
}
function initSelectClass(){
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
				//jQuery.generalAlert(obj.eduModelType);
				setInputValue("id",obj.id);
				setInputValue("projectName",obj.projectName);
//				setInputValue("year",obj.year);
				$("select[name='year']").val(obj.year);
				$("select[name='eduModelType']").val(obj.eduModelType);
				setInputValue("projectNo",obj.projectNo);
				setInputValue("startDate",obj.startDate);
				setInputValue("endDate",obj.endDate);
				setInputValue("planNum",obj.planNum);
				setInputValue("trainScopeName",obj.trainScopeName);
				setInputValue("trainScopeId",obj.trainScopeId);
				$("#orgId").val(obj.orgId);
				if(obj.printXueshiCertificate == 1) {
					$("input[name='printxueshi']").attr('checked', "checked");
				}
				if(obj.printProjectCertificate == 1) {
					$("input[name='printproject']").attr('checked', "checked");
				}
				$("#projectScope").val(obj.projectScopeId);
//				$("#projectScope").find("option[text='"+obj.projectScopeName+"']").attr("selected",true);
				$("#projectProperty").val(obj.projectPropertyId);
				//$("#projectTrainType").val(obj.trainTypeId);
				$("#projectTrainType").val(obj.trainTypeId)
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
				
				//是否收费\\
				//$("input[type=if]").attr("checked",obj.isFree);
				$('input[name=if]').get(obj.isFree).checked = true;
	
//				$("input[type=radio]").attr("checked",obj.isFree);
				//设置界面的值
				
				
				//报名方式设置
//				$("input[type=radio]").attr("checked","1");
				
//				$('input[name=t1]').get(obj.signUpWay-1).checked = true;
				
				$("input[name=t1][value="+obj.signUpWay+"]").attr('checked',true);
				
				$("select[name='mustAudit']").val(obj.mustAudit);
				setInputValue("chargingStandard",obj.chargingStandard);
				setInputValue("classPeriod",obj.classPeriod);
				setInputValue("classScore",obj.classScore);
				$("textarea[name='memo']").text(obj.memo);
				/*if(obj.fileName != null && obj.fileName.length>0){
					var names = obj.fileName.split(",");
					var attch = obj.projectAttchement.split(",");
					var tHtml = "";
				
					for(var i = 0;i<names.length;i++){
					tHtml +="<tr>";
					tHtml +="<td align='center'></td>";
					//tHtml +="<td colspan='2' align='center'><a href='"+pathHeader+"/static/projectAttchement/"+attch[i]+"' class='tablelink'>"+names[i]+"</a>&nbsp;&nbsp;<a href='###' onclick='removeFile(this,\""+attch[i]+"\")'>删除</a></td>";
					tHtml +="<td><a href='###' class='tablelink'onclick='uploadProjectFile(\"" + obj.id + "\",\""+obj.projectName+"\");'>"+names[i]+"</a></td>";
					tHtml +="</tr>";
					}
				}*/
				var table = "<tr><td width='50'>序号</td><td>文件名</td><td>操作</td></tr> ";
				$.each(data.files,function(i, item) {
					table += "<tr><td>"+ (i + 1)
						table +="<td><a href='###' class='tablelink' onclick='downloadFile(\"" + item.url + "\");'>"+item.name+"</a></td><td><a href='###' onclick='removeFile("+item.id+",\""+item.url+"\",\""+item.projectId+"\")'>删除</a></td>";
						table +="</tr>";
					});
					
				$("#files").append(table);
				initSelectClass();

			}
		},
		error:function(){
			
		}
		
	});
}

function updatePro(){
	setValue();
//	if(!validateProjectScope()){
//		jQuery.generalAlert("请选择项目范围！");
//		$("#submitPro").attr("disabled",false);
//		return ;
//	}
	if(!validateName()){
		jQuery.generalAlert("请填写项目名称！");
		$("input[name='projectName']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	if(!validateProjectNO()){
		jQuery.generalAlert("请填写项目编号！");
		$("input[name='projectNo']").focus();
		$("#submitPro").attr("disabled",false);
		return;
	}

	if(!validateDate()){
		jQuery.generalAlert("请填写项目开始时间或结束时间！");
		$("input[name='startDate']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	// 验证实施机构
	if(!validateSSOrg()){
		jQuery.generalAlert("请选择实施机构！");
		$("input[name='orgId']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	if(!validatePlanNum()){
		jQuery.generalAlert("请填写大于零八位以内的正整数数字！");
		$("input[name='planNum']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	if(!validateXmxz()){
		jQuery.generalAlert("请选择项目性质！");
		$("input[name='projectScope']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	if(!validateTrainScope()){
		jQuery.generalAlert("请选择培训范围！");
		$("input[name='trainScopeName']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	if(!validatePxnx()){
		jQuery.generalAlert("请选择培训类型！");
		$("input[name='projectProperty']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	if(!validatePxxs()){
		jQuery.generalAlert("请选择培训形式！");
		$("input[name='projectTrainType']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	if(!validateSubject()){
		jQuery.generalAlert("请选择学科/学段！");
		$("input[name='subject']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	//验证项目名称是否已经存在 如果当前编辑checkProName的项目名称和填写的projectName项目名称不同 就去后台查询新填写的项目名称是否存在
	if(!($("input[name='checkProName']").attr("value")==$("input[name='projectName']").attr("value"))){		
		if(!validateProName()){
			jQuery.generalAlert("项目名称已经存在！");
			$("input[name='projectName']").focus();
			$("#submitPro").attr("disabled",false);
			return ;
		}
	}
	//验证项目编号是否已经存在 如果当前编辑checkProNo的项目编号和填写的projectNo项目编号不同 就去后台查询新填写的项目编号是否存在
	if(!($("input[name='checkProNo']").attr("value")==$("input[name='projectNo']").attr("value"))){		
	//验证项目编号
	if(!validateNO()){		
		jQuery.generalAlert("项目编号已经存在！");
		$("#submitPro").attr("disabled",false);
		return ;
	}
	}
	$('#myModal').modal('show');
	var url = pathHeader +"/edupm/projectmanage/modifyPro.do";
	$("#proForm").ajaxSubmit({
		url:url,
		async:false,
		success:function(data){
			if(data){
				jQuery.generalAlert("保存成功！");
//				url = pathHeader + "/edupm/projectmanage/toProjectListPage.htm";
				url = pathHeader +"/edupm/projectmanage/toProjectDeclarePage.htm?click=20&status=10";
				openWindow(url);
			}else{
				jQuery.generalAlert("保存失败！");
//				url = pathHeader + "/edupm/projectmanage/toProjectListPage.htm";
				url = pathHeader +"/edupm/projectmanage/toProjectDeclarePage.htm?click=20&status=10";
				openWindow(url);
			}
			$('#myModal').modal('hide');
		},
		error:function(){
			
		}
	});
}

/*function removeFile(o,fileName){
	var name = $("#deleted").val();
	if(name.length > 0){
		$("#deleted").val(name+","+fileName);
	}else{
		$("#deleted").val(fileName);
	}
	$(o).parent().remove();
}*/

function cancel(){
	var url = pathHeader +"/edupm/projectmanage/toProjectDeclarePage.htm?click=21&status=10";
	openWindow(url);
}

function removeFile(id, filePath, pid) {
	jQuery.confirmWindow(
				"提示",
				"是否删除该文件？",
				function() {
					var url = pathHeader
							+ "/fileupload/deleteFile.do?";
					$.ajax({
							dataType : 'json',
							type : 'post',
							url : url,
							data : {
								id : id,
								filePath : filePath,
								pid : pid
							},
							success : function(data) {
								$(".addMore").html('');
								$('#myModal').modal('hide');
								jQuery.generalAlert("删除成功");
								window.location.reload();
							},
							error : function() {
								jQuery.generalAlert("删除失败");
							}
						});
				});

}

// 下载文件
function downloadFile(filePathName) {
	// 下载能使用jquery的ajax，因为ajax的返回值不支持流
	var url = pathHeader + '/fileupload/downloadFiles.do';
	var form = $("<form>");// 定义一个form表单
	form.attr("style", "display:none");
	form.attr("method", "post");
	form.attr("action", url);
	var input = $("<input>");
	input.attr("type", "hidden");
	input.attr("name", "filePathName");
	input.attr("value", filePathName);
	$("body").append(form);// 将表单放置在web中
	form.append(input);
	form.submit();// 表单提交
}