<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>年度考核设置</title>
		<%@include file="../common/commonHead.jsp"%>
		<%@include file="../common/commonAreaSelect.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/commonValidate.js"></script>
		<script type=text/javascript src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/targetManage.js"></script>
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
						继教证书
					</li>
					<li>
						年度考核设置
					</li>
				</ul>
			</div>

			<div class="formbody">

				<div class="tabson">
					<ul class="seachform" style="padding-left: 23px;">

						<li>
							<label>
								培训年度：
							</label>
							<div class="vocation">
								<select id="queryYear" class="select3 yearpicker">
									<option value="">
										请选择
									</option>
								</select>
							</div>
						</li>
						<li>
							<label>
								地区：
							</label>
							<div class="vocation">
								<input readonly="readonly" name="input" id="tss" value="<%=request.getAttribute("areaName") %>" 
									type="text" style="width: 320px;" readonly="readonly"
									class="scinput areaSelect" />
								<input name="input2" type="button" value="选 择"
									class="btnXuan areaSelect" />
							</div>
						</li>


						<li>
							<label>
								&nbsp;
							</label>
							<input type="button" class="scbtn" onclick="showInfoList();"
								value="查 询" />
						</li>

					</ul>
				</div>

				<div class="chauxnJS jsTool">
					<span style="float: left;"> <a href="javascript:;"
						class="huibtn_a click" style="margin-left: 6px">添加</a> </span>
					<span style="float: right;">
						<div class="pagin" style="margin: 0; width: 180px;">
							<div class="message">
								共
								<i class="blue" id="totleCount">0</i>条记录
							</div>
							<div class="vocation paginList"
								style="margin: 4px 6px 0 6px; right: 0px;">
								<select id="pageSize" class="select3">
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
							<th width="25%">
								年度
							</th>
							<th width="25%">
								地区
							</th>
							<th width="25%">
								总学分要求
							</th>
							<th width="25%">
								操作
							</th>
						</tr>
					</thead>
					<tbody id="targetList">
					</tbody>
				</table>

				<!-- 分页 -->
				<INPUT id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
				<INPUT id="pageIndex" value="1" type="hidden" name="pageIndex" />
				<div id="pagebar" class="pagin">
				</div>
				<!-- 分页 -->


				<div class="tip">
					<div class="tiptop">
						<span>年度考核添加</span><a></a>
					</div>

					<div class="tipinfo">

						<ul class="forminfo" style="padding: 0; margin: 0;">
							<li>
								<label style="width: 60px;">
									年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度：
								</label>
								<div class="vocation">
									<select class="select2 yearpicker" name="yearpicker" id="year"></select>
								</div>
							</li>
							<li>
								<label style="width: 60px;">
									考核地区：
								</label>
								<div class="vocation">
									<input readonly="readonly" name="input" id="tss1" value=""
										type="text" style="width: 220px;" onclick="clearPCD();"
										class="scinput areaSelect" />
									<input name="input2" type="button" value="选 择"
										class="btnXuan areaSelect" />
								</div>
							</li>
							<li>
								<label style="width: 60px;">
									总&nbsp;要&nbsp;求&nbsp;：
								</label>
								<%--<input id="classPeriod" name="" type="text" class="scinput"
									style="width: 65px;" />
								&nbsp;学时&nbsp;
								--%><input id="classScore" name="" type="text" class="scinput"
									style="width: 65px;" />
								&nbsp;学分
							</li>
							<li>
								<label style="width: 60px;">
							&nbsp;
							</label>
							<div id="errorMsg" style="color:#c00"></div>
							</li>
						</ul>


					</div>
					

					<div class="tipbtn">
						<input id="targetId" type="hidden" value="0" />
						<input name="" type="button" class="sure" value="保存" />
						&nbsp;
						<input name="" type="button" class="cancel" value="取消" />
					</div>

				</div>

			</div>


		</div>

		<div class="tip0"
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
						<table style="width: 60%">
							<tr>
								<td align="center"  id="toPage"></td>
								<td  align="center">
									<input name="" id="toCancel" style="display: none"
										type="button" class="cancel1" value="取消" />
								</td>
							</tr>
						</table>
						
						
					</td>
				</tr>
			</table>
		</div>
		<!-- 标识选择地区的时候是新建选择地区还是查询列表选择地区 -->
		<input type="hidden" name="flag" id="flag" value="0" />
		<input type="hidden" name="schoolProvinceId" id="schoolProvinceId"
			value="" />
		<input type="hidden" name="schoolCityId" id="schoolCityId" value="" />
		<input type="hidden" name="schoolDistrictId" id="schoolDistrictId"
			value="" />
		<input type="hidden" name="schoolId2" id="schoolId2" value="" />
		
		<input type="hidden" name="yearStr" id="yearStr" value="" />
		<input type="hidden" name="cityStr" id="cityStr" value="" />
	</body>

</html>
