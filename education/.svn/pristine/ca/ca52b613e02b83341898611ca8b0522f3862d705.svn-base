<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>培训项目申报</title>

		<%@include file="../common/commonHead.jsp"%>
		<link />
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript">
			var status= <%=request.getParameter("status")%>
		</script>
		<script type="text/javascript" 	src="<%=basePathHeader%>/javascript/project/Two_projectDeclare.js"></script>
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
						<a href="ssadmin.html">培训项目</a>
					</li>
					<li>
						培训项目申报
					</li>
					<li>
						操作提示：实施机构管理员可下载申报模板进行填写申报，审核通过后可通过切换审核通过标签查看详情
					</li>
				</ul>
			</div>

			<div class="formbody">

				<div id="usual1" class="usual">

					<div class="itab">
						<ul>
							<li>
								<a onclick="change(1);" id="tab_1" href="#tab1" class="selected">待申报项目
								</a>
							</li>
							<!-- 增加一个已申报项目 -->
							<li>
								<a onclick="change(4);" id="tab_4" href="#tab4" >已申报项目
								</a>
							</li>
							<li>
								<a onclick="change(2);" id="tab_2" href="#tab2">审批通过
								</a>
							</li>
							<li>
								<a onclick="change(3);" id="tab_3" href="#tab2">审批未通过
								</a>
							</li>
						</ul>
					</div>

					<!-- 待申报项目 -->
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
									--
								</li>
								<li>
									<div class="vocation">
										<select class="select3 yearpicker" name="yearpicker" id="endDate">
											<option value="">请选择</option>
										</select>
									</div>
								</li>


								<li>
									<a href="#" class="dian3" id="select_1">查 询</a>
								</li>

							</ul>


						</div>

						<%--<div class="chauxnJS jsTool">
							<span style="float: left;"> <a
								href="<%=basePathHeader%>/edupm/projectmanage/toAddProPage.htm?click=0"
								class="huibtn_a  " style="margin-left: 6px">添加</a>&nbsp; </span>
						</div>--%>


						<table class="tablelist">
							<thead>
								<tr>
									<th width="28%">
										项目名称
									</th>
									<th>
										开始时间
									</th>
									<th>
										结束时间
									</th>
									<th>
										继教信息
									</th>
									<th>
										培训人数
									</th>
									<th>
										培训形式
									</th>
									<th>
										项目性质
									</th>
									<th width="6%">
										项目创建人
									</th>
									<th>
										操作
									</th>
								</tr>
							</thead>
							<tbody id="table_list_1">

							</tbody>
						</table>
						<!-- 分页 -->
						<!-- 分页 -->
					</div>
	
					<!-- 审批通过 -->			
					<div id="tab2" class="tabson" style="display: none;">  
				      <div class="tabson">
				       <ul class="seachform">
				       <li>
													<label>
														项目名称：
													</label>
													<input name="input" type="text" class="scinput"
														id="projectName2" />
												</li>
												<li>
													<label>
														项目年度：
													</label>
													<div class="vocation">
														<select class="select3 yearpicker" name="yearpicker" id="beginDate2">
															<option value="">请选择</option>
														</select>
														--
													</div>
												</li>
						  						<li>--</li>
											    <li>
										            <div class="vocation">   
											            <select  class="select3 yearpicker" name="yearpicker" id="endDate2">
															
											            </select>  
													</div> 
									          	</li>
							
						 
				           <li><a href="#" class="dian3" id="select_2">查 询</a></li>
				           
				        </ul>
						
					   
				      </div>
				    
				    <table class="tablelist">
				    	<thead>
				    	<tr>
				        <th>项目名称</th>
				        <th>培训类型</th>
				        <th>计划人数</th>
				        <th>培训形式</th>
						<th>申报人</th>
						<th>申报时间</th>
				        <th>审核状态</th>
				        <th>审核人</th>
				        <th>审核时间</th>
				        <th>操作</th>
				        </tr>
				        </thead>
				        <tbody id="table_list_2">
				        
				    
				        </tbody>
				    </table>
				    	<!-- 分页 -->
						<!-- 分页 -->
					</div>

					<!-- 审批未通过 -->
					<div id="tab3" class="tabson" style="display: none;">  
					      <div class="tabson">
					      <ul class="seachform">
					       <li>
														<label>
															项目名称：
														</label>
														<input name="input" type="text" class="scinput"
															id="projectName3" />
													</li>
													<li>
														<label>
															项目年度：
														</label>
														<div class="vocation">
															<select class="select3 yearpicker" name="yearpicker" id="beginDate3">
																<option value="">请选择</option>
															</select>
															--
														</div>
													</li>
							  <li>--</li>
							   <li>
					            <div class="vocation">   <select  class="select3 yearpicker" name="yearpicker" id="endDate3">
					            							<option value="">请选择</option>
					            						</select>  
								 </div> 
					          </li>
								
							 
					           <li><a href="#" class="dian3" id="select_3">查 询</a></li>
					           
					        </ul>
							
						   
					      </div>
					    
					    <table class="tablelist">
					    	<thead>
					    	<tr>
					        <th width="20%">项目名称</th>
					        <th width="8%">培训类型</th>
					        <th width="5%">计划人数</th>
					        <th width="8%">培训形式</th>
							<th width="6%">申报人</th>
							<th width="12%">申报时间</th>
					        <th width="10%">审核状态</th>
					        <th width="4%">审核人</th>
					        <th width="12%">审核时间</th>
					        <th width="25%">操作</th>
					        </tr>
					        </thead>
					        <tbody id="table_list_3">
					        
					    
					        </tbody>
					    </table>
					    	<!-- 分页 -->
							<!-- 分页 -->
						</div>
						
						<!-- 已申报项目 -->				
						<div id="tab4" class="tabson" style="display: none;">

							<div class="tabson">
								<ul class="seachform">
									<li>
										<label>
											项目名称：
										</label>
										<input name="input" type="text" class="scinput"
											id="projectName4" />
									</li>
									<li>
										<label>
											项目年度：
										</label>
										<div class="vocation">
											<select class="select3 yearpicker" name="yearpicker" id="beginDate4">
												<option value="">请选择</option>
											</select>
											--
										</div>
									</li>
									<li>
										--
									</li>
									<li>
										<div class="vocation">
											<select class="select3 yearpicker" name="yearpicker" id="endDate4">
												<option value="">请选择</option>
											</select>
										</div>
									</li>
	
	
									<li><a href="#" class="dian3" id="select_4">查 询</a></li>
	
								</ul>
	
	
							</div>

							<%--<div class="chauxnJS jsTool">
								<span style="float: left;"> <a
									href="<%=basePathHeader%>/edupm/projectmanage/toAddProPage.htm?click=0"
									class="huibtn_a  " style="margin-left: 6px">添加</a>&nbsp; </span>
							</div>--%>

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
											继教信息
										</th>
										<th>
											培训人数
										</th>
										<th>
											培训形式
										</th>
										<th>
											项目性质
										</th>
										<th>
											申报人
										</th>
										<th >
											操作
										</th>
									</tr>
								</thead>
								<tbody id="table_list_4">
	
								</tbody>
							</table>
						<!-- 分页 -->
						<!-- 分页 -->
					</div>


					<!--1.3.2 end-->
				</div>
				<!-- 分页 -->
				<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			    <input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			    <div id="pagebar" class="pagin"></div>
				<!-- 分页 -->
			</div>
			
		</div>
		
		<!-- 培训项目申报模态框 -->	
		<div id="myModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h3 id="projectName10"></h3><label>附件上传：【支持上传图片，文本文件，OFFICE 文档，压缩包等】</label>
		  </div>
		  <div class="modal-body">
		    <form id="declareForm" enctype="multipart/form-data" method="post">
				<input id="projectId" name="projectId" type="hidden" value="" />
				<input id="projectName3" name="projectName" type="hidden" value="" />
				<input id="type" name="type" type="hidden" value="declare" />
				<table id="hasUpload" class="table table-hover table-condensed">
				</table>
				<table id="noUpload" class="table">
				</table>
			</form>
		  </div>
		  <div class="modal-footer">
		  	<button class="btn btn-primary" id="addFile" onclick="addMore()">增加文件</button>
		   <!--  <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button> -->
		    <button class="btn btn-primary" onclick="declare()">申报</button>
		  </div>
		</div>
		<!-- 培训项目申报模态框结束 -->	
		
		<!-- 审核意见对话框开始-->	
		<div id="auditReasonModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h3 id="projectName9">审核失败意见：</h3>
		  </div>
		  <div class="modal-body">
				<div id="reason"></div>
		  </div>
		  <div class="modal-footer">
		 	<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		  </div>
		</div>
		<!-- 审核意见模态对话框结束 -->
 
	    <!-- 实施机构申报模板模态框 -->	
		<div id="declareViewModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h3 id="projectName_">培训项目申报模板</h3>
		  </div>
		  <div class="modal-body">
				<table id="viewTable" class="table table-hover table-condensed">
				</table>
		  </div>
		  <div class="modal-footer">
		   <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		  </div>
		</div>
		<!-- 实施机构申报模板模态框结束 -->	


		<div id="alertDiv" class="tip"  style="height: 200px; margin-top: 200px;">
		    	<div class="tiptop"><span>提示信息</span></div>
				<div class="tipinfo">
		      	<div class="tipright" style="padding:0; margin:0;"></div>
		        	<ul class="forminfo" style="padding:0; margin:0;">
						<li >
					  		<h4 style="margin-left: 120px;" id="alertInfo">申报成功，请等待审核</h4>
					  	</li>
				    </ul>
				</div>
				<div class="tipbtn"  style="margin-top: -130px;"> 
		        	<input style="margin-left: 70px;"  type="button"  class="sure" value="确定" onclick="hideAlert();"/>&nbsp;
		        </div>
		</div>
	</body>

</html>

