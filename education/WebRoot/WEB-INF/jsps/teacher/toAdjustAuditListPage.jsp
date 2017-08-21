<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>编制调整审核</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/toAdjustAuditListPage.js"></script>
		<script type="text/javascript">
			$(document).ready(function(e) {
				$(".select3").uedSelect( {
					width : 120
				});
			});
		</script>

		<style type="text/css">
			.cancel {
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
						<a href="#">编制调整审核</a>
					</li>
				</ul>
			</div>
			<div class="formbody">
				<div id="usual1" class="usual">

					<div class="itab">
						<ul id="action">

							<li>
								<a id="N"
									href="<%=basePathHeader%>/teacher/teachermanage/toAdjustAuditListPage.htm?click=1001&flag=N">待审核编制调整</a>
							</li>
							<li>
								<a id="Y"
									href="<%=basePathHeader%>/teacher/teachermanage/toAdjustAuditListPage.htm?click=1001&flag=Y">已审核编制调整</a>
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
									<input style="width: 80px;" name="realName" id="realName" type="text"
										class="scinput" />
								</li>
								<li>
									<label>
										身份证：
									</label>
									<input style="width: 160px;" name="idNumber" id="idNumber" type="text"
										class="scinput" />
								</li>
								<li>
									<label>
										原编制：
									</label>
									<label>
										<select id="adjustId" class="select3">
											
										</select>
									</label>
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
										教师姓名
									</th>
									<th width="6%">
										身份证号
									</th>
									<th width="3%">
										性别
									</th>
									<th width="12%">
										原编制
									</th>
									<th width="12%">
										新编制
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

		<div class="tip01"
			style="width: 400px; height: 150px; top: 40%; left: 35%">
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
					</td>
				</tr>
			</table>
		</div>
		
		<div class="tip0">
			<div class="tiptop">
				<span>编制调整审核</span><a></a>
			</div>
			<div class="tipinfo">
				<table width="100%" height="80%">
					<tr>
						<td>
							是否审核通过
						</td>
						<td>
						<input type="radio" checked="checked" name="audit" value="1" id="audityes" />
							是 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="audit" value="0" id="auditno" />
							否
						</td>
						
					</tr>
					<tr>
						<td>
							编制调整说明
						</td>
						<td id="mark">
						
						</td>
						
					</tr>
					<tr>
						<td>审核意见</td>
						<td><textarea name="auditOption" id="auditOption" cols=""
												rows="" class="textinput"
												style="width: 260px; height: 80px;"></textarea></td>
						</tr>
				</table>
			</div>

			<div class="tipbtn">
				<input name="postPage" id="postPage" type="button" class="sure2" value="提交" />
				&nbsp;
				<input name="" type="button" class="cancel" value="取消" />
			</div>

		</div>
		<div id="myModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" ></div>
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