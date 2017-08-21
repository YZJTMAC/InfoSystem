<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="../common/commonHead.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>培训成绩公布</title>
<script type="text/javascript">
	$(document).ready(function(e) {
		$(".select2").uedSelect({
			width : 167
		});
	});
</script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/organization/orgScorePublishi.js"></script>
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
				<li><a href="#">培训成绩公布</a></li>
				<li>操作说明：需要导入成绩后，方可查询出项目列表。</li>
			</ul>
		</div>
		<!-- <div class="place">
			<p style="padding:0 20px;color:#39C">操作提示:成绩确定公布后标志项目真正结束.1.查看导入的成绩.2.成绩修改,可批量可单个修改.3.公布成绩
			</p>
			<p style="padding:0 20px;color:#39C">公布规则:1.公布分数2.按合格不合格公布,设置合格分数.3.按等级公布,优良中差,设置各级分数.4.获得学时的最低学分设置</p>
		</div> -->


		<div class="formbody">


			<div id="usual1" class="usual">

				<div class="itab">
					<ul>
						<li><a href="#tab1" id="tabPage0" class="selected">未公布成绩<span class="ctype"></span> </a></li>
								
						<li><a href="#tab2" id="tabPage1">已公布成绩<span class="ctype"></span> </a></li>

					</ul>
				</div>				
				<div id="tab1" class="tabson">
				<ul class="seachform">
						<li><label>项目名称：</label> <input id="projectName1" name="input"
							type="text" class="scinput" /></li>
						<li><label>项目年度：</label></li>
						<li><select id="projectYear1" name="select"
							class="select2 yearpicker" width="110px;">
								<option value="">请选择...</option>
							</select></li>
							 <li><a onclick="getProjectList1()" href="#" class="dian3">查 询</a></li>
					</ul>
					<table class="tablelist">
						<thead>
							<tr>
								<th width="28%">项目名称</th>
								<!-- <th>项目状态</th> -->
								<th>培训形式</th>
								<th>创建人</th>
								<th>实施机构</th>
								<th>申报人</th>
								<th>计划人数</th>
								<th>报名人数</th>
								<th>学习人数</th>
								<th>成绩未审核人数</th>
								<th width="8%">操作</th>
							</tr>
						</thead>
						<tbody id="target">
							

						</tbody>
					</table>
				</div>

				<div id="tab2" class="tabson" style="display: none;">
					<ul class="seachform">
						<li><label>项目名称：</label> <input id="projectName2" name="input"
							type="text" class="scinput" /></li>
						<li><label>项目年度：</label></li>
						<li><select id="projectYear2" name="select"
							class="select2 yearpicker" width="110px;">
								<option value="">请选择...</option>	
							</select></li>
							<li><a onclick="getProjectList2()" href="#" class="dian3">查 询</a></li>
					</ul>
					<table class="tablelist">
						<thead>
							<tr>
								<th >项目名称</th>
								<!-- <th >项目状态</th> -->
								<th >培训形式</th>
								<th>创建人</th>
								<th>实施机构</th>
								<th>申报人</th>
								<th >计划人数</th>
								<th >报名人数</th>
								<th >学习人数</th>
								<th >成绩未审核人数</th>
								<th width="8%">操作</th>
							</tr>
						</thead>
						<tbody id="target2">

						</tbody>
					</table>


				</div>
				<!-- 分页 -->
				<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
				<div id="pagebar" class="pagin"></div>
				<!-- 分页 -->
				
</div>
	 		
				
				<!-- 页面隐藏域 -->
				<input id="isScorePublished" value="0" type="hidden" name="isScorePublished" />
				<!-- 页面隐藏域 -->
		</div>
	</div>
</body>
</html>
