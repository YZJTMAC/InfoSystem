<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="../common/commonHead.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>非培训类项目学分登记</title>
<link rel="stylesheet" href="<%=basePathHeader%>/javascript/common/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"/>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/mustache.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/ztree/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/creditEnterNoTrain.js"></script>
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
	<!-- content -->
	<div class="content">
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">继教信息</a>
				</li>
				<li><a href="#">学分登记</a>
				</li>
				<li><a href="#">非培训类项目学分登记</a>
				</li>
			</ul>
		</div>
		<div class="place">
			<p style="padding:0 20px;color:#39C">操作提示:</p>
		</div>

		<div class="formbody" style="overflow:hidden;">

			<ul class="seachform">
				<li>

					<p id="projectName" class="xmTool">
						 
					</p></li>

				<li><label>教师姓名：</label> <input id="txtTeacherName"
					name="input" type="text" class="scinput" /></li>
				<li><input id="select" class="scbtn" name="input2" type="button"
					class="dian3" value="查 询" /></li>


			</ul>



			<div style="width:30%; float:left;">
				<div style="width:180px; float:left;">
					<ul id="treeDemo2" class="ztree"></ul>
				</div>

			</div>

			<div style="width:70%; float:left;">
				<div class="tabson">

 <div class="idTabs itab">
          <ul>
            <li>
              <a href="#tab1" id="tabPage0"  class="selected">未登记</a>
            </li>

            <li>
              <a href="#tab2"  id="tabPage1" >已登记</a>
            </li>
          </ul>
        </div>

<div id="tab1">
<div class="chauxnJS jsTool">
						<span style="float:left;"> <label>&nbsp;登记学分：</label> <input
							id="batchScore" name="input" type="text" class="scinput" />
							&nbsp;<a href="#" class="huibtn_a  " id="btnBatch"
							style="margin-left: 6px">批量登记</a> <a
							href="javascript:history.back();" class="huibtn_a  "
							style=" margin-left:6px">返回</a> </span> <span style="float:right;">
						</span>
					</div>

					<table class="tablelist">
						<thead>
							<tr>
								 <th><input id="chkAll" type="checkbox" value="" /></th>
								
								<th>姓名</th>
								<th>性别</th>
								<th>身份证号</th>
								<th>学校</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="target">
						</tbody>
					</table>
					<div id="page_1"></div>
</div>
<div id="tab2">
<div class="chauxnJS jsTool">
						<span style="float:left;">  <a
							href="javascript:history.back();" class="huibtn_a  "
							style=" margin-left:6px">返回</a> </span> <span style="float:right;">
						</span>
					</div>
					
				<table class="tablelist">
						<thead>
							<tr>
								 <th  >姓名</th><th width="4%">性别</th>
                <th  >身份证号</th>
                <th  >学校</th>
                <th >登记学分</th>
				   <th >审核状态</th>

							</tr>
						</thead>
						<tbody id="target2">
						</tbody>
					</table>
				 <div id="page_2"></div>
					
</div>


						<!-- 分页 -->					
					<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
				    <input id="pageSize" value="10" type="hidden" name="pageSize" />
					<!-- <div id="pagebar" class="pagin"></div> -->
					<!-- 分页 -->
					

				</div>
			</div>




		</div>


	</div>

	<!-- 页面隐藏域 -->
	<input id="txtProvinceId" type="hidden" />
	<input id="txtCityId" type="hidden" />
	<input id="txtDistrictId" type="hidden" />
	<input id="txtSchoolId" type="hidden" />

	<input id="txtSchoolType" type="hidden" />

	<input id="txtAreaLevel" type="hidden" />
	<input id="txtAreaId" type="hidden" />


	<input id="txtNoTraintProjectAreaId" type="hidden" />
	<!-- 非培训类项目的项目范围 -->
	<input id="userId" type="hidden" />
	<input id="isCreditEntered" value="0" type="hidden" />
	<!-- 登记学分的教师id-->
	<!-- 页面隐藏域 -->

	<script id="template" type="x-tmpl-mustache">
{{#users}}
	<tr>
 <td><input name="chkEnterCredit" type="checkbox" value="{{id}}" /></td>

		<td>{{realName}} </td>
		 
{{#gender}}
 <td>男 </td> 
{{/gender}}
{{^gender}}
  <td>女 </td> 
{{/gender}}

		<td>{{idNumber}}</td>
		<td>{{schoolName}}</td>
		 
		<td>
			 
			<a name="btn_bc" onclick="popup({{id}});"   class="huibtn_a click" >登记</a>&nbsp;&nbsp;
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
		 <td>{{teacherScore}}</td>
  <td>{{auditStatus}} </td> 


 
</tr>
{{/users}}
</script>


 

	<div class="tip" style="z-index:1">
		<div class="tiptop">
			<span>学分登记</span><a></a>
		</div>


		<table border="0" cellspacing="0" cellpadding="0"
			style="line-height:40px; margin:0 auto;">
			<tr>
				<td>&nbsp;</td>

			</tr>




			<tr>
				<td>登记学分:<input type="text" class="scinput" id="txt_fp"
					value="0" />学分</td>

			</tr>
			<tr>
				<td>&nbsp;</td>

			</tr>


		</table>



		<table width="230" style="margin:0 auto;">

			<tr>
				<td width="130"><a href="#" onclick="enterOneCredit();"
					class="sure dian3" />确定</a>
				</td>
				<td width="15">&nbsp;</td>
				<td width="130"><a href="#" class="cancel dian3" />取消</a>
				</td>
			</tr>

		</table>

	</div>

	<script type="text/javascript">
		$(document).ready(function() {

			$(".click").click(function() {
				$(".tip").fadeIn(200);
			});

			$(".tiptop a").click(function() {
				$(".tip").fadeOut(200);
			});

			/* $(".sure").click(function(){
				var teacherId = $("#userId").val();
				enterCredit(teacherId);//登记学分
			$(".tip").fadeOut(100);
			}); */

			$(".cancel").click(function() {
				$(".tip").fadeOut(100);
			});

			$(".click2").click(function() {
				$(".tip2").fadeIn(200);
			});

			$(".tip2top a").click(function() {
				$(".tip2").fadeOut(200);
			});

			$(".sure2").click(function() {
				$(".tip2").fadeOut(100);
			});

			$(".cancel2").click(function() {
				$(".tip2").fadeOut(100);
			});

		});
	</script>
<script type="text/javascript"	src="<%=basePathHeader%>/javascript/jquery.json-2.4.min.js" ></script>
<script type="text/javascript"	src="<%=basePathHeader%>/javascript/jquery.alertWindow.min.js" ></script>
</body>

</html>
