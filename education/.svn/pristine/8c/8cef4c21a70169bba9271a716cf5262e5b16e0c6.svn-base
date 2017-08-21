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
			var flag=${flag};
		    if(flag==false)
		    {
		    	$("#div1").hide();
		    	$("#div2").show();
		    }
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

		<div class="loginContent" style="margin-top:120px; padding: 40px 0;">
    <div class="itab" style="margin-bottom:40px;">
        <ul> 
        <li><a href="#" class="selected" id="1">通过邮箱找回</a></li> 
        <li><a href="<%=basePathHeader%>/person/login/findPwdByQuestion.htm" id="2">通过密保找回</a></li> 
        </ul>
        </div>
        
    <div class="Uploadxu" style="padding-left:20px; margin-bottom:20px;"><span class="loadx">&nbsp;</span><span>步骤1：输入您的账号信息</span><span class="loadx">&nbsp;</span><span>步骤2：获得密码找回邮件</span><span class="loadx">&nbsp;</span><span class="txtcolor">步骤3：设置新密码</span></div>
       <div id="div2" style="display: none">
 		<table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
          
          <tr>
            <td></td>
            <td style="color: #c00; margin-bottom: 10px; margin-top: -10px;">
            ${tip }
            </td>
          </tr>
        </table>
		</div>
       <div  id="div1" class="usual" style="width:100%">
     
        <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
          <tr>
            <td width="112" align="right" style="padding-right:6px;"><b>*</b>用户名/身份证号：</td>
            <td width="506"><input id="loginAccount" name="input2" type="text" class="scinput"/>
              <i>必填，4-20位，可为英文、数字或下划线，第一位必须为字母</i></td>
          </tr>
          <tr>
            <td align="right" style="padding-right:6px;"><b>*</b>新 密 码：</td>
            <td><input id="password" name="input" type="text" class="scinput"/>
              <i>必填，6-16位，可为英文、数字或下划线，区分大小写</i></td>
          </tr>
          <tr>
            <td align="right" style="padding-right:6px;"><b>*</b>确认密码：</td>
            <td><input id="password1" name="input" type="text" class="scinput"/>
              <i>必填，必须和密码一致</i></td>
          </tr>
          <tr>
            <td></td>
            <td id="msg" style="color: #c00; margin-bottom: 10px; margin-top: -10px; display: none"></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><a href="#" onclick="chkUpdate();" class="dian3">确 定</a></td>
          </tr>
        </table>
      </div> 


</div>

    






			<div class="loginbm">
			<%@include file="../common/buttom.jsp"%>
		</div>


	</body>
</html>