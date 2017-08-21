<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>编辑实施机构管理员</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/person/editOrgAdmin.js"></script>
		<script type="text/javascript">
			var id = '<%=request.getParameter("id")%>';
			var type = '<%=request.getParameter("type")%>';
			$(document).ready(function(e){
				$('#roleId').val(${user.roleId});
				
				$(".select2").uedSelect({
					width : 167  
				});
			});
		</script>
	</head>

	<body>
		<input type="hidden" id="organizationId" value="${user.organizationId }" />
		<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="system" name="flag" />
			</jsp:include>
		</div>
		<!-- left -->
		<div class="leftNav">
			<%@include file="../common/systemLeft.jsp"%>
		</div>
		<div class="content">
			<div class="place">
				<span>位置：</span>
				<ul class="placeul">
					<li><a href="ssadmin.html">系统管理</a></li>
					<li>实施机构管理</li>
					<li>设置管理员</li>
				</ul>
			</div>
	
				<div class="formbody">
				<div class="loginContent">
				      <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
				        <tr>
							<td>
								<b>*</b>用户角色：
							</td>
							<td>
								<select id="roleId" name="select" class="select2">
								<option value="">
										请选择...
									</option>
									<c:forEach items= "${roles}" var="r">
										<option value=${r.id}>${r.roleName}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
				        <tr>
				          <td width="100"><b>*</b>用户名：</td>
				          <td><input id="loginAccount" type="text" class="scinput" value="<%=request.getAttribute("loginAccount")%>"/><i>4-20位，可为英文、数字或下划线，第一位必须为字母</i></td>
				        </tr>
				        <tr>
				          <td><b>*</b>密 码：</td>
				          <td><input id="password" type="password" class="scinput" value="<%=request.getAttribute("password")%>"/><i>6-16位，可为英文、数字或下划线，区分大小写</i></td>
				        </tr>
				        <tr>
				          <td><b>*</b>确认密码：</td>
				          <td><input id="password1" type="password" class="scinput" "/><i>必须和密码一致</i></td>
				        </tr>
				        <tr>
				          <td><b>*</b>真实姓名：</td>
				          <td><input id="realName" type="text" class="scinput" value="<%=request.getAttribute("realName")%>"/><i>2-20个汉字</i></td>
				        </tr>
				       <%--  <tr>
				          <td><b>*</b>身份证号：</td>
				          <td><input id="idNumber" type="text" class="scinput" value="<%=request.getAttribute("idNumber")%>"/><i>可以使用身份证号+密码进行登录</i></td>
				        </tr> --%>
				       <%--  <tr>
				          <td><b></b>教师编号：</td>
				          <td><input id="teacherNo" type="text" class="scinput" value="${user.teacherNo}"/><i>教师编号</i></td>
				        </tr> --%>
				        <tr>
				          <td><b></b>电子邮箱：</td>
				          <td><input id="mail" type="text" class="scinput" value="<%=request.getAttribute("mail")%>"/><i>找回密码时可通过邮箱找回</i></td>
				        </tr>
				        <tr>
				          <td><b></b>手机号码：</td>
				          <td><input id="mobile" type="text" class="scinput" value="<%=request.getAttribute("mobile")%>"/><i>方便管理员联系</i></td>
				        </tr>
				        <tr>
				          <td></td>
				          <td><input name="rt"  value="" id="imTeacher"/><!--<input name="rt" type="radio" value="" style="margin-left:20px;"/>我是管理员-->
				         <tr>
				          <td colspan=2 id="msg" style="color: #c00; margin-bottom: 10px; margin-top: -10px; display: none"></td>
				        </tr>
				        </tr>
				        <tr>
				          <td></td>
				          <td><a href="##" class="dian3" onclick="editInfo();" >修改</a></td>
				        </tr>
				      </table>
				     </div>
				    </div>
		</div>
	</body>
</html>
