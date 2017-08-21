<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="../common/commonHead.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>参训教师管理</title>
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
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/organization/orgProjectTeachers.js"></script>
	</head>
	<body>
		<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp">
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
					<li>
						<a href="#">参训教师管理</a>
					</li>
					<li>
						<a href="#">教师管理</a>
					</li>
				</ul>
			</div>
			<div class="formbody">
				<div class="tabson">
					<ul class="seachform">
						<li>
							<label >项目名称：${projectName}</label>
						</li>
					</ul>
					<ul class="seachform">
						<li>
							<label>地 区：</label>
						</li>
						<li>
							<div class="vocation">
		   						<input name="input2" type="text" class="scinput areaSelect" id="schoolName" readonly="readonly"/>
		   						<input id="selectSchoolId" type="hidden"/>
          						<input name="input2" type="button" value="选 择" class="btnXuan areaSelect" />
							</div>
						</li>
						<%--
						<li>
							<select id="provinceId" name="select" class="select2">
								<option value="">请选择省</option>
							</select>
						</li>
						<li>
							<select id="cityId" name="select" class="select2">
								<option value=''>请选择市</option>
							</select>
						</li>
						<li>
							<select id="districtId" name="select" class="select2">
								<option value="">请选择区/县</option>
							</select>
						</li>
						<li>
							<select id="schoolId" name="select" class="select2">
								<option value="">请选择学校</option>
							</select>
						</li>
						--%>
					</ul>
					<ul class="seachform">
						<li>
							<label>学 科：</label>
						</li>
						<li>
							<select id="subject" name="select" class="select2">
								<option value="">请选择学科</option>
							</select>
						</li>
					</ul>
					<ul class="seachform" style="padding-left: 85px;">
						<li>
							<a id="exportUrl">
								<input onclick="exportTeacher();" name="input2" type="button" class="dian3" value="导出" />
							</a>
						</li>
						<li>
							<input id="select" name="input2" type="button" class="dian3" value="查 询" />
						</li>
					</ul>
					<table class="tablelist">
						<thead>
							<tr>
								<th width="4%">教师编号</th>
					          	<th width="4%">姓名</th>
					          	<th width="5%">身份证号</th>
					          	<th width="3%">学科</th>
					          	<th width="6%">省</th>
					          	<th width="6%">市</th>
					          	<th width="6%">县</th>
					          	<th width="6%">校</th>
							  	<th width="6%">手机</th>
							</tr>
						</thead>
						<tbody id="orgProject_list">
						</tbody>
					</table>
					<!-- 分页 -->
					<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
					<div id="pagebar" class="pagin"></div>
					<!-- 分页 -->
				</div>
			</div>
		</div>
		<%@include file="../common/commonAreaSelectForSchool.jsp" %>
		<iframe id="downIframe"　src="" frameborder=0 scrolling=no vspace=0 hspace=0   marginheight=0 marginwidth=0 height=60 width="100%"></iframe>
	</body>
</html>
