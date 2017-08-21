<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>年度证书模板设置</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type=text/javascript src="<%=basePathHeader%>/javascript/common/pagination.js"> </script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/certificateList.js"> </script>
		<script type="text/javascript">
			var queryYear = '${year}';
			
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
						年度证书模版设置
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
									<option value="">请选择</option>
								</select>
							</div>
						</li>
						<li>
							<label>
								&nbsp;
							</label>
							<input type="button" class="scbtn" onclick="showInfoList();"  value="查 询" />
						</li>

					</ul>
				</div>

				<div class="chauxnJS jsTool">
					<span style="float: left;"> <a
						href="<%=basePathHeader%>/furtheredu/certificate/certificateAddPage.htm?type=1&click=3"
						class="huibtn_a click" style="margin-left: 6px">添加</a>
					</span>
					<span style="float: right;">
						<div class="pagin" style="margin: 0; width: 180px;">
							<div class="message">
								共
								<i class="blue" id="totleCount">0</i>条记录
							</div>
							<div class="vocation paginList"
								style="margin: 4px 6px 0 6px; right: 0px;">
								<select class="select3">
									<option>
										每页显示10条
									</option>
									<option>
										每页显示30条
									</option>
									<option>
										每页显示50条
									</option>
								</select>
							</div>

						</div>
					 </span>
				</div>
				<table class="tablelist">
					<thead>
						<tr>
							<th width="20%">
								年度
							</th>
							<th width="30%">
								模板名称
							</th>
							<th width="20%">
								模板状态
							</th>
							<th width="30%">
								操作
							</th>
						</tr>
					</thead>
					<tbody id="targetList">
					</tbody>
				</table>

				<!-- 分页 -->
				<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
				<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
				<div id="pagebar" class="pagin">
				</div>
				<!-- 分页 -->

			</div>
			<br/>
		</div>
	</body>

</html>
