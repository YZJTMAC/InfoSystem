<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
response.setHeader("Pragma","No-cache"); 
response.setHeader("Cache-Control","no-cache"); 
response.setDateHeader("Expires", 0); 
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>老师的培训总结</title>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/jquery.url.js"></script>
<script type=text/javascript src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherProSummaryList.js"></script>
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
		
					<li>培训项目总结</li>
		            <li>查看教师培训总结</li>
				</ul>
		</div>

		<div class="formbody" style="width: 98%">
		<div class="tabson">
		        <ul class="seachform">
		        <li>
		<label>学校：</label> <div class="vocation">   <input id="school" style="width: 100px;" name="input" type="text" class="scinput" value="${school}" /></div></li>
		        <li>
		            <label>身份证：</label>
		            <input style="width: 160px;" id="sno" name="input" type="text" name="sno" value="${sno}" class="scinput" />
		          </li>
		         <li>
		            <label>姓名：</label>
		            <input style="width: 80px;" id="name" name="input" type="text" name="name" value="${name}" class="scinput" />
		          </li>
					
					<li><a href="javascript:void(0)" id="searchButton" class="dian3">查 询</a></li>
		           <li><a href="javascript:history.go(-1);" class="dian3">返 回</a></li>
		           
		        </ul>
			   
		      </div>
		
		<table class="tablelist">
						<thead>
							<tr>
								<th width="10%"  >教师姓名</th>
								<th width="15%"  >身份证号</th>
							 	<th width="20%"  >所在学校</th>
								<th width="20%"  >培训总结</th>
							</tr>
						</thead>
		                
						<tbody id="teacherProSummaryList">
		<!-- 					<c:forEach items="${pageObject.objects}" var="obj"> -->
		<!-- 						<tr> -->
		<!-- 							<td>${obj.name}</td> -->
		<!-- 							<td>${obj.sno}</td> -->
		<!-- 							<td>${obj.school}</td> -->
		<!-- 							<td><a href="#" onclick="viewSummary(${obj.summaryId})" class="tablelink click">查看</a>&nbsp;&nbsp;</td> -->
		<!-- 						</tr> -->
		<!-- 					</c:forEach> -->
					</tbody>
					</table>
					
					
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin">	</div>
		
			
			<!-- 培训总结上传模态框 -->	
			<div id="myModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
			  <div class="modal-header">
			    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			    <h3>${project.projectName}</h3><label>老师的培训总结</label>
			  </div>
			  <div class="modal-body">
			   	<table id="viewTable"  class="table table-hover table-condensed"></table>
			  </div>
			  <div class="modal-footer">
			   <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			  </div>
			</div>
			<!-- 培训总结上传模态框结束 -->
		</div>
</div>
<iframe id="downIframe" src="" frameborder=0 scrolling=no marginheight=0 marginwidth=0 height=60 width="100%"></iframe>
</body>
</html>
