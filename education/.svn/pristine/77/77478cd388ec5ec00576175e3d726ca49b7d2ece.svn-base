<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>新增年度证书</title>

		<%@include file="../common/commonHead.jsp"%>
		<link />
		<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/addYearCertificate.js"> </script>
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
					<li>
						<a href="#">继教信息</a>
					</li>
					<li>
						<a href="#">继教证书</a>
					</li>
					<li>
						<a href="#">年度培训证书设置</a>
					</li>
					<li>
						<a href="#">新增年度证书</a>
					</li>
				</ul>
			</div>
			<div class="formbody">
				<ul class="seachform" >
		        	<li>
						<label>
							<font style="color: red">*</font>证书年度：
						</label>
						<div class="vocation">
		        			<select name="select" class="select2 yearpicker" id="diplomaYear">
							</select> 
						</div>
					</li>
					<a id="diplomaYearError" style="color: red"></a>
        		</ul>
        		<ul class="seachform" >
		        	<li>
						<label>
							<font style="color: red">*</font>证书标题：
						</label>
						<div class="vocation">
		        			<input name="" type="text" class="scinput" id="diplomaTitle" />
						</div>
					</li>
					<a id="diplomaTitleError" style="color: red"></a>
        		</ul>
	        	<ul class="seachform" >
	        		<li style="width: 420px">
						<label>
							<font style="color: red">*</font>开始时间：
						</label>
						<input type="text" name="startDate" id="startDate"
							class="Wdate scinput"
							style="height: 32px; line-height: 32px; border-color: #a7b5bc #ced9df #ced9df #a7b5bc;"
							onClick="WdatePicker()">
						<a id="startDateError" style="color: red"></a>
					</li>
	        	</ul>
	        	<ul class="seachform" >
	        		<li style="width: 420px">
						<label>
							<font style="color: red">*</font>结束时间：
						</label>
						<input type="text" name="endDate" id="endDate"
							class="Wdate scinput"
							style="height: 32px; line-height: 32px; border-color: #a7b5bc #ced9df #ced9df #a7b5bc;"
							onClick="WdatePicker()">
						<a id="endDateError" style="color: red"></a>
					</li>
	        	</ul>
	        	<ul class="seachform" >
		        	<li>
						<label>
							<font style="color: red">*</font>偿还倍数：
						</label>
						<div class="vocation">
		        			<input name="" type="text" class="scinput" id="repayRate" />
						</div>
					</li>
					<a id="repayRateError" style="color: red"></a>
        		</ul>
	        	<ul class="formbody" >
		        	<div id = "formList1">
		        	
		        	</div>
	        	</ul>
				<a id="diplomaError" style="color: red"></a>
      		</div>
        	<div class="tipbtn">
				<table border="0" cellspacing="0" cellpadding="0"
					style="margin: left;" >
					<tr>
						<td>
							<a class="dian3" onclick="saveInfo()" id="save">保 存</a>
						</td>
						<td style="width: 30px;">
							&nbsp;
						</td>
						<td>
							<a class="dian3"
								onclick="javascript:window.history.back();">取 消</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>

