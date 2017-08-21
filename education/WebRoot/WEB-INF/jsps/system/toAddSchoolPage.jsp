<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>添加学校</title>
		<%@include file="../common/commonHead.jsp"%>
		<%@include file="../common/commonAreaSelectAll.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/system/toAddSchoolPage.js"></script>
		<script type="text/javascript">
			$(document).ready(function(e) {
				$(".select2").uedSelect( {
					width : 135
				});
				$(".select4").uedSelect( {
					width : 168
				});
			});
			
			function clearPCD() {
				$('#schoolProvinceId').val("");
				$('#schoolCityId').val("");
				$('#schoolDistrictId').val("");
				$('#tss').val("");
			}
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
					<li>
						<a href="#">系统管理</a>
					</li>
					<li>
						<a href="#">学校管理</a>
					</li>
					<li>
						<a href="#">添加学校 </a>
					</li>
				</ul>
			</div>

			<div class="formbody">
				<div class="tabson" id="txtBox">

					<table border="0" cellspacing="0" cellpadding="0"
						style="line-height: 40px; margin: 0 auto;">
						<tr>
							<td>
								所在地区：
							</td>
							<td colspan="2">
								<input name="input" id="tss" value="" onclick="clearPCD();"
									type="text" style="width: 240px;" class="scinput areaSelect" />
								<input name="input2" type="button" value="选 择"
									class="btnXuan areaSelect" />
							</td>
							
						</tr>
						<tr>
						  
							 <td>
								学校办别：
							</td>
							<td width="260">
								<select id="schoolEstablishId" name="select" class="select2">
									
								</select>
							</td>
							<td width="60">
							  <td>
								学校性质：
							</td>
							<td width="260">
								<select id="schoolNatureId" name="select" class="select2">
									
								</select>
							</td>
						</tr>
						
						<tr>
							<td width="84">
								学校名称:
							</td>
							<td width="260">
								<input id="schoolName" maxlength="50" name="input" type="text"
									class="scinput" value="" />
							</td>
							<td width="60">
								&nbsp;
							</td>
							<td>
								学校类型：
							</td>
							<td width="260">
								<select id="schoolTypeId" name="select" class="select2">
									
								</select>

							</td>
						</tr>
						<tr>
							<td width="84">
								联系人:
							</td>
							<td width="260">
								<input id="schoolContacts" name="input" maxlength="20"
									type="text" class="scinput" value=" " />
							</td>
							<td width="60">
								&nbsp;
							</td>
							<td>
								联系方式：
							</td>
							<td width="260">
								<input id="schoolContactsType" name="input" maxlength="20"
									type="text" class="scinput" style="width: 135px" value=" " />
							</td>
						</tr>

						<tr>
							<td width="84">
								所在区划:
							</td>
							<td width="260">
								<select id="areaTypeId" name="areaTypeId" class="select4">
								</select>
							</td>
							<td width="60">
								&nbsp;
							</td>
							<td width="60">
							学校编码：
							</td>
							<td width="260">

								<input id="schoolCode" name="input" maxlength="16"
									type="text" class="scinput" style="width: 135px" value=" " />
							</td>
						</tr>

						<tr>
							<td>
								联系地址：
							</td>
							<td colspan="4">
								<input id="schoolContactsAddress" name="input4" maxlength="100"
									type="text" class="scinput" style="width: 514px;" />
							</td>
						</tr>

						<tr>
							<td>
								备注：
							</td>
							<td colspan="4">
								<textarea id="schoolMemo" maxlength="300" name="textarea"
									style="width: 514px; height: 100px; max-width: 514px; border: 1px solid #ccc; border-color: #a7b5bc #ced9df #ced9df #a7b5bc;"></textarea>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<span id="msg" style="color: #c00"></span>
							</td>
						</tr>
					</table>

					<br />
					<table border="0" cellspacing="0" cellpadding="0"
						style="margin: 0 auto;">
						<tr>
							<td>
								<input name="btn" id="btn" onclick="addSchool();" type="button"
									class="sure" value="保 存" />
							</td>
							<td style="width: 30px;">
								&nbsp;
							</td>
							<td>
								<input name="btn" onclick="toPage();" type="button" class="sure"
									value="取 消" />
							</td>
						</tr>
					</table>

				</div>
			</div>
		</div>
		<input type="hidden" name="schoolProvinceId" id="schoolProvinceId"
			value="" />
		<input type="hidden" name="schoolCityId" id="schoolCityId" value="" />
		<input type="hidden" name="schoolDistrictId" id="schoolDistrictId"
			value="" />

		<div class="tip"
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
						<input name="" id="toPage" type="button" class="sure" value="确定" />
					</td>
				</tr>
			</table>
		</div>

	</body>

</html>
