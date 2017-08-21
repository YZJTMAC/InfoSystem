<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>教师调动审核</title>
		<%@include file="../common/commonHead.jsp"%>
		<%@include file="../common/commonAreaSelect.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/toMobilizeAuditListPage.js"></script>
		<script type="text/javascript">
			var flag = ${flag}
			$(document).ready(function(e) {
				$(".select3").uedSelect( {
					width : 120
				});
			});
		</script>
		<style type="text/css">
			.cancel1 {
				background: url(../../images/btnbg2.png) repeat-x;
				color: #000;
				font-weight: normal;
			}
		</style>
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
						<a href="#">教师信息审核 </a>
					</li>
					<li>
						<a href="#">教师调动审核</a>
					</li>
					<li>
						由发起校的管理员或者行政管理员，审核通过后，此教师的信息才会在调动后的目标学校。
					</li>
				</ul>
			</div>
			<div class="formbody">
				<div id="usual1" class="usual">

					<div class="itab">
						<ul id="action">

							<li>
								<a id="N"
									href="<%=basePathHeader%>/teacher/teachermanage/toMobilizeAuditListPage.htm?click=1000&flag=N">待审核调动</a>
							</li>
							<li>
								<a id="Y"
									href="<%=basePathHeader%>/teacher/teachermanage/toMobilizeAuditListPage.htm?click=1000&flag=Y">已审核调动</a>
							</li>
						</ul>
					</div>

					<div id="tab1" class="tabson">

						<div class="tabson">


							<ul class="seachform">

								<li>
									<label>
										姓名：
									</label>
									<input style="width: 80px" name="realName" id="realName" type="text"
										class="scinput" />
								</li>
								<li>
									<label>
										身份证号：
									</label>
									<input style="width: 160px"  name="idNumber" id="idNumber" type="text"
										class="scinput" />
								</li>
								<li>
									<label>
										原地区：
									</label>
									<input readonly="readonly" name="input" id="tss" value="点击选择"
										type="text" onclick="clearPCD();"
										class="scinput areaSelect" />
								<!-- <input name="input2" type="button" value="选 择"
										class="btnXuan areaSelect" /> -->
								</li>
								<li>
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
									<th width="4%">
										姓名
									</th>
									<th width="6%">
										身份证
									</th>
									<th width="3%">
										性别
									</th>
									<th width="12%">
										原地区
									</th>
									<th width="12%">
										目标地区
									</th>
									<th width="4%">
										操作人
									</th>
									<th width="6%">
										操作时间
									</th>
									<th id="actionInfo" width="6%">
										
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
						<!-- 分页 -->
						<input type="hidden" name="schoolProvinceId" id="schoolProvinceId"
							value="" />
						<input type="hidden" name="schoolCityId" id="schoolCityId"
							value="" />
						<input type="hidden" name="schoolDistrictId" id="schoolDistrictId"
							value="" />
						<input type="hidden" name="schoolId2" id="schoolId2" value="" />
						<br />
					</div>
				</div>
			</div>
		</div>

		<div class="tip1" style="width: 400px; height: 150px; top: 40%; left: 35%">
			<div class="tiptop">
				<span>提示信息</span>
			</div>
			<table style="width: 100%; height: 100%">
				<tr>
					<td align="center">
						<span id="msgHtml"></span>
					</td>
				</tr>
				<tr>
					<td align="center" valign="top" style="height: 60%">
						<input name="" id="toPage" type="button" class="sure1" value="确定" />
						<input name="" id="cancel" type="button" class="cancel1"
							value="取消" />

					</td>
				</tr>
			</table>
		</div>
	</body>

</html>
<script>
var audit ="<%=request.getParameter("flag")%>";
$("#"+audit+"").addClass('selected');
if(audit=='N'){
$("#actionInfo").html("操作");
}else if(audit=='Y'){
$("#actionInfo").html("审核状态");
}
</script>