$(function(){
	initSysSetupInfo();	
	
	// 条件查询
	/*$("#select").click(function() {
		queryMgr();
	});
	
	initSelect();
	*/
});


/*function initSelect(){
	$(".select2").uedSelect( {
		width : 167
	});

	$("dt").attr( {
		'style' : 'width : 100px'
	});
}*/


function initSysSetupInfo(){
	$.ajax({
		url : pathHeader + '/sys/sysSetupInfo.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		success:function(data){
			if(data.success){
				var obj = data.obj;
				
//				$('#roleId').val(data.roleId);
				
				var accountType = obj.accountType;
				for(var i=0; i<accountType.length; i++){
					var val = accountType.split(',')[i]
					setCheckedVal('accountType',val);
				}
				
				setCheckedVal('useTeacherRole',obj.useTeacherRole);
				
				setCheckedVal('openRegisterTeacher',obj.openRegisterTeacher);
				
				//setCheckedVal('teacherInfoChangeAudit', obj.teacherInfoChangeAudit);
				if(obj.teacherInfoChangeAudit == 1){
					$('#zxq_8').attr('checked', 'checked');
				} 
				
				setCheckedVal('teacherInfoSafe', obj.teacherInfoSafe);
				
				setCheckedVal('enableOrg', obj.enableOrg);
				
				$('#teacherModuleAutherName').html(obj.teacherModuleAutherName);
				$('#teacherModuleAutherId').val(obj.teacherModuleAutherId);
				
				$('#furthereduModuleAutherName').html(obj.furthereduModuleAutherName);
				$('#furthereduModuleAutherId').val(obj.furthereduModuleAutherId);
			} else {
				jQuery.generalAlert("查询失败!");
			}
		},
		error:function(){
			jQuery.generalAlert("查询失败!");
		}
	});
}


/**
 * 选择管理员显示查询管理员页面, 隐藏功能设置页面
 */
/*function showAddMgr(type){
	$('#jqDiv1').hide();
	$('#jqDiv2').show();
	
	//createOption();
	queryMgr(type);
}*/


/**
 * 返回/选择管理员后隐藏查询管理员页面, 显示功能设置页面
 */
/*function hideAddMgr(){
	$('#jqDiv1').show();
	$('#jqDiv2').hide();
}
*/

/**
 * 根据当前登陆人的角色生成相对应的角色option
 */
/*function createOption(){
	var roleId = $('#roleId').val();
	var opt = "<option value=''>请选择...</option>";
	if(roleId==1 ||roleId==0){// 省管理员/系统管理员
		opt += "<option value='1'>省管理员</option>";
		opt += "<option value='2'>市管理员</option>";
		opt += "<option value='3'>区县管理员</option>";
		opt += "<option value='4'>学校管理员</option>";
		opt += "<option value='8'>专家</option>";
	} else if(roleId == 2){// 市管理员
		opt += "<option value='2'>市管理员</option>";
		opt += "<option value='3'>区县管理员</option>";
		opt += "<option value='4'>学校管理员</option>";
		opt += "<option value='8'>专家</option>";
	} else if(roleId == 3){// 区县管理员
		opt += "<option value='3'>区县管理员</option>";
		opt += "<option value='4'>学校管理员</option>";
		opt += "<option value='8'>专家</option>";
	} else if(roleId == 4){// 学校管理员
		opt += "<option value='4'>学校管理员</option>";
		opt += "<option value='8'>专家</option>";
	}
	$('#role').append(opt);
	initSelect();
}*/


/**
 * 教师/继教信息模块管理授权查询管理员
 */
/*function queryMgr(){
	$('#mgr_list').html('');
	var pageIndex = $("#pageIndex").val();
	$.ajax( {
		url : pathHeader + '/person/queryManages.do',
		type : "POST",
		cache : "false",
		async : "true",
		dataType : "json",
		data : {
			loginAccount : $('#loginAccount').val(),
			roleId : $('#role').val(),
			pageIndex : pageIndex,
			userProvinceId : $('#schoolProvinceId').val(),
			userCityId : $('#schoolCityId').val(),
			userDistrictId : $('#schoolDistrictId').val()
		},
		success : function(data) {
			if (data.success) {
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList, function(index, element) {
					gridHtml += getTdHtml(element);
				});

				$('#mgr_list').append(gridHtml);
				pagination(data, function() {
					queryMgr();
				});
			} else {
				gridHtml = "<tr><td align='center' colspan='7'>暂无查询结果！</td></tr>";
				$('#mgr_list').append(gridHtml);
			}
		},
		error : function() {
			gridHtml = "<tr><td align='center' colspan='7'>暂无查询结果！</td></tr>";
			$('#mgr_list').append(gridHtml);
		}
	});
}


function getTdHtml(obj) {
	var gridHtml = "<tr>";
	gridHtml += "<td>" + obj.realName + "</td>";
	gridHtml += "<td>" + obj.loginAccount + "</td>";
	gridHtml += "<td>" + obj.password + "</td>";
	gridHtml += "<td>" + obj.roleName + "</td>";
	gridHtml += "<td>" + (obj.userProvinceName!=null?obj.userProvinceName:"")+obj.userCityName+obj.userDistrictName + "</td>";
	gridHtml += "<td>" + obj.userStatus + "</td>";
	gridHtml += "<td>";
	gridHtml += "</td>";
	gridHtml += "</tr>";
	return gridHtml;
}


function clearPCD() {
	$('#schoolProvinceId').val("");
	$('#schoolCityId').val("");
	$('#schoolDistrictId').val("");
	$('#tss').val("");
}
*/








/**
 * 系统功能设置更改
 */
$sysSetup = [];
function modifySysSetup(){
	
	$sysSetup.length = 0;
	var teacherInfoChangeAudit = '';
	if($('#zxq_8').attr('checked')){
		teacherInfoChangeAudit = 1;
	} else {
		teacherInfoChangeAudit = 0;
	}
	
	$sysSetup = {
		accountType : getCheckedVal('accountType'),
		useTeacherRole : getCheckedVal('useTeacherRole'),
		openRegisterTeacher : getCheckedVal('openRegisterTeacher'),
		teacherInfoChangeAudit : teacherInfoChangeAudit,
		enableOrg : getCheckedVal('enableOrg'),
		teacherInfoSafe : getCheckedVal('teacherInfoSafe')
		//teacherInfoChangeAudit : getCheckedVal('teacherInfoChangeAudit'),
		//teacherInfoAuditLevel : getCheckedVal('teacherInfoAuditLevel'),
		//transferAuditLevel : getCheckedVal('transferAuditLevel'),
		//retiredAuditLevel : getCheckedVal('retiredAuditLevel'),
		//furthereduAuditLevel : getCheckedVal('furthereduAuditLevel'),
		//yearAppraisalLevel : getCheckedVal('yearAppraisalLevel')
	}
	
	$.ajax({
		url : pathHeader + '/sys/modifySysSetup.do',
		type:"POST",
		cache:"false",
		data:{data : $.toJSON($sysSetup)},
		async:"true",
		dataType:"json",
		success:function(data){
			if(data.success){
				jQuery.generalAlert("保存成功!");
			} else {
				jQuery.generalAlert("保存失败!");
			}
		},
		error: function(){
			jQuery.generalAlert("保存失败!");
		}
	});
}

/**
 * 当选中不审核时清空别的已选项, 选择别的选项时清空不审核已选项
 * @param {Object} obj
 * @memberOf {TypeName} 
 */
function chickedChange(obj){
	if(obj.value == 0){
		$('input[name=' + obj.name +']').each(function(){
			$(this).attr('checked','');
		});
		$("#"+obj.id).attr('checked','checked');
	} else {
		$('input[name=' + obj.name +'][value=0]').attr('checked','');
	}
}


/**
 * 多选框/单选框选中
 * @param {Object} name
 * @param {Object} val
 * @memberOf {TypeName} 
 */
function setCheckedVal(name, val){
	$('input[name=' + name +']').each(function(){
		if(this.value == val){
			$(this).attr('checked','checked');
		}
	});
}


/**
 * 获取多选框/单选框中选中的值
 * @param {Object} name
 * @memberOf {TypeName} 
 * @return {TypeName} 
 */
function getCheckedVal(name){
	var val = '';
	$('input[name=' + name +']').each(function(){
		if($(this).attr('checked')) {
			val += $(this).val()+',';
		}
	});
	val = val.substring(0, val.length-1);
	return val;
}