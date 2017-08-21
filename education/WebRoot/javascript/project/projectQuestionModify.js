var proId = $("#projectId").val();
var paperId =$("#paperId").val();
var length = '${fn:length(oplist)}';
$(function(){
	var i = parseInt('${equ.questionType}');
	var isneed = '${equ.requiredAnswer}';
	
	if(i==0){
		$("#questionType1").val("填空");
	}
	if(i==1){
		$("#questionType1").val("问答");
	}
	if(i==2){
		$("#questionType1").val("单选");
	}
	if(i==3){
		$("#questionType1").val("多选");
	}
	if(isneed=='Y'){
		$("#requiredAnswer1").attr("checked","checked");
	}
	if(isneed=='N'){
		$("#requiredAnswer2").attr("checked","checked");
	}
	
		$("#op2").show();
		$("#btnadd").click(function(){
			$("#op2").show();
		});
			$("#btnsub").click(function(){
			$("#op2").hide();
		});
			var q1 = $("#option11").attr("title");
			$("#op1id").val(q1);
		if(length>1){
			var q2 = $("#option22").attr("title");
				$("#op2id").val(q2);
		}
	
});
function saveQuestion(){
	
	var param = $("#questionForm");
	paperId =$("#paperId").val();
	var qt = $("#questionType1 option:selected").val();
	var isneed = $("input[type='radio']:checked").val();
	var title = $("#title1").val().trim();
	var showStyle = $("#showStyle1").val();
	var rank = $("#rank1").val();
	//var option1 = $("#option11").val().trim();
	//var option2 = "";
	//if(length>1){
	//	option2 = $("#option22").val().trim();
	//	$("#op2id").val();
	//}
	

	$("#questionType").val(qt);
	$("#showStyle").val(showStyle);
	$("#requiredAnswer").val(isneed);
	$("#title").val(title);
	$("#rank").val(rank);
	//$("#option1").val(option1);
	//$("#option2").val(option2);
	
	param.serialize();
	var url = pathHeader + "/edupm/paper/UpdateQuestion.do";
	$("#questionForm").ajaxSubmit({
		url:url,
		type:"post",
		success:function(data){
			jQuery.generalAlert("修改问题成功");
			url1 = pathHeader + "/edupm/paper/toUpdatePaper.htm?click=8&paperId="+paperId;
			window.location.href=url1;
		},
		error:function(){
			jQuery.generalAlert("修改问题失败");
			return
		}
	});
	
	
}

function goback(paperId){
	var url1 = pathHeader + "/edupm/paper/toUpdatePaper.htm?click=8&paperId="+paperId;
	window.location.href=url1;
}