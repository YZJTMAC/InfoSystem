<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>成绩审核</title>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/projectValidate.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/proListShenHe.js"></script>
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
			    <li><a href="#">培训项目</a></li>
			    <li><a href="#">培训成绩审核</a></li>
		    </ul>
	    </div>
	    
	    <div class="formbody">
	    	<div class="tabson">
		     	<ul class="seachform">
		  			<li>
			            <label>项目名称：</label>
			            <input name="input" type="text" class="scinput" id="projectName"/>
		          	</li>
		    		<li>
		            	<label>项目年度：</label>
		             	<div class="vocation"><select  class="select3 yearpicker" name="yearpicker" id="beginDate">
		             		<option value="">请选择</option>
		             	</select> -- 
					 	</div>
		          	</li>
				  	<li>--</li>
				   	<li>
		            	<div class="vocation">   <select  class="select3 yearpicker" name="yearpicker" id="endDate">
		             		<option value="">请选择</option>
		             	</select>  
					 	</div> 
		          	</li>
		  			<li>
			        	<a href="javascript:qryPro()" class="dian3" >查 询</a>
			        </li>
		        </ul>
	      	</div>
	      
	      	<table class="tablelist">
		    	<thead>
			        <tr>
			          <th width="30%">项目名称</th>
			          <th >开始时间</th>
			          <th >结束时间</th>
			          <th >创建人</th>
			          <th >实施机构</th>
			          <th >申报人</th>
			          <th >计划人数</th>
			          <th >已审核人数</th>
			          <th >未审核人数</th>
			          <th >操作</th>
			        </tr>
		      	</thead>
				<tbody id="proList">
				</tbody>
	    	</table>
	
			<!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
			<!-- 分页 -->
	    </div>
	</div>
</body>
</html>