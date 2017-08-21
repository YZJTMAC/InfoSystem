<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>编辑继教信息版块</title>

		<%@include file="../common/commonHead.jsp"%>
		<link />
		<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/editModelInfo.js"></script>
		<script type="text/javascript">
			var id = '<%=request.getParameter("id")%>';
		</script>
	</head>

	<body>
		<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="project" name="flag" />
			</jsp:include>
		</div>
		<!-- left -->
		<div class="leftNav">
			<%@include file="../common/projectLeft.jsp"%>
		</div>

		<div class="content">
			<div class="place">
				<span>位置：</span>
				<ul class="placeul">
					<li>
						<a href="#">培训项目</a>
					</li>
					<li>
						<a href="#">继教信息板块</a>
					</li>
					<li>
						<a href="#">编辑</a>
					</li>

				</ul>
			</div>

			<div class="formbody">

				<ul class="seachform">
					<li>
						<label>
							<font style="color: red">*</font>继教信息板块名称：
						</label>
						<input name="" type="text"  class="scinput" style="width: 534px;"
							id="modelName" />
						<a id="modelNameError" style="color: red"></a>
					</li>
				</ul>
				<ul class="seachform">
					<li style="width: 472px">
						<label style="width: 120px">
							<font style="color: red">*</font>继教信息版块编码：
						</label>
						<input name="" type="text"  class="scinput" id="modelCode" />
						<a id="modelCodeError" style="color: red"></a>
					</li>


					<li>
						<label>
							<font style="color: red">*</font>培训类型：
						</label>
						<div class="vocation">
						<select name="select" class="select3" id="trainType">
	        			</select>
						</div>
						<a id="trainTypeError" style="color: red"></a>
					</li>
				</ul>

				<ul class="seachform">



					<li style="width: 472px">
						<label style="width: 105px">
							<font style="color: red">*</font>学分：
						</label>
						<input name="" type="text" class="scinput" id="trainScore" />
						<a id="trainScoreError" style="color: red"></a>
					</li>
					
					<li >
						<label>
							<font style="color: red">*</font>状&nbsp;&nbsp;态：
						</label>
						<div class="vocation">
						<select name="select" class="select4" id="status" >
	        				<option value="1">启用</option>
	        				<option value="0">禁用</option>
	        			</select>
						</div>
						<a id="statusError" style="color: red"></a>
					</li>

				</ul>


				<ul class="seachform">
					<li  style="width: 420px">
						<label style="width: 105px">
							<font style="color: red">*</font>计划开始日期：
						</label>
						<input type="text" name="startDate" id="startDate"
							class="Wdate scinput"
							style="height: 32px; line-height: 32px; border-color: #a7b5bc #ced9df #ced9df #a7b5bc;"
							onClick="WdatePicker()">
							<a id="startDateError" style="color: red"></a>
					</li>
					<li>
						<label>
							<font style="color: red">*</font>计划结束日期：
						</label>
						<input type="text" name="endDate" id="endDate"
							class="Wdate scinput"
							style="height: 32px; line-height: 32px; border-color: #a7b5bc #ced9df #ced9df #a7b5bc;"
							onclick="WdatePicker()" />
						<a id="endDateError" style="color: red"></a>
					</li>
				</ul>

				<ul class="seachform" style="padding-bottom: 10px; height: 100%">
					<li>
						<label>
							备注：
						</label>
						<textarea name="" cols="" rows=""
							style="width: 534px; border: #eee 1px solid; height: 100px; border-color: #a7b5bc #ced9df #ced9df #a7b5bc; -moz-border-radius: 5px; -webkit-border-radius: 5px; border-radius: 5px; margin-left: 72px;"
							id="memo"></textarea>
					</li>
				</ul>
				
				<table border="0" cellspacing="0" cellpadding="0"
					style="margin: 0 auto;">
					<tr>
						<td>
							<a href="#" class="dian3" onclick="editInfo()" id="saveId">保
								存</a>
						</td>
						<td style="width: 30px;">
							&nbsp;
						</td>
						<td>
							<a
								href="<%=basePathHeader%>/edupm/projectmanage/toModelListPage.htm?click=19"
								class="dian3">返 回</a>
						</td>
					</tr>
				</table>


			</div>
	</body>
</html>

