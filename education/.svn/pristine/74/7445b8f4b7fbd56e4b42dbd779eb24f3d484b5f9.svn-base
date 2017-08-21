<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学分查询</title>
<%@include file="../common/commonHead.jsp"%>
<script type=text/javascript src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/scoreSearch.js"></script>
<script type="text/javascript">
$(document).ready(function(e) {
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
</head>
<body>
	<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp">
			<jsp:param value="system" name="flag" />
		</jsp:include>
	</div>
	<!-- left -->
	<div class="leftNav">
		<%@include file="../common/systemLeft.jsp"%>
	</div>
	<div class="content">
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">

				<li><a href="#">继教信息</a>
				</li>
				<li>学分查询</li>
			</ul>
		</div>
		<div class="formbody">
			<div id="usual1" class="usual">
				<div class="itab">
					<ul>
						<li style="text-align: left;">
							<a onclick="change(1);" href="#tab1" class="selected" id="tab_1">按继教板块查询</a>
						</li>
						<li style="text-align: left;">
							<a onclick="change(2);" href="#tab2" id="tab_2">按项目年度查询</a>
						</li>
						<li>
							<a onclick="change(3);" href="#tab3" id="tab_3">按项目周期查询</a>
						</li>
					</ul>
				</div>

				<div id="tab1" class="tabson">
					<div class="tabson">
						<ul class="seachform">
							<li><label>继教信息板块：</label>
								<div class="vocation">
									<select id="modelId" name="modelId" class="select3">
										<option value="0">请选择...</option>
									</select>
								</div></li>
							<li><label>教师姓名：</label> <input name="teacherName1"
								id="teacherName1" style="width: 80px" type="text" class="scinput" /></li>

							<li><label>学分范围:</label> <input name="beginScore1"
								id="beginScore1" type="text" style="width: 60px" class="scinput" />到 <input
								name="endScore1" style="width: 60px"  id="endScore1" type="text" class="scinput" /></li>
							<li><a href="#" class="dian3" onclick="showInfoList1()">查
									询</a>
							</li>

						</ul>
					</div>
					<table class="tablelist">
						<thead>
							<tr>
								<th>继教板块</th>
								<th>教师姓名</th>
								<th>工作单位</th>
								<th>总学分</th>
							</tr>
						</thead>
						<tbody id="tab1List">

						</tbody>
					</table>

				</div>


				<div id="tab2" class="tabson">

					<div class="tabson">
						<ul class="seachform">
							<li><label>项目年度</label>
								<div class="vocation">
									<select class="select3 yearpicker" name="beginYear"
										id="beginYear"></select> --
								</div></li>
							<li><label>教师姓名：</label> <input style="width: 80px" name="teacherName2" type="text"
								class="scinput" id="teacherName2" /></li>

							<li><label>学分范围:</label> <input style="width: 60px" name="beginScore2" type="text"
								class="scinput" id="beginScore2"/>到
								<input style="width: 60px" name="endScore2" id="endScore2" type="text"
								class="scinput" /></li>
							<li><a onclick="showInfoList2()" href="#" class="dian3">查 询</a>
							</li>
						</ul>
					</div>

					<table class="tablelist">
						<thead>
							<tr>
								<th>教师姓名</th>
								<th>工作单位</th>
								<th>总学分</th>
							</tr>
						</thead>
						<tbody id="tab2List">

						</tbody>
					</table>
				</div>

				<div id="tab3" class="tabson">
					<div class="tabson">
						<ul class="seachform">
							<li><label>项目年度</label>
								<div class="vocation">
									<select class="select3 yearpicker" name="beginYear2"
										id="beginYear2"></select> 到
								</div>
								<div class="vocation">
									<select class="select3 yearpicker" name="endYear"
										id="endYear"></select>
								</div></li>
							<li><label>教师姓名：</label> <input style="width: 80px" id="teacherName3" name="teacherName3" type="text"
								class="scinput" /></li>

							<li><label>学分范围:</label> <input style="width: 60px" id="beginScore3" name="beginScore3" type="text"
								class="scinput" />到<input style="width: 60px" id="beginScore3" name="endScore3" type="text"
								class="scinput" /></li>
							<li><a onclick="showInfoList3()" href="#" class="dian3">查 询</a>
							</li>
						</ul>
					</div>

					<table class="tablelist">
						<thead>
							<tr>
								<th>教师姓名</th>
								<th>工作单位</th>
								<th>总学分</th>
							</tr>
						</thead>
						<tbody id="tab3List">
						</tbody>
					</table>
				</div>


				<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
				<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
				<input id="pageSize" value="10" type="hidden" name="pageSize" />
				<div id="pagebar" class="pagin"></div>
				<br />
			</div>

		</div>
	</div>
</body>
</html>

