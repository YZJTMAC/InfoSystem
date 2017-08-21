<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="project.furtheredu.certificate.pojo.EduDiploma" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@include file="../common/pathHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>打印预览</title>
<script type="text/javascript"	src="<%=basePathHeader%>/javascript/jquery.js"></script>
<script type="text/javascript">
	var projectId = <%=request.getParameter("projectId")%>;
	var teacherId = '<%=request.getParameter("teacherId")%>';			
	var type = '<%=request.getParameter("type")%>';
	var click = '<%=request.getParameter("click")%>';
	var isTip = <%=request.getParameter("isShowTip")%>;
</script> 
<%String baseHeader = request.getContextPath()+"/uploadFile/"; %>
<!-- 禁止右键 -->
<script type="text/javascript">document.oncontextmenu=function(e){return false;}</script> 
<%-- <script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/teacherPrinterPreview.js"></script> --%>
</head>
<body oncontextmenu=self.event.returnValue=false onselectstart="return false" style="margin: 0px;padding: 0px;">
	<div class="diploma">
		<% 
			EduDiploma pojo = (EduDiploma)request.getAttribute("certificateInfo");
			//type 证书类型1:年度证书, 2:项目证书, 3:学时证书
			if(StringUtils.isNotEmpty(pojo.getType()) && "1".equals(pojo.getType()) && pojo.getBackgroundImg()==-1){
		%>
			<img id="backgroundImage" src="<%=basePathHeader%>/images/imgTemplate/code_back_920_690.jpg" style="margin:0 auto;position: absolute; z-index: -1;left:0px;top: 0px; right:0px;bottom: 0px;"width="920px" height="690px"/>
		<% }else if(StringUtils.isNotEmpty(pojo.getType()) && "2".equals(pojo.getType()) && pojo.getBackgroundImg()==-1){%>
			<img id="backgroundImage" src="<%=basePathHeader%>/images/imgTemplate/code_back_920_690.jpg" style="margin:0 auto;position: absolute; z-index: -1;left:0px;top: 0px; right:0px;bottom: 0px;"width="920px" height="690px"/>
		<% }else if(StringUtils.isNotEmpty(pojo.getType()) && "3".equals(pojo.getType()) && pojo.getBackgroundImg()==-1){%>
			<img id="backgroundImage" src="<%=basePathHeader%>/images/imgTemplate/period_back_920_690.jpg" style="margin:0 auto;position: absolute; z-index: -1;left:0px;top: 0px; right:0px;bottom: 0px;"width="920px" height="690px"/>
		<% }%>%>
		<c:if test="${certificateInfo.backgroundImg!='-1'}">
			<img id="backgroundImage" src="<%=basePathHeader%>/${certificateInfo.backgroundImgUrl}" style="margin:0 auto;position: absolute; z-index: -1;left:0px;top: 0px; right:0px;bottom: 0px;"width="920px" height="690px"/>
		</c:if>
 		<div id="print" style="margin:0 auto;position: absolute; z-index: -1;left:0px;top: 0px; right:0px;bottom: 0px; width:920px;height:690px">			
 			<div style="padding-top:60px ; padding-left:86px; padding-right:86px ;">
				<div id="content">
					<div>
						<c:if test="${certificateInfo.qrcode eq '1'}">
						<img style="position: absolute; z-index: -1;width: ${certificateInfo.qrcodeWidth}px; height: ${certificateInfo.qrcodeHeight}px; left: ${certificateInfo.qrcodeRight}px; top: ${certificateInfo.qrcodeTop}px;" src="<%=baseHeader%>${certificateInfo.qrcodeUrl }"/>
						</c:if>
						<c:if test="${certificateInfo.seal eq '1'}">
						<img style="position: absolute; z-index: -1;width: ${certificateInfo.positionWidth}px; height: ${certificateInfo.positionHeight}px; left: ${certificateInfo.positionRight}px; top: ${certificateInfo.positionTop}px;" src="<%=baseHeader%>${certificateInfo.signetUrl }"/>
						</c:if>
					</div>
					<div>${certificateInfo.content }</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
