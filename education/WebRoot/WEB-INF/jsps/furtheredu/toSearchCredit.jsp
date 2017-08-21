<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学分查询</title>
<%@include file="../common/commonHead.jsp"%>
<%@include file="../common/commonAreaSelect.jsp" %>
<script type="text/javascript">
var id = '${id}';
var flag = '${flag}';
lastSelect = '${areaId}_${areaType}_${areaName}';

$(document).ready(function(e) {
	$(".select2").uedSelect({
		width : 167 
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/commonValidate.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/toSearchCredit.js"></script>

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
			<li>继教信息</li>
			<li>继教信息</li>
			<li>学分查询</li>
		</ul>
	</div>
	<div class="formbody" style="overflow: hidden; padding-bottom: 20px;">
		<div class="formbodyL">
			<div class="tabson">
				<ul class="seachform">
          			<li>
						<label>
							查询年度:&nbsp;
						</label>
						<div class="vocation">
							<select name="select" class="select2 yearpicker" id="queryYear" ></select>
						</div>
					</li>
          			<li>
						<label>
							身份证号:
						</label>
						<div class="vocation">
							<input id="idNumber" name="input" value="" type="text" class="scinput" />
						</div>
					</li>
         		</ul>
				<ul class="seachform" style="padding-left: 23px;">
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
							学校地区:
						</label>
						<div class="vocation">
							<input id="areaName" name="" readonly="readonly" type="text"  value="${areaName}" class="scinput areaSelect"/>
							<input type="hidden" id="areaId" value="${areaId}"/>
							<input type="hidden" id="areaType" value="${areaType}"/>
							<input name="input2" class="btnXuan areaSelect" type="button" value="选 择"/>
						</div>
					</li>
				</ul>
				<ul class="seachform" style="padding-left: 23px;">
					<li></li>
					<li>
						<label>
							&nbsp;
						</label>
						<input id="select" type="button" class="scbtn" value="查 询" onclick="search()" />
					</li>
				</ul>
			</div>
			<div class="chauxnJS jsTool">
				<span style="float: left;">
					 <a href="javascript:void(0);" class="huibtn_a click" style="margin-left: 6px" id="btnAdd2" onclick="exportExl();">批量导出</a>
				</span>
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
						<th>去年结余</th>
						<th>总学分(培训)</th>
<!-- 						<th>操作</th> -->
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
	
	<input type="hidden" name="checkedId" id="checkedId" value=""/>
		
		</div>
	</div>
	
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    	<div style="width: 280px;height:20px; z-index: 20000; position: absolute; text-align: center; left: 50%; top: 50%;margin-left:-100px;margin-top:160px">
			<div class="progress progress-striped active" style="margin-bottom: 0;">
				<span style="font-size:22px;">导出中，请稍后. . .</span>
			</div>
		</div>
	 </div> 
</div>
</body>
</html>