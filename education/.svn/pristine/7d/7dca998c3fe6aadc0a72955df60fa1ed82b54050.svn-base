<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>欢迎登录后台管理系统</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/person/login.js"></script>
		<%-- <script type="text/javascript" src="<%=basePathHeader%>/javascript/cloud.js"></script> --%>
		<script language="javascript">
			$(function() {
				$("#password").keypress(function() {
					if (event.keyCode == 13) {
						chkLogin();
					}
				});
			
				$('.loginbox').css( {
					'position' : 'absolute',
					'left' : ($(window).width() - 692) / 2
				});
				$(window).resize(function() {
					$('.loginbox').css( {
						'position' : 'absolute',
						'left' : ($(window).width() - 692) / 2
					});
				})
			});

			$(function() {
				var platformSetup = SysCode.getJsonArray("SYS_PLATFORM_SETUP", "")[0].text;
			
				$('#login_logo').css(
						'background',
						'url(' + pathHeader + '/static' + platformSetup.sysLogo
								+ ') no-repeat center');
				$('#logininfo_logo').css(
						'background',
						'url(' + pathHeader + '/static' + platformSetup.loginLogo
								+ ') no-repeat center');
								
				$("#login_banner").html(platformSetup.sysName);
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
					<a href="#">回首页</a>
				</li>
				<li>
					<a href="#">帮助</a>
				</li>
				<li>
					<a href="#">关于</a>
				</li>
			</ul>
		</div>

		<div class="loginbody">

  			<span class="systemlogo"></span> 

			<div id="logininfo_logo" class="loginbox">

				<ul>
					<li>
						<input name="loginAccount" id="loginAccount" type="text"
							class="loginpwd" value="" onblur="clearMsg(0)"
							onclick="JavaScript:this.value=''" />
					</li>
					<li>
						<input name="password" id="password" type="password"
							class="loginpwd" value="" onblur="clearMsg(1)"
							onclick="JavaScript:this.value=''" />
					</li>
					<li id="msg"
						style="color: #c00; margin-bottom: 10px; margin-top: -10px; display: none"></li>
					<li>
						<input name="" type="button" id="btn" class="loginbtn" value="登录"
							onclick="chkLogin();" />
						<label>
							<input id="remeberId" name="" type="checkbox" value="" checked="checked" />
							记住密码
						</label>
						<label>
							<a href="<%=basePathHeader%>/person/login/resetpwdByIdcard.htm">忘记密码？</a>
						</label>
						<%
							String type = (request.getAttribute("type") == null ? "0" :request.getAttribute("type").toString());
						 %>
						<label style="display:<%=type.equals("0")?"none":""%>">
						
							<a href="<%=basePathHeader%>/person/login/register.htm">注册</a>
						</label>
					</li>
					<li>
						<label>推荐在IE8以上浏览器,1024*768以上分辨率显示器使用</label>
					</li>
				</ul>
			</div>
			<!-- 
		<div style="float: right; margin-top: 40px; margin-right: 30px">
			<ul>
			<li>
				<input class="loginbtn" value="角色"/><input class="loginbtn" value="帐号"/><input class="loginbtn" value="密码"/>
			</li>
			<li>
				<input class="loginbtn" value="省管理员"/><input class="loginbtn" value="test11,test12"/><input class="loginbtn" value="123"/>
			</li>
			<li>
				<input class="loginbtn" value="市管理员"/><input class="loginbtn" value="test21,test22"/><input class="loginbtn" value="123"/>
			</li>
			<li>
				<input class="loginbtn" value="区管理员"/><input class="loginbtn" value="test31,test32"/><input class="loginbtn" value="123"/>
			</li>
			<li>
				<input class="loginbtn" value="校管理员"/><input class="loginbtn" value="test41,test42"/><input class="loginbtn" value="123"/>
			</li>
			<li>
				<input class="loginbtn" value="教师"/><input class="loginbtn" value="test51,test52"/><input class="loginbtn" value="123"/>
			</li>
			<li>
				<input class="loginbtn" value="三方机构"/><input class="loginbtn" value="test61,test62"/><input class="loginbtn" value="123"/>
			</li>
		</ul>
		</div>
 	-->
		</div>

		<div class="loginbm">
			<%@include file="../common/buttom.jsp"%>
		</div>
	</body>
</html>