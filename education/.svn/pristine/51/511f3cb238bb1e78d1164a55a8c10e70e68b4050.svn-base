$(function(){
	var pid=$("#projectId").val();
//	querySubject();
//	querySection();
//	initSelect();
	/*$("input[type='checkbox']").click(function(){
		if($(this).attr("checked")){
			var name = $(this).attr("name");
			$("hasSelected").append(name);
		}
		
	});
	$("a[name='rm']").click(function(){
		$(this).parent().parent().remove();
	});*/
	$("#cancleSave").click(function(){
		if(confirm("确定取消吗？")){
			window.location.href= pathHeader + "/edupm/projectmanage/toProjectPaperListPage.htm?click=8&proId="+pid;
		}else{
			return false;
		}
});
	
	var isforce=0;
	var c = $("#isforce");
	if(c.attr("checked")){
		isforce=1;
	}
	$("#isforce").val(isforce);
})

function initSelect(){
	//地区
//	var area = SysCode.getJsonArray("PROJECT_DIM_PROJECT_SCOPE","");
//	createCommonOpt(area,"area");
	//学科
//	var projectProperty = SysCode.getJsonArray("PROJECT_DIM_PROJECT_PROPERTY","");
//	createCommonOpt(projectProperty,"projectProperty");
}

/**
 * 查询字典表
 */
/*var section;
var subject;
function queryDic(dicType){
	var url = pathHeader+ "/sys/queryDicByType.do";
	$.ajax({
		url:url,
		data:{dicType:dicType},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
				if(dicType == "project_subject"){
					subject = data.rows;
				}else if(dicType == "stduty_section"){
					section = data.rows;
				}
			}
		},
		error:function(){
			
		}
	});
}

*//**
 * 查询学科
 *//*
function qrySubject(sectionName,id){

	
	$("#subject").html("");
	var url = pathHeader + "/sys/querySubject.do";
	$.ajax({
		url:url,
		data:{sectionName:sectionName},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				var rows = data.rows;
				if(rows.length > 0){
					var girdHtml = "<tr >";
					for(var i = 0;i<rows.length;i++){
						var obj = rows[i];
						girdHtml +="<td><input type='checkbox' name='"+obj.dictionaryName+"' value='"+obj.dictionaryId+"' onclick='setValues(this)'>"+obj.dictionaryName+"</td>";
						if( i != 0 && (i%4) == 0){
							girdHtml +="</tr><tr>"
						}
					}
					girdHtml +="</tr>";
					$("#subject").html(girdHtml);
				}
			}
		},
		error:function(){
			
		}
	});
}

function showS(){
	$("#XDshow").show();
}
function hideMe(){
	$("#XDshow").hide();
}

function lastSure(){
	if(subAry.length>0){
		var ids = "";
		var names = "";
		for(var i = 0;i<subAry.length;i++){
			var obj = subAry[i];
			ids += obj.subjectId+",";
			names += obj.subjectName+",";
		}
	}
	$("input[name='subjectId']").val(ids.substring(0,ids.length-1));
	$("input[name='subjectName']").val(names.substring(0,names.length-1));
	var values = "";
	for(var i = 0;i<subAry.length;i++){
		values += subAry[i].subjectName+" ";
	}
	$("input[name='subject']").val(values);
	subAry.length = 0;
	$("#XDshow").hide();
}
*/

//保存调查问卷
function savePaper(){
$("#savePaper").attr("disabled",true);

//setValue();
var url = pathHeader+"/edupm/paper/addPapertoBase.do";
var pid=$("#projectId").val();
if(!validateName()){
	alert("请填写调查问卷名称！");
	$("input[name='name']").focus();
	$("#savePaper").attr("disabled",false);
	return ;
}


if ($("input[name='name']").val().length<2 || $("input[name='name']").val().length>100)  {
	alert("请输入2-100个汉字！");
	$("input[name='name']").focus();
	$("#savePaper").attr("disabled",false);
	return ;
}
/*if(!validateDate()){
	alert("请填写项目开始时间或结束时间！");
	$("input[name='startDate']").focus();
	$("input[name='endDate']").focus();
	$("#savePaper").attr("disabled",false);
	return ;*/

if(!validateStartDateEmpty()){
	jQuery.generalAlert("开始时间不能为空！");
	$("input[name='startDate']").focus();
	$("#savePaper").attr("disabled",false);
	return ;
}

if(!validateEndDateEmpty()){
	jQuery.generalAlert("结束时间不能为空！");
	$("input[name='endDate']").focus();
	$("#savePaper").attr("disabled",false);
	return ;
}

if(!validateDate()){
	jQuery.generalAlert("开始时间不能大于结束时间！");
	$("input[name='startDate']").focus();
	$("#savePaper").attr("disabled",false);
	return ;
}

var pid = $("#projectId").val();
/*if(!validateProjectNO()){
	alert("请选择地区");
	$("input[name='projectNo']").focus();
	$("#savePaper").attr("disabled",false);
	return;
}


if(!validateSubject()){
	alert("请选择学科！");
	$("input[name='subject']").focus();
	$("#savePaper").attr("disabled",false);
	return ;
}*/
$("#paperForm").ajaxSubmit({
	url:url,
	async:false,
	type:"post",
	dataType:"json",
	success:function(data){
		if(data){
			alert("保存成功！");
			url = pathHeader+"/edupm/projectmanage/toProjectPaperListPage.htm?click=8&proId="+pid;
			window.location.href=url;
		}else{
			alert("保存失败！");
			$("#savePaper").attr("disabled",false);
		}
	}, 
	error:function(){
		$("#savePaper").attr("disabled",false);
	}
});
}

