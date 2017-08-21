<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>继教信息</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type=text/javascript src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/eduManage.js"></script>
		<script type="text/javascript">
			lastSelect = '${areaId}_${areaType}_${areaName}';
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
						<a href="#">继教信息</a>
					</li>
					<li>
						继教信息管理
					</li>
				</ul>
			</div>

			<div class="formbody">

				<div class="tabson">


					<ul class="seachform">

						<li>
							<label>
								项目名称：
							</label>
							<div class="vocation">
								<input name="input" id="projectName" type="text" value="" class="scinput" />
							</div>
						</li>


						<!--  
    <li>
            <label>培训年度：</label>
            <input type="text" class="Wdate scinput" style="height:32px;line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;" onclick="WdatePicker()" /> -- <input type="text" class="Wdate scinput" style="height:32px; line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;" onclick="WdatePicker()" />
          </li>-->
						<li>
							<label>
								培训年度：
							</label>
							<div class="vocation">
								<select id="queryYearStart" class="select4 yearpicker"
									name="yearpicker" id="yearpicker">
								</select>
							</div>
						</li>
						<li>
							至
						</li>
						<li>
							<div class="vocation">
								<select id="queryYearEnd" class="select4 yearpicker"
									name="yearpicker" id="yearpicker">
								</select>
							</div>
						</li>

						<li>
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
									<option value="11">
										未审核
									</option>
								</select>
							</div>
						</li>




					</ul>
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
					</ul>

					<ul class="seachform">
						<li>
							<label>
								参培所在地区：
							</label>
						</li>
						<li>
							<input id="areaName" name="" readonly="readonly" type="text"  value="${areaName}" class="scinput areaSelect"/>
							<input type="hidden" id="areaId" />
							<input type="hidden" id="areaType" />
							<input name="input2" class="btnXuan areaSelect" type="button" value="选 择"/>
						</li>

						<li>
							<label style="width: 45px;">
								&nbsp;
							</label>
						</li>
						<li>
							<label style="width: 45px;">
								&nbsp;
							</label>
						</li>
						<li>
							<label style="width: 45px;">
								&nbsp;
							</label>
						</li>
						<li>
							<input type="button" onClick="showInfoList();" class="scbtn"
								value="查 询" />
						</li>
					</ul>
				</div>
				<div class="chauxnJS jsTool">
					<span style="float: left;">
						<div class="vocation" style="margin: 4px 6px 0 6px;">

						</div> <a href="###" class="huibtn_a batchAudit"
						style="margin-right: 8px;">批量审核</a> <a href="###"
						class="huibtn_a batchDelete" style="margin-right: 8px;">批量删除</a> </span>
					<span style="float: right;">
						<div class="pagin" style="margin: 0; width: 180px;">
							<div class="message">
								共
								<i class="blue" id="totleCount">0</i>条记录
							</div>
							<div class="vocation paginList"
								style="margin: 4px 6px 0 6px; right: 0px;">
								<select id="pageSize"  class="select3">
									<option value="100">每页显示100条</option>
	    							<option value="300">每页显示300条</option>
	    							<option value="500">每页显示500条</option>
								</select>
							</div>

						</div> </span>
				</div>
				<table class="tablelist">
					<thead>
						<tr>
							<th>
								<input id="chk_all" name="" type="checkbox" value="" />
							</th>
							<th>
								年度
							</th>
							<th>
								项目名称
							</th>
							<th>
								身份证号
							</th>
							<th>
								教师姓名
							</th>
							<th>
								所在地区
							</th>
							<th>
								培训状态
							</th>
							<th>
								学时/学分
							</th>
							<th>
								审核状态
								<i class="sort"><img src="<%=basePathHeader%>/images/px.gif" />
								</i>
							</th>
							<th>
								操作
							</th>
						</tr>
					</thead>

					<tbody id="targetList"></tbody>

				</table>

				<!-- 分页 -->
				<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
				<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
				<div id="pagebar" class="pagin"></div>
				<!-- 分页 -->
				<!-- 区域选择 -->
   				<%@include file="../common/commonAreaSelect.jsp"%>
   				
   				<!-- 审核box -->
				<div class="tip">
					<div class="tiptop">
						<span>继教信息审核</span><a></a>
					</div>

					<div class="tipinfo">
						<ul class="forminfo">
							<li>
								<label>
									是否通过
								</label>
								<cite><input name="auditTeacher" type="radio"
										value="true" checked="checked" />通过&nbsp;&nbsp;&nbsp;&nbsp;<input
										name="auditTeacher" type="radio" value="false" />不通过</cite>
							</li>
							<li>
								<label>
									审核意见
								</label>
								<textarea id="auditMemo" name="" cols="" rows=""
									class="textinput" style="width: 230px; height: 130px;"></textarea>
							</li>
						</ul>
					</div>
					<div class="tipbtn" style="padding-left: 50px;">
						<input id="auditIds" type="hidden" value="" />
						<input name="" type="button" class="sure" value="提交" />
						&nbsp;
						<input name="" type="button" class="cancel" value="取消" />
					</div>
				</div>
				<!-- 审核box -->
				<br/>
				
				
				<div class="tip2">
					<div class="tip2top">
						<span>继教信息删除</span><a></a>
					</div>

					<div class="tip2info">
						<ul class="forminfo">
							<li>
								<label>
									删除原因：
								</label>
								<textarea id="deleteMemo" name="" cols="" rows=""
									class="textinput" style="width: 230px; height: 100px;"></textarea>
							</li>
							<li>
								<label>
									提示：
								</label>
								<cite>删除后，该教师在该项目中的继教信息将会丢失，除非在项目管理中再为该教师添加一份成绩。</cite>
							</li>
						</ul>
					</div>
					<div class="tip2btn" style="padding-left: 50px;">
						<input name="" type="button" class="sure2" value="删除" />
						&nbsp;
						<input name="" type="button" class="cancel2" value="不删除" />
					</div>
				</div>
				<br/>
						 
			</div>
				
		</div>   
	</body>

</html>
