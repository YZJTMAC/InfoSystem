<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学分信息汇总</title>
<%@include file="../common/commonHead.jsp"%>
<%@include file="../common/commonAreaSelect.jsp" %>
<script type="text/javascript">
var id = '${id}';
var flag = '${flag}';
lastSelect = '${areaId}_${areaType}_${areaName}';
</script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/commonValidate.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/system/eduTeacherTraningScoreList.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"> </script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>

</head>
<body>
<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp" >
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
			<div class="tabson">
						<ul class="seachform" style="padding-left: 23px;">
							<li>
								<label>
									身份证号:
								</label>
								<div class="vocation">
									<input id="idNumber" name="input" value="" type="text" class="scinput" />
								</div>
							</li>
							<li>
								<label>
									学员姓名:
								</label>
								<div class="vocation">
									<input id="teacherName" name="input" value="" type="text" class="scinput" />
								</div>
							</li>
							<li>
								<label>
									学校名称:
								</label>
								<div class="vocation">
									<input id="schoolName" name="input" value="" type="text" class="scinput" />
								</div>
							</li>
						</ul>
						<ul class="seachform" style="padding-left: 23px;">
							<li>
								<label>
									所属地区:
								</label>
								<div class="vocation">
									<input id="areaName" name="" readonly="readonly" type="text"  value="${areaName}" class="scinput areaSelect"/>
									<input type="hidden" id="areaId" />
									<input type="hidden" id="areaType" />
									<input name="input2" class="btnXuan areaSelect" type="button" value="选 择"/>
<!-- 									<input id="areaName" name="" readonly="readonly" type="text"  value="${areaName}" class="scinput areaSelect"/> -->
<!-- 									<input name="input" id="tss" value="" type="text" onclick="clearPCD();" class="scinput areaSelect" style="width:260px;" /> -->
<!-- 									<input name="input2" type="button" value="选 择" class="btnXuan areaSelect" /> -->
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
					
			<div class="chauxnJS jsTool">
						<span style="float: left;">
							 <a href="javascript:void(0);" class="huibtn_a click" style="margin-left: 6px" id="btnAdd2" onclick="exportTeacherScore();">批量导出</a>
						</span>
						<!-- <span style="float: right;">
							<div class="pagin" style="margin: 0; width: 180px;">
								<div class="message">
									共 <i class="blue" id="counts">0</i>条记录
								</div>
								<div class="vocation paginList" style="margin: 4px 6px 0 6px; right: 0px;">
								</div>
							</div> 
						</span> -->
					</div>		
					
			<table class="tablelist">
				<thead>
					<tr>
						<th>
							<input id="chk_all" type="checkbox"/>
						</th>
						<th>学员姓名</th>
						<th>学校</th>
						<th>身份证号</th>
						<th>学段/学科</th>
						<!-- <th>培训学情</th> -->
						
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
				</tbody>
			</table>

	<!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
	<!-- 分页 -->
	
	<IFRAME id="downIframe" frameborder=0 scrolling=no vspace=0 hspace=0 marginheight=0 marginwidth=0 height=60 width="100%"></IFRAME>
	
	<input type="hidden" name="schoolProvinceId" id="schoolProvinceId" value=""/>
	<input type="hidden" name="schoolCityId" id="schoolCityId" value=""/>
	<input type="hidden" name="schoolDistrictId" id="schoolDistrictId" value=""/>
	<input type="hidden" name="schoolId" id="schoolId" value=""/>
	<input type="hidden" name="teacherIdNumber" id="teacherIdNumber" value=""/>
	<!-- 推优详情显示 -->
	<div class="tip0">
		<div class="tiptop"><span>提示信息</span></div>
				<div style="padding-left:15px;">推优建议：<textarea style="width: 310px;height: 35px; padding:5px; border: 1px solid #000; position: relative;top: 34px;" id="comment"></textarea></div>
			<div class="tipbtn">
				<input type="button" class="sure" onclick="pushTeacherScoreComment()" id="submit" value="保 存" />
					&nbsp;
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