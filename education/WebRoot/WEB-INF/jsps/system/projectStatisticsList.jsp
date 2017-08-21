<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="../common/commonHead.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目汇总统计</title>
<script type="text/javascript">
	$(document).ready(function(e) {
		$(".select2").uedSelect({
			width : 167
		});
		$(".select3").uedSelect({
			width : 100
		});

	});
</script>
<script type="text/javascript"
	src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript"
	src="<%=basePathHeader%>/javascript/system/projectStatisticsList.js"></script>
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
				<li><a href="#">培训实施机构</a></li>
				<li><a href="#">项目汇总统计</a></li>
				<li><a href="#" style="color:red">有学员报名的项目会显示数据；合格人数是成绩导入合格的人数和。合格率=合格人数/实际培训人数</a></li>
			</ul>
		</div>
		<div class="formbody">
		
			<div class="idTabs itab">
			<ul id="tt">
					<li><a href="#tab1" id="tabPage0" class="selected">按项目统计<span
							class="ctype"></span> </a>
					</li>
					<li><a href="#tab2" id="tabPage1">按板块统计<span class="ctype"></span>
					</a>
					</li>
					<li><a href="#tab3" id="tabPage2">按地区统计<span class="ctype"></span>
					</a>
					</li>
				</ul>
			</div>
			<div class="tabson">
			<ul class="seachform" id="selectAreaId">
					<li><label> 参培所在地区： </label>
					</li>
					<li>
					    <input id="areaName" name="" readonly="readonly"
						type="text" value="${areaName}" class="scinput areaSelect" /> 
						<input	type="hidden" id="areaId" /> 
						<input type="hidden" id="areaType"/>
						<input name="input2" class="btnXuan areaSelect" type="button"
						value="选 择" />
					</li>
				</ul>
				</div>
			<div id="tab1" class="tabson">
			<ul class="seachform">
					<li>
						<label>继教板块:</label>
						<div class="vocation">
							<select class="select2" id="eduModelType">
					      		<option value="">请选择</option>
					      	</select>
						</div>
					</li>
					<li><label> 项目名称： </label> <input id="projectName"
						name="input" type="text" class="scinput" />
					</li>
					<li><label> 项目性质: </label>
						<div class="vocation">
							<select name="select" class="select2" id="projectScope"></select>
						</div>
					</li>
					<li><label> 项目年度： </label>
					</li>
					<li><select id="year" name="select" class="select3 yearpicker"></select>
					</li>
					
				<li><input id="select" name="input2" type="button"
						class="dian3" value="查 询" />
					</li>
				
						
				</ul>
			<table class="tablelist">
				<thead>
					<tr>
						<th width="20%">项目</th>
						<th width="8%">项目学时</th>
						<th width="8%">项目年度</th>						
						<th width="8%">计划培训人数</th>
						<th width="8%">实际培训人数</th>
						<th width="8%">合格人数</th>
						<th width="8%">不合格人数</th>
						<th width="10%">未有(/未导入)成绩人数</th>
						<th width="8%">合格率</th>
					</tr>
				</thead>
				<tbody id="project_list">
				</tbody>
			</table>
			</div>
			<div id="tab2" class="tabson">
				<ul class="seachform">
					<li><label> 继教板块： </label>
						<div class="vocation">
							<select id="modelId" name="modelId" class="select3">
								<option >请选择...</option>
							</select>
						</div>
					</li>
					<li><label> 项目性质: </label>
						<div class="vocation">
							<select name="select" class="select2" id="modelProjectScope"></select>
						</div></li>
					<li><label> 项目年度： </label></li>
					<li><select id="modelYear" name="select"
						class="select3 yearpicker"></select></li>
					<li><input id="modelSelect" name="input2" type="button"
						class="dian3" value="查 询" /></li>
				</ul>
				<table class="tablelist">
					<thead>
						<tr>
							<th width="20%">模板名称</th>
							<th width="8%">培训人数</th>
							<th width="8%">合格人数</th>
							<th width="8%">不合格人数</th>
							<th width="10%">未有(/未导入)成绩人数</th>
							<th width="8%">合格率</th>
						</tr>
					</thead>

					<tbody id="model_list">
					</tbody>
				</table>
			</div>
               <div id="tab3" class="tabson">
				<ul class="seachform">
					
					<li><label> 项目性质: </label>
						<div class="vocation">
							<select name="select" class="select2" id="areaProjectScope"></select>
						</div></li>
					<li><label> 项目年度： </label></li>
					<li><select id="areaYear" name="select"
						class="select3 yearpicker"></select></li>
					<li><input id="areaSelect" name="input2" type="button"
						class="dian3" value="查 询" /></li>
				</ul>
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
								  <a id="btnBack" onclick="returnArea()"   class="huibtn_a">返回</a> 
							</div>
	
						</div> 
					</span>
				</div>
				<table class="tablelist">
					<thead>
						<tr>
							<th width="20%">地区</th>
							<th width="8%">编号</th>
							<th width="8%">培训人数</th>
							<th width="8%">合格人数</th>
							<th width="8%">不合格人数</th>
							<th width="10%">未有(/未导入)成绩人数</th>
							<th width="8%">合格率</th>
						</tr>
					</thead>

					<tbody id="area_list">
					</tbody>
				</table>
			</div>

			<!-- 分页 -->
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin">
			
			</div>
			<!-- 分页 -->
			<%@include file="../common/commonAreaSelect.jsp"%>
			<script type="text/javascript">
				lastSelect = '${areaId}_${areaType}_${areaName}';
				var initArea = '${areaId}_${areaType}_${areaName}';								
			</script>
		</div>
	</div>
</body>
</html>
