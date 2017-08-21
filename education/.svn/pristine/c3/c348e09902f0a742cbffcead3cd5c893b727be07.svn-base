<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>指定培训机构</title>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript">
	var proId = <%=request.getParameter("proId")%>
</script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/orgClassList.js"></script>
</head>
<body>
<!-- top -->
		<div class="head">
		<jsp:include page="../common/top.jsp" >
			<jsp:param value="project" name="flag"/>
		</jsp:include>
	</div>
	<!-- left -->
	<div class="leftNav">
		<%@include file="../common/projectLeft.jsp"%>
	</div>
	<div class="content">
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">培训项目管理</a></li>
    <li><a href="#">课程设置</a></li>
	 <li><a href="#">机构课程查看</a></li> 
    </ul>
    </div>
     
    <div class="formbody">
    
    

      <div class="tabson">
        <p class="xmTool">项目名称：<b id="projectName2">${name}</b>计划培训人数：<b id="planNum2">${planNum}</b> </p> 
        <div> 
         <table class="tablelist" style="margin-top:12px;">
        <thead>
          <tr>
            <th width="20%">培训实施机构</th>
			<th width="80%">课程</th>
          </tr>
        </thead>
        <tbody id="orgList">
		   <c:forEach items="${class}" var="c" >
		   <tr>
		   	<td width="20%">${c.orgName}</td>
		   	<td width="80%">${c.classes}</td>
		   </tr>
		   </c:forEach>
        </tbody>
      </table>
		 </div>
      </div>
    </div> 
</div>
</body>
</html>