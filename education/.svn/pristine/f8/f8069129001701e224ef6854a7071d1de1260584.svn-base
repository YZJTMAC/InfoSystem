<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>专家评分详情</title>
<%@include file="../common/commonHead.jsp"%>
<%@include file="../common/commonAreaSelect.jsp" %>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/master/judgeDetail.js"></script>
<script type="text/javascript">
var comparisonId = ${comparisonId};
var masterId = ${masterId};
</script>
</head>
<body>
	<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="comparison" name="flag" />
			</jsp:include>
		</div>
		<!-- left -->
		<div class="leftNav">
			<%@include file="../common/comparisonLeft.jsp"%>
		</div>
		<div class="content">
			<div class="place">
				<span>位置：</span>
				<ul class="placeul">
					<li>评比活动</li>
					<li>评比活动</li>
					<li>专家</li>
					<li>评分详情</li>
				</ul>
			</div>
	    <div class="formbody">
			<div class="tabson">
				<div class="chauxnJS jsTool">
					<span style="float: left;margin-left: 20px">
						<a href="javascript:window.history.back();" >返回</a> 
					</span>
				</div>	
				
	    		<table class="tablelist" >
	      			<thead>
	       			    <tr>
					        <th width="8%">头像</th>
					        <th width="8%">姓名</th>
					        <th width="15%">身份证号</th>
					        <th width="10%">学段</th>
					        <th width="10%">学科</th>
					        <th width="15%">学校</th>
							<th width="8%">评分</th>
							<th width="26%">评审意见</th>
	        			</tr>
	      			</thead>
	      			<tbody id="proList1">
			
	     			 </tbody>
	    		</table>
	    	</div> 
	 	</div>
	 	<!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
		<!-- 分页 -->
	</div> 
	<!-- 查看附件 -->	
	<div id="myModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
  		<div class="modal-header">
    		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    		<h3 id="projectName2"></h3><label>附件</label>
  		</div>
  		<div class="modal-body">
    		<form id="declareForm" enctype="multipart/form-data" method="post">
			<input id="projectId" name="projectId" type="hidden" value="" />
				<input id="projectName3" name="projectName" type="hidden" value="" />
				<input id="type" name="type" type="hidden" value="declareTemplate" />
				<table id="hasUpload" class="table table-hover table-condensed"></table>
				<table id="noUpload" class="table"></table>
			</form>
 		</div>
 		<div class="modal-footer">
		    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
  		</div>
	</div>
</body>
</html>