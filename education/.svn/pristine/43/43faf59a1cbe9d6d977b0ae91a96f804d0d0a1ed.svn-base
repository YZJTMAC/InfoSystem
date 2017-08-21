<%@ page pageEncoding="UTF-8"%>
<%@page import="project.person.pojo.EduUserActivty" %>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
int roleId = ((EduUserActivty)session.getAttribute("userinfo")).getRoleId();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>个人信息</title>
		<%@include file="../common/commonHead.jsp"%>

		<script type="text/javascript"
			src="<%=basePathHeader%>/javascript/person/personInfoPage.js">
		</script>



		<script type="text/javascript">
$(document).ready(function(e) {
	$(".select1").uedSelect( {
		width : 345
	});
	
	$(".select3").uedSelect( {
		width : 100
	});
	$("#paswdQuestionType").val('${personInfo.paswdQuestionType}');
	$(".select2").uedSelect( {
		width : 167
	});
});
</script>

	</head>

	<body>
		<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="person" name="flag" />
			</jsp:include>
		</div>
		<!-- left -->
		<div class="leftNav">
			<%@include file="../common/personLeft.jsp"%>
		</div>

		<div class="content">
			<div class="place">
				<span>位置：</span>
				<ul class="placeul">
					<li>
						<a href="#">个人中心</a>
					</li>
					<li>
						<a href="#">个人信息</a>
					</li>
				</ul>
			</div>

			<div class="formbody">
				<h4
					style="padding: 20px 0 20px 40px; margin-top: 30px; border-top: 1px dashed #a7b5bc;">
					个人信息： 带<b style="color:#c00">&nbsp;*&nbsp;</b>为必填项
				</h4>
				<table border="0" cellspacing="0" cellpadding="0"
					style="line-height: 40px; margin: 0 auto;">
					<tr>
						<td width="84">
							用户名：
						</td>
						<td width="260">
							${personInfo.loginAccount} 
							<%-- <%=request.getAttribute("LoginAccount") %>--%>
						</td>
					</tr>
					<tr>
						<td width="84">
							角色名称：
						</td>
						<td width="260">
							${personInfo.roleName} 
						</td>
					</tr>
					<tr>
						<td width="84">
							所属地区：
						</td>
						<td width="260">
							${personInfo.userProvinceName} ${personInfo.userCityName} ${personInfo.userDistrictName} 
							${personInfo.schoolName}
						</td>
					</tr>
					<%if(roleId != 5){ %>
					<tr>
						<td width="84">
							真实姓名：
						</td>
						<td width="465">
							<input  onblur="return chk();" id="realName" name="input4" type="text" class="scinput"
								style="width: 300px;" value="${personInfo.realName}" /><b style="color:#c00">&nbsp;*</b>
							<a id="realNameHTML" style="color:#c00"></a>
						</td>
					</tr>
					<%} else{%>
						<tr>
						<td width="84">
							真实姓名：
						</td>
						<td width="465">
							<input  onblur="return chk();" id="realName" name="input4" type="text" class="scinput"
								style="width: 300px;" value="${personInfo.realName}" title="对教师学员不允许修改，如果有误，请联系上级管理员在教师信息管理中修改" disabled="true"/><b style="color:#c00">&nbsp;*</b>
							<a id="realNameHTML" style="color:#c00"></a>
						</td>
					</tr>
					<%} %>
					<%if(roleId == 5){ %>
					<tr>
						<td width="84">
							身份证号：
						</td>
						<td width="465">
							<input  onblur="return chk();" id="idNumber" name="input4" type="text" class="scinput"
								style="width: 300px;" value="${personInfo.idNumber}" title="对教师学员不允许修改，如果有误，请联系上级管理员在教师信息管理中修改" disabled="true"/><b style="color:#c00">&nbsp;*</b>
						<a id="idNumberHTML" style="color:#c00"></a>
						</td>
					</tr>
					<%}%>
					<%-- <tr>
						<td width="84">
							邮箱：
						</td>
						<td width="260">
							<input id="mail" name="input4" type="text" class="scinput"
								style="width: 300px;" value="${personInfo.mail}" />
						</td>
					</tr> --%>
					<tr>
						<td width="84">
							手机号：
						</td>
						<td width="260">
							<input id="mobile" name="input4" type="text" class="scinput"
								style="width: 300px;" value="${personInfo.mobile}" />
						</td>
					</tr>
					<%-- <tr>
						<td width="84">
							选择密保问题：
						</td>
						<td width="260">
							<select id="paswdQuestionType" class="select2">

								<option value="0">
									--请选择--
								</option>
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
							</select>
						</td>
					</tr>
					<tr>
						<td width="84">
							设置密保答案：
						</td>
						<td width="465">
							<input onblur="return chk();" id="paswdAnswer" name="input4" type="text" class="scinput"
								style="width: 300px;" value="${personInfo.paswdAnswer}" />
								<span id="paswdAnswerHTML" style="color:#c00"></span>
						</td>
					</tr> --%>

				</table>

			</div>

			<table border="0" cellspacing="0" cellpadding="0"
				style="margin: 0 auto;">
				<tr>
					<td>
						<a href="#" id="btn" onclick="saveInfo();" class="dian3">保 存</a>
					</td>
					<td style="width: 30px;">
						&nbsp;
					</td>
					<td>
						<!-- <a href="#" class="dian3">取 消</a> -->
					</td>
				</tr>
			</table>

		</div>
		
		<div class="tip1"
			style="width: 400px; height: 150px; top: 40%; left: 35%">
			<div class="tiptop">
				<span>提示信息</span>
			</div>
			<table style="width: 100%; height: 100%">
				<tr>
					<td align="center">
						<span id="msgHtml"></span>
					</td>
				</tr>
				<tr>
					<td align="center" valign="top" style="height: 60%">
						<input name="" id="toPage" type="button" class="sure1" value="确定" />

					</td>
				</tr>
			</table>
		</div>
	</body>

</html>
