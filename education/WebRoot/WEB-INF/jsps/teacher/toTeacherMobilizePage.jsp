<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>我的调动记录</title>
		<%@include file="../common/commonHead.jsp"%>
		<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/toTeacherMobilizePage.js"></script>
		<script type="text/javascript">
			$(document).ready(function(e) {
				$(".select3").uedSelect( {
					width : 120
				});
			});
		</script>
	</head>

	<body>
		<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="teacher" name="flag" />
			</jsp:include>
		</div>
		<!-- left -->
		<div class="leftNav">
			<%@include file="../common/teacherLeft.jsp"%>
		</div>

		<div class="content">
			<div class="place">
				<span>位置：</span>
				<ul class="placeul">
					<li>
						<a href="#">教师信息</a>
					</li>
					<li>
						<a href="#">我的调动记录</a>
					</li>
				</ul>
			</div>
			<div class="formbody">
				<div id="usual1" class="usual">
					<div id="tab1" class="tabson">

						<div class="tabson">

							<ul class="seachform">

								<li>
									<label>
										操作时间：
									</label>
									<input type="text" id="startDate" name="startDate"
										class="Wdate scinput"
										style="height: 32px; line-height: 32px; border-color: #a7b5bc #ced9df #ced9df #a7b5bc;"
										onClick="WdatePicker()" />
									&nbsp;—&nbsp;
									<input type="text" id="endDate" name="endDate"
										class="Wdate scinput"
										style="height: 32px; line-height: 32px; border-color: #a7b5bc #ced9df #ced9df #a7b5bc;"
										onClick="WdatePicker()" />
								</li>
								<li>
									<label>
										审核状态：
									</label>
									<div class="vocation" style="padding-right: 8px;">
										<select id="auditStauts" class="select3">
											<option value="">
												请选择...
											</option>
											<option value="11">
												未审核
											</option>
											<option value="12">
												未通过
											</option>
											<option value="13,15">
												审核通过
											</option>
										</select>
									</div>
								</li>
								<li>
									<label>
										&nbsp;
									</label>
									<input name="" id="select" type="button" class="scbtn"
										value="查 询" />
								</li>
							</ul>
						</div>

						<div class="chauxnJS jsTool">

							<span style="float: right;">
								<div class="pagin" style="margin: 0; width: 180px;">
									<div class="message">
										共
										<i class="blue" id="counts"></i>条记录
									</div>
									<div class="vocation paginList"
										style="margin: 4px 6px 0 6px; right: 0px;">
										<select id="sizePerPage" onchange="showMobilizeList()"
											class="select3">
											<option value="100">
												每页显示100条
											</option>
											<option value="300">
												每页显示300条
											</option>
											<option value="500">
												每页显示500条
											</option>
										</select>
									</div>

								</div> </span>
						</div>


						<table class="tablelist">
							<thead>
								<tr>
									<th>
										教师姓名
									</th>
									<th>
										身份证号
									</th>
									<th>
										性别
									</th>
									<th>
										原地区
									</th>
									<th>
										目标地区
									</th>
									<th>
										操作人
									</th>
									<th>
										操作时间
									</th>
									<th>
										审核状态
									</th>
									<th>
										详情
									</th>
								</tr>
							</thead>
							<tbody id="proTeacher_list">

							</tbody>
						</table>

						<!-- 分页 -->
						<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
						<div id="pagebar" class="pagin">
						</div>
						<br />
					</div>
				</div>
			</div>
		</div>
	</body>
</html>