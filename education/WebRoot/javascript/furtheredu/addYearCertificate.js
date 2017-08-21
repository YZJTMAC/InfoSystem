$(function(){
	initTrainForm();
})
var forms = null;
function initTrainForm(){
	var url = pathHeader+ "/org/queryPxxsList.do";
	$('#formList').html();
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
				forms = data.rows;
				var htm1 = "";
				$.each(data.rows, function(key, value) {
					htm1 += "<ul  class='seachform' >";
					htm1 += "所需学分("+value.dictionaryName+")：<input name='' type='text' class='scinput' id='diplomaCredit"+value.dictionaryId+"' />";
					htm1 += "所需学时("+value.dictionaryName+")：<input name='' type='text' class='scinput' id='diplomaPeriod"+value.dictionaryId+"' />";
					htm1 += "</ul>";
				});
				$('#formList1').html(htm1);
			}
		},
		error:function(){
		}
	});
}
/**
 * 添加新的年度证书
 * @returns
 */
function saveInfo(){

	//验证证书年度
	$('#diplomaYearError').html("");
	if ($("#diplomaYear").val() == null || $("#diplomaYear").val() == "") {
		$('#diplomaYearError').html("证书年度不能为空");
		return false;
	}
	
	//验证标题
	$('#diplomaTitleError').html("");
	if($("#diplomaTitle").val()==null||$("#diplomaTitle").val().trim()==""){
	$('#diplomaTitleError').html("标题不能为空!");
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
	//结束日期验证
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
	
	//验证比例
	$('#repayRateError').html("");
	if($("#repayRate").val()==null||$("#repayRate").val().trim()==""){
		$('#repayRateError').html("偿还学分转换比例不能为空!");
		b = true;
	}else if(isNaN($("#repayRate").val())){
		$('#repayRateError').html("偿还学分转换比例不能为非数字!");
		b = true;
	}
	
	// 日期比较
	var startDate = $("#startDate").val().replace(/-/g, "");
	var endDate = $("#endDate").val().replace(/-/g, "");
	if (startDate - endDate > 0) {
		$('#endDateError').html("开始日期大于结束日期");
		return false;
	}
	//验证学分、学时
	$('#diplomaError').html("");
	var creditStr = "";
	var periodStr = "";
	var b = false;
	$.each(forms, function(key, value) {
		if($("#diplomaCredit"+value.dictionaryId+"").val()==null||$("#diplomaCredit"+value.dictionaryId+"").val().trim()==""){
			$('#diplomaError').html("学分不能为空!");
			b = true;
		}else if(isNaN($("#diplomaCredit"+value.dictionaryId+"").val())){
			$('#diplomaError').html("学分不能是非数字!");
			b = true;
		}
		if($("#diplomaPeriod"+value.dictionaryId+"").val()==null||$("#diplomaPeriod"+value.dictionaryId+"").val().trim()==""){
			$('#diplomaError').html("学时不能为空!");
			b = true;
		}else if(isNaN($("#diplomaPeriod"+value.dictionaryId+"").val())){
			$('#diplomaError').html("学时不能是非数字!");
			b = true;
		}
		
		creditStr += value.dictionaryName +"-"+$("#diplomaCredit"+value.dictionaryId+"").val()+",";
		periodStr += value.dictionaryName +"-"+$("#diplomaPeriod"+value.dictionaryId+"").val()+",";
	});	

	if(b){
		return false;
	}

	var year = $('#diplomaYear').val();
	var diplomaStartDate = $('#startDate').val();
	var diplomaEndDate = $('#endDate').val();
	var diplomaTitle = $('#diplomaTitle').val();
	var repayRate = $('#repayRate').val();

	var url = pathHeader +"/furtheredu/edumanage/addYearCertificate.do";
		$.ajax({
		url : url,
		type:"POST",
		async:"true",
		data:{
			year:year,
			diplomaStartDate:diplomaStartDate,
			diplomaEndDate:diplomaEndDate,
			diplomaTitle:diplomaTitle,
			creditStr:creditStr,
			periodStr:periodStr,
			repayRate:repayRate
			
		},
		success:function(data){
			if(data.success) 
			{
			urlGo=pathHeader +"/furtheredu/edumanage/toYearPrinterCertificateSetPage.htm?click=24";	
			jQuery.generalAlertAndJump("增加成功！",urlGo);
			}else{
				jQuery.generalAlert(data.message);	
			}
		},
		error:function(){
			jQuery.generalAlert("增加失败");
		}
	});
}



