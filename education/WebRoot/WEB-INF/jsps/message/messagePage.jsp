<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>个人信息</title>
		<%@include file="../common/commonHead.jsp"%>

		<script type="text/javascript" src="<%=basePathHeader%>/javascript/message/messagePage.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>

		<script type="text/javascript">
$(document).ready(function(e) {
	$(".select1").uedSelect( {
		width : 240
	});
	
	$(".select3").uedSelect( {
		width : 100
	});
	$("#paswdQuestionType").val(${personInfo.paswdQuestionType});
	$(".select2").uedSelect( {
		width : 167
	});
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
	$(".click").click(function() {
		$("input[type='text']").attr("value","");
		$("#content").attr("value","");
		$(".tip").fadeIn(200);
	});

	$(".tiptop a").click(function() {
		$(".tip").fadeOut(200);
	});

	$(".sure").click(function() {
	});

	$(".cancel").click(function() {
		$(".tip").fadeOut(100);
	});

});
</script>
	</head>

	<body>
		<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="person" name="flag" />
			</jsp:include>
		</div>
		<!-- left -->
		<div class="leftNav">
			<%@include file="../common/personLeft.jsp"%>
		</div>

		<div class="content">
			<div class="place">
				<span>位置：</span>
				<ul class="placeul">
					<li>
						<a href="#">个人中心</a>
					</li>
					<!-- <li>
						<a href="#">通知</a>
					</li> -->
					<li>
						<a href="#">短消息</a>
					</li>

				</ul>
			</div>

			<div class="formbody">
				<div class="noticeTool"
					style="overflow: hidden; border-bottom: 1px solid #ccc; line-height: 32px; margin-bottom: 30px;">
					<dl>
						<dt style="float: left; padding-right: 12px;">
							<p>
								你有
								<b style="margin: 0 4px;" id="counts"></b>条未读消息
							</p>
						</dt>
						<dd style="float: left">
							<a href="#"
								style="background-color: #60C1E7; color: #fff; border-color: #2B89BF;"
								class="huibtn_a click">发短消息</a>
						</dd>
						<dd style="float: right">
							<a href="#" class="huibtn_a" onclick="deleteAllMessage()">全部删除</a>
						</dd>
					</dl>

				</div>
				<div class="itab">
						<ul>
							<li>
								<a onclick="change(1);" id="tab_1" href="#tab1" class="selected">省级消息
								</a>
							</li>
							<li>
								<a onclick="change(2);" id="tab_2" href="#tab2" class="">市级消息
								</a>
							</li>
							<li>
								<a onclick="change(3);" id="tab_3" href="#tab3" class="">区县消息
								</a>
							</li>
							<li>
								<a onclick="change(4);" id="tab_4" href="#tab4" class="">学校消息
								</a>
							</li>
						</ul>
					</div>
				<div class="textContent" id="textContent">

				</div>
			</div>
		</div>

 		<%@include file="../common/commonAreaSelect.jsp"%>  
		<div class="tip" style="height: 500px;z-index: 10;">
			<div class="tiptop">
				<span>发送消息</span><a></a>
			</div>

			<div class="tipinfo">
				<div class="tipright" style="padding: 0; margin: 0;"></div>
				<form id="messageForm" enctype="multipart/form-data" method="post">
				<table border="0" cellspacing="0" cellpadding="0"
					style="margin: 0 auto; line-height: 42px;">
					<tbody id="files">
					<tr>
						<td>
							发布范围：
						</td>
						<td>
							<input type="radio" name="sendType" id="dt" value="byName" checked="checked"/>用户名&nbsp;&nbsp;
							<input type="radio" name="sendType" id="st" value="byProject"/>项目&nbsp;&nbsp;
							<input type="radio" name="sendType" id="st" value="byArea"/>地区&nbsp;&nbsp;
							<input type="radio" name="sendType" id="yzn" value="byRole"/>角色&nbsp;&nbsp;
						</td>
					</tr>
					<tr id="byArea" class="sendType" style="display: none;">
						<td>
							地区：
						</td>
						<td>
							<input id="areaName"　name="" readonly="readonly" type="text"  value="${areaName}" class="scinput areaSelect"/>
							<input type="hidden" id="areaId" />
							<input type="hidden" id="areaIdName" />
							<input name="input2" class="btnXuan areaSelect" type="button" value="选 择"/>
							<a style="color: red" id="byAreaError"></a>
						</td>
					</tr>
					<tr id="byProject" class="sendType" style="display: none;">
						<td>
							项目：
						</td>
						<td>
							<select id="projectList" name="select" class="select1">
							</select>
							<a style="color: red" id="byProjectError"></a>
						</td>
					</tr>
					<tr id="byRole" class="sendType" style="display: none;">
						<td>
							角色：
						</td>
						<td>
							<select id="roleId" name="select" class="select2">
										<option value="-1">
											请选择...
										</option>
										 <c:choose> 
										   <c:when test="${sessionScope.userinfo.roleId eq 0}"> 
										    <option value="0"> 系统管理员 </option> 
										    <option value="1"> 省管理员 </option> 
										    <option value="2"> 市管理员 </option> 
										    <option value="3"> 区管理员 </option> 
										    <option value="4"> 校管理员 </option> 
										    <option value="5"> 教师 </option> 
										    <option value="6"> 承培机构管理员 </option> 
										    <option value="7"> 实施机构管理员（省） </option> 
										    <option value="8"> 实施机构管理员（市） </option> 
										    <option value="9"> 实施机构管理员（区） </option> 
										    <option value="10"> 实施机构管理员（校） </option> 
										   </c:when> 
										   <c:when test="${sessionScope.userinfo.roleId eq 1}"> 
										    <option value="2"> 市管理员 </option> 
										    <option value="3"> 区管理员 </option> 
										    <option value="4"> 校管理员 </option> 
										    <option value="5"> 教师 </option> 
										    <option value="7"> 实施机构管理员（省） </option> 
										     <option value="8"> 实施机构管理员（市） </option> 
										    <option value="9"> 实施机构管理员（区） </option> 
										    <option value="10"> 实施机构管理员（校） </option> 
										   </c:when> 
										   <c:when test="${sessionScope.userinfo.roleId eq 2}"> 
										    <option value="3"> 区管理员 </option> 
										    <option value="4"> 校管理员 </option> 
										    <option value="5"> 教师 </option> 
										    <option value="9"> 实施机构管理员（区） </option> 
										    <option value="10"> 实施机构管理员（校） </option> 
										   </c:when> 
										   <c:when test="${sessionScope.userinfo.roleId eq 3}"> 
										    <option value="4"> 校管理员 </option> 
										    <option value="5"> 教师 </option> 
										    <option value="10"> 实施机构管理员（校） </option> 
										   </c:when> 
										   <c:when test="${sessionScope.userinfo.roleId eq 4}"> 
										    <option value="5"> 教师 </option> 
										   </c:when> 
										   <c:when test="${sessionScope.userinfo.roleId eq 5}"> 
										    
										   </c:when> 
										   <c:when test="${sessionScope.userinfo.roleId eq 6}"> 
										    
										   </c:when> 
										   <c:when test="${sessionScope.userinfo.roleId eq 7}"> 
										    <option value="8"> 实施机构管理员（市） </option> 
										    <option value="9"> 实施机构管理员（区） </option> 
										    <option value="10"> 实施机构管理员（校） </option> 
										   </c:when> 
										   <c:when test="${sessionScope.userinfo.roleId eq 8}"> 
										    <option value="9"> 实施机构管理员（区） </option> 
										    <option value="10"> 实施机构管理员（校） </option> 
										   </c:when> 
										   <c:when test="${sessionScope.userinfo.roleId eq 9}"> 
										    <option value="10"> 实施机构管理员（校） </option> 
										   </c:when> 
										   <c:when test="${sessionScope.userinfo.roleId eq 10}"> 
										   
										   </c:when> 
										    <c:otherwise> 
										  </c:otherwise>
										  </c:choose> 
									</select>
									<a style="color: red" id="byRoleError"></a>
						</td>
					</tr>
					<tr id="byName" class="sendType" >
						<td>
							收信人：
						</td>
						<td>
							<input id="receverName" name="input" type="text" class="scinput" 
								style="width: 240px;" />
							<a style="color: red" id="receverNameError"></a>
						</td>
					</tr>
					<tr>
						<td>
							标题：
						</td>
						<td>
							<input name="input" type="text" class="scinput" id="title"
								style="width: 240px;" />
							<a style="color: red" id="titleError"></a>
						</td>
					</tr>
					<tr>
						<td>
							内容：
						</td>
						<td>
							<textarea rows="10" cols="35" id="content" class="scinput"
								style="width: 300px; height: 120px;"></textarea>
						</td>
					</tr>
					<tr>
						<td  colspan="2" >附件：【支持上传图片，文本文件，OFFICE 文档，压缩包等】</td>
					</tr>
<!-- 		        	<tr id="uploadTr"> -->
<!--  			</tr> -->
 			</tbody>
 			<tr>
 			<tr><td width="450" colspan="2"><input type="file" style="float:left;" name="file" > </td></tr>
 			
 			
 			</tr>
				</table>
				</form>

			</div>

			<div class="tipbtn" style="margin-top:150px">
				<input name="" type="button" class="sure" onclick="sendInfo();"
					id="submit" value="发送" />
				&nbsp;
				<input name="" type="button" class="cancel" value="取 消" />
			</div>
 			<div style="clear:both"></div>
		</div>
	</body>

</html>
