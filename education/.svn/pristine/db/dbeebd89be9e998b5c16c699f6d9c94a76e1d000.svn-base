/**
 * 验证项目名称
 * @return {TypeName} 
 */
function validateName(){
	var name = $("input[name='name']").val();
	if(name.length >0){
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
 * 验证时间
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
	if($("#projectTrainType").val() !=0){
		return true;
	}
	return false;
}