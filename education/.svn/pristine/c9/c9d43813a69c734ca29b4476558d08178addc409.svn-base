<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员管理-添加</title>
<%@include file="../common/commonHead.jsp"%>
<%@include file="../common/commonAreaSelect.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/person/toAddManagesPage.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
		$(".select2").uedSelect({
			width : 165
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
				<li><a href="#">系统管理</a>
				</li>
				<li><a href="#">管理员管理</a>
				</li>
				<li><a href="#">添加 </a>
				</li>
			</ul>
		</div>

		<div class="formbody">
			<div class="tabson" id="txtBox">

				<table border="0" cellspacing="0" cellpadding="0"
					style="line-height: 40px; margin: 0 auto;">
					<tr>
						<td><b style="color: red">*</b>角色：</td>

						<td><select onchange="selectRole();" id="roleId"
							name="select" class="select2">
						</select>
						</td>
					</tr>
					<tr>
						<td><b style="color: red">*</b>所在地区：</td>
						<td colspan="4"><input name="input" id="tss"
							readonly="readonly" value="" onclick="clearPCD();" type="text"
							style="width: 384px;" class="scinput areaSelect" /> <input
							name="input2" disabled="disabled" id="sel" type="button"
							value="选 择" class="btnXuan areaSelect" />
						</td>
					</tr>
					<tr>
						<td>学校：</td>
						<td colspan="4"><input name="input" readonly="readonly"
							disabled="disabled" id="schoolName2" value="" type="text"
							style="width: 428px;" class="scinput" />
						</td>
					</tr>
					<tr>
						<td width="84"><b style="color: red">*</b>用户名:</td>
						<td width="260"><input id="loginAccount" maxlength="100"
							name="input" type="text" class="scinput" value="" />
						</td>

						<td><b style="color: red">*</b>密码：</td>
						<td width="260"><input id="password" maxlength="100"
							name="input" type="text" class="scinput" value="" />
						</td>
					</tr>
					<tr>
						<td width="84">姓名:</td>
						<td width="260"><input id="realName" name="input"
							maxlength="100" type="text" class="scinput" value=" " />
						</td>

						<td>性别：</td>
						<td width="260"><select id="gender" name="select"
							class="select2">
								<option value="1">男</option>
								<option value="0">女</option>
						</select>
						</td>
					</tr>

					<tr>
						<!--  <td>身份证号：</td>
						<td><input id="idNumber" name="input" maxlength="20"
							type="text" class="scinput" value="" />
						</td>
						-->
						<td>手机：</td>
						<td><input id="mobile" name="input" maxlength="20"
							type="text" class="scinput" value="" />
						</td>
					</tr>

					<tr>
						<td>状态：</td>
						<td><select id="status" name="select" class="select2">
								<option value="1">正常</option>
								<option value="44">禁用</option>
						</select>
						</td>
						<td>邮箱：</td>
						<td><input id="mail" name="input" maxlength="20" type="text"
							class="scinput" value="" />
						</td>
					</tr>
					<tr>
						<td>联系地址：</td>
						<td colspan="4"><input id="userAddress" name="input4"
							maxlength="100" type="text" class="scinput" style="width: 428px;" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td><span id="msg" style="color: #c00"></span>
						</td>
					</tr>
				</table>

				<br />
				<table border="0" cellspacing="0" cellpadding="0"
					style="margin: 0 auto;">
					<tr>
						<td><input name="btn" id="btn" onclick="addManages();"
							type="button" class="sure" value="保 存" />
						</td>
						<td style="width: 30px;">&nbsp;</td>
						<td><input name="btn" onclick="toPage();" type="button"
							class="sure" value="取 消" />
						</td>
					</tr>
				</table>

			</div>
		</div>
	</div>
	<input type="hidden" name="schoolProvinceId" id="schoolProvinceId"
		value="" />
	<input type="hidden" name="schoolCityId" id="schoolCityId" value="" />
	<input type="hidden" name="schoolId2" id="schoolId2" value="" />
	<input type="hidden" name="schoolDistrictId" id="schoolDistrictId"
		value="" />

	<div class="tip"
		style="width: 400px; height: 150px; top: 40%; left: 35%">
		<div class="tiptop">
			<span>提示信息</span>
		</div>
		<table style="width: 100%; height: 100%">
			<tr>
				<td align="center"><span id="msgHtml"></span>
				</td>
			</tr>
			<tr>
				<td align="center" valign="top" style="height: 60%"><input
					name="" id="toPage" type="button" class="sure" value="确定" />
				</td>
			</tr>
		</table>
	</div>

</body>

</html>
