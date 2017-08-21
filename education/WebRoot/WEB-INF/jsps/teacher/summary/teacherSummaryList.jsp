<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>教师培训总结</title>

<%@include file="../../common/commonHead.jsp"%>

<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherSummaryList.js"></script>

<script type="text/javascript">
	$(document).ready(function(e) {
		$(".select3").uedSelect({
			width : 100
		});
	});
</script>
</head>

<body>
	<!-- top -->
	<div class="head">
		<jsp:include page="../../common/top.jsp">
			<jsp:param value="project" name="flag" />
		</jsp:include>
	</div>
	<!-- left -->
	<div class="leftNav">
		<%@include file="../../common/projectLeft.jsp"%>
	</div>

	<div class="content">
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">培训项目管理</a></li>
				<li><a href="#">项目总结</a></li>
				<li>
				 	培训项目总结:培训项目结束后,教师可以上传培训项目总结附件供行政管理员和实施管理员查看和下载使用
				</li>
			</ul>
		</div>

		<div class="formbody">

			<div class="tabson">
				<ul class="seachform">
					<li><label>项目名称：</label> <input name="input" id="projectName"
						name="projectName" type="text" class="scinput" />
					</li>
					<li><label>项目年度：</label>
						<div class="vocation">
							<select class="select3 yearpicker" name="startTime"
								id="startTime">
									<option value="">请选择</option>
								</select> --
						</div>
					</li>
					<li>--</li>
					<li>
						<div class="vocation">
							<select class="select3 yearpicker" name="endTime" id="endTime">
									<option value="">请选择</option>
							</select>
						</div>
					</li>
					<li><a href="#" onclick="selectCloseProjectList()"
						class="dian3">查 询</a></li>
				</ul>
			</div>
			
			<table class="tablelist">
				<thead>
					<tr>
						<th width="20%">项目名称</th>
						<th width="30%">开始时间</th>
						<th width="20%">结束时间</th>
						<th width="30%">操作</th>
					</tr>
				</thead>
				<tbody id="summaryList">
				</tbody>
			</table>
			<!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
		</div>
	</div>
	
	<!-- 培训总结上传模态框 -->	
	<div id="myModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="projectName2"></h3><label>附件上传：【支持上传图片，文本文件，OFFICE 文档，压缩包等】</label>
	  </div>
	  <div class="modal-body">
	    <form id="declareForm" enctype="multipart/form-data" method="post">
			<input id="projectId" name="projectId" type="hidden" value="" />
			<input id="projectName3" name="projectName" type="hidden" value="" />
			<input id="type" name="type" type="hidden" value="summarry" />
			<table id="hasUpload" class="table table-hover table-condensed">
			</table>
			<table id="noUpload" class="table">
			</table>
		</form>
	  </div>
	  <div class="modal-footer">
	  	<button class="btn btn-primary"   onclick="addMore()">增加文件</button>
	    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	    <!-- <button class="btn btn-primary" onclick="saveFiles()">保存</button> -->
	  </div>
	</div>
	<!-- 培训总结上传模态框结束 -->	

</body>
</html>
