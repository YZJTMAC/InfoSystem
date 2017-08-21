<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>培训类项目学分审核</title>
<%@include file="../common/commonHead.jsp"%>
<script type=text/javascript src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/creditAuditTrain.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
		$(".select2").uedSelect({
			width : 167
		});
		$(".select3").uedSelect({
			width : 110
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
				<li><a href="jixuMegGLY_2.2.html">继教信息</a>
				</li>
				<li>学分审核</li>
				<li>培训类项目学分审核</li>
			</ul>
		</div>

		<div class="formbody">
			<div class="idTabs itab">
				<ul>
					<li><a href="#tab1" id="tabPage0" class="selected">未审核<span
							class="ctype"></span> </a></li>
					<li><a href="#tab2" id="tabPage1">已审核<span class="ctype"></span>
					</a></li>

				</ul>
			</div>

			
			<div class="tabson">
					
					<ul class="seachform">
						<li>
							<label>
								身份证号：
							</label>
							<div class="vocation">
								<input id="queryIdNumber" name="input" type="text" value=""
									class="scinput" />
							</div>
						</li>

						<li>
							<label>
								教师姓名：
							</label>
							<div class="vocation">
								<input id="queryRealName" name="input" type="text" value=""
									class="scinput" />
							</div>
						</li>
						<li style="display:none;" id="queryAudit">
							<label>
								审核状态：
							</label>
							<div class="vocation">
								<select class="select3" id="queryStatus">
									<option value="">
										请选择
									</option>
									<option value="13">
										审核通过
									</option>
									<option value="12">
										审核不通过
									</option>
								</select>
							</div>
						</li>
					</ul>

					<ul class="seachform">
						<li>
							<label>
								所在地区：
							</label>
							<input id="areaName"　name="" readonly="readonly" type="text"  value="${areaName}" class="scinput areaSelect"/>
							<input type="hidden" id="areaId"/>
							<input type="hidden" id="areaType"/>
							<input name="input2" class="btnXuan areaSelect" type="button" value="选 择"/>
						</li>

						<li>
							<label style="width: 45px;">
								&nbsp;
							</label>
						</li>
						<li>
							<label style="width: 1px;">
								&nbsp;
							</label>
						</li>
						<li>
							<input type="button" class="scbtn" id="search" value="查 询" />
						</li>
					</ul>
				</div> <!-- tabson end -->

			<div id="tab1">
				<div class="chauxnJS jsTool">
				
					<div class="vocation" style="margin-top:4px;">
			 			<select id="batchResult" class="select2">
							<option value="0">请选择...</option>
							<option value="13">合格</option>
							<option value="12">不合格</option>
						</select> 
					</div>
					
					<span style="float:left;"> 
						<label>&nbsp;审核学分：</label> 
						<input id="batchScore" name="input" type="text" class="scinput" />
						&nbsp;
						<a href="#" class="huibtn_a  " id="btnBatch" 	style="margin-left: 6px">批量审核</a> 
						<a href="javascript:history.back();" class="huibtn_a  " style=" margin-left:6px">返回</a>
					</span> 
					<span style="float:right;">
						<div class="pagin" style="margin: 0; width: 185px;">
							<div class="message">
								共
								<i class="blue" id="counts">0</i>条记录
							</div>
							<div class="vocation paginList" style="margin: 4px 6px 0 6px; right: 0px;">
								<select onchange="showInfoList();" id="pageSize" class="select3">
									<option value="10">
										每页显示10条
									</option>
									<option value="30">
										每页显示30条
									</option>
									<option value="50">
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
							<th width="5%"><input id="chkAll" type="checkbox" value="" />
							</th>
							<th width="20%">姓名</th>

							<th width="20%">身份证号</th>

							<th width="25%">学校</th>

							<th width="10%">
								<span class="periodSort">
									学时
									<img id="periodUpSort" src="<%=basePathHeader%>/static/photo/arrow_up.png"  title="升序排列" />	
									<img id="periodDownSort" src="<%=basePathHeader%>/static/photo/arrow_down.png"  title="降序排列" />	
								</span>
							</th>
							<th  width="10%">学分(兑换结果)</th>
							<th width="10%">操作</th>
						</tr>
					</thead>
					<tbody id="target">
					</tbody>
				</table>
			</div>
			<div id="tab2">
				<div class="chauxnJS jsTool">
					<span style="float:left;"> <a
						href="javascript:history.back();" class="huibtn_a  "
						style=" margin-left:6px">返回</a> </span> <span style="float:right;">
					</span>
				</div>

				<table class="tablelist">
					<thead>
						<tr>
							<th width="14%">姓名</th>
							<th width="4%">性别</th>
							<th width="5%">身份证号</th>
							<th width="20%">学校</th>
							<th width="8%">
								<span class="scoreSort">
									学分
									<img id="scoreUpSort" src="<%=basePathHeader%>/static/photo/arrow_up.png" title="升序排列" />	
									<img id="scoreDownSort" src="<%=basePathHeader%>/static/photo/arrow_down.png" title="降序排列" />	
								</span>
							</th>
							<th width="6%">审核状态</th>
						</tr>
					</thead>
					<tbody id="target2">
					</tbody>
				</table>
			</div>

			<!-- 分页 -->
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
			<!-- 分页 -->



			<!-- 页面隐藏域 -->
			<input id="isScorePublished" value="1" type="hidden" /> 
			<input id="txtProjectId" type="hidden" /> 
			<input id="userId" type="hidden" />
			
			<input id="periodSortType" type="hidden" value="asc"/>
			<input id="scoreSortType" type="hidden" value="asc"/>
			<!-- 页面隐藏域 -->
			
			 <%@include file="../common/commonAreaSelect.jsp"%>
			 <script type="text/javascript">
				lastSelect='${areaId}_${areaType}_${areaName}';
			</script>

		</div>
	</div>

	<div class="tip"  style="z-index:1">
		<div class="tiptop">
			<span>学分审核</span><a></a>
		</div>

		<table border="0" cellspacing="0" cellpadding="0"
			style="line-height:40px; margin:0 auto;">
			<tr>
				<td id="pTeacherName" colspan="2"></td>
			</tr>

			<tr>
				<td id="pscore" colspan="2"></td>
			</tr>

			<tr>
				<td>转换结果:</td>
				<td><input id="txt_fp" name="input" type="text" class="scinput" />学分
				</td>
			</tr>
			<tr>
				<td>审核结果:</td>
				<td><input type="radio" checked name="isPass" value="13" />合格
					<input type="radio" name="isPass" value="12" />不合格</td>
			</tr>
		</table>

		<table width="230" style="margin:0 auto;">
			<tr>
				<td width="130"><a href="#" class="sure dian3"
					onclick="auditOneCredit();" />确定</a></td>
				<td width="15">&nbsp;</td>
				<td width="130"><a href="#" class="cancel dian3" />取消</a></td>
			</tr>
		</table>

	</div>
</body>
</html>