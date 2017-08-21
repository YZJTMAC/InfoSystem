function validateName(){
	var name = $("input[name='projectName']").val();
	if(name.length >0){
		return true;
	}
	return false;
}


/**
 * 验证项目名称
 * @return {TypeName} 
 */

/*function validateProjectName(){
	var name = $("input[name='projectName']").val();
	var url = pathHeader+ "/org/projectNameList.do";
	
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			$('#projectName').html('');
			if(data.rows.length > 0){
			$.each(data.rows, function(key, value) {
				var projectName = value.projectName;
				if(name == projectName){
					$("input[name='projectName']").parent().append("项目名已存在,请重新填写!");
				}
			});
			}
		},
		
	});
	
}*/




function validateProjectNO(){
	var nn = $("input[name='projectNo']").val();
	if(nn.length > 0){
		return true;
	}
	return false;
}
/**
 * 验证项目编号
 * @return {TypeName} 
 */
/*function validateNO(){
	var id = $("input[name='projectNo']").val();
	var url = pathHeader+ "/org/projectNameList.do";
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			$('#projectNo').html();
			if(data.rows.length > 0){
			$.each(data.rows, function(key, value) {
				var projectNo = value.projectNo;
				
				if(id == projectNo){
					$("input[name='projectNo']").parent().append("项目编号已存在，请重新填写");
				    }
			});
			}
		},
		
	});
	
}*/




/*
 * 验证实施机构
 */

function validateSSOrg(){
	
	var orgId = getSelected("orgId").value;
	if(orgId !=0){
		return true;
	}
	return false;
}
function validateXmxz(){
	var orgId = getSelected("projectScope").value;
	if(orgId !=0){
		return true;
	}
	return false;
}
function validatePxnx(){
	var orgId = getSelected("projectProperty").value;
	if(orgId !=0){
		return true;
	}
	return false;
}

function validatePxxs(){
	var orgId = getSelected("projectTrainType").value;
	if(orgId !=0){
		return true;
	}
	return false;
}

function validatePlanNum(){
	var orgId = $("input[name='planNum']").val();
	if(orgId== null || orgId == ''){
		jQuery.generalAlert("培训人数不能为空！");
		return false;
	}	
	var tt = /^[0-9]*[1-9][0-9]*$/;	
	flag = tt.test(orgId);	
	if(flag){
		return true;
	}
	return false;
}

//验证学分
function validateClassPeriod(){
	var classPeriod = $("input[name='classPeriod']").val();
	if(classPeriod== null || classPeriod == ''){
		jQuery.generalAlert("学时不能为空！");
		return false;
	}
	var tt = /^[1-9][\d]{0,7}$/;	
	flag = tt.test(classPeriod);	
	if(flag){
		return true;
	}else{
		jQuery.generalAlert("学时请填写非0的正整数数字！");
		return false;
	}
}




/**
 * 验证学科
 * @return {TypeName} 
 */

function validateSubject(){

	var vv = $("input[name='subject']").val();

	if(vv.length >0){

		return true;

	}

	return false;

}

/**
 * 验证培训范围
 * @return {TypeName} 
 */

function validateTrainScope(){

	var ss = $("input[name='trainScopeName']").val();
	if(ss.length >0){

		return true;

	}

	return false;

}


//验证开始时间非空
function validateStartDateEmpty(){
	var start = $("input[name='startDate']").val();
	if($.trim(start).length<1 ){
		return false;
	}else{
		return true;
	}
}

//验证开始时间非空
function validateEndDateEmpty(){
	var end = $("input[name='endDate']").val();
	if($.trim(end).length<1 ){
		return false;
	}else{
		return true;
	}
}

/**
 * 验证时间比较
 * @return {TypeName} 
 */
function validateDate(){

	var start = $("input[name='startDate']").val();

	var end = $("input[name='endDate']").val();

	
	var arr1 = start.split("-");

    var arr2 = end.split("-");

    var date1=new Date(parseInt(arr1[0]),parseInt(arr1[1])-1,parseInt(arr1[2]),0,0,0);

    var date2=new Date(parseInt(arr2[0]),parseInt(arr2[1])-1,parseInt(arr2[2]),0,0,0);

    if(date1.getTime()>date2.getTime()) {


    return false;

    }else{

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
 * 验证项目范围
 * @returns {Boolean}
 */
function validateProjectScope(){
//	alert($("input[name='projectScopeId']").val());
	if($("input[name='projectScopeId']").val() !=0){
		return true;
	}
	return false;
}


function validatEduModelType(){
//	alert($("input[name='projectScopeId']").val());
	if($("select[name='eduModelType']").val() != null){
		return true;
	}
	return false;
}


/*$(function(){
	
	
})*/
