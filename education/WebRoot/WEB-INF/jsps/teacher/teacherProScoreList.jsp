<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<%@include file="../common/commonHead.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>培训成绩导入</title>
	<script type="text/javascript">
		$(document).ready(function(e) {
			$(".select2").uedSelect( {
				width : 167
			});
		});
	</script>
	<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
	<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherProScoreList.js"></script>
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
			<li>
					<a href="#">培训项目</a>
				</li>
				<li>
					<a href="#">培训成绩导入</a>
				</li>
				<li>
					操作说明：在对应培训项目中点击模板按钮下载导入成绩模板，模板文件数据填写完成后导入成绩，然后在培训成绩审核中由管理员进行审核。
				</li>
				
			</ul>
		</div>
		<div class="formbody">
			<div class="tabson">
				<ul class="seachform">
					<li>
						<label>项目名称：</label>
						<input id="projectName" name="input" type="text" class="scinput" />
					</li>
					<li>
						<label>项目年度：</label>
					</li>
					<li>
						<select id="beginDate" name="select" class="select2 yearpicker" width="110px;">
							<option value="">请选择</option>
						</select>
					</li>
					<li>
						--
					</li>
					<li>
						<select id="endDate" name="select" class="select2 yearpicker" width="110px;">
							<option value="">请选择</option>
						</select>
					</li>
					<li>
						<input id="select" name="input2" type="button" class="dian3" value="查 询" />
					</li>
				</ul>
			</div>
			<table class="tablelist">
				<thead>
					<tr>
						<th width="30%">项目名称</th>
          				<th>项目状态</th>
						<th>培训形式</th>
						<th>创建人</th>
						<th>实施机构</th>
						<th>是否已结束报名</th>
						<th>申报人</th>
				        <th>计划人数</th>
						<th>审核人</th>
				        <th>参培人数</th>
				        <th>操作</th>
					</tr>
				</thead>
				<tbody id="proTeacher_list">
				</tbody>
			</table>
			<!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
			<!-- 分页 -->
		</div>
	</div>
	<iframe id="downIframe"　src="" frameborder=0 scrolling=no marginheight=0 marginwidth=0 height=60 width="100%"></iframe>
</body>
</html>
