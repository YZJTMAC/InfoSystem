<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="../common/commonHead.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>培训项目过程管理</title>
		<script type="text/javascript">
			$(document).ready(function(e) {
				$(".select2").uedSelect( {
					width : 167
				});
			});
		</script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/organization/orgProProcessList.js"></script>
	</head>
	<body>
		<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="project" name="flag" />
			</jsp:include>
		</div>
		<!-- left -->
		<div class="leftNav" style="background: #f0f9fd;">
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
						<a href="#">培训项目过程管理</a>
					</li>
					<li>
						在培训项目筹备开始至培训项目关闭之前,实施管理员可以上传相关培训材料供行政管理员操作,行政管理员也可以上传相关培训材料
					</li>
				</ul>
			</div>
			<div class="formbody">
				<div class="tabson">
					<ul class="seachform">
						<li>
							<label>
								项目名称：
							</label>
							<input id="projectName" name="input" type="text" class="scinput" />
						</li>
						<li>
							<label>
								项目年度：
							</label>
						</li>
						<li>
							<select id="beginDate" name="select" class="select2 yearpicker">
								<option value="">请选择</option>
							</select>
						</li>
						<li>
							--
						</li>
						<li>
							<select id="endDate" name="select" class="select2 yearpicker">
								<option value="">请选择</option>
							</select>
						</li>
						<li>
							<input id="select" name="input2" type="button" class="dian3"
								value="查 询" />
						</li>
					</ul>
				</div>
				<table class="tablelist">
					<thead>
						<tr>
							<th>
								项目名称
							</th>
							<th>
								开始时间
							</th>
							<th>
								结束时间
							</th>
							<th>
								申报人
							</th>
							<th>
								实施机构
							</th>
							<!-- <th>
								创建人
							</th> -->
							<th>
								审核人
							</th>
							<th>
								操作
							</th>
						</tr>
					</thead>
					<tbody id="orgProject_list">
					</tbody>
				</table>
				<!-- 分页 -->
				<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
				<input id="pageIndex" value="0" type="hidden" name="pageIndex" />
				<div id="pagebar" class="pagin"></div>
				<!-- 分页 -->
					
		</div>	
		
		<!-- 实施机构过程管理模态框 -->	
		<div id="processModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h3 id="projectName2"></h3><label>附件上传：【支持上传图片，文本文件，OFFICE 文档，压缩包等】</label>
		  </div>
		  <div class="modal-body">
		    <form id="declareForm" enctype="multipart/form-data" method="post">
				<input id="projectId" name="projectId" type="hidden" value="" />
				<input id="projectName3" name="projectName" type="hidden" value="" />
				<input id="type" name="type" type="hidden" value="process" />
				<table id="hasUpload" class="table table-hover table-condensed">
				</table>
				<table id="noUpload" class="table">
				</table>
			</form>
		  </div>
		  <div class="modal-footer">
		  	<button class="btn btn-primary"  id="addFile"  onclick="addMore()">增加文件</button>
		    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		    <!-- <button class="btn btn-primary" onclick="saveFiles()">保存</button> -->
		  </div>
		</div>
		<!-- 实施机构过程管理模态框结束 -->	

		<!-- 实施机构过程管理模态框 -->	
		<div id="processViewModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h3 id="projectName4"></h3>
		  </div>
		  <div class="modal-body">
				<table id="viewTable" class="table table-hover table-condensed">
				</table>
		  </div>
		  <div class="modal-footer">
		   <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		  </div>
		</div>
		<!-- 实施机构过程管理模态框结束 -->	

	</div>
		<!-- </div> -->
	</body>
</html>
