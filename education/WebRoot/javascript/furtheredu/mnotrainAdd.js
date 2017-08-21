$(function(){
	initSelect();
	var year=$("#year").val();
	var year_ = new Date().getFullYear();
	for (i = year_; i > 2013; i--)
	{
		if(year==i){
			$('.yearpicker1').append($('<option selected/>').val(i).html(i));
		}else{
			$('.yearpicker1').append($('<option />').val(i).html(i));
		}
		
	} 
});

function initSelect(){
	//继教信息模块
	 initEduModel();
}




function createCommonOpt(rows,sid,cid){
	var cidvalue=$("input[name='"+cid+"']").val();
	var opt = "<option value='0'>请选择</option>";
	for(var i = 0;i<rows.length;i++){
		opt += "<option value='"+rows[i].id+"' ";
		if(cidvalue==rows[i].id){
			opt +=" selected";
		}
		opt += ">"+rows[i].text+"</option>";
	}
	$("#"+sid).append(opt);
}

function savePro(){
	$("#submitPro").attr("disabled",true);
	setValue();
	var url = pathHeader+"/furtheredu/certificate/addMnotrain.do";
	if(!validateName()){
		jQuery.generalAlert("请填写项目名称！");
		$("input[name='name']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	
	if(!validateProjectNO()){
		jQuery.generalAlert("请填写项目编号！");
		$("input[name='code']").focus();
		$("#submitPro").attr("disabled",false);
		return;
	}
	if(!validateOrganizer()){
		jQuery.generalAlert("请填写组织单位！");
		$("input[name='organizer']").focus();
		$("#submitPro").attr("disabled",false);
		return;
	}
	if(!validateCredit()){
		jQuery.generalAlert("请填写学分！");
		$("input[name='credit']").focus();
		$("#submitPro").attr("disabled",false);
		return;
	}
	
	if(!validateCreditNum()){
		jQuery.generalAlert("学分必须是整数！");
		$("input[name='credit']").focus();
		$("#submitPro").attr("disabled",false);
		return;
	}
	
	if(!validateDate()){
		jQuery.generalAlert("请填写项目开始时间或结束时间！");
		$("input[name='beginDate']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	if(!validateYear()){
		jQuery.generalAlert("开始时间不能大于结束时间！");
		$("input[name='beginDate']").focus();
		$("#submitPro").attr("disabled",false);
		return;
	}
	
	
	//验证项目名称是否已经存在
	if(!validateProName("2")){
		jQuery.generalAlert("项目名称已经存在！");
		$("#submitPro").attr("disabled",false);
		return ;
	}
	//验证项目编号
	if(!validateNO("2")){
		jQuery.generalAlert("项目编号已经存在！");
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	
	var yearvalue=$("#selectYear option:selected").text();
	$("input[name='year']").val(yearvalue);
	$("#proForm").ajaxSubmit({
		url:url,
		async:false,
		type:"post",
		dataType:"json",
		success:function(data){
			if(data){
				jQuery.generalAlert("保存成功！");
				url = pathHeader + "/furtheredu/certificate/mnotrainListPage.htm?click=7";
				setInterval(function() {
					openWindow(url);
				}, 2000);
			}else{
				jQuery.generalAlert("保存失败！");
				$("#submitPro").attr("disabled",false);
			}
		},
		error:function(){
			$("#submitPro").attr("disabled",false);
		}
	});
}



function updatePro (){
	$("#submitPro").attr("disabled",true);
	setValue();
	var url = pathHeader+"/furtheredu/certificate/addMnotrain.do";
	if(!validateName()){
		jQuery.generalAlert("请填写项目名称！");
		$("input[name='name']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	
	if(!validateProjectNO()){
		jQuery.generalAlert("请填写项目编号！");
		$("input[name='code']").focus();
		$("#submitPro").attr("disabled",false);
		return;
	}
	if(!validateOrganizer()){
		jQuery.generalAlert("请填写组织单位！");
		$("input[name='organizer']").focus();
		$("#submitPro").attr("disabled",false);
		return;
	}
	if(!validateCredit()){
		jQuery.generalAlert("请填写学分！");
		$("input[name='credit']").focus();
		$("#submitPro").attr("disabled",false);
		return;
	}
	
	if(!validateCreditNum()){
		jQuery.generalAlert("学分必须是整数！");
		$("input[name='credit']").focus();
		$("#submitPro").attr("disabled",false);
		return;
	}
	
	if(!validateDate()){
		jQuery.generalAlert("请填写项目开始时间或结束时间！");
		$("input[name='beginDate']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	if(!validateYear()){
		jQuery.generalAlert("开始时间不能大于结束时间！");
		$("input[name='beginDate']").focus();
		$("#submitPro").attr("disabled",false);
		return;
	}
	
	var yearvalue=$("#selectYear option:selected").text();
	$("input[name='year']").val(yearvalue);
	$("#proForm").ajaxSubmit({
		url:url,
		async:false,
		type:"post",
		dataType:"json",
		success:function(data){
			if(data){
				jQuery.generalAlert("更新成功！");
				url = pathHeader + "/furtheredu/certificate/mnotrainListPage.htm?click=7";
				setInterval(function() {
					openWindow(url);
				}, 2000);
			}else{
				jQuery.generalAlert("更新失败！");
				$("#submitPro").attr("disabled",false);
			}
		},
		error:function(){
			$("#submitPro").attr("disabled",false);
		}
	});
}

function getSelected(sid){
	var value,text;
	text = $("#"+sid+" option:selected").text();
	value = $("#"+sid).val();
	scontent={
		value:value,
		text:text
	};
	return scontent;
}

function setInputValue(name,value){
	$("input[name='"+name+"']").val(value);
}

function setValue(){

	//继教信息
	var modelType = getSelected("modelType");
	setInputValue("modelId",modelType.value);
	setInputValue("modelName",modelType.text);

	
}




function cancel(){
	url = pathHeader + "/furtheredu/certificate/mnotrainListPage.htm?click=7";
	window.location.href=url;
}




function initEduModel(){
	var modelId=$("input[name='modelId']").val();
	var url = pathHeader + "/edupm/projectmanage/queryEduModelNoPage.do";
	$.ajax({
		url:url,
		type:"post",
		async:false,
		success:function(data){
				if(data.success){
					var rows = data.rows;
				var opts = "";
				for(var i = 0;i<rows.length;i++){
					var obj = rows[i];
					opts +="<option value='"+obj.id+"'";
					if(modelId==obj.id){
						opts +=" selected";
					}
					opts +=">";
					opts += obj.name;
					opts+="</option>";
				}
				$("select[name='modelType']").html(opts);
				}
		},
		error:function(){
			alert("初始化继教信息模块失败！");
		}
		
	});
}


function lastForSure() {
	if(lastSelect != null && lastSelect.length > 0) {
		var conditionArray = lastSelect.split("_");
		var belone = conditionArray[0];
		var areaA = conditionArray[1];
		var text = conditionArray[2];
		$('#areaName').val(text);
		$('#scopeName').val(text);
		$('#areaType').val(areaA);
		$('#areaId').val(belone);
	}
	
	//清空
	clear();
	
	$(".tip11").fadeOut(200);
}



