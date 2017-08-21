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
	
	showOrgProjectTeachers();
	// 查询地区
	areaList(0, 'provinceId');
	// 查询学科
	querySubject();
	
	// 省变更
	$('#provinceId').change(function(){
		$('#cityId').empty();
		$('#cityId').append("<option value=''>请选择市</option>");
		$('#districtId').empty();
		$('#districtId').append('<option value="">请选择区/县</option>');
		$('#schoolId').empty();
		$('#schoolId').append('<option value="">请选择学校</option>');
		if($(this).val() == ''){
			return false;
		}
		areaList($(this).val(), 'cityId');
	});
	
	// 市变更
	$('#cityId').change(function(){
		$('#districtId').empty();
		$('#districtId').append('<option value="">请选择区/县</option>');
		$('#schoolId').empty();
		$('#schoolId').append('<option value="">请选择学校</option>');
		if($(this).val() == ''){
			return false;
		}
		areaList($(this).val(), 'districtId');
	});
	
	// 区/县变更
	$('#districtId').change(function(){
		$('#schoolId').empty();
		$('#schoolId').append('<option value="">请选择学校</option>');
		if($(this).val() == ''){
			return false;
		}
		areaList($(this).val(), 'schoolId');
	});
	
	// 条件查询
	$("#select").click(function() {
		showOrgProjectTeachers();
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


function initSelect(){
	$(".select1").uedSelect( {
					width : 345
				});
				$(".select2").uedSelect( {
					width : 167
				});
				$(".select3").uedSelect( {
					width : 100
				});
}
// 创建opt
function createOpt(rows,sid){
	for(var i = 0;i<rows.length;i++){
		var opt = "<option value='"+rows[i].dictionaryName+"'>"+rows[i].dictionaryName+"</option>";
		$("#"+sid).append(opt);
	}
}

/**
 * 查询学科
 */
function querySubject(){
	queryDic("project_subject")
	if(subject.length > 0){
		createOpt(subject,"subject");
	}
}

/**
 * 查询字典表
 */
var section;
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
function areaList(belong, area){
	var url = pathHeader + "/sys/areaList.do";
	$.ajax({
		url:url,
		data:{
			belong:belong
		},
		dataType:"json",
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				var obj = eval(data.obj);
//				if(area == 'cityId'){
//					$opt = $("<option value=''>请选择市</option>");
//				}else if(area == 'districtId'){
//					$opt = $('<option value="">请选择区/县</option>');
//				} else if(area =='schoolId'){
//					$opt = $('<option value="">请选择学校</option>');
//				}else {
//					$opt = '';
//				}
//				$('#'+area).append($opt);
				if(obj.length > 0){
					for(var i=0; i<obj.length; i++){
						$opt2 = $("<option value='" + obj[i].code + "'>" + obj[i].name + "</option>");
						$('#'+area).append($opt2);
					}
				}
			}
		},
		error:function(){
			jQuery.generalAlert(" error");
		}
	});
}


function showOrgProjectTeachers(){
	$('#teacher_list').html('');
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + '/edupm/projectmanage/teacherListForAuditbutongguo.do',
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
//				$('#projectName').html('项目名称：'+objList[0].projectName);
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



//审核通过
function auditChaxunbaomingtongguo(projectId){
	var url = pathHeader + "/edupm/projectmanage/auditChaxunbaomingtongguo.htm?&projectId="+projectId+"&click+="+click;
	openWindow(url);
}
//未通过

function auditChaxunbaomingtongguogeqiu(projectId){
	var url = pathHeader + "/edupm/projectmanage/auditChaxunbaomingtongguogeqiu.htm?&projectId="+projectId+"&click+="+click;
	openWindow(url);
}

//全部
function auditChaxunbaoming(projectId){
	var url = pathHeader + "/edupm/projectmanage/toTeacherListForAuditchaxunbaoming.htm?&projectId="+projectId+"&click+="+click;
	openWindow(url);
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
	/*gridHtml += "<td><input type='checkbox' name='cid' value='"+obj.id+"'></td>";*/
	gridHtml += "<td>"+name+"</td>";
	/*gridHtml += "<td>"+idc+"</td>";*/
	gridHtml += "<td>"+sub+"</td>";
	gridHtml += "<td>"+pn+"</td>";
	gridHtml += "<td>"+cn+"</td>";
	gridHtml += "<td>"+dn+"</td>";
	gridHtml += "<td>"+sn+"</td>";
	gridHtml += "<td>"+mobile+"</td>";
	gridHtml += "<td>"+status+"</td>";
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		if(row.status == 11){
			//returnStr += 	 "<a href='###' class='tablelink' onclick='audit(\"" + row.id + "\");'>审 核</a>&nbsp;&nbsp;&nbsp;";
		}else	if(row.status == 13){
			//returnStr += "<a href='###' class='tablelink' onclick='cancelAudit(\"" + row.id + "\");'>取消审核</a>";
		}else if(row.status == 12){
		//	returnStr += "<a href='###' class='tablelink' onclick='cancelReason(\"" + row.id + "\");'>审核不通过</a>";
		}
		
		return returnStr;
	}
}
/**
 * 显示审核对话
 * @param {Object} id
 */
function audit(id){
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


function lastForSure() {
	clear2();
	if(lastSelect != null && lastSelect.length > 0) {
		var tempArray = lastSelect.split("_");
		if(tempArray[1] == "provinceId") {
			provinceId = tempArray[0];
			provinceName = tempArray[2];
			$('#schoolName').val('');
			$('#schoolName').val(provinceName);
		} else if(tempArray[1] == "cityId") {
			cityId = tempArray[0];
			cityName = tempArray[2];
			$('#schoolName').val('');
			$('#schoolName').val(cityName);
		} else if(tempArray[1] == "districtId") {
			districtId = tempArray[0];
			districtName = tempArray[2];
			$('#schoolName').val('');
			$('#schoolName').val(districtName);
		} else if(tempArray[1] == "schoolId"){
			schoolId = tempArray[0];
			schoolName = tempArray[2];
			$('#schoolName').val('');
			$('#schoolName').val(schoolName);
		}
	}
	clear();
}
function clear2(){
	provinceId = "";
	cityId = "";
	districtId="";
	schoolId = "";
}


function onClick(e,treeId, treeNode) {
	//  jQuery.generalAlert(treeNode.id + ", -" + treeNode.name+", " + treeNode.type+",isSchool= " + treeNode.isSchool);
		
//	  		if(treeNode.isSchool ==="true"){ //学校类型
////	  			jQuery.generalAlert('小学');
//	  			$("#txtSchoolType").val(treeNode.type);
//	  			$("#txtDistrictId").val(treeNode.pId);
//	  		}else if(treeNode.isSchool ==="school"){ //学校类型
//	  			$("#txtSchoolId").val(treeNode.id);
//	  		}else{
//	  			var type=treeNode.type;
//	  			if(type=="0"){
//		  			$("#txtProvinceId").val(treeNode.id);
//		  			$("#txtCityId").val("");
//		  			$("#txtDistrictId").val("");
//		  			$("#txtSchoolId").val("");
//	  			}else if(type=="1"){
//		  			$("#txtCityId").val(treeNode.id);
//		  			$("#txtDistrictId").val("");
//		  			$("#txtSchoolId").val("");
//	  			}else if(type=="2"){
//		  			$("#txtDistrictId").val(treeNode.id);
//		  			$("#txtSchoolId").val("");
//	  			}
//	  		}
	  		
//	  		queryTeacher(treeNode.id);
			$("#areaId").val(treeNode.id);
	  		showOrgProjectTeachers();
}









