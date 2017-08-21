<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>编辑非培训类项目</title>
<%@include file="../common/commonHead.jsp"%>
<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/notrainValidate.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/mnotrainAdd.js"></script>
<script type="text/javascript">
	$(function() {
		$(".select2").uedSelect({
			width : 167
		});
	});
	lastSelect = '${areaType}_${notrain.scopeId}_${notrain.scopeName}';
</script>
</head>

<body>
	<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp">
			<jsp:param value="furtheredu" name="flag" />
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
				<li><a href="###">继教信息</a></li>
				<li>非培训类项目</li>
				<li><a href="#">修改</a></li>
			</ul>
		</div>
		<div class="formbody">


			<form action="" id="proForm" method="post">
				<input type="hidden" name="id" value="${notrain.id}" />
				<input type="hidden" name="modelId" value="${notrain.modelId}"/>
				<input type="hidden" name="modelName"/>
				<input type="hidden" name="year" id="year" value="${notrain.year}"/>
				<input type="hidden" id="scopeName" name="scopeName" value="${notrain.scopeName}"/>
				<div class="tabson" id="txtBox">
					<h4 style="padding:0 0 20px 40px;">项目基本信息：</h4>
					<table border="0" cellspacing="0" cellpadding="0"
						style="line-height:40px; margin:0 auto;">
						<tr>
							<td>继教信息板块:</td>
							<td><select class="select2" id="modelType" name="modelType">

							</select></td>
						</tr>
						<tr>
							<td><font style="color:red">*</font>项目名称：</td>
							<td colspan="4"><div class="required">
									<input name="name" readonly="readonly" value="${notrain.name}" type="text" class="scinput"
										style="width:571px;" maxlength="50" />
								</div>
							</td>
						</tr>
						<tr>
							<td><font style="color:red">*</font>项目年度：</td>
							<td><select class="select2 yearpicker1"
								id="selectYear">
							</select></td>
							<td>&nbsp;</td>
							<td><font style="color:red">*</font>项目编码：</td>
							<td ><input name="code" readonly="readonly" value="${notrain.code}" type="text"
								class="scinput" />
							</td>
						</tr>
						<tr>
							<td ><font style="color:red">*</font>组织单位：</td>
							<td><input name="organizer" value="${notrain.organizer}" type="text"
								class="scinput" /></td>
							<td >&nbsp;</td>
							<td><font style="color:red">*</font>学分：</td>
							<td ><input name="credit" value="${notrain.credit}" type="text"
								class="scinput" />
							</td>
						</tr>

						<tr>
							<td><font style="color:red">*</font>开始日期：</td>
							<td><input type="text" name="beginDate" id="beginDate" value="${notrain.beginDate}"
								class="Wdate scinput"
								style="height:32px; line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;"
								onclick="WdatePicker()" />
							</td>
							<td>&nbsp;</td>
							<td><font style="color:red">*</font>结束日期：</td>
							<td><input type="text" name="endDate" id="endDate" value="${notrain.endDate}" class="Wdate scinput"
								style="height:32px; line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;"
								onclick="WdatePicker()" />
							</td>
						</tr>
						<tr>
							<td >项目范围：</td>
							<td >
								<div class="vocation">
									<input id="areaName" 　 readonly="readonly" type="text"
										 class="scinput areaSelect" value="${notrain.scopeName}"/> <input type="hidden"
										id="areaId" name="scopeId" value="${notrain.scopeId}"/> <input type="hidden" id="areaType" /> <a
										href="###" id="" class="areaSelect">&nbsp;&nbsp;请选择...</a>
								</div></td>
						</tr>
						<tr>
							<td >备注：</td>
							<td ><textarea name="description"  
									style="height:100px; max-width:600px; border:1px solid #ccc;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;">${notrain.description}</textarea>
							</td>
						</tr>
					</table>
				</div>
			</form>
			<table border="0" cellspacing="0" cellpadding="0"
				style="margin:0 auto;">
				<tr>
					<td><input type="button" onclick="updatePro();" id="submitPro"
						class="sure" value="保存" />
					</td>
					<td style="width:30px;">&nbsp;</td>
					<td><a href="javascript:cancel();" class="dian3">取 消</a>
					</td>
				</tr>
			</table>

			<div class="black" style="display: none;" id="black"></div>
		</div>
	</div>
		 	<!-- 区域选择 -->
   <%@include file="../common/commonAreaSelect.jsp"%>  
</body>


</html>
