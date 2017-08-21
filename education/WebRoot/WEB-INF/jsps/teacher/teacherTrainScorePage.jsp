<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教师培训学分汇总</title>
<%@include file="../common/commonHead.jsp"%>
<%@include file="../common/commonAreaSelectAll.jsp" %>
<script type="text/javascript">
var flag = '${flag}';
</script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/commonValidate.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherTrainScorePage.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>

</head>
<body>
	<!-- top -->
	<div class="head">
	<jsp:include page="../common/top.jsp">
		<jsp:param value="furtheredu" name="flag"/>
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
			<li><a href="jixuMegGLY_2.2.html">继教信息管理</a></li>
			<li>学分信息汇总</li>
			<li><label>&nbsp;</label>
    		</li>
		</ul>
	</div>
	<div class="formbody" style="overflow: hidden; padding-bottom: 20px;">
		<div class="formbodyL">
					
			<div class="chauxnJS jsTool">
			</div>		
					
			<table class="tablelist">
				<thead>
					<tr>
						<th>学员姓名</th>
						<th>学校</th>
						<th>身份证号</th>
						<th>学段/学科</th>
						
						<th>工作坊数</th>
						<th>课程作业数</th>
						<th>研修活动数</th>
						<th>研修活动参与数</th>
						<th>实践研修成果数</th>
						<th>项目简报数</th>
						
						<th>总学分</th>
						<th>推优</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="dataList">
					<c:if test="${eduTeacherSocre != null}">
					<td>${eduTeacherSocre.teacherName }</td>
					<td>${eduTeacherSocre.schoolName }</td>
					<td>${eduTeacherSocre.idNumber }</td>
					<td>${eduTeacherSocre.teacherSection } ${eduTeacherSocre.teacherSubject }</td>
					<td>${eduTeacherSocre.workShopNum }</td>
					<td>${eduTeacherSocre.courseWorkNum }</td>
					<td>${eduTeacherSocre.trainActivitNum }</td>
					<td>${eduTeacherSocre.trainActivitJoinNum }</td>
					<td>${eduTeacherSocre.practiceActivitNum }</td>
					<td>${eduTeacherSocre.projectReportNum }</td>
					<td>${eduTeacherSocre.totalScore }</td>
					<td>
					<a href="javascript:void(0);" onclick="showPushComment('${eduTeacherSocre.pushComment}');">${eduTeacherSocre.pushExcellent == '0' ? '未推优' : '已推优' }</a>
					</td>
					<td>
					<a href="javascript:void(0);" onclick="getTeacherScoreInfo(${eduTeacherSocre.teacherId});">查看培训信息</a>
					</td>
					</c:if>
				</tbody>
			</table>

	<!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
	<!-- 分页 -->
	
	<input type="hidden" name="teacherIdNumber" id="teacherIdNumber" value=""/>
	<!-- 推优详情显示 -->
	<div class="tip0">
		<div class="tiptop"><span>推优建议</span></div>
			<div id="comment" style="padding:35px;"></div>
			<div class="tipbtn">
				<input type="button" class="cancel" onclick="cancel();" value="取 消" />
			</div>
		</div>
		
			<div class="tip"
			style="width: 400px; height: 150px; top: 40%; left: 35%">
			<div class="tiptop">
				<span>提示信息</span>
			</div>
			<table style="width: 100%; height: 100%">
				<tr>
					<td align="center">
						<span id="msgHtml"></span>
					</td>
				</tr>
				<tr>
					<td align="center" valign="top" style="height: 60%">
						<input name="" id="toPage" type="button" class="sure" value="确定" />
						<input name="" id="cancel" type="button" class="cancel" value="取消" />
						
					</td>
				</tr>
			</table>
		</div>

		</div>
	</div>
</div>
</body>
</html>