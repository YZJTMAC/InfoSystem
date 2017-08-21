<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="../common/commonHead.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学分登记</title>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/mustache.js"></script>
 <script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/creditEnterList.js"></script>
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
				<li><a href="#">继教信息</a></li>
				<li><a href="#">学分登记</a></li>
			</ul>
		</div>
		 
		<div class="place">
			<p style="padding:0 20px;color:#39C">操作提示:非培训类项目和校本类项目学分登记</p>
		</div>


		<div class="formbody">


			<div id="usual1" class="usual">

				<div class="itab">
					<ul>
						<li><a href="#tab1" id="tabPage0" class="selected">非培训类项目<span
								class="ctype"></span> </a></li>
						<li><a href="#tab2" id="tabPage1">校本培训项目<span
								class="ctype"></span> </a></li>

					</ul>
				</div>
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
							<select id="queryYear" class="select3 yearpicker">
								<option value="">请选择</option>
							</select>
						</div></li>
					<li><label>&nbsp;</label><input id="select" name="input2" type="button"
							class="scbtn" value="查 询" />
					</li>

				</ul>
			</div>
			
<!-- 				<div class="tabson">
				
					<ul class="seachform">
						<li><label>继教信息板块:：</label></li>
						<li>	<div class="vocation"><select class="select2" id="modelType" name="modelId">

							</select></div></li>
					 
						<li><label>项目年度：</label></li>
						<li><select id="queryYear" class="select3 yearpicker">
							</select></li>


						<li><input id="select" name="input2" type="button"
							class="dian3" value="查 询" /></li>
					</ul>
				</div> -->
				<div id="tab1" class="tabson">
					<table class="tablelist">
						<thead>
							<tr>
								<th>项目名称</th>
								<th>组织单位</th>
								<th>开始日期</th>
								<th>结束日期</th>
								<th>范围</th>
								<th>学分</th>
								<th>操作</th>

							</tr>
						</thead>
						<tbody id="target"><tr>
<!-- 
						<td>校本培训项目一</td>
						<td>xx小学</td>
						 <td>2016-4-1</td>
                         <td>2017-4-1</td>
						 <td>广州市</td>
						 <td>5</td>
					<td><a href="creditEnterNoTrainPage.htm?projectId=13" class="tablelink click">登记</a> </td>
						 -->

					</tr>
						 </tbody>
					</table>
<div id="page_1"></div>




				</div>


				<div id="tab2" class="tabson">
					<table class="tablelist">
						<thead>
							<tr>
								<th>项目名称</th>
								<th>组织单位</th>

								<th>开始日期</th>
								<th>结束日期</th>
								<th>学分</th>
								<th>操作</th>

							</tr>
						</thead>
						<tbody id="target2"><tr>

						<!-- <td>校本培训项目一</td>
						<td>xx小学</td>
						 <td>2016-4-1</td>
                         <td>2017-4-1</td>
						 <td>5</td>
						<td><a href="creditEnterSchoolPage.htm?projectId=14" class="tablelink click">登记</a> </td> -->
						

					</tr>
						 </tbody>
					</table>
<div id="page_2"></div>

				</div>
				<!-- 分页 -->
				<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
				<div id="pagebar" class="pagin"></div>
				<!-- 分页 -->
 


				<!-- 页面隐藏域 -->
				<input id="isScorePublished" value="1" type="hidden"
					name="isScorePublished" /> <input id="txtProjectId" type="hidden" />
				<!-- 页面隐藏域 -->



				<script id="template" type="x-tmpl-mustache">
{{#projects}}
	<tr>
		<td>{{name}} </td>
		<td>{{organizer}}</td>
		<td>{{beginDate}}</td>
		<td>{{endDate}}</td>
		<td>{{scopeName}}</td>
		<td>{{credit}}</td>
		<td>
			<a href="creditEnterNoTrainPage.htm?projectId={{id}}&projectName={{name}}&scope={{scopeId}}&click=8" class="tablelink">登记</a> 
		</td>
</tr>
{{/projects}}
</script>

				<script id="template2" type="x-tmpl-mustache">
{{#projects}}
	<tr>
			<td>{{name}} </td>
		<td>{{organizer}}</td>
		<td>{{beginDate}}</td>
		<td>{{endDate}}</td>
		<td>{{credit}}</td>
		<td>
			<a href="creditEnterSchoolPage.htm?projectId={{id}}&projectName={{name}}&scope={{scopeId}}&click=8" class="tablelink">登记</a> 
		</td>
</tr>
{{/projects}}

	 
</script>


<script id="template3" type="x-tmpl-mustache">
{{#models}}
	 <option value='{{id}}'> {{name}} </option>
{{/models}}
</script>



				<script type="text/javascript">
					$("#usual1 ul").idTabs();
				</script>

				<script type="text/javascript">
					$('.tablelist tbody tr:odd').addClass('odd');
				</script>




			</div>

		</div>
	</div>

	<iframe id="downIframe" 　src="" frameborder=0 scrolling=no
		marginheight=0 marginwidth=0 height=60 width="100%"></iframe>
</body>
</html>
