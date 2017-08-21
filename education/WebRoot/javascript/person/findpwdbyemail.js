$(function(){
	initBannerInfo();
});

function initBannerInfo(){
	var platformSetup = SysCode.getJsonArray("SYS_PLATFORM_SETUP", "")[0].text;
	$("#login_banner").html(platformSetup.sysName);
}

function chk() {
	var loginAccount= $("#loginAccount").val();
	var mail = $("#mail").val();
	var randcode = $("#randcode").val();
	if (loginAccount == '用户名' || loginAccount=="") {
		$("#msg").css("display","");
		$("#msg").html("请输入用户名！");
		return false;
	}
	if ( mail=="") {
		$("#msg").css("display","");
		$("#msg").html("请输入邮箱！");
		return false;
	}
	if (randcode == '密码' || randcode=="") {
		$("#msg").css("display","");
		$("#msg").html("请输入验证码！");
		return false;
	}
	$("#dian3").attr('disabled', true);
	var url = pathHeader + "/person/login/chkFindPwdByEmail.do";
	$.ajax( {
		url : url,
		type : "post",
		data : {
			loginAccount : loginAccount,
			mail : mail,
			randcode:randcode
		},
		async : false,
		success : function(data) {
			if (data.success) {
				$("#div1").hide();
				$("#div2").show();
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

function chkUpdate() {
	
	var loginAccount= $("#loginAccount").val();
	var password = $("#password").val();
	var password1 = $("#password1").val();
	
	if (loginAccount == '用户名' || loginAccount=="") {
		$("#msg").css("display","");
		$("#msg").html("请输入用户名！");
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
	
	$("#btn").attr('disabled', true);
	var url = pathHeader + "/person/login/updatePasswordByMail.do";
	$.ajax( {
		url : url,
		type : "post",
		data : {
			loginAccount : loginAccount,
			password : password
			
		},
		async : false,
		success : function(data) {
			if (data.success) {
				window.location.href = pathHeader
						+ "/";
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


function chkFindpwdByQuestion() {
	var loginAccount= $("#loginAccount").val();
	var paswdQuestionType = $("#paswdQuestionType").val();
	var paswdAnswer = $("#paswdAnswer").val();
	var randcode = $("#randcode").val();
	if (loginAccount == '用户名' || loginAccount=="") {
		$("#msg").css("display","");
		$("#msg").html("请输入用户名！");
		return false;
	}
	if (randcode == '密码' || randcode=="") {
		$("#msg").css("display","");
		$("#msg").html("请输入验证码！");
		return false;
	}
	if (paswdQuestionType=="") {
		$("#msg").css("display","");
		$("#msg").html("请选择密保问题！");
		return false;
	}
	if (paswdAnswer=="") {
		$("#msg").css("display","");
		$("#msg").html("请填写密保答案！");
		return false;
	}
	$("#dian3").attr('disabled', true);
	var url = pathHeader + "/person/login/chkFindPwdByQuestion.do";
	$.ajax( {
		url : url,
		type : "post",
		data : {
			loginAccount : loginAccount,
			paswdQuestionType : paswdQuestionType,
			paswdAnswer : paswdAnswer,
			randcode:randcode
		},
		async : false,
		success : function(data) {
			if (data.success) {
				$("#div1").hide();
				$("#div2").show();
				$("#account").html(data.user.loginAccount+"/"+data.user.idNumber);
				$("#loginAccount").val(data.user.loginAccount);
				$("#id").val(data.user.id);
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
function chkUpdateByQuestion() {
	
	var loginAccount= $("#loginAccount").val();
	var password = $("#password").val();
	var password1 = $("#password1").val();
	var id = $("#id").val();
	
	if (loginAccount == '用户名' || loginAccount=="") {
		$("#msg1").css("display","");
		$("#msg1").html("请输入用户名！");
		return false;
	}
	if (password == '密码' || password=="") {
		$("#msg1").css("display","");
		$("#msg1").html("请输入密码！");
		return false;
	}
	if (password1 == '密码' || password1=="") {
		$("#msg1").css("display","");
		$("#msg1").html("请输入确认密码！");
		return false;
	}
	if (password.length<6 || password.length>16) {
		$("#msg1").css("display","");
		$("#msg1").html("请输入6-16位密码，可为英文、数字或下划线，区分大小写！");
		return false;
	}
	if (password1 != password) {
		$("#msg1").css("display","");
		$("#msg1").html("两次输入密码不同！");
		return false;
	}
	$("#btn").attr('disabled', true);
	var url = pathHeader + "/person/login/updatePasswordByMail.do";
	$.ajax( {
		url : url,
		type : "post",
		data : {
			loginAccount : loginAccount,
			password : password,
			id:id
			
		},
		async : false,
		success : function(data) {
			if (data.success) {
				$("#div1").hide();
				$("#div2").show();
				$("#account").html(data.user.loginAccount+"/"+data.user.idNumber);
				$("#loginAccount").val(data.user.loginAccount);
				$("#id").val(data.user.id);
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
			$("#msg1").css("display","");
			$("#msg1").html("服务繁忙，请稍后重试！");
		}
	});
}
//密码重置
function resetUserPwd(){
	var userName= $("#userName").val();
	var loginAccount= $("#loginAccount").val();
	var randcode = $("#randcode").val();
	if (userName=="" || userName.length == 0) {
		$("#msg1").css("display","");
		$("#msg1").html("请输入真实姓名！");
		return false;
	}
	if (loginAccount=="" || loginAccount.length == 0) {
		$("#msg1").css("display","");
		$("#msg1").html("请输入身份证号码！");
		return false;
	}
	if(!BasicValidate.isIdNumber(loginAccount)){
		$("#msg1").css("display","");
		$("#msg1").html("身份证号码不符合规则！");
		return false;
	}
	
	if (randcode=="" || randcode.length == 0) {
		$("#msg1").css("display","");
		$("#msg1").html("请输入验证码！");
		return false;
	}
	$("#btn").attr('disabled', true);
	var url = pathHeader + "/person/login/updatePasswordByIdcard.do";
	$.ajax( {
		url : url,
		type : "post",
		data : {
			userName : userName,
			loginAccount : loginAccount,
			randcode : randcode
		},
		async : true,
		success : function(data) {
			if (data.success) {
				$("#div1").hide();
				$("#div2").show();
				$("#tipMsg").html(data.flag);
				
			} else {
				$("#msg1").css("display","");
				if (data.flag != "") {
					$("#msg1").html(data.flag);
				} 
				else {
					$("#msg1").html("服务繁忙，请稍后重试！");
				}
				
				$("#btn").attr('disabled', false);
			}
		},
		error : function() {
			$("#btn").attr('disabled', false);
			$("#msg1").css("display","");
			$("#msg1").html("服务繁忙，请稍后重试！");
		}
	});
}