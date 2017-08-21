$(function(){
	initLeave();
	initForm();
	initSelectClass();
})

/**
 * 初始化请假原因
 */
function initLeave(){
	$("#reasonInsert").html("");
	var url = pathHeader + "/org/queryDictionaryByType.do";
	$.ajax({
		url:url,
		data:{
			dictionaryType:"leave_type"
		},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
				$("#reasonInsert").append("<option  value=''>请选择</option>");
				$.each(data.rows, function(key, value) {
					$("#reasonInsert").append(
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
 * 初始化培训形式
 */
function initForm(){
	$("#lendForm").html("");
	var url = pathHeader+ "/org/queryPxxsList.do";
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
				$("#lendForm").append("<option  value=''>请选择</option>");
				$.each(data.rows, function(key, value) {
					$("#lendForm").append(
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
 * 新增一条借贷
 */
function insert(){
	var lendYear = $('#yearInsert').val();
	var lendReason = $('#reasonInsert').val();
	var lendCredit = $('#lendCredit').val();
	var lendFormId = $('#lendForm').val();
	var lendFormName = $("#lendForm option:selected").text();
	var url = pathHeader + "/teacher/teacherProject/insertLendCredit.do";
	if(checkout()){
		$.ajax({
			url:url,
			type:"post",
			async:true,
			data:{
				lendYear:lendYear,
				lendReason:lendReason,
				lendCredit:lendCredit,
				lendFormId:lendFormId,
				lendFormName:lendFormName
			},
			success:function(data){
				if(data.success){
					urlGo=pathHeader +"/teacher/teacherProject/toCreditLend.htm?click=27";	
					jQuery.generalAlertAndJump("借贷成功！",urlGo);
				}else{
					jQuery.generalAlert(data.message);
				}
				
			},
			error:function(){
				jQuery.generalAlert("借贷失败");
			}
		});
	}
}

/**
 * 校验
 * @param from
 * @returns {Boolean}
 */
function checkout(){
		var lendYear = $('#yearInsert').val();
		var lendReason = $('#reasonInsert').val();
		var lendCredit = $('#lendCredit').val();
		var lendForm = $('#lendForm').val();
	
	if(lendYear == "" || lendYear == null){
		jQuery.generalAlert("年限为空");
		return false;
	}

	if(lendReason == "" || lendReason == null){
		jQuery.generalAlert("借贷原因为空");
		return false;
	}
	
	if(lendForm == "" || lendForm == null){
		jQuery.generalAlert("培训形式为空");
		return false;
	}

	//验证学分
	$('#lendCreditError').html("");
	if(lendCredit==null||lendCredit.trim()==""){
	$('#lendCreditError').html("学分不能为空!");
		return false;
	}else if(isNaN(lendCredit)){
		$('#lendCreditError').html("学分不能是非数字!");
		return false;
	}
	
	if(!checkLendCredit(lendCredit,lendYear,lendForm)){
		return false;
	}
	
	return true;
}

/**
 * 校验借贷学分的分数
 * @returns {Boolean}
 */
function checkLendCredit(lendCredit, lendYear, lendForm){
	var qualified = false;
	var url = pathHeader
	+ "/teacher/teacherProject/checkLendCredit.do";
		$.ajax( {
					type : "POST",
					url : url,
					data : {
						lendCredit:lendCredit,
						lendYear:lendYear,
						trainForm:lendForm
					},
					async : false,
					success : function(data) {
						if(data.success){
							qualified = true;
						}else{
							jQuery.generalAlert(data.message);
						}
					},
					error : function() {
					}
				});
		
		return qualified;
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