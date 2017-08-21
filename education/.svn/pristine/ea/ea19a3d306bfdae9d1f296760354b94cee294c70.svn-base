<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>教师报名审核</title>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/proListForAudit.js"></script>
</head>
<body>
	<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp" >
			<jsp:param value="project" name="flag"/>
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
			    <li><a href="#">教师报名管理</a></li>
			    <li><a href="#">教师报名审核</a></li>
			    <li>操作提示： 点击审核按钮可以选择相应学员进行审核，审核完成后点击结束报名便于后续启动当前项目</li>
		    </ul>
	    </div>
	    
	    <div class="formbody">
			<div class="itab">
				<ul>
					<li>
						<a onclick="change(1);" id="tab_1" href="javascript:void(0);" class="selected">待审核
						</a>
					</li>
					<li>
						<a onclick="change(2);" id="tab_2" href="javascript:void(0);">审核完成
						</a>
					</li>
				</ul>
			</div>
	
	      	<!-- 待审核 -->
			<div id="tab1" class="tabson">
				<div class="tabson">
			      	<ul class="seachform">
			     		<li>
				            <label>项目名称：</label>
				            <input name="input" type="text" class="scinput" id="projectName"/>
			          	</li>
			    		<li>
			            	<label>项目年度：</label>
			             	<div class="vocation"><select  class="select3 yearpicker" name="yearpicker" id="beginDate">
			             		<option value="">请选择</option>
			             	</select> -- 
						 	</div>
			          	</li>
					  	<li>--</li>
					   	<li>
			            	<div class="vocation"><select  class="select3 yearpicker" name="yearpicker" id="endDate">
			             		<option value="">请选择</option>
			             	</select>  
						 	</div> 
			          	</li>
			 	 		<li>
				        	<a href="javascript:queryProject(1)" class="dian3" >查 询</a>
				        </li>
			        </ul>
			    </div>
			    
			    <table class="tablelist">
				      <thead>
				        <tr>
				          <th width="35%">项目名称</th>
				          <th >开始时间</th>
				          <th >结束时间</th>
				          <th >创建人</th>
				          <th >计划人数</th>
				          <th >申报人</th>
				          <th >审核通过人数</th>
				          <th >审核未通过人数</th>
				          <th >未审核人数</th>
				          <th >操作</th>
				        </tr>
				      </thead>
				      <tbody id="table_list_1">
				      </tbody>
			    </table>
			</div>
	      
	      	<!-- 审核完成 -->
			<div id="tab2" class="tabson" style="display: none;">
				<div class="tabson">
			      	<ul class="seachform">
			     		<li>
				            <label>项目名称：</label>
				            <input name="input" type="text" class="scinput" id="projectName2"/>
			          	</li>
			    		<li>
			            	<label>项目年度：</label>
			             	<div class="vocation"><select  class="select3 yearpicker" name="yearpicker" id="beginDate2">
			             		<option value="">请选择</option>
			             	</select> -- 
						 	</div>
			          	</li>
					  	<li>--</li>
					   	<li>
			            	<div class="vocation"><select  class="select3 yearpicker" name="yearpicker" id="endDate2">
			             		<option value="">请选择</option>
			            	</select>  
						 	</div> 
			          	</li>
			 	 		<li>
				        	<a href="javascript:queryProject(2)" class="dian3" >查 询</a>
				        </li>
			        </ul>
			    </div>
			    
			    <table class="tablelist">
				      <thead>
				        <tr>
				          <th width="35%">项目名称</th>
				          <th >开始时间</th>
				          <th >结束时间</th>
				          <th >创建人</th>
				          <th >计划人数</th>
				          <th >申报人</th>
				          <th >审核通过人数</th>
				          <th >审核未通过人数</th>
				          <th >未审核人数</th>
				          <th >操作</th>
				        </tr>
				      </thead>
				      <tbody id="table_list_2"></tbody>
			    </table>
			</div>
				
			<!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
			<!-- 分页 -->
	    </div>
	</div>
</body>
</html>