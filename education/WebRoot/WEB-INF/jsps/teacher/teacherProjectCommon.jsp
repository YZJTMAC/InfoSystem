<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>项目报名</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherProjectCommon.js"></script>
		<script type="text/javascript">
			$(document).ready(function(e) {
				$(".select3").uedSelect( {
					width : 100
				});
			});
			
			var flag= <%=request.getParameter("flag")%>;
			$(function(){
				$('#s1').removeClass("selected");
				$('#s2').removeClass("selected");
				$('#s3').removeClass("selected");
				$('#s4').removeClass("selected");
				$('#s5').removeClass("selected");
				$('#s6').removeClass("selected");
				$('#s7').removeClass("selected");
				$('#s'+flag+'').addClass("selected");
				projectList(flag);
			});
		</script>
	</head>
	<body>
      <input maxlength="100" type="hidden" name="roleId" type="text" value="<%=request.getAttribute("roleId")%>">
      <input maxlength="100" type="hidden" name="areaId" type="text" value="<%=request.getAttribute("areaId") %>" >
      <input maxlength="100" type="hidden" name="flag" type="text" value="<%=request.getAttribute("flag") %>" >
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
					<li><a href="ssadmin.html">培训项目</a></li>
					<li><a href="#">查看培训项目</a></li>
					<li>操作说明：我的项目显示当前用户的参培项目,各选项卡查询的是项目的培训级别</li>
				</ul>
			</div>
			<div class="formbody">

				<div id="usual1" class="usual">

					<div class="itab">
						<ul>
							<li>
								<a href="<%=basePathHeader%>/teacher/teacherProject/teacherProjectCommon.htm?click=9&flag=6" id="s6">我的培训项目 </a>
							</li>
							<li>
								<a href="<%=basePathHeader%>/teacher/teacherProject/teacherProjectCommon.htm?click=9&flag=1" id="s1">国培项目</a>
							</li>
							<li>
								<a href="<%=basePathHeader%>/teacher/teacherProject/teacherProjectCommon.htm?click=9&flag=2" id="s2">省级培训项目 </a>
							</li>
							<li>
								<a href="<%=basePathHeader%>/teacher/teacherProject/teacherProjectCommon.htm?click=9&flag=3" id="s3">地市培训项目</a>
							</li>
							<li>
								<a href="<%=basePathHeader%>/teacher/teacherProject/teacherProjectCommon.htm?click=9&flag=4" id="s4">区县培训项目 </a>
							</li>
							<li>
								<a href="<%=basePathHeader%>/teacher/teacherProject/teacherProjectCommon.htm?click=9&flag=5" id="s5">校本培训项目 </a>
							</li>
							<li>
								<a href="<%=basePathHeader%>/teacher/teacherProject/teacherProjectCommon.htm?click=9&flag=7" id="s7">自由报名项目 </a>
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
									<input maxlength="100" name="input" type="text" class="scinput"
										id="projectName" />
								</li>
								
								<li>
									<label>
										项目年度：
									</label>
									<div class="vocation">
										<select class="select3 yearpicker" name="yearpicker"
											id="beginDate">
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
										<select class="select3 yearpicker" name="yearpicker"
											id="endDate">
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
										开始时间
									</th>
									<th>
										结束时间
									</th>

									<th>
										培训形式
									</th>
									<th>
										项目性质
									</th>
									<th>
										报名方式
									</th>
									<th>
										培训人数
									</th>

									<th>
										操作
									</th>
								</tr>
							</thead>
							<tbody id="proList">

							</tbody>
						</table>
						<!-- 分页 -->
						<input id="sizePerPage" type="hidden" value="10"
							name="sizePerPage" />
						<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
						<div id="pagebar" class="pagin"></div>
						<!-- 分页 -->

					</div>


					<!--1.3.2 end-->



				</div>

			</div>

		</div>
<div class="tip">
    	<div class="tiptop"><span>选择培训机构</span><a></a></div>
        
      <div class="tipinfo">
      <div class="tipright" >
       </div>
        <ul class="forminfo" >
    <li> 
		<div class="vocation">
			   项目名称:<a id="projectName22"></a>
		</div>
    </li>
        <li> 
		<div class="vocation" id="organizationName">
			   <a id="url"></a>
		</div>
    	</li>
  
        </ul>
        
      </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="保存" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>		
		
		
	</body>
</html>