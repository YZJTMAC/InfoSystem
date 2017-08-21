<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>专家库</title>
<%@include file="../common/commonHead.jsp"%>
<%@include file="../common/commonAreaSelectAll.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/master/masterDatabase.js"></script>
<script type="text/javascript">
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
					<li>专家库</li>
				</ul>
		</div>
		<div class="formbody">
		<div class="tabson">
		       	<ul class="seachform">
		       		<li>
						<label>
							专家名：
						</label>
						<div class="vocation" >
		        			<input type="text" id="masterNameQuery" class="scinput" />
						</div>
					</li>
					<li>
						<label>
							用户名：
						</label>
						<div class="vocation" >
		        			<input type="text" id="loginAccountQuery" class="scinput" />
						</div>
					</li>
					<li><a href="javascript:queryList();" class="dian3">查 询</a></li>
				</ul>
	      	</div>
			<div class="formbodyL"
				style="overflow: hidden; padding-bottom: 20px;">
				<div class="chauxnJS jsTool">
						<span style="float: left;"> 
						<a href="<%=basePathHeader %>/master/toManageComparison.htm" class="huibtn_a click" style="margin-left: 6px">返 回</a>
						<a class="huibtn_a click" style="margin-left: 6px" id="btnAdd" onclick="toCreateMaster()">添加专家</a>
						<a href ="<%=basePathHeader %>/master/toUploadMaster.htm?click=111" class="huibtn_a click" style="margin-left: 6px" >批量导入</a>
						</span>
					</div>
				<table class="tablelist">
					<thead>
						<tr id="edu_header">
							<th width="12%">头像</th>
							<th width="8%">名称</th>
							<th width="8%">用户名</th>
							<th width="8%">密码</th>
							<th width="36%">评比活动</th>
							<th width="20%">操作</th>
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
	
	<!-- 为专家设置活动 -->
	<div class="tip" id="setTip" style=" z-index: 1;width: 480px;margin-left: 100px">
		<div class="tiptop">
			<span>选择活动</span><a href="javascript:hideMe();"></a>
		</div>
		<div class="tabson" >
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
			<input name="" type="button" class="sure" value="保存" onclick="saveComparisonToMaster();" />&nbsp; 
			<input name="" type="button" class="cancel" value="取消" onclick="hideMe();" />
		</div>
	</div>
	
	<!-- 添加专家（逐个） -->
	<div class="tip2" style="height: 450px;" id="masterTip">
		<div class="tiptop">
			<span>添加专家</span><a href="javascript:hideMe();"></a>
		</div>
		<div class="tipinfo">
			<ul style="width:40%;text-align: left;margin-left: 30%">
				<li >
						<img id="photoTemp" style="height: 99px; width:71px; display: "  src="<%=basePathHeader%>/static/photo/teacher_default.png" title="头像" />
						<input id="photoFile" type="file" name="photoFile" onchange="uploadPhotoFile()" style="display: block;" />	
						<input type="hidden" id="imageSrcTemp"/>
				</li>
			</ul>
			<ul style="width:100%;text-align: left;margin-left: 5%;margin-top: 10px">
				<li >
						专家姓名:<input name="input" type="text" class="scinput" id="masterName" />
						<a id="masterNameError" style="color: red"></a>
				</li>
			</ul>
			<ul style="width:100%;text-align: left;margin-left: 5%;margin-top: 10px" >
				<li >
						用户名&nbsp;&nbsp;&nbsp;:<input name="input" type="text" class="scinput"  id="loginAccount" />
						<a id="loginAccountError" style="color: red"></a>
				</li>
			</ul>
			<ul style="width:100%;text-align: left;margin-left: 5%;margin-top: 10px" >
				<li >
						专家密码:<input name="input" type="text" class="scinput"  id="password" />
						<a id="passwordError" style="color: red"></a>
				</li>
			</ul>
			<ul class="seachform" style="padding-bottom: 10px; height: 100%; margin-top: 10px; margin-left: 0%">
					<li>
						<a href="javascript:saveMaster()" class="dian3" id="saveBtn">保 存</a>
					</li>
					<li>
						<a href="javascript:updateMaster()" class="dian3" id="updateBtn" style="display: none;">修 改</a>
					</li>
					<li>
						<a href="javascript:hideMe()" class="dian3">取 消</a>
					</li>
				</ul>
		</div>
	</div>
</body>
</html>
