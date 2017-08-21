<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>培训成绩导入查看</title>
		<%@include file="../common/commonHead.jsp"%> 
		<script type="text/javascript">
			var projectId = '<%=request.getParameter("projectId")%>';
		</script>
		<link href="<%=basePathHeader%>/javascript/jqplot/jquery.jqplot.min.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript"	src="<%=basePathHeader%>/javascript/jqplot/jquery.jqplot.min.js" ></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/jqplot/jqplot.pieRenderer.min.js" ></script>
		<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/importScoreInfo.js"> </script>
	</head>
	<body>
		<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="project" name="flag" />
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
					<li>
						培训项目
					</li>
					<li>
						培训成绩导入
					</li>
					<li>
						查看
					</li>
				</ul>
			</div>

			<div class="formbody">
				<div class="tabson">
					<table class="tablelist">
      					<thead>
       						<tr>
          						<th >承培机构</th>
          						<th >计划人数</th>
		     					<th >报名人数</th>
          						<th >学习人数</th>
		  						<th  >导入结果</th>
        					</tr>
      					</thead>
      					<tbody id="score_list">
      					</tbody>
    				</table>
				</div>
			</div>
		</div>
	</body>
</html>