<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>

<%@include file="../common/commonHead.jsp"%>
<link />
<script type="text/javascript" src="<%=basePathHeader%>/javascript/editor/kindeditor.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/cloud.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/person/register.js"></script>
<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>

</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div> 


<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
    <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    
    <div class="loginContent">
      <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
        <tr>
          <td width="100"><b>*</b>用户名：</td>
          <td><input name="input2" type="text" class="scinput" id="userName"/><i id="userNameError">4-20位，可为英文、数字或下划线，第一位必须为字母</i></td>
        </tr>
        <tr>
          <td><b>*</b>密 码：</td>
          <td><input name="input2" type="text" class="scinput" id="userPwd"/><i id="userPwdError">6-16位，可为英文、数字或下划线，区分大小写</i></td>
        </tr>
        <tr>
          <td><b>*</b>确认密码：</td>
          <td><input name="input2" type="text" class="scinput" id="surePwd"/><i id="surePwdError">必须和密码一致</i></td>
        </tr>
        <tr>
          <td><b>*</b>真实姓名：</td>
          <td><input name="input2" type="text" class="scinput" id="realName"/><i id="realNameError">2-6个汉字</i></td>
        </tr>
        <tr>
          <td><b>*</b>身份证号：</td>
          <td><input name="input2" type="text" class="scinput" id="idNumber"/><i id="idNumberError">可以使用身份证号+密码进行登录</i></td>
        </tr>
        <tr>
          <td><b></b>电子邮箱：</td>
          <td><input name="input2" type="text" class="scinput" id="email"/><i id="emailError">找回密码时可通过邮箱找回</i></td>
        </tr>
        <tr>
          <td><b></b>手机号码：</td>
          <td><input name="input2" type="text" class="scinput" id="mobile"/><i id="mobileError">方便管理员与你联系</i></td>
        </tr>
        <tr>
          <td><b>*</b>选择密保问题：</td>
          <td><select name="select" class="select2" id="selctPwdProtection">
          <option value="0">请选择</option>
          	<option value="1">你爸爸的名字是？</option>
          	<option value="2">你爸爸的名字是？</option>
          	<option value="3">你爸爸的名字是？</option>
          	<option value="4">你爸爸的名字是？</option>
          </select><i id="selctPwdProtectionError"></i></td>
        </tr>
        <tr>
          <td><b>*</b>设置密保答案：</td>
          <td><input name="input2" type="text" class="scinput" id="pwdProtectionAnswer"/><i id="pwdProtectionAnswerError">账户安全</i></td></td>
        </tr>
        <!--<tr><i>找回密码时可通过密保问题和答案找回</i>
          <td><b>*</b>验证码：</td>
          <td><input name="input2" type="text" class="scinput" style="width:100px;"/></td>
        </tr>-->
        <tr>
          <td></td>
          <td><input name="rt" type="radio" value="" id="imTeacher"/>我是教师<!--<input name="rt" type="radio" value="" style="margin-left:20px;"/>我是管理员-->
		  <input name="" type="checkbox" value="" style="margin-left:20px;" id="alreadyRead"/><a href="#" class="tablelink" style="margin-left:2px; text-decoration:underline;">服务条款已阅读</a></td>
        </tr>
        <tr>
          <td></td>
          <td><a href="##" class="dian3" onclick="chkRegister()">立即注册</a></td>
        </tr>
      </table>
    </div>
    <div class="loginbm">中国教师教育网</div>
</body>


</html>
