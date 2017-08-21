var organizationNameFlag = true;
var contactsFlag = true;
var contactsTypeFlag = true;
var organizationAdderssFlag = true;
var orgCodeFlag = true;

//增加机构 
function saveInfo(){
		if(organizationNameFlag){
			$('#organizationNameError').html("机构名称不能为空!");
			return;
		}
		if(contactsFlag){
			$('#contactsError').html("联系人不能为空!");
			return;
		}
		if(contactsTypeFlag){
			$('#contactsTypeError').html("联系方式不能为空!");
			return;
		}
		if(orgCodeFlag){
			$('#orgCoddeError').html("机构编码不能为空!");
			return;
		}
		if(organizationAdderssFlag){
			$('#organizationAdderssError').html("联系地址不能为空!");
			return;
		}

	var organizationName = $('#organizationName').val();
	var contacts = $('#contacts').val();
	var contactsType = $('#contactsType').val();
	var organizationAdderss = $('#organizationAdderss').val();
	var orgCode = $('#orgCode').val();
	var memo = $('#memo').val();
	var url = pathHeader +"/sys/saveOrganizationInfo.do";
//	 按钮置灰
		$("#submit").attr({"disabled":"disabled"});
		$.ajax({
		url : url,
		type:"POST",
		async:"true",
		data:{
		type:type,
		organizationName:organizationName,
		contacts:contacts,
		contactsType:contactsType,
		orgCode:orgCode,
		organizationAdderss:organizationAdderss,
		memo:memo
		},
		success:function(data){
			if(data.success) 
			{
				if(type==2){
			urlGo=pathHeader +"/sys/organizationList.htm?click=4";	
				}else{
			urlGo=pathHeader +"/sys/cpOrganizationList.htm?click=4";	
				}
			window.location.href=urlGo;
			}
			else{
				jQuery.generalAlert("添加失败"+data.resultReason);
			}
		},
		error:function(){
			jQuery.generalAlert("增加失败");
		}
	});
}
$(function(){
	$("#organizationName").blur(function(){
		$('#organizationNameError').html("");
		if(Trim($("#organizationName").val())==null || Trim($("#organizationName").val())==""){
		$('#organizationNameError').html("机构名称不能为空!");
		}else{
			organizationNameFlag = false;
		}
	});
	
	$("#contacts").blur(function(){
		$('#contactsError').html("");
		if(Trim($("#contacts").val())==null||Trim($("#contacts").val())==""){
		$('#contactsError').html("联系人不能为空!");
		}else{
			contactsFlag = false;
		}
	});
	
	$("#contactsType").blur(function(){
		$('#contactsTypeError').html("");
		if(Trim($("#contactsType").val())==null || Trim($("#contactsType").val())==""){
		$('#contactsTypeError').html("联系方式不能为空!");
		}else{
			contactsTypeFlag = false;
		}
	});
	
	$("#organizationAdderss").blur(function(){
		$('#organizationAdderssError').html("");
		if(Trim($("#organizationAdderss").val())==null||Trim($("#organizationAdderss").val())==""){
		$('#organizationAdderssError').html("联系地址不能为空!");
		}else{
			organizationAdderssFlag = false;
		}
	});
	
	$("#orgCode").blur(function(){
		$('#orgCodeError').html("");
		if(Trim($("#orgCode").val())==null||Trim($("#orgCode").val())==""){
		$('#orgCodeError').html("机构编码不能为空!");
		}else{
			orgCodeFlag = false;
		}
	});
	
});

