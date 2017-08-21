<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>机构管理</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript">
			var type=2;
		</script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/system/addOrganizationInfo.js"></script>
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
			<li><a href="#">系统管理</a></li>
			<li><a href="#">培训实施机构管理</a></li>
			<li><a href="#">添加培训实施机构 </a></li>
		</ul>
	</div>

	<div class="formbody">



		<div class="tabson" id="txtBox">

			<table border="0" cellspacing="0" cellpadding="0"
				style="line-height: 40px; margin: 0 auto;">
				 
				 
				<tr>
					<td><font style="color: red">*</font>机构名称：</td>
					<td colspan="4"><input name="input4" type="text"
						class="scinput" style="width: 571px;" id="organizationName"/>&nbsp;&nbsp;<span style="color:red" id="organizationNameError"></span></td>
				</tr>
				
				<tr>
					<td width="84"><font style="color: red">*</font>联系人:</td>
					<td width="260"> <input name="input" type="text"
						class="scinput" id="contacts"/><span style="color:red" id="contactsError"></span></td>
					<td width="60"> &nbsp;</td>
					<td width="84"><font style="color: red">*</font>联系方式:</td>
					<td width="260" ><input name="input" type="text"
						class="scinput"  id="contactsType" /><span style="color:red;" id="contactsTypeError"></span></td>
				</tr>
				<tr>
					<td width="84"><font style="color: red">*</font>机构编码:</td>
					<td width="260"> <input name="input" type="text"
						class="scinput" id="orgCode"/><span style="color:red" id="orgCodeError"></span></td>					
				</tr>

				<tr>
					<td><font style="color: red">*</font>联系地址：</td>
					<td colspan="4"><input name="input4" type="text"
						class="scinput" style="width: 571px;" id="organizationAdderss"/><span style="color:red" id="organizationAdderssError"></span></td>
				</tr>

				<tr>
					<td>备注：</td>
					<td colspan="4"><textarea name="textarea"
							style="width: 600px; height: 100px; max-width: 600px; border: 1px solid #ccc; border-color: #a7b5bc #ced9df #ced9df #a7b5bc;" id="memo"></textarea></td>
				</tr>
			</table>

			<table border="0" cellspacing="0" cellpadding="0"
				style="margin: 0 auto;">
				<tr>
					<td><a href="#" class="dian3" onclick="saveInfo()" id="submit">保 存</a></td>
					<td style="width: 30px;">&nbsp;</td>
					<td><a href="#" class="dian3" onclick="javascript:window.history.back();">取 消</a></td>
				</tr>
			</table>

		</div>

		<div class="black" style="display: none;" id="black"></div>
</div>
</div>
	</body>

</html>
