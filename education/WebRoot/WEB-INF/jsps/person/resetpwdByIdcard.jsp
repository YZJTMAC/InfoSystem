<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>欢迎登录后台管理系统</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/commonValidate.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/person/findpwdbyemail.js"></script>
		<script type="text/javascript">
			$(document).ready(function(e) {
			    $(".select1").uedSelect({
					width : 345			  
				});
			});
		</script>
	</head>
	<body
		style="background-color:#1c77ac; background-image:url(<%=basePathHeader%>/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
		<div id="mainBody">
			<div id="cloud1" class="cloud"></div>
			<div id="cloud2" class="cloud"></div>
		</div>


		<div class="loginbanner">
			<span id="login_banner"></span>
			<ul>
				<li>
					<a href="<%=basePathHeader%>">回首页</a>
				</li>
				<li>
					<a href="#">帮助</a>
				</li>
				<li>
					<a href="#">关于</a>
				</li>
			</ul>
		</div>

		<div class="loginContent" id="div1" style="margin-top:120px; padding: 40px 0;">
    <h4 style="color:#333; font-size:14px;border-bottom:1px solid #ccc;padding-bottom:20px; margin:0 20px; margin-bottom:15px;display:none;">通过邮箱找回</h4>
    <div class="itab" style="margin-bottom:40px;">
        <ul> 
        <li><a href="###" class="selected" id="3">用户密码重置</a></li> 
        <li><a href="<%=basePathHeader%>/person/login/findPwdByEmail.htm">通过邮箱找回</a></li> 
        <li><a href="<%=basePathHeader%>/person/login/findPwdByQuestion.htm" id="2">通过密保找回</a></li> 
        </ul>
        </div>
    <div class="Uploadxu" style="width:460px;padding-left:20px;"><span class="loadx">&nbsp;</span><span class="txtcolor">步骤1：输入您的账号信息</span><span class="loadx">&nbsp;</span><span>步骤2：重置密码</span></div>
      <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto; margin-top:20px;">
        <tr>
          <td align="right" style="padding-right:6px;">真实姓名：</td>
          <td><input id="userName" name="input2" type="text" class="scinput"/></td>
        </tr>
        <tr>
          <td width="110" align="right" style="padding-right:6px;">身份证号：</td>
          <td><input id="loginAccount" name="input2" type="text" class="scinput"/></td>
        </tr>
        <tr>
          <td align="right" style="padding-right:6px;">验证码：</td>
          <td><table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><input id="randcode" name="input2" type="text" class="scinput" style="width:100px;"/></td>
    <td width="10"></td>
    <td><img src="<%=basePathHeader%>/randServlet"/></td>
  </tr>
</table>
</td>
        </tr>
        <tr>
            <td></td>
            <td id="msg1" style="color: #c00; margin-bottom: 10px; margin-top: -10px;font-size:12px;display: none"></td>
          </tr>
        <tr>
          <td>&nbsp;</td>
          <td><a href="#" onclick="resetUserPwd();" class="dian3">重置密码</a></td>
        </tr>
      </table>
    </div>
<div class="loginContent" id="div2" style="margin-top:120px; padding: 40px 0;display: none">

<div class="itab" style="margin-bottom:40px;">
        <ul> 
        <li><a href="###" class="selected" id="3">用户密码重置</a></li> 
        <li><a href="<%=basePathHeader%>/person/login/findPwdByEmail.htm" id="1">通过邮箱找回</a></li>  
        <li><a href="<%=basePathHeader%>/person/login/findPwdByQuestion.htm" id="2">通过密保找回</a></li> 
        </ul>
        </div>
    <div class="Uploadxu" style="width:460px;padding-left:20px;"><span class="loadx">&nbsp;</span><span class="txtcolor">步骤1：输入您的账号信息</span><span class="loadx">&nbsp;</span><span>步骤2：重置密码</span></div>
      
      <div class="usual" style="width:100%"> 
    
        
        <div id="tab1" >
          <h2>密码已经被重置！</h2>
          <p style="width:100%;color: #c00;" id="tipMsg"></p>
        </div>
        <div id="tab2" style="display:none;">
          <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto; margin-top:20px;">
        <tr>
          <td></td>
          <td><table border="0" cellspacing="0" cellpadding="0" style="margin:20px 0;">
		  <tr>
		    <td width="111"><a href="#" class="dian3">确 定</a></td>
		    <td width="60"></td>
		    <td width="111"><a href="#" class="dian3">返 回</a></td>
		  </tr>
		</table></td>
        </tr>
      </table>
  
        </div>
   </div> 


</div>

		<div class="loginbm">
			<%@include file="../common/buttom.jsp"%>
		</div>

	</body>
</html>