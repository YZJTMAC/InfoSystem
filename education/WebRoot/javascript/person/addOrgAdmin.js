//var organizationName;
function chkRegister() {
	var loginAccount= $("#loginAccount").val();
	var password = $("#password").val();
	var password1 = $("#password1").val();
	var realName = $("#realName").val();
	var idNumber = $("#idNumber").val();
	var teacherNo = $("#teacherNo").val();
	var mail = $("#mail").val();
	var mobile = $("#mobile").val();
	var roleId = $("#roleId").val();
	if (roleId=="") {
		$("#msg").css("display","");
		$("#msg").html("请选择角色！");
		return false;
	}
	if (loginAccount == '用户名' || loginAccount=="") {
		$("#msg").css("display","");
		$("#msg").html("请输入用户名！");
		return false;
	}
	var reg = /^[a-zA-Z][a-zA-Z\d]\w{2,18}$/;//正则
	if(reg.test(loginAccount)==false){
		$("#msg").css("display","");
		$("#msg").html("用户名错误，4-20位，可为英文、数字或下划线，第一位必须为字母！");
		return false;
	}
	if (password == '密码' || password=="") {
		$("#msg").css("display","");
		$("#msg").html("请输入密码！");
		return false;
	}
	if (password1 == '密码' || password1=="") {
		$("#msg").css("display","");
		$("#msg").html("请输入确认密码！");
		return false;
	}
	if (password.length<6 || password.length>16) {
		$("#msg").css("display","");
		$("#msg").html("请输入6-16位密码，可为英文、数字或下划线，区分大小写！");
		return false;
	}
	if (password1 != password) {
		$("#msg").css("display","");
		$("#msg").html("两次输入密码不同！");
		return false;
	}
	if (realName=="") {
		$("#msg").css("display","");
		$("#msg").html("请输入真实姓名！");
		return false;
	}
	var reg1 = /^[\u4e00-\u9fa5]+$/gi; 
	if (!reg1.test(realName))  {
		$("#msg").css("display","");
		$("#msg").html("请输入2-6个汉字姓名！");
		return false;
	}
	if (realName.length<2 || realName.length>20)  {
		$("#msg").css("display","");
		$("#msg").html("请输入2-20个汉字姓名！");
		return false;
	}
	/*if (idNumber=="") {
		$("#msg").css("display","");
		$("#msg").html("请输入身份证号！");
		return false;
	}*/
	/*var reg2 = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
	if (reg2.test(idNumber)==false) {
		$("#msg").css("display","");
		$("#msg").html("请输入正确的身份证号！");
		return false;
	}*/
	if(mail!="")
	{
		var reg3 = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if(reg3.test(mail)==false)
		{
			$("#msg").css("display","");
			$("#msg").html("请输入正确的邮箱地址！");
			return false;
		}
	}
	if(mobile!="")
	{
		var reg4 = /^1[3458]\d{9}$/;

		if(reg4.test(mobile)==false)
		{
			$("#msg").css("display","");
			$("#msg").html("请输入正确的手机号！");
			return false;
		}
	}
	$("#btn").attr('disabled', true);
//	getOrgName(organizationId);
	var url = pathHeader + "/person/login/addOrgAdmin.do?organizationId="+organizationId;
	$.ajax( {
		url : url,
		type : "post",
		data : {
			loginAccount : loginAccount,
			password : password,
			mail : mail,
			mobile : mobile,
			roleId : roleId,
			idNumber : idNumber,
			realName : realName,
			teacherNo : teacherNo
			
		},
		async : false,
		success : function(data) {
			if (data.success) {
				var url = pathHeader + "/sys/toOrgAdminsList.htm?click=4&organizationId="+organizationId+"&type="+type;
				window.location.href=url;
			} else {
				$("#msg").css("display","");
				if (data.flag != "") {
					$("#msg").html(data.flag);
				} 
				else {
					$("#msg").html("服务繁忙，请稍后重试！");
				}
				
				$("#btn").attr('disabled', false);
			}
		},
		error : function() {
			$("#btn").attr('disabled', false);
			$("#msg").css("display","");
			$("#msg").html("服务繁忙，请稍后重试！");
		}
	});
}

/*function getOrgName(organizationId){
	var url = pathHeader + "/sys/getOrganizationInfo.do";
	$.ajax({
		url : url,
		type:"POST",
		async:false,
		data:{
		organizationId:organizationId
		},
		success:function(data){
			if(data.success) 
			{
				var obj = data.info;
				if(obj.organizationName!=null){
					organizationName = obj.organizationName;
				}
					}
		},
		error:function(){
			jQuery.generalAlert("失败!");
		}
	});
	
}*/

function clearMsg(index){
	if(index==0 && $("#loginAccount").val()!=""){
		$("#msg").html("");
		$("#msg").css("display","none");
	}
	if(index==1 && $("#password").val()!=""){
		$("#msg").html("");
		$("#msg").css("display","none");
	}
}

function getRoleList() {
	$('#roleId').html('');
	$.ajax( {
				url : pathHeader + '/sys/queryRoleList.do',
				type : "POST",
				cache : "false",
				async : "true",
				dataType : "json",
				data:{onlyShishi:true},
				success : function(data) {
					if (data.success) {
						var objList = data.rows;
						var gridHtml = "<option value=''>请选择...</option>";
						$.each(objList, function(index, element) {
							gridHtml += getTdHtml(element);
						});
						
					}
					$('#roleId').append(gridHtml);
				},
				error : function() {
					
				}
			});
}
function getTdHtml(obj) {
	var gridHtml = "";
	gridHtml += "<option value="+obj.id+">" + obj.roleName + "</option>";
	return gridHtml;
}
$(document).ready(
		function() {
			getRoleList();
		}
);