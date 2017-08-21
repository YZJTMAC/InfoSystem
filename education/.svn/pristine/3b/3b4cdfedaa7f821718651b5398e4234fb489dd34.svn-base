<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>发送通知</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
	<%@include file="../common/commonHead.jsp"%>
	<script charset="utf-8" src="<%=basePathHeader%>/kindeditor/kindeditor_notice.js"></script>
	<script charset="utf-8" src="<%=basePathHeader%>/kindeditor/lang/zh_CN.js"></script>
	<script type="text/javascript" src="<%=basePathHeader%>/javascript/message/messageSendByUser.js"></script>
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
		   margin: 25px 0px 10px 0px;
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
			<div class="itab">
				<ul>
					<li>
						<a id="tab_1" href="<%=basePathHeader %>/message/messageManagement/sendMessageByScope.htm?click=3" class="">选择范围
						</a>
					</li>
					<li>
						<a id="tab_3" href="<%=basePathHeader %>/message/messageManagement/sendMessageByProject.htm?click=3" class="">选择项目
						</a>
					</li>
					<li>
						<a id="tab_2" href="<%=basePathHeader %>/message/messageManagement/sendMessageByUser.htm?click=3" class="selected">选择用户
						</a>
					</li>
				</ul>
			</div>
			
			<div class="explain">
				说明：收信人填写为<span style="color: red;">系统登录账户</span>
				<br/>
				<span>实例：假设收信人填写为<span style="color: red">fjadmin</span>，则<span style="color: red">fjadmin</span>登录后可看到该通知</span>
			</div>
			<div class="textContent" id="textContent" style="padding-left:20px;">
				<form id="messageForm" enctype="multipart/form-data" method="post">
					<table border="0" cellspacing="0" cellpadding="0" style="width:100%;line-height: 40px; margin: 0 auto;">
						<tbody>
							<tr>
								<td width="84"><font color="red">*</font>收信人：</td>
								<td width="260" colspan="3">
									<input id="receiveUser" name="receiveUser" type="text" class="scinput" style="width: 300px;"/>
								</td>
							</tr>
							<tr>
								<td width="84"><font color="red">*</font>通知标题：</td>
								<td width="260">
									<input id="title" name="title" type="text" class="scinput" style="width: 300px;">
								</td>
								<td width="84"><font color="red">*</font>通知类型：</td>
								<td width="485">
									<select id="messageType" name="messageType" class="select3 ">
										<option value="${messageType}">${from}</option>
									</select>
								</td>
							</tr>
							
							<tr>
								<td><font color="red">*</font>内容：</td>
								<td colspan="3"><textarea id="content" name="content" style="width: 750px;"></textarea>
								</td>
							</tr>
							 <tr>
								<td>附件：</td>
								<td colspan="3"><input type="file" name="file" />
								</td>
							</tr> 
						</tbody>
					</table>
					<table id="fileList"  style="margin-left: 100px;">
					</table>
					<table border="0" cellspacing="0" cellpadding="0" style="margin: 0 auto;">
						<tbody>
							<tr>
								<td colspan="2"><a href="###" onclick="sendMessage();" class="dian3">发送</a>
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