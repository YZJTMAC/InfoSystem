<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<%@include file="../common/commonHead.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>教师成绩</title>
	<script type="text/javascript" src="<%=basePathHeader%>/javascript/editor/kindeditor.js"></script>
	<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		KE.show( {
			id : 'content7',
			cssPath : './index.css'
		});
	</script>

	<script type="text/javascript">
		$(document).ready(function(e) {
			$(".select1").uedSelect( {
				width : 345
			});
			$(".select2").uedSelect( {
				width : 167
			});
			$(".select3").uedSelect( {
				width : 100
			});
		});
	</script>
	<script type="text/javascript">
		var projectId = '<%=request.getParameter("projectId")%>';
	</script>
	<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
	<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/location.js"></script>
	<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherProScoreInfo.js"></script>
</head>
<body>
	<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp">
		<jsp:param value="teacher" name="flag"/>
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
				<li>
					<a href="#">教师成绩查询</a>
				</li>
				<li>
					<a href="#">教师成绩</a>
				</li>
			</ul>
		</div>
		<div class="formbody">
			<div class="tabson">
				 <ul class="forminfo">
					 <li>
        				<p class="xmTool">培训项目：<b id="projectName"></b></p>
      				</li>
					<li>
        				<label>教师姓名：</label>
        				<div class="vocation">
              				<input id="teacherName" name="input" type="text" class="dfinput" style="width:200px;margin-right:20px;"/>
            			</div>
						<label>身份证号：</label>
						<div class="vocation">
							<input id="idNumber" name="input" type="text" class="dfinput" style="width:200px;margin-right:20px;"/>
						</div>
						<label style="width:50px;">学 科：</label>
        				<div class="vocation" style="margin-right:20px;">
          					<select id="subject" name="select" class="select3">
          						<option value="">请选择学科</option>
          					</select>
        				</div>
      				</li>
      				<li>
        				<label>地 区：</label>
        				<div class="vocation" style="margin-right:20px;">
	   						<input name="input2" type="text" class="scinput areaSelect" id="schoolName" readonly="readonly"/>
	   						<input id="selectSchoolId" type="hidden"/>
         					<input name="input2" type="button" value="选 择" class="btnXuan areaSelect" />
						</div>
        				<%--<div id="provinceId" class="vocation" style="margin-right:20px;">
        					<select class="select3">
        						<option value="">请选择省</option>
        					</select>
        				</div>
       					<div id="cityId" class="vocation" style="margin-right:20px;">
       						<select class="select3">
       							<option value=''>请选择市</option>
       						</select>
       					</div>
       					<div id="districtId" class="vocation" style="margin-right:20px;">
       						<select class="select3">
       							<option value="">请选择区/县</option>
       						</select>
       					</div>
       					<div id="schoolId" class="vocation" style="margin-right:20px;">
       						<select class="select3">
       							<option value="">请选择学校</option>
       						</select>
       					</div>
       					--%>
       					<input id="select" name="input3" type="button" class="dian3" value="查 询"/>
     				 </li>
      			</ul>
			</div>
			<table class="tablelist">
				<thead>
					<tr>
						<th width="4%">姓名</th>
				        <th width="10%">身份证号</th>
				        <th width="6%">学科</th>
				        <th width="6%">省</th>
				        <th width="6%">市</th>
				        <th width="6%">县</th>
				        <th width="6%">校</th>
				        <th width="10%">成绩</th>
					</tr>
				</thead>
				<tbody id="proTeacher_list">
				</tbody>
			</table>
			<!-- 分页 -->
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
			<!-- 分页 -->
		</div>
	</div>
	<%@include file="../common/commonAreaSelectForSchool.jsp" %>
</body>
</html>
