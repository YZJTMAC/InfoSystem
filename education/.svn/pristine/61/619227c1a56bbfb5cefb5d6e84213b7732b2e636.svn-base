<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="project.edupm.projectmanage.pojo.EduProject" %>
<%@ page import="project.util.ApplicationProperties" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<%-- <%@include file="../common/commonHead.jsp"%> --%>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="cache-control" content="max-age=0" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
	<meta http-equiv="pragma" content="no-cache" />
	<title>福建教师信息管理系统证书二维码扫描验证信息</title>
<%
	String basePathHeader = request.getContextPath();
	String eduHostPath = ApplicationProperties.getPropertyValue("eduHostPath").toString();
	
	String imageServer = request.getContextPath();
	if (ApplicationProperties.getPropertyValue("imageServer").toString().length() > 0)
		imageServer = ApplicationProperties.getPropertyValue("imageServer").toString();
%>	

<script type="text/javascript">  
    var pathHeader = '<%=basePathHeader%>';
    var eduHostPath = '<%=eduHostPath%>';
    var imageServer='<%=imageServer%>';
</script>
<script type="text/javascript">
	var type =<%=request.getParameter("type")%>;
</script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/qrcode.js"></script>
<style type="text/css">
	tr{line-height:70px;text-align:left;}
 	td{font-size:40px;text-align:center;}
 	.to_r{padding:0 20px 0 0;}
</style>
</head>
	<body>
		<div align="center">
		<%  
		    String type = request.getParameter("type");
			if(type.equals("1") || type.equals("2")){
		%>   
		<!-- 显示项目证书 -->
			<div style="margin-top:180px;" >
     			<img id="QRbackgroundImgPro" src="<%=basePathHeader%>/images/project.png" style="position: absolute; z-index: -1;left:0px;top: 0px; right:0px;bottom: 0px;" height="100%" width="100%" /> 
     			<table border="0" cellspacing="0" cellpadding="0" align="center" style="line-height: 20px; font-size:28px;padding:30px; ">
					<tr>
					    <td colspan="3" style="font-weight:bold;text-align: center;padding:10px 180px 10px 180px">${eduDiploma.periodCertificateTitle }</td>
					 </tr>
					 <tr>
					    <td colspan="2" style="text-align:center" >
							<img id="photo" title='头像' src="<%=imageServer%>${userinfo.userImageUrl}" style="width:160px;height:200px"/> 
					    </td>
					 </tr>
					 <tr>
						<td width="40%" style='font-weight:bold'>
							姓　　名: 
						</td>
						<td width="60%" class="to_r" style='text-align:left;'>
							${userinfo.realName}
						</td>
					</tr>
					<tr>
						<td width="40%" style='vertical-align:top; font-weight:bold'>
							学　　校: 
						</td>
						<td width="60%" class="to_r" style='text-align:left;'>
							${userinfo.schoolName}
						</td>
					</tr>
					<tr>
						<td width="10%" style='vertical-align:top; font-weight:bold'>
							参训项目: 
						</td>
						<td width="80%"  class="to_r" style='text-align:left'>
							${project.projectName}
						</td>
					</tr>
					<tr>
						<td width="10%" style='vertical-align:top; font-weight:bold'>
							承培机构: 
						</td>
						<td width="80%"  class="to_r" style='text-align:left;'>
							${project.organizationName}
						</td>
					</tr>
					<tr>
						<td width="40%" style='font-weight:bold'>
							参训时间: 
						</td>
						<td width="60%" class="to_r" style='text-align:left'>
							${project.startDate } 至  ${project.endDate}
						</td>
					</tr>
					<tr>
						<td width="40%" style='font-weight:bold'>
							获得学时: 
						</td>
						<td width="60%" class="to_r" style='text-align:left'>
							${teacherComment.teacherClassPeriod }
						</td>
					</tr>
					<tr>
						<td width="40%" style='font-weight:bold'>
							证书编号: 
						</td>
						<td width="60%" class="to_r" style='text-align:left'>
							${teacherComment.projectCertificateCode}
						</td>
					</tr>
				</table>
    		</div>
		<% }else if(type.equals("3")){ %>
			<!-- 显示学时证书 -->
			<!-- 二维码 -->
			<div style="margin-top:180px;" >
			<img id="QRbackgroundImg" src="<%=basePathHeader%>/images/qrbg.jpg" style="position: absolute; z-index: -1;left:0px;top: 0px; right:0px;bottom: 0px;" height="100%" width="100%"/>
				<table border="0" cellspacing="0" cellpadding="0" align="center"; 
					style="line-height: 20px; font-size:28px;padding:40px; ">
					
					<tr><!-- style="text-align: center;"  福建省教师培训信息管理系统培训信息验证-->
					    <td colspan="3" style="font-weight:bold;text-align: center;padding:10px 180px 10px 180px">${eduDiploma.periodCertificateTitle}</td>
					 </tr>
					 <tr>
					    <td colspan="2" style="text-align:center" >
							<img id="photo" title='头像' src="<%=imageServer%>${userinfo.userImageUrl}" style="width:160px;height:200px";/> 
					    </td>
					 </tr>
					 <tr>
						<td width="40%" style='font-weight:bold'>
							姓　　名: 
						</td>
						<td width="60%" class="to_r" style='text-align:left;'>
							${userinfo.realName}
						</td>
					</tr>
					<tr>
						<td width="40%" style='vertical-align:top; font-weight:bold'>
							学　　校: 
						</td>
						<td width="60%" class="to_r" style='text-align:left'>
							${userinfo.schoolName }
						</td>
					</tr>
					<tr>
						<td width="10%" style='vertical-align:top; font-weight:bold'>
							参训项目: 
						</td>
						<td width="80%"  class="to_r" style='text-align:left'>
							${project.projectName}
						</td>
					</tr>
					<tr>
						<td width="10%" style='vertical-align:top; font-weight:bold'>
							承培机构: 
						</td>
						<td width="80%"  class="to_r" style='text-align:left'>
							${project.organizationName}
						</td>
					</tr>
					<tr>
						<td width="40%" style='font-weight:bold'>
							参训时间: 
						</td>
						<td width="60%" class="to_r" style='text-align:left'>
							${project.startDate } 至  ${project.endDate}
						</td>
					</tr>
					<tr>
						<td width="40%" style='font-weight:bold'>
							获得学时: 
						</td>
						<td width="60%" class="to_r" style='text-align:left'>
							${teacherComment.teacherClassPeriod }
						</td>
					</tr>
					<tr>
						<td width="40%" style='font-weight:bold'>
							证书编号: 
						</td>
						<td width="60%" class="to_r" style='text-align:left'>
							${teacherComment.periodCertificateCode}
						</td>
					</tr>
				</table>
			</div>
		<%} %>
			<input type="hidden" id="projectId" name="projectId" value="${project.id}">
			<input type="hidden" id="teacherId" name="teacherId" value="${userinfo.userId}">
			<input type="hidden" id="qrbackground" value="${eduDiploma.qrbackgroundImg}">

		</div>
		</div>
	</body>
</html>
