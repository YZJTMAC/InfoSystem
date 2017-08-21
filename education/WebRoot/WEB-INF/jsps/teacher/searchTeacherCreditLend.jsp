<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看教师学分借贷情况</title>

<%@include file="../common/commonHead.jsp"%>
<link />
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script> 
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/searchTeacherCreditLend.js"></script>
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
		    	<li><a href="#">学分银行</a></li>
		    	<li><a href="#">教师学分借贷情况</a></li>
		    </ul>
    	</div>
    	<div class="formbody">
      		<div class="tabson">
				<ul class="seachform">
		         	<li>
		            	<label>借贷年度：</label>
		          	</li>
          			<li>
          	 			<select name="select" class="select3 yearpicker" id="lendYear" >
          	 				<option value="">请选择</option>
          				</select>  
          			</li>
			 		<li>
	            		<input name="input2" type="button" class="dian3" value="查 询" onclick="queryList();"/>
	          		</li>
         		</ul>
      		</div>
	      	<div class="chauxnJS jsTool">
				<span style="float: left;margin-left: 20px">
<!-- 					<a onclick="creditLendAdd()">学分借贷</a>  -->
				</span>
			</div>
			<table class="tablelist" >
				<thead>
	          		<tr>
			            <th width="10%">教师姓名</th>
			            <th width="20%">身份证号</th>
			            <th width="10%">培训方式</th>
			            <th width="20%">借贷日期</th>
			            <th width="10%">借贷原因</th>
			            <th width="10%">借贷学分</th>
			            <th width="10%">借贷学时</th>
			            <th width="10%">借贷状态</th>
	          		</tr>
	        	</thead>
	        	<tbody id="queryList">
	         		<!-- 显示数据 -->
	        	</tbody>
	      	</table>
	    </div> 
	</div>
    
    <!-- 审核意见对话框开始-->	
	<div id="auditReasonModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
		<div class="modal-header">
	    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    	<h3 id="projectName9">审核意见</h3>
	  	</div>
	  	<div class="modal-body">
			<div id="reason"></div>
	  	</div>
	  	<div class="modal-footer">
	 		<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	  	</div>
	</div>
</body>
</html>
