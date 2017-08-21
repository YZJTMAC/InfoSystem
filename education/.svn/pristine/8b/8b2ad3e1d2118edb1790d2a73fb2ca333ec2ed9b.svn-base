
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加非培训类项目</title>
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
		lastSelect = '${areaType}_${areaId}_${areaName}';
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
				<li><a href="###">继教信息</a>
				</li>
				<li>非培训类项目</li>
				<li><a href="#">添加</a>
				</li>
			</ul>
		</div>
		<div class="formbody">


			<form action="" id="proForm" method="post">
			    <input type="hidden" name="propertyId" value="0" /> 
			    <input type="hidden" name="trainTypeId" value="0" />  
			    <input type="hidden" name="propertyName" value="0" />
			    <input type="hidden" name="trainTypeName" value="0" />
				<input type="hidden" name="modelId" /> 
				<input type="hidden" name="modelName" />
				<input type="hidden" id="scopeName" name="scopeName" value="<%=request.getAttribute("areaNames")%>"/>
				<div class="tabson" id="txtBox">
					<h4 style="padding:0 0 20px 40px;">项目基本信息：</h4>
					<table border="0" cellspacing="0" cellpadding="0"
						style="line-height:40px; margin:0 auto;">
						<tr>
							<td>继教信息板块:</td>
							<td><select class="select2" id="modelType"
								name="modelType">

							</select>
							</td>
						</tr>
						<tr>
							<td><font style="color: red">*</font>项目名称：</td>
							<td colspan="4"><div class="required">
									<input name="name" type="text" class="scinput"
										style="width:571px;" maxlength="50" />
								</div></td>
						</tr>
						<tr>
							<td>项目年度：</td>
							<td><select class="select2 yearpicker"
								name="year">
							</select>
							</td>
							<td>&nbsp;</td>
							<td><font style="color: red">*</font>项目编码：</td>
							<td><input name="code" type="text"
								class="scinput" /></td>
						</tr>
						<tr>
							<td ><font style="color: red">*</font>组织单位：</td>
							<td><input name="organizer" type="text"
								class="scinput" />
							</td>
							<td>&nbsp;</td>
							<td><font style="color: red">*</font>学分：</td>
							<td><input name="credit" type="text"
								class="scinput" /></td>
						</tr>

						<tr>
							<td><font style="color: red">*</font>开始日期：</td>
							<td><input type="text" name="beginDate" id = "beginDate"
								class="Wdate scinput"
								style="height:32px; line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;"
								onclick="WdatePicker()" /></td>
							<td>&nbsp;</td>
							<td><font style="color: red">*</font>结束日期：</td>
							<td><input type="text" name="endDate" class="Wdate scinput" id = "endDate"
								style="height:32px; line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;"
								onclick="WdatePicker()" /></td>
						</tr>
						<tr>
							<td>培训范围：</td>
							<td>
								<div class="vocation">
										<input id="areaName"  readonly="readonly" type="text"
										 class="scinput areaSelect" value="<%=request.getAttribute("areaNames")%>"/> <input type="hidden"
										id="areaId" name="scopeId" value="<%=request.getAttribute("areaIdes")%>"/> <input type="hidden" id="areaType" /> <a
										href="###" id="" class="areaSelect">&nbsp;&nbsp;请选择...</a>
								</div>
							</td>
						</tr>
						<tr>
							<td>备注：</td>
							<td><textarea name="description"
									style="height:100px; max-width:600px; border:1px solid #ccc;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;"></textarea>
							</td>
						</tr>
					</table>
				</div>
			</form>
			<table border="0" cellspacing="0" cellpadding="0"
				style="margin:0 auto;">
				<tr>
					<td><input type="button" onclick="savePro();" id="submitPro"
						class="sure" value="保存" /></td>
					<td style="width:30px;">&nbsp;</td>
					<td><a href="javascript:cancel();" class="dian3">取 消</a></td>
				</tr>
			</table>

			<div class="black" style="display: none;" id="black"></div>
		</div>
	</div>
	 	<!-- 区域选择 -->
   <%@include file="../common/commonAreaSelect.jsp"%>  
</body>


</html>
