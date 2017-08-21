<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>系统设置</title>
		<%@include file="../common/commonHead.jsp"%>
		<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/system/sysPlatformSetup.js"></script>
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
			<div id="jqDiv1">
				<div class="place">
					<span>位置：</span>
					<ul class="placeul">
						<li>
							<a href="#">系统管理</a>
						</li>
						<li>
							<a href="#">系统设置</a>
						</li>
					</ul>
				</div>
				<div class="formbody">
					<div class="chauxnJS jsTool">
						<span style="float: left;">
							<h4 style="float: left;"></h4> <a href="javascript:;" class="jq"
							style="float: left; line-height: 18px; margin: 7px 0 0 10px;"
							id="btn1">平台设置</a> </span>
						<span style="float: right;"></span>
					</div>
					<div>
					<form action="" id="sysForm" enctype="multipart/form-data" method="post">
						<input id="sysStyle" type="hidden" />
						<table border="0" cellspacing="0" cellpadding="0"
							style="line-height: 42px; margin: 0 auto; width: 100%;">
							<tr>
								<td width="140"
									style="background-color: #EDF6FA; text-align: right;">
									系统风格：
								</td>
								<td>
									<select id="sys_style" name="sysStyle" class="select3" onchange="modifyStyle(this)">
										<option value="0">
											深蓝色
										</option>
										<option value="1">
											蓝色
										</option>
										<option value="2">
											绿色
										</option>
										<option value="3">
											红色
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td width="140" style="background-color: #EDF6FA; text-align: right;">
									系统名称：
								</td>
								<td>
									<input id="sys_name" name="sysName" type="text" class="dfinput" style="width: 200px;" />
								</td>
							</tr>
							<tr>
							
								<td style="background-color: #EDF6FA; text-align: right;">
									系统LOGO：
								</td>
								<td>	
									<input id="sysLogo" name="sysLogoFile" type="file" class="dfinput" style="width: 200px;" onchange="modifySysLogo('sysLogo');"/>
									<br/>
									<img src="" id="sys_logo" />
								</td>
							</tr>
							<tr>
								<td style="background-color: #EDF6FA; text-align: right;">
									登录LOGO：
								</td>
								<td>
									<input id="loginLogo" name="loginLogoFile" type="file" class="dfinput" style="width: 200px;" onchange="modifyLoginLogo('loginLogo');"/>
									<br/>
									<img id="login_logo"/>
								</td>
							</tr>
							<tr>
								<td style="background-color: #EDF6FA; text-align: right;">
									版权声明：
								</td>
								<td>
									<input id="copyright" name="copyrightNotice" type="text" class="dfinput" style="width: 400px;"/>
								</td>
							</tr>
							<tr>
								<td style="background-color: #EDF6FA; text-align: right;">
									联系方式：
								</td>
								<td>
									<input id="contact_way" name="contactWay" type="text" class="dfinput" style="width: 400px;"/>
								</td>
							</tr>

							<tr>
								<td width="90">
									&nbsp;
								</td>
								<td>
									<a id="save" href="javascript: save();" class="dian3">保存</a>
								</td>
							</tr>
						</table>
					</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
