<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<%@include file="../common/commonHead.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>教师成绩查询</title>
	<script type="text/javascript">
		$(document).ready(function(e) {
			$(".select3").uedSelect({
				width : 100
			});
		});
	</script>
	
	<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
	<script type="text/javascript" src="<%=basePathHeader%>/javascript/organization/teacherScoreProjectList.js"></script>
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
				<li><a href="#">培训项目</a></li>
				<li><a href="#">教师成绩查询</a></li>
			</ul>
		</div>

		<div class="formbody">

			<div id="usual1" class="usual">
				<div id="tab1" class="tabson">
					<div class="tabson">
						<ul class="seachform">
							<li>
								<label>项目名称：</label> 
								<input id="projectName" name="input" type="text" class="scinput" />
							</li>
							<li><label>项目年度：</label></li>
							<li>
								<select id="projectYear" name="select" class="select3 yearpicker" >
									<option value="">请选择...</option>
								</select>
							</li>
							<li><a onclick="getProjectList()" href="#" class="dian3">查 询</a></li>
						</ul>
					</div>
					<table class="tablelist">
						<thead>
							<tr>
								<th>项目名称</th>
								<th>培训形式</th>
								<th>计划人数</th>
								<th>报名人数</th>
								<th>学习人数</th>
								<th>成绩未审核人数</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="target">
							
						</tbody>
					</table>


				</div>
				<!-- 分页 -->
				<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
				<input id="pageSize" type="hidden" value="20" name="pageSize" />
				<div id="pagebar" class="pagin"></div>
				<!-- 分页 -->
			</div>
		</div>
	</div>
</body>
</html>
