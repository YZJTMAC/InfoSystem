<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>编制调整管理</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/toAdjustPage.js"></script>
		<script type="text/javascript">
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
						<a href="#">教师信息</a>
					</li>
					<li>
						<a href="#">编制调整</a>
					</li>
				</ul>
			</div>
			<div class="formbody">
				<div id="usual1" class="usual">

					<div class="itab">
						<ul id="action">

							<li>
								<a
									href="<%=basePathHeader%>/teacher/teachermanage/toAdjustPage.htm?click=333"
									class="selected">已发起编制调整</a>
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
									<input name="realName" id="realName" type="text"
										class="scinput" style="width: 80px;"/>
								</li>
								<li>
									<label>
										身份证号：
									</label>
									<input name="idNumber" id="idNumber" type="text"
										class="scinput" />
								</li>
								<li>
									<label>
										原编制：
									</label>
									<label>
										<select id="adjustId" class="select3">
											<option value=''>
												请选择...
											</option>
										</select>
									</label>
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
									<th width="6%">
										状态
									</th>
									<th width="6%">
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
						<!-- 分页 -->
						<br />

					</div>

				</div>

			</div>

		</div>

		<div class="tip1"
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
						<input name="" id="cancel" type="button" class="cancel1"
							value="取消" />

					</td>
				</tr>
			</table>
		</div>


		<div class="tip2" style="height: 300px;">
			<div class="tip2top">
				<span>编制调整详情</span><span></span><a></a>
			</div>

			<div class="tip2info"
				style="width: 470px; height: 160px; padding: 10px; margin: 0;">
				<ul class="forminfo" style="padding: 0; margin: 0;">
					<li>
						<label>
							教师编制
						</label>
						<cite><i style="text-decoration: line-through; color: #999" id="oldAdjustName"></i>&nbsp;<em
							style="font-style: normal; color: red" id="newAdjustName"></em></cite>
					</li>
					<li>
						<label>
							编制调整说明
						</label>
						<cite><i class="vocation" id="mobilizeMark">
							
						</i></cite>
					</li>
					<li id="auditOptionHtml" style="display: none;">
						<label>
							审核说明
						</label>
						<cite><i class="vocation"  id="auditOption">
							
						</i></cite>
					</li>
				</ul>
			</div>

			<div class="tip2btn" style="text-align: center; margin:0px">
				<input name="" type="button" class="sure2" value="确定" />
				&nbsp;
			</div>
		</div>
	</body>

</html>