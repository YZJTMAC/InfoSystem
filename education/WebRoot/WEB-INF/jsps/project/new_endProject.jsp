<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/new_endProject.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
$(document).ready(function(e) {
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
<title>关闭项目</title>
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
					<li><a href="ssadmin.html">培训项目</a></li>
		
					<li>培训项目关闭</li>
				</ul>
		</div>

		<div class="formbody">
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
		            <div class="vocation">   <select  class="select3 yearpicker" name="yearpicker" id="endDate">
		            	<option value="">请选择</option>
		            </select>  
					 </div> 
		          </li>
					
				 
		           <li><a href="#" class="dian3" onclick="projectList();">查 询</a></li>
		           
		        </ul>
				
			   
		    </div>
		
			<table class="tablelist">
						<thead>
							<tr>
								<th  >项目名称</th>
								<th  >开始时间</th>
							 	<th  >结束时间</th>
		                        <th  >计划人数</th>
		                        <th  >报名人数</th>
		                        <th  >项目性质</th>
								<th  >操作</th>
							</tr>
						</thead>
		                
						<tbody id="proList1">
							<tr>
								<td>学习培训计划</td>
								<td>2016-4-1</td>
								<td>2017-4-1</td>
								<td>3456</td>
		                        <td>4345</td>
		                        <td>校本培训</td>
								<td><a href="#" class="tablelink huibtn_a click">启动</a></td>
							</tr>
		
							<tr>
							  <td>学习培训计划</td>
							  <td>2016-4-1</td>
							  <td>2017-4-1</td>
							  <td>3456</td>
							  <td>4345</td>
							  <td>校本培训</td>
								<td><a href="#" class="tablelink huibtn_a click">启动</a></td>
							</tr>
		
					</tbody>
					</table>
		 <!-- 分页 -->
					<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
					<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
					<div id="pagebar" class="pagin"></div>
		<!-- 分页 --> 
		</div>
		
		<div class="tip" id="tip">
    		<div class="tiptop"><span id="proName">项目名称：XXXXX培训项目</span><a href="javascript:hideMe();"></a></div>
        	<p class="xmTool">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>提示：当所有承培机构都[准备就绪]时才可以启动项目</b> </p>  
      		<table class="tablelist" style=" width:440px;margin:20px;">
				<thead>
					<tr>
						<th>承培机构</th>
						<th>准备状态</th>
					</tr>
				</thead>
                
				<tbody id="orgStatus">
					<tr>
						<td>果实网&nbsp;</td>
						<td>准备就绪&nbsp;</td>
					</tr>

					<tr>
					  <td>教师网&nbsp;</td>
					  <td>未准备就绪&nbsp;</td>
					</tr>
				</tbody>
			</table>
	        <table width="230" style="margin:0 auto;">
	        	<tr>
				  <td width="130"><a href="javascript:start()" class="sure dian3"/>启动项目</a></td>
                     <td width="15">&nbsp;</td>
				  <td width="130"><a href="javascript:hideMe();" class="sure dian3"/>取消</a></td>
				</tr>
	        </table>
     </div>
</div>	
</body>
</html>