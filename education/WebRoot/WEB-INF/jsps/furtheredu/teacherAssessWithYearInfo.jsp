<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>年度继教详情</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/teacherAssessWithYearInfo.js"></script>

		<script type="text/javascript">
			$(document).ready(function(e) {
				$(".select1").uedSelect( {
					width : 110
				});
			});
			var year = "<%=request.getParameter("year")%>";
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
						<a href="#">继教考核查询</a>
					</li>
					<li>

						年度继教详情

					</li>
				</ul>
			</div>

			<div class="formbody">

				<div class="tabson">
					<div id="SZ">
						
					</div>

					<ul class="seachform">

						<li>
							<label>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;培训年度：
							</label>
							<label>
								<select id="startYear" name="select" class="select1 yearpicker"></select>
							</label>
						</li>
						<li>
							<input name="input2" id="select" type="button" class="dian3"
								value="查 询" />
						</li>

					</ul>


				</div>

				<div class="chauxnJS jsTool">
					<span style="float: left;"> <a href="###" onclick="goback();" class="huibtn_a" style="margin-left: 6px">返回</a> </span>
					<span style="float: right;"> </span>
				</div>

				<table class="tablelist">
					<thead>
						<tr>
							<th>
								项目编号
							</th>
							<th>
								项目名称
							</th>
							<th>
								结束时间
							</th>
							<th>
								成绩 
							</th>
							<!-- <th>
								成绩/学分
							</th> -->
							<th>
								获得学分
							</th>
							<th>
								状态
							</th>

						</tr>
					</thead>

					<tbody id="proTeacher_list">

					</tbody>

				</table>


			</div>
		</div>
	</body>

</html>
