var modelNameFlag = false;
var modelCodeFlag = false;
var	trainTypeFlag = false;
var	trainHourFlag = false;
var	trainScoreFlag = false;
var	startDateFlag = false;
var	endDateFlag = false;

$(function(){
	queryPxxsList();
	queryXiangMuList();
	initSelectClass();
})

//培训形式
function queryPxxsList(){
	var url = pathHeader+ "/org/queryPxxsList.do";
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
				$("#trainType").append("<option  value=''>请选择</option>");
				$.each(data.rows, function(key, value) {
					$("#trainType").append(
							"<option  value=\"" + value.dictionaryName + "\">"
							+ value.dictionaryName + "</option>");
				});
			}
		},
		error:function(){
			
		}
	});
	
}


function queryXiangMuList(){
	var url = pathHeader+ "/org/queryXiangMuList.do";
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
			$("#modelCode").append("<option  value=''>请选择</option>");
			$.each(data.rows, function(key, value) {
				$("#modelCode").append(
					"<option  value=\"" + value.dictionaryId + "\">"
					+ value.dictionaryName + "</option>");
			});
			}
		},
		error:function(){
			
		}
	});
	
}

/**
 * 检测继教板块明是否存在
 * */
function isModelNameExists(){
	var isExists = true;//默认是存在的
	var modelName = $('#modelName').val();
	var url = pathHeader+ "/edupm/projectmanage/isModelNameExists.do";
	$.ajax({
		url:url,
		data:{
			modelName:modelName
		},
		type:"post",
		async:false,
		success:function(data){
			if(data.success){
				isExists = false;
			}else{
				isExists = true;
				$('#modelNameError').html(data.info);
			}
		},
		error:function(){
		}
	});
	
	return isExists;
}

/**
 * 检测继教板块明是否存在
 * */
function isModelCodeExists(){
	var isExists = true;//默认是存在的
	var url = pathHeader+ "/edupm/projectmanage/isModelCodeExists.do";
	var modelCode = $('#modelCode').val();
	$.ajax({
		url:url,
		data:{
			code:modelCode
		},
		type:"post",
		async:false,
		success:function(data){
			if(data.success){
				isExists = false;
			}else{
				isExists = true;
				$('#modelCodeError').html(data.info);
			}
		},
		error:function(){
		}
	});
	
	return isExists;
}

function saveInfo(){
	

	$('#modelNameError').html("");
	if ($("#modelName").val() == null || $("#modelName").val() == "") {
		$('#modelNameError').html("名称不能为空!");
		return false;
	} else if (isModelNameExists()) {
		$('#modelNameError').html("名称已经存在");
		return false;
	}

	$('#modelCodeError').html("");
	if ($("#modelCode").val() == null || $("#modelCode").val() == "") {
		$('#modelCodeError').html("请选择项目性质!");
		return false;
	} else if (isNaN($("#modelCode").val())) {
		$('#modelCodeError').html("编码不能是非数字	!");
		return false;
	} 
	/*else if (isModelCodeExists()) {
		$('#modelCodeError').html("编码已经存在");
		return false;
	}*/


	$('#trainScoreError').html("");
	if($("#trainScore").val()==null||$("#trainScore").val()==""){
	$('#trainScoreError').html("学分不能为空!");
		return false;
	}else if(isNaN($("#trainScore").val())){
		$('#trainScoreError').html("学分不能是非数字!");
		return false;
	}
	
	

	// 开始日期验证
	$('#startDateError').html("");
	if ($("#startDate").val() == null || $("#startDate").val() == "") {
		$('#startDateError').html("不能为空!");
		return false;
	} else {
		var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;
		var r = $("#startDate").val().match(reg);
		if (r == null) {
			$('#startDateError').html("输入的日期格式不正确!");
			return false;
		}
	}

	$('#endDateError').html("");
	if ($("#endDate").val() == null || $("#endDate").val() == "") {
		$('#endDateError').html("不能为空!");
		return false;
	} else {
		var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;
		var r = $("#endDate").val().match(reg);
		if (r == null) {
			$('#endDateError').html("输入的日期格式不正确!");
			return false;
		}
	}

	// 日期比较
	var startDate = $("#startDate").val().replace(/-/g, "");
	var endDate = $("#endDate").val().replace(/-/g, "");

	if (startDate - endDate > 0) {
		$('#endDateError').html("开始日期大于结束日期");
		return false;
	}
	
	
	$('#trainTypeError').html("");
	var trainType = $("#trainType").val();
	if($.trim(trainType)==null || $.trim(trainType)==""){
		$('#trainTypeError').html("请选择类型!");
		return false;
	}
	
	
	var modelName = $('#modelName').val();
	var modelCode = $('#modelCode').val();
	var trainType = $('#trainType').val();
	var trainHour = $('#trainHour').val();
	var trainScore = $('#trainScore').val();
	var startDate = $('#startDate').val();
	var status = $('#status').val();
	var endDate = $('#endDate').val();
	var memo = $('#memo').val();
	var url = pathHeader +"/edupm/projectmanage/addModelInfo.do";
//	 按钮置灰
		$("#save").attr({"disabled":"disabled"});
		$.ajax({
		url : url,
		type:"POST",
		async:"true",
		data:{
		modelName:modelName,
		modelCode:modelCode,
		trainType:trainType,
		trainHour:trainHour,
		trainScore:trainScore,
		startDate:startDate,
		endDate:endDate,
		status:status,
		memo:memo
		},
		success:function(data){
			if(data.success) 
			{
			urlGo=pathHeader +"/edupm/projectmanage/toModelListPage.htm";	
			
			jQuery.generalAlertAndJump("增加成功！",urlGo);
			}else{
				jQuery.generalAlert("增加失败,失败原因。"+data.info);	
			}
		},
		error:function(){
			jQuery.generalAlert("增加失败");
		}
	});
}
$(function(){
	$("#modelName").blur(function(){
		$('#modelNameError').html("");
		if($("#modelName").val()==null||$("#modelName").val()==""){
		$('#modelNameError').html("名称不能为空!");
		}else if(isModelNameExists()) {
			$("#modelName").html("");
			modelNameFlag = false;
		}else{
			modelNameFlag = true;
		}
	});
	
	
	
	$("#modelCode").blur(function(){
		$('#modelCodeError').html("");
		if($("#modelCode").val()==null||$("#modelCode").val()==""){
		$('#modelCodeError').html("项目性质不能为空!");
		}else if(isNaN($("#modelCode").val())){
			$('#modelCodeError').html("编码不能是非数字	!");
			$('#modelCodeError').html("");
		}
		
		/*else if(isModelCodeExists()){
			modelCodeFlag = false;
		}else{
			modelCodeFlag = true;
		}*/
	});
	
	$("#trainScore").blur(function(){
		$('#trainScoreError').html("");
		if($("#trainScore").val()==null||$("#trainScore").val()==""){
		$('#trainScoreError').html("学分不能为空!");
		}else if(isNaN($("#trainScore").val())){
			$('#trainScoreError').html("学分不能是非数字!");
		}else{
			trainScoreFlag = true;
		}
	});
		
	$("#trainType").blur(function(){
		$('#trainTypeError').html("");
		if($("#trainType").val()==null||$("#trainType").val()==""){
		$('#trainTypeError').html("请选择类型!");
		}else{
			trainTypeFlag = true;
		}
	});
	
//	$("#trainHour").blur(function(){
//		$('#trainHourError').html("");
//		if($("#trainHour").val().trim()==null||$("#trainHour").val().trim()==""){
//		$('#trainHourError').html("不能为空!");
//		}else{
//			trainHourFlag = true;
//		}
//	});
		
		
	$("#startDate").blur(function(){
		//开始日期验证
		$('#startDateError').html("");
		if($("#startDate").val()==null||$("#startDate").val()==""){
		$('#startDateError').html("不能为空!");
			return false;
		}else{
		    var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;  
		    var r = $("#startDate").val().match(reg);    
		    if(r==null){
		    	$('#startDateError').html("输入的日期格式不正确!");
		    	return false;
		    }
		    
			startDateFlag = true;
		}
		
		
//		$('#startDateError').html("");
//		if($("#startDate").val()==null||$("#startDate").val()==""){
//		$('#startDateError').html("不能为空!");
//		}else{
//			startDateFlag = true;
//		}
	});
	$("#endDate").blur(function(){
		
		$('#endDateError').html("");
		if($("#endDate").val()==null||$("#endDate").val()==""){
		$('#endDateError').html("不能为空!");
		return false;
		}else{
		    var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;  
		    var r = $("#endDate").val().match(reg);    
		    if(r==null){
		    	$('#endDateError').html("输入的日期格式不正确!");
		    	return false;
		    }
		    
		    endDateFlag = true;
		}
//		$('#endDateError').html("");
//		if($("#endDate").val()==null||$("#endDate").val()==""){
//		$('#endDateError').html("不能为空!");
//		}else{
//			endDateFlag = true;
//		}
	});
	
	
	
	
	
});

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
	$(".select4").uedSelect({
		width : 100
	});

}

