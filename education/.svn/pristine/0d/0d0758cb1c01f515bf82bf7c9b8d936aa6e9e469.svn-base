<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>教师离退休导入</title>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/importAuditRecords.js"></script>
</head>
<body>
	<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp" >
			<jsp:param value="teacher" name="flag"/>
		</jsp:include>
	</div>
	<!-- left -->
	<div class="leftNav">
		<%@include file="../common/teacherLeft.jsp"%>
	</div>
	
	<div class="content">
		<div class="place">
		    <span>位置：</span>
		    <ul class="placeul">
		    <li>教师信息</li>
		    <li>教师离退休管理</li>
		    <li>教师离退休导入</li>
		    </ul>
		</div>
	    
	    <div class="formbody">
		    <div id="usual1" class="usual">
				<div class="itab">
					<ul>
						<li>
							<a href="<%=basePathHeader %>/teacher/teachermanage/toRetireesAddPage.htm?click=4"  >发起离退休</a>
						</li>
						<li>
							<a href="<%=basePathHeader %>/teacher/teachermanage/teacherRetireesPage.htm?click=4">已发起离退休</a>
						</li>
						<li>
							<a href="###" class="selected">教师离退休导入</a>
						</li>
					</ul>
				</div>
				<ul>
		    		<li><label>&nbsp;</label><input type="button" class="scbtn" value="批量导入" onclick="window.location='<%=basePathHeader%>/teacher/teachermanage/toImportRetireesTeacherPage.htm?click=4'"/></li>
				</ul>
		
		   		<div class="chauxnJS jsTool" style="display: none"><span style="float:left;"></span><span style="float:right;"></span></div>
		
			    <table class="tablelist">
			    	<thead>
			    	<tr>
			        <th width="7%">年度</th>
			        <th width="10%">操作时间</th>
			        <th width="10%">操作人</th>
			        <th width="15%">操作人所在地区</th>
			        <th width="5%">导入记录数</th>
			        <th width="7%">操作</th>
			        </tr>
			        </thead>
			        <tbody id="records">
			        </tbody>
			    </table>
		      	<!-- 分页 -->
					<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
					<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
					<div id="pagebar" class="pagin"></div>
				<!-- 分页 -->
			</div>  
		</div> 
	</div>
</body>
</html>