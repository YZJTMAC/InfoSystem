<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="../common/commonHead.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>承培机构任务分配</title>
		<script language="javascript" type="text/javascript"
			src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js">
		</script>
		<script type="text/javascript"
			src="<%=basePathHeader%>/javascript/common/pagination.js">
		</script>
		<script type="text/javascript"
			src="<%=basePathHeader%>/javascript/project/orgTasking.js">
		</script>
		<script type="text/javascript">
		var enableOrg = '${enableOrg}';
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

	$('#tanqi').hide();
});
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
						<a href="###">培训项目</a>
					</li>

					<li>
						承培机构任务分配
					</li>
					<li
						style="float: right; background: url(images/help.png) no-repeat left center; padding-left: 18px;">
						<a href="###">帮助</a>
					</li>
				</ul>
			</div>
			<div class="place">
				<p style="padding: 0 20px; color: #39C">
					操作提示:筹备中项目
				</p>
			</div>
			<div class="formbody">
				<div id="usual1" class="usual">
					<div class="itab">
						<ul>
							<li>
								<a onclick="change(1);" id="tab_1" href="###" class="selected">待分配
								</a>
							</li>
							<li>
								<a onclick="change(0);" id="tab_2" href="###">已分配</a>
							</li>

						</ul>
					</div>
					<div id="tab1" class="tabson">
						<div class="tabson">
							<ul class="seachform">
								<li>
									<label>
										项目名称：
									</label>
									<input id="project_name_1" name="input" type="text" class="scinput" />
								</li>
								<li>
									<label>
										项目年度：
									</label>
									<div class="vocation">
										<select id="yearpicker" class="select3 yearpicker" name="yearpicker"></select>
										--
									</div>
								</li>
								<li>
									<label>
										培训形式：
									</label>
									<div class="vocation">
										<select id="trainType" class="select3" name="yearpicker">
											<option value=""> 请选择...</option>
											<option value="1">
												远程
											</option>
											<option value="0">
												面授
											</option>
										</select>
									</div>
								</li>
								<li>
									<a id="select_1" href="#" class="dian3">查 询</a>
								</li>
							</ul>
						</div>
						<table class="tablelist">
							<thead>
								<tr>
									<th width="40%">
										项目名称
									</th>
									<th width="10%">
										项目范围
									</th>
									<th width="10%">
										计划培训人数
									</th>
									<th width="20%">
										承培机构
									</th>
									<th width="20%">
										操作
									</th>
								</tr>
							</thead>
							<tbody id="table_list_1">
							</tbody>
						</table>
						<!-- 分页 -->
						<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
						<div id="page_1"></div>
						<!-- 分页 -->
					</div>
					<div id="tab2" class="tabson" style="display: none;">

						<div class="tabson">
							<ul class="seachform">
								<li>
									<label>
										项目名称：
									</label>
									<input id="project_name_2" name="input" type="text" class="scinput" />
								</li>
								<li>
									<label>
										项目年度：
									</label>
									<div class="vocation">
										<select id="startDate" class="select3 yearpicker" name="yearpicker"></select>
										--
									</div>
								</li>
								<li>
									--
								</li>
								<li>
									<div class="vocation">
										<select id="endDate" class="select3 yearpicker" name="yearpicker"></select>
									</div>
								</li>
								<li>
									<a id="select_2" href="#" class="dian3">查 询</a>
								</li>
							</ul>
						</div>
						<table class="tablelist">
							<thead>
								<tr>
									<th>
										项目名称
									</th>
									<th>
										项目性质
									</th>
									<th>
										计划人数
									</th>
									<th>
										培训形式
									</th>
									<th>
										申报人
									</th>
									<th>
										申报时间
									</th>
									<th>
										审核状态
									</th>
									<th>
										审核人
									</th>
									<th>
										操作
									</th>
								</tr>
							</thead>
							<tbody id="table_list_2">
							</tbody>
						</table>
						<!-- 分页 -->
						<div id="page_2"></div>
						<!-- 分页 -->
					</div>
				</div>
				<div id="tanqi"
					style="width: 660px; padding: 20px; margin: -60px 0 0 -340px; display: none;">
					<div class="tabson">
						<ul class="seachform">
							<li>
								<p class="xmTool">
									项目名称： <b id="projectName"></b>
									计划培训人数：<b id="planNum"></b>
								</p>
							</li>
						</ul>
						<ul class="seachform">
							<li>
								<label> 承培机构： </label>
							</li>
							<li>
								<div id="checkboxes">
								</div>
							</li>
						</ul>
					</div>
					<table border="0" cellspacing="0" cellpadding="0"
						style="margin: 0 auto;">
						<tr>
							<td width="111">
								<input id="btnOK" name="input" type="button" class="dian3" value="确 定" />
							</td>
							<td width="100px"> &nbsp; </td>
							<td width="111">
								<input id="btnQX" name="input3" type="button" class="dian3" value="取 消"/>
							</td>
						</tr>
					</table>
					<input type="hidden" id="projectId"/>
					<input type="hidden" id="orgId"/>
				</div>
			</div>
		</div>
	</body>
</html>
