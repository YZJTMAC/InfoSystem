var modelNameFlag = false;
var modelCodeFlag = false;
var	trainTypeFlag = false;
var	trainHourFlag = false;
var	trainScoreFlag = false;
var	startDateFlag = false;
var	endDateFlag = false;
$(function(){
	selectInfo();
	//initSelect();
	//培训形式，之前是写死的，现在是从字典里面查询的
	queryPxxsList();
});
function selectInfo(){
	var url = pathHeader +"/edupm/projectmanage/selectModelInfo.do";
		$.ajax({
		url : url,
		type:"POST",
		async:"true",
		data:{
		id:id
		},
		success:function(data){
			if(data.success) 
			{
				var obj = data.info;
			$('#modelName').val(obj.modelName);
			$('#modelCode').val(obj.modelCode);
			$("select[name='trainType']").val(obj.trainType);
			$('#trainHour').val(obj.trainHour);
			$('#trainScore').val(obj.trainScore);
			//ie8 不支持 new Date
			//var start = new Date(obj.startDate).format("yyyy-MM-dd");
			//var end = new Date(obj.endDate).format("yyyy-MM-dd");
			$('#startDate').val(obj.startDate);
			$('#endDate').val(obj.endDate);
			$("#trainType").val(obj.trainType);
			$('#status').val(obj.status);
			if(obj.memo!==null||obj.memo!==""){
			$('#memo').val(obj.memo);
			}
			initSelectClass();
			}
		},
		error:function(){
			jQuery.generalAlert("查询失败!!");
		}
	});
}
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
		$('#modelCodeError').html("编码不能为空!");
		}else if(/^\d+$/.test($("#modelCode").val())){
			$('#modelCodeError').html("编码不能是纯数字	!");
			$('#modelCodeError').html("");
		}else if(isModelCodeExists()){
			modelCodeFlag = false;
		}else{
			modelCodeFlag = true;
		}
	});
	
	$("#trainScore").blur(function(){
		$('#trainScoreError').html("");
		if($("#trainScore").val()==null||$("#modelCode").val()==""){
		$('#trainScoreError').html("编码不能为空!");
		}else if(!/^\d+$/.test($("#trainScore").val())){
			$('#trainScoreError').html("学分应为纯数字	!");
		}else{
			modelCodeFlag = true;
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
		$('#startDateError').html("");
		if($("#startDate").val()==null||$("#startDate").val()==""){
		$('#startDateError').html("不能为空!");
		}else{
			startDateFlag = true;
		}
	});
	$("#endDate").blur(function(){
		$('#endDateError').html("");
		if($("#endDate").val()==null||$("#endDate").val()==""){
		$('#endDateError').html("不能为空!");
		}else{
			endDateFlag = true;
		}
	});
});


function editInfo(){
		$('#modelNameError').html("");
		if($("#modelName").val()==null||$("#modelName").val()==""){
		$('#modelNameError').html("名称不能为空!");
		return false;
		}else if(isModelNameExists()){
			$('#modelNameError').html("名称已经存在");
			return false;
		}
	
		$('#modelCodeError').html("");
		if($("#modelCode").val()==null||$("#modelCode").val()==""){
		$('#modelCodeError').html("编码不能为空!");
		return false;
		}else if(isModelCodeExists()){
			$('#modelCodeError').html("编码已经存在");
			return false;
		}
	
		
		
	
//		$('#trainHourError').html("");
//		if($("#trainHour").val()==null||$("#trainHour").val()==""){
//		$('#trainHourError').html("不能为空!");
//		return false;
//		}
		
		$('#trainScoreError').html("");
		if($("#trainScore").val()==null||$("#modelCode").val()==""){
		$('#trainScoreError').html("编码不能为空!");
			return false;
		}else if(!/^\d+$/.test($("#trainScore").val())){
			$('#trainScoreError').html("学分应为纯数字!");
			return false;
		}
		
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
		}
		
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
		}
		
		//日期比较
		var startDate =$("#startDate").val().replace(/-/g,"");
		var endDate = $("#endDate").val().replace(/-/g,"");
		
		if(startDate-endDate>0){
			$('#endDateError').html("开始日期大于结束日期");
			return false;
		}
		
		
		$('#trainTypeError').html("");
		
		var trainType = $("#trainType").val();
		if($.trim(trainType)==null||$.trim(trainType)==""){
			$('#trainTypeError').html("请选择类型!");
			return false;
		}
		//ie8不支持"str".trim()方法
//		if($("#trainType").val().trim()==null||$("#trainType").val().trim()==""){
//		$('#trainTypeError').html("请选择类型!");
//		return false;
//		}
			
		$('#modelCodeError').html("");
		if($("#modelCode").val()==null||$("#modelCode").val()==""){
		$('#modelCodeError').html("编码不能为空!");
		return false;
		}else if(/^\d+$/.test($("#modelCode").val())){
			$('#modelCodeError').html("编码不能是纯数字	!");
			return false;
		}
		
	var modelName = $('#modelName').val();
	var modelCode = $('#modelCode').val();
	var trainType = $('#trainType').val();
	var trainHour = $('#trainHour').val();
	var trainScore = $('#trainScore').val();
	var startDate = $('#startDate').val();
	var endDate = $('#endDate').val();
	var status = $('#status').val();
	var memo = $('#memo').val();
	var url = pathHeader +"/edupm/projectmanage/editModelInfo.do";
//	 按钮置灰
		$("#saveId").attr({"disabled":"disabled"});
		$.ajax({
		url : url,
		type:"POST",
		async:"true",
		data:{
		id:id,
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
				var url = pathHeader+ "/edupm/projectmanage/toModelListPage.htm?click=19";
				jQuery.generalAlertAndJump("修改成功！",url);
				
			//window.location.href=url;
			}
		},
		error:function(){
			jQuery.generalAlert("增加失败");
		}
	});
}

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

/**
 * 检测继教板块名称是否存在
 * */
function isModelNameExists(){
	var isExists = true;//默认是存在的
	var modelName = $('#modelName').val();
	var url = pathHeader+ "/edupm/projectmanage/isModelNameExistsInEdit.do";
	$.ajax({
		url:url,
		data:{
			modelId:id,
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
	var url = pathHeader+ "/edupm/projectmanage/isModelCodeExistsInEdit.do";
	var modelCode = $('#modelCode').val();
	$.ajax({
		url:url,
		data:{
			modelId:id,
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