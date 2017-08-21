<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>教师成绩查询</title>

<%@include file="../common/commonHead.jsp"%>
<link />
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script> 
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/scoreQuery.js"></script>
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
		    	<li><a href="#">继教信息</a></li>
		    	<li><a href="#">成绩查询</a></li>
		    </ul>
    	</div>
    	<div class="formbody">
      		<div class="tabson">
				<ul class="seachform">
		         	<li>
		            	<label>项目年度：</label>
		          	</li>
          			<li>
          	 			<select name="select" class="select2 yearpicker" id="queryYear" width="100px;">
          				</select>  
          			</li>
			 		<li>
	            		<input name="input2" type="button" class="dian3" value="查 询" onclick="queryRemainQuery();"/>
	          		</li>
         		</ul>
         		<ul class="seachform" >
	         			<font color="red">
		         			<div id = "creditRule">
		         			
		         			</div>
	         			</font>
         		</ul>
         		<ul class="seachform" >
	         			<font color="red">
		         			<div id = "creditMap">
		         			
		         			</div>
	         			</font>
         		</ul>
      		</div>
      		<div class="chauxnJS jsTool">
			</div>		
			<table class="tablelist" >
				<thead>
	          		<tr>
			            <th width="40%">项目名称</th>
			            <th width="20%">项目类型</th>
			            <th width="40%">学分</th>
	          		</tr>
	        	</thead>
	        	<tbody id="queryList">
	         		<!-- 显示数据 -->
	        	</tbody>
	      	</table>
	    </div> 
	</div>
</body>
</html>
