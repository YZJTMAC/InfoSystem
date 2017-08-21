<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>按学段统计</title>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherSemesterStatsPage.js"></script>

<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="<%=basePathHeader%>/javascript/common/DataTables/media/js/jquery.js"></script>
<script type="text/javascript" charset="utf8" src="<%=basePathHeader%>/javascript/common/DataTables/media/js/jquery.dataTables.js"></script>

<!-- DataTables tools -->
<script type="text/javascript" charset="utf8" src="<%=basePathHeader%>/javascript/common/DataTables/extensions/TableTools/js/dataTables.tableTools.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePathHeader%>/javascript/common/DataTables/media/css/jquery.dataTables.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePathHeader%>/javascript/common/DataTables/extensions/TableTools/css/dataTables.tableTools.css"/>
</head>

<body>
	<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp">
			<jsp:param value="system" name="flag" />
		</jsp:include>
	</div>
	<!-- left -->
	<div class="leftNav">
		<%@include file="../common/systemLeft.jsp"%>
	</div>

	<div class="content">
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">教师信息统计</a></li>
				<li><a href="#">按学段统计</a></li>

			</ul>
		</div>

		<div class="formbody">

			<div class="idTabs itab">
				<ul>
					<li><a href="#tab1" id="tabPage0" class="selected">职称<span
							class="ctype"></span> </a></li>
					<li><a href="#tab2" id="tabPage1">学历<span class="ctype"></span>
					</a></li>
					<li><a href="#tab3" id="tabPage1">年龄<span class="ctype"></span>
					</a></li>
					<!--  <li><a href="#tab4" id="tabPage1">学科<span class="ctype"></span>
					</a></li>-->

				</ul>
			</div>

			<div id="tab1" class="tabson" style="overflow-x: scroll; overflow-y: auto;">
				<table class="tablelist" style="width:5000px;">
					<thead id="thPro">
						<!-- <tr>
							<th width="10%"></th>
							<th width="4%">编号</th>
							<th width="5%">小计</th>
							<th width="5%">中学高级</th>
							<th width="5%">小学高级</th>
							<th width="5%">小学一级</th>
							<th width="5%">小学二级</th>
							<th width="5%">小学三级</th>
							<th width="5%">未定职称</th>
						</tr> -->
					</thead>
					<tbody id="tbPro">
					</tbody>
				</table>
			</div>

			<div id="tab2" class="tabson" style="overflow-x: scroll; overflow-y: auto;">
				<!-- <table id="hideTableEdu" >
					<thead >
					</thead>
					<tbody >
					</tbody>
				</table> -->
				<table class="tablelist" style="width:5000px;">
					<thead id="thEdu">
					</thead>
					<tbody id="tbEdu">
					</tbody>
				</table>
			</div>


			<div id="tab3" class="tabson">
				<table class="tablelist">
					<thead>
						<tr>
							<th></th>  
							<th>编号</th>
							<th>小计</th>
							<th>24岁及以下</th>
							<th>25-29岁</th>
							<th>30-34岁</th>
							<th>35-39岁</th>
							<th>40-44岁</th>
							<th>45-49岁</th>
							<th>50-54岁</th>
							<th>55-59岁</th>
							<th>60岁及以上</th>
							<th>其它</th>
						</tr>
					</thead>
					<tbody id="tbAge">
					</tbody>
				</table>
			</div>

			<!--  <div id="tab4" class="tabson"  style="overflow-x: scroll; overflow-y: auto;">
				<table class="tablelist" style="width:15000px;">
					<thead id="thSub">
			-->
					<!-- 	<tr>
							<th width="10%"></th>
							<th width="4%">编号</th>
							<th width="5%">小计</th>
							<th width="5%">语文</th>
							<th width="5%">数学</th>
							<th width="5%">英语</th>
							<th width="5%">...</th>
						</tr> -->
				<!--	</thead>
					<tbody id="tbSub">
					</tbody>
				</table>
			</div>-->

			<input type="hidden" id="extEdu"/>
		</div>
	</div>
</body>
</html>
