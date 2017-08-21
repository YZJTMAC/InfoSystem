var proId =$("#proId").val();
var paperId =$("#paperId").val();

function saveQuestion(){
	proId =$("#proId").val();
	paperId =$("#paperId").val();
	var param = $("#questionForm");
	
	var qt = $("#questionType1 option:selected").val();
	var isneed = $("input[type='radio']:checked").val();
	var title = $("#title1").val().trim();
	var showStyle = $("#showStyle1").val();
	var rank = $("#rank1").val();
	var option1 = $("#option11").val().trim();
	var option2 = $("#option21").val().trim();

	$("#questionType").val(qt);
	$("#showStyle").val(showStyle);
	$("#requiredAnswer").val(isneed);
	$("#title").val(title);
	$("#rank").val(rank);
	$("#option1").val(option1);
	$("#option2").val(option2);
	
	param.serialize();
	var url = pathHeader + "/edupm/paper/AddQuestion.do";
	$("#questionForm").ajaxSubmit({
		url:url,
		type:"post",
		success:function(data){
			alert("保存问题成功");
			url1 = pathHeader + "/edupm/paper/toUpdatePaper.htm?click=32&paperId="+paperId;
			window.location.href=url1;
		},
		
	});
	
	
}


function validateNumber(objId){
    var reg = new RegExp("^[0-9]*$");
    var obj = document.getElementById(objId);
    alert(obj.value);
	 if(!reg.test(obj.value)){
	     return false;
	 }
	 if(!/^[0-9]*$/.test(obj.value)){
	     return false;
	 }
 return true;
}


function IsNull(str) {
   if(str==""||str==null){
	   return false;
   }else{
	   return true;
   }
}


function goback(paperId){
	var url = pathHeader + "/edupm/paper/toUpdatePaper.htm?click=32&paperId="+paperId;
	window.location.href=url;
}