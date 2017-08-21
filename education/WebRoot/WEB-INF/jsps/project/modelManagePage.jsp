<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>继教信息版块管理</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/modelManageList.js"></script>
  
		<script type="text/javascript">
			$(document).ready(function(e) {
			    $(".select1").uedSelect({
					width : 345			  
				});
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
					<li><a href="ssadmin.html">培训项目</a></li>
		
					<li>继教信息板块</li>
				</ul>
			</div>
	
			<div class="formbody">
				<div class="formbodyL" style="overflow: hidden; padding-bottom: 20px;">
	
					<div class="chauxnJS jsTool">
					
						<span style="float: left;"> <a href="#" class="huibtn_a click"
							 style="margin-left: 6px" id="btnAdd" onclick="addModelInfo()">添加</a>
						</span>
						<span style="float: right;">
							<div class="pagin" style="margin: 0; width: 180px;">
								<div class="message">
									共
									<i class="blue" id="counts">0</i>条记录
								</div>
								<div class="vocation paginList"
									style="margin: 4px 6px 0 6px; right: 0px;">
									<select onchange="projectList();" id="sizePerPage" class="select3">
										<option value="100">
											每页显示100条
										</option>
										<option value="300">
											每页显示300条
										</option>
										<option value="500">
											每页显示500条
										</option>
									</select>
								</div>
	
							</div> </span>
					</div>
					<table class="tablelist">
						<thead>
							<tr>
								<th width="20%">
									继教信息版块名称
								</th>
								<th width="20%">
									计划周期
								</th>
								<th width="20%">
									开始日期
								</th>
								<th width="20%">
									结束日期
								</th>
								<th width="20%">
									操作
								</th>
							</tr>
						</thead>
	
						<tbody id="modelManageList">
	
						</tbody>
					</table>
	
					<!-- 分页 -->
					<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
					<div id="pagebar" class="pagin"></div>
					<!-- 分页 -->
				</div>
			</div>
		</div>
	</body>
</html>
