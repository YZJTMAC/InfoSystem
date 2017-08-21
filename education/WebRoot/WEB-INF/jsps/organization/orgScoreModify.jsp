<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="../common/commonHead.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>培训成绩修改</title> 
<link rel="stylesheet" href="<%=basePathHeader%>/javascript/common/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css" />	
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/ztree/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/organization/orgScoreModify.js"></script>
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
				<li><a href="#">培训项目</a>
				</li>
				<li><a href="#">培训成绩修改</a>
				</li>
				<li><a href="#">修改</a>
				</li>
			</ul>
		</div>
		<!-- <div class="place">
			<p style="padding:0 20px;color:#39C">操作提示:</p>
		</div> -->

<!-- <div class="content_wrap">
	<div class="zTreeDemoBackground left">
		  <ul id="treeDemo2" class="ztree"></ul>
	</div>
	<div class="right">
		 
	</div>
</div> -->
		<div class="formbody" style="overflow:hidden;">

			<ul class="seachform">
				<li>

					<p class="xmTool">
						项目名称：<b id="pname"> </b>
					</p></li>

				<li><label>教师姓名：</label> <input id="txtTeacherName"
					name="input" type="text" class="scinput" /></li>
				<li><input id="select" name="input2" type="button"
					class="dian3" value="查 询" /></li>


			</ul>



			<div style="width:30%; float:left;">
				<div style="width:180px; float:left;">
				 <ul id="treeDemo2" class="ztree"></ul>
				  
				   <ul id="treeDemo" class="ztree"></ul>
				   
					<span class="tabson">
						<div id="using_json"></div> </span>
				</div>

			</div>

			<div style="width:70%; float:left;">
				<div class="tabson">



					<div class="chauxnJS jsTool">
						<span style="float:left;"> <a
							href="javascript:history.back();" class="huibtn_a  "
							style=" margin-left:6px">返回</a> </span> <span style="float:right;">
							  </span>
					</div>

					<table class="tablelist">
						<thead>
							<tr>

								<th width="10%">姓名</th>
								<!-- <th width="4%">性别</th> -->
								<th width="20%">学校</th>

								<th width="6%">培训成绩</th>
								<th width="6%">培训学时</th>
								<th width="6%">操作</th>
							</tr>
						</thead>
						<tbody id="target">
						</tbody>
					</table>
					<!-- 分页 -->
				<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
				<input id="sizePerPage" type="hidden" value="20" name="sizePerPage" />
				<div id="pagebar" class="pagin"></div>
				<!-- 分页 -->

				</div>
			</div>
		</div>

	</div>

 				<!-- 页面隐藏域 -->
					<input id="txtProvinceId" type="hidden"  />
					<input id="txtCityId" type="hidden"  />
					<input id="txtDistrictId" type="hidden"  />
					<input id="txtSchoolId" type="hidden"  />
					
					<input id="txtSchoolType"  type="hidden"  />
					
					<input id="txtAreaLevel" type="hidden"  />
					<input id="txtAreaId" type="hidden"  />
				<!-- 页面隐藏域 -->

</body>
</html>
