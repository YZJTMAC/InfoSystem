<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>通知详情</title>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/message/messageInfo.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
</head>
<body>
	<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp">
			<jsp:param value="person" name="flag" />
		</jsp:include>
	</div>
	<!-- left -->
	<div class="leftNav">
		<%@include file="../common/personLeft.jsp"%>
	</div>

	<div class="content">
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">个人中心</a>
				</li>
				<li><a href="#">通知</a>
				</li>
				<li><a href="#">查看通知</a>
				</li>
			</ul>
		</div>
		<div class="formbody">
			<div class="article">
				<h4>${message.title }</h4>
				<div class="time">
					<span><fmt:formatDate value="${message.createDate }" /> </span> <span>发布人：${message.sendUserName}</span> 
					<span>
						通知类型：
						<c:choose>
							<c:when test="${message.messageType == 1 }">
								省级通知
							</c:when>
							<c:when test="${message.messageType == 2 }">
								市级通知
							</c:when>
							<c:when test="${message.messageType == 3 }">
								区县通知
							</c:when>
							<c:when test="${message.messageType == 4 }">
								学校通知
							</c:when>
						</c:choose>
					</span>
				</div>
				<div class="content1">
					<p class="arc">${message.content }</p>
				</div>
				<div class="content1">
					<p><h2>附件：</h2></p>
					<table>
						<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>${message.fileName}</td>
							<td>&nbsp;&nbsp;</td>
							<td>
								<c:if test="${not empty message.fileUrl}">
									<a href='#' onclick='downloadFile("${message.fileUrl}")'>下载 </a>
								</c:if>
							</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>