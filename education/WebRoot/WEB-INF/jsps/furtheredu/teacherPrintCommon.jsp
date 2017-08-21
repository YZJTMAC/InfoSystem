<%@ page pageEncoding="UTF-8"%>
<%@ include file="../common/pathHead.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>批量打印页面</title>
<script type="text/javascript"	src="<%=basePathHeader%>/javascript/jquery.js"></script>
<script type="text/javascript">document.oncontextmenu=function(e){return false;}</script> 
<style type="text/css">
body
{
	text-align: center;
}
</style>
</head>
 <body oncontextmenu=self.event.returnValue=false onselectstart="return false" style="margin: 0px auto;padding: 0px;">
        <!-- 批量生成证书页面 -->
        <c:forEach items= "${certificateInfos}" var="certificateInfo" varStatus="status">
        <div class="diploma">
        	<c:if test="${certificateInfo.backgroundImg == '-1'}">
				<div id="print" style="margin: 0px auto; width: 920px; height: 690px; page-break-after:always;position:relative ; z-index: -1;background:url(<%=basePathHeader%>/images/imgTemplate/code_back_920_690.jpg) no-repeat no-repeat;">
			</c:if>
			<c:if test="${certificateInfo.backgroundImg != '-1'}">
				<div id="print" style="margin: 0px auto; width: 920px; height: 690px; page-break-after:always;position:relative ; z-index: -1;background:url(<%=basePathHeader%>/${certificateInfo.backgroundImgUrl })  no-repeat no-repeat;">
			</c:if>	
				<div style="padding-top:60px ; padding-left:86px; padding-right:86px ;">
					<div id="content" style="text-align:left;">${certificateInfo.content }
						<c:if test="${certificateInfo.qrcode eq '1'}">
						<img style="position: absolute; z-index: -1;width: ${certificateInfo.qrcodeWidth}px; height: ${certificateInfo.qrcodeHeight}px; left: ${certificateInfo.qrcodeRight}px; top: ${certificateInfo.qrcodeTop}px;" src="<%=pdfImageServer%>${certificateInfo.qrcodeUrl }"/>
						</c:if>
						<c:if test="${certificateInfo.seal eq '1'}">
						<img style="position: absolute; z-index: -1;width: ${certificateInfo.positionWidth}px; height: ${certificateInfo.positionHeight}px; left: ${certificateInfo.positionRight}px; top: ${certificateInfo.positionTop}px;" src="<%=pdfImageServer%>${certificateInfo.signetUrl }"/>
						</c:if>
					</div>
				</div>
			</div>
		</div>
        </c:forEach>
        
    </body>
</html>
