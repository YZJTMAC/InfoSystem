<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>专家管理</title>
<%@include file="../common/commonHead.jsp"%>
<%@include file="../common/commonAreaSelectAll.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/master/manageMaster.js"></script>
<script type="text/javascript">
var comparisonId= ${comparisonId};
</script>
</head>

<body>
	<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="comparison" name="flag" />
			</jsp:include>
		</div>
		<!-- left -->
		<div class="leftNav">
			<%@include file="../common/comparisonLeft.jsp"%>
		</div>
		<div class="content">
			<div class="place">
				<span>位置：</span>
				<ul class="placeul">
					<li>评比活动</li>
					<li>评比活动</li>
					<li>专家</li>
				</ul>
			</div>
		<div class="formbody">
			<div class="formbodyL"
				style="overflow: hidden; padding-bottom: 20px;">
				<div class="chauxnJS jsTool">
						<span style="float: left;"> 
						<a style="margin-left: 6px" href="<%=basePathHeader %>/master/toManageComparison.htm">返 回</a> 
<!-- 						<a class="huibtn_a click" style="margin-left: 6px" id="btnAdd" onclick="toCreateMaster()">创建专家</a> -->
							<a class="huibtn_a click" style="margin-left: 6px" id="btnAdd" onclick="toSetMaster()">设置专家</a> 
						</span>
					</div>
				<table class="tablelist">
					<thead>
						<tr id="edu_header">
							<th>名称</th>
							<th>用户名</th>
							<th>密码</th>
							<th>评比活动</th>
							<th>操作</th>
						</tr>
					</thead>

					<tbody id="queryList">

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
	<!-- 创建专家账号 -->
	<div class="tip">
		<div class="tiptop">
			<span>创建专家</span><a href="javascript:hideMe();"></a>
		</div>

		<div class="tipinfo" style="height:100px;">
			<ul class="forminfo" style="padding:0; margin:0;">
				<li id="periodRule">
					<div class="vocation">
						专家数目：<input name="input" type="text" class="scinput"  id="masterNum" />
					</div>
				</li>
			</ul>
		</div>

		<div class="tipbtn">
			<input name="" type="button" class="sure" value="创建" onclick="createMaster();" />&nbsp; 
			<input name="" type="button" class="cancel" value="取消" onclick="hideMe();" />
		</div>
	</div>
	<!-- 为活动设置专家 -->
	<div class="tip2" id="setTip" style=" z-index: 1;width: 480px;margin-left: 100px">
		<div class="tiptop">
			<span>选择专家</span><a href="javascript:hideMe();"></a>
		</div>
		<div class="tabson" style="margin-left: 15%">
			<ul class="forminfo" style="padding:0; margin:0;">
				<li id="periodRule">
					<div class="vocation">
						<table  style="width: 100%;margin-top: 10px;" cellpadding="0" cellspacing="0">
	      					<tbody id="subject">
	      						<div id="showCheck" ></div>
	      					</tbody>
	      				</table>
					</div>
				</li>
			</ul>
		</div>
		<div class="tipbtn">
			<input name="" type="button" class="sure" value="保存" onclick="saveMasterToComparison();" />&nbsp; 
			<input name="" type="button" class="cancel" value="取消" onclick="hideMe();" />
		</div>
	</div>
</body>
</html>
