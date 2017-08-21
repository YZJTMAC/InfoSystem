<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>调查问卷管理</title>

<%@include file="../common/commonHead.jsp"%>
<link />
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/projectPaperList.js"></script>
</head>
<body>
<input type="hidden" id="projectId" value="${proId}"/>
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
    <li><a href="#">项目调查与评估</a></li>
    </ul>
    </div>
    <div class="tabson">
        <p class="xmTool">项目名称：<b><%=request.getAttribute("projectName") %></b>计划培训人数：<b> <%=request.getAttribute("planNum") %></b>    开始时间:<b><%=request.getAttribute("startDate") %></b>  结束时间:<b><%=request.getAttribute("endDate") %></b> </p>  
    </div>
    <div class="formbody" >
    <div class="chauxnJS jsTool">
    <span style="float:left;"><a href="<%=basePathHeader%>/edupm/paper/addPaper.htm?click=32&proId=<%=request.getAttribute("proId") %>" class="huibtn_a  " style=" margin-left:6px">添加</a>&nbsp;  </span>
    </div>
      <table class="tablelist" >
        <thead>
          <tr>
            <th>问卷名称</th> 
			<th>开始时间</th> 
			<th>结束时间</th> 
			<th>发布人</th> 
			<th>参与人数</th>
			<th>是否强制提交</th>
			<th>问卷状态</th>
			<th>问卷结果</th>
          </tr>
        </thead>
        <tbody id="proList">
         
         
        </tbody>
      </table>
      <!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
	<!-- 分页 -->
    </div> 
	</div>

</body>

</html>
