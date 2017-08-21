<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>评比活动管理</title>
		<%@include file="../common/commonHead.jsp"%>
		<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/master/manageComparison.js"></script>
	</head>

	<body>
		<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="comparison" name="flag" />
			</jsp:include>
		</div>
		<!-- left -->
		<div class="leftNav">
			<%@include file="../common/comparisonLeft.jsp"%>
		</div>
		<div class="content">
			<div class="place">
				<span>位置：</span>
				<ul class="placeul">
					<li>评比活动</li>
					<li>评比活动</li>
					<li>评比活动管理</li>
				</ul>
			</div>
			<div class="formbody">
				<div class="formbodyL" style="overflow: hidden; padding-bottom: 20px;">
					<div class="tabson">
		       			<ul class="seachform">
				       		<li>
								<label>
									项目名称：
								</label>
								<div class="vocation" >
				        			<input type="text" id="comparisonNameQuery" class="scinput" />
								</div>
							</li>
							<li><label>项目类型：</label>
								<div class="vocation">
									<select id="comparisonType" name="comparisonType" class="select3"></select>
								</div>
							</li>
							<li><label>项目状态：</label>
								<div class="vocation">
									<select id="comparisonStatus" name="comparisonStatus" class="select3"></select>
								</div>
							</li>
						</ul>
						<ul class="seachform">
							<li>
								<label>
									日期范围(开始日期)：
								</label>
								<input type="text" name="startDate" id="startDate"
									class="Wdate scinput"
									style="height: 32px; line-height: 32px; border-color: #a7b5bc #ced9df #ced9df #a7b5bc;"
									onClick="WdatePicker()">
									<a id="signupStartDateErr" style="color: red"></a>
							</li>
							<li>--</li>
							<li>
								<input type="text" name="endDate" id="endDate"
									class="Wdate scinput"
									style="height: 32px; line-height: 32px; border-color: #a7b5bc #ced9df #ced9df #a7b5bc;"
									onclick="WdatePicker()" />
								<a id="signupEndDateErr" style="color: red"></a>
							</li>
						  <li><a href="javascript:queryList();" class="dian3">查 询</a></li>
				        </ul>
			      	</div>
					<div class="chauxnJS jsTool">
						<span style="float: left;"> 
						<a class="huibtn_a click" style="margin-left: 6px" id="btnAdd" onclick="toAdd()">添加项目</a>
						<a class="huibtn_a click" style="margin-left: 6px" id="btnAdd" onclick="toMasterDatabase()">专家库</a>
						</span>
					</div>
					<table class="tablelist">
						<thead>
							<tr>
								<th width="10%">
									评比名称
								</th>
								<th width="10%">
									评比类型
								</th>
								<th width="5%">
									评比年度
								</th>
								<th width="7%">
									开始日期
								</th>
								<th width="7%">
									结束日期
								</th>
								<th width="7%">
									项目状态
								</th>
								<th width="21%">
									操作
								</th>
							</tr>
						</thead>
						<tbody id="queryList">
	
						</tbody>
					</table>
					<!-- 分页 -->
					<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
					<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
					<div id="pagebar" class="pagin"></div>
					<!-- 分页 -->
				</div>
			</div>
		</div>
		<!-- 项目详情 -->
		<div class="tip" style=" z-index: 1;width: 800px;margin-left: -100px" id="comparisonTip">
			<div class="tiptop">
				<span>评比活动详情</span><a href="javascript:hideMe();"></a>
			</div>
			<div class="tabson">
				<ul class="seachform">
          			<li>
						<label>
							活动名称:&nbsp;
						</label>
						<div class="vocation">
							<input class="scinput" id="comparisonName" style="margin-left: 23px" disabled="disabled"></input>
						</div>
					</li>
          			<li>
						<label>
							评比类型:&nbsp;
						</label>
						<div class="vocation">
							<input class="scinput" id="comparisonTypeName" style="margin-left: 23px" disabled="disabled"></input>
						</div>
					</li>
         		</ul>
				<ul class="seachform">
          			<li>
						<label>
							活动年度:&nbsp;
						</label>
						<div class="vocation">
							<input class="scinput" id="comparisonYear" style="margin-left: 23px" disabled="disabled"></input>
						</div>
					</li>
          			<li>
						<label>
							单位评选额度:&nbsp;
						</label>
						<div class="vocation">
							<input class="scinput" id="comparisonPlanNum" disabled="disabled"></input>
						</div>
					</li>
         		</ul>
         		<ul class="seachform">
          			<li>
						<label>
							报名开始时间:&nbsp;
						</label>
						<div class="vocation">
							<input class="scinput" id="signupStartDate" disabled="disabled"></input>
						</div>
					</li>
          			<li>
						<label>
							报名结束时间:&nbsp;
						</label>
						<div class="vocation">
							<input class="scinput" id="signupEndDate" disabled="disabled"></input>
						</div>
					</li>
         		</ul>
         		<ul class="seachform">
          			<li>
						<label>
							审核开始时间:&nbsp;
						</label>
						<div class="vocation">
							<input class="scinput" id="auditStartDate" disabled="disabled"></input>
						</div>
					</li>
          			<li>
						<label>
							审核结束时间:&nbsp;
						</label>
						<div class="vocation">
							<input class="scinput" id="auditEndDate" disabled="disabled"></input>
						</div>
					</li>
         		</ul>
         		<ul class="seachform">
          			<li>
						<label>
							结果公布时间:&nbsp;
						</label>
						<div class="vocation">
							<input class="scinput" id="publishDate" disabled="disabled"></input>
						</div>
					</li>
         		</ul>
         		<ul style="margin-left: 20px;">
          			<li>
						<label>
							参评单位:&nbsp;
						</label>
						<div style="margin-left: 88px;margin-top: -15px">
							<textarea  cols="" rows=""
							style="width: 440px;height:60px; border: #eee 1px solid;  border-color: #a7b5bc #ced9df #ced9df #a7b5bc;border-radius: 5px;"
							id="schools" disabled="disabled"></textarea>
						</div>
					</li>
         		</ul>
         		<ul style="margin-left: 20px;">
          			<li>
						<label>
							备注:&nbsp;
						</label>
						<div style="margin-left: 88px;margin-top: -15px">
							<textarea  cols="" rows=""
							style="width: 440px;height:60px; border: #eee 1px solid;  border-color: #a7b5bc #ced9df #ced9df #a7b5bc;border-radius: 5px;"
							id="memo" disabled="disabled"></textarea>
						</div>
					</li>
         		</ul>
         		<ul style="margin-left: 20px;" >
          			<li>
						<label>
							附件:&nbsp;
						</label>
						<div >
							<table border="0" cellspacing="0" cellpadding="0" style="line-height:40px;width: 100%">
		        				<tbody id="files">
		        				</tbody>
		      				</table>
						</div>
					</li>
         		</ul>
			</div>
		</div>
	</body>
</html>
