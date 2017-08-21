$(function(){
	initSysSetupInfo();	
	
});

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
				
				var accountType = obj.accountType;
				for(var i=0; i<accountType.length; i++){
					var val = accountType.split(',')[i]
					setCheckedVal('accountType',val);
				}
				
				setCheckedVal('useTeacherRole',obj.useTeacherRole);
				
				setCheckedVal('openRegisterTeacher',obj.openRegisterTeacher);
				
				/*var useTeacherRole = obj.useTeacherRole;
				for(var i=0; i<useTeacherRole.length; i++){
					var val = useTeacherRole.split(',')[i]
					setCheckedVal('useTeacherRole',val);
				}
				
				var openRegisterTeacher = obj.openRegisterTeacher;
				for(var i=0; i<openRegisterTeacher.length; i++){
					var val = openRegisterTeacher.split(',')[i]
					setCheckedVal('openRegisterTeacher',val);
				}*/
				
				var teacherInfoChangeAudit = obj.teacherInfoChangeAudit;
				for(var i=0; i<teacherInfoChangeAudit.length; i++){
					var val = teacherInfoChangeAudit.split(',')[i]
					setCheckedVal('teacherInfoChangeAudit', val);
				}
				
				var teacherInfoAuditLevel = obj.teacherInfoAuditLevel;
				for(var i=0; i<teacherInfoAuditLevel.length; i++){
					var val = teacherInfoAuditLevel.split(',')[i]
					setCheckedVal('teacherInfoAuditLevel', val);
				}
				
				var transferAuditLevel = obj.transferAuditLevel;
				for(var i=0; i<transferAuditLevel.length; i++){
					var val = transferAuditLevel.split(',')[i]
					setCheckedVal('transferAuditLevel', val);
				}
				
				var retiredAuditLevel = obj.retiredAuditLevel;
				for(var i=0; i<retiredAuditLevel.length; i++){
					var val = retiredAuditLevel.split(',')[i]
					setCheckedVal('retiredAuditLevel', val);
				}

				var furthereduAuditLevel = obj.furthereduAuditLevel;
				for(var i=0; i<furthereduAuditLevel.length; i++){
					var val = furthereduAuditLevel.split(',')[i]
					setCheckedVal('furthereduAuditLevel', val);
				}

				var yearAppraisalLevel = obj.yearAppraisalLevel;
				for(var i=0; i<yearAppraisalLevel.length; i++){
					var val = yearAppraisalLevel.split(',')[i]
					setCheckedVal('yearAppraisalLevel', val);
				}
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
 * 系统功能设置更改
 */
$sysSetup = [];
function modifySysSetup(){
	
	$sysSetup.length = 0;
	$sysSetup = {
		accountType : getCheckedVal('accountType'),
		useTeacherRole : getCheckedVal('useTeacherRole'),
		openRegisterTeacher : getCheckedVal('openRegisterTeacher'),
		teacherInfoChangeAudit : getCheckedVal('teacherInfoChangeAudit'),
		teacherInfoAuditLevel : getCheckedVal('teacherInfoAuditLevel'),
		transferAuditLevel : getCheckedVal('transferAuditLevel'),
		retiredAuditLevel : getCheckedVal('retiredAuditLevel'),
		furthereduAuditLevel : getCheckedVal('furthereduAuditLevel'),
		yearAppraisalLevel : getCheckedVal('yearAppraisalLevel')
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