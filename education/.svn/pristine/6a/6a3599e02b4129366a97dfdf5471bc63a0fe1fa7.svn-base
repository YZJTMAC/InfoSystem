/***
 * 使用jquery.validator进行验证，简单而且便于扩展
 */

$(document).ready(function(){
	
});


/**
 * 验证项目名称
 * 
 * @return {TypeName}
 */
function validateName(){
	var name = $("input[name='name']").val();
	if(name.length >0){
		return true;
	}
	return false;
}
/**
 * 验证学分
 * 
 * @return {TypeName}
 */
function validateCredit(){
	var credit = $("input[name='credit']").val();
	if(credit.length >0){
		return true;
	}
	return false;
}
/**
 * 验证学分整数
 * 
 * @return {TypeName}
 */
function validateCreditNum(){
	var credit = $("input[name='credit']").val();
	if(credit.length >0){
		if(!(/^(\+|-)?\d+$/.test( credit ))){
			return false;
		}
		return true;
	}
	return false;
}
/**
 * 验证时间
 * 
 * @return {TypeName}
 */
function validateDate(){
	var start = $("input[name='beginDate']").val();
	var end = $("input[name='endDate']").val();
	if(start.length ==0 || end.length == 0){
		return false;
	}
	return true;
}


/**
 * 验证项目编号
 * 
 * @return {TypeName}
 */
function validateProjectNO(){
	var nn = $("input[name='code']").val();
	if(nn.length > 0){
		return true;
	}
	return false;
}
/**
 * 验证组织单位
 * 
 * @return {TypeName}
 */
function validateOrganizer(){
	var nn = $("input[name='organizer']").val();
	if(nn.length > 0){
		return true;
	}
	return false;
}

function validateYear(){
	var start = $("#beginDate").val();
	var end = $("#endDate").val();
	if(start <= end){
		return true;
	}
	return false;
}
/**
 * 验证项目名称
 * @return {TypeName} 
 */
function validateProName(type){
	var ok = false;
	var url1 = pathHeader + "/edupm/projectmanage/validateTrainProjectName.do";
	$.ajax({
		url:url1,
		data:{projectName:$("input[name='name']").val(),type:type},
		type:"post",
		async:false,
		success:function(data){
			if(data.ok){
				ok = true;
			}
		},
		error:function(){
			
		}
	});
	return ok;
}

/**
 * 验证校本和非培训类项目编号
 * @return {TypeName} 
 */
function validateNO(type){
	var ok = false;
	var url2 = pathHeader + "/edupm/projectmanage/validateTrainProjectNO.do";
	$.ajax({
		url:url2,
		data:{projectNO:$("input[name='code']").val(), type:type},
		type:"post",
		async:false,
		success:function(data){
			if(data.ok){
				ok = true;
			}
		},
		error:function(){
			
		}
	});
	return ok;
}
