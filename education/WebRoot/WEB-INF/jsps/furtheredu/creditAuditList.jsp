<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学分审核</title>
<%@include file="../common/commonHead.jsp"%>
<script type=text/javascript src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/creditAuditList.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
		$(".select2").uedSelect({
			width : 167
		});
		$(".select3").uedSelect({
			width : 100
		});
	});
</script>
</head>

<body>
	<input type="hidden" name="areaId" type="text" value="${areaId }" />
	<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp">
			<jsp:param value="furtheredu" name="flag" />
		</jsp:include>
	</div>
	<!-- left -->
	<div class="leftNav">
		<%@include file="../common/furthereduLeft.jsp"%>
	</div>

	<div class="content">
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="jixuMegGLY_2.2.html">继教信息</a></li>
				<li>校本培训项目</li>
			</ul>
		</div>

		<div class="formbody">
			<div class="idTabs itab">
				<ul>
					<li><a href="#tab1" id="tabPage0" class="selected">培训类项目<span
							class="ctype"></span> </a>
					</li>
					<li><a href="#tab2" id="tabPage1">非培训类项目<span
							class="ctype"></span> </a>
					</li>

				</ul>
			</div>

			<div id="tab1" class="tabson">
			<div class="tabson">

				<ul class="seachform" style="padding-left:23px;">
				
					<!-- <li><label>继教信息板块:</label>
						<div class="vocation">
							<select class="select2" id="modelType" name="modelId">
							</select>
						</div>
					</li> -->
					     <li>
							<label>
								项目名称：
							</label>
							<div class="vocation">
								<input name="input" id="projectName" type="text" value="" class="scinput" />
							</div>
						</li>
					
					<li><label>项目年度：</label>
						<div class="vocation">
							<select id="queryYear" name="queryYear" class="select3 yearpicker">
								<option value="">请选择</option>
							</select>
						</div>
					</li>
					<li><label>&nbsp;</label><input type="button" class="scbtn"
						id="select" value="查 询" /></li>

				</ul>
			</div>
			
				<table class="tablelist">
					<thead>
						<tr>
							<th>项目名称</th>
							<th>培训性质</th>
							<th>培训形式</th>
							<th>项目学时</th>

							<th>操作</th>

						</tr>
					</thead>
					<tbody id="target">
						<tr>
							<td>全员培训</td>
							<td>区县级项目</td>
							<td>远程</td>

							<td><a href="#" class="tablelink click">查看学分规则</a> <a
								href="xunfen.4.1.html" class="tablelink click">审核</a>
							</td>
						</tr>
					</tbody>
				</table>
				<!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			 <!-- 分页 -->
						<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
						<div id="page_1"></div>
						<!-- 分页 -->
			</div>


			<div id="tab2" class="tabson">
			<div class="tabson">

				<ul class="seachform" style="padding-left:23px;">
					<!-- <li><label>继教信息板块:</label>
						<div class="vocation">
							<select class="select2" id="modelTypes" name="modelIdes">

							</select>
						</div>
					</li> -->
					
					    <li>
							<label>
								项目名称：
							</label>
							<div class="vocation">
								<input name="input" id="projectName" type="text" value="" class="scinput" />
							</div>
						</li>
					<li><label>项目年度：</label>
						<div class="vocation">
							<select id="queryYear" class="select3 yearpicker">
								<option value="">请选择</option>
							</select>
						</div>
					</li>
					<li><label>&nbsp;</label><input type="button" class="scbtn"
						id="select2" value="查 询" /></li>

				</ul>
			</div>
			
				<table class="tablelist">
					<thead>
						<tr>
							<th>项目名称</th>
							<th>组织单位</th>
							<th>范围</th>
							<th>计划学分</th>
							<th>操作</th>

						</tr>
					</thead>
					<tbody id="target2">
					</tbody>
				</table>
				<div id="page_2"></div>
			</div>

			

			<!-- 弹出 -->
			<div class="tip">
				<div class="tiptop">
					<span>学分转换规则</span><a></a>
				</div>
				<p class="xmTool" id="modelname">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b> 继教信息板块: </b>
				</p>

				<table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
					<tr>
						<td>
							<p id="punit"></p>
						</td>
					</tr>
					<tr>
						<td>
							<p id="excellentunit"></p>
						</td>
					</tr>
				</table>
			</div>
			<!-- 弹出 -->

			<!-- 页面隐藏域 -->
			<input id="isScorePublished" value="0" type="hidden" /> <input
				id="txtProjectId" type="hidden" />
			<!-- 页面隐藏域 -->

		</div>
	</div>

<!--  

	<script id="template" type="x-tmpl-mustache">
{{#projects}}
	<tr>
		<td>{{projectName}} </td>
		<td>{{projectPropertyName}}</td>
		<td>{{trainTypeName}}</td>
		<td>{{classPeriod}}</td>
		 
		<td>
			<a href="#" class="tablelink" onclick="popup({{id}},{{eduModelType}},'{{projectName}}');">查看学分规则</a> 
			<a href="#" class="tablelink" onclick="gotoAudit({{id}},{{eduModelType}},'{{projectName}}');">审核</a> 
		</td>
</tr>
{{/projects}}
</script>

	<script id="template2" type="x-tmpl-mustache">
{{#projects}}
	<tr>
		<td>{{name}} </td>
		<td>{{organizer}}</td>
		<td>{{scopeName}}</td>
		<td>{{credit}}</td>
		<td>
			<a href="creditAuditNoTrainPage.htm?projectId={{id}}&projectName={{name}}&click=9" class="tablelink">审核</a> 
		</td>
</tr>
{{/projects}}
</script>
-->
</body>
</html>