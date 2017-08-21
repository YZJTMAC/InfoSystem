<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>能力提升数据统计</title>
<%@include file="../common/commonHead.jsp"%>
<%@include file="../common/commonAreaSelectAll.jsp" %>
<script type="text/javascript">
var id=${id};
</script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/commonValidate.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/system/fjimportMgr.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"> </script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>

</head>
<body>
<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp" >
			<jsp:param value="system" name="flag"/>
		</jsp:include>
	</div>
	<!-- left -->
	<div class="leftNav">
		<%@include file="../common/systemLeft.jsp"%>
	</div>
<div class="content">
<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="jixuMegGLY_2.2.html">系统管理</a></li>

			<li>能力提升数据统计</li>
			<li><label>&nbsp;</label>
    		</li>
		</ul>
	</div>
	<div class="formbody" style="overflow: hidden; padding-bottom: 20px;">
		<div class="formbodyL">
			<div class="tabson">
						<ul class="seachform" style="padding-left: 23px;">
							<li>
								<label>
									学校名称:
								</label>
								<div class="vocation">
									<input id="schoolName" name="input" value="" type="text" class="scinput" />
								</div>
							</li>
						
							<li>
								<label>
									所属地区:
								</label>
								<div class="vocation">
									<input name="input" id="tss" value="" type="text" onclick="clearPCD();" class="scinput areaSelect" style="width:260px;" />
									<input name="input2" type="button" value="选 择" class="btnXuan areaSelect" />
								</div>
							</li>

							<li>
								<label>
									&nbsp;
								</label>
								<input id="select" type="button" class="scbtn" value="查 询" />
							</li>
							</ul>
					</div>
			<table class="tablelist">
				<thead>
					<tr>
						<th>地市</th>
						<th>区县</th>
						<th>学校</th>
						<th>上报人数</th>
						<th>登录人数</th>
						<th>参训率(%)</th>
						<th>有效学习人数</th>
						<th>学习率(%)</th>
						<th>合格人数</th>
						<th>合格率(%)</th>
						<th>课程作业数</th>
						<th>工作坊数</th>
						<th>研修活动数</th>
						<th>研修活动参与数</th>
						<th>实践研修成果数</th>
						<th>项目简报数</th>
					</tr>
				</thead>
				<tbody id="areaList">
				</tbody>
			</table>

	<!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
	<!-- 分页 -->
	<input type="hidden" name="schoolProvinceId" id="schoolProvinceId" value=""/>
	<input type="hidden" name="schoolCityId" id="schoolCityId" value=""/>
	<input type="hidden" name="schoolDistrictId" id="schoolDistrictId" value=""/>
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