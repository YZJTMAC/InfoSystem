<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>培训项目查询</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/new_projectManage.js"></script>
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
					培训项目
					</li>
					<li>
						<a href="#">培训项目查询</a>
					</li>

					
					<li
						style="float: right; background: url(images/help.png) no-repeat left center; padding-left: 18px;">
						<a href="#">帮助</a>
					</li>
				</ul>
			</div>
			<div class="formbody">

				<div id="usual1" class="usual">

					<div class="itab">
						<ul>
							<li>
								<a href="<%=basePathHeader%>/edupm/projectmanage/toProjectManagePage.htm?click=20" class="selected">我的项目
								</a>
							</li>
							<li>
								<a href="<%=basePathHeader%>/edupm/projectmanage/toProjectManageOtherPage.htm?click=20&status=60">已关闭项目
								</a>
							</li>
							<%-- <li>
								<a href="<%=basePathHeader%>/edupm/projectmanage/toProjectManageOtherPage.htm?click=20&status='20,21,22'">审批中
								</a>
							</li>
							<li>
								<a  href="<%=basePathHeader%>/edupm/projectmanage/toProjectManageOtherPage.htm?click=20&status=30">筹备中
								</a>
							</li>
							<li>
								<a  href="<%=basePathHeader%>/edupm/projectmanage/toProjectManagePage.htm?click=20&status=40" id="s40">进行中
								</a>
							</li>
							<li>
								<a  href="<%=basePathHeader%>/edupm/projectmanage/toProjectManageOtherPage.htm?click=20&status=50">已结束
								</a>
							</li> 
							<li>
								<a href="<%=basePathHeader%>/edupm/projectmanage/toProjectManageOtherPage.htm?click=20&status=60">已关闭
								</a>
							</li>--%>

						</ul>

					</div>
				
					<div id="tab1" class="tabson">

						<div class="tabson">
							<ul class="seachform">
								<li>
									<label>
										项目名称：
									</label>
									<input id="projectName" name="input" type="text" class="scinput" />
								</li>
								<li>
									<label>
										项目年度：
									</label>
									<div class="vocation">
										<select class="select3 yearpicker" name="yearpicker"
											id="year">
											<option value="">
												请选择...
											</option>
											</select>
									</div>
								</li>
								<li><label>继教信息板块：</label>
								<div class="vocation">
									<select id="modelId" name="modelId" class="select3">
									</select>
								</div></li>
								<li>
									<label>
										培训形式：
									</label>
									<div class="vocation">
										<select id="projectTrainType" class="select3" name="projectTrainType">
										</select>
									</div>
								</li>


								<li>
									<a href="#" class="dian3" onclick="projectList();">查 询</a>
								</li>

							</ul>


						</div>

						<table class="tablelist">
							<thead>
								<tr>
									<th width="16%">
										项目名称
									</th>
									<th width="7%">
										开始时间
									</th>
									<th width="7%">
										结束时间
									</th>
									<th width="6%">
										项目性质
									</th>
									<th width="6%">
										培训形式
									</th>
									<th width="5%">
										培训人数
									</th>
									<th width="5%">
										创建人
									</th>
									<th width="7%">
										实施机构
									</th>
									<th width="5%">
										申报人
									</th>
									<th width="6%">
										申报时间
									</th>
									<th width="5%">
										审核人
									</th>
									<th width="6%">
										审核时间
									</th>
									<th width="5%">
										继教信息
									</th>
									<th width="20%">
										项目状态
									</th>

								</tr>
							</thead>
							<tbody id="proList1">
								
							</tbody>
						</table>

						<!-- 分页 -->
						<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
						<input id="pageIndex" value="0" type="hidden" name="pageIndex" />
						<div id="pagebar" class="pagin"></div>
						<!-- 分页 -->
					</div>

				</div>
			</div>

		</div>
	</body>
</html>