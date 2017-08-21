$(function(){
	initStudyType();
	initSelectClass();
})

/**
 * 初始化培训形式
 */
function initStudyType(){
	$("#studyType").html("");
	var url = pathHeader + "/org/queryDictionaryByType.do";
	$.ajax({
		url:url,
		data:{
			dictionaryType:"dependent_study"
		},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
				$("#studyType").append("<option  value=''>请选择</option>");
				$.each(data.rows, function(key, value) {
					$("#studyType").append(
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
 * 不同研修形式，显示不同的说明
 */
function showUp(){
	disapear();
	if($("#studyType").val() == 1){//援教支教
		$("#vtBox").css("display","block");
	}else if($("#studyType").val() == 2){//学历提升
		$("#irsBox").css("display","block");
	}else if($("#studyType").val() == 3){//论文评选
		$("#psBox").css("display","block");
	}else if($("#studyType").val() == 4){//论文发表
		$("#ppBox").css("display","block");
	}else if($("#studyType").val() == 5){//教育科研
		$("#esrBox").css("display","block");
	}else if($("#studyType").val() == 6){//教学竞赛
		$("#tcBox").css("display","block");
	}else if($("#studyType").val() == 7){//培训专家
		$("#teBox").css("display","block");
	}else if($("#studyType").val() == 8){//送培送教
		$("#cctBox").css("display","block");
	}else if($("#studyType").val() == 9){//指导教师
		$("#ttBox").css("display","block");
	}else if($("#studyType").val() == 10){//名师工作坊
		$("#twBox").css("display","block");
	}else if($("#studyType").val() == 11){//学分专员
		$("#oBox").css("display","block");
	}
}
/**
 * 隐藏
 */
function disapear(){
	$("#vtBox").css("display","none");
	$("#irsBox").css("display","none");
	$("#psBox").css("display","none");
	$("#ppBox").css("display","none");
	$("#esrBox").css("display","none");
	$("#tcBox").css("display","none");
	$("#teBox").css("display","none");
	$("#cctBox").css("display","none");
	$("#ttBox").css("display","none");
	$("#twBox").css("display","none");
	$("#oBox").css("display","none");
}



/**
 * 新增
 */
function insert(){

	var credit = 0;
	var annotation = "";
	if($("#studyType").val() == 1){//援教支教
		credit = $("#vtArea").val() * $("#vtTime").val();
		annotation += $("#vtArea option:selected").text() +";"+ $("#vtTime option:selected").text();
	}else if($("#studyType").val() == 2){//学历提升
		credit = $("#irsCertificate").val();
		annotation += $("#irsCertificate option:selected").text();
	}else if($("#studyType").val() == 3){//论文评选
		credit = parseInt($("#psArea").val()) + parseInt($("#psLevel").val());
		credit = credit < 0 ? 0 : credit;
		annotation += $("#psArea option:selected").text() + " ; " + $("#psLevel option:selected").text() ;
	}else if($("#studyType").val() == 4){//论文发表
		credit = $("#ppType").val();
		annotation += $("#ppType option:selected").text();
	}else if($("#studyType").val() == 5){//教育科研
		credit = $("#esrType").val() / $('#esrPepleNum').val();
		annotation += $("#esrType option:selected").text() +";课题牵头人："+ $('#esrPepleNum').val() + "人";
	}else if($("#studyType").val() == 6){//教学竞赛
		credit = parseFloat($("#tcType").val()) + parseFloat($('#tcLevel').val());
		annotation += $("#tcType option:selected").text() + ";" + $("#tcLevel option:selected").text() ;
	}else if($("#studyType").val() == 7){//培训专家
		credit = parseFloat($("#teType").val()) + parseFloat($("#teLevel").val());
		credit = credit == 0 ? 0.5 : credit;
		annotation += $("#teType option:selected").text() + ";" + $("#teLevel option:selected").text() ;
	}else if($("#studyType").val() == 8){//送培送教
		var c2 = $('#cctClass').val();
		if(c2 == null || c2 == ""){
			c2 = 0;
		}
		credit = parseFloat($('#cctDay').val() * 1) + parseFloat(c2 * 0.25);
		annotation += $('#cctDay').val() + "天 加 " + c2 + "节课" ;
	}else if($("#studyType").val() == 9){//指导教师
		credit = parseInt($('#ttNum').val())  * 2 ;
		annotation += "参加" + $('#ttNum').val() + "次";
	}else if($("#studyType").val() == 10){//名师工作坊
		credit = parseFloat($("#twType").val()) + parseFloat($("#twLevel").val());
		if($("#twType").val() == 1 && $("#twLevel").val() == 4){
			credit --;
		}
		if($("#twType").val() == 1 && $("#twLevel").val() == 0){
			credit --;
		}
		annotation += $("#twType option:selected").text() +";"+ $("#twLevel option:selected").text();
	}else if($("#studyType").val() == 11){//学分专员
		credit = 5;
		annotation = $("#studyType option:selected").text();
	}
	$("input[name='isYear']").val($("#yearInsert").val());
	$("input[name='isAnnotation']").val(annotation);
	$("input[name='isStudyTypeId']").val($("#studyType").val());
	$("input[name='isStudyTypeName']").val($("#studyType option:selected").text());
	$("input[name='isCredit']").val(credit);
	
	if(checkout()){
		var url = pathHeader + "/teacher/teacherProject/addInpedtStudy.do";
		$("#proForm").ajaxSubmit({
			url:url,
			async:false,
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.success){
					urlGo=pathHeader +"/teacher/teacherProject/toDeclareIndependentStudy.htm?click=31";	
					jQuery.generalAlertAndJump(data.message,urlGo);
				}else{
					jQuery.generalAlert(data.message);
				}
			},
			error:function(){
				jQuery.generalAlert("新增失败");
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
	if($("#studyType").val() == ""){
		jQuery.generalAlert("请选择研修类型");
		return false;
	}else if($("#studyType").val() == 5){
		if($('#esrPepleNum').val() == ""){
			jQuery.generalAlert("请输入参研人数");
			return false;
		}else if($('#esrPepleNum').val() <= 0 ){
			jQuery.generalAlert("请输入正确参研人数");
			return false;
		}else if(isNaN($("#esrPepleNum").val())){
			jQuery.generalAlert("参研人数不能是非数字");
			return false;
		}
	}else if($("#studyType").val() == 8){
		if($('#cctClass').val() == "" || $('#cctDay').val() == ""){
			jQuery.generalAlert("请输入时长或课节");
			return false;
		}else if($('#cctClass').val() < 0  || $('#cctDay').val() <= 0){
			jQuery.generalAlert("请输入正确时长或课节");
			return false;
		}else if(isNaN($("#cctClass").val()) || isNaN($("#cctDay").val())){
			jQuery.generalAlert("时长或课节不能是非数字");
			return false;
		}
	}else if($("#studyType").val() == 9){
		if($('#ttNum').val() == ""){
			jQuery.generalAlert("请输入参加次数");
			return false;
		}else if($('#ttNum').val() <= 0 ){
			jQuery.generalAlert("请输入正确参加次数");
			return false;
		}else if(isNaN($("#ttNum").val())){
			jQuery.generalAlert("参加次数不能是非数字");
			return false;
		}
	}
	
	return true;
}

function removeMe(o){
	$(o).parent().remove();
}
function addMore(){
	var tr = "<tr><td width='260' colspan='2'><input type='file' name='file'/><a href='###' onclick='removeMe(this)'>删除</a></td></tr>";
	$("#files").append(tr);
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