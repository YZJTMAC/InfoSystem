<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/projectForAllocateByArea.js"></script>
		<script type="text/javascript">
			var flag= <%=request.getParameter("flag")%>
			
			$(document).ready(function(e) {
				$(".select3").uedSelect( {
					width : 100
				});
				
				$('#s1').removeClass("selected");
				$('#s2').removeClass("selected");
				$('#s3').removeClass("selected");
				$('#s4').removeClass("selected");
				$('#s5').removeClass("selected");
				$('#s'+flag+'').addClass("selected");
				projectList(flag);
			});
		</script>

		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>名额分配</title>
	</head>
	<body>
      <input type="hidden" name="roleId" type="text" value="<%=request.getAttribute("roleId")%>">
      <input type="hidden" name="areaId" type="text" value="<%=request.getAttribute("areaId") %>" >
      <input type="hidden" name="flage" type="text" value="<%=request.getAttribute("flag") %>" >
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
						<a href="ssadmin.html">培训项目</a>
					</li>
					<li>
						培训名额分配
					</li>
					<li>
						操作说明：对于报名方式是层级分配/报名的项目，需要往下分配名额。
					</li>
				</ul>
			</div>
			<div class="formbody">

				<div id="usual1" class="usual">

					<div class="itab">
						<ul>
							<li>
								<a href="<%=basePathHeader%>/edupm/projectmanage/toAllocateByAreaPage.htm?click=23&flag=1" id="s1">国培 </a>
							</li>
							<li>
								<a href="<%=basePathHeader%>/edupm/projectmanage/toAllocateByAreaPage.htm?click=23&flag=2" id="s2">省培 </a>
							</li>
							<li>
								<a href="<%=basePathHeader%>/edupm/projectmanage/toAllocateByAreaPage.htm?click=23&flag=3" id="s3">市培</a>
							</li>
							<li>
								<a href="<%=basePathHeader%>/edupm/projectmanage/toAllocateByAreaPage.htm?click=23&flag=4" id="s4">县培 </a>
							</li>
							<li>
								<a href="<%=basePathHeader%>/edupm/projectmanage/toAllocateByAreaPage.htm?click=23&flag=5" id="s5">校本 </a>
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
									<input name="input" type="text" class="scinput"
										id="projectName" />
								</li>
								
								<li>
									<label>
										项目年度：
									</label>
									<div class="vocation">
										<select class="select3 yearpicker" name="yearpicker" id="beginDate">
											<option value="">请选择</option>
										</select>
										--
									</div>
								</li>
								<li>
									<label>
										--

									</label>

									<div class="vocation">
										<select class="select3 yearpicker" name="yearpicker" id="endDate">
											<option value="">请选择</option>
										</select>
									</div>
								</li>
								

								<li>
									<input name="" id="toPage" onclick="qryPro();" type="button" class="sure1" value="查 询" />
								</li>

							</ul>


						</div>

						<div class="chauxnJS jsTool" style="display: none;">

							<span style="float: right;">
								<div class="pagin" style="margin: 0; width: 180px;">
									<div class="message">
										共
										<i class="blue">1256</i>条记录
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

								</div> </span>
						</div>


						<table class="tablelist">
							<thead>
								<tr>
									<th>
										项目名称
									</th>
									<th>
										报名模式
									</th>
									<th>
										培训范围
									</th>
									<th>
										申报人
									</th>
									<th>
										计划培训人数
									</th>
									<th>
										我的名额
									</th>
									<th>
										创建人
									</th>
									<th>
										实施机构
									</th>
									<th>
										审核人
									</th>
									<th>
										项目状态
									</th>

									<th>
										操作
									</th>
								</tr>
							</thead>
							<tbody id="proList1">

							</tbody>
						</table>
						<!-- 分页 -->
						<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
						<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
						<div id="pagebar" class="pagin"></div>
						<!-- 分页 -->

					</div>


					<!--1.3.2 end-->



				</div>

			</div>

		</div>
	</body>
</html>