$(function(){
	rememberUser();
});


function chkLogin() {
	var loginAccount= $("#loginAccount").val();
	var password = $("#password").val();
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

	// 设置保存密码
	setCookie(loginAccount, password);
	
	$("#btn").attr('disabled', true);
	var url = pathHeader + "/person/login/exitsUser.do";
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
						+ "/person/index.htm";
			} else {
				$("#msg").css("display","");
				$("#msg").html(data.info);
//				if (data.flag == "-3") {
//					$("#msg").html("用户名或密码错误！");
//				} else if(data.flag == "-4"){
//					$("#msg").html("该帐号未分配角色！");
//				} else if(data.flag == "-5"){
//					$("#msg").html("该角色已被禁用！");
//				}else if(data.flag == "-6"){
//					$("#msg").html("该角色暂无权限！");
//				}else if(data.flag == "-7"){
//					$("#msg").html("该用户审核未通过！");
//				}else if(data.flag == "-55"){
//					$("#msg").html("系统已关闭教师登录！");
//				}else if(data.flag == "-44"){
//					$("#msg").html("该用户已被禁用！");
//				}else if(data.flag == "-11"){
//					$("#msg").html("不允许以身份证的方式登录！");
//				}else if(data.flag == "-22"){
//					$("#msg").html("不允许以帐号的方式登录！");
//				}else if(data.flag == "-33"){
//					$("#msg").html("不允许以教师编号的方式登录！");
//				}else if(data.flag == "-00"){
//					$("#msg").html("系统暂时不允许登录！");
//				}
//				else {
//					$("#msg").html("服务繁忙，请稍后重试！");
//				}
				
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



/**
 * 获取系统平台设置并写入session
 * add by xiao

function getSysPlatformSetup(){
	$.ajax({
		url : pathHeader + '/sys/platform/sysPlatformSetupInfo.do',
		type:"POST",
		cache:"false",
		async:"false",
		dataType:"json",
		success:function(data){
			if(data.success){
				var obj = data.obj;
				//$("#sys_style").find("option[value="+obj.sysStyle+"]").attr("selected",true);
				//initSelect();
				//$('#sys_name').val(obj.sysName);
				//$('#sys_logo').attr('src', pathHeader+'/static/uploadFile/'+obj.sysLogo);
				//$('#login_logo').attr('src', pathHeader+'/static/uploadFile/'+obj.loginLogo);
				//$('#copyright').val(obj.copyrightNotice);
				//$('#contact_way').val(obj.contactWay);
				
				$('#login_logo').css('background', 'url('+ pathHeader+'/static/'+obj.sysLogo+')no-repeat center');
				$('#logininfo_logo').css('background', 'url('+ pathHeader+'/static/'+obj.loginLogo+')no-repeat center');
				
			} else {
				jQuery.generalAlert("查询失败!");
			}
		},
		error:function(){
			jQuery.generalAlert("查询失败!");
		}
	});
}
 */



// 记住密码
function rememberUser()
{  //userName1=userName;Pwd=password   
    if(document.cookie !="")
    {          
     //下面这两句就是用来记住用户名和密码了
     $("#loginAccount").val(getCookie('userName'));
	 $("#password").val(getCookie(' Pwd'));
	 if(getCookie('userName')==""){
		 $("#remeberId").click();	
	 }
    }
}
// 用正则表达式将前后空格,用空字符串替代(PS:因为js没有现成的trim,所以要加上这个)
String.prototype.trim   = function()   
{       
     return   this.replace(/(^s*)|(s*$)/g,   "");   
}
function getCookie(objName)//获取指定名称的cookie的值
{    
    var arrStr = document.cookie.split(";");
        for(var i = 0;i < arrStr.length;i++)
            {
                var temp = arrStr[i].split("=");
               // alert("temp:"+temp);
                if(objName.trim()==temp[0].trim()) //此处如果没有去掉字符串空格就不行,偶在这里折腾了半死,主要是这种错误不好跟踪啊
                {                
                	return temp[1];
                }                            
            }
}

function setCookie(a, b)//设置cookie
{
	var arrayRemember = $("#remeberId").attr("checked");
	if((a !="")&&(b !="") && arrayRemember)
	{
	 	document.cookie ="userName="+a;
	 	document.cookie ="Pwd="+b;
	} else {
		document.cookie ="userName=";
	 	document.cookie ="Pwd=";
	}
}













