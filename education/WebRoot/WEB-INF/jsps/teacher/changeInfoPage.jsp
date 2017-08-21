<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>信息变更详情</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherInfoChangePage.js"></script>
		<script type="text/javascript">
			var auditId = ${auditId};
			function goBack() {
				window.location.href = "<%=basePathHeader%>/teacher/teachermanage/teacherInfoChangePage.htm?click=100";
			}
		</script>
	</head>

	<body>
		<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="teacher" name="flag" />
			</jsp:include>
		</div>
		<!-- left -->
		<div class="leftNav">
			<%@include file="../common/teacherLeft.jsp"%>
		</div>

		<div class="content">
			<div class="place">
				<span>位置：</span>
				<ul class="placeul">
					<li>
						<a href="#">变更信息记录</a>
					</li>
					<li>
						<a href="#">变更详情</a>
					</li>
				</ul>
			</div>
			
			<%@include file="teacherInfoChangeCommon.jsp"%>
		     <ul class="forminfo">
		    
		    <li><label>&nbsp;</label><input name="" type="button" onclick="goBack();" class="btn" value="返回" /></li>
		    </ul>
		</div>
	</body>

</html>
