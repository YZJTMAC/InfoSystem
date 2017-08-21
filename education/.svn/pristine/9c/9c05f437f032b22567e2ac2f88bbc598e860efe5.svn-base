var flag = 0;
$(function(){
	$(".sure").click(function(){
		toAudit();
		$(".tips_zb_1").fadeOut(100);
	});
	$(".cancel").click(function(){
		$(".tips_zb_1").fadeOut(100);
		$(".tip").fadeOut(100);
	});
	
	showOrgProjectTeachers();
	
	
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


function showOrgProjectTeachers(){
	$('#teacher_list').html('');
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + '/edupm/projectmanage/teacherListForAudit.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectId : projectId,
			provinceId : provinceId,
			cityId : cityId,
			districtId : districtId,
			schoolId :schoolId,
			subject : $('#subject').find("option:selected").val(),
			status:$("#status").val(),
			pageIndex : pageIndex,
			areaId:$("#areaId").val()
		},
		success:function(data){
			if(data.success) {
				$("#projectName").html("项目名称："+data.projectName);
				var objList = data.rows;
				var gridHtml = "";
				if(objList.length > 0){
						$.each(objList, function(index,element) {
						gridHtml += getTdHtml(element);
					});
					$('#teacher_list').append(gridHtml);
				}else {
					gridHtml = "<tr><td align='center'colspan='11'>暂无查询结果！</td></tr>";
					$('#teacher_list').append(gridHtml);
				}
				pagination(data, function(){showOrgProjectTeachers();});
			} 
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='11'>暂无查询结果！</td></tr>";
			$('#teacher_list').append(gridHtml);
		}
	});
}


function getTdHtml(obj){
	var status = "";
	if(obj.status == 11){
		status  = "未审核"
	}else if(obj.status == 12){
		status = "未通过审核";
	}else if(obj.status == 13){
		status = "审核通过";
	}
	var gridHtml = "<tr>";
	var name = obj.realName==null?"":obj.realName;
	/*var idc = obj.idNumber==null?"":obj.idNumber;*/
	var sub = obj.teachingSubject == null?"":obj.teachingSubject;
	var mobile = obj.mobile == null?"":obj.mobile;
	var pn = obj.schoolProvinceName == null?"":obj.schoolProvinceName;
	var cn = obj.schoolCityName == null?"":obj.schoolCityName;
	var dn = obj.schoolDistrictName == null?"":obj.schoolDistrictName;
	var sn = obj.schoolName == null?"":obj.schoolName;
	gridHtml += "<td><input type='checkbox' name='cid' value='"+obj.id+"'></td>";
	gridHtml += "<td>"+name+"</td>";
	/*gridHtml += "<td>"+idc+"</td>";*/
	gridHtml += "<td>"+sub+"</td>";
	gridHtml += "<td>"+pn+"</td>";
	gridHtml += "<td>"+cn+"</td>";
	gridHtml += "<td>"+dn+"</td>";
	gridHtml += "<td>"+sn+"</td>";
	gridHtml += "<td>"+mobile+"</td>";
	gridHtml += "<td>"+status+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td>";
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		if(row.status == 11){
			returnStr += 	 "<a href='###' class='tablelink' onclick='audit(\"" + row.id + "\");'>审 核</a>&nbsp;&nbsp;&nbsp;";
		}else	if(row.status == 13){
			returnStr += "<a href='###' class='tablelink' onclick='cancelAudit(\"" + row.id + "\");'>取消审核</a>";
		}else if(row.status == 12){
			returnStr += "<a href='###' class='tablelink' onclick='cancelReason(\"" + row.id + "\");'>审核不通过</a>&nbsp;&nbsp;&nbsp;";
			returnStr += "<a href='###' class='tablelink' onclick='deleteTeacher("+row.teacherId+","+row.projectId+");'>取消报名</a>&nbsp;&nbsp;";
		}
		
		return returnStr;
	}
}

function deleteTeacher(teacherId,projectId){
	$.ajax({
		/*url : pathHeader + "/teacher/teachermanage/removeTeacher.do",*/  //假删教师信息
		url : pathHeader + "/edupm/projectmanage/deleteTeacher.do",   //真删教师信息
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{teacherIds:teacherId,projectId:projectId,schoolID:0},
		success:function(data){
			
			if(data.success) { 
				showOrgProjectTeachers();
			} else {
				alert("删除失败");
				showOrgProjectTeachers();
			}
		},
		error:function(){
		}
	});
	
}
/**
 * 显示审核对话
 * @param {Object} id
 */
function audit(id){
	flag = 0;
	$(".tips_zb_1").fadeIn(100);
	$("#commentId").val(id);
}
/**
 * 取消审核
 * @param {Object} id
 */
function cancelAudit(id){
	var url = pathHeader + "/edupm/projectmanage/auditTeacher.do";
	$.ajax({
		url:url,
		data:{
			commentId:id,
			status:11,
			auditMemo:""
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				showOrgProjectTeachers();
			}
		},
		error:function(){
			jQuery.generalAlert("URL error");
		}
	});
}
/**
 * 不通过原因
 * @param {Object} id
 */
function cancelReason(id){
	var url = pathHeader + "/edupm/projectmanage/getUnpassReason.do";
	$.ajax({
		url:url,
		data:{id:id},
		async:true,
		success:function(data){
			if(data.success){
				$("#reasonMemo").fadeIn(10);
				$("#reason").html(data.reason);
			}
		},
		error:function(){
			jQuery.generalAlert("查询失败，请稍后再试！");
		}
		
	});
}

function toAudit(){
	if(flag == 0){
		auditSingle();
	}else if(flag == 1){
		var ids = "";
		$("input[name='cid']:checked").each(function(){
			ids += $(this).val()+",";
		});
		batchAudit(ids);
	}else if(flag == 2){
		auditAll();
	}else if(flag == 4){
		cancelAuditAll();
	}
}

function auditSingle(){
	var url = pathHeader + "/edupm/projectmanage/auditTeacher.do";
	var status = $("input[name='radio']:checked").val();
	$.ajax({
		url:url,
		data:{
			commentId:$("#commentId").val(),
			status:status,
			auditMemo:$("#auditMemo").val()
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				showOrgProjectTeachers();
			}
		},
		error:function(){
			jQuery.generalAlert("URL error");
		}
	});
}

/**
 * 批量审核
 */
function batchAudit(ids){
	var status = $("input[name='radio']:checked").val();
	var url = pathHeader + "/edupm/projectmanage/batchAudit.do";
	if(ids.length>0){
			$.ajax({
			url:url,
			data:{
				ids:ids.substring(0,ids.length-1),
				status:status,
				auditMemo:$("#auditMemo").val()
			},
			type:"post",
			async:true,
			success:function(data){
				if(data.success){
					$("#all").attr("checked",false);
					showOrgProjectTeachers();
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
 * 显示审核对话 -- 用于批量审核
 * @param {Object} id,type:审核类型
 */
function showForBatch(type){
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
 * 批量取消审核
 * @memberOf {TypeName} 
 */
function batchCancelAudit(){
	var ids = "";
	$("input[name='cid']:checked").each(function(){
		ids += $(this).val()+",";
		});
	if(ids.length > 0){
		var url = pathHeader + "/edupm/projectmanage/batchCancelAudit.do";
		$.ajax({
			url:url,
			data:{ids:ids},
			type:"post",
			async:true,
			success:function(data){
				if(data.success){
					$("#all").attr("checked",false);
					showOrgProjectTeachers();
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
 * 审核全部
 */
function auditAll(){
	var url = pathHeader + "/edupm/projectmanage/auditAll.do";
	var status = $("input[name='radio']:checked").val();
	$.ajax({
		url:url,
		data:{
			projectId : projectId,
			provinceId : provinceId,
			cityId : cityId,
			districtId : districtId,
			schoolId :schoolId,
			areaId:$("#areaId").val(),
			subject : $('#subject').find("option:selected").val(),
			status:$("#status").val(),//查询条件
			auditSatus:status,//审核状态
			auditMemo:$("#auditMemo").val()
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				showOrgProjectTeachers();
			}
		},
		error:function(){
			
		}
	});
	
}

var provinceId = null;
var provinceName= null;
var cityId= null;
var cityName= null;
var districtId= null;
var districtName = null;
var schoolId  = null;
var schoolType = null;
var schoolName = null;
/**
 * 全部取消审核
 */

function cancelAuditAll(){
	var url = pathHeader + "/edupm/projectmanage/cancelAuditAll.do";
	var status = $("input[name='radio']:checked").val();
	$.ajax({
		url:url,
		data:{
			projectId : projectId,
			provinceId : provinceId,
			cityId : cityId,
			districtId : districtId,
			schoolId :schoolId,
			subject : $('#subject').find("option:selected").val(),
			status:$("#status").val(),//查询条件
			areaId:$("#areaId").val()
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				showOrgProjectTeachers();
			}
		},
		error:function(){
			
		}
	});
	
}


function onClick(e,treeId, treeNode) {
	//  jQuery.generalAlert(treeNode.id + ", -" + treeNode.name+", " + treeNode.type+",isSchool= " + treeNode.isSchool);
	/*	
	  		if(treeNode.isSchool ==="true"){ //学校类型
	  			$("#txtSchoolType").val(treeNode.type);
	  			$("#txtDistrictId").val(treeNode.pId);
	  		}else if(treeNode.isSchool ==="school"){ //学校类型
	  			$("#txtSchoolId").val(treeNode.id);
	  			alert(treeNode);
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
	  		}*/
	  		
//	  		queryTeacher(treeNode.id);
			$("#areaId").val(treeNode.id);
	  		showOrgProjectTeachers();
}

function cancelRegistrationAll(){
	jQuery.confirmWindow(
			"提示",
			"是否将全部教师取消报名？",
			function() {
				var url = pathHeader + "/edupm/projectmanage/cancelRegistrationAll.do";
				$.ajax({
					url:url,
					data:{
						projectId : projectId
					},
					type:"post",
					async:true,
					success:function(data){
						if(data.success){
							showOrgProjectTeachers();
						}
					},
					error:function(){
						
					}
				});
			});
	
}