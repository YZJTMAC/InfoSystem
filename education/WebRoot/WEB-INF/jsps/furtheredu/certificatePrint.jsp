<%@ page pageEncoding="UTF-8"%>
<%@include file="../common/pathHead.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="project.furtheredu.certificate.pojo.EduDiploma" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>证书预览</title>
<script type="text/javascript">
	var id = '${id}';
	var projectId = '${projectId}';
	var type = '${type}';
</script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/jquery.js"></script>
<%-- <script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/certificateView.js"></script> --%>
</head>
<body style="margin: 0px;padding: 0px;">
		<div class="diploma">
		<% 
			EduDiploma pojo = (EduDiploma)request.getAttribute("obj");
			String type = (String)request.getAttribute("type"); 
			//type 证书类型1:年度证书, 2:项目证书, 3:学时证书
			if(StringUtils.isNotEmpty(type) && "1".equals(type) && pojo.getBackgroundImg()==-1){%>
			<img id="backgroundImage" src="<%=basePathHeader%>/images/imgTemplate/code_back_920_690.jpg" style="margin:0 auto;position: absolute; z-index: -1;left:0px;top: 0px; right:0px;bottom: 0px;"width="920px" height="690px"/>
		<% }else if(StringUtils.isNotEmpty(type) && "2".equals(type) && pojo.getBackgroundImg()==-1){%>
			<img id="backgroundImage" src="<%=basePathHeader%>/images/imgTemplate/code_back_920_690.jpg" style="margin:0 auto;position: absolute; z-index: -1;left:0px;top: 0px; right:0px;bottom: 0px;"width="920px" height="690px"/>
		<% }else if(StringUtils.isNotEmpty(type) && "3".equals(type) && pojo.getBackgroundImg()==-1){%>
			<img id="backgroundImage" src="<%=basePathHeader%>/images/imgTemplate/period_back_920_690.jpg" style="margin:0 auto;position: absolute; z-index: -1;left:0px;top: 0px; right:0px;bottom: 0px;"width="920px" height="690px"/>
		<% }%>
		<c:if test="${obj.backgroundImg!='-1'}">
			<img id="backgroundImage" src="<%=basePathHeader%>/${obj.backgroundImgUrl}" style="margin:0 auto;position: absolute; z-index: -1;left:0px;top: 0px; right:0px;bottom: 0px;"width="920px" height="690px"/>
		</c:if>
		<div id="print" style="margin:0 auto;position: absolute; z-index: -1;left:0px;top: 0px; right:0px;bottom: 0px; width:920px;height:690px" >
			<div style="padding:60px 86px 60px 86px;">
				<div id="content" >
					<div>
						<c:if test="${obj.qrcode=='1'}">
						<img style="position: absolute; z-index: -1;width: ${obj.qrcodeWidth}px; height: ${obj.qrcodeHeight}px; left: ${obj.qrcodeRight}px; top: ${obj.qrcodeTop}px;" src="<%=pdfImageServer%>${qrcodeUrl }"/>
						</c:if>
						<c:if test="${obj.seal=='1'}">
						<img style="position: absolute; z-index: -1;width: ${obj.positionWidth}px; height: ${obj.positionHeight}px; left: ${obj.positionRight}px; top: ${obj.positionTop}px;" src="<%=pdfImageServer%>${obj.signetUrl }"/>
						</c:if>
					</div>
					<div>${obj.content }</div>
				</div>	
			</div> 
		</div>
		</div>
</body>
</html>
