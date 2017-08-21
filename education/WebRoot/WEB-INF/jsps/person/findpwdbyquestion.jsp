<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>欢迎登录后台管理系统</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/person/findpwdbyemail.js"></script>
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

		<div id="div1" class="loginContent" style="margin-top:120px; padding: 40px 0;">
    <div class="itab" style="margin-bottom:40px;">
        <ul> 
        <li><a href="<%=basePathHeader%>/person/login/resetpwdByIdcard.htm" id="3">用户密码重置</a></li>
        <li><a href="<%=basePathHeader%>/person/login/findPwdByEmail.htm">通过邮箱找回</a></li> 
        <li><a href="#" class="selected">通过密保找回</a></li> 
        </ul>
        </div>
    <div class="Uploadxu" style=" width:460px;padding-left:20px; margin-bottom:20px;"><span class="loadx">&nbsp;</span><span class="txtcolor">步骤1：输入您的密保信息</span><span class="loadx">&nbsp;</span><span>步骤2：设置新密码</span></div>
      
      <div class="usual" style="width:100%">
      
        <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
          <tr>
            <td width="112" align="right" style="padding-right:6px;">用户名/身份证号：</td>
            <td width="130"><input id="loginAccount" name="input2" type="text" class="scinput"/></td>
          </tr>
          <tr>
          <td width="120" align="right" style="padding-right:6px;">密码提示问题：</td>
          <td><select id="paswdQuestionType" name="select" class="select1">
          <option value="">--请选择--</option>
								<option value="1">
									我爸爸的名字
								</option>
								<option value="2">
									我妈妈的名字
								</option>
								<option value="3">
									我爱人的名字
								</option>
								<option value="4">
									我宝宝的名字
								</option>
          </select></td>
        </tr>
        <tr>
          <td align="right" style="padding-right:6px;">密码提示问题答案：</td>
          <td><input id="paswdAnswer" type="text" class="scinput"/></td>
        </tr>
        <tr>
          <td align="right" style="padding-right:6px;">验证码：</td>
          <td><table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><input name="input2" id="randcode" type="text" class="scinput" style="width:100px;"/></td>
    <td width="10"></td>
    <td><img src="<%=basePathHeader%>/randServlet"/></td>
  </tr>
</table>
</td>
        </tr>
        <tr>
          <td></td>
          <td id="msg" style="color: #c00; margin-bottom: 10px; margin-top: -10px; display: none"></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><a href="#" onclick="chkFindpwdByQuestion();" class="dian3">找回密码</a></td>
        </tr>
        </table>
      </div> 

</div>
<div id="div2" class="loginContent" style="margin-top:120px; padding: 40px 0;display: none">
    <div class="itab" style="margin-bottom:40px;">
        <ul> 
        <li><a href="<%=basePathHeader%>/person/login/findPwdByEmail.htm">通过邮箱找回</a></li> 
        <li><a href="#" class="selected">通过密保找回</a></li> 
        </ul>
        </div>
    <div class="Uploadxu" style="width:460px;padding-left:20px; margin-bottom:20px;"><span class="loadx">&nbsp;</span><span>步骤1：输入您的密保信息</span><span class="loadx">&nbsp;</span><span class="txtcolor">步骤2：设置新密码</span></div>
      
      <div class="usual" style="width:100%">
      
        <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
          <tr>
            <td width="112" align="right" style="padding-right:6px;">用户名/身份证号：</td>
            <td id="account">
            </td>
          </tr>
          <tr>
            <td align="right" style="padding-right:6px;">新 密 码：</td>
            <td><input name="input" id="password" type="text" class="scinput"/>
              <i>必填，6-16位，可为英文、数字或下划线，区分大小写</i></td>
          </tr>
          <tr>
            <td align="right" style="padding-right:6px;">确认密码：</td>
            <td><input name="input" id="password1" type="text" class="scinput"/>
              <i>必填，必须和密码一致</i></td>
          </tr>
          <tr>
            <td></td>
            <td id="msg1" style="color: #c00; margin-bottom: 10px; margin-top: -10px; display: none"></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><input type="hidden" id="id" value="">
            <input type="hidden" id="loginAccount" value=""><a href="#" onclick="chkUpdateByQuestion();" class="dian3">确 定</a></td>
          </tr>
        </table>
      </div> 

</div>







		<div class="loginbm">
			<%@include file="../common/buttom.jsp"%>
		</div>


	</body>
</html>