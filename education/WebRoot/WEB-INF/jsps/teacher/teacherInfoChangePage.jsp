<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>信息变更记录</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherInfoChangePage.js"></script>
		<script type="text/javascript">
			$(document).ready(function(e) {
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
						<a href="#">信息变更记录</a>
					</li>
				</ul>
			</div>

			<div class="formbody">

				<div class="tabson">
					<ul class="seachform" style="padding-left: 23px;">

						<li>
							<label>
								操作时间：
							</label>
							<div class="vocation">
								<input id="auditCreateDate" type="text" name="startDate" class="Wdate scinput"
									style="height: 32px; line-height: 32px; border-color: #a7b5bc #ced9df #ced9df #a7b5bc; width: 120px"
									onClick="WdatePicker()" />
							</div>
						</li>
						<li>
							<label>
								变更类型：
							</label>
							<div class="vocation">
								<select id="changeType" class="select3">
									<option value="">
										--请选择--
									</option>
									<option value="1">
										信息变更
									</option>
									<option value="2">
										调动
									</option>
									<option value="33">
										离休
									</option>
								</select>
							</div>
						</li>

						<li>
							<label>
								审核状态：
							</label>
							<div class="vocation">
								<select id="auditStatus" class="select3">
								<option value="">
										--请选择--
									</option>
									<option value="11">
										未审核
									</option>
									<option value="13,15">
										审核通过
									</option>
									<option value="12">
										审核不通过
									</option>
								</select>
							</div>
						</li>
						<li>
							<label>
								&nbsp;
							</label>
							<input id="select" type="button" class="scbtn" value="查 询" />
						</li>
					</ul>
				</div>

				<table class="tablelist">
					<thead>
						<tr>
							<th>
								操作人
							</th>
							<th>
								操作时间
							</th>
							<th>
								变更类型
							</th>
							<th>
								审核状态
								<!-- <i class="sort"><img src="<%=basePathHeader%>/images/px.gif" /> </i> -->
							</th>
							<th>
								最后审核时间
							</th>
							<th>
								操作
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
