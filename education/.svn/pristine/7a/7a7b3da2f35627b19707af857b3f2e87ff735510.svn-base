<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人信息</title>
<%@include file="../common/commonHead.jsp"%>

<script type="text/javascript"
	src="<%=basePathHeader%>/javascript/message/notice.js">
	
</script>
<script type="text/javascript"
	src="<%=basePathHeader%>/javascript/common/dateFormat.js">
	
</script>
<style>
.article span {
	display: inline;
}

.article {
	margin: 0 auto;
	margin-left: 10px;
}

.article h2,.article h4 {
	font-size: 14px;
	color: #464646;
}

.article h4 {
	padding-top:20px;
}

.article .time {
	padding-top: 10px;
	border-bottom: dashed 1px #b3b3b3;
}

.article .time span {
	font-size: 12px;
	color: #b3b3b3;
	margin: 10px;
}

.content1 {
	padding-top: 20px;
}

.content1 p {
	color: #3f453f;
	font-size: 12px;
	text-indent: 2em;
	line-height: 28px;
}

.content1 .arc {
	line-height: 28px;
	text-indent: 5em;
}
</style>

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
				<h4>${notice.title }</h4>
				<div class="time">
					<span><fmt:formatDate value="${notice.createDate }" /> </span> <span>发布人：${notice.sendUserName
						}</span> <span>通知类型：
						<c:choose>
							<c:when test="${notice.noticeType == 1 }">
								省级通知
							</c:when>
							<c:when test="${notice.noticeType == 2 }">
								市级通知
							</c:when>
							<c:when test="${notice.noticeType == 3 }">
								区县通知
							</c:when>
							<c:when test="${notice.noticeType == 4 }">
								学校通知
							</c:when>
						</c:choose></span>
				</div>
				<div class="content1">
					<p class="arc">${notice.content }</p>
				</div>
				<div class="content1">
					<p><h2>附件：</h2></p>
					<table><tr>
					<c:forEach var="noticeFile" items="${noticeFiles}"> 
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>${noticeFile.fileName}</td>
					<td>
						<a href='#' onclick='downloadFile("${noticeFile.fileUrl}")' >下载 </a>
						</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</c:forEach></tr>
						</table>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
