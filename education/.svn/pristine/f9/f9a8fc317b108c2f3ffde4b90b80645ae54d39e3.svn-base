<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>查看学校信息</title>
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
						<a href="#">学校管理</a>
					</li>
					<li>
						<a href="#">查看学校信息 </a>
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
								<label>
									${info.schoolProvinceName}
								</label>


							</td>
							
						</tr>
						<tr>
						    <td>
								学校性质：
							</td>
							<td width="260">
								<label>
									${info.schoolNatureName}
								</label>
							</td>
							<td width="60">
								&nbsp;
							</td>
							
							 <td>
								学校办别：
							</td>
							<td width="260">
								<label>
									${info.establishTypeName}
								</label>
							</td>
							
						</tr>
						<tr>
							<td width="84">
								学校名称：
							</td>
							<td width="260">
								<label>
									${info.schoolName}
								</label>
							</td>
							<td width="60">
								&nbsp;
							</td>
							<td>
								学校类型：
							</td>
							<td width="260">
								<label>
									${info.schoolTypeName}
								</label>
							</td>
						</tr>
						<tr>
							<td width="84">
								联系人：
							</td>
							<td width="260">
								<label>
									${info.schoolContacts}
								</label>
							</td>
							<td width="60">
								&nbsp;
							</td>
							<td>
								联系方式：
							</td>
							<td width="260">
								<label>
									${info.schoolContactsType}
								</label>
							</td>
						</tr>

						<tr>
							<td width="84">
								所在区划:
							</td>
							<td width="260">
								${info.areaTypeName}
							</td>
							<td width="60">
								&nbsp;
							</td>
							<td>
								学校编码：
							</td>
							<td width="260">
								${info.schoolCode}

							</td>
						</tr>


						<tr>
							<td>
								联系地址：
							</td>
							<td colspan="4">
								<label>
									${info.schoolContactsAddress}
								</label>
							</td>
						</tr>

						<tr>
							<td>
								备注：
							</td>
							<td colspan="4">
								<label>
									${info.schoolMemo}
								</label>
							</td>
						</tr>
					</table>

					<table border="0" cellspacing="0" cellpadding="0"
						style="margin: 0 auto;">
						<tr>
							<td>
								<a href="<%=basePathHeader%>/sys/toSetSchoolPage.htm?click=2"
									class="dian3">返 回</a>
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
