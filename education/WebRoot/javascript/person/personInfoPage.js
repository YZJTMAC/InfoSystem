function saveInfo() {
	if (chk()) {
		$.ajax( {
			url : pathHeader + '/person/setPersonInfo.do',
			type : "POST",
			cache : "false",
			async : "true",
			dataType : "json",
			data : {
				realName : $("#realName").val(),
				idNumber : $("#idNumber").val(),
				mail : $("#mail").val(),
				mobile : $("#mobile").val(),
				paswdQuestionType : $("#paswdQuestionType").val(),
				paswdAnswer : $("#paswdAnswer").val()
			},
			success : function(data) {
				$(".tip1").fadeIn(200);
				if (data.success) {
					$("#msgHtml").html("保存成功！")
					$(".sure1").click(function() {
						toPage(1)
					});

				} else {
					$("#msgHtml").html("保存失败！")
					$(".sure1").click(function() {
						toPage(0)
					});
				}
			},
			error : function() {
				$(".tip1").fadeIn(200);
				$("#msgHtml").html("保存失败！")
				$(".sure1").click(function() {
					toPage(0)
				});
			}
		});
	}
}

function toPage(lx) {
	if (lx == 1) {
		window.location.href = pathHeader
				+ "/person/personInfoPage.htm?click=0";
	} else {
		$(".tip1").fadeOut(100);
	}
}

function nLogin(lx) {
	if (lx == 1) {
		var url = pathHeader + "/person/nLogin.do";
		$.ajax( {
			url : url,
			type : "post",
			async : true,
			success : function(data) {
				window.location.href = pathHeader + "/person/login.htm";

			},
			error : function() {
				window.location.href = pathHeader + "/person/login.htm";
			}
		});
	} else {
		$(".tip1").fadeOut(100);
	}
}

function chk() {
	if ($("#realName").val() == "") {
		$("#realNameHTML").html("真实姓名不能为空！");
		return false;
	} else {
		$("#realNameHTML").html("");
	}
	if ($("#idNumber").val() == "") {
		$("#idNumberHTML").html("身份证号不能为空！");
		return false;
	} else {
		$("#idNumberHTML").html("");
	}
	if ($("#paswdQuestionType").val() != "0" && $("#paswdAnswer").val() == "") {
		$("#paswdAnswerHTML").html("密保答案不能为空！");
		return false;
	} else {
		$("#paswdAnswerHTML").html("");
	}

	return true;
}

function chkPsd() {
	if($("#isSetPassword").val() == 'Y'){
		var mail = $("#mail").val();
		var paswdQuestionType = $("#paswdQuestionType").val();
		var paswdAnswer = $("#paswdAnswer").val();
		
		if(paswdQuestionType == '0'){jQuery.generalAlert("请选择密保问题类型！");return false;}
		flag = (BasicValidate.isNotEmpty(paswdAnswer)) ? true : false;
		if(!flag) {jQuery.generalAlert("密保问题答案不能为空！");return flag;}
		
		flag = BasicValidate.isNotEmpty(mail) ? true : false;
		if(!flag) {jQuery.generalAlert("邮箱地址不能为空！");return flag;}
		
		flag = BasicValidate.checkMail(mail) ? true : false;
		if(!flag) {jQuery.generalAlert("邮箱地址不符合规则！");return flag;}
	}
	if ($("#password").val() == "") {
		$("#oldPsdHTML").html("旧密码不能为空！");
		return false;
	} else {
		if ($("#password").val().toLowerCase() != $("#oldPsd").val().toLowerCase()) {
			$("#oldPsdHTML").html("旧密码不正确！");
			return false;
		} else {
			$("#oldPsdHTML").html("");
		}
	}
	if ($("#newPsd").val() == "") {
		$("#newPsdHTML").html("新密码不能为空！");
		return false;
	} else {
		$("#newPsdHTML").html("");
	}
	if ($("#yesPsd").val() == "") {
		$("#yesPsdHTML").html("确认密码不能为空！");
		return false;
	} else {
		if ($("#newPsd").val() != $("#yesPsd").val()) {
			$("#yesPsdHTML").html("两次输入密码不一致！");
			return false;
		} else {
			$("#yesPsdHTML").html("");
		}
	}

	return true;
}

function savePsd() {
	if (chkPsd()) {
		$.ajax( {
			url : pathHeader + '/person/setPersonPsd.do',
			type : "POST",
			cache : "false",
			async : "true",
			dataType : "json",
			data : {
				password : $("#newPsd").val(),
				mail : $("#mail").val(),
				paswdQuestionType : $("#paswdQuestionType").val(),
				paswdAnswer : $("#paswdAnswer").val()
				
			},
			success : function(data) {
				$(".tip1").fadeIn(200);
				if (data.success) {
					$("#msgHtml").html("保存成功！")
					$(".sure1").click(function() {
						nLogin(1);
					});

				} else {
					$("#msgHtml").html("保存失败！")
					$(".sure1").click(function() {
						nLogin(0);
					});
				}
			},
			error : function() {
				$(".tip1").fadeIn(200);
				$("#msgHtml").html("保存失败！")
				$(".sure1").click(function() {
					nLogin(0);
				});
			}
		});
	}
}