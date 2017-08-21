<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>发送通知</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>个人信息</title> <%@include file="../common/commonHead.jsp"%>
	<link rel="stylesheet" href="<%=basePathHeader%>/javascript/common/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css" />
	<script charset="utf-8" src="<%=basePathHeader%>/kindeditor/kindeditor_notice.js"></script>
	<script charset="utf-8" src="<%=basePathHeader%>/kindeditor/lang/zh_CN.js"></script>
	<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/ztree/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/ztree/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="<%=basePathHeader%>/javascript/message/notice.js"></script>
	<script type="text/javascript">
		var content;
		$(function() {
			content = kedit("content");
		});
		function kedit(keid) {
			var content = KindEditor.create('#' + keid, {
				uploadJson : '<%=basePathHeader%>/fileupload/kindEditorUpload.do',
								urlType : 'relative',
								height : '200px',
								afterBlur : function() {
									this.sync();
								}
							});
		}
		$(document).ready(function(e) {
			$(".select3").uedSelect({
				width : 300
			});

			getNode();

		});
	</script>
	<style type="text/css">
ul.ztree {
	margin-top: 10px;
	border: 1px solid #617775;
	background: #f0f6e4;
	width: 220px;
	height: 360px;
	overflow-y: scroll;
	overflow-x: auto;
}

.explain{
   padding: 10px;
   margin-bottom:10px;
   line-height: 20px;
   border: dashed 1px;
}
span {
	display: inline;
}
</style>
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
				<li><a href="#">个人中心</a>
				</li>
				<li><a href="#">通知</a>
				</li>

			</ul>
		</div>

		<div class="formbody">
			<div class="noticeTool"
				style="overflow: hidden; border-bottom: 1px solid #ccc; line-height: 32px; margin-bottom: 30px;">
				<dl>
					<dt style="float: left; padding-right: 12px;"></dt>
					<dd style="float: left">
						<a href="<%=basePathHeader%>/notice/sendNotice.htm"
							style="background-color: #60C1E7; color: #fff; border-color: #2B89BF;"
							class="huibtn_a">发通知</a>
					</dd>
				</dl>

			</div>
			<div class="explain">
				说明：通知范围由<span style="color: red;">接收范围，接收人角色</span>共同确定!
				<br/>
				<span>实例：假设省管理员接收范围选择<span style="color: red">福州市</span>，接收人角色选择
				<span style="color: red">教师</span>，则<span style="color: red">福州市以及所辖区县的教师</span>都能看到该通知</span>
			</div>
			<div class="textContent" id="textContent">
				<form id="noticeForm"
					action="<%=basePathHeader%>/notice/sendNotice.do"
					 method="post">
					<table border="0" cellspacing="0" cellpadding="0"
						style="line-height: 40px; margin: 0 auto;">
						<tbody>
							<tr>
								<td width="84"><font color="red">*</font>通知标题：</td>
								<td width="260"><input id="title" name="title" type="text"
									class="scinput" style="width: 300px;">
								</td>
								<td width="84"><font color="red">*</font>通知类型：</td>
								<td width="465"><select id="noticeType" name="noticeType"
									class="select3 ">
										<option value="${noticeType}">${typeName}</option>
								</select></td>
							</tr>
							<!-- <tr>
								<td width="84">开始时间：</td>
								<td width="465"><input type="text" name="startDate"
									class="Wdate scinput"
									style="height:32px; line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;"
									onclick="WdatePicker()"><b style="color:#c00">&nbsp;*</b>
										<a id="idNumberHTML" style="color:#c00"></a>
								</td>
							</tr> -->
							<tr>
								<td width="84"><font color="red">*</font>接收范围：</td>
								<td width="465"><input id="citySel" style="width: 250px;"
									type="text" readonly onclick="showMenu();" class="scinput"
									value="" /> <input name="area" id="selectValue"
										type="hidden" value="" /> <a id="menuBtn" href="#"
										onclick="showMenu(); return false;">选择范围</a>
								</td>
								<td width="84"><font color="red">*</font>接收人角色：</td>
								<td width="260"><select id="sendType" name="sendType"
									class="select3 ">
										<c:choose>
											<c:when test="${noticeType eq 4}">
												<option value="3">教师</option>
											</c:when>
											<c:otherwise>
												<option value="0">全部</option>
												<option value="1">行政管理员</option>
												<option value="2">实施机构管理员</option>
												<option value="3">教师</option>
											</c:otherwise>
										</c:choose>

								</select></td>
							</tr>
							<tr>
								<td><font color="red">*</font>内容：</td>
								<td colspan="3"><textarea id="content" name="content"
										style="width: 850px;"></textarea>
								</td>
							</tr>
							 <tr>
								<td>附件：</td>
								<td colspan="3"><input type="file" onchange="uploadFile();" id="noticeFile" name="noticeFile" />
								</td>
							</tr> 
						</tbody>
					</table>
					<table id="fileList"  style="margin-left: 100px;">
					</table>
					<table border="0" cellspacing="0" cellpadding="0"
						style="margin: 0 auto;">
						<tbody>
							<tr>
								<td><a href="###" onclick="sendNotice();" class="dian3">保存</a>
								</td>
								<td style="width: 30px;">&nbsp;</td>
								<td><a href="###" onclick="javascript:window.history.back();" class="dian3">取 消</a>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
				<div id="menuContent" class="menuContent"
					style="display:none; position: absolute;">
					<ul id="treeDemo" class="ztree"
						style="margin-top:0; width:180px; height: 300px; z-index: 1000"></ul>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
