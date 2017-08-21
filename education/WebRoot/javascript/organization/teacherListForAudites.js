$(document).ready(function(e) {
	var projectName=GetURLParameter('projectName');
	$('#pname').html(decodeURIComponent(projectName));
	//getAreaList();
	getUserList();
	
	$("#select").click(function() {
		getUserList();
	});
	
	var projectId= GetURLParameter('projectId');
	 $.post(pathHeader + '/org/orgAreaList.do?projectId='+projectId,function(result){
		 var myJsonString = JSON.stringify(result);
		 var zNodes =eval("(" + myJsonString + ")");
		 $.fn.zTree.init($("#treeDemo2"), setting2,zNodes);   
	 });

	
});

/*function getAreaList(){
	$.ajax({
		url : pathHeader + '/org/orgAreaList.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			 
			pageIndex : 1,
			pageSize:20
		},
		success:function(data){
			if(data.success) {
				alert("success.")
				 
			} else {
				alert("failure.")
			}
		},
		error:function(){
			alert("error.")
		}
	});
}*/

function getUserList(){
	$('#target').html('');
	var province = $("#txtProvinceId").val();
	var city  = $("#txtCityId").val();
	var district = $("#txtDistrictId").val();
	var school = $("#txtSchoolId").val();
	var schoolType = $("#txtSchoolType").val();
	var teacherName=$('#txtTeacherName').val();
	var projectId;
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	
	$.ajax({
		url : pathHeader + '/org/orgScoreModifyList.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectId: GetURLParameter('projectId'),
			province: province,
			city: city,
			district:district,
			school:school,
			schoolType:schoolType,
			teacherName:teacherName,
			pageIndex : pageIndex,
			pageSize:sizePerPage
		},
		success:function(data){
			if(data.success) {
			var rows = data.rows;			
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				
				$('#target').append(gridHtml);
				pagination(data, function(){getUserList();});
			}else {
				gridHtml = "<tr><td align='center'colspan='8'>暂无查询结果！</td></tr>";
				$('#target').html(gridHtml);
				$('#pagebar').html('');
		}			
			},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='8'>错误,暂无查询结果！</td></tr>";
			$('#target').append(gridHtml);
			$('#pagebar').html('');
		}
	}); 

}

function getTdHtml(obj){
	var status = "";
	if(obj.examine == 0 || obj.examine == null){
		status  = "未审核"
	}else if(obj.examine == 2){
		status = "审核未通过";
	}else if(obj.examine == 1){
		status = "审核通过";
	}
	//学员学时
	var score = '';
	if(obj.teacherClassPeriod == null){
		score = '';
	}else{
		score = obj.teacherClassPeriod;
	}
	
	var total = obj.pass-0+obj.unPass-0;
	var gridHtml = "<tr>";
	gridHtml += "<td><input type='checkbox' name='cid' value='"+obj.id+"'></td>";
	gridHtml += "<td>"+obj.realName+"</td>";
	gridHtml += "<td>"+(obj.gender==0?'女':'男')+"</td>";
	gridHtml += "<td>"+obj.schoolName+"</td>";
	gridHtml += "<td>"+obj.teacherScore+"</td>";
	gridHtml += "<td>"+(obj.score == null ? '' : obj.score)+"</td>";
	gridHtml += "<td>"+status+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td>"
	return gridHtml;
}


function optionFormatter(obj){
	
	var ids = '';
	var id='';
	var examine ='';
	var projectId ='';
	var returnStr = "";
	for(var i=0;i<obj.length;i++){
		ids = ids + rows[i].id+",";
		id = obj[i].id;
		examine = obj[i].examine;
		projectId = obj[i].projectId;
	}
	
	/*if(obj.hasStopSign == 0 ||obj.hasStopSign==null){*/
	if(obj.examine == 0 || obj.examine==null){
		returnStr +=  "<a href='javascript:void(0);'  class='tablelink'   onclick='modifyScores(\"" + obj.projectId + "\" ,\"" + obj.id + "\" );'>审核</a>&nbsp;&nbsp;&nbsp;";
	}else if(obj.examine == 1){                                                                   
		returnStr += 	 "已审核";
	}else if(obj.examine == 2){
		returnStr += "<a href='javascript:void(0);'  class='tablelink'   onclick='modifyScores(\"" + obj.projectId + "\" ,\"" + obj.id + "\" );'>审核未通过</a>&nbsp;&nbsp;&nbsp;";
	}
	
	return returnStr;
}

function modifyScores(pId,id){
	$("input[name='radio']").attr("checked",false);
	$("#opinion").val("");
	flag = 0;
	$(".tips_zb_1").fadeIn(100);
	$("#commentId").val(id);
	$("#pid").val(pId);
}

$(".cancel").click(function(){
	$(".tips_zb_1").fadeOut(100);
	$(".tip").fadeOut(100);
});

/*function hideConfirm(){
	$("#tips_zb_1").hide();
}*/

//审核button click
/*function modifyScores(a,pid,tid){
	var score = $( a ).parent().prev().find('input').val();
	$.ajax({
		url : pathHeader + '/org/orgScoreUpdate.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			pid:pid,
			tid:tid,
			score:score 
		},
		success:function(data){
			if(data) {
				alert("审核通过!");
				 
			} else {
				alert("审核失败!");
			}
		},
		error:function(){
			alert("错误.");
		}
	});
	
	
}*/


function GetURLParameter(sParam)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) 
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) 
        {
            return sParameterName[1];
        }
    }
}

 




var setting2 = {
		view: {
			dblClickExpand: false,
			showLine: true,
			showIcon: false
		},
	async: {
		enable: true,
		url:pathHeader + '/org/orgAreaList.do?projectId='+ GetURLParameter('projectId'),
		autoParam:["id","type","isSchool","pId=pid"],
		otherParam:{"otherParam":"zTreeAsyncTest"},
		dataFilter: filter
	},
	callback: {
		onClick: onClick
	}
	
};

function getUserListForArea(){
	$('#target').html('');
	var province = $("#txtProvinceId").val();
	var city  = $("#txtCityId").val();
	var district = $("#txtDistrictId").val();
	var school = $("#txtSchoolId").val();
	var schoolType = $("#txtSchoolType").val();
	var teacherName=$('#txtTeacherName').val();
	var projectId;
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + '/org/orgScoreModifyList.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectId: GetURLParameter('projectId'),
			province: province,
			city: city,
			district:district,
			school:school,
			schoolType:schoolType,
			teacherName:teacherName,
			pageIndex : pageIndex,
			pageSize:sizePerPage
		},
		success:function(data){
			if(data.success) {
			var rows = data.rows;			
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				
				$('#target').append(gridHtml);
				pagination(data, function(){
					getUserListForArea();});
			}
			else {
				gridHtml = "<tr><td align='center'colspan='8'>暂无查询结果！</td></tr>";
					$('#target').html(gridHtml);
					$('#pagebar').html('');
			}
			},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='8'>错误,暂无查询结果！</td></tr>";
			$('#target').html(gridHtml);
			$('#pagebar').html('');
		}
	}); 

}

function onClick(e,treeId, treeNode) {
	//  alert(treeNode.id + ", -" + treeNode.name+", " + treeNode.type+",isSchool= " + treeNode.isSchool);
		
	  		if(treeNode.isSchool ==="true"){ //学校类型
//	  			alert('小学');
	  			$("#txtSchoolType").val(treeNode.type);
	  			$("#txtDistrictId").val(treeNode.pId);
	  		}else if(treeNode.isSchool ==="school"){ //学校类型
	  			$("#txtSchoolId").val(treeNode.id);
	  			$("#txtDistrictId").val(treeNode.pId.split(",")[0]);
	  		}else{
	  			var type=treeNode.type;
	  			if(type=="0"){
		  			$("#txtProvinceId").val(treeNode.id);
		  			$("#txtCityId").val("");
		  			$("#txtDistrictId").val("");
		  			$("#txtSchoolId").val("");
	  			}else if(type=="1"){
		  			$("#txtCityId").val(treeNode.id);
		  			$("#txtDistrictId").val("");
		  			$("#txtSchoolId").val("");
	  			}else if(type=="2"){
		  			$("#txtDistrictId").val(treeNode.id);
		  			$("#txtSchoolId").val("");
	  			}
	  		}
	  		
	  		getUserListForArea();
}


function filter(treeId, parentNode, childNodes) {
	if (!childNodes) return null;
//	alert(childNodes);
	for (var i=0, l=childNodes.length; i<l; i++) {
		childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
	}
	return childNodes;
}


var flag = 0;
$(function(){
	//initSelect();
	$(".sure").click(function(){
		toAudit();
		$(".tips_zb_1").fadeOut(100);
	});
	$(".cancel").click(function(){
		$(".tips_zb_1").fadeOut(100);
		$(".tip").fadeOut(100);
	});
	
	
	$("#all").click(function(){
		if($("#all").attr("checked")){
			$("input[name='cid']").each(function(){
				$(this).attr("checked",true);
			});
		}else{
			$("input[name='cid']").each(function(){
				$(this).attr("checked",false);
			});
		}
	});
});

function toAudit(){	
	if(flag == 0){
		auditSingle(); //单个审核
	}else if(flag == 1){
		var ids = "";
		$("input[name='cid']:checked").each(function(){
			ids += $(this).val()+",";
		});
		batchAudit(ids);//批量审核
	}else if(flag == 2){
		auditAll(); //审核全部
	}
	/*else if(flag == 4){
		cancelAuditAll();
	}*/
}

/*
 * 单个审核
 */

function auditSingle(){
	var url = pathHeader + '/org/auditSingleScore.do';
	var examine = $("input[name='radio']:checked").val();
	$.ajax({
		url:url,
		data:{
			commentId:$("#commentId").val(),
			pid:$("#pid").val(),
			examine:examine,
			opinion:$("#opinion").val()
		},
		type:"post",
		async:true,
		success:function(data){
			if(data){
				getUserList();
			}
		},
		error:function(){
			jQuery.generalAlert("URL error");
		}
	});
}

/**
 * 显示审核对话 -- 用于批量审核
 * @param {Object} id,type:审核类型
 */
function showForBatch(type){
	//清空
	$("input[name='radio']").attr("checked",false);
	$("#opinion").val("");
	//$("input[name='radio']:checked") = false;
	flag = type;
	if(type == 1 || type == 3){
		var ids = "";
		$("input[name='cid']:checked").each(function(){
			ids += $(this).val()+",";
			});
		if(ids.length > 0){
			$(".tips_zb_1").fadeIn(100);
		}else{
			jQuery.generalAlert("请至少选择一个要审核的教师！");
		}
	}else{
		$(".tips_zb_1").fadeIn(100);
	}
}


/**
 * 审核全部
 */
function auditAll(){
	var projectId = GetURLParameter('projectId');
	var url = pathHeader + '/org/auditAllScores.do';
	var status = $("input[name='radio']:checked").val();
	if(status == null){
		jQuery.generalAlert("请选择是否审核通过！");
		return;
		
	}
	$.ajax({
		url:url,
		data:{
			projectId : projectId,			
			examine:status,			
			opinion:$("#opinion").val()
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				getUserList();
			}
			else{
				jQuery.generalAlert("全部审核失败 	！");
			}
		},
		error:function(){
			
		}
	});
	
}
/**
 * 全部取消审核
 */
function cancelAuditAll(){
	var projectId = GetURLParameter('projectId');
	var url = pathHeader + '/org/auditAllScores.do';
	//var status = $("input[name='radio']:checked").val();
	
	$.ajax({
		url:url,
		data:{
			projectId : projectId,			
			examine:0,			
			opinion:""
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				getUserList();
			}
			else{
				jQuery.generalAlert("全部取消审核失败！");
			}
		},
		error:function(){
			
		}
	});
	
}

/**
 * 批量审核
 */
function batchAudit(ids){
	var status = $("input[name='radio']:checked").val();	
	var url = pathHeader + '/org/batchAuditScores.do';
	if(status == null){
		jQuery.generalAlert("请选择是否审核通过！");
		return;
	}
	if(ids.length>0){
			$.ajax({
			url:url,
			data:{
				ids:ids.substring(0,ids.length-1),
				status:status,
				auditMemo:$("#opinion").val()
			},
			type:"post",
			async:true,
			success:function(data){
				if(data.success){
					$("#all").attr("checked",false);
					getUserList();
				}
			},
			error:function(){
				
			}
		});
	}else{
		jQuery.generalAlert("请至少选择一个要审核的教师！");
	}
	
}

/**
 * 批量取消审核
 * @memberOf {TypeName} 
 */
function batchCancelAudit(){
	var ids = "";
	$("input[name='cid']:checked").each(function(){
		ids += $(this).val()+",";
		});
	if(ids.length > 0){
		var url = pathHeader + '/org/batchAuditScores.do';
		$.ajax({
			url:url,
			data:{
				ids:ids.substring(0,ids.length-1),
				status:0,
				auditMemo:""			
			},
			type:"post",
			async:true,
			success:function(data){
				if(data.success){
					$("#all").attr("checked",false);
					getUserList();
				}
			},
			error:function(){
				
			}
			
		});
	}else{
		jQuery.generalAlert("请至少选择一个要审核的教师！");
	}
}




