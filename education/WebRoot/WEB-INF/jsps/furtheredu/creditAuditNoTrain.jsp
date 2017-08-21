<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>信息查询</title>
<%@include file="../common/commonHead.jsp"%>
<link href="<%=basePathHeader%>/style/style.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePathHeader%>/style/select.css" rel="stylesheet"
	type="text/css" />
<script type=text/javascript
	src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript"
	src="<%=basePathHeader%>/javascript/furtheredu/creditAuditNoTrain.js"></script>
<script type="text/javascript"
	src="<%=basePathHeader%>/javascript/common/mustache.js"></script>
<script type="text/javascript"
	src="<%=basePathHeader%>/javascript/jquery.idTabs.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(e) {
		$(".select1").uedSelect({
			width : 345
		});
		$(".select2").uedSelect({
			width : 167
		});
		$(".select3").uedSelect({
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
				<li><a href="jixuMegGLY_2.2.html">继教信息</a></li>
				<li>学分审核</li>
				<li>非培训类项目学分审核</li>
			</ul>
		</div>

		<div class="formbody">
			<div class="idTabs itab">
				<ul>
					<li><a href="#tab1" id="tabPage0" class="selected">未审核<span
							class="ctype"></span> </a>
					</li>
					<li><a href="#tab2" id="tabPage1">已审核<span class="ctype"></span>
					</a>
					</li>

				</ul>
			</div>

			<div class="tabson">

				<ul class="seachform" style="padding-left:23px;">
					<li>
						<p class="xmTool">
							项目名称：<b id="pname">2014普通高中教师职务培训</b>
						</p></li>

					<li><label>教师姓名：</label> <input id="txtTeacherName"
						name="input" type="text" class="scinput" /></li>

					<li><label>&nbsp;</label><input type="button" class="scbtn"
						id="select" value="查 询" /></li>

				</ul>
			</div>


			<div id="tab1">
				<div class="chauxnJS jsTool">
				<div class="vocation"><select id="batchResult" class="select2">
								<option value="0">请选择...</option>
								<option value="13">合格</option>
								<option value="12">不合格</option>
							</select> </div>
					<span style="float:left;"> <label>&nbsp;审核学分：</label> <input
						id="batchScore" name="input" type="text" class="scinput" />
						&nbsp;<a href="#" class="huibtn_a  " id="btnBatch"
						style="margin-left: 6px">批量审核</a> <a
						href="javascript:history.back();" class="huibtn_a  "
						style=" margin-left:6px">返回</a> </span> <span style="float:right;">
					</span>
				</div>

				<table class="tablelist">
					<thead>
						<tr>
							<th width="4%"><input id="chkAll" type="checkbox" value="" />
							</th>
							<th width="10%">姓名</th>

							<th width="5%">身份证号</th>

							<th width="15%">学校</th>

							<th width="3%">登记学分</th>

							<th width="6%">操作</th>
						</tr>
					</thead>
					<tbody id="target">
					</tbody>
				</table>
				<!-- 分页 -->
						<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
						<div id="page_1"></div>
						<!-- 分页 -->

			</div>
			<div id="tab2">
				<div class="chauxnJS jsTool">
					<span style="float:left;"> <a
						href="javascript:history.back();" class="huibtn_a  "
						style=" margin-left:6px">返回</a> </span> <span style="float:right;">
					</span>
				</div>

				<table class="tablelist">
					<thead>
						<tr>
							<th width="4%">姓名</th>
							<th width="4%">性别</th>
							<th width="5%">身份证号</th>
							<th width="30%">学校</th>
							<th width="6%">登记学分</th>
							<th width="6%">审核状态</th>

						</tr>
					</thead>
					<tbody id="target2">
					</tbody>
				</table>
<div id="page_2"></div>

			</div>

			<!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
		<!-- 	<input id="pageIndex" value="1" type="hidden" name="pageIndex" /> -->
			<!-- <div id="pagebar" class="pagin"></div> -->
			<!-- <div id="page_1"></div> -->
			<!-- 分页 -->



			<!-- 页面隐藏域 -->
			<input id="isScorePublished" value="0" type="hidden" /> <input
				id="txtProjectId" type="hidden" /> <input id="userId" type="hidden" />
			<!-- 页面隐藏域 -->

		</div>
	</div>

	<div class="tip" style="z-index:1">
		<div class="tiptop">
			<span>学分审核</span><a></a>
		</div>

		<table border="0" cellspacing="0" cellpadding="0"
			style="line-height:40px; margin:0 auto;">
			<tr>
				<td id="pTeacherName" colspan="2"></td>
			</tr>
			<!--  <tr>
          <td   colspan="2">
			 总学分:12学分 
      
         </td>
        </tr> -->

			<tr>
				<td id="pscore" colspan="2"></td>
			</tr>

			<tr>
				<td>审核学分:</td>
				<td><input id="txt_fp" name="input" type="text" class="scinput" />


				</td>
			</tr>
			<tr>
				<td>审核结果:</td>
				<td><input type="radio" checked name="isPass" value="13" />合格 <input
					type="radio" name="isPass" value="12" />不合格</td>
			</tr>
		</table>


		<table width="230" style="margin:0 auto;">

			<tr>
				<td width="130"><a href="#" class="sure dian3"
					onclick="auditOneCredit();" />确定</a>
				</td>
				<td width="15">&nbsp;</td>
				<td width="130"><a href="#" class="cancel dian3" />取消</a>
				</td>
			</tr>

		</table>


	</div>



	<script id="template" type="x-tmpl-mustache">
{{#users}}
	<tr>
 <td><input name="chkEnterCredit" type="checkbox" value="{{id}}" /></td>
 
		<td>{{realName}} </td>
		<td>{{idNumber}}</td>
		<td>{{schoolName}}</td>
		 <td>{{teacherScore}}</td>
		<td>
			 
			<a name="btn_bc" onclick="popup({{id}},'{{realName}}',{{teacherScore}});"   class="huibtn_a click" >审核</a>&nbsp;&nbsp;
		</td>
</tr>
{{/users}}
</script>

	<script id="template2" type="x-tmpl-mustache">
{{#users}}
	<tr>
  

		<td>{{realName}} </td>
		 
{{#gender}}
 <td>男 </td> 
{{/gender}}
{{^gender}}
  <td>女 </td> 
{{/gender}}

		<td>{{idNumber}}</td>
		<td>{{schoolName}}</td>
		 	<td>{{auditScore}}</td>
		{{#auditStatus}}
 <td>已审核</td> 
{{/auditStatus}}
{{^auditStatus}}
  <td>未审核 </td> 
{{/auditStatus}}

 
</tr>
{{/users}}
</script>
</body>

<script type="text/javascript"	src="<%=basePathHeader%>/javascript/jquery.json-2.4.min.js" ></script>
<script type="text/javascript"	src="<%=basePathHeader%>/javascript/jquery.alertWindow.min.js" ></script>
</html>

