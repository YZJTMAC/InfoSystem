<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>编辑权限</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript"
			src="<%=basePathHeader%>/javascript/system/toRoleInfoPage.js">
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
						<a href="#">角色管理</a>
					</li>
					<li>
						<a href="#">编辑权限</a>
					</li>
				</ul>
			</div>

			<div class="formbody">


				<div class="formbody">



					<div class="tabson" id="txtBox">

						<table border="0" cellspacing="0" cellpadding="0"
							style="line-height: 40px; margin: 0 auto;">


							<tr>
								<td>
									角色名称：
								</td>
								<td colspan="4">
									<input name="roleName" id="roleName" type="text" value=""
										class="scinput" style="width: 471px;" />
								</td>
							</tr>

							<tr>
								<td>
									状态：
								</td>
								<td colspan="4">
									<input name="stauts" id="stautsY" type="radio" />
									启用&nbsp;&nbsp;&nbsp;&nbsp;
									<input  name="stauts" id="stautsN" type="radio" />
									禁用
								</td>
							</tr>


							<tr>
								<td>
									备注：
								</td>
								<td colspan="4">
									<textarea name="remark" id="remark"
										style="width: 600px; height: 100px; max-width: 600px; border: 1px solid #ccc; border-color: #a7b5bc #ced9df #ced9df #a7b5bc;"></textarea>
								</td>
							</tr>
						</table>
						<div id="cHtml">
							
						</div>

						<br/>

						<table border="0" cellspacing="0" cellpadding="0"
							style="margin: 0 auto;">
							<tr>
								<td>
									<input name="btn" id="btn" onclick="setRole();" type="button"
									class="sure" value="保 存" />
								</td>
								<td style="width: 30px;">
									&nbsp;
								</td>
								<td>
									<input name="btn" id="btn" onclick="toPage();" type="button"
									class="sure" value="取 消" />
								</td>
							</tr>
						</table>

					</div>

				</div>
			</div>
			
			<div class="tip"
			style="width: 400px; height: 150px; top: 1500px; left: 35%">
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
	</div>
	</body>
<script>
var roleId="<%=request.getParameter("id")%>";
var roleType="<%=request.getParameter("roleType")%>";
</script>
</html>
