<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加校本培训项目</title>
<%@include file="../common/commonHead.jsp"%>
<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/notrainValidate.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/notrainAdd.js"></script>
<script type="text/javascript">
	$(function() {
		$(".select2").uedSelect({
			width : 167
		});
	});
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
				<li>校本培训项目</li>
				<li><a href="#">添加</a></li>
			</ul>
		</div>
		<div class="formbody">


			<form action="" id="proForm" method="post">
				<input type="hidden" name="propertyId"/>
				<input type="hidden" name="trainTypeId"/>
				<input type="hidden" name="scopeName"/>
				<input type="hidden" name="propertyName"/>
				<input type="hidden" name="trainTypeName"/>
				<input type="hidden" name="modelId"/>
				<input type="hidden" name="modelName"/>
				<div class="tabson" id="txtBox">
					<h4 style="padding:0 0 20px 40px;">项目基本信息：</h4>
					<table border="0" cellspacing="0" cellpadding="0"
						style="line-height:40px; margin:0 auto;">
						<tr>
							<td>继教信息板块:</td>
							<td width="260"><select class="select2" id="modelType" name="modelType">

							</select></td>
						</tr>
						<tr>
							<td><font style="color: red">*</font>项目名称：</td>
							<td colspan="4"><div class="required">
									<input name="name" type="text" class="scinput"
										style="width:571px;" maxlength="50" />
								</div>
							</td>
						</tr>
						<tr>
							<td width="84">项目年度：</td>
							<td width="260"><select class="select2 yearpicker"
								name="year">
							</select></td>
							<td width="60">&nbsp;</td>
							<td><font style="color: red">*</font>项目编码：</td>
							<td width="260"><input name="code" type="text"
								class="scinput" />
							</td>
						</tr>
						<tr>
							<td width="84"><font style="color: red">*</font>组织单位：</td>
							<td width="260"><input name="organizer" type="text"
								class="scinput" /></td>
							<td width="60">&nbsp;</td>
							<td><font style="color: red">*</font>学分：</td>
							<td width="260"><input name="credit" type="text"
								class="scinput" />
							</td>
						</tr>

						<tr>
							<td><font style="color: red">*</font>开始日期：</td>
							<td><input type="text" name="beginDate" id="beginDate"
								class="Wdate scinput"
								style="height:32px; line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;"
								onclick="WdatePicker()" />
							</td>
							<td>&nbsp;</td>
							<td><font style="color: red">*</font>结束日期：</td>
							<td><input type="text" name="endDate" class="Wdate scinput" id="endDate"
								style="height:32px; line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;"
								onclick="WdatePicker()" />
							</td>
						</tr>
						<tr>
							<td>培训类型：</td>
							<td><div class="vocation">
									<select name="projectProperty" class="select2" id="projectProperty">
									</select>
								</div></td>
							<td>&nbsp;</td>
							<td>培训形式：</td>
							<td><div class="vocation">
									<select name="projectTrainType" class="select2" id="projectTrainType">
									</select>
								</div></td>
						</tr>
						<tr>
							<td width="84">备注：</td>
							<td width="260" colspan="4"><textarea name="description"
									style="width:600px; height:100px; max-width:600px; border:1px solid #ccc;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;"></textarea>
							</td>
						</tr>
					</table>
				</div>
			</form>
			<table border="0" cellspacing="0" cellpadding="0"
				style="margin:0 auto;">
				<tr>
					<td><input type="button" onclick="savePro();" id="submitPro"
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
</body>


</html>
