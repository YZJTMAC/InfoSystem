<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../common/commonHead.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>信息变更详情</title>
<script type="text/javascript">
	var auditId = ${auditId};
</script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
<script type="text/javascript" src="<%=basePathHeader %>/javascript/teacher/teacherInfoChangeDetail.js"></script>
</head>
<body>
	<!-- top -->
	<div class="head">
			<jsp:include page="../common/top.jsp" >
			<jsp:param value="teacher" name="flag"/>
		</jsp:include>
	</div>
	<!-- left -->
	<div class="leftNav">
		<%@include file="../common/teacherLeft.jsp"%>
	</div>
	<div class="content">
<%@include file="teacherInfoChangeCommon.jsp"%>

 <div class="formtitle"><span>审核</span></div>
    
    <ul class="forminfo">
    
    <li><label>是否通过：</label><cite>
    <input name="status" type="radio" value="13" checked="checked" />审核通过&nbsp;&nbsp;&nbsp;&nbsp;
    <input name="status" type="radio" value="12" />审核不通过</cite></li>
    
    <li><label>审核意见：</label>
    <textarea id="memo" cols="" rows="" class="textinput"></textarea></li>
    <li><label>&nbsp;</label>
    <input name="" type="button" class="btn" value="提交审核" onclick="audit()"/>&nbsp;&nbsp;&nbsp;&nbsp;
    <input name="" type="button" class="cancel" value="取消"/></li>
    </ul>
    </div>
    <div id="myModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" ></div>
</body>
</html>