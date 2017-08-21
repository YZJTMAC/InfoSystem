<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>继教统计</title>
<%@include file="../common/commonHead.jsp"%>
<%-- <script type="text/javascript" src="<%=basePathHeader%>/javascript/common/jquery.battatech.excelexport.min.js" charset="utf-8"></script> --%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/stats/furtherStatsPage.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
		$(".select2").uedSelect({
			width : 167
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
				<li><a>继教统计</a></li>
				<li><a>合格率=每个人一年中总学分达到按年度考核设置中地区总学分算为合格的人数和/参加人数</a></li>
			</ul>
		</div>
		<div class="formbody">
			<div class="idTabs itab">
				<ul>
					<li><a href="#tab1" id="tabPage0" class="selected">年度培训人次<span
							class="ctype"></span> </a>
					</li>
					<li><a href="#tab2" id="tabPage1">教师人数<span class="ctype"></span>
					</a>
					</li>
                    
				</ul>
			</div>
			<div class="tabson">
				<ul class="seachform">
					<li><label>项目年度：</label>
					</li>
					<li><select id="projectYear" name="select"
						class="select2 yearpicker"></select>
					</li>

				</ul>
			</div>
			

			<div id="tab1" class="tabson">
				<div class="chauxnJS jsTool">
					<span style="float:left;">
						<div class="vocation" style="margin:4px 0px 0 6px;">
							 
						</div>
					 
					</span> 
					<span style="float:right;">
						<div class="pagin" style="margin:0; width:180px;">
							 
							<div class="vocation paginList"
								style=" margin:4px 6px 0 6px;right:6px;">
								<!--  <a href="#"  id="btnExport" class="huibtn_a">导出</a> -->
								  <a id="btnBack" href="furtherStatsPage.htm?click=901"   class="huibtn_a">返回</a> 
							</div>
	
						</div> 
					</span>
				</div>
				<table class="tablelist" id="tableTimes">
				
					<thead>
						<tr>
							<th width="20%"></th>
							<th width="20%">编号</th>
							<th width="20%">年度</th>
							<th width="20%">年度培训人次</th>
							<th width="20%">合格率</th>
						</tr>
					</thead>

					<tbody id="tbTimes">

					</tbody>
				</table>
			</div>

			<div id="tab2" class="tabson">
			
				<table class="tablelist">
					<thead>
						<tr>
							<th width="20%"></th>
							<th width="20%">编号</th>
							<th width="20%">年度</th>
							<th width="20%">教师人数</th>
							<th width="20%">年度合格率</th>
						</tr>
					</thead>

					<tbody id="tbTeacher">

					</tbody>
				</table>
			</div>

		</div>
	</div>
</body>
</html>
