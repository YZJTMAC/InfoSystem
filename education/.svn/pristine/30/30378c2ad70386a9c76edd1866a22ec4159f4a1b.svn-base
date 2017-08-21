<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>信息管理系统界面</title>
		<%@include file="../common/commonHead.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js">
		</script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script> 
		<script type="text/javascript"
			src="<%=basePathHeader%>/javascript/common/pagination.js">
		</script>
		<script type="text/javascript">
		var type = 1;
		var roleId = 6;
		</script>
		<script type="text/javascript">
		var organizationId = <%= request.getParameter("organizationId")%>;
		</script>
		<script type="text/javascript"
			src="<%=basePathHeader%>/javascript/person/addOrgAdmin.js">
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

	<body>
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
          <td width="100"><b>*</b>用户名：</td>
          <td><input id="loginAccount" type="text" class="scinput"/><i>4-20位，可为英文、数字或下划线，第一位必须为字母</i></td>
        </tr>
        <tr>
          <td><b>*</b>密 码：</td>
          <td><input id="password" type="password" class="scinput"/><i>6-16位，可为英文、数字或下划线，区分大小写</i></td>
        </tr>
        <tr>
          <td><b>*</b>确认密码：</td>
          <td><input id="password1" type="password" class="scinput"/><i>必须和密码一致</i></td>
        </tr>
        <tr>
          <td><b>*</b>真实姓名：</td>
          <td><input id="realName" type="text" class="scinput"/><i>2-6个汉字</i></td>
        </tr>
        <tr>
          <td><b>*</b>身份证号：</td>
          <td><input id="idNumber" type="text" class="scinput"/><i>可以使用身份证号+密码进行登录</i></td>
        </tr>
        <tr>
          <td><b></b>教师编号：</td>
          <td><input id="teacherNo" type="text" class="scinput"/><i>教师编号</i></td>
        </tr>
        <tr>
          <td><b></b>电子邮箱：</td>
          <td><input id="mail" type="text" class="scinput"/><i>找回密码时可通过邮箱找回</i></td>
        </tr>
        <tr>
          <td><b></b>手机号码：</td>
          <td><input id="mobile" type="text" class="scinput"/><i>方便管理员与你联系</i></td>
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
          <td><a href="##" class="dian3" onclick="chkRegister();" >增加</a></td>
        </tr>
      </table>
	</body>
</html>
