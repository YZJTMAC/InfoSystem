<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>调查问卷结果明细</title>
<%@include file="../common/commonHead.jsp"%>
<link />
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/projectPaperDetailList.js"></script>
</head>
<body>
<input type="hidden" id="projectId" value="${proId}"/>
<input type="hidden" id="paperId" value="${paper.id}"/>
<input type="hidden" id="projectNo" value="${info.projectNo}"/>
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
    <li><a href="#">结果明细</a></li>
    </ul>
    </div>
    <div class="tabson">
        <p class="xmTool">项目名称：<b>${info.projectName }</b>问卷名称：<b> ${paper.name}</b>    开始时间:<b>${paper.startDate }</b>  结束时间:<b>${paper.endDate}</b> </p>  
    </div>
    <div class="formbody" >
      <table class="tablelist" >
        <thead>
          <tr>
			<th width="10%">姓名</th> 
			<th width="13%">地区</th> 
			<th width="13%">学校</th> 
			<th width="10%">学段</th> 
			<th width="10%">学科</th> 
			<th width="14%">调查所在ip</th> 
			<th width="15%">提交时间</th> 
			<th width="15%">操作</th> 
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
