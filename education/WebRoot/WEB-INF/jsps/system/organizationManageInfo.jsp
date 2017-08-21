<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>机构详情</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript">
			var organizationId = '<%=request.getParameter("organizationId")%>';
		</script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/system/organizationInfo.js"></script>
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
					<div class="place">
						<span>位置：</span>
						<ul class="placeul">
							<li><a href="#">系统管理</a></li>
							<li><a href="#">管理员管理</a></li>
							<li><a href="#">机构查看</a></li>
						</ul>
					</div>
			
				<div class="formbody">
					<div class="tabson" id="txtBox">
			
						<table border="0" cellspacing="0" cellpadding="0"
							style="line-height: 40px; margin: 0 auto;">
							<tr>
								<td>机构名称：</td>
								<td colspan="4">  <label id="organizationName"></label></td>
							</tr>
							<tr>
								<td width="84">联系人：</td>
								<td width="260"><label id="contacts"></label></td>
								<td width="60">&nbsp;</td>
								<td>联系方式：</td>
								<td width="260"> <label id="contactsType"></label></td>
							</tr>
							
							<tr>
								<td width="84">联系地址：</td>
								<td width="260">
								<label id="organizationAdderss"></label>
								 </td>
								<td width="60">&nbsp;</td>
								<td >创建人：</td>
								<td width="260"> <label id="createBy"></label></td>
								<!--<td >所在省：</td>
								<td width="260">  
								<label id="organizationProvinceName"></label>
								</td>
							-->
							</tr>
							 
							<!--<tr>
								<td width="84">所在市:</td>
								<td width="260"> <label id="organizationCityName"></label>
			</td>
								<td width="60">&nbsp;</td>
								<td>所在区：</td>
								<td width="260"> <label id="organizationDistrictName"></label></td>
							</tr>
			
							
			-->
							<tr>
								<td width="84">创建日期：</td>
								<td width="260"> <label id="createDate"></label></td>
								<td width="60">&nbsp;</td>
								<td >备注：</td>
								<td width="260"> <label id="memo"></label></td>
							</tr>
						</table>
			
						<table border="0" cellspacing="0" cellpadding="0"
							style="margin: 0 auto;">
							<tr>
								<td><a href="#" class="dian3" onclick="javascript:window.history.back();">返 回</a></td>
								<td style="width: 30px;">&nbsp;</td>
								<td> </td>
							</tr>
						</table>
			
					</div>
				</div>
			</div>
		</div>
</body>
</html>