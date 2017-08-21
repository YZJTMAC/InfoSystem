<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员管理</title>
<%@include file="../common/commonHead.jsp"%>
<%@include file="../common/commonAreaSelectAll.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/person/toManagesPage.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
		xianshi('${sessionScope.userinfo.roleId}');
		$(".select2").uedSelect({
			width : 127
		});
		$(".select3").uedSelect({
			width : 120
		});
	});
</script>
<style type="text/css">
.cancel {
	background: url(../images/btnbg2.png) repeat-x;
	color: #000;
	font-weight: normal;
}
</style>
</head>

<body>
	<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp">
			<jsp:param value="system" name="flag" />
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
				<li><a href="#">系统管理</a></li>
				<li><a href="#">管理员管理</a></li>
			</ul>
		</div>
		<div class="formbody">
			<div class="formbodyL"
				style="overflow: hidden; padding-bottom: 20px;">
				<div class="tabson">
					<ul class="seachform" style="padding-left: 23px;">
						
						<li><label> 角色类型: </label>
							<div class="vocation">
								<select id="roleTypeId" name="select" class="select2">
								</select>
							</div></li>
						<li><label> 角色名称: </label>
							<div class="vocation">
								<select id="roleId" name="select" class="select2">
								</select>
							</div></li>
						<li><label> 用户名: </label>
							<div class="vocation">
								<input id="loginAccount" name="input" value="" type="text"
									class="scinput" />
							</div></li>
						<li><label> 学校名称: </label>
							<div class="vocation">
								<input id="schoolName" name="school" value="" type="text"
									class="scinput" />
							</div></li>
					</ul>
					<ul class="seachform" style="padding-left: 23px;">
						<li><label> 所属地区: </label>
							<div class="vocation">
								<input name="input" id="tss" onclick="clearPCD();" value=""
									type="text" style="width: 260px;" class="scinput areaSelect" />
								<input name="input2" type="button" value="选 择"
									class="btnXuan areaSelect" />
							</div></li>
						<li><label> &nbsp; </label> <input id="select" type="button"
							class="scbtn" value="查 询" /></li>

					</ul>


				</div>

				<div class="chauxnJS jsTool">
					<span style="float: left;" id="action"> </span> <span
						style="float: right;">
						<div class="pagin" style="margin: 0; width: 180px;">
							<div class="message">
								共 <i class="blue" id="counts">0</i>条记录
							</div>
							<div class="vocation paginList"
								style="margin: 4px 6px 0 6px; right: 0px;">
								<select onchange="showManagesList();" id="sizePerPage"
									class="select3">
									<option value="100">每页显示100条</option>
									<option value="300">每页显示300条</option>
									<option value="500">每页显示500条</option>
								</select>
							</div>

						</div> </span>
				</div>
				<table class="tablelist">
					<thead>
						<tr id="edu_header">
							<th><input id="allCheck" type="checkbox" /></th>
							<th>姓名</th>
							<th>用户名</th>
							<th>密码</th>
							<th>角色名称</th>
							<th>角色类型</th>
							<th>地区</th>
							<th>学校</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>

					<tbody id="proTeacher_list">

					</tbody>
				</table>

				<!-- 分页 -->
				<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
				<div id="pagebar" class="pagin"></div>
				<!-- 分页 -->
				<input type="hidden" name="schoolProvinceId" id="schoolProvinceId"
					value="" /> <input type="hidden" name="schoolCityId"
					id="schoolCityId" value="" /> <input type="hidden"
					name="schoolDistrictId" id="schoolDistrictId" value="" />
			</div>
		</div>
	</div>

					<div class="tip0">
							<div class="tiptop2">
								<span>批量修改用户角色</span>
							</div>
							<div class="tipinfo" style="padding: 10px; margin: 20;align:center">
								<ul class="forminfo forminfo1" style="padding: 60; margin: 0;">

									<li>
										<label>
											<b style="color: red">*</b>选择用户角色名称 : 
										</label>
										<div class="vocation" style="padding-right: 80px;">
											<select id="batRoleId" onchange="selectRole();" name="select" class="select2">
											</select>
										</div>
									</li>
									<li><a style="color: red;" id="selectedError"></a></li>
								</ul>
							</div>
							
							<div class="tipbtn">
								<input name="" type="button" id="modifyRole" class="sure" value="提交" />
								&nbsp;
								<input name="" type="button" id="modifyCancel" class="cancel" value="取消" />
							</div>
						</div>




	<div class="tip"
		style="width: 400px; height: 150px; top: 40%; left: 35%">
		<div class="tiptop">
			<span>提示信息</span>
		</div>
		<table style="width: 100%; height: 100%">
			<tr>
				<td align="center"><span id="msgHtml"></span></td>
			</tr>
			<tr>
				<td align="center" valign="top" style="height: 60%"><input
					name="" id="toPage" type="button" class="sure" value="确定" /> <input
					name="" id="cancel" type="button" class="cancel" value="取消" /></td>
			</tr>
		</table>
	</div>

	<IFRAME id="downIframe" 　src="" frameborder=0 scrolling=no vspace=0
		hspace=0 marginheight=0 marginwidth=0 height=60 width="100%"></IFRAME>
</body>
</html>
