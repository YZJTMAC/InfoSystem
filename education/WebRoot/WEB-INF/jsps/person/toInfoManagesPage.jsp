<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>管理员管理 -查看</title>
		<%@include file="../common/commonHead.jsp"%>
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
						<a href="#">管理员管理 </a>
					</li>
					<li>
						<a href="#">查看 </a>
					</li>
				</ul>
			</div>

			<div class="formbody">
				<div class="tabson" id="txtBox">

				<table border="0" cellspacing="0" cellpadding="0"
						style="line-height: 40px; margin: 0 auto;">
						<tr>
							<td>
								角色：
							</td>
							<td>
								${info.roleName}
							</td>
						</tr>
						<tr>
							<td>
								所在地区：
							</td>
							<td colspan="4">
								${info.userProvinceName}
							</td>
						</tr>
						<tr>
							<td>
								学校：
							</td>
							<td colspan="4">
								${info.schoolName}
							</td>
						</tr>
						<tr>
							<td width="84">
								用户名:
							</td>
							<td width="260">
								${info.loginAccount}
							</td>

							<td>
								密码：
							</td>
							<td width="260">
								${info.password}
							</td>
						</tr>
						<tr>
							<td width="84">
								姓名:
							</td>
							<td width="260">
								${info.realName}
							</td>

							<td>
								性别：
							</td>
							<td width="260">
								${info.sex}
							</td>
						</tr>

						<tr>
							<td>
								身份证号：
							</td>
							<td>
								${info.idNumber}
							</td>
							<td>
								手机：
							</td>
							<td>
									${info.mobile}
							</td>
						</tr>

						<tr>
							<td>
								状态：
							</td>
							<td>
								${info.statusName}
							</td>
							<td>
								邮箱：
							</td>
							<td>
									${info.mail}
							</td>
						</tr>
						<tr>
							<td>
								联系地址：
							</td>
							<td colspan="4">
						   ${info.userAddress}
							</td>
						</tr>
						
					</table>
<br/>
					<table border="0" cellspacing="0" cellpadding="0"
						style="margin: 0 auto;">
						<tr>
							<td>
								<a href="<%=basePathHeader %>/person/toManagesPage.htm?click=444" class="dian3">返 回</a>
							</td>
							<td style="width: 30px;">
								&nbsp;
							</td>
							<td>
							</td>
						</tr>
					</table>

				</div>
			</div>
		</div>
	</body>

</html>
